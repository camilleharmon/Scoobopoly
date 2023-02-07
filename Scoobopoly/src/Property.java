
public class Property implements IProperty {

	protected String name = "";
	protected int umber;
	protected boolean forSale = false;
	protected int price = 0;
	protected int owner = 5;
	protected int level = 0;
	
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
	
	public void setOwner(int owner) {
		this.owner = owner;
	}
	
	public boolean isForSale() {
		return forSale;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getLevel() {
		return level;
	}
}
