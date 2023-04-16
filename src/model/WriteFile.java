package model;

import java.io.*;

public class WriteFile<T> {
   public void writeData(String fileName,T data){
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
