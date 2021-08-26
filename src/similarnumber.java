public class similarnumber {

    public static int singleNumber(int[] nums) {
        int out =0;
        for (int i:nums){
            out = out ^ i ;
        }
        return out;
    }

    public static void main(String[] args) {
        System.out.println("singleN = " + singleNumber(new int[] {4,4,1,2,1,2,7:wq
}));
    }
}
