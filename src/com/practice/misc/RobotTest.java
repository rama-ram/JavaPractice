
public class RobotTest {

	static boolean stepcheck(int x, int y, int x1, int y1){
		int newx=x1, newy=y1;
		while (newx >= x && newy >=y)
		{
			if (newx == x && newy ==y){
				System.out.println("valid step");		
				return true;
				
			}
				
			if(newx>newy)
				newx= newx-newy;
			else
				newy= newy-newx;
			
		}
		
		System.out.println("not valid step");
		return false;
	}
	public static void main (String args[]){
		stepcheck(2,3,16,7);
		
	}
}
