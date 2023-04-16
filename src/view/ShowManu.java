package view;

import controller.PhoneBookManager;
import model.Concat;

import java.util.Scanner;

public class ShowManu {
    public static void main(String[] args) {
        PhoneBookManager phoneBookManager = new PhoneBookManager();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            System.out.println("""
                    ===== Phone Book Management System =====
                    1.Display all contacts
                    2.Insert a new contact
                    3.Remove a contact
                    4.Update the contact
                    5.Search for a contact
                    6.Sort contacts
                    0.Exit.
                    """);
            System.out.println("Choose is your");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> phoneBookManager.display();
                case 2 -> {
                    System.out.print("Enter contact name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter contact phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter contact type ID: ");
                    int typeId = scanner.nextInt();
                    Concat concat = new Concat(name, phoneNumber, typeId);
                    phoneBookManager.insertPhone(concat);
                }
                case 3 -> {
                    System.out.print("Enter contact name to remove: ");
                    String removeName = scanner.nextLine();
                    phoneBookManager.removePhone(removeName);
                }
                case 4 -> {
                    System.out.print("Enter contact name to update: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Enter new phone number: ");
                    String newPhoneNumber = scanner.nextLine();
                    phoneBookManager.updatePhone(updateName, newPhoneNumber);
                }
                case 5 ->{
                    System.out.print("Enter contact name to search: ");
                    String searchName = scanner.nextLine();
                    phoneBookManager.searchPhone(searchName);
                }
                case 6 ->{
                    phoneBookManager.sort();
                }
                case 0 -> System.exit(0);
            }

        } while (choice != 0);
    }
}
