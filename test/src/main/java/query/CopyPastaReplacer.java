package query;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class CopyPastaReplacer {
	@Test
	public void multiReplace() throws Exception {
		Files.readAllLines(new File(CounterQueryParams.class.getResource("fields.txt").getFile()).toPath()).stream()
				.forEach(s -> System.out.println(String.format("ALTER TABLE V0BRMUSR DROP COLUMN %s;", s)));

	}

	@Test
	public void replaceWithCapturing() throws Exception{
		Pattern regex = Pattern.compile("([^=\\s]+)\\s*=(.+)");
		Files.readAllLines(new File(CounterQueryParams.class.getResource("replace.txt").getFile()).toPath()).stream()
		.forEach(s -> {
			if (s.length() == 0) return ;
			String resultString = null;
			Matcher regexMatcher = regex.matcher(s);
			try {
				while(regexMatcher.find()) {
					//String replacement = "$1=@$1@";
					String replacement = "<replacefilter token=\"@$1@\" value=\"\\${$1}\"/>";
					resultString = regexMatcher.replaceAll(replacement);
				}
			} catch (Exception e) {
			    e.printStackTrace();
			}
			
			System.out.println(resultString);
		});
	}
}
