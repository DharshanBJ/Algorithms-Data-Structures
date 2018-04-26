public class ExcelSheetColumnTitle {
    public static String convertToTitle(int n) {
//         char[] alphabets=new char[26];
//         String alph="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//        // alphabets=alph.toCharArray();
//         StringBuilder result=new StringBuilder();
//         int sum=n;
//         while(sum != 0){
//             if(sum-1/26 !=0){
//                 result.append(alph.charAt((sum-1/26)%26));
//             }else{
//                 result.append(alph.charAt(sum-1%26 ));
//             }
//             sum/=26;
//         }
//         return result.toString();

        StringBuilder result=new StringBuilder();
        while(n>0){
            n--;
            result.append((char)('A'+ n%26 ));
            n/=26;
        }
        return result.reverse().toString();
    }
    public static void main(String[] args){
        System.out.println(convertToTitle(29));
    }

}
