import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CheckTask {
  public void checkTask(String fileName, String[] args) {
    if (args.length < 2) {
      System.out.println("Unable to check: no index provided");
    }
    int index;
    try {
      index = Integer.parseInt(args[1]);
    } catch (NumberFormatException e) {
      System.out.println("Unable to check: index is not a number");
    }
    try {
      Path filePath = Paths.get("./" + fileName);
      List<String> lines = Files.readAllLines(filePath);
      int index1 = Integer.parseInt(args[1]);
      if (index1 > lines.size()) {
        System.out.println("Unable to check: index is out of bound");
      } else {
        for (int i = 0; i < lines.size() ; i++) {
          if (i == (index1 - 1)) {
            String checked ="[x] " + lines.get(i);
            lines.set(i, checked);
          }
          Files.write(filePath, lines);
        }
      }
    } catch (Exception e) {
      System.out.println("Uh oh, could not read the file");
    }
  }
}
