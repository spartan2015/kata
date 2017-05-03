package java8;

/**
 * Created by Battlestar on 2/17/2015.
 */

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Reading a file to a stream
 * <p>
 * Reading a text file into an ArrayList
 * <p>
 * List walk search a directory structure using stream
 * <p>
 * Read files using lambda improvements: Files.find, lines(), walk()
 */
public class FilesJava8 {

    @Test
    public void linesOfFile()  {


          /*
        public enum FileVisitOption {
            FOLLOW_LINKS;
        }

        Stream<Path> find(Path start,
                                    int maxDepth,
                                    BiPredicate<Path, BasicFileAttributes> matcher,
                                    FileVisitOption... options)
        * */
        try {

            // throws IOException
            Files.find(
                    /*start folder*/ Paths.get("."),
                    /*max depth*/ Integer.MAX_VALUE,
                    /*BiPredicate< Path, BasicFileAttributes >*/ (path, basicFileAttributes) ->  path.getFileName().toString().length() > 0 && basicFileAttributes.isRegularFile(),
                    FileVisitOption.FOLLOW_LINKS /*optional*/)
                    .forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }


        //throws IOException
        /*
         Stream<String> lines(Path path)
         Stream<String> lines(Path path, Charset cs)
        */
        try (Stream<String> lines = Files.lines(Paths.get(""), Charset.forName("UTF-8"))) {

            // words in a file
            Stream<String> theLines = Files.lines(Paths.get(""), Charset.forName("UTF-8"));

            // use the stream - here we also split by space - to count words
            theLines.flatMap(line -> Arrays.stream(line.split(" "))).count();

        } catch (IOException e) {
            e.printStackTrace();
        }


         /*
        public enum FileVisitOption {
            FOLLOW_LINKS;
        }


        Stream<Path> walk(Path start, FileVisitOption... options)
        Stream<Path> walk(Path start,
                                    int maxDepth,
                                    FileVisitOption... options)

        * */
        try {
            // throws IOException
            /*

            * */
            Files.walk(Paths.get(".")).forEach(System.out::println);

            Files.walk(Paths.get("."), FileVisitOption.FOLLOW_LINKS).forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }


        //DirectoryStream
        //Stream<Path> list(Path dir)
        try {

            Files.list(Paths.get(".")).forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
