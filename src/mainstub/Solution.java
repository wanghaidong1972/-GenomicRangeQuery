package mainstub;

public class Solution {
	public int[] DNA(String S, int[] P, int[] Q) {
		int[] resultarr = new int[P.length];
		Gene[] genes = new Gene[S.length()];
		int[] inarr = Str2arr(S);

		genes[0] = new Gene();

		for (int i = 0; i < genes.length; i++) {
			if (i > 0) {
				genes[i] = genes[i - 1].clone();
			}

			switch (inarr[i]) {
			case 1:
				genes[i].A++;
				genes[i].selfA++;
				break;
			case 2:
				genes[i].C++;
				genes[i].selfC++;
				break;
			case 3:
				genes[i].G++;
				genes[i].selfG++;
				break;
			case 4:
				genes[i].T++;
				genes[i].selfT++;
				break;
			default:
				break;
			}
		}

		Gene tmpleft; 
		Gene tmpright;
		int tmpcenter;
		
		for (int i = 0; i < P.length; i++) {
			tmpleft = genes[P[i]];
			tmpright = genes[Q[i]];
			
			if(P[i] == Q[i]) {
				tmpcenter = 4;
			}else {
				tmpcenter = tmpright.minus(tmpleft).min();
			}
			
			resultarr[i] = Math.min(tmpleft.selfmin(),Math.min(tmpcenter,tmpright.selfmin()));
		}
		return resultarr;
	}

	public int[] Str2arr(String instr) {
		int[] resultarr = new int[instr.length()];

		for (int i = 0; i < instr.length(); i++) {
			char charat = instr.charAt(i);
			switch (charat) {
			case 'A':
				resultarr[i] = 1;
				break;
			case 'C':
				resultarr[i] = 2;
				break;
			case 'G':
				resultarr[i] = 3;
				break;
			case 'T':
				resultarr[i] = 4;
				break;
			}
		}

		return resultarr;
	}

	class Gene {
		public int A, C, G, T = 0;
		public int selfA, selfC, selfG, selfT = 0;

		public void Gene() {
		}

		public Gene minus(Gene right) {
			Gene result = new Gene();
			Gene left = this;
			result.A = left.A - right.A;
			result.C = left.C - right.C;
			result.G = left.G - right.G;
			result.T = left.T - right.T;
			return result;
		}

		public int min() {
			if (A > 0) {
				return 1;
			} else if (C > 0) {
				return 2;
			} else if (G > 0) {
				return 3;
			} else if (T > 0) {
				return 4;
			}
			return -1;
		}
		
		public int selfmin() {
			if (selfA > 0) {
				return 1;
			} else if (selfC > 0) {
				return 2;
			} else if (selfG > 0) {
				return 3;
			} else if (selfT > 0) {
				return 4;
			}
			return -1;
		}

		@Override
		public Gene clone() {
			Gene result = new Gene();

			Gene left = this;
			result.A = left.A;
			result.C = left.C;
			result.G = left.G;
			result.T = left.T;

			return result;
		}
	}
}
