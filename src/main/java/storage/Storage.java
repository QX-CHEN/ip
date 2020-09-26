package storage;

import data.TaskList;
import tasks.Deadline;
import tasks.Event;
import tasks.Todo;
import ui.Ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Storage class handles loading of data from file and saving of data to file.
 */
public class Storage {
    private static final String DIRECTORY_NAME = "data";
    private static final String FILE_NAME = "Duke.txt";

    /**
     * Write to file the latest data of tasks.
     *
     * @param tasks latest TaskList object after modification.
     */
    public static void updateFile(TaskList tasks) {
        try {
            writeTasksToFile(tasks);
        } catch (IOException e) {
            Ui.printMessageWithNewLine("Check file path!");
        }
    }

    private static void writeTasksToFile(TaskList tasks) throws IOException {
        FileWriter file = new FileWriter(DIRECTORY_NAME + "/" + FILE_NAME);
        for (int i = 0; tasks.size() > i; i++) {
            file.write(tasks.get(i).getCode() + "|" + (tasks.get(i).isDone() ? "1" : "0") + "|" +
                    tasks.get(i).getDescription() + "|" + tasks.get(i).getDatetime() + System.lineSeparator());
        }
        file.close();
    }

    /**
     * Load data from file and add tasks to TaskList.
     *
     * @param tasks empty TaskList.
     */
    public static void loadTasks(TaskList tasks) {
        if (!createDirectory()) {
            try {
                readTasksFromFile(tasks);
            } catch (FileNotFoundException e) {
                Ui.printMessageWithNewLine("File not found!");
            }
        }
    }

    private static boolean createDirectory() {
        File directory = new File(DIRECTORY_NAME);
        boolean directoryCreated = false;
        try {
            if (!directory.exists()) {
                directoryCreated = directory.mkdir();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return directoryCreated;
    }

    private static void readTasksFromFile(TaskList tasks) throws FileNotFoundException {
        File file = new File(DIRECTORY_NAME + "/" + FILE_NAME);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            processLine(tasks, scanner.nextLine());
        }
    }

    private static void processLine(TaskList tasks, String line) {
        String[] parts = line.split("\\|");
        boolean done = ("1".equals(parts[1]));
        switch (parts[0]) {
        case "T":
            String todoDescription = parts[2];
            tasks.add(new Todo(done, todoDescription));
            break;
        case "E":
            String eventDescription = parts[2];
            String eventDate = parts[3];
            String eventTime = parts[4];
            tasks.add(new Event(done, eventDescription, eventDate, eventTime));
            break;
        case "D":
            String deadlineDescription = parts[2];
            String deadlineDate = parts[3];
            String deadlineTime = parts[4];
            tasks.add(new Deadline(done, deadlineDescription, deadlineDate, deadlineTime));
            break;
        default:
            break;
        }
    }
}
