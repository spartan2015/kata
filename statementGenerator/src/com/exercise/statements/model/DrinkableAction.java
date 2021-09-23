package com.exercise.statements.model;

import com.exercise.statements.StatementsGenerator;

public class DrinkableAction extends Action implements Drinkable {
    public DrinkableAction(String name) {
        super(name);
    }

    public boolean canDo(Thing thing) {
        return thing instanceof Drinkable;
    }
}
