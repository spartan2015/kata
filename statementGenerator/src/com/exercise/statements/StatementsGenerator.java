package com.exercise.statements;

import com.exercise.statements.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Predicate;

public class StatementsGenerator {

    public static List<List<NamedObject>> produceStatements(List<NamedObject> list,
                                                            Map<Integer, Predicate<Context>> stateRules,
                                                            int statementCount, int startIndex) {
        int count = 0;
        List<List<NamedObject>> result = new ArrayList<>();
        List<NamedObject> statement = new ArrayList<>();
        boolean loopEnded = false;
        int loopEndedSize = 0;
        for (int currentIndex = startIndex; count < statementCount;
             currentIndex = Math.abs(new Random().nextInt()) % (list.size()-1)) {
            if (endOfList(list, currentIndex)) {
                if (loopEnded && result.size() == loopEndedSize){
                    return result;
                }
                loopEndedSize = result.size();
                loopEnded = true;
                currentIndex = 0;
            }
            NamedObject currentObject = list.get(currentIndex);
            if (stateRules.get(statement.size()).test(new Context(currentObject, statement))){
                statement.add(currentObject);
            } else {
                continue;
            }

            if (statement.size() == 3) {
                result.add(statement);
                statement = new ArrayList<>();
            }

            if (result.size() == statementCount){
                break;
            }

        }

        return result;
    }

    private static boolean endOfList(List<NamedObject> list, int index) {
        return index > list.size() - 1;
    }

}
