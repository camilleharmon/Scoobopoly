
public class Factory extends Property{

	protected int price;
	protected String owner;
	protected boolean forSale;
	protected int lodging;
	protected String group;
	
	protected Factory(String n, int u, int p, String o, boolean fs, int l, String g) {
		
		name = n;
		umber = u;
		price = p;
		owner = o;
		forSale = fs;
		lodging = l;
	}
}
