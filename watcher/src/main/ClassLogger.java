package main;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class ClassLogger implements ClassFileTransformer
{
    @Override
    public byte[] transform(ClassLoader loader, String className, Class< ? > classBeingRedefined, ProtectionDomain protectionDomain,
            byte[] classfileBuffer) throws IllegalClassFormatException
    {
        try
        {

        }
        catch (Throwable ignored)
        { // ignored, don’t do this at home kids
        }
        finally
        {
            return classfileBuffer;
        }
    }
}