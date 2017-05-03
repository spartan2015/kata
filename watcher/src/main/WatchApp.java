package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class WatchApp
{
    private static Logger LOGGER = Logger.getLogger(WatcherNIO2.class.toGenericString());

    public WatchApp()
    {

    }

    public static void main(String[] args)
    {

        try
        {
            WatcherNIO2 watcher = new WatcherNIO2();

            Map<Path, List<Path>> folderToFolderMap = new HashMap<>();

            BufferedReader br = new BufferedReader(new InputStreamReader(WatchApp.class.getResourceAsStream("folderMap.properties")));
            String line = null;
            while((line = br.readLine()) != null){
                String[] s = line.split("=");
                Path path1 = Paths.get(s[0]);
                Path path2 = Paths.get(s[1]);
                List list = new ArrayList<Path>();
                list.add(path2);
                folderToFolderMap.put(path1, list);
                scanFolder(path1, path2, folderToFolderMap);
            }

            for (Path resource : folderToFolderMap.keySet())
            {

                URI uri = resource.toUri();
                LOGGER.fine("Watching directory '{}' for changes." + uri);
                watcher.addEventListener(null, uri, new WatchEventListener() {
                    @Override
                    public void onEvent(WatchFileEvent event)
                    {
                        try
                        {
                            if (event.isFile())
                            {
                                LOGGER.fine("File '{}' changed and will be returned instead of original classloader equivalent."
                                        + event.getURI().toURL());

                                try
                                {
                                    Path changed = Paths.get(event.getURI());
                                    folderToFolderMap.get(changed.getParent()).stream().forEach(p -> {
                                        Path to = p.resolve(changed.getParent().relativize(changed));

                                        try
                                        {
                                            if (args.length != 0)
                                            {
                                                if (Arrays.asList(args).stream().allMatch(arg -> to.toString().contains(arg)))
                                                {
                                                    System.out.println("cp " + changed + " -> " + to);
                                                    Files.copy(changed, to, StandardCopyOption.REPLACE_EXISTING);
                                                }
                                            }
                                            else
                                            {
                                                System.out.println("cp " + changed + " -> " + to);
                                                Files.copy(changed, to, StandardCopyOption.REPLACE_EXISTING);
                                            }
                                        }
                                        catch (Exception ex)
                                        {
                                            // TODO Auto-generated catch block
                                            ex.printStackTrace();
                                        }
                                    });

                                }
                                catch (Exception ex)
                                {
                                    // TODO Auto-generated catch block
                                    ex.printStackTrace();
                                }
                            }
                        }
                        catch (Exception e)
                        {
                            LOGGER.severe("Unexpected - cannot convert URI {} to URL." + e + event.getURI());
                        }
                    }
                });

            }

            watcher.run();
            // watcher.runner.join();
            System.out.println("WatchApp EXIT");
        }
        catch (Exception e)
        {
            LOGGER.severe("Unable to convert watchResources URL '{}' to URI. URL is skipped.");
            e.printStackTrace();
        }

    }

    static void scanFolder(Path folderToScan, Path destinationFolder, Map<Path, List<Path>> folderToFolderMap)
    {

        try
        {
            Files.walkFileTree(folderToScan, new FileVisitor<Path>() {

                @Override
                public FileVisitResult postVisitDirectory(Path arg0, IOException arg1) throws IOException
                {
                    // TODO Auto-generated method stub
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult preVisitDirectory(Path file, BasicFileAttributes arg1) throws IOException
                {
                    Path resolve = destinationFolder.resolve(folderToScan.relativize(file));
                    System.out.println(file + " = " + resolve);

                    List newList = new ArrayList();
                    newList.add(resolve);
                    folderToFolderMap.merge(file, newList, (o, n) -> {
                        o.addAll(n);
                        return o;
                    });

                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes arg1) throws IOException
                {

                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path arg0, IOException arg1) throws IOException
                {
                    // TODO Auto-generated method stub
                    return FileVisitResult.CONTINUE;
                }
            });
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }

}
