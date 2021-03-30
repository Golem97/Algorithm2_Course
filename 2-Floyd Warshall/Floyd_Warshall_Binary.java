// Created by Or Kadrawi

import java.util.ArrayList;

public class _02_Floyd_Warshall_Binary {

	public static void main(String[] args) {

//		//without path
//		int m = 1; // first bottle 
//		int n = 2; //second bottle 
//		boolean[][] T = _01_Bottles_Problem.BottlesProblem(m,n);
//		floyd_warshall(T);
//		System.out.println("Bottle1 = " + m + ", Bottle2 = " + n);
//		System.out.println("\nFloyd Warshall Matrix:");
//
//		MyFunctions.Print(T);	
//
//		System.out.println("\nIs the graph connected? : " + isConnected(T));
//
//		System.out.println("\nThere is : " + NumberOfComponents(T) + " components.");
//
//		String[] components = GetVertexInEachComponents(T);
//		for (int i = 0; i < components.length; i++) {
//			System.out.println("Component "+i+" is : " + components[i]);
//		}


//		//with path
		int m = 3; // first bottle 
		int n = 5; //second bottle 
		boolean[][] T = _01_Bottles_Problem.BottlesProblem(m,n);
		int size = T.length;
		String[][] path = InitPath(size, T, n);
		floyd_warshall(T, path);
		FixPath(path, n);
		System.out.println("Bottle1 = " + m + ", Bottle2 = " + n);

		IsExist(0,0,0,4,T,path,n);
		
		System.out.println("\nAll paths:\n");
		PrintAllPath(T, path, n);


//		System.out.println("        V4");
//		System.out.println("        /\\");
//		System.out.println("       /  \\");
//		System.out.println("      /____\\");
//		System.out.println("     V0     V5");
//		System.out.println("    V6------V3");
//		System.out.println("      |     |");
//		System.out.println("      |_____|");
//		System.out.println("     V1     V2");
//		System.out.println();
//		boolean[][] T = Init01();				
//		floyd_warshall(T);
//		
//		System.out.println("Floyd Warshall Matrix:");
//		MyFunctions.Print(T);
//
//		System.out.println("Is the graph connected? : " + isConnected(T));

//		System.out.println("\nThere is : " + NumberOfComponents(T) + " components.");
//
//		String[] components = GetVertexInEachComponents(T);
//		for (int i = 0; i < components.length; i++) {
//			System.out.println("Component "+i+" is : " + components[i]);
//		}	
//
//		ReArrangeMat(T);
//		System.out.println("\nReArrange Matrix:");
//		MyFunctions.Print(T);

	}


	private static void floyd_warshall(boolean[][] T) {
		int size = T.length;
		for (int k = 0; k < size; k++) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					T[i][j] = (T[i][k] && T[k][j]) || T[i][j];
				}
			}
		}
	}

	private static void floyd_warshall(boolean[][] T, String[][] paths) {
		int size = T.length;
		for (int k = 0; k < size; k++) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (T[i][j] == false && ((T[i][k] && T[k][j])==true))
						paths[i][j] = paths[i][k] + "->" + paths[k][j];
					T[i][j] = (T[i][k] && T[k][j]) || T[i][j];
				}
			}
		}
	}

	private static void FixPath(String[][] path, int n) {
		for (int i = 0; i < path.length; i++) {
			for (int j = 0; j < path.length; j++) {
				path[i][j] += "->("+_01_Bottles_Problem.getI(j, n)+","+_01_Bottles_Problem.getJ(j, n)+")";
			}
		}
	}


	private static void PrintAllPath(boolean[][] T, String[][] path, int n) {
		for (int i = 0; i < path.length; i++) {
			for (int j = 0; j < path.length; j++) {
				System.out.print("("+_01_Bottles_Problem.getI(i, n)+","+_01_Bottles_Problem.getJ(i, n)+")->("+_01_Bottles_Problem.getI(j, n)+","+_01_Bottles_Problem.getJ(j, n)+"):\t");
				if (T[i][j] == true)
					System.out.println(path[i][j]);
				else
					System.out.println("NO..");
			}
		}	
	}

	private static void IsExist(int i1, int j1, int i2, int j2, boolean[][] T, String[][] paths, int n) {
		int i = _01_Bottles_Problem.getIndex(i1, j1, n);
		int j = _01_Bottles_Problem.getIndex(i2, j2, n);
		System.out.println("Is Exist path from ("+i1+","+j1+") to ("+i2+","+j2+")?");
		if (T[i][j] == true)
			System.out.println("YES! "+paths[i][j]);
		else
			System.out.println("NO..");
	}

	public static boolean isConnected(boolean T[][]){

		for(int j=0; j<T[0].length; j++){
			if (T[0][j] == false)
				return false;
		}
		return true;
	}

	private static int NumberOfComponents(boolean[][] T) {
		int size = T.length;
		ArrayList<Integer> Seen = new ArrayList<Integer>();
		ArrayList<Integer> UnSeen = new ArrayList<Integer>();
		for (int i = 0; i < T.length; i++) {
			UnSeen.add(i);
		}

		int counter = 0;
		while (UnSeen.isEmpty() == false) {
			int vertex = UnSeen.get(0);
			counter++;
			for (int j = 0; j < size; j++) {
				if (T[vertex][j]==true)
				{
					Seen.add(j);
				}
			}
			UnSeen = Substract(UnSeen, Seen);
		}
		return counter;
	}

	private static String[] GetVertexInEachComponents(boolean[][] T) {
		int size = T.length, counter = 0;
		int[] components = new int[size];

		for (int i = 0; i < components.length; i++) {
			if (components[i] == 0)
			{
				counter++;
				components[i] = counter;
				for (int j = i+1; j < components.length; j++) {
					if (components[j] == 0 && T[i][j] == true)
						components[j] = counter;
				}
			}
		}

		String[] vertexInComponent = new String[counter];
		for (int i = 0; i < vertexInComponent.length; i++) {
			vertexInComponent[i] = "";
		}
		for (int i = 0; i < components.length; i++) {
			vertexInComponent[components[i]-1] += i + "\t"; 
		}

		return vertexInComponent;
	}
	private static void ReArrangeMat(boolean[][] T) {
		ReArrangeCols(T);
		Transpose(T);
		ReArrangeCols(T);
	}

	private static void Transpose(boolean[][] T) {
		boolean temp;
		for (int i = 0; i < T.length; i++) {
			for (int j = i+1; j < T.length; j++) {
				temp = T[i][j];
				T[i][j] = T[j][i];
				T[j][i] = temp;
			}
		}
	}

	private static void ReArrangeCols(boolean[][] T) {
		int start = 0, end , row = 0;
		while (start<T.length-1)
		{
			row = start;
			end = T.length-1;
			while(start<end)
			{
				while(start < T.length && T[row][start]==true)
					start++;
				if (start == T.length)
				{
					return;
				}
				while(T[row][end]==false)
					end--;
				for (int i = 0; i < T.length; i++) {
					SwapCols(T, i, start, end);

				}
				start++;
				end--;
			}
		}
	}

	private static void SwapCols(boolean[][] T, int i, int start, int end) {
		boolean temp;
		temp = T[i][start];
		T[i][start] = T[i][end];
		T[i][end] = temp;
	}

	private static ArrayList<Integer> Substract(ArrayList<Integer> UnSeen, ArrayList<Integer> Seen) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (int i = 0; i < UnSeen.size(); i++) {
			if (Seen.contains(UnSeen.get(i)) == false)
			{
				ans.add(UnSeen.get(i));
			}
		}
		return ans;
	}

	
	//        V4
	//        /\
	//       /  \
	//      /____\
	//     V0     V5
	//    V6------V3
	//      |     |
	//	    |_____|
	//     V1     V2
	//
	private static boolean[][] Init01() {
		boolean[][] T= {{false,false,false,false,true,true,false},
						{false,false,true,false,false,false,true},
						{false,true,false,true,false,false,false},
						{false,false,true,false,false,false,true},
						{true,false,false,false,false,true,false},
						{true,false,false,false,true,false,false},
						{false,true,false,true,false,false,false}};
		return T;
	}
	private static String[][] InitPath(int size, boolean[][] T, int n) {
		String[][] path = new String[size][size];
		for (int i = 0; i < path.length; i++) {
			for (int j = 0; j < path.length; j++) {
				if (T[i][j] == true)
					path[i][j] = "("+_01_Bottles_Problem.getI(i, n)+","+_01_Bottles_Problem.getJ(i, n)+")";

			}
		}
		return path;
	}


}
