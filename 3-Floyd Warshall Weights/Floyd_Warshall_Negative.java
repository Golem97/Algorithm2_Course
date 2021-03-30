package fw_bottle;

public class FloydWarshallNegative {

	static int infinity = Integer.MAX_VALUE;
	
	public static void FWNeg(int [][] mat){
		int n = mat.length;
		// matrix building
		for (int k = 0; k<n; k++){
			for (int i = 0; i<n; i++){
				for (int j = 0; j<n; j++){
					if (mat[i][k]!=infinity && mat[k][j]!=infinity){
						mat[i][j] = Math.min(mat[i][j], mat[i][k]+mat[k][j]);
						System.out.println("k="+k+", i="+i+", j="+j+", mat["+i+","+j+"]="+mat[i][j]); 
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		int[][]mat1={{infinity,3,-10},{3,infinity,-1},{-10,-1,infinity}};
		int[][]mat={{infinity,5,-2},{5,infinity,-1},{-2,-1,infinity}};
		int[][] mat2={{0,-1,10},{-1,0,2},{10,2,0}};
		int[][]mat3={{0,infinity},{-5,0}};
		int[][]mat4={{0,-5},{-5,0}};
		int[][]mat5={{0,5,2},{5,0,-1},{2,-1,0}};
		int[][]mat6={{0,5,2},{5,0,1},{2,1,0}};
		FWNeg(mat5);
		System.out.println();
		FloydWarshallWeightsCODE.printMatrix(mat5);
	}

}