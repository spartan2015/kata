package com.exercise.statements.model;

public class Action extends NamedObject {
    public Action(String name) {
        super(name);
    }

    public boolean canDo(Thing thing) {
        return true;
    }
}
