package utility;


import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import data.StudyGroup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;
import java.lang.*;

public class FileManager {

        private Gson gson = new Gson();
        private String envVariable;

        public FileManager(String envVariable) {
            this.envVariable = envVariable;
        }

    /**
     * If the environment variable is not null, then create a new file writer and write the collection to the file
     *
     * @param collection The collection to be written to the file.
     */
    public void writeCollection(Collection<?> collection) {
        //if (System.getenv().get(envVariable) != null) {
        if (envVariable != null) {
            try (FileWriter collectionFileWriter = new FileWriter(new File(envVariable))) {
                collectionFileWriter.write(gson.toJson(collection));
                Console.println("Collection successfully saved to file!");
            } catch (IOException exception) {
                Console.printerror("The download file is a directory/cannot be opened!");
            }
        } else Console.printerror("Boot file system variable not found!");
    }


    /**
     * It reads the collection from the file specified by the system variable
     *
     * @return An ArrayDeque of StudyGroup objects.
     */
    public ArrayDeque<StudyGroup> readCollection() {
        if (envVariable != null) {
            try (Scanner collectionFileScanner = new Scanner(new File(envVariable))) {
                ArrayDeque<StudyGroup> collection;
                Type collectionType = new TypeToken<ArrayDeque<StudyGroup>>() {}.getType();
                collection = gson.fromJson(collectionFileScanner.nextLine().trim(), collectionType);
                Console.println("Collection successfully uploaded!");
                return collection;
            } catch (FileNotFoundException exception) {
                Console.printerror("Boot file not found!");
            } catch (NoSuchElementException exception) {
                Console.printerror("Boot file is empty!");
            } catch (JsonParseException | NullPointerException exception) {
                Console.printerror("The required collection was not found in the download file!");
            } catch (IllegalStateException exception) {
                Console.printerror("Unexpected error!");
                System.exit(0);
            }
        } else Console.printerror("Boot file system variable not found!");
        return new ArrayDeque<StudyGroup>();
    }


    /**
     * This function returns a string that describes the class
     *
     * @return The toString() method is being returned.
     */
    @Override
    public String toString() {
        String string = "FileManager (class for working with the boot file)";
        return string;
    }
}