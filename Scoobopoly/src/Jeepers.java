import java.util.ArrayList;
import java.util.Scanner;

public class Jeepers extends Property{

	public static final String RED = "\u001b[41;1m";
	public static final String ANSI_RESET = "\u001B[0m";
	
	protected Jeepers(String n, int u) {
		
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
	
	public void moveMoney(int player, ArrayList <Player> playersList) {
		
		Scanner userIntInput = new Scanner(System.in);
		System.out.println("You landed on Jeepers, pay $200");
		
		int playerBank = playersList.get(player).getBank();
		
		if(playerBank < 200) {
			
			playersList.get(player).setBankrupt(true);
			System.out.println(playersList.get(player).character + " went bankrupt.");
		}else {
			
			playersList.get(player).setBank(playerBank - 200);
			System.out.println(RED + "PAY UP" + ANSI_RESET);
			int enter = userIntInput.nextInt();
		}
	}
}
