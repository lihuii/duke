package storage;

import exceptions.InvalidStorageFilePathException;
import taskList.Task;
import taskList.TaskList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.util.List;

public class Storage {
    private static File file;
    public Storage(String filePath) {
    }
    public static File load() throws FileNotFoundException {
        return file;
    }

    public static String homeDirectory(){
        String homeDirectory = System.getProperty("user.home");
        return homeDirectory;
    }
    private static void writeToFile(String filePath, List<Task> taskList) throws IOException {
        // write to file
        FileWriter fw = new FileWriter(filePath);
        for (Task arr : taskList) {
            fw.write(arr.toString() + System.lineSeparator());
        }
        fw.close();
    }

    public static void main(String[] args) throws InvalidStorageFilePathException, IOException {
        // create file to file path assuming all users are storing the duke in the user home directory
        File file = new File(homeDirectory(), "/duke/data/duke.txt");
        File home = new File(homeDirectory());
        if (!home.exists()) {
            throw new InvalidStorageFilePathException();
        }
        else {
            try {
                // write to file
                writeToFile(String.valueOf(file), TaskList.taskList);
            } catch (IOException e) {
                System.out.println("Something went wrong: " + e.getMessage());
            }
        }
    }

    public static void mainCaller() throws InvalidStorageFilePathException, IOException {
        Storage.main(null);
    }

}

