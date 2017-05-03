package main;

import java.lang.instrument.Instrumentation;

public class IuccaAgent
{
    public static void premain(String args, Instrumentation instrumentation)
    {
        System.out.println("AGENT-START: " + args);

        instrumentation.addTransformer(new ClassLogger());
        WatchApp.main(args.split(","));
    }

}
