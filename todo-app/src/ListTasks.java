import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ListTasks {
  public void listTasks (String fileName, String[] args) {
    try {
      Path filePath = Paths.get("./" + fileName);
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
  }
}
