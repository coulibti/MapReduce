import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class test {

    public static void main(String[] args) {

        String text = "balcon ecole etagere bonjour allo vive ecole garderie chalet pomme balcon super chaleur chalet ecole as or cuivre salut";

        countAndDisplayWords(text);

    }

    private static void countAndDisplayWords(String message) {

        Map<String, Integer> counter = new HashMap<>();

        // Compter chaque mot
        String[] words = message.split(" ");
        for (String word : words) {
            Integer currentCount = counter.get(word);
            if (currentCount == null) {
                currentCount = 0;
            }

            ++currentCount;
            counter.put(word, currentCount);
        }

        // Obtenir la list en ordre
        List<String> sortedEntries = new ArrayList<>();
        for (Entry<String, Integer> entry : counter.entrySet()) {
            sortedEntries.add(entry.getKey() + ": " + entry.getValue());
        }
        Collections.sort(sortedEntries);

        // Afficher tous les mots
        for (String entry : sortedEntries) {
            System.out.println(entry);
        }

    }
}