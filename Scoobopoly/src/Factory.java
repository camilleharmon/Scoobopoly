
public class Factory extends Property{

	protected int price;
	protected int owner;
	protected boolean forSale;
	protected int level;
	protected String group;
	protected int rent1;
	
	protected Factory(String n, int u, int p, int o, boolean fs, int l, String g, int r1) {
		
		super(n, u);
		price = p;
		owner = o;
		forSale = fs;
		level = l;
		rent1 = r1;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getOwner() {
		return owner;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}

	public boolean isForSale() {
		return forSale;
	}

	public void setForSale(boolean forSale) {
		this.forSale = forSale;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public int getRent1() {
		return rent1;
	}

	public void setRent1(int rent1) {
		this.rent1 = rent1;
	}
	
}
