
public class Jeepers extends Property{

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
	
	public void collect(int player) {
		
		System.out.println("You landed on Jeepers, pay $200");
		
		int playerBank = playersList.get(player).getBank();
		
		if(playerBank < 200) {
			
			playersList.get(player).setBankrupt(true);
		}else {
			
			playersList.get(player).setBank(playerBank - 200);
		}
	}
}
