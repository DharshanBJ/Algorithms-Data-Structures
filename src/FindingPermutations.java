import java.util.ArrayList;
import java.util.List;

public class FindingPermutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>result=new ArrayList<List<Integer>>();
        backtrack(nums,result,new ArrayList<>());
        return result;
    }

    public static void backtrack(int[] nums, List<List<Integer>> result, ArrayList<Integer> tempList){
        if(tempList.size()==nums.length){
            result.add(new ArrayList<>(tempList));
        }else{
            for(int i=0;i<nums.length;i++){
                if(tempList.contains(nums[i]))continue;
                tempList.add(nums[i]);
                backtrack(nums,result,tempList);
                tempList.remove(tempList.size()-1);
            }
        }
    }

    public static void main(String[] args){
        int[] input={1,2,3};
        List<List<Integer>> answer=permute(input);
        for(int i=0;i<answer.size();i++){
            System.out.println(answer.get(i));
        }
    }
}
