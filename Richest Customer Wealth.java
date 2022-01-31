
class Solution {
    public static int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] person: accounts){
            int sum = 0;
            for (int i = 0; i < person.length; i++){
                sum += person[i];
            }
            if (sum > max){
                max = sum;
            }

        }
        return max;
    }
}

public class RichestCustomerWealth {
    public static void main(String[] args) {
        //String s = "codeleet";
        int[][] accounts = new int[][]{{9, 2, 3}, {3, 4, 1}, {8, 2, 5}};
        int result = Solution.maximumWealth(accounts);
        System.out.println(String.valueOf(result));
    }
}
