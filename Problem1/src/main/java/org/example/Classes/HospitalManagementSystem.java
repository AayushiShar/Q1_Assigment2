package org.example.Classes;

import org.example.Classes.Hospital;
import org.example.CustomAnnotations.ClassDocumentaion;

import java.util.Scanner;

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hospital hospital = new Hospital();

        while (true) {
            System.out.println("\nHospital Management System");
            System.out.println("1. Register a new patient");
            System.out.println("2. Display registered patients");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            String name = null;
            switch (choice) {
                case 1:
                    System.out.print("Enter patient name: ");
                    name = scanner.next();


                    System.out.print("Enter patient age: ");
                    int age = scanner.nextInt();

                    System.out.print("Enter patient gender: ");
                    String gender = scanner.next();//M or F

                    hospital.registerPatient(name, age, gender);
                    break;

                case 2:
                    hospital.displayPatients();
                    break;

                case 3:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

