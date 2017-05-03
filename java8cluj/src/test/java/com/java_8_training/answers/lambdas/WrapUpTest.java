package com.java_8_training.answers.lambdas;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class WrapUpTest {

    private final File mainDirectory = new File("src/test/resources/wrap_up");

    @Test
    public void hiddenFiles() {
        File[] files = mainDirectory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.isHidden();
            }
        });
        assertEquals(2, files.length);
    }

    @Test
    public void xmlFiles() {
        File[] files = mainDirectory.listFiles(f -> f.getName().endsWith(".xml"));
        assertEquals(1, files.length);
    }
}
