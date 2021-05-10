package MaxSumSubMatrix;

import Huffman.MyLibrary;

public class MaxSumMatrixON3 {
	///////
	public static int[][] helpRows(int[][]mat){
		int[][]help = new int[mat.length][mat[0].length+1];// the first column of help contains 0 only
		for (int i=0; i<help.length; i++) help[i][1] = mat[i][0];
		for (int i=0; i<help.length; i++){
			for (int j = 2; j < help[0].length; j++) {
				help[i][j] = help[i][j-1] + mat[i][j-1];
			}
		}
		return help;
	}
	public static void matrixNewBestON3(int[][]mat){//O(N^3)
		int[][]help = helpRows(mat);
		MyLibrary.printMatrix(help);
		int rows = help.length, cols = help[0].length;
		int sum=0, count = 0, countMax = 0, jStart = 0, jEnd = 0, iEnd = 0;
		int maxSum = mat[0][0];
		for (int jb = 0; jb < cols; jb++) {
			for (int je = jb+1; je < cols; je++) {
				sum = 0; 
				count = 0;
				for (int i=0; i<rows; i++){
					int val = help[i][je] - help[i][jb];
					sum = sum + val;
					count++;
					if (sum < 0){
						sum = 0;
						count = 0;
					}
					else{
						if (sum > maxSum){
							maxSum = sum;
							countMax = count;
							jStart = jb;
							jEnd = je-1;
							iEnd = i;
						}
					}
				}
			}
		}
		System.out.println("maxSum="+maxSum+", jStart="+jStart+", jEnd="+jEnd+", iStart="+(iEnd+1-countMax)+", iEnd="+iEnd);
	}
	public static void main(String[] args) {
		//sumMax=20,  iStart=2, jStart=0, iEnd=2, jEnd=4
		//int mat[][] = {{-10,5,-4,3,4},{4,-100,10,-30,5},{3,2,8,1,6},{-5,2,-20,3,1}};
		// maxSum=14, iStart=0, jStart=1, iEnd=1, jEnd=2
		int mat[][] = {{1,2,3},{-3,4,5},{-1,-2,-4}};
		//int mat[][] = {{1,2,3},{4,5,6},{7,8,9}};
		//int[][]mat = {{-2,1},{1,3}};
		//int[][]mat = {{1,2},{4,-3}};
		//int mat[][] = {{2,10,8,3},{-8,14,-1,4},{-6,-1,8,-2},{1,8,7,3},{8,2,-10,-8}};//sumMax=61, iStart=0, jStart=1, iEnd=3, jEnd=3
		matrixNewBestON3(mat);
	}

}