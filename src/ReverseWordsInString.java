public class ReverseWordsInString {

    public static void reverseString(char[] input){
        int start=0;
        int end=input.length-1;
        reverse(input,start,end);

        start=0;
        for(int i=0;i<input.length;i++){
            if(input[i]==' '){
                reverse(input,start,i-1);
                start=i+1;
            }
        }

        reverse(input,start,input.length-1);
    }

    public static void reverse(char[] input,int start,int end){
        while(start<end){
            char temp=input[start];
            input[start]=input[end];
            input[end]=temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args){

        char[] input=new char[]{'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        reverseString(input);
        for(int i=0;i<input.length;i++){
            System.out.println(input[i]+"\n");
        }
    }
}
