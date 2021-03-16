package tpMiniBlast;

public class BlastAlt {

    public static void main(String[] args) {
        //To test
        char[] query = {'a', 'e', 'g', 'v', 'x', 'z', 'k'};
        char[] reference = {'c', 'z', 'y', 'v', 'x', 'a', 'k'};
        //Exact match would be 5, and the arrays are 7 letters long.
        double matching = exactMatch(query, reference);
        //Percentage would be 5/7 =~ 0.714
        double percentage= (percentage(query, reference, matching) * 100);
        System.out.println("Percentage (how similar the query and the reference are): " + percentage);

    }

    public static double percentage(char[] query, char[] reference, double matching) {
            return (matching / query.length);
    }

    public static double exactMatch(char[] query, char[] reference) {
        int exactMatch = 0;
        for (int i = 0; i < reference.length; i++) {
            for (int j = 0; j < query.length; j++) {
                if (query[j] == (reference[i])) {
                    exactMatch++;
                }
            }
        }
        return exactMatch;
    }

}

