import java.util.Comparator;

public class SortSymbol implements Comparator<String> {
    public int compare(String q, String w){
        return q.compareTo(w);
    }
}
