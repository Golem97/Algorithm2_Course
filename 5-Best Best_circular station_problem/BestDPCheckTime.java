package best;

public class BestDPCheckTime {

	//O(N^2) mat[i][j] = mat[i][j-1] + mat[j][j]
	public static int bestDP1(int[]a){
		int n = a.length;
		int [][]mat = new int[n][n];
		int sumMax=a[0], beginMax=0, endMax=0;
		for (int i=0; i<n; i++){
			mat[i][i] = a[i];
			if (sumMax < a[i]){
				sumMax = a[i];
				beginMax = endMax = i;
			}
		}
		for (int i=0; i<n; i++){
			for (int j=i+1; j<n; j++){
				mat[i][j] = mat[i][j-1] + mat[j][j];
				if (sumMax < mat[i][j]){
					sumMax = mat[i][j];
					beginMax = i;
					endMax = j;
				}
			}
		}
		return sumMax;
	}
	//O(N^2) mat[i][j] = mat[i+1][j] + mat[i][i];
	public static int bestDP2(int[]a){
		int n = a.length;
		int [][]mat = new int[n][n];
		int sumMax=a[0], beginMax=0, endMax=0;
		for (int i=0; i<n; i++){
			mat[i][i] = a[i];
			if (sumMax < a[i]){
				sumMax = a[i];
				beginMax = endMax = i;
			}
		}
		for (int i=n-1; i>=0; i--){
			for (int j=i+1; j<n; j++){
				mat[i][j] = mat[i+1][j] + mat[i][i];
				if (sumMax < mat[i][j]){
					sumMax = mat[i][j];
					beginMax = i;
					endMax = j;
				}
			}
		}
		return sumMax;
	}
	public static void testTime(){
		int size = 5000, loop = 100;
		long t1 = 0, t2 = 0;
		for (int i=1; i<=loop;i++){
			int arr[] = MyLibrary.randomIntegerArrayMinus(size);
			long start = System.currentTimeMillis();
			int sumMax = bestDP1(arr);
			long end = System.currentTimeMillis();
			t1 = t1 + (end-start);
			////////
			start = System.currentTimeMillis();
			sumMax = bestDP2(arr);
			end = System.currentTimeMillis();
			t2 = t2 + (end-start);
		}
		System.out.println("DP1 time = "+ t1/loop + " ms");
		System.out.println("DP2 time = "+t2/loop + " ms");
	}
	public static void main(String[] args) {
		testTime();
	}
}
/* int size = 3000, loop = 100;
DP1 time = 96 ms
DP2 time = 46 ms

    int size = 1000, loop = 100;
DP1 time = 8 ms
DP2 time = 4 ms

	int size = 5000, loop = 100;
DP1 time = 392 ms
DP2 time = 244 ms

*/