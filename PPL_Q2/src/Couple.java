import java.util.ArrayList;

public class Couple {
	String name;
	Boy boy;
	Girl girl;
	int price;
	int happiness = 0;
	int compatibility = 0;
	ArrayList <Gift> gift_arr=new ArrayList<>();
	Couple(Boy boy, Girl girl){
		name = boy.getBoyName() + " and " +girl.getGirlName();
		this.boy = boy;
		this.girl = girl;
		int price = 0, happiness = 0, compatibility = 0;
		
	}
}
