import java.util.ArrayList;
import java.util.Scanner;

public class Go extends Property{

	public static final String GREEN = "\u001b[42;1m";
	public static final String ANSI_RESET = "\u001B[0m";
			
	protected Go(String n, int u) {
		
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
	
	public void go(int player, ArrayList <Player> playersList) {
		
		Scanner userIntInput = new Scanner(System.in);
		System.out.println("You passed Go, collect $200");
		
		int playerBank = playersList.get(player).getBank();
		
		playersList.get(player).setBank(playerBank + 200);
		
		System.out.println(GREEN + "COLLECT" + ANSI_RESET);
		int enter = userIntInput.nextInt();
	}
}
