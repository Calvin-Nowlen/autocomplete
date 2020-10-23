import java.util.Arrays;
import java.util.Comparator;

public class Term implements Comparable<Term> {
    private String query;
    private long weight;
    // Initializes a term with the given query string and weight.
    public Term(String query, long weight) {
        this.query = query;
        this.weight = weight;
    }

    public static Comparator<Term> byReverseWeightOrder() {
        return new Comparator<Term>() {
            public int compare(Term v, Term w) {
                if(v.weight>w.weight){
                //some condition
                    return -1;
                }

                else if(v.weight<w.weight){
                    //some condition
                    return 1;
                }
                else if(v.weight==w.weight){
                    //some condition
                    return 0;
                }
                else {
                    return 0;
                }

            }

        };
    }

    // Compares the two terms in lexicographic order but using only the first r characters of each query.
    public static Comparator<Term> byPrefixOrder(int r) {
        return new Comparator<Term>() {
            public int compare(Term v, Term w) {
                int h=0;
                int i = v.query.length() < r ? v.query.length() : r;//set end of substring based on
                int j = w.query.length() < r ? w.query.length() : r;// if the stored value is longer
                //or the searched value is larger

                int l = v.query.substring(0, i).compareTo(w.query.substring(0, i));//comparison and return

                return l;//FIXME
            }
        };
    }

    // Compares the two terms in lexicographic order by query.
    public int compareTo(Term that) {
        return query.compareTo(that.query); //FIXME
    }

    // Returns a string representation of this term in the following format:
    // the weight, followed by a tab, followed by the query.
    public String toString() {
        String  i = Long.toString(weight);
        String j = query;
        String string = String.format("%s     %s", i, j);
        return string; //FIXME
    }

    // unit testing (you should have some Unit Testing here to confirm that your methods work); for example...
    public static void main(String[] args) {
        Term[] terms = new Term[5];
        terms[0] = new Term("Trevor", 45);
        terms[1] = new Term("Kathy", 43);
        terms[2] = new Term("Ellie", 11);
        terms[3] = new Term("Allen", 9);
        terms[4] = new Term("Eva", 1);
        
        Arrays.sort(terms);
        for (Term t : terms) {
            StdOut.println(t);
        }
        
        StdOut.println("");
        Arrays.sort(terms, Term.byReverseWeightOrder());
        for (Term t : terms) {
            StdOut.println(t);
        }
        
        StdOut.println("");
        Arrays.sort(terms, Term.byPrefixOrder(1));
        for (Term t : terms) {
            StdOut.println(t);
        }        
    }
}