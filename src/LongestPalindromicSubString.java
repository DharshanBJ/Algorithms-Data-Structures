public class LongestPalindromicSubString {
    public static String longestPalindrome(String s) {
        int len=s.length();

        String res="";

        boolean[][] dp=new boolean[len][len];

        for(int i=len-1;i>=0;i--){
            for(int j=i;j<len;j++){
                dp[i][j]= s.charAt(i)==s.charAt(j) && ((j-i < 3) || dp[i+1][j-1]); //if the length of sustring <=3,just check the end characters
                if(dp[i][j] && (res=="" || j-i+1 > res.length())){
                    res=s.substring(i,j+1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args){

        String result=longestPalindrome("malayalam");
        System.out.println("Longest palindromic substring is "+result);
    }

}
