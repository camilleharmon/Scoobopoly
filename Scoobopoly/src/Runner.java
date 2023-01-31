import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;
import java.io.*;

public class Runner {

	static ArrayList <Property> board = new ArrayList<Property>();
	static ArrayList <Card> chance = new ArrayList<Card>();
	static ArrayList <Card> communityChest = new ArrayList<Card>();
	static ArrayList <Player> playersList = new ArrayList<Player>();
	static Scanner file;
	static int theme;
	static int numPlayers;
	static int charnum = 1;
	static ArrayList <Property> player1 = new ArrayList<Property>();
	static ArrayList <Property> player2 = new ArrayList<Property>();
	static ArrayList <Property> player3 = new ArrayList<Property>();
	static ArrayList <Property> player4 = new ArrayList<Property>();
	static ArrayList <String> scoobyCharacters = new ArrayList<String>();
	static ArrayList <String> classicCharacters = new ArrayList<String>();
	
	public static void main(String[] args) throws IOException {
		
		chooseTheme();
		choosePlayers();
		fillBoard();
		fillDecks();
		fillCharacters();
		createCharacters();
		
	}
	
	public static void rollDice() {
		
		int dice = (int)(Math.random() * 6)+1;
		System.out.println("You rolled a " + dice + ".");
	}
	
	public static void characterSelect() {
		
		Scanner userIntInput = new Scanner(System.in);
		int counter = 1;
		
		if(theme == 2) {
			
			for(int j = 0; j < scoobyCharacters.size(); j++) {
				
				System.out.println("   " + counter + ") " + scoobyCharacters.get(j));
				counter++;
			}
			charnum = userIntInput.nextInt();
			counter = 0;
			
			if(charnum == 0 || charnum > scoobyCharacters.size()) {
				
				System.out.println("Please enter a valid answer.");
				characterSelect();
			}
		}else {
			
			for(int j = 0; j < classicCharacters.size(); j++) {
				
				System.out.println("   " + counter + ") " + classicCharacters.get(j));
				counter++;
			}
			charnum = userIntInput.nextInt();
			counter = 0;
			
			if(charnum == 0 || charnum > classicCharacters.size()) {
				
				System.out.println("Please enter a valid answer.");
				characterSelect();
			}
		}
	}
	
	public static void createCharacters() throws IOException{
		
		Scanner userInput = new Scanner(System.in);
		Scanner userIntInput = new Scanner(System.in);
		int counter = 1;
		String character = " ";
		
		for(int i = 1; i <= numPlayers; i++) {
			
			System.out.println("What is your name?");
			String name = userInput.next();
			
			if(theme == 2) {
				
				characterSelect();
				System.out.println(scoobyCharacters.get(charnum - 1) + " selected.");
				character = scoobyCharacters.get(charnum - 1);
				scoobyCharacters.remove(charnum-1);
				
			}else{
				
				characterSelect();
				System.out.println(classicCharacters.get(charnum - 1) + " selected.");
				character = classicCharacters.get(charnum - 1);
				classicCharacters.remove(charnum-1);
			}
			
			playersList.add(new Player(name, character, null, 0, false));
		}
	}
	
	public static void choosePlayers() throws IOException{
		
		Scanner userIntInput = new Scanner(System.in);

		System.out.println("");
        System.out.println("How many players are there?");
		System.out.println("   1 Player");
		System.out.println("   2 Players");
		System.out.println("   3 Players");
		System.out.println("   4 Players");

		int num = userIntInput.nextInt();
		
		if(num == 1) {				
			
			System.out.println("1 Player Selected");
			numPlayers = 1;
		}else if(num == 2) {				
			
			System.out.println("2 Players Selected");
			numPlayers = 2;
		}else if(num == 3) {				
			
			System.out.println("3 Players Selected");
			numPlayers = 3;
		}else{				
			System.out.println("4 Players Selected");
			numPlayers = 4;
		}
	}
	
	public static void chooseTheme() throws IOException{
		
		Scanner userIntInput = new Scanner(System.in);
		System.out.println("");
        System.out.println("What theme would you like to play?");
		System.out.println("   1) Classic");
		System.out.println("   2) Scooboploy");

		theme = userIntInput.nextInt();

		if(theme == 1) {				
			
			System.out.println("Basic.");
			file = new Scanner(new File("Classic.txt"));
		}else if(theme == 2) {				
			
			System.out.println("Scooby it is!");
			file = new Scanner(new File("Scoobopoly.txt"));
		}else {				
			System.out.println("Please choose a valid answer.");
			chooseTheme();
		}
	}
	
	public static void fillCharacters() {
		
		scoobyCharacters.add(new String("Fred"));
		scoobyCharacters.add(new String("Daphne"));
		scoobyCharacters.add(new String("Velma"));
		scoobyCharacters.add(new String("Shaggy"));
		scoobyCharacters.add(new String("Scooby"));

		classicCharacters.add(new String("Top Hat"));
		classicCharacters.add(new String("Scottie Dog"));
		classicCharacters.add(new String("Cat"));
		classicCharacters.add(new String("Racecar"));
		classicCharacters.add(new String("Thimble"));
	}
	
	public static void fillBoard() throws IOException{
		
		System.out.print("Making board");
		
		for(int i = 0; i < 3; i++) {
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print(".");
		}
		System.out.println("");
		
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
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Board Complete!");
		System.out.println("");
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
