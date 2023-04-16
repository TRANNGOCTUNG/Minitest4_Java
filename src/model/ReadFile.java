package model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadFile<T> {
   public List<T> readData(String fileName){
       List<T> data = new ArrayList<>();
       try {
           FileInputStream fis = new FileInputStream(fileName);
           ObjectInputStream ois = new ObjectInputStream(fis);
           data =(List<T>) ois.readObject();
           ois.close();
       } catch (IOException | ClassNotFoundException e) {
           e.printStackTrace();
       }
       return data;
    }
}
