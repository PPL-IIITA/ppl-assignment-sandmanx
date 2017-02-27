
public class Boy {
	private String name;
	private int attr;//on a scale of 10
	private int intel;
	private int budget;
	private boolean commit=false;
	private int min_attr;
	private String type;
	/*
	 * Minimum attraction requirement for girls
	 */
	
	Boy(String n, int a, int intl, int bud, int min_attr, String type)
	{
		this.name = n;
		this.attr = a;
		this.intel=intl;
		this.budget =bud;
		this.min_attr = min_attr;
		this.type = type;
		this.commit = false;
	
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getBoyName(){
		return this.name;
	}
	
	public int getAttraction(){
		return this.attr;
	}
	
	public int getIntelligence(){
		return this.intel;
	}
	
	public int getBudget(){
		return this.budget;
	}
	
	public int getMinimumAttraction(){
		return this.min_attr;
	}
	
	public boolean getCommitment(){
		return this.commit;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setAttraction(int attr) {
		this.attr = attr;
	}


	public void setIntellligence(int intel) {
		this.intel = intel;
	}


	public void setBudget(int budget) {
		this.budget = budget;
	}


	public void setCommitment(boolean commit) {
		this.commit = commit;
	}


	public void setMin_attr(int min_attr) {
		this.min_attr = min_attr;
	}
	
	
}
	
	
	
	