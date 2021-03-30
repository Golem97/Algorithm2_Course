package fw_bottle;

public class WeightsOnVertices_Edges {

	static int infinity = Integer.MAX_VALUE;

	public static void FWAlgorithm(int mat[][]){
		int n = mat.length;
		for (int k = 0; k<n; k++){
			for (int i = 0; i<n; i++){
				for (int j = 0; j<n; j++){
					if (mat[i][k]!=infinity && mat[k][j]!=infinity){
						if (mat[i][j] > mat[i][k]+mat[k][j]){
							mat[i][j] = mat[i][k]+mat[k][j];
						}
					}
				}
			}
		}
	}
	
	public static int[][] toEdgesWeights(int[][] weightsEdges, int[] weightsVertices){
		int[][]ans = new int[weightsEdges.length][weightsEdges[0].length];
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[0].length; j++) {
				if (weightsEdges[i][j] != infinity){
					ans[i][j] = 2*weightsEdges[i][j] + weightsVertices[i] + weightsVertices[j];
				}
				else ans[i][j] = infinity;
			}
		}
		return ans;
	}
	public static int[][] edge2VertWeights(int[] vertexWeight, int matWEdges[][]){
		int n = matWEdges.length;
		int[][] matWVert = new int[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if (matWEdges[i][j]!=infinity)
					matWVert[i][j] = (matWEdges[i][j] + vertexWeight[i] + vertexWeight[j])/2;
				else matWVert[i][j] = infinity;
			}
		}
		return matWVert;
	}

	public static int[][] toSourceWeights(int[][] weightsEdges, int[] weightsVertices)	{
		int[][]m = toEdgesWeights(weightsEdges, weightsVertices);
		printMatrix(m);
		System.out.println();
		FWAlgorithm(m);
		int ans[][] = edge2VertWeights(weightsVertices, m);
		return ans;
	}
	public static int[][] initB3(){
		int [][] mat = {{0,4,5}, 
						{4,0,2},
						{5,2,0}};

		return mat;	
	}
	public static int[][] initB5(){
		int [][] mat = {{0,5,12,infinity}, 
				{5,0,infinity,2},
				{12,infinity,0,2},
				{infinity,2,2,0}};

		return mat;	
	}
	public static int[][] initB6(){
		int [][] mat={{0, 10,2,20,infinity}, 
				{10,0, infinity,12,1},
				{2,infinity,0, 1, infinity },
				{20,12,1,0,8},
				{infinity,1,infinity,8,0}};
		return mat;	
	}
	public static int[][] initB7(){
		int [][] mat = {{0, infinity, infinity,20,1}, 
				   {infinity,0, infinity,6,4},
				   {infinity, infinity,0,3,2},
				   {20,6,3,0,infinity},							                
			       {1,4,2, infinity,0}};
		return mat;	
	}

	public static int[][] initB8(){
		int [][] mat={{0,1,1,infinity,1,infinity,infinity,infinity}, 	//0
				{1,0,infinity,1,infinity,1,infinity,infinity},		//1
				{1,infinity,0,1,infinity,infinity,1,infinity},	      //2
				{infinity,1,1,0,infinity,infinity,infinity,1}, 		//3
				{1,infinity, infinity, infinity,0,1,1,infinity},	//4
				{infinity,1,infinity,infinity,1,0,infinity,1},		//5
				{infinity,infinity,1,infinity,1,infinity,0,1},		//6
				{infinity,infinity,infinity,1,infinity,1,1,0}};		//7
		return mat;	
	}
	public static void printMatrix(int[][] mat){
		for(int i=0; i<mat.length; i++){
			for(int j=0; j<mat[0].length; j++){
				if (i==j) System.out.print("0, ");
				else if (mat[i][j] ==infinity) System.out.print("*, ");
				else System.out.print(mat[i][j]+", ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[]w = {1,2,3,4,5};
		int[][]ans = toSourceWeights(initB7(), w);
		printMatrix(ans);
	}

}