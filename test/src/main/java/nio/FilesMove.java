package nio;

import org.junit.Test;

import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 * Created by Battlestar on 2/3/2015.
 */
public class FilesMove {

    @Test
    public void t() throws Exception{

        Files.move(null,null, StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING);

/*
        public enum StandardCopyOption implements CopyOption {
            /**
             * Replace an existing file if it exists.
             */
            //REPLACE_EXISTING,
            /**
             * Copy attributes to the new file.
             */
            //COPY_ATTRIBUTES,
            /**
             * Move the file as an atomic file system operation.
             */
            //ATOMIC_MOVE;
      //  }

    }
}
