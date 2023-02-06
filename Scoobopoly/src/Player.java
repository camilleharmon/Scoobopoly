import java.util.*;

public class Player {
	
	protected String name = "";
	protected String character = "";
	//protected ArrayList <String> assets = new ArrayList<String>();
	protected String inventory = "";
	protected int bank;
	protected boolean jail;
	protected boolean bankrupt;
	
	protected Player(String n, String c, String i, int b, boolean j, boolean ba) {
		
		name = n;
		character = c;
		//assets = a;
		inventory = i;
		bank = b;
		jail = j;
		bankrupt = ba;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

//	public ArrayList<String> getAssets() {
//		return assets;
//	}
//
//	public void setAssets(ArrayList<String> assets) {
//		this.assets = assets;
//	}

	public int getBank() {
		return bank;
	}

	public String getInventory() {
		return inventory;
	}

	public void setInventory(String inventory) {
		this.inventory = inventory;
	}

	public void setBank(int bank) {
		this.bank = bank;
	}

	public boolean isJail() {
		return jail;
	}

	public void setJail(boolean jail) {
		this.jail = jail;
	}

	public boolean isBankrupt() {
		return bankrupt;
	}

	public void setBankrupt(boolean bankrupt) {
		this.bankrupt = bankrupt;
	}
	
	
}
