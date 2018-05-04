import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class SimplifyFilePath {
    public static String simplifyPath(String path) {
        String[] str=path.split("/");

        Deque<String> deque=new LinkedList<>();
        StringBuilder result=new StringBuilder();
        result.append("/");

        for(int i=0;i<str.length;i++){
        if(str[i].equals("..")){
            deque.pollLast();
        }else if(!str[i].equals(".") && !str[i].equals("")){ //to handle '//' case
            deque.add(str[i]);
        }

        }


        while(!deque.isEmpty()){
            result.append(deque.pollFirst());

                result.append("/");

        }
        if(result.length()>1) {
            result.delete(result.length() - 1, result.length());
        }

        return result.toString();
    }

    public static void main(String[] args){
        String result=simplifyPath("/../");
        System.out.print(result);
    }
}


