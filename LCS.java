import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class LCS {

    /** Get user time in nanoseconds. */
    public static long getUserTime( ) {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean( );
        return bean.isCurrentThreadCpuTimeSupported( ) ?
                bean.getCurrentThreadUserTime( ) : 0L;
    }

    public static int findLCS(StringBuffer s1,StringBuffer s2){

        double startUserTimeNano = getUserTime();

        int l1=s1.length();
        int l2=s2.length();
        int[][] dp=new int[l1+1][l2+1];


        //base case
        for(int i=0;i<l1+1;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<l2+1;i++){
            dp[0][i]=0;
        }

        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
               if(s1.charAt(i-1)==s2.charAt(j-1)){
                   dp[i][j]=dp[i-1][j-1]+1;

               }else{
                   dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
               }
            }
        }

        double taskUserTimeNano = getUserTime() - startUserTimeNano;
        System.out.println("User time: "+taskUserTimeNano/1000000000+ "  seconds");

        return dp[l1][l2];
    }

    //Driver class
    public static void main(String[] args){
        String CHAR_LIST ="abcdefghijklmnopqrstuvwxyz";
        int RANDOM_STRING_LENGTH_1 = 100;
        int RANDOM_STRING_LENGTH_2 = 100;

        StringBuffer randStr1 = new StringBuffer();
        for(int i=0; i<RANDOM_STRING_LENGTH_1; i++){
            int randomNum = ThreadLocalRandom.current().nextInt(0, 25 + 1);
            char ch = CHAR_LIST.charAt(randomNum);
            randStr1.append(ch);
        }

        StringBuffer randStr2 = new StringBuffer();
        for(int i=0; i<RANDOM_STRING_LENGTH_2; i++){
            int randomNum = ThreadLocalRandom.current().nextInt(0, 25 + 1);
            char ch = CHAR_LIST.charAt(randomNum);
            randStr2.append(ch);
        }

        int answer;
        answer=findLCS( randStr1,randStr2);

//        System.out.println("String 1 "+randStr1);
//        System.out.println("String 1 "+randStr2);
        System.out.println("The longest common sub sequence between s1 and s2 is of length "+answer);

    }
}
