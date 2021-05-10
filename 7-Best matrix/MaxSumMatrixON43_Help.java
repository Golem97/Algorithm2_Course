package maxSumSubmatrix;
import best.*;
public class MaxSumMatrixON43_Help {
	static int[][] helpMatrix(int[][]mat){//O(N^2)
		int[][]help = new int[mat.length][mat[0].length];
		//first column
		help[0][0] = mat[0][0];
		for (int i=1; i<help.length; i++) { 
			help[i][0] = help[i-1][0] + mat[i][0];
		}
		//first row
		for(int j=1; j<help[0].length; j++) {
			help[0][j] = help[0][j-1] + mat[0][j];
		}
		for (int i = 1; i < help.length; i++) {
			for (int j = 1; j < help[0].length; j++) {
				help[i][j] = mat[i][j] + help[i-1][j] + help[i][j-1] - help[i-1][j-1];
			}
		}
		return help;
	}
	static int sum_ij_pq(int help[][], int i, int j, int p, int q){//O(1)
		int t = 0;
		if (i==0 && j==0){
			t = help[p][q];
		}
		else if (i==0 && j>0){
			t = help[p][q] - help[p][j-1];  
		}
		else if (i>0 && j==0){
			t = help[p][q] - help[i-1][q]; 
		}
		else{
			t = help[p][q] - help[p][j-1] - help[i-1][q] + help[i-1][j-1];
		}
		return t;
	}
	public static int matrixSuperBestON4(int[][] mat){//O(N^4)
		int[][] help = helpMatrix(mat);
		MyLibrary.printIntMatrix(help);
		int max = help[0][0], t, iStart=0, jStart=0, iEnd=0, jEnd=0;
		for (int i=0; i<help.length; i++){
			for (int j=0; j<help[0].length; j++){
				for(int p=i; p<help.length; p++ ){
					for(int q=j; q<help[0].length; q++ ){
						t = sum_ij_pq(help, i, j, p, q);
						if (t>max){
							max = t;
							iStart=i; jStart=j; iEnd=p; jEnd=q;
						}
					}
				}
			}
		}
		System.out.println("maxSum = " + max + ", iStart=" + iStart+", jStart="+jStart+", iEnd="+iEnd+", jEnd="+jEnd);
		return max;
	}
	public static int matrixSuperBestON3(int[][] mat){//O(N^3)
		int[][] help = helpMatrix(mat);
		MyLibrary.printIntMatrix(help);
		int max = help[0][0], t=0, iStart=0, jStart=0, iEnd=0, jEnd=0;
		for (int i=0; i<mat.length; i++) {
			for (int p=i; p<mat.length; p++) {
				int j = 0;
				for (int q=0; q<mat[0].length; q++) {
					t = sum_ij_pq(help, i, j, p, q);//O(1)
					if (t < 0) j = q + 1;
					else if (t>max){
						max = t;
						iStart=i; jStart=j; iEnd=p; jEnd=q;
					}
				}
			}
		}
		System.out.println("maxSum = " + max + ", iStart=" + iStart+", jStart="+jStart+", iEnd="+iEnd+", jEnd="+jEnd);
		return max;
	}

	public static void main(String[] args) {
		//sumMax=20,  iStart=2, jStart=0, iEnd=2, jEnd=4
		//int mat[][] = {{-10,5,-4,3,4},{4,-100,10,-30,5},{3,2,8,1,6},{-5,2,-20,3,1}};//sum=20
		//int mat[][] = {{1,2,3},{-3,4,5},{-1,-2,-4}};//sum=14
		//////////
		//maxSum = 15, iStart=1, jStart=0, iEnd=3, jEnd=1
		int mat[][] = {{0,-2,-7,0},{9,2,-6,2},{-4,1,-4,1},{-1,8,0,-2}};//sum=15
		//int mat[][] = {{2,10,8,3},{-8,14,-1,4},{-6,-1,8,-2},{1,8,7,3},{8,2,-10,-8}};//sumMax=61, iStart=0, jStart=1, iEnd=3, jEnd=3

		matrixSuperBestON4(mat);
		System.out.println();
		matrixSuperBestON3(mat);
	}

}