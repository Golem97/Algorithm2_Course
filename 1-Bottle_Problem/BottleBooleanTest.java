package fw_bottle;

import static org.junit.Assert.*;

import org.junit.Test;

public class BottleBooleanTest {

	@Test
	public void test1() {
		int m=1, n=1;
		boolean[][]actual = BottleBoolean.initBooleMatrBottle(m, n);
		boolean[][] expected = {{false,true,true,false},{true,false,true,true},
								{true,true,false,true},{false,true,true,false}};
		int dim = (m+1)*(n+1);
		assertTrue(checkMatrices(actual,expected));
	}
	@Test
	public void test2() {
		int m=2, n=1;
		boolean[][]actual = BottleBoolean.initBooleMatrBottle(m, n);
		boolean[][] expected = {{false,	true,	false,	false,	true,	false},
								{true,	false,	true,	false,	false,	true},
								{true,	true,	false,	true,	true,	false},
								{false,	true,	true,	false,	true,	true},
								{true,	false,	false,	true,	false,	true},
								{false,	true,	false,	false,	true,	false}};
		int dim = (m+1)*(n+1);
		assertTrue(checkMatrices(actual,expected));
	}
	@Test
	public void test3() {
		int m=2, n=2;
		boolean[][]actual = BottleBoolean.initBooleMatrBottle(m, n);
		boolean[][] expected = 
			    {{false,	false,	true,	false,	false,	false,	true,	false,	false},	
				{true,	false,	true,	true,	false,	false,	false,	true,	false},	
				{true,	false,	false,	false,	false,	false,	true,	false,	true},	
				{true,	true,	false,	false,	false,	true,	true,	false,	false},	
				{false,	true,	true,	true,	false,	true,	true,	true,	false},	
				{false,	false,	true,	true,	false,	false,	false,	true,	true},	
				{true,	false,	true,	false,	false,	false,	false,	false,	true},	
				{false,	true,	false,	false,	false,	true,	true,	false,	true},	
				{false,	false,	true,	false,	false,	false,	true,	false,	false}};	

		int dim = (m+1)*(n+1);
		assertTrue(checkMatrices(actual,expected));
	}
    private boolean checkMatrices(boolean[][]a, boolean[][]b){
    	boolean ans = true;
    	for(int i=0; ans && i<a.length; i++){
    		for (int j = 0; ans && j<a[0].length; j++) {
				if(a[i][j] != b[i][j]) ans = false;
			}
    	}
    	return ans;
    }
}