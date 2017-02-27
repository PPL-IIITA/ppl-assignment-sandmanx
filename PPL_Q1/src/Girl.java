
public class Girl {
	private String name;
	private int attr;
	private int intel;
	private int maint;
	private int relation_criterion;
	/*
	 * 0 for according to attractiveness
	 * 1 for according to wealth
	 * 2 for according to intelligence
	 */
	private boolean commit=false;
	Girl(String n, int a, int intl, int maint, int reln_crit)
	{
		this.name=n;
		this.attr=a;
		this.intel=intl;
		this.maint=maint;
		this.relation_criterion=reln_crit;
		this.commit=false;
	}
	
	public String getGirlName(){
		return this.name;
	}
	
	public int getAttraction(){
		return this.attr;
	}
	
	public int getIntelligence(){
		return this.intel;
	}
	
	public int getMaintain(){
		return this.maint;
	}
	
	public int getRelationCriterion(){
		return this.relation_criterion;
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

	public void setMaintain(int maint) {
		this.maint = maint;
	}

	public void setRelationCriterion(int relation_criterion) {
		this.relation_criterion = relation_criterion;
	}

	public void setCommit(boolean commit) {
		this.commit = commit;
	}
	
}
