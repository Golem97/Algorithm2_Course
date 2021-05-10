package MaxSumSubMatrix;

//import java.util.Arrays;
// n = numOfRows, m = numOfColumns 
// n(n+1)/2 - number of bands, 
// n*m - number of band elements - O(n^2*m)
//O(m) - best, complexity = O(n^2*n*m+m)=O(n^3*m)
public class MaxSumMatrixON4A {

	public static int maxSumMatrixON4A(int[][] mat){
		int max = mat[0][0];
		for (int i0 = 0; i0 < mat.length; i0++) { //n(n+1)/2
			for (int i1 = i0; i1 < mat.length; i1++) {
				int[] sumBand = sumOfBand(mat, i0, i1); //O(n^3*m)
				//System.out.println(Arrays.toString(sumBand)); 
				int ans = Best2.best(sumBand)[3];// O(m)
				if(ans > max) max = ans;
			}
		}
		return max;
	}
	public static int[] sumOfBand(int[][]mat, int i0, int i1){
		int sumBand[] = new int[mat[0].length];
		for (int j = 0; j < mat[0].length; j++) {
			for (int i = i0; i <= i1; i++) {
				sumBand[j] = sumBand[j] + mat[i][j];
			}
		}
		return sumBand;
	}
	
	public static void main(String[] args) {
		int[][] m = {{1,2,3,6},{2,-3,1,2},{5,2,7,0}};
		int max = maxSumMatrixON5(m);
		System.out.println(max);
	}

}