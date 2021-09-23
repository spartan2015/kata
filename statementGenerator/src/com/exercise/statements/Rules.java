package com.exercise.statements;

import com.exercise.statements.model.Action;
import com.exercise.statements.model.Context;
import com.exercise.statements.model.Person;
import com.exercise.statements.model.Thing;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class Rules {

    public static Map<Integer, Predicate<Context>> getRules(){
        Map<Integer, Predicate<Context>> statePredicateMap = new HashMap<>();
        statePredicateMap.put(0, (Context context) -> context.getNamedObject() instanceof Person);
        statePredicateMap.put(1, (Context context) -> context.getNamedObject() instanceof Action);
        statePredicateMap.put(2, (Context context) ->
                (context.getNamedObject() instanceof Thing)
                        && ((Action) context.getStatement().get(1)).canDo((Thing) context.getNamedObject())
        );
        return statePredicateMap;
    }

}
