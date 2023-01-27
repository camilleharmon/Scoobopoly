
public class Restaurant extends Property {

	protected int price;
	protected String owner;
	protected boolean forSale;
	protected int level;
	protected String group;
	
	protected Restaurant(String n, int u, int p, String o, boolean fs, int l, String g) {
		
		name = n;
		umber = u;
		price = p;
		owner = o;
		forSale = fs;
		level = l;
	}
}
