package controller;

import model.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PhoneBookManager extends AbstractPhone implements IPhone {
    private List<Concat> concats = new ArrayList<Concat>();
    private List<Type> types = new ArrayList<Type>();
    private ReadFile<Concat> readFile = new ReadFile<Concat>();
    private WriteFile<Concat> writeFile = new WriteFile<Concat>();

    @Override
    public void display(Type type) {
        System.out.println("Danh sách liên hệ");
        if(type == null || type.getName().isEmpty()){
            concats.stream()
                    .forEach(System.out::println);
        } else {
          concats.stream()
                  .filter(concat -> concat.getType().getTypeName().equals(type.getName()))
                  .forEach(System.out::println);
        }
    }
    public void display(){
        System.out.println(concats);
    }

    @Override
    public void insertPhone(Concat concat) {
        boolean isContactExit = concats.stream()
                .anyMatch(concat1 -> concat1.getName().equals(concat.getName()));
        if(isContactExit){
            concats.stream()
                    .filter(concat1 -> concat1.getName().equals(concat.getName()))
                    .forEach(concat1 -> {
                        concat1.setPhoneNumber(concat.getPhoneNumber());
                        concat1.setType(concat.getType());
                    });
        } else {
            concats.add(concat);
        }
        writeFile.writeData(concats,"src/file/outputStream");
        System.out.println("Đã thêm/ sửa liên hệ: " + concat);

    }

    @Override
    public void removePhone(String name) {
        Concat concatToRemove = null;
        for (Concat concat :concats
             ) {
            if(concat.getName().equals(name)) {
                concatToRemove = concat;
                break;
            }
        }
        if(concatToRemove != null){
            concats.remove(concatToRemove);
            writeFile.writeData(concats,"src/file/outputStream");
            System.out.println("Contact has been removed successfully.");
        } else {
            System.out.println("Concat not found.");
        }
    }

    @Override
    public void updatePhone(String name, String newPhone) {
        boolean isUpdate = false;
        for (Concat concat :concats
             ) {
            if(concat.getName().equals(name)){
                concat.setPhoneNumber(newPhone);
                isUpdate = true;
                break;
            }
        }
        if(isUpdate){
            System.out.println("Phone number has been updated successfully.");
        }else {
            System.out.println("Concat not found");
        }
        writeFile.writeData(concats,"src/file/outputStream");


    }

    @Override
    public void searchPhone(String name) {
        boolean isFound = false;
        for (Concat concat :concats)
             {
            if(concat.getName().equals(name)){
                System.out.println(concat);
                isFound = true;
                break;
            }
        }
        if(!isFound){
            System.out.println("Contact not found.");
        }

    }

    @Override
    public void sort() {
        concats.sort(Comparator.comparing(Concat::getName));
        System.out.println("\"Phone book has been sorted by name.\"");
        writeFile.writeData(concats,"src/file/outputStream");
    }
}
