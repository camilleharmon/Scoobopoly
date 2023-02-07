
public class Property implements IProperty {

	protected String name = "";
	protected int umber;
	
	Property()
	{
	}
	
	Property(String n, int u){
		
		name = n;
		umber = u;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUmber() {
		return umber;
	}

	public void setUmber(int umber) {
		this.umber = umber;
	}
	
	public int getOwner() {
		return 5;
	}
	
}
