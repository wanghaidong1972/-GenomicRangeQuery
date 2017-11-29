package mainstub;

import java.util.Arrays;

public class Mainstub {

    public static void main(String[] args) {

        int[] P1 = {1, 2, 3};
        int[] Q1 = {4, 5, 6};
        int[] P2 = {2, 5, 0};
        int[] Q2 = {4, 5, 6};
        int[] P3 = {1, 2, 0};
        int[] Q3 = {3, 4, 3};

        Solution sol = new Solution();
        //System.out.println("expect [] and got " + Arrays.toString(sol.Str2arr("ACGTTGAC")));

        //System.out.println("expect [] and got " + Arrays.toString(sol.DNA("ACGTTGAC",P1,Q1)));

//		System.out.println("expect [2,4,1] and got " + Arrays.toString(sol.DNA("CAGCCTA",P2,Q2)));
//		System.out.println("expect [1,2,1] and got " + Arrays.toString(sol.DNA("CAGCCTA",P3,Q3)));
//
//		System.out.println("expect true and got " + sol.NoCommonFactor(7,111));
//        System.out.println("expect false and got " + sol.NoCommonFactor(14,21));
//        System.out.println("expect true and got " + sol.NoCommonFactor(1090234,134572341));
//        System.out.println("expect true and got " + sol.NoCommonFactor(62340234,1234341741));
//
        System.out.println("expect false and got " + sol.CommonFactors(62340234, 1234341741));
        System.out.println("expect true and got " + sol.CommonFactors(48, 162));
        System.out.println("expect false and got " + sol.CommonFactors(48, 150));
        System.out.println("expect false and got " + sol.CommonFactors(260134875, 105));
        System.out.println("expect true and got " + sol.CommonFactors(260134875, 780404625));
        System.out.println("expect false and got " + sol.CommonFactors(780404625, 105));
        System.out.println("expect false and got " + sol.CommonFactors(780404625, 17325));
        System.out.println("expect true and got " + sol.CommonFactors(780404625, 15015));
        System.out.println("expect true and got " + sol.CommonFactors(9, 3));
        System.out.println("expect false and got " + sol.CommonFactors(6, 3));
//          System.out.println("expect 15015 and got " + sol.maxcommondivisor(15015,780404625));
//        System.out.println("expect 17325 and got " + sol.maxcommondivisor(17325,780404625));
//        System.out.println("expect 15 and got " + sol.maxcommondivisor(210,2145));
//        System.out.println("expect 1 and got " + sol.maxcommondivisor(7,9));
//        System.out.println("expect 15 and got " + sol.maxcommondivisor(17325,780402345));
//        System.out.println("expect 2 and got " + sol.maxcommondivisor(25371346,780402346));

    }

}
