import java.io.BufferedWriter;
import java.io.FileWriter;

public class AddNewTask {
  public void addNewTask(String fileName, String[] args) {
    if (args.length < 2) {
        System.out.println("Unable to add: no task provided");
      } else {
        try {
          FileWriter fstream = new FileWriter(fileName, true);
          BufferedWriter out = new BufferedWriter(fstream);
          out.write("\n" + args[1]);
          out.close();
        } catch (Exception e) {
          System.out.println("Not today, buddy :(");
        }
    }
  }
}

