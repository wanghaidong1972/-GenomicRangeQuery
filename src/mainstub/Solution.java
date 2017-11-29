package mainstub;

import java.util.ArrayList;
import java.util.Comparator;

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

            if (P[i] == Q[i]) {
                tmpcenter = 4;
            } else {
                tmpcenter = tmpright.minus(tmpleft).min();
            }

            resultarr[i] = Math.min(tmpleft.selfmin(), Math.min(tmpcenter, tmpright.selfmin()));
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

    class UserComparator implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {

            try {
                o1 = (Numbers) o1;
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                o2 = (Numbers) o2;
            } catch (Exception e) {
                e.printStackTrace();
            }

            ArrayList<Integer> left = ((Numbers) o1).primefactors;
            ArrayList<Integer> right = ((Numbers) o2).primefactors;

            while (left.iterator().hasNext()) {
                if (!right.iterator().hasNext()) {
                    return 1;
                }
                int leftnext = left.iterator().next();
                int rightnext = left.iterator().next();
            }

            if (right.iterator().hasNext()) {
                return -1;
            } else {
                return 0;
            }
        }


    }

    class Numbers implements Comparable {
        public int originindex;  // to store the origin index
        public int truenumber;  // to store the origin number which saved at position of origin index
        public int sortedindex; // to store the sorted index number
        public ArrayList<Integer> primefactors;  // store count of prime factors in asced order,like [2] = 2,[3] = 4

        @Override
        public int compareTo(Object o) {
            Numbers others = (Numbers) o;
            return this.truenumber - others.truenumber;
        }
    }

    class Factors implements Comparable {
        public int factornumber;
        public int factorcount;

        @Override
        public int compareTo(Object o) {
            Factors other = (Factors) o;

            if (this.factornumber < ((Factors) o).factornumber) {
                return -1;
            } else if (this.factornumber > ((Factors) o).factornumber) {
                return 1;
            }
            return this.factorcount - other.factorcount;
        }
    }

    public boolean CommonFactorsold(int a, int b) {
        int tmp = a;
        if (a > b) { //swap a, b to let a<b
            a = b;
            b = tmp;
        } else if (a == b) {
            return true;
        }

        int mod = b % a;
        if (mod == 0) {
            int quotient = b / a;
            int innermod = 0;

            if ((a > quotient) && (a % quotient) == 0) {
                return true;
            } else {
                return CommonFactors(a, quotient);
            }
        }

        if (NoCommonFactor(a, mod)) {
            return false;
        }

        return (CommonFactors(mod, a));
    }

    public int Oujilide(int[] A, int[] B) {
        int counter = 0;
        for (int i = 0; i< A.length ; i++) {
            if (CommonFactors(A[i],B[i])) {
                counter ++;
            }
        }
        return counter;
    }

    public boolean CommonFactors(int a, int b) {
        int tmp = a;
        if (a > b) { //swap a, b to let a<b
            a = b;
            b = tmp;
        } else if (a == b) {
            return true;
        }

        if (a == 1) {
            return false;
        }

        int maxcommon = maxcommondivisor(a, b);
        if (maxcommon == 1) {
            return false;
        }

        int diva = a ;
        int divb = b ;

        int tmpcommon = maxcommon;

        while (true) {
            tmpcommon = maxcommondivisor(diva,tmpcommon);
            if (tmpcommon == 1) {
                break;
            }
            diva = diva / tmpcommon;
            if (diva == 1) {
                break;
            }
        }

        if( (tmpcommon ==1 ) ||(diva != 1) ){
            return false;
        }

        tmpcommon = maxcommon;
        while (true) {
            tmpcommon = maxcommondivisor(divb,tmpcommon);
            if (tmpcommon == 1) {
                break;
            }
            divb = divb / tmpcommon;
            if (divb == 1) {
                break;
            }
        }

        if( (tmpcommon ==1 ) ||(divb != 1) ){
            return false;
        }

//        if ((diva > maxcommon) || (divb > maxcommon)) {
//            return false;
//        }
//        if ((diva % maxcommon != 0) || (divb % maxcommon != 0)) {
//            return false;
//        }

        return true;

    }

    public boolean NoCommonFactor(int a, int b) {
        int tmp = a;
        if (a > b) { //swap a, b to let a<b
            a = b;
            b = tmp;
        } else if (a == b) {
            return false;
        }

        if (a == 1) {
            return true;
        }

        int diff = b - a;
        if (diff == 1) {
            return true;
        }

        int remainder = b % a;
        if (remainder == 0) {
            return false;
        }
        return NoCommonFactor(a, remainder);
    }

    public int maxcommondivisor(int a, int b) {
        int tmp = a;
        if (a > b) { //swap a, b to let a<b
            a = b;
            b = tmp;
        } else if (a == b) {
            return a;
        }

        if (a == 1) {
            return a;
        }

        int diff = b - a;
        if (diff == 1) {
            return 1;
        }

        int remainder = b % a;
        if (remainder == 0) {
            return a;
        }
        return maxcommondivisor(a, remainder);
    }
}
