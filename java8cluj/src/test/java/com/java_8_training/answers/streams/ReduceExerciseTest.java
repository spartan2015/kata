package com.java_8_training.answers.streams;

import org.junit.Test;

import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ReduceExerciseTest {

    @Test
    public void findMinimumValue() {
        int min = Stream.of(5, 2, 200, 33, 150, 0)
                        .reduce(Integer.MAX_VALUE, Integer::min);

        assertThat(min, is(0));
    }

}
