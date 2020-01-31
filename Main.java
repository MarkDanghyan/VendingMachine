package vendingMachine;

import vendingMachine.products.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        ArrayList<Product> arrayList = Converter.convert(vendingMachine);
        System.out.println("your orders: " + arrayList);
    }
}
