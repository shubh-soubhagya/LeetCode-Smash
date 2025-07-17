
public class twosum {

    public static void main(String[] args) {
        int nums[] = {3,2,4,2,4};
        int target = 6;

        int[] result = findtwosum(nums, target);
        System.out.println("["+result[0]+","+result[1]+"]");

    }

    public static int[] findtwosum(int[] nums, int target){

        for(int i=0; i<nums.length; i++){
            for(int j =1; j<nums.length; j++){
                if(nums[i]+nums[j]==target){return new int[]{i,j}; }
            }

        }
        return new int[]{-1,-1};
    }
    
}
