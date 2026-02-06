import java.util.*;

public class SearchEngine {

    private Map<String, Set<String>> index;

    public SearchEngine(Map<String, Set<String>> index) {
        this.index = index;
    }

    public void search(String query) {
        query = query.toLowerCase();

        if (index.containsKey(query)) {
            System.out.println("Word found in files:");
            for (String file : index.get(query)) {
                System.out.println("- " + file);
            }
        } else {
            System.out.println("Word not found in any file.");
        }
    }
}
