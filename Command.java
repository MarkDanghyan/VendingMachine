package vendingMachine;

import vendingMachine.exception.InvalidCommandException;
import vendingMachine.products.*;

import java.util.*;
/*
*  A : 1 CocaCola
*  A : 2 Fanta
*  A : 3 Sprite
*  B : 1 Doritos
*  B : 2 KarginChips
* */


public class Command {
    private char first;
    private int second;

    public Command() {
    }

    public Command(char first, int second) {
        this.first = first;
        this.second = second;
    }

    public char getFirst() {
        return first;
    }

    public void setFirst(char first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Command)) return false;
        Command command = (Command) o;
        return first == command.first &&
                second == command.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return "Command{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    static HashMap<Command, Queue<Product>> fillVendingMachine(){
        HashMap<Command, Queue<Product>> hashMap = new HashMap<>();
        Command[] commands = new Command[5];
        commands[0] = new Command('A', 1);
        commands[1] = new Command('A', 2);
        commands[2] = new Command('A', 3);
        commands[3] = new Command('B', 1);
        commands[4] = new Command('B', 2);


        int n = 3; //Initial quantity in Vending Machine
        CocaCola[] cocaColas = new CocaCola[n];
        for(int i = 0; i < n; i++){
            cocaColas[i] = new CocaCola();
        }
        Fanta[] fantas = new Fanta[n];
        for(int i = 0; i < n; i++){
            fantas[i] = new Fanta();
        }
        Sprite[] sprites = new Sprite[n];
        for(int i = 0; i < n; i++){
            sprites[i] = new Sprite();
        }
        Doritos[] doritos = new Doritos[n];
        for(int i = 0; i < n; i++){
            doritos[i] = new Doritos();
        }
        KarginChips[] karginChips = new KarginChips[n];
        for(int i = 0; i < n; i++){
            karginChips[i] = new KarginChips();
        }
        Queue<Product> cocaColas1 = new LinkedList<>(Arrays.asList(cocaColas));
        Queue<Product> fantas1 = new LinkedList<>(Arrays.asList(fantas));
        Queue<Product> sprites1 = new LinkedList<>(Arrays.asList(sprites));
        Queue<Product> doritos1 = new LinkedList<>(Arrays.asList(doritos));
        Queue<Product> karginChips1 = new LinkedList<>(Arrays.asList(karginChips));

        hashMap.put(commands[0], cocaColas1);
        hashMap.put(commands[1], fantas1);
        hashMap.put(commands[2], sprites1);
        hashMap.put(commands[3], doritos1);
        hashMap.put(commands[4], karginChips1);

        return hashMap;
    }

    public void isValidCommand() throws InvalidCommandException{
        if(first == 'A' && (second == 1 || second == 2 || second == 3))
            return;
        if(first == 'B' && (second == 1 || second == 2))
            return;
        throw new InvalidCommandException("There is no product under such command!");
    }
}
