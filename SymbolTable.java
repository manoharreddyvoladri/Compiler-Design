import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SymbolTable {
    private Map<String, Integer> symbolMap;
    private static final String REGISTER_NUMBER = "21BRS1177";

    public SymbolTable() {
        this.symbolMap = new HashMap<>();
    }
    // Adding symbols to the table
    public void addSymbol(String symbol, int value) {
        symbolMap.put(symbol, value);
    }
    // Deleting symbols from the table
    public void deleteSymbol(String symbol) {
        symbolMap.remove(symbol);
    }

    // Searching if a symbol exists in the table
    public boolean symbolExists(String symbol) {
        return symbolMap.containsKey(symbol);
    }

    // Retrieving the value associated with a symbol
    public int getSymbolValue(String symbol) {
        return symbolMap.getOrDefault(symbol, -1); // -1 indicates symbol not found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SymbolTable symbolTable = new SymbolTable();

        // Asking for the number of symbols to add
        System.out.print("How many symbols do you want to add? ");
        int numSymbols = scanner.nextInt();

        // Adding symbols based on user input
        for (int i = 0; i < numSymbols; i++) {
            System.out.print("Enter symbol name: ");
            String symbol = scanner.next();
            System.out.print("Enter value for " + symbol + ": ");
            int value = scanner.nextInt();
            symbolTable.addSymbol(symbol, value);
        }

        while (true) {
            // Asking the user whether to search, delete, or exit
            System.out.print("Do you want to search (S), delete (D), or exit (E)? ");
            char choice = scanner.next().charAt(0);

            if (Character.toUpperCase(choice) == 'S') {
                // Searching for symbols
                System.out.print("Enter symbol to search: ");
                String searchSymbol = scanner.next();
                System.out.println("Does " + searchSymbol + " exist in the symbol table? " + symbolTable.symbolExists(searchSymbol));
            } else if (Character.toUpperCase(choice) == 'D') {
                // Deleting symbols
                System.out.print("Enter symbol to delete: ");
                String deleteSymbol = scanner.next();
                symbolTable.deleteSymbol(deleteSymbol);
                System.out.println("Symbol " + deleteSymbol + " deleted from the symbol table.");
            } else if (Character.toUpperCase(choice) == 'E') {
                // Exit the program
                System.out.println("Exiting the program. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please choose 'S' for search, 'D' for delete, or 'E' for exit.");
            }
        }

        // Displaying the registration number constant
        System.out.println("Registration Number: " + REGISTER_NUMBER);

        // Close the scanner to avoid resource leak
        scanner.close();
    }
}
