package model;

import java.io.*;
import java.util.List;

public class WriteFile<T> {
   public void writeData(List<T> data,String fileName){
       try {
           FileOutputStream fos = new FileOutputStream(fileName);
           ObjectOutputStream oos = new ObjectOutputStream(fos);
           oos.writeObject(data);
           oos.flush();
           oos.close();
       } catch (IOException e){
           e.printStackTrace();
       }
    }
}
