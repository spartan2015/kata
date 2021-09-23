package com.exercise.statements.model;

import java.util.List;

public class Context {
    private NamedObject namedObject;
    private List<NamedObject> statement;

    public Context(NamedObject namedObject, List<NamedObject> statement) {
        this.namedObject = namedObject;
        this.statement = statement;
    }

    public NamedObject getNamedObject() {
        return namedObject;
    }

    public void setNamedObject(NamedObject namedObject) {
        this.namedObject = namedObject;
    }

    public List<NamedObject> getStatement() {
        return statement;
    }

    public void setStatement(List<NamedObject> statement) {
        this.statement = statement;
    }
}
