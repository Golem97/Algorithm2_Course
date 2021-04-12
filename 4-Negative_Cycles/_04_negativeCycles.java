// Created by Or Kadrawi
public class _04_negativeCycles {
	static int inf = 1000000;

	public static void main(String[] args) {
		
		
		System.out.println("    v2");
		System.out.println("    /\\");
		System.out.println("  1/  \\-5");
		System.out.println("  /    \\");
		System.out.println("v1------v3");
		System.out.println("    2");
		int[][] mat = {{0,1,inf},
						{inf,0,-5},
						{2,inf,0}};
		String[][] path = InitPath(mat.length, mat);

		floyd_warshall(mat, path);
		FixPath(path);
		Print(mat);
		int indexOfNegativeCycle=IsNegativeCycle(mat);
		if (indexOfNegativeCycle != -1) {
			System.out.println("There is negative cycle!");
			System.out.println("Example: "+path[indexOfNegativeCycle][indexOfNegativeCycle]);
		}
		else
		{
			System.out.println("There isn't negative cycle!");
		}
	}
	private static int IsNegativeCycle(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
				if (mat[i][i]<0)
					return i;
		}
		return -1;
	}
	private static void floyd_warshall(int[][] mat, String[][] path) {
		int size = mat.length;
		for (int k = 0; k < size; k++) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (mat[i][k]!= inf &&  mat[k][j]!= inf)
						if (mat[i][k] + mat[k][j] < mat[i][j])
						{
							mat[i][j] = mat[i][k] + mat[k][j];
							path[i][j] = path[i][k] + "->" + path[k][j];
						}
				}
			}
		}
	}
	private static void Print(int[][] mat)
	{
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print(mat[i][j]+"\t");
			}
			System.out.println();
		}
	}
	private static String[][] InitPath(int size, int[][] mat) {
		String[][] path = new String[size][size];
		for (int i = 0; i < path.length; i++) {
			for (int j = 0; j < path.length; j++) {
				if (mat[i][j] != inf)
					path[i][j] = (i+1) + "";
			}
		}
		return path;
	}
	private static void FixPath(String[][] path) {
		for (int i = 0; i < path.length; i++) {
			for (int j = 0; j < path.length; j++) {
				path[i][j] += "->"+(j+1);
			}
		}
	}
}