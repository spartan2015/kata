package test;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

import org.apache.commons.io.IOUtils;

public class NexusExplore {

	public static void main(String[] args) throws Exception {
		Files.readAllLines(Paths.get(NexusExplore.class.getResource("deps.txt").getPath().substring(1))).stream()
				.map(l -> l.substring(l.lastIndexOf(" ")).split(":")).forEach(ar -> {
					CompletableFuture.runAsync(() -> {
						try {
							String url = "http://53.118.67.78/nexus/content/groups/public/"
									+ ar[0].replace(".", "/").trim() + "/" + ar[1].replace(".", "/").trim() + "/"
									+ ar[3].trim() + "/" + ar[1].replace(".", "/").trim() + "-" + ar[3].trim() + ".pom";
							System.out.println(url);
							String str = IOUtils.toString(new URL(url));
							int r = str.indexOf("redhat");
							if (r >= 0) {

								System.out.println(str);
							}
						} catch (Exception ex) {
							ex.printStackTrace();
							System.out.println(Arrays.toString(ar));
						}
					});

				});

	}
}
