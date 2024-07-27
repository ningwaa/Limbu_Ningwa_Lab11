import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListDemo {
    private static Scanner in = new Scanner(System.in);
    private static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        boolean quit = false;

        while (!quit) {
            displayMenu();
            String choice = SafeInput.getRegExString(in, "Enter a command: ", "[AaDdIiPpQq]");
            switch (choice.toUpperCase()) {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "I":
                    insertItem();
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    quit = confirmQuit();
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nCurrent List:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ": " + list.get(i));
        }
        System.out.println("\nMenu:");
        System.out.println("A - Add an item to the list");
        System.out.println("D - Delete an item from the list");
        System.out.println("I - Insert an item into the list");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit");
    }

    private static void addItem() {
        String item = SafeInput.getNonZeroLenString(in, "Enter item to add: ");
        list.add(item);
        System.out.println("Item added.");
    }

    private static void deleteItem() {
        if (list.isEmpty()) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }
        int itemNumber = SafeInput.getRangedInt(in, "Enter item number to delete: ", 1, list.size());
        list.remove(itemNumber - 1);
        System.out.println("Item deleted.");
    }

    private static void insertItem() {
        String item = SafeInput.getNonZeroLenString(in, "Enter item to insert: ");
        int position = SafeInput.getRangedInt(in, "Enter position to insert at: ", 1, list.size() + 1);
        list.add(position - 1, item);
        System.out.println("Item inserted.");
    }

    private static void printList() {
        if (list.isEmpty()) {
            System.out.println("List is empty.");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ": " + list.get(i));
            }
        }
    }

    private static boolean confirmQuit() {
        return SafeInput.getYNConfirm(in, "Are you sure you want to quit? (Y/N): ");
    }
}