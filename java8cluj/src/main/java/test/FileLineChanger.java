package test;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class FileLineChanger {

	public static void main(String[] args) throws Exception {
		Path dir = Paths.get(
				"C:\\IDE_IUCCA_Mars\\Entwicklungsumgebung\\project\\git\\IuccaProject\\Utilities\\IDE-Configs\\dev-config");
		withFiles(dir, file -> {
			try {
				List<String> lines = Files.readAllLines(file);
				PrintWriter pw = new PrintWriter(file.toFile());
				
				lines.forEach(line->{
					pw.println(lineConsumer(line));
				});
				
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	private static void withFiles(Path inDir, Consumer<Path> consumer) throws IOException {
		try (Stream<Path> files = Files.list(inDir)) {
			files.forEach(file -> {
				System.out.println(file.getFileName());
				consumer.accept(file);
			});
		}
	}

	private static String lineConsumer(String line) {
		String newFolder = "git";
		line = line.replace("HEAD/IuccaProject/", newFolder + "/IuccaProject/");
		return line;
	}

}