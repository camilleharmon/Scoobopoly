import java.util.ArrayList;

public class Runner {

	static ArrayList <Property> board = new ArrayList<Property>();
	static ArrayList <Card> chance = new ArrayList<Card>();
	static ArrayList <Card> communityChest = new ArrayList<Card>();
	
	public static void main(String[] args) {
		
		fillBoard();
		fillDecks();
	}
	
	public static void fillBoard() {
			
			board.add(new Go("ClubHouse", 0));
			board.add(new Estate("Gypsy Wagon", 1, 60, "Unowned", false, 0, "Brown"));
		//Zoinks
			board.add(new Estate("Witch's Hut", 4, 60, "Unowned", false, 0, "Brown"));
			board.add(new Restaurant("Tiki Tub", 5, 100, "Unowned", false, 0, "Restaurant"));
		//Jeepers	
			board.add(new Estate("Gold City Mine", 7, 100, "Unowned", false, 0, "Azure"));
		//Jinkies	
			board.add(new Estate("Abandoned Airfield", 9, 100, "Unowned", false, 0, "Azure"));
			board.add(new Estate("Sawmill", 10, 120, "Unowned", false, 0, "Azure"));
		//Jail
			board.add(new Estate("Graveyard of Ships", 12, 140, "Unowned", false, 0, "Pink"));
			board.add(new Factory("Gas Station", 13, 150, "Unowned", false, 0, "Factory"));
			board.add(new Estate("Wolf's End Lodge", 14, 140, "Unowned", false, 0, "Pink"));
			board.add(new Estate("Cemetery", 15, 160, "Unowned", false, 0, "Pink"));
			board.add(new Restaurant("Fruitmeir's", 16, 100, "Unowned", false, 0, "Restaurant"));
			board.add(new Estate("Jone's Cheesery", 17, 180, "Unowned", false, 0, "Orange"));
		//Zoinks
			board.add(new Estate("Dinkley's Bookshop", 19, 180, "Unowned", false, 0, "Orange"));
			board.add(new Estate("Blake's  Videorama", 20, 200, "Unowned", false, 0, "Orange"));
		//FreeSpace
			board.add(new Estate("Rocky Point Beach", 22, 220, "Unowned", false, 0, "Red"));
		//Jinkies
			board.add(new Estate("Brancusi Circus", 24, 220, "Unowned", false, 0, "Red"));
			board.add(new Estate("Funland", 25, 240, "Unowned", false, 0, "Red"));
			board.add(new Restaurant("Bloody Stake", 26, 100, "Unowned", false, 0, "Restaurant"));
			board.add(new Estate("Burlington Library", 27, 260, "Unowned", false, 0, "Yellow"));
			board.add(new Estate("Shady Sanitarium", 28, 260, "Unowned", false, 0, "Yellow"));
			board.add(new Factory("Destrodio Corp", 29, 150, "Unowned", false, 0, "Factory"));
			board.add(new Estate("Wax Muesem", 30, 280, "Unowned", false, 0, "Yellow"));
		//GoToJail
			board.add(new Estate("Sander's Mansion", 32, 300, "Unowned", false, 0, "Green"));
			board.add(new Estate("Franken Castle", 33, 300, "Unowned", false, 0, "Green"));
		//Zoinks
			board.add(new Estate("Skull Island", 35, 320, "Unowned", false, 0, "Green"));
			board.add(new Restaurant("Malt Shop", 36, 100, "Unowned", false, 0, "Restaurant"));
		//Jinkies
			board.add(new Estate("Kingston Mansion", 38, 350, "Unowned", false, 0, "Blue"));
		//Jeepers
			board.add(new Estate("Vasquez Castle", 40, 400, "Unowned", false, 0, "Blue"));
			
	}
	
	public static void fillDecks() {
		
		communityChest.add(new Card("Zoinks", 00, "Advance to Go(Collect $200))", false));
        communityChest.add(new Card("Zoinks", 00, "Bank Error in your favor - collect $200", false));
        communityChest.add(new Card("Zoinks", 00, "Doctors's fees - Pay $50", false));
        communityChest.add(new Card("Zoinks", 00, "Get Out of Jail Free", false));
        communityChest.add(new Card("Zoinks", 00, "Go Directly to Jail - Do not Pass Go, do not collect $200", false));
        communityChest.add(new Card("Zoinks", 00, "Grand opening of the Opera, collect $50 from each player", false));
        communityChest.add(new Card("Zoinks", 00, "Income Tax Refund - Collect $20", false));
        communityChest.add(new Card("Zoinks", 00, "Life Insurance Matures, collect $100", false));
        communityChest.add(new Card("Zoinks", 00, "Pay Hospital Fee of $100", false));
        communityChest.add(new Card("Zoinks", 00, "Pay School Fee of $50", false));
        communityChest.add(new Card("Zoinks", 00, "You are assessed for Street Repairs - pay $40 per house, $115 per Hotel", false));
        communityChest.add(new Card("Zoinks", 00, "You have won second prize in a Beauty contest, collect $10", false));
        communityChest.add(new Card("Zoinks", 00, "You inherit $100", false));
        communityChest.add(new Card("Zoinks", 00, "From sale of Stock you get $50", false));
        communityChest.add(new Card("Zoinks", 00, "XMAS Fund Matures, collect $100", false));
        
        
        chance.add(new Card("Jinkies", 00, "Advance to Go(Collect $200)", false));
        chance.add(new Card("Jinkies", 00, "Advance to Illinois Ave. - if you pass Go, collect $200", false));
        chance.add(new Card("Jinkies", 00, "Advance token to the nearest Utility.\nIf unowned, you may buy it from the Bank.\nIf owned, throw dice and pay owner a total of 10 times the amount shown.", false));
        chance.add(new Card("Jinkies", 00, "Advance token to the nearest Railroad.\nIf unowned, you may buy it from the Bank.\nIf owned, pay the owner twice the amount that they are entitled", false));
        chance.add(new Card("Jinkies", 00, "Advance token to the nearest Railroad.\nIf unowned, you may buy it from the Bank.\nIf owned, pay the owner twice the amount that they are entitled", false));
        chance.add(new Card("Jinkies", 00, "Advance to St. Charles Place - if you pass Go, collect $200", false));
        chance.add(new Card("Jinkies", 00, "Bank pays you dividend of $50", false));
        chance.add(new Card("Jinkies", 00, "Get out of Jail free.", false));
        chance.add(new Card("Jinkies", 00, "Go back 3 spaces", false));
        chance.add(new Card("Jinkies", 00, "You are assessed for street repairs, pay $25 for each house and $100 for each hotel", false));
        chance.add(new Card("Jinkies", 00, "Pay Poor tax of $15", false));
        chance.add(new Card("Jinkies", 00, "Take a trip on the Reading Railroad - if you pass Go, collect $200", false));
        chance.add(new Card("Jinkies", 00, "Take a walk on the Boardwalk - advance token to Boardwalk", false));
        chance.add(new Card("Jinkies", 00, "You have been elected Chairman of the board, pay each player $50", false));
        chance.add(new Card("Jinkies", 00, "Building Loan Matures, collect $150", false));
	}
}
