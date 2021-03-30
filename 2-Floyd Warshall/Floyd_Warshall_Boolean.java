package fw_bottle;

import java.util.Arrays;
public class FloydWarshallBooleanCODE{
	public static void FWB(boolean [][] bm){
		// matrix calculation
		int n = bm.length;
		for (int k = 0; k<n; k++){
			for (int i = 0; i<n; i++){
				for (int j = 0; j<n; j++){
					bm[i][j] = bm[i][j] || (bm[i][k] && bm[k][j]);
				}
			}
		}
	}
	public static int[][] connectComponentsOfGraphBoolN2(boolean [][] mat){
		int[][]t = new int[mat.length][mat.length];
		int numComps = 1, count = 0;
		for(int i=0; i<mat.length; i++){
			for (int j = 0; j < mat.length; j++) {
				if (mat[i][j] && t[i][j]==0){
					t[i][j] = t[j][i] = numComps;
				}
			}
			if (count > 0) numComps++;
			count = 0;
		}
		return t;
	}

	public static void connectComponentsOfGraphBool(boolean [][] mat){
		// number of connected components
		// in undirected graph (square symmetric matrix)
		int n = mat.length;
		// connectComp[j] - the component number of vertex j
		int connectComp[] = new int[n];
		int numComponentes = 0;

		for(int i=0; i<mat.length; i++){
			if (connectComp[i]==0){
				numComponentes++;
				connectComp[i]=numComponentes;
			}
			for(int j=i+1; j<mat.length; j++){
				// vertex j is not defined yet   the path exists
				if (connectComp[j]==0 && mat[i][j]){
					connectComp[j] = numComponentes;
				}
			}
		}
		String vs[] = new String[numComponentes];
		for (int i=0; i<numComponentes; i++)
			vs[i] = new String();
		for (int i=0; i<n; i++){
			int index = connectComp[i] - 1;
			vs[index] = vs[index] + i + ","; 
		}
		System.out.println(Arrays.toString(connectComp));
		System.out.println("number of components = "+numComponentes);
		for (int i=0; i<numComponentes; i++)
			System.out.println("component number " + i + ", vertices: [" + vs[i].substring(0, vs[i].length()-1) + "]");
	}
	public static boolean isConnected(boolean mat[][]){//O(n^2)
		boolean ans = true;
		for(int i=0; ans && i<mat.length; i++){
			for(int j=0; ans && j<mat.length; j++){
				if (!mat[i][j]) ans = false;
			}
		}
		return ans;
	}
	public static boolean isConnectedOn(boolean mat[][]){//O(n)
		boolean ans = true;
		for(int i=0; ans && i<mat.length; i++){
			if (!mat[i][0]) ans = false;
		}
		return ans;
	}
	public static boolean[][] initB1(){
		boolean [][] mat = {{true,true,true,false}, 
							{true,true,false,true},
							{true,false,true,true},
							{false,true,true,true}};

		return mat;	
	}
	public static boolean[][] initB2(){
		boolean [][] mat = {{true,false,false,false}, 
							{false,true,true,true},
							{false,true,true,true},
							{false,true,true,true}};
		return mat;	
	}
	public static boolean[][] initB3(){
		boolean [][] mat = {{true,true,false,false}, 
							{true,true,false,false},
							{false,false,true,true},
							{false,false,true,true}};
		return mat;	
	}
	public static boolean[][] initB4(){
		boolean [][] mat = {{true,true,false}, 
							{true,true,true},
							{false,true,true}};
		return mat;	
	}
	public static boolean[][] initB5(){
		boolean [][] mat = {{true,true,false,false}, 
							{true,true,true,false},
							{false,true,true,true},
							{false,false,true,true}};
		return mat;	
	}
	public static boolean[][] initB6(){
		boolean [][] mat = {{true,true,false,false,true}, 
							{true,true,true,false,false},
							{false,true,true,true,false},
							{false,false,true,true,true},
							{true,false,false,true,true}};
		return mat;	
	}
	public static void printBoolMatrix(boolean[][] mat){
		for(int i=0; i<mat.length; i++){
			for(int j=0; j<mat[0].length; j++){
				System.out.print(mat[i][j]+", ");
			}
			System.out.println();
		}
	}
	public static void checkFWBool(){
		System.out.println("\ninit B3 ");
		boolean[][]mat = initB2();
		FWB(mat);
		printBoolMatrix(mat);
		System.out.println("is the graph connected?  " + isConnected(mat));
	}
	public static void checkComps(){
		boolean[][]mat = initB3();
		connectComponentsOfGraphBool(mat);
	}
	public static void main(String[] args) {
		checkFWBool();
	}

}