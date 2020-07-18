import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class RemoveTask {
  public void removeTask(String fileName, String[] args) {
    if (args.length < 2) {
      System.out.println("Unable to remove: no index provided");
    }
    int index;
    try {
      index = Integer.parseInt(args[1]);
    } catch (NumberFormatException e) {
      System.out.println("Unable to remove: index is not a number");
    }
    try {
      Path filePath = Paths.get("./" + fileName);
      List<String> lines = Files.readAllLines(filePath);

      int index1 = Integer.parseInt(args[1]);
      if (index1 > lines.size()) {
        System.out.println("Unable to remove: index is out of bound");
      } else {
        Path filePath2 = Paths.get("./tempFile.txt");
        List<String> content = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
          if (i != (index1 - 1)) {
            content.add(lines.get(i));
          }
        }
        Files.write(filePath2, content);
        Files.delete(filePath);
        Files.move(filePath2, filePath2.resolveSibling("file.txt"));
      }
    } catch (Exception e) {
      System.out.println("Uh oh, could not read the file");
    }
  }
}
/*1.make tempFile x
 * 2.open oldFile x
 * 3.iterate trough oldFile's lines x
 * 4.copy every line that's not the index's line to tempFile x
 * 5. delete oldFile x
 * 6. rename tempFile to oldFile X  */

