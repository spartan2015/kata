package com.exercise.statements;

import com.exercise.statements.model.Action;
import com.exercise.statements.model.NamedObject;
import com.exercise.statements.model.Person;
import com.exercise.statements.model.Thing;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        Person p1 = new Person("p1");
        Action a1 = new Action("a1");
        Thing t1 = new Thing("t1");
        List<List<NamedObject>> result = StatementsGenerator.produceStatements(
                Arrays.asList(p1, a1, t1,
                        new Person("p2"),
                        new Action("a2"),
                        new Thing("t2"),
                        new Person("p3"),
                        new Action("a3"),
                        new Thing("t3")
                ),
        Rules.getRules(), 50, new Random().nextInt(5));
        StatementsPrinter.print(result);
    }
}
