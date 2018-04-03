import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.ThreadLocalRandom;

 class LCS_HA {

    /** Get user time in nanoseconds. */
    public static long getUserTime( ) {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean( );
        return bean.isCurrentThreadCpuTimeSupported( ) ?
                bean.getCurrentThreadUserTime( ) : 0L;
    }

    public static int solveLCS(StringBuffer x, StringBuffer y) {

        double startUserTimeNano = getUserTime();

        int i, j;
        int l1 = x.length();
        int l2 = y.length();
        int[][] K = new int[2][l2+1];

     //base case
        for (j = 0; j < y.length() + 1; j++) {
            K[1][j] = 0;

        }
        for (i = 1; i < x.length() + 1; i++) {

            for (j = 0; j < y.length() + 1; j++) {
                K[0][j] = K[1][j];
            }

            K[1][0] = 0;

            for (j = 1; j < y.length() + 1; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    K[1][j] = K[0][j - 1] + 1;
                } else {
                    K[1][j] = Math.max(K[0][j], K[1][j - 1]);
                }
            }
        }

        double taskUserTimeNano = getUserTime() - startUserTimeNano;
        System.out.println("User time: "+taskUserTimeNano/1000000000+ "  seconds");

        return K[1][y.length()];
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
        answer=solveLCS( randStr1,randStr2);
//        System.out.println("String 1 "+randStr1);
//        System.out.println("String 1 "+randStr2);
        System.out.println("The longest common sub sequence between s1 and s2 is of length "+answer);
    }
}

