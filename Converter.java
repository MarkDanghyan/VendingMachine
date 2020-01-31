package vendingMachine;

import vendingMachine.exception.InvalidCommandException;
import vendingMachine.exception.OutOfProductsException;
import vendingMachine.products.Fanta;
import vendingMachine.products.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Converter {
    public static ArrayList<Product> convert(VendingMachine vendingMachine){
        Scanner scanner = new Scanner(System.in);

        ArrayList<Product> orders = new ArrayList<>();
        while (true) {
            System.out.println("A:1 - CocaCola");
            System.out.println("A:2 - Fanta");
            System.out.println("A:3 - Sprite");
            System.out.println("B:1 - Doritos");
            System.out.println("B:2 - KarginChips");
            System.out.println("Please input the command: ");

            String input = scanner.next();
            input = input.replaceAll(":", "");
            try {
                Command command = new Command(input.charAt(0), Integer.parseInt(input.substring(1)));
                command.isValidCommand();
                orders.add(vendingMachine.getProduct(command));
            }catch (InvalidCommandException e){
                System.out.println(e.getMessage());
                continue;
            }catch (OutOfProductsException e){
                System.out.println(e.getMessage());
                continue;
            }
            System.out.println();
            System.out.println("Input \"exit\" if you want to leave or otherwise if you want to stay.");
            if(scanner.next().equals("exit")){
                System.out.println("Here are your orders: ");
                System.out.println(orders);
                System.out.println("Have a nice day");
                break;
            }
        }

        return orders;
    }
}
