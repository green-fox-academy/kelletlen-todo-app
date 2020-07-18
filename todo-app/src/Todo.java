import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Todo {
  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Command Line Todo application\n" +
          "=============================\n" +
          "\n" +
          "Command line arguments:\n" +
          "    -l   Lists all the tasks\n" +
          "    -a   Adds a new task\n" +
          "    -r   Removes an task\n" +
          "    -c   Completes an task");
    } else if (args[0].equals("-l")) {
      ListTasks listTasks1 = new ListTasks();
      listTasks1.listTasks("file.txt", args);
    } else if (args[0].equals("-a")) {
      AddNewTask addNewTask1 = new AddNewTask();
      addNewTask1.addNewTask("file.txt", args);

    } else if (args[0].equals("-r")) {
      RemoveTask removeTask1 = new RemoveTask();
      removeTask1.removeTask("file.txt", args);
    }
  }
}
