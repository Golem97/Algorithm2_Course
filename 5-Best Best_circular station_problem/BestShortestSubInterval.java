package best;

public class BestShortestSubInterval {
	public static int bestShortestSubInterval2(int[] a){
		int i=0;
		while (i<a.length && a[i]<=0) {i++;}
		if (i == a.length){// a[i]<=0, i=1,...,a.length
			return 1;
		}
		else{
			int  endMax = i+1, count = 0,  bestCount = 1;
			double maxSum=a[i], sum = 0;
			while(i<a.length){
				sum = sum + a[i];
				count++;
				if (sum <= 0){
					sum = 0;
					count = 0;
				}
				else if (sum > maxSum){
					maxSum = sum;
					endMax = i+1;
					bestCount = count;
				}
				else if(sum == maxSum){
					if (count < bestCount){
						bestCount = count;
						endMax = i+1;
					}
				}
				i++;
			}
			System.out.println("maxSum = "+maxSum+", start = "+(endMax-bestCount));
			return bestCount;
		}
	}
	public static void main(String[] args) {
		int[]a1 = {1,2,3,-50,2,4,-34,4};//2
		int[]a2 = {1,2,3,-50,2,4,-34,6};// 1
		int[]a3 = {3,3,-50,1,2,3,-34,4};// 2
		int[]a4 = {1,2,2,1,-50,2,4,-34,1,2,3};//2
		int[]a5 = {-1,-2,-2,-1,-50};// 1
		int[]a6 = {6,-50,1,2,3,-34,3,3};//1
		int a7[] = {1,1,-2,3,1,4,2,4,-3,-4,3,-1,2,0,2,3,2,0,3,-2};//16
		int []a8 = {5,6,9,12,3};//5

		System.out.println("len1 = " + bestShortestSubInterval2(a1));
		System.out.println("len2 = " + bestShortestSubInterval2(a2));
		System.out.println("len3 = " + bestShortestSubInterval2(a3));
		System.out.println("len4 = " + bestShortestSubInterval2(a4));
		System.out.println("len5 = " + bestShortestSubInterval2(a5));
		System.out.println("len6 = " + bestShortestSubInterval2(a6));
		/////
		System.out.println("len7 = " + bestShortestSubInterval2(a7));
		System.out.println("len7 = " + bestShortestSubInterval2(a8));
	}

}
