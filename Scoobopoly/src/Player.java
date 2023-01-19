import java.util.*;

public class Player {
	
	protected String name = "";
	protected String character = "";
	protected ArrayList <Property> assets = new ArrayList<Property>();
	protected int bank;
	protected boolean jail;
	//
	protected Player(String n, String c, ArrayList a, int b, boolean j) {
		
		name = n;
		character = c;
		assets = a;
		bank = b;
		jail = j;
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

	public ArrayList<Property> getAssets() {
		return assets;
	}

	public void setAssets(ArrayList<Property> assets) {
		this.assets = assets;
	}

	public int getBank() {
		return bank;
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
	
	
}
