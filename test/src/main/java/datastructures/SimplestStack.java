package datastructures;

import org.junit.Test;
import sedgewick.StdOut;

import java.util.Iterator;
import java.util.concurrent.Callable;

import static org.junit.Assert.assertEquals;
import static testing.AssertionUtils.*;

/**
 * Created by Battlestar on 2/8/2015.
 */
public class SimplestStack<T> implements Iterable<T>{

    @Test
    public void test(){
        final SimplestStack<String> ss = new SimplestStack<>(2);
        assertException(()->{ss.pop();}, RuntimeException.class);
        ss.push("1");
        ss.push("2");

        assertEquals("2",ss.pop());
        assertEquals("1", ss.pop());

        assertException(()->{ss.pop();}, RuntimeException.class);

        for(int i =0; i < 100; i++){
            ss.push(String.valueOf(i));
        }

        for(String s : ss){
            StdOut.print(s);
        }

        for(int i =0; i < 100; i++){
            ss.pop();
        }
    }

    public SimplestStack(){}
    int n;
    Object[] stack;
    SimplestStack(int capacity){
        stack = new Object[capacity];
    }

    public void push(T s){
        if (n+1 > stack.length){
            resize(stack.length * 2);
        }
        stack[n++] = s;
    }

    public T pop(){
        if (n > 0){
            T item = (T)stack[n-1];
            stack[n-1] = null;
            n--;
            if (stack.length/4 > n){
                resize(stack.length/2);
            }
            return item;
        }else{
            throw new RuntimeException("stack is empty");
        }
    }

    public void resize(int n){
        if (n > stack.length){
            Object[] newStack = new Object[n];
            for(int i =0; i< stack.length ; i++){
                newStack[i]=stack[i];
            }
            stack = newStack;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>(){
            int position = n-1;
            @Override
            public boolean hasNext() {
                return position >= 0;
            }

            @Override
            public T next() {
                return (T)stack[position--];
            }
        };
    }
}
