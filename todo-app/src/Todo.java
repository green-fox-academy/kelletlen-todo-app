import java.io.BufferedWriter;
import java.io.FileWriter;
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
      try {
        Path filePath = Paths.get("./file.txt");
        List<String> lines = Files.readAllLines(filePath);
        if (lines.size() > 0) {
          for (int i = 0; i < lines.size(); i++) {
            System.out.println((i + 1 + ". ") + lines.get(i));
          }
        } else {
          System.out.println("No todos for today! :)");
        }
      } catch (Exception e) {
        System.out.println("Not today, buddy :(");
      }
    } else if (args[0].equals("-a")) {
      if (args.length < 2) {
        System.out.println("Unable to add: no task provided");
      } else {
        try {
          FileWriter fstream = new FileWriter("file.txt",true);
          BufferedWriter out = new BufferedWriter(fstream);
          out.write("\n" + args[1]);
          out.close();
        } catch (Exception e) {
          System.out.println("Not today, buddy :(");
        }
      }
    }
  }
}
