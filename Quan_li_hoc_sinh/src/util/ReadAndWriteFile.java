package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
  public void writeToFile(String FILE_PATH, List<String> stringList, boolean append) {
    File file = new File(FILE_PATH);
    try {
      FileWriter fileWriter = new FileWriter(file, append);
      BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
      for (String o: stringList) {
        bufferedWriter.write(o);
        bufferedWriter.newLine();
      }
      bufferedWriter.close();
      fileWriter.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public List<String> readFromFile(String FILE_PATH) {
    List<String> stringList = new ArrayList<>();
    try {
      FileReader fileReader = new FileReader(FILE_PATH);
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      String line = "";
      while ((line = bufferedReader.readLine()) != null) {
        stringList.add(line);
      }
      bufferedReader.close();
      fileReader.close();
    } catch (Exception e) {
      e.getMessage();
    }
    return stringList;
  }
}
