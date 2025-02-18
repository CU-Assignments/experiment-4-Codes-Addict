import java.util.*;

class Card {
    String symbol;
    String value;

    Card(String symbol, String value) {
        this.symbol = symbol;
        this.value = value;
    }

    @Override
    public String toString() {
        return "[" + symbol + " " + value + "]";
    }
}

public class CardCollection {
    private static final List<Card> cards = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void addCard() {
        System.out.print("Enter Card Symbol: ");
        String symbol = scanner.next();
        scanner.nextLine();
        System.out.print("Enter Card Value: ");
        String value = scanner.nextLine();
        cards.add(new Card(symbol, value));
        System.out.println("Card added successfully!\n");
    }

    public static void displayCards() {
        if (cards.isEmpty()) {
            System.out.println("No cards available!\n");
        } else {
            System.out.println("All Cards:");
            for (Card card : cards) {
                System.out.println(card);
            }
            System.out.println();
        }
    }

    public static void findCardsBySymbol() {
        System.out.print("Enter symbol to search: ");
        String symbol = scanner.next();
        boolean found = false;
        for (Card card : cards) {
            if (card.symbol.equalsIgnoreCase(symbol)) {
                System.out.println(card);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No cards found with the symbol: " + symbol + "\n");
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add Card");
            System.out.println("2. Display All Cards");
            System.out.println("3. Find Cards by Symbol");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addCard();
                case 2 -> displayCards();
                case 3 -> findCardsBySymbol();
                case 4 -> {
                    System.out.println("Exiting... Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice! Try again.\n");
            }
        }
    }
}
