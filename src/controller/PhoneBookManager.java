package controller;

import model.AbstractPhone;
import model.Concat;
import model.Type;

import java.util.ArrayList;

public class PhoneBookManager extends AbstractPhone {
    private ArrayList<Concat> concats = new ArrayList<Concat>();

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
        System.out.println("Đã thêm/ sửa liên hệ: " + concat);

    }

    @Override
    public void removePhone(String name) {



    }

    @Override
    public void updatePhone(String name, String newPhone) {

    }

    @Override
    public void searchPhone(String name) {

    }

    @Override
    public void sort() {

    }
}
