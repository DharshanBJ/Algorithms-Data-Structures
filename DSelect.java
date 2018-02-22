import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.*;

public class DSelect {

    /** Get CPU time in nanoseconds. */
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



        DSelect ds = new DSelect();

        Random r = new Random();

        //for (int z = 0; z < 20; z++) {
            double startUserTimeNano = getUserTime();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < 100000; i++) {
                list.add(r.nextInt());
            }

            //testing
            //list.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,24,235,53,45,34,534,346,88888,565,6666,-5,-123,-3234,40923));

            int k = list.size() / 2;

            System.out.println(ds.findKthSmallest(list, k, 9));

            //testing
            Collections.sort(list);
            System.out.println(list.get(list.size() / 2));

        double taskUserTimeNano = getUserTime() - startUserTimeNano;
        System.out.println("User time: "+taskUserTimeNano/1000000000+ "  seconds");


    }
    public static int findMedian(List<Integer> arr) {
        Collections.sort(arr);
        return arr.get(arr.size() / 2);
    }

    public static int findKthSmallest(List<Integer> arr, int k,int div) {

        if (arr.size() < 10) {
            Collections.sort(arr);
           // System.out.println("Hello");
            return arr.get(k);
        }


        int g=div;
        ArrayList<Integer> medians = new ArrayList<>();

        for (int i = 0; i < arr.size() - arr.size() % g; i = i + g) {
            medians.add(findMedian(arr.subList(i, i + g)));
            //System.out.println(i);
        }

        int mainMedian = (medians.size() == 1) ? medians.get(0) : findKthSmallest(medians, medians.size()/2,g);

        ArrayList<Integer> left = getLeftPartition(arr, mainMedian);
        ArrayList<Integer> right = getRightPartition(arr, mainMedian);

        if (left.size() == k) {
            return mainMedian;
        } else if (left.size() > k) {
            return findKthSmallest(left, k,g);
        } else {
            return findKthSmallest(right, k - left.size(),g);
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
}

