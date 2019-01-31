
package enigma.core;

import java.awt.*;
import java.io.*;
import java.lang.reflect.*;
import java.security.*;
import java.util.*;
import java.util.List;
import java.util.regex.*;
import javax.swing.*;
import enigma.core.windows.*;
import enigma.console.*;
import enigma.console.Console;
import enigma.console.java2d.*;
import enigma.util.*;

public class Enigma
{
	// ekranýn koordinatlarýný ayarladýðýn kýsým 55. satýrda
    private static final Permission SET_ENVIRONMENT_PERMISSION = new RuntimePermission("enigma.core.Enigma.setEnvironment");
    private static final Permission INSTALL_CONSOLE_PERMISSION = new RuntimePermission("enigma.core.Enigma.installConsole");
    
    private static Properties properties;
    private static Environment environment;
    private static Console console;
    private static Random random = new Random();
    
    // non-instantiable
    private Enigma()
    {
    	
    }
    
    public static Environment getEnvironment()
    {
        if (environment == null)
            environment = new WindowsEnvironmentImpl();
        return environment;
    }
    
    public static void setEnvironment(Environment environment) throws SecurityException
    {
        if (System.getSecurityManager() != null)
            System.getSecurityManager().checkPermission(SET_ENVIRONMENT_PERMISSION);
        Enigma.environment = environment;
    }
    
    public static Console getConsole()
    {    
        return getConsole(null);
    }
    
    public static TextWindow createTextWindow(String title)
    {
        final Java2DTextWindow textPane = new Java2DTextWindow(168, 38, 50);
        final JFrame f = new JFrame(title != null ? title : Util.msg(Enigma.class, "default.console.title"));
        f.setLocation(random.nextInt(100), random.nextInt(100));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JScrollPane scrollPane = new JScrollPane(textPane);
        f.getContentPane().add(scrollPane);
        SwingUtilities.invokeLater(new Runnable()
        {
            @SuppressWarnings("deprecation")
			public void run()
            {
                f.pack(); // force peer to be created so that insets are known
                f.setSize(f.getPreferredSize());
                f.show();
                // workaround for 1.3.1: requestFocus not working unless run in another invokeLater
                SwingUtilities.invokeLater(new Runnable()
                {
                    public void run()
                    {
                        textPane.requestFocus();
                    }
                });
            }
        });
        return textPane;
    }
    
    public static Console getConsole(final String title)
    {
        // need to be able to use DISPOSE_ON_CLOSE and have better notification of
        // window close
        if (console == null)
        {
            Object doPrivileged2 = AccessController.doPrivileged(new PrivilegedAction()
            {
                public Object run()
                {
                    installConsole(new DefaultConsoleImpl(createTextWindow(title)));
                    return null;
                }
            });
			Object doPrivileged = doPrivileged2;
        }
        else if (title != null)
            console.setTitle(title);
        return console;
    }
    
    public static void installConsole(Console console)
    {
        if (System.getSecurityManager() != null)
            System.getSecurityManager().checkPermission(INSTALL_CONSOLE_PERMISSION);
        Enigma.console = console;
        System.setIn(console.getInputStream());
        System.setOut(console.getOutputStream());
        System.setErr(console.getOutputStream());
    }
    
    public static boolean isFileSystemCaseSensitive(File path)
    {
        return false;
    }
    
    public static File resolvePath(String path)
    {
        if (path.length() == 2 && path.charAt(1) == ':')
            path += "\\";
        File file = new File(path);
        if (file.isAbsolute() || path.startsWith(File.separator))
            return file;
        return new File(getEnvironment().getCurrentPath(), path);
    }
    
    private static boolean checked14;
    private static boolean is14;
    
    private static void check14()
    {
        if (!checked14) {
            checked14 = true;
            StringTokenizer st = new StringTokenizer(System.getProperty("java.specification.version"), ".");
            try
            {
                int major = Integer.parseInt(st.nextToken());
                int minor = Integer.parseInt(st.nextToken());
                is14 = major > 1 || (major == 1 && minor >= 4);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        
        if (!is14)
            throw new UnsupportedOperationException("this operation requires Java 1.4 or higher");
    }
    
    public static File[] expandWildcards(String path)
    {
        check14();
        // use reflection to access method to avoid getting an error in 1.3
        // during classloading
        try
        {
            Class<Java14Utilities> utils = Java14Utilities.class;
            Method expandWildcards = utils.getMethod("expandWildcards", new Class[] { String.class });
            return (File[]) expandWildcards.invoke(null, new Object[] { path });
        }
        catch (Exception e)
        {
            throw new Error(e);
        }
    }
    
    public static VirtualMachine createVirtualMachine(VirtualMachineConfiguration cfg) throws VirtualMachineInstantiationException, SecurityException
    {
        try
        {
            File java = new File(System.getProperty("java.home"), "bin" + File.separator + "java");
            String program;
            if (cfg.getMainClassName() != null)
            {
                program = cfg.getMainClassName();
            }
            else if (cfg.getJarFile() != null)
            {
                program = "-jar " + cfg.getJarFile();
            }
            else
                throw new IllegalArgumentException("main class or jar file must be defined");
            
            String[] args = cfg.getArguments();
            StringBuffer argString = new StringBuffer();
            if (args != null)
                for (int i = 0; i < args.length; i++)
                {
                    argString.append(' ');
                    argString.append(args[i]);
                }
            
            StringBuffer javaArgs = new StringBuffer();
            
            File[] classPath = cfg.getClassPath();
            if (classPath != null && classPath.length > 0)
            {
                javaArgs.append("-cp");
                for (int i = 0; i < classPath.length; i++)
                {
                    javaArgs.append(' ');
                    javaArgs.append(classPath[i]);
                }
            }
            
            final Process p = Runtime.getRuntime().exec(java + " " + javaArgs + " " + program + " " + argString);
            return new VirtualMachine()
            {
                public InputStream getInputStream()
                {
                    return p.getInputStream();
                }
                
                public InputStream getErrorStream()
                {
                    return p.getErrorStream();
                }

                public OutputStream getOutputStream()
                {
                    return p.getOutputStream();
                }
                
                public void waitFor() throws InterruptedException
                {
                    p.waitFor();
                }
                
                public void destroy()
                {
                    p.destroy();
                }
            };
        }
        catch (Exception e)
        {
            throw new VirtualMachineInstantiationException(e.toString());
        }            
    }
    
    public static String getSystemProperty(String key)
    {
        if (properties == null)
        {
            try
            {
                properties = new Properties();
                properties.load(Enigma.class.getResourceAsStream("resources/properties/defaults.properties"));
            }
            catch (IOException e)
            {
                throw new RuntimeException(e.toString());
            }
        }
        return properties.getProperty(key);
    }
    
    private static TextAttributes parseTextAttributes(String value)
    {
        StringTokenizer st = new StringTokenizer(value, ", \t");
        int tokens = st.countTokens();
        if (tokens != 3 && tokens != 6)
            throw new IllegalArgumentException("expected three or six comma-separated numbers, got '" + value + "'");
        Color foreground = new Color(Integer.parseInt(st.nextToken()),
                                     Integer.parseInt(st.nextToken()),
                                     Integer.parseInt(st.nextToken()));
        Color background;
        if (tokens == 6)
            background = new Color(Integer.parseInt(st.nextToken()),
                                   Integer.parseInt(st.nextToken()),
                                   Integer.parseInt(st.nextToken()));
        else
            background = getSystemTextAttributes("attributes.console.default").getBackground();
        return new TextAttributes(foreground, background);
    }
    
    public static TextAttributes getSystemTextAttributes(String key)
    {
        return parseTextAttributes(getSystemProperty(key));
    }
    
    public static class Java14Utilities
    {
        public static File[] expandWildcards(String path)
        {
            if (path.indexOf("*") != -1 || path.indexOf("?") != -1)
            {
                String parent;
                String pattern = path;
                if (path.indexOf(File.separator) != -1)
                {
                    parent = path.substring(0, path.lastIndexOf(File.separator));
                    pattern = path.substring(path.lastIndexOf(File.separator) + 1);
                }
                else
                    parent = getEnvironment().getCurrentPath().getPath();
                File parentFile = resolvePath(parent);
                File[] files = parentFile.listFiles();
                if (files == null)
                    return new File[0];
    
                boolean caseSensitive = isFileSystemCaseSensitive(parentFile);
                if (!caseSensitive)
                    pattern = pattern.toLowerCase();
                pattern = pattern.replaceAll("([\\.\\\\])", "\\\\$1").replaceAll("\\*", ".*").replaceAll("\\?", ".");
                Matcher matcher = Pattern.compile(pattern).matcher("");
                List result = new ArrayList();
                for (int i = 0; i < files.length; i++)
                {
                    String name = files[i].getName();
                    if (!caseSensitive)
                        name = name.toLowerCase();
                    matcher.reset(name);
                    if (matcher.matches())
                        result.add(files[i]);
                }
                return (File[]) result.toArray(new File[result.size()]);
            }
            else
            { // no wildcard characters in path
                File file = resolvePath(path);
                if (file.exists())
                    return new File[] { file };
                else
                    return new File[0];
            }
        }
    }
}


