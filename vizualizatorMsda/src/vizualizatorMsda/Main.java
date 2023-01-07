package vizualizatorMsda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a new red-black tree
        RedBlackTree tree = new RedBlackTree();

        // Create a scanner for reading user input
        Scanner scanner = new Scanner(System.in);

        // Continuously prompt the user for commands
        while (true) {
            System.out.print("Enter a command (a: add node, p: print tree, q: quit): ");
            String command = scanner.nextLine();

            if (command.equals("a")) {
                // Add a node
                System.out.print("Enter a key value: ");
                int key = scanner.nextInt();
                tree.add(key);
            } else if (command.equals("p")) {
                // Print the tree
                tree.printTree();
            } else if (command.equals("q")) {
                // Quit the program
                break;
            } else {
                System.out.println("Invalid command.");
            }
        }

        // Close the scanner
        scanner.close();
    }
}

