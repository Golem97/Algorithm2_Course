package MaxSumSubMatrix;

import java.util.Arrays;

public class MaxSumSubMatrixDin3DStatic {

	public static void maxSumSubMatrixDin3D(int[][]mat){//O(N^3)
		int rows = mat.length, cols = mat[0].length;
		int [][][]sumMat = new int[cols][cols][rows];
		int sumMax=mat[0][0], iStart=0, iEnd=0, jStart=0, jEnd=0;
		int t[] = new int[rows];
		
		for (int i=0; i<cols; i++){
			for (int k=0; k<rows; k++){
				t[k] = sumMat[i][i][k] = mat[k][i];
			}
			int[]ind = Best2.best(t);
			if (ind[3] > sumMax){
				sumMax = ind[3];
				iStart = ind[0];  iEnd = ind[1];
				jStart = i; jEnd = i+1;
			}
		}
		MyLibrary.print3DMatrix(sumMat);
		for (int i=0; i<cols; i++){
			for (int j=i+1; j<cols; j++){
				for (int k=0; k<rows; k++){
					t[k]=sumMat[i][j][k]=sumMat[i][j-1][k]+sumMat[j][j][k];
				}
				System.out.println(Arrays.toString(t));
				int ind[] = Best2.best(t);
				if (ind[3] > sumMax){
					sumMax = ind[3];
					iStart = ind[0];  iEnd = ind[1]-1;
					jStart = i; jEnd = j;
				}
			}
		}
		System.out.println("iStart=" + iStart+", jStart="+jStart+", iEnd="+iEnd+", jEnd="+jEnd);
		System.out.println("sum max = "+sumMax);
		MyLibrary.print3DMatrix(sumMat);
	}
	public static void main(String[] args) {
		//int mat[][] = {{2,10,8,3},{-8,14,-1,4},{-6,-1,8,-2},{1,8,7,3},{8,2,-10,-8}};//sumMax=61, iStart=0, jStart=1, iEnd=3, jEnd=3
		//int mat[][] = {{1,2,-1},{-1,0,1},{1,-5,-2}}; // sumMax=3, iStart=0, jStart=0, iEnd=0, jEnd=1
		//int mat[][] = {{2,-8,-6,1,8},{10,14,-1,8,2},{8,-1,8,7,-10},{3,4,-2,3,-8}};;//sumMax=61, iStart=1, jStart=0, iEnd=3, jEnd=3
		//int mat[][] = {{1,2,-1},{-1,0,1},{1,-5,-2},{4,-1,-1}};;//sumMax=5, iStart=0, jStart=0, iEnd=3, jEnd=0
		//int mat[][] = {{-10,5,-4,3,4},{4,-100,10,-30,5},{3,2,8,1,6},{-5,2,-20,3,1}};//sumMax=20,  iStart=2, jStart=0, iEnd=2, jEnd=4
		int mat[][] = {{1,2,3},{-3,4,5},{-1,-2,-4}};//sum = 14
		MyLibrary.printMatrix(mat);		
		maxSumSubMatrixDin3D(mat);
	}
}