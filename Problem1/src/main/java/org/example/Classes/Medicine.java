package org.example.Classes;

import org.example.CustomAnnotations.ClassDocumentaion;
import org.example.CustomAnnotations.MethodDocumentation;
//Medicine class
@ClassDocumentaion("Medicine")
public class Medicine {

        private final String name;
        private final int quantity;
        private final double price;

        public Medicine(String name, int quantity, double price) {
            this.name = name;
            this.quantity = quantity;
            this.price = price;
        }
        //overriding toString method
@MethodDocumentation("Method")
        @Override
        public String toString() {
            return "Medicine: " + name + "\nQuantity: " + quantity + "\nPrice: $" + price;
        }
    }

