import java.util.ArrayList;

public class Runner {

	static ArrayList <Property> board = new ArrayList<Property>();
	
	public static void main(String[] args) {
		
		fillBoard();

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
		
		communityChest.add(new Card("Community Chest", "Advance to Go(Collect $200))", 0, 0, false));
        communityChest.add(new Card("Community Chest", "Bank Error in your favor - collect $200", 200, -1, false));
        communityChest.add(new Card("Community Chest", "Doctors's fees - Pay $50", -50, -1, false));
        communityChest.add(new Card("Community Chest", "Get Out of Jail Free", 0, -1, true));
        communityChest.add(new Card("Community Chest", "Go Directly to Jail - Do not Pass Go, do not collect $200", 0, 10, false));
        communityChest.add(new Card("Community Chest", "Grand opening of the Opera, collect $50 from each player", -50, -1, true));
        communityChest.add(new Card("Community Chest", "Income Tax Refund - Collect $20", 20, -1, false));
        communityChest.add(new Card("Community Chest", "Life Insurance Matures, collect $100", 100, -1, false));
        communityChest.add(new Card("Community Chest", "Pay Hospital Fee of $100", -100, -1, false));
        communityChest.add(new Card("Community Chest", "Pay School Fee of $50", -50, -1, false));
        communityChest.add(new Card("Community Chest", "You are assessed for Street Repairs - pay $40 per house, $115 per Hotel", -40, -1, true));
        communityChest.add(new Card("Community Chest", "You have won second prize in a Beauty contest, collect $10", 10, -1, false));
        communityChest.add(new Card("Community Chest", "You inherit $100", 100, -1, false));
        communityChest.add(new Card("Community Chest", "From sale of Stock you get $50", 50, -1, false));
        communityChest.add(new Card("Community Chest", "XMAS Fund Matures, collect $100", 100, -1, false));
        
        //Chance cards
        chance.add(new Card("Chance", "Advance to Go(Collect $200)", 0, 0, false));
        chance.add(new Card("Chance", "Advance to Illinois Ave. - if you pass Go, collect $200", 0, 24, false));
        chance.add(new Card("Chance", "Advance token to the nearest Utility.\nIf unowned, you may buy it from the Bank.\nIf owned, throw dice and pay owner a total of 10 times the amount shown.", 0, -1, true));
        chance.add(new Card("Chance", "Advance token to the nearest Railroad.\nIf unowned, you may buy it from the Bank.\nIf owned, pay the owner twice the amount that they are entitled", 0, -1, true));
        chance.add(new Card("Chance", "Advance token to the nearest Railroad.\nIf unowned, you may buy it from the Bank.\nIf owned, pay the owner twice the amount that they are entitled", 0, -1, true));
        chance.add(new Card("Chance", "Advance to St. Charles Place - if you pass Go, collect $200", 0, 11, false));
        chance.add(new Card("Chance", "Bank pays you dividend of $50", 50, -1, false));
        chance.add(new Card("Chance", "Get out of Jail free.", 0, -1, true));
        chance.add(new Card("Chance", "Go back 3 spaces", 0, -1, true));
       /chance.add(new Card("Chance", "You are assessed for street repairs, pay $25 for each house and $100 for each hotel", 0, -1, true));
        chance.add(new Card("Chance", "Pay Poor tax of $15", -15, -1, false));
        chance.add(new Card("Chance", "Take a trip on the Reading Railroad - if you pass Go, collect $200", 0, 5, false));
        chance.add(new Card("Chance", "Take a walk on the Boardwalk - advance token to Boardwalk", 0, 39, false));
       /chance.add(new Card("Chance", "You have been elected Chairman of the board, pay each player $50", -50, -1, true));
        chance.add(new Card("Chance", "Building Loan Matures, collect $150", 150, -1, false));
	}
}
