package in.lld.parking.sys;

public class Log 
{
    public static void warn(String msg) 
    {
        System.err.println("warn : " + msg);
    }

    public static void info(String msg) 
    {
        System.out.println("info : " + msg);
    }

}
