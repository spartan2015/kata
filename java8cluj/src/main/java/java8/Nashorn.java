package java8;

import org.junit.Test;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 9.1. Develop Javascript code that creates and uses Java members such as Java objects, methods, JavaBeans, Arrays, Collections, Interfaces.
 9.2. Develop code that evaluates JavaScript in java, passes Java object to JavaScript, inovkes JavaScript function and call methods on JavaScript objects.
 */
public class Nashorn {

    @Test
    public void t(){
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine engine = scriptEngineManager.getEngineByName("nashorn");

        try {

            Object result = engine.eval("'Hello'.length");
            System.out.println(result);
        } catch (ScriptException e) {
            e.printStackTrace();
        }

    }

    private ScriptEngine getNashorn(){
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine engine = scriptEngineManager.getEngineByName("nashorn");
        return engine;
    }

    @Test
    public void makeObjectAccessible(){
        ScriptEngine engine = getNashorn();
        engine.put("key","value");

        try {
            System.out.println(engine.eval("key"));
        } catch (ScriptException e) {
            e.printStackTrace();
        }

        Bindings scope = engine.createBindings();
        scope.put("key","value");

        try {
            System.out.println(engine.eval("key", scope));
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void choosingFromOverloadedMethods() throws ScriptException{
        ScriptEngine engine = getNashorn();

        Object result = engine.eval("" +
                "var list = new java.util.ArrayList();" +
                "list.add(1); list.add(2); list.add(3);" +
                "list['remove(int)'](2); " +
                "list['remove(Object)'](3);" +
                "list;");

        System.out.println(result);
    }

    @Test
    public void accessingOtherJavaClasses() throws ScriptException{
        ScriptEngine engine = getNashorn();

        /**
         * Available variables for packages - implicit object you can access to go to other packages or classes:
         *
         * java
         * javax
         * javafx
         * com
         * org
         * edu
         */
        if (false)engine.eval("var package = java.net; " +
                "var clazz = java.net.URL; " +
                "/*var otherClasses = Package.com.java8.Nashorn; */" +
                "var other = Java.type('java.net.URL');" +
                "var innerClass = new java.util.AbstractMap.SimpleEntry('hello',42);" +
                "var secondInner = new (Java.type('java.util.AbstractMap$SimpleEntry'));");

        engine.eval("var intsClass = Java.type('int[]'); " +
                "var ints = new intsClass(10);" +
                "var stringsClass = Java.type('java.lang.String[]');" +
                "var strings = new stringsClass(11);" +
                "strings[0]='a';" +
                "strings[1]='b';" +
                "for each (var element in strings) print(element);" +
                "for (var index in strings) print(index);");

        engine.eval("" +
                "/*convert a JavaScript array to a java array*/" +
                "var names = ['a','b','c']; " +
                "var javaNames=Java.to(names, Java.type('java.lang.String[]'));" +
                "/*convert a java array to a javascript */" +
                "var jsNames = Java.from(javaNames);" +
                "" +
                "/*resolving ambiguities*/" +
                "java.lang.Arrays.toString(Java.to([1,2,3], Java.type('int[]')));" +
                "java.lang.Arrays.toString(Java.to([1,2,3], 'int[]'));" +
                "");

        engine.eval("" +
                "var names = java.util.Arrays.asList('a','b','c');" +
                "var first = names[0];" +
                "print(first);" +
                "var map = new java.util.HashMap;" +
                "map['a']='b';" +
                "for(var key in map) print(key + ' = ' + map[key]);" +
                "for each(var value in map) print(value);" +
                "for each(var entry in map.entrySet()) print(entry.key + ' <=> ' + entry.value);" +
                "");

        // lambdas
        engine.eval("" +
                "var f = function(x){ return x * 10;};" +
                "print( f(10) );" +
                "" +
                "var names = ['c','b','a'];" +
                "java.util.Arrays.sort(names, function(a,b){ return a.compareTo(b);});" +
                "for each(var name in names) print(name)");

        engine.eval("" +
                "var implementorClass = Java.extend(java.util.Comparator,{" +
                "compare : function(a,b){return a.compareTo(b);" +
                "}});" +
                "var subClass = Java.extend(implementorClass,{newCompare : function(a){return a+a;}});" +
                "print('subClass = ' + subClass);\n" +
                "var names = ['c','b','a'];\n" +
                "var compar = Java.type('java.util.Comparator'); print('compar' + compar)\n" +
                "java.util.Arrays.sort(Java.to(names,'java.lang.String[]'),\n" +
                "new implementorClass);" +
                "print(names);"+
                "");

        engine.eval("var comparable = new java.util.Comparator{" + // NOTE the missing () - diff from java
                "compare: function(a,b){return a.compareTo(b);}" +
                "};" +
                "" +
                "var task = new java.lang.Runnable(function(){print('runnable !!!');});" + // interesting NOTATION
                "print(task.run());" +
                "print(comparable);");

        // invoking super
        engine.eval("var sub = new (Java.extend(java.util.ArrayList)){\n" + // NOTE THAT WE USE AN ANNONYMOUS
                "add : function(obj){\n" +
                "   print('adding obj then super ' + obj);\n " +
                "   return Java.super(sub).add(obj); \n" +
                "   }\n" +
                "};\n" +
                "" +
                "var list =sub;" +
                "list.add('a');" +
                "list.add('b');" +
                "list.add('c');" +
                "");

        // executing shell commands
        engine.eval("var vals = `dir`;" +
                "for(var val : vals) print(val);");
    }
}
