import java.io.*;
import java.util.*;

public class FileIndexer {

    // word -> set of files
    private Map<String, Set<String>> index = new HashMap<>();

    public void indexFiles(String folderPath) throws IOException {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        if (files == null) {
            System.out.println("No files found.");
            return;
        }

        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                indexFile(file);
            }
        }
    }

    private void indexFile(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        while ((line = br.readLine()) != null) {
            String[] words = line.toLowerCase().split("\\W+");

            for (String word : words) {
                if (word.isEmpty()) continue;

                index.putIfAbsent(word, new HashSet<>());
                index.get(word).add(file.getName());
            }
        }
        br.close();
    }

    public Map<String, Set<String>> getIndex() {
        return index;
    }
}
