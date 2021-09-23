package com.exercise.statements;

import com.exercise.statements.model.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class StatementsGeneratorTest {

    @Test
    public void shouldGenerateOneBasicStatement(){
        Person p1 = new Person("p1");
        Action a1 = new Action("a1");
        Thing t1 = new Thing("t1");
        List<List<NamedObject>> result = StatementsGenerator.produceStatements(
                Arrays.asList(p1, a1, t1),
                Rules.getRules(), 1, 0);

        assertEquals("1 result", Integer.valueOf(1), (Integer)result.size());
        assertTrue(result.get(0).get(0) == p1);
        assertTrue(result.get(0).get(1) == a1);
        assertTrue(result.get(0).get(2) == t1);
    }

    @Test
    public void shouldGenerateTwoBasicStatement(){
        Person p1 = new Person("p1");
        Action a1 = new Action("a1");
        Thing t1 = new Thing("t1");
        List<List<NamedObject>> result = StatementsGenerator.produceStatements(
                Arrays.asList(p1, a1, t1),
                Rules.getRules(), 2, 0);

        assertEquals("2 result", Integer.valueOf(2), (Integer)result.size());
        assertTrue(result.get(0).get(0) == p1);
        assertTrue(result.get(0).get(1) == a1);
        assertTrue(result.get(0).get(2) == t1);
        assertTrue(result.get(1).get(0) == p1);
        assertTrue(result.get(1).get(1) == a1);
        assertTrue(result.get(1).get(2) == t1);
    }

    @Test
    public void shouldStartAnyWhere1(){
        Person p1 = new Person("p1");
        Action a1 = new Action("a1");
        Thing t1 = new Thing("t1");
        List<List<NamedObject>> result = StatementsGenerator.produceStatements(
                Arrays.asList(p1, a1, t1),
                Rules.getRules(), 1, 1);

        assertEquals("1 result", Integer.valueOf(1), (Integer)result.size());
        assertTrue(result.get(0).get(0) == p1);
        assertTrue(result.get(0).get(1) == a1);
        assertTrue(result.get(0).get(2) == t1);
    }

    @Test
    public void shouldStartAnyWhere2(){
        Person p1 = new Person("p1");
        Action a1 = new Action("a1");
        Thing t1 = new Thing("t1");
        List<List<NamedObject>> result = StatementsGenerator.produceStatements(
                Arrays.asList(p1, a1, t1),
                Rules.getRules(), 1, 2);

        assertEquals("1 result", Integer.valueOf(1), (Integer)result.size());
        assertTrue(result.get(0).get(0) == p1);
        assertTrue(result.get(0).get(1) == a1);
        assertTrue(result.get(0).get(2) == t1);
    }

    @Test
    public void shouldFollowDrinkableRule(){
        Person p1 = new Person("p1");
        Action a1 = new DrinkableAction("a1");
        Thing t1 = new Thing("t1");
        Thing t2 = new Cola("t2");
        List<List<NamedObject>> result = StatementsGenerator.produceStatements(
                Arrays.asList(p1, a1, t1, t2),
                Rules.getRules(), 1, 2);

        assertEquals("1 result", Integer.valueOf(1), (Integer)result.size());
        assertTrue(result.get(0).get(0) == p1);
        assertTrue(result.get(0).get(1) == a1);
        assertTrue(result.get(0).get(2) == t2);
    }

    @Test
    public void shouldStopIfNoneFound(){
        Person p1 = new Person("p1");
        Action a1 = new DrinkableAction("a1");
        Thing t1 = new Thing("t1");

        List<List<NamedObject>> result = StatementsGenerator.produceStatements(
                Arrays.asList(p1, a1, t1),
                Rules.getRules(), 1, 2);

        assertEquals("0 result", Integer.valueOf(0), (Integer)result.size());
    }
}
