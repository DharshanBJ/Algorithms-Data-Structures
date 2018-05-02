import java.util.HashMap;
import java.util.Map;


public class StringCompression {

    public static int compress(char[] chars) {
//        StringBuilder result=new StringBuilder();
//        Map<Character,Integer> map=new HashMap<>();
//        int value;
//        for(int i=0;i<chars.length;i++){
//            if(map.containsKey(chars[i])){
//                 value=map.get(chars[i]);
//                map.put(chars[i],value+1);
//            }else{
//                map.put(chars[i],1);
//            }
//        }
//
//        for(char c:map.keySet()){
//            System.out.println("Key:"+c+" Value:"+map.get(c));
//            result.append(c);
//            if(map.get(c) != 1)result.append(map.get(c));
//
//        }
//        System.out.println(result+" "+result.length());
//        return 0;

        int index=0,indexAnswer=0;
        while(index<chars.length){
            char currChar=chars[index];
            int count=0;
            while(index<chars.length && chars[index]==currChar){
                index++;
                count++;
            }
            chars[indexAnswer]=currChar;
            indexAnswer++;

            if(count != 1){
                for(char c:Integer.toString(count).toCharArray()){
                    chars[indexAnswer]=c;
                    indexAnswer++;
                }
            }
        }
        for(int i=0;i<indexAnswer;i++){
            System.out.print(chars[i]);
        }
        return indexAnswer; //i need the length not the last index,hence not returning indexAnswer-1
    }

    public static void main(String[] args){

        compress(new char[]{'a','b','b','b','b','b','b','c','e','e'});
    }
}
