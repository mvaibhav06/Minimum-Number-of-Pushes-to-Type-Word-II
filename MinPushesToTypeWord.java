import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MinPushesToTypeWord {
    public int minimumPushes(String word) {
        HashMap<Character, Integer> inp = new HashMap<>();

        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(inp.containsKey(ch)){
                inp.put(ch, inp.get(ch)+1);
            }else{
                inp.put(ch,1);
            }
        }

        List<Integer> values = new ArrayList<>();

        for(int a: inp.values()){
            values.add(a);
        }
        Collections.sort(values);
        int size = values.size();
        int out = 0;
        for(int i=size-1; i>=0; i--){
            if(size-i <= 8){
                out += values.get(i);
            }else if(size-i > 8 && size-i<=16){
                out += values.get(i)*2;
            }else if(size-i>16 && size-i<=24){
                out += values.get(i)*3;
            }else{
                out += values.get(i)*4;
            }
        }
        return out;
    }
}
