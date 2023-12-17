package org.example.Classes;

import org.example.Classes.Medicine;
import org.example.CustomAnnotations.MethodDocumentation;

import java.util.ArrayList;

public class MedicineInventory {

    private ArrayList<Medicine> medicines;

    public MedicineInventory() {
        medicines = new ArrayList<>();
    }
@MethodDocumentation("addMedicine")
//addMedicine method
    public void addMedicine(String name, int quantity, double price) {
        Medicine newMedicine = new Medicine(name, quantity, price);
        medicines.add(newMedicine);
        System.out.println("Medicine added successfully:\n" + newMedicine);
    }
@MethodDocumentation("displayMedicines")
//displayMedicine method
    public void displayMedicines() {
        if (medicines.isEmpty()) {
            System.out.println("No medicines in the inventory.");
        } else {
            System.out.println("List of Medicines in the Inventory:");
            for (Medicine medicine : medicines) {
                System.out.println(medicine + "\n");
            }
        }
    }
}
