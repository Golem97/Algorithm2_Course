package best;

public class CheckMatrixWalkJava {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int size = 10000, sum = 0;
		int[][]mat = new int[size][size];
		long start = System.currentTimeMillis();
		for (int i=0; i<size; i++){
			for (int j=0; j<size; j++){
				sum = sum + mat[i][j];
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("time i-j = "+(end-start)+" ms");
		
		start = System.currentTimeMillis();
		for (int j=0; j<size; j++){
			for (int i=0; i<size; i++){
				sum = sum + mat[i][j];
			}
		}
		end = System.currentTimeMillis();
		System.out.println("time j-i = "+(end-start)+" ms");
	}

}
/*
time i-j = 195 ms
time j-i = 10470 ms
*/