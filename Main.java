import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        FileIndexer indexer = new FileIndexer();

        try {
            indexer.indexFiles("data");
        } catch (IOException e) {
            System.out.println("Error reading files.");
            return;
        }

        SearchEngine engine = new SearchEngine(indexer.getIndex());
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Mini Search Engine ---");
            System.out.println("1. Search word");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter word to search: ");
                String word = sc.nextLine();
                engine.search(word);
            } else {
                System.out.println("Exiting search engine.");
                break;
            }
        }
        sc.close();
    }
}
