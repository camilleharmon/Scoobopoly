import java.util.ArrayList;
import java.util.Scanner;

public class Runner {

	static ArrayList <Property> board = new ArrayList<Property>();
	static ArrayList <Card> chance = new ArrayList<Card>();
	static ArrayList <Card> communityChest = new ArrayList<Card>();
	
	public static void main(String[] args) {
		
		//fillBoard();
		makeBoard();
		fillDecks();
		
		
	}
	
	public static void makeBoard(){
		
		Scanner file = new Scanner(new File("Scoobopoly.txt"));
		for(int i = 0; i<40; i++) {
			
			String type = file.next();
			
			if(type.equals("Estate")) {
				
				String name = file.next();
				int num = file.nextInt();
				int price = file.nextInt();
				String owner = file.next();
				boolean fs = file.nextBoolean();
				int level = file.nextInt();
				String group = file.next();
				
				board.add(new Estate(name, num, price, owner, fs, level, group));
			}else if(type.equals("Factory")) {
				
				String name = file.next();
				int num = file.nextInt();
				int price = file.nextInt();
				String owner = file.next();
				boolean fs = file.nextBoolean();
				int level = file.nextInt();
				String group = file.next();
				
				board.add(new Factory(name, num, price, owner, fs, level, group));
			}else if(type.equals("Restaurant")) {
				
				String name = file.next();
				int num = file.nextInt();
				int price = file.nextInt();
				String owner = file.next();
				boolean fs = file.nextBoolean();
				int level = file.nextInt();
				String group = file.next();
				
				board.add(new Estate(name, num, price, owner, fs, level, group));
			}else if(type.equals("Go")) {
				
				String name = file.next();
				int num = file.nextInt();
				
				board.add(new Go(name, num));
			}else if(type.equals("Jail")) {
				
				String name = file.next();
				int num = file.nextInt();
				
				board.add(new Jail(name, num));
			}else if(type.equals("GoToJail")) {
				
				String name = file.next();
				int num = file.nextInt();
				
				board.add(new GoToJail(name, num));
			}else if(type.equals("FreeSpace")) {
				
				String name = file.next();
				int num = file.nextInt();
				
				board.add(new FreeSpace(name, num));
			}else if(type.equals("Jeepers")) {
				
				String name = file.next();
				int num = file.nextInt();
				
				board.add(new Jeepers(name, num));
			}else if(type.equals("CardSpace")) {
				
				String name = file.next();
				int num = file.nextInt();
				boolean iz = file.nextBoolean();
				
				board.add(new CardSpace(name, num, iz));
			}
		}
	}
	
	public static void fillBoard() {
			
			board.add(new Go("ClubHouse", 0));
			board.add(new Estate("Gypsy Wagon", 1, 60, "Unowned", false, 0, "Brown"));
			board.add(new CardSpace("Zoinks", 2, true));
			board.add(new Estate("Witch's Hut", 3, 60, "Unowned", false, 0, "Brown"));
			board.add(new Restaurant("Tiki Tub", 4, 200, "Unowned", false, 0, "Restaurant"));
			board.add(new Jeepers("Jeepers", 5));
			board.add(new Estate("Gold City Mine", 6, 100, "Unowned", false, 0, "Azure"));
			board.add(new CardSpace("Jinkies", 7, false));	
			board.add(new Estate("Abandoned Airfield", 8, 100, "Unowned", false, 0, "Azure"));
			board.add(new Estate("Sawmill", 9, 120, "Unowned", false, 0, "Azure"));
			
			board.add(new Jail("Jail", 10));
			board.add(new Estate("Graveyard of Ships", 11, 140, "Unowned", false, 0, "Pink"));
			board.add(new Factory("Gas Station", 12, 150, "Unowned", false, 0, "Factory"));
			board.add(new Estate("Wolf's End Lodge", 13, 140, "Unowned", false, 0, "Pink"));
			board.add(new Estate("Cemetery", 14, 160, "Unowned", false, 0, "Pink"));
			board.add(new Restaurant("Fruitmeir's", 15, 200, "Unowned", false, 0, "Restaurant"));
			board.add(new Estate("Jone's Cheesery", 16, 180, "Unowned", false, 0, "Orange"));
			board.add(new CardSpace("Zoinks", 7, true));
			board.add(new Estate("Dinkley's Bookshop", 18, 180, "Unowned", false, 0, "Orange"));
			board.add(new Estate("Blake's  Videorama", 19, 200, "Unowned", false, 0, "Orange"));
			
			board.add(new FreeSpace("Free Parking", 20));
			board.add(new Estate("Rocky Point Beach", 21, 220, "Unowned", false, 0, "Red"));
			board.add(new CardSpace("Jinkies", 22, false));
			board.add(new Estate("Brancusi Circus", 23, 220, "Unowned", false, 0, "Red"));
			board.add(new Estate("Funland", 24, 240, "Unowned", false, 0, "Red"));
			board.add(new Restaurant("Bloody Stake", 25, 200, "Unowned", false, 0, "Restaurant"));
			board.add(new Estate("Burlington Library", 26, 260, "Unowned", false, 0, "Yellow"));
			board.add(new Estate("Shady Sanitarium", 27, 260, "Unowned", false, 0, "Yellow"));
			board.add(new Factory("Destrodio Corp", 28, 150, "Unowned", false, 0, "Factory"));
			board.add(new Estate("Wax Muesem", 29, 280, "Unowned", false, 0, "Yellow"));
			
			board.add(new GoToJail("Go To Jail", 30));
			board.add(new Estate("Sander's Mansion", 31, 300, "Unowned", false, 0, "Green"));
			board.add(new Estate("Franken Castle", 32, 300, "Unowned", false, 0, "Green"));
			board.add(new CardSpace("Zoinks", 33, true));
			board.add(new Estate("Skull Island", 34, 320, "Unowned", false, 0, "Green"));
			board.add(new Restaurant("Malt Shop", 35, 200, "Unowned", false, 0, "Restaurant"));
			board.add(new CardSpace("Jinkies", 36, false));
			board.add(new Estate("Kingston Mansion", 37, 350, "Unowned", false, 0, "Blue"));
			board.add(new Jeepers("Jeepers", 38));
			board.add(new Estate("Vasquez Castle", 39, 400, "Unowned", false, 0, "Blue"));
			
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
