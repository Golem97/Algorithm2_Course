package best;

public class PetrolStationBest {
	
	public static boolean PetrolStation(int a[], int b[]){
		// amount of gasoline at the pump  i -> a[i]
		// the amount of gasoline needed to get to the pump  i -> b[i]
		// sum(b)<=sum(a)
		boolean ans = true;
		int []c = new int[a.length];
		int sum = 0;
		for (int i = 0; i < c.length; i++) {
			c[i] = a[i] - b[i];
			sum = sum + c[i];
		}
		System.out.println("sum c = "+sum);
		if (sum < 0){
			System.out.println("not enough gasoline");
			ans = false;
		}
		else{
			int[] res = Best2.bestCycle(c);
			int start = res[0], amount = 0;
			for (int i = 0; ans && i < res.length; i++) {
				int ind = (start+i)%c.length;
				amount = amount + c[ind];
				if (amount<0){
					System.out.println("error");
					ans = false;
				}
			}
		}
		return ans;		
	}
	public static void main(String[] args) {
		//int [] a = {5,10,12,100};
		//int [] b = {6,11,13,50};
		/////////
		//int [] a = {8,10,12,100};
		//int [] b = {6,11,13,50};
		///////
		//int [] a = {6, 0, 0, 6, 7, 0, 7, 8, 5, 5};
		//int [] b = {7, 4, 6, 5, 3, 3, 8, 0, 1, 0};
		int [] b = {8,10,12,100};
		int [] a = {6,11,13,50};
		System.out.println(PetrolStation(a,b));
		///////
		

	}

}
