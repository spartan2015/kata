package com.exercise.statements;

import com.exercise.statements.model.NamedObject;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class StatementsPrinter {

    public static void print(List<List<NamedObject>> statements) {
        for(List<NamedObject> statement : statements) {
            System.out.println(
                    statement.stream()
                    .map((NamedObject namedObject) -> namedObject.getName())
                    .collect(joining(" "))
            );
        }
    }
}
