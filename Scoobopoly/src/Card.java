
public class Card {

	protected String name;
	protected int umber;
	protected String card;
	protected boolean discard;
	
	protected Card(String n, int u, String c, boolean d) {
		
		name = n;
		umber = u;
		card = c;
		discard = d;
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

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public boolean isDiscard() {
		return discard;
	}

	public void setDiscard(boolean discard) {
		this.discard = discard;
	}
	
	
}

