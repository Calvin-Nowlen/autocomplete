import java.util.Arrays;

public class Autocomplete {

    public Term [] terms;
    // Initializes the data structure from the given array of terms.
    public Autocomplete(Term[] terms) {
        if (terms == null) throw new NullPointerException();
        for (Term tmp : terms) {
            if (tmp == null) {
                throw new NullPointerException();
            }
        }
        this.terms = terms;
        Arrays.sort(this.terms);
    }

    // Returns all terms that start with the given prefix, in descending order of weight.
    public Term[] allMatches(String prefix) {
        Term search = new Term(prefix,0);
        int first= BinarySearchDeluxe.firstIndexOf(terms,search,Term.byPrefixOrder(prefix.length()));
        int last = BinarySearchDeluxe.lastIndexOf(terms,search,Term.byPrefixOrder(prefix.length()));

        if(first < 0){
            return new Term[]{};
        }
        Term[] matches = new Term[last-first+1];
        for(int i = first; i<=last; i++){
            matches[i-first] = terms[i];
        }
        Arrays.sort(matches, Term.byReverseWeightOrder());
        return matches; //FIXME
    }

    // Returns the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix) {
        Term search = new Term(prefix,0);
        int first= BinarySearchDeluxe.firstIndexOf(terms,search,Term.byPrefixOrder(prefix.length()));
        int last = BinarySearchDeluxe.lastIndexOf(terms,search,Term.byPrefixOrder(prefix.length()));
        return last-first+1; //FIXME
    }
    

    // A sample client for unit testing
    public static void main(String[] args) {

        // read in the terms from a file
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Term[] terms = new Term[N];

        int i;
        for (i = 0; i < N; i++) {
            long weight = in.readLong();           // read the next weight
            in.readChar();                         // scan past the tab
            String query = in.readLine();          // read the next query
            terms[i] = new Term(query, weight);    // construct the term
        }


        // read in queries from standard input and print out the top k matching terms
        int k = Integer.parseInt(args[1]);
        Autocomplete autocomplete = new Autocomplete(terms);
        while (StdIn.hasNextLine()) {
            Stopwatch time = new Stopwatch();
            String prefix = StdIn.readLine();
            Term[] results = autocomplete.allMatches(prefix);
            for ( i = 0; i < Math.min(k, results.length); i++)
                StdOut.println(results[i]);
            StdOut.println(time.elapsedTime());
        }
    }
}