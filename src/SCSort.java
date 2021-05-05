import java.util.Comparator;
import java.util.StringTokenizer;

public class SCSort implements Comparator<String> {
    public int compare(String s, String a){
        StringTokenizer st1 = new StringTokenizer(s,"+");
        StringTokenizer st2 = new StringTokenizer(a,"+");
        return st1.countTokens()-st2.countTokens();
    }
}
