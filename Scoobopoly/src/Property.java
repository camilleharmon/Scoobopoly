import java.util.ArrayList;

public class Property implements IProperty {

	protected String name = "";
	protected int umber;
	protected boolean forSale = false;
	protected int price = 0;
	protected int owner = 5;
	protected int level = 0;
	protected int rent1 = 0;
	protected boolean canBuy = false;
	
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
	
	public void setForSale(boolean forSale) {
		this.forSale = forSale;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getLevel() {
		return level;
	}
	
	public int getRent1() {
		return rent1;
	}
	
	public boolean isCanBuy() {
		return canBuy;
	}
	
	public void moveMoney(int player, ArrayList <Player> playersList) {
		
	}
	
	public void go(int player, ArrayList <Player> playersList) {
		
	}
}
