import data.TaskList;
import storage.Storage;
import ui.Ui;


public class Duke {

    private static final TaskList tasks = new TaskList();

    public static void main(String[] args) {
        Storage.loadTasks(tasks);
        Ui.run(tasks);
    }
}
