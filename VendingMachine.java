package vendingMachine;

import vendingMachine.exception.OutOfProductsException;
import vendingMachine.products.*;

import java.util.*;

public class VendingMachine {
    private HashMap<Command, Queue<Product>> hashMap;
    public VendingMachine(){
        hashMap = new HashMap<>();
        this.fillTheVendingMachine();
    }

    private void fillTheVendingMachine(){
        this.hashMap = Command.fillVendingMachine();
    }

    public Product getProduct(Command command) throws OutOfProductsException{
        Queue<Product> products = hashMap.get(command);
        if(products.isEmpty())
            throw new OutOfProductsException("Sorry we do not have this product");
        return products.remove();
    }
}
