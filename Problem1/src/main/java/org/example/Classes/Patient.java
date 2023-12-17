package org.example.Classes;

import org.example.CustomAnnotations.ClassDocumentaion;
import org.example.CustomAnnotations.MethodDocumentation;

//Patient class
@ClassDocumentaion("Patient Class")
public class Patient {
    private final String name;
    private final int age;
    private final String gender;


    public Patient(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
@MethodDocumentation("Patient method")

    @Override
    public String toString() {
        return "Name: " + name + "\nAge: " + age + "\nGender: " + gender;
    }
}
