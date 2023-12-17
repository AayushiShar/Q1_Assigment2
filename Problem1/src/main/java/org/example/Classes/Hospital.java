package org.example.Classes;

import org.example.CustomAnnotations.ClassDocumentaion;
import org.example.CustomAnnotations.MethodDocumentation;

import java.util.ArrayList;
@ClassDocumentaion
public class Hospital {
    private ArrayList<Patient> patients;

    public Hospital() {
        patients = new ArrayList<>();
    }
    @MethodDocumentation("Hospital")

    public void registerPatient(String name, int age, String gender) {
        Patient newPatient = new Patient(name, age, gender);
        patients.add(newPatient);
        System.out.println("Patient registered successfully:\n" + newPatient);
    }
@MethodDocumentation("Hospital")
    public void displayPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients registered yet.");
        } else {
            System.out.println("List of registered patients:");
            for (Patient patient : patients) {
                System.out.println(patient + "\n");
            }
        }
    }
}
