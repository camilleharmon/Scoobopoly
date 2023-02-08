import java.util.ArrayList;
import java.util.Scanner;

public class CardSpace extends Property{

	protected boolean isZoinks;
	
	protected CardSpace(String n, int u, boolean z) {
		
		name = n;
		umber = u;
		isZoinks = z;
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
	
	public boolean isZoinks() {
		return isZoinks;
	}

	public void setZoinks(boolean isZoinks) {
		this.isZoinks = isZoinks;
	}
	
	public void pickZoinks(int player, ArrayList <Player> playersList, ArrayList <Card> communityChest) {
		
		Scanner userIntInput = new Scanner(System.in);
		System.out.println("You landed on Zoink, here is your card: ");
		
		int random = (int)(Math.random() * 14)+1;
		
		System.out.println(communityChest.get(random).getCard());
		System.out.println("OKAY");
		int enter = userIntInput.nextInt();
		
	}
}
