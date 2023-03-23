import java.util.HashMap;
import java.util.Map;

public class Scrabble {
    private String word;
    private Character[] doubleLetter, tripleLetter;

    private Boolean isDouble, isTriple;


    public Scrabble(String word) {
        this.word = word;
    }

    public Scrabble(String word, Character[] doubleLetter, Character[] tripleLetter, boolean isDouble, boolean isTriple) {
        this.word = word;
        this.doubleLetter = doubleLetter;
        this.tripleLetter = tripleLetter;
        this.isDouble = isDouble;
        this.isTriple = isTriple;
    }
    private HashMap<Character, Integer> values = new HashMap<>();
    {
        char[] letters1 = {'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T'};
        for (char letter : letters1) {
            values.put(letter, 1);
        }
        char[] letters2 = {'D', 'G'};
        for (char letter : letters2) {
            values.put(letter, 2);
        }
        char[] letters3 = {'B', 'C', 'M', 'P'};
        for (char letter : letters3) {
            values.put(letter, 3);
        }
        char[] letters4 = {'F', 'H', 'V', 'W', 'Y'};
        for (char letter : letters4) {
            values.put(letter, 4);
        }
        char[] letters5 = {'K'};
        for (char letter : letters5) {
            values.put(letter, 5);
        }
        char[] letters8 = {'J', 'X'};
        for (char letter : letters8) {
            values.put(letter, 8);
        }
        char[] letters10 = {'Q', 'Z'};
        for (char letter : letters10) {
            values.put(letter, 10);
        }

    }

    public int score() {
        if (word == null || word.isEmpty()) {
            return 0;


        }

        int score = 0;
        this.word = word == null ? "" : word.toUpperCase();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            score += values.get(c);

        }
        score *= isTriple != null && isTriple.booleanValue() ? 3 : (isDouble != null && isDouble.booleanValue() ? 2 : 1);
        return score;
    }

}
