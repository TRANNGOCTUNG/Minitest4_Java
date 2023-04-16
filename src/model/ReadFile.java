package model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadFile<T> {
   public T readData(String fileName){
       T data = null;
       try {
           FileInputStream fis = new FileInputStream(fileName);
           ObjectInputStream ois = new ObjectInputStream(fis);
           data =(T)ois.readObject();
           ois.close();
       } catch (IOException | ClassNotFoundException e) {
           e.printStackTrace();
       }
       return data;
    }
}
