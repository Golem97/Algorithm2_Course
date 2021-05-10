package MoedBet;

public class MaxDifference {
	public static int maxDiff(int[]a) {
		return maxDiff(a, 0, a.length-1);
	}
	public static int maxDiff(int[]a, int left, int right) {
		if(left >= right) return Integer.MIN_VALUE;
		int mid = (right+left)/2;
		int leftDiff = maxDiff(a, left, mid);
		int rightDiff = maxDiff(a, mid+1, right);
		int minLeft = min(a, left, mid);
		int maxRight = max(a, mid+1, right);
		int diff = maxRight - minLeft;
		return Math.max(diff, Math.max(leftDiff,rightDiff));
	}
	public static int min(int[]a, int i, int j) {
		int min = a[i];
		for (int k = i; k <= j; k++) {
			if (a[k] < min) min = a[k];
		}
		return min;
	}
	public static int max(int[]a, int i, int j) {
		int max = a[i];
		for (int k = i; k <= j; k++) {
			if (a[k] > max) max = a[k];
		}
		return max;
	}
/* The function assumes that there are at least two
    elements in array.
    The function returns a negative value if the array is
    sorted in decreasing order.
    Returns 0 if elements are equal  */
	public static int maxDifferrence(int arr[]) {
	 int n = arr.length;
     int maxDiff = arr[1] - arr[0];
     int min = arr[0];
     for (int i = 1; i < n; i++) {
         if (arr[i] - min > maxDiff)
        	 maxDiff = arr[i] - min;
         if (arr[i] < min)
             min = arr[i];
     }
     return maxDiff;
 }

	public static void main(String[] args) {
		int [] a = { 12, 5, 1, 7, 3, 9, 5};
		int [] a1 = { 22,2, 12, 5, 4, 7, 3, 19, 5};
		int [] a2 = { 2, 5, 1, 7, 3, 9, 15};
		int [] a3 = { 1, 2, 3, 4, 10};
		int [] a4 = { 8, 5, 2, 1};
		int [] a5 = { 8, 7, 5, 1};
		int [] a6 = {4, 1};
		System.out.print(maxDifferrence(a)+", ");
		System.out.print(maxDifferrence(a1)+", ");
		System.out.print(maxDifferrence(a2)+", ");
		System.out.print(maxDifferrence(a3)+", ");
		System.out.print(maxDifferrence(a4)+", ");
		System.out.print(maxDifferrence(a5)+", ");
		System.out.print(maxDifferrence(a6)+", ");
		System.out.println();
		System.out.print(maxDiff(a)+", ");
		System.out.print(maxDiff(a1)+", ");
		System.out.print(maxDiff(a2)+", ");
		System.out.print(maxDiff(a3)+", ");
		System.out.print(maxDiff(a4)+", ");
		System.out.print(maxDiff(a5)+", ");
		System.out.print(maxDiff(a6)+", ");
		System.out.println();
	}
// output: 8, 17, 14, 3, -1, -1, 

}