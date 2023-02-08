import java.util.ArrayList;

public interface IProperty{

	public String getName();

	public int getOwner();
	
	public int getPrice();
	
	public boolean isForSale();
	
	public void setForSale(boolean forSale);
	
	public void setOwner(int owner);
	
	public int getLevel();
	
	public int getRent1();
	
	public boolean isCanBuy();
	
	public void moveMoney(int player, ArrayList <Player> playersList);
	
	public void go(int player, ArrayList <Player> playersList);
}
