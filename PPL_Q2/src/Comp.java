import java.util.Comparator;
public class Comp implements Comparator {
	@Override
	public int compare(Object obj1,Object obj2)
	{
		Gift gift1,gift2;
		gift1 = (Gift)obj1;
		gift2 = (Gift)obj2;
		
		if(gift1.getCost() > gift2.getCost()){
			return 1;
		}
		
		else if(gift1.getCost() < gift2.getCost()){
			return -1;
		}
		
		else if(gift1.getValue() > gift2.getValue()){
			return 1;
			
		}
		
		else if(gift1.getValue() < gift2.getValue()){
			return -1;
		}
		
		return 0;
		
	}
	

}
