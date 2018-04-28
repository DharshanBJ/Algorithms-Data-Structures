public class FindMinInRotatedSortedArr {
    public static int findMin(int[] nums) {
        int start=0;
        int end=nums.length-1;

        while(start<=end){
            if(nums[start]<=nums[end])
            {
                return nums[start];

            }

            int mid=(start+end)/2;

            if(nums[start]<=nums[mid])start=mid+1;//rotation is in the right half;
            else end=mid; //rotation is the left half
        }
        return nums[start];
    }

    public static void main(String[] args){
        int[] input={6,7,8,9,1,2,3,4,5};
        System.out.println("The minimum number in the rotated array is "+findMin(input));
    }
}
