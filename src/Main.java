import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String s;
        BufferedReader BuffRead = new BufferedReader(new FileReader("src\\input.txt"));
        BufferedWriter BuffRead1 = new BufferedWriter(new FileWriter("src\\output1.txt"));
        BufferedWriter BuffRead2 = new BufferedWriter(new FileWriter("src\\output2.txt"));
        BufferedWriter BuffRead3 = new BufferedWriter(new FileWriter("src\\output3.txt"));

        ArrayList<String> apl = new ArrayList<>();
        ArrayList<String> tab = new ArrayList<>();
        ArrayList<String> activ = new ArrayList<>();
        while ((s = BuffRead.readLine()) != null) {
            String[] arr = s.split(" ");
            int size = arr.length;
            for(int i = 0; i < size; i++){
                if(arr[i].equals("Run")){
                    String st = " ";
                    int q = i+1;
                    while (q < size){
                       st = st + arr[q] + " ";
                       q++;
                    }
                    apl.add(0,st.trim());
                    activ.add(st.trim());
                    break;
                }

                if(arr[i].equals("Close")){
                    apl.remove(0);
                    break;
                }

                else {
                    if(apl.size() > 1) {
                        tab.add(s);

                        String[] alt = s.split("\\+");
                        int count = 0;
                        for (String stab : alt) {
                            if (stab.equals("Tab")) {
                                count++;
                            }
                        }
                        for (int h = 0; h < count; h++) {
                            String si = apl.get(0);
                            apl.add(apl.size(), si);
                            apl.remove(0);
                        }
                        String act = apl.get(0);
                        activ.add(act);
                        break;
                    }
                    else{
                        tab.add(s);
                        continue;
                    }
                }
            }
        }
        tab.sort(new SCSort());
        apl.sort(new SortSymbol());
        for(String qaz: apl){
            BuffRead1.write(qaz + "\n");
        }
        for(String str: tab){
            BuffRead2.write(str + "\n");
        }
        for(String ac: activ){
            BuffRead3.write(ac + "\n");
        }
        BuffRead1.close();
        BuffRead2.close();
        BuffRead3.close();

    }
}