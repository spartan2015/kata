package com.java_8_training.problems.lambdas;

import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.util.stream.Stream;

import static junit.framework.Assert.assertEquals;

@Ignore
public class WrapUpTest {

	private final File mainDirectory = new File("src/test/resources/wrap_up");

	@Test
	public void hiddenFiles() {
		assertEquals(2, Stream.of(mainDirectory.listFiles()).filter(File::isHidden).count());
	}

	@Test
	public void xmlFiles() {
		// TODO: Find XML files,
		File[] files = null; mainDirectory.listFiles(File::isHidden);
		assertEquals(1, Stream.of(mainDirectory.listFiles()).filter((f) -> f.getName().endsWith("xml")).count());
	}
}
