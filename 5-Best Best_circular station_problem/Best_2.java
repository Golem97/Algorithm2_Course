package MaxSumSubMatrix;

public class Best2 {
	public static int[] best(int[] a){
		int i=0;
		while (i<a.length && a[i]<=0) {i++;}
		if (i == a.length){
			int index = 0;
			for (int j=0; j<a.length; j++){
				if (a[j] > a[index]) index = j;
			}
			int[]ans = {index, index+1, 1, a[index]};
			return ans;
		}
		else{
			int sum=0, maxSum=a[i], beginMax = i, endMax = i+1, count = 0, countMax = 1;
			while(i<a.length){
				sum = sum + a[i];
				count++;
				if (sum < 0){
					sum = 0;
					count = 0;
				}
				else if (sum > maxSum){
					maxSum = sum;
					endMax = i+1;
					countMax = count;
				}
				i++;
			}
			beginMax = endMax - countMax;
			int[]ans = {beginMax, endMax, countMax, maxSum};
			//printBest(a, ans);
			return ans;
		}
	}
	public static int[] bestCycle(int[] a){
		int[] ans1 = best(a);
		int sum1 = ans1[3];
		if (sum1<0){
			return ans1;
		}
		int t[] = new int[a.length];
		int sumA = 0;
		for (int i = 0; i < t.length; i++) {
			sumA = sumA + a[i];
			t[i] = -a[i];
		}
		int[] ans2 = best(t);
		int sum2 = sumA + ans2[3];
		if (sum1 >= sum2){
			printBest(a, ans1);
			return ans1;
		}
		else{
			int ans[] = {ans2[1], ans2[0], a.length-ans2[2], sum2};
			printBestCycle(a, ans);//ans2={beg, end, count, sum}
			return ans;
		}
	}
	public static int[] bestCycle2(int[] a){
		int[] ans1 = best(a);
		int sum1 = ans1[3];
		if (sum1 < 0){
			int result[] = {sum1};
			return result;
		}
		int t[] = new int[a.length];
		int sumA = 0;
		for (int i = 0; i < t.length; i++) {
			sumA = sumA + a[i];
			t[i] = -a[i];
		}
		int[] ans2 = best(t);
		int sum2 = sumA + ans2[3];
		if (sum1 >= sum2){
			//printBest(a, ans1);
			int beginMax=ans1[0], countmax = ans1[2];
			int result[] = new int[countmax];
			for (int i = 0; i < countmax; i++) {
				result[i] = a[beginMax+i];
			}
			return result;
		}
		else{
			int ans[] = {ans2[1], ans2[0], a.length-ans2[2], sum2};
			int beginMax=ans[0], countmax = ans[2];
			int result[] = new int[countmax];
			for (int i = 0; i < countmax; i++) {
				result[i] = a[(beginMax+i)%a.length];
			}
			return result;
		}
	}
	public static void printBestCycle(int[]a ,int[] res){
		int beginMax=res[0], endMax = res[1], countmax = res[2], sumMax = res[3];
		System.out.println("beginMax = " + beginMax + ", endMax = " + endMax + ", sumMax = "+sumMax);
		System.out.print("sub array cycle best: ");
		for (int i = 0; i < countmax; i++) {
			System.out.print(a[(beginMax+i)%a.length] + ", ");
		}
		System.out.println();
	}
	public static void printBest(int[]a ,int[] res){
		int beginMax=res[0], endMax = res[1], countmax = res[2], sumMax = res[3];
		System.out.println("beginMax = " + beginMax + ", endMax = " + endMax + ", sumMax = "+sumMax);
		System.out.print("sub array best: ");
		for (int i = 0; i < countmax; i++) {
			System.out.print(a[beginMax+i] + ", ");
		}
		System.out.println();
	}
	public static int bestShortestSubInterval(int[] a){
		int i=0;
		while (i<a.length && a[i]<=0) {i++;}
		if (i == a.length){// a[i]<=0, i=1,...,a.length
			return 1;
		}
		else{
			int  endMax = i+1, count = 0, countMax = 1, bestCount = 1;
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
					countMax = count;
					bestCount = countMax;
				}
				else if(sum == maxSum){
					if (count < bestCount){
						bestCount = count;
					}
				}
				i++;
			}
			return bestCount;
		}
	}
	public static void checkbestShortestSubInterval(){
		int[]a1 = {1,2,3,-50,2,4,-34,4};//2
		int[]a2 = {1,2,3,-50,2,4,-34,6};// 1
		int[]a3 = {3,3,-50,1,2,3,-34,4};// 2
		int[]a4 = {1,2,2,1,-50,2,4,-34,1,2,3};//2
		int[]a5 = {-1,-2,-2,-1,-50};// 1
		int[]a6 = {6,-50,1,2,3,-34,3,3};//1
		int a7[] = {1,1,-2,3,1,4,2,4,-3,-4,3,-1,2,0,2,3,2,0,3,-2};//16		
		System.out.println("len1 = " + bestShortestSubInterval(a1));
		System.out.println("len2 = " + bestShortestSubInterval(a2));
		System.out.println("len3 = " + bestShortestSubInterval(a3));
		System.out.println("len4 = " + bestShortestSubInterval(a4));
		System.out.println("len5 = " + bestShortestSubInterval(a5));
		System.out.println("len6 = " + bestShortestSubInterval(a6));
		/////
		System.out.println("len7 = " + bestShortestSubInterval(a7));
	}
	public static void checkBestCycle(){
		//int[]arr = {2, 0, -5, 2};
		//int[]arr = {-2, 0, +5, -2};
		//int arr[] = {1,10,-15,3,-10};
		//int arr[] = {10,2,-5,8,-100,3,50,-80,1,2,3}; //sum=53
		//int arr[] = {10,2,-5,8,-100,3,50,-80,1,2,3,88}; //sum=94
		//int arr[] = {10,2,-5,8,-100,3,150,-180,1,2,3,88}; //best sum=94, cycle sum = 106
		int arr[] = {90,2,-5,8,-100,3,50,-80,1,2,3};//best sum=95,cycle sum = 101
		//best(arr);
		bestCycle(arr);
	}
	public static void main(String[] args) {
		//checkBestCycle();
		checkbestShortestSubInterval();
	}

}
