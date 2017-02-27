
public class Couple {
	String name;
	Boy boy;
	Girl girl;
	Couple(Boy boy, Girl girl){
		name = boy.getBoyName() + " and " +girl.getGirlName();
		this.boy = boy;
		this.girl = girl;
	}
}
