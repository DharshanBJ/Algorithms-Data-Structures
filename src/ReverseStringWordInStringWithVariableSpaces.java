public class ReverseStringWordInStringWithVariableSpaces {
    public static String reverseWords(String s) {
        int start=0;
        int end=s.length()-1;
        if(s.length()==0)return s;
        //reverse the complete string
        char[] arr;
        arr=s.toCharArray();
        reverse(arr,start,end);
        System.out.println(arr);
        boolean flag=true;
        //char[] str=s.toCharArray();
        //reverse individual words in the string
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=' ' && flag==true){
                start=i;
                flag=false;
            }
            if(arr[i]==' ' && flag==false){
                end=i-1;
                flag=true;
                reverse(arr,start,end);
            }
        }
        System.out.println(arr);
        String result=new String(arr);
        return result;
    }

    public static void reverse(char[] s,int start,int end){
        while(start<end){
            Character temp=s[end];
            s[end]=s[start];
            s[start]=temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args){
       System.out.println(reverseWords("   the  sky is  blue  "));

    }
}
