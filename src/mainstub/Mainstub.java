package mainstub;

import java.util.Arrays;

public class Mainstub {

	public static void main(String[] args) {
		
		int[] P1 = {1,2,3};
		int[] Q1 = {4,5,6};
		int[] P2 = {2,5,0};
		int[] Q2 = {4,5,6};
		int[] P3 = {1,2,0};
		int[] Q3 = {3,4,3};
		
		Solution sol = new Solution();
		//System.out.println("expect [] and got " + Arrays.toString(sol.Str2arr("ACGTTGAC")));
		
		//System.out.println("expect [] and got " + Arrays.toString(sol.DNA("ACGTTGAC",P1,Q1)));
		
		System.out.println("expect [2,4,1] and got " + Arrays.toString(sol.DNA("CAGCCTA",P2,Q2)));
		System.out.println("expect [1,2,1] and got " + Arrays.toString(sol.DNA("CAGCCTA",P3,Q3)));
		
	}

}
