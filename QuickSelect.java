import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.*;

public class QuickSelect {

//    public static long getCpuTime( ) {
//        ThreadMXBean bean = ManagementFactory.getThreadMXBean( );
//        return bean.isCurrentThreadCpuTimeSupported( ) ?
//                bean.getCurrentThreadCpuTime( ) : 0L;
//    }

    /** Get user time in nanoseconds. */
    public static long getUserTime( ) {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean( );
        return bean.isCurrentThreadCpuTimeSupported( ) ?
                bean.getCurrentThreadUserTime( ) : 0L;
    }


    public static void main(String[] args) {


    QuickSelect ds = new QuickSelect();

        Random r=new Random();

   //     for(int z=0;z<20;z++) {

            double startUserTimeNano   = getUserTime( );
            List<Integer> list = new ArrayList<>();

    for (int i = 0; i < 400000; i++) {
        list.add(r.nextInt());
    }

    //testing
     //list.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,24,235,53,45,34,534,346,88888,565,6666));

    int k = list.size() / 2;

    System.out.println(ds.findKthSmallest(list, k));
        double taskUserTimeNano = getUserTime() - startUserTimeNano;
        System.out.println("User time: "+taskUserTimeNano/1000000000+ "  seconds");

    //testing
//        Collections.sort(list);
//        System.out.println(list.get(list.size()/2));

    }


    public static int findKthSmallest(List<Integer> arr, int k) {


        if(arr.size() < 2){
            return arr.get(k);
        }

        int randomNum;
        Random rand = new Random();
        randomNum = 0 + rand.nextInt(((arr.size()-1) - 0) + 1);

        ArrayList<Integer> left = getLeftPartition(arr, arr.get(randomNum));
        ArrayList<Integer> right = getRightPartition(arr, arr.get(randomNum));
        //ArrayList<Integer> equal = getEqualPartition(arr, arr.get(randomNum));

        if (left.size()  == k) {
            return arr.get(randomNum);
        } else if (left.size() > k) {
            return findKthSmallest(left, k);
        } else {
            return findKthSmallest(right, k - left.size());
        }

    }

    public static ArrayList<Integer> getLeftPartition(List<Integer> a, int mainMedian) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        for (int val : a) {
            if (val < mainMedian)
                res.add(val);
        }

        return res;
    }

    public static ArrayList<Integer> getRightPartition(List<Integer> a, int mainMedian) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        for (int val : a) {
            if (val >= mainMedian)
                res.add(val);
        }

        return res;
    }
//    public static ArrayList<Integer> getEqualPartition(List<Integer> a, int mainMedian) {
//        ArrayList<Integer> res = new ArrayList<Integer>();
//
//        for (int val : a) {
//            if (val == mainMedian)
//                res.add(val);
//        }
//
//        return res;
//    }
}
