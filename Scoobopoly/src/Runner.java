import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;
import java.io.*;

public class Runner {

	static boolean game = true;
	static int dice;
	static ArrayList <IProperty> board = new ArrayList<IProperty>();
	static ArrayList <Card> chance = new ArrayList<Card>();
	static ArrayList <Card> communityChest = new ArrayList<Card>();
	static ArrayList <Player> playersList = new ArrayList<Player>();
	static Scanner file;
	static int theme;
	static int numPlayers;
	static int charnum = 1;
	static ArrayList <String> scoobyCharacters = new ArrayList<String>();
	static ArrayList <String> classicCharacters = new ArrayList<String>();
	public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001b[34;1m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_HGREEN = "\u001b[42;1m";
    public static final String ANSI_MAGENTA = "\u001b[35m";
    
    public static final String BLUE = "\u001b[44;1m";
    public static final String GREEN = "\u001b[42;1m";
    public static final String YELLOW = "\u001b[43;1m";
    public static final String RED = "\u001b[41;1m";
    public static final String ORANGE = "\033[48;2;255;165;0m";
    public static final String PINK = "\u001b[45;1m";
    public static final String LBLUE = "\u001b[46;1m";
    public static final String WHITE = "\u001b[47;1m";
    public static final String WHITEW = "\u001b[48;2;305;165;0m";
    
    public static final String BOLD = "\u001b[1m";
    public static final String UNDERLINED = "\u001b[4m";
    public static final String REVERSE = "\u001b[7m;1m";
	
	public static void main(String[] args) throws IOException {
		
		chooseTheme();
		choosePlayers();
		fillBoard();
		fillDecks();
		fillCharacters();
		createCharacters();
		gameOn();
	}
	
	public static void move(int player) {
		
		int location = playersList.get(player).getCurrentSpace();
		
		if(location + dice < board.size()) {
			
			playersList.get(player).setCurrentSpace(location + dice);
		}else{
			
			location = location + dice - board.size();
			playersList.get(player).setCurrentSpace(location);
			
			IProperty pro = board.get(0);
			
			//Passed go or landed on go
			pro.go(player, playersList);
		}
		
		//playersList.get(player).setCurrentSpace(location);
		//System.out.println("Player Location: " + playersList.get(player).getCurrentSpace());
	}
	
	public static void buyProperty(int player) {
		
		int price = board.get(playersList.get(player).getCurrentSpace()).getPrice();
		int playerBank = playersList.get(player).getBank();
		int location = playersList.get(player).getCurrentSpace();
		
		if(price > playerBank) {
			
			System.out.println("Insufficent funds");
			return;	
		}
		Scanner userIntInput = new Scanner(System.in);
		System.out.println(BOLD + "Price: $" + ANSI_RESET + price);
		System.out.println("Would you like to buy this property?");
		System.out.println("1) Yes");
		System.out.println("2) No");
		int answer = userIntInput.nextInt();
		
		if(answer == 1) {
			
			System.out.println(playersList.get(player).getCharacter() + " has bought " + board.get(location).getName());
			board.get(location).setOwner(player);
//			System.out.println("Owner: " + board.get(location).getOwner());
//			System.out.println("Name: " + board.get(location).getName());
			board.get(location).setForSale(false);
			pay(player, price);
		}else {
			
			System.out.println(playersList.get(player).getCharacter() + " declined to buy " + board.get(location).getName());
		}
	}
	
	public static void pay(int player, int pay) {
		
		int playerBank = playersList.get(player).getBank();
		int holder = board.get(playersList.get(player).getCurrentSpace()).getOwner();
		int holderBank = playersList.get(holder).getBank();
		
		if(playerBank < pay) {
			
			playersList.get(player).setBankrupt(true);
			System.out.println(playersList.get(player).character + " went bankrupt.");
		}else {
			
			playersList.get(player).setBank(playerBank - pay);
			//playersList.get(holder).setBank(holderBank + pay);
		}
	}
	
	public static void payRent(int player) {
		
		Scanner userIntInput = new Scanner(System.in);
		int holder = board.get(playersList.get(player).getCurrentSpace()).getOwner();
		//System.out.println(holder);
		
		if(holder >= 4) {
			
			return;
		}
		
		String holder2 = playersList.get(holder).getCharacter();
		
		System.out.println(holder2 + " owns this property.");
		
		if(board.get(playersList.get(player).getCurrentSpace()).getLevel() == 0) {
			
			System.out.println("You need to pay $" + board.get(playersList.get(player).getCurrentSpace()).getRent1());
			pay(player, board.get(playersList.get(player).getCurrentSpace()).getRent1());
		}else {
			
			System.out.println(BOLD + "Rent: $" + ANSI_RESET + board.get(playersList.get(player).getCurrentSpace()).getLevel());
		}
		
		System.out.println(RED + "PAY RENT" + ANSI_RESET);
		int enter = userIntInput.nextInt();
	}
	
	public static void getSpace(int player) {
		
		//System.out.println("______________________________________________________");
		System.out.println(board.get(playersList.get(player).getCurrentSpace()).getName());
		
		IProperty pro = board.get(playersList.get(player).getCurrentSpace());
		
		if(!pro.isCanBuy()) {
			
			//Transfer money
			pro.moveMoney(player, playersList);
			
			
			return;
		}
			
		if(pro.isForSale()) {
			
			buyProperty(player);
		}else {
			
			payRent(player);
		}
		
	}
	
	public static String padRight(String s, int n) {
	     return String.format("%-" + n + "s", s);  
	}
	
	public static void display(int player) {
		
		//System.out.println("______________________________________________________");
		System.out.println(playersList.get(player).getCharacter());
		System.out.println(BOLD + "Bank: $" + ANSI_RESET + playersList.get(player).getBank());
		
		if(playersList.get(player).isJail() == true) {
			
			System.out.println(BOLD + "Jail Status: " + ANSI_RESET + ANSI_RED + "ARRESTED" + ANSI_RESET);
		}else {
			
			System.out.println(BOLD + "Jail Status: " + ANSI_RESET + ANSI_CYAN + "FREE" + ANSI_RESET);
		}

		System.out.println("                    " + UNDERLINED + "Assets" + ANSI_RESET);
		
		int counter = 0;
		ArrayList<IProperty> mine = new ArrayList<IProperty>();
		
		for(int i = 0; i < board.size(); i++) {
			
			IProperty pro = board.get(i);
			
			if(pro.getOwner() == player) {
				
				//System.out.println("Name " + pro.getName());
				mine.add(pro);
				counter++;
			}
			
//			if(pro.getOwner() != 5) {
//				
//				System.out.println("Owner " + pro.getOwner());
//				System.out.println("Name " + pro.getName());
//			}
		}
		
		for(int z = 0; z < mine.size(); z++) {
			
			IProperty pro = mine.get(z);
			
			if(z%2 == 0 && z > 0) {
				
				System.out.println("");
			}
			
			System.out.print(padRight(pro.getName(), 30));
		}
		
		if(counter == 0) {
			
			System.out.println("No properties owned");
		}
		System.out.println("");
		//System.out.println("______________________________________________________");
	}
	
	public static void gameOn() {
		
		int counter= 0;
		while(game) {
			
			for(int i = 0; i < playersList.size(); i++) {
				
				if(playersList.get(i).isBankrupt() == false) {
					
					System.out.println("-----------------------------------------");
					//System.out.println(playersList.get(i).getCharacter());
					display(i);
					rollDice();
					move(i);
					getSpace(i);
					display(i);
					//System.out.println("_________________________________________");
				}
				counter++;
//				if(counter == 50) {
//					
//					game = false;
//				}
				
			}
			
			
			if(playersList.size() == 1)
				continue;
			
			
			int bCounter = 0;
			for(int j = 0; j < playersList.size(); j++) {
				
				if(playersList.get(j).isBankrupt()) {
					
					bCounter++;
				}
			}
			
			if(bCounter >= playersList.size() - 1) {
				
				game = false;
			}
		}
	}
	
	public static void rollDice() {

		System.out.print("Rolling Dice");
		
		for(int i = 0; i < 3; i++) {
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print(".");
		}
		System.out.println("");
			
		dice = (int)(Math.random() * 6)+1;
		System.out.println("You rolled a " + dice + ".");
		System.out.println("");
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
		String inventory = " ";
		
		for(int i = 1; i <= numPlayers; i++) {
			
			//System.out.println("What is your name?");
			//String name = userInput.next();
			
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
			
			playersList.add(new Player("name", character, 500, false, false, 0));
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
		
		scoobyCharacters.add(new String(ANSI_CYAN + "Fred" + ANSI_RESET));
		scoobyCharacters.add(new String(ANSI_MAGENTA + "Daphne" + ANSI_RESET));
		scoobyCharacters.add(new String(ANSI_RED +"Velma" + ANSI_RESET));
		scoobyCharacters.add(new String(ANSI_GREEN + "Shaggy" + ANSI_RESET));
		scoobyCharacters.add(new String(ANSI_YELLOW + "Scooby" + ANSI_RESET));

		classicCharacters.add(new String(ANSI_CYAN + "Top Hat" + ANSI_RESET));
		classicCharacters.add(new String(ANSI_MAGENTA + "Scottie Dog" + ANSI_RESET));
		classicCharacters.add(new String(ANSI_RED + "Racecar" + ANSI_RESET));
		classicCharacters.add(new String(ANSI_GREEN + "Cat" + ANSI_RESET));
		classicCharacters.add(new String(ANSI_YELLOW + "Thimble" + ANSI_RESET));
	}

	public static void fillBoard() throws IOException{
		
		System.out.print("Making board");
		
		for(int i = 0; i < 3; i++) {
			
			try {
				Thread.sleep(100);
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
				int owner = file.nextInt();
				boolean fs = file.nextBoolean();
				int level = file.nextInt();
				String group = file.next();
				int rent1 = file.nextInt();
				
				if(group.equals("Brown")) {
					
					board.add(new Estate(ANSI_MAGENTA + name + ANSI_RESET, num, price, owner, fs, level, group, rent1));
				}else if(group.equals("Azure")) {
					
					board.add(new Estate(LBLUE + name + ANSI_RESET, num, price, owner, fs, level, group, rent1));
				}else if(group.equals("Pink")) {
					
					board.add(new Estate(PINK + name + ANSI_RESET, num, price, owner, fs, level, group, rent1));
				}else if(group.equals("Orange")) {
					
					board.add(new Estate(ORANGE + name + ANSI_RESET, num, price, owner, fs, level, group, rent1));
				}else if(group.equals("Red")) {
					
					board.add(new Estate(RED + name + ANSI_RESET, num, price, owner, fs, level, group, rent1));
				}else if(group.equals("Yellow")) {
					
					board.add(new Estate(YELLOW + name + ANSI_RESET, num, price, owner, fs, level, group, rent1));
				}else if(group.equals("Green")) {
					
					board.add(new Estate(GREEN + name + ANSI_RESET, num, price, owner, fs, level, group, rent1));
				}else if(group.equals("Green")) {
					
					board.add(new Estate(BLUE + name + ANSI_RESET, num, price, owner, fs, level, group, rent1));
				}
				
				board.add(new Estate(name, num, price, owner, fs, level, group, rent1));
				
			}else if(type.equals("Factory")) {
				
				String name = file.next();
				int num = file.nextInt();
				int price = file.nextInt();
				int owner = file.nextInt();
				boolean fs = file.nextBoolean();
				int level = file.nextInt();
				String group = file.next();
				int rent1 = file.nextInt();
				
				board.add(new Factory(name, num, price, owner, fs, level, group, rent1));
			}else if(type.equals("Restaurant")) {
				
				String name = file.next();
				int num = file.nextInt();
				int price = file.nextInt();
				int owner = file.nextInt();
				boolean fs = file.nextBoolean();
				int level = file.nextInt();
				String group = file.next();
				int rent1 = file.nextInt();
				
				board.add(new Restaurant(name, num, price, owner, fs, level, group, rent1));
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
		
//		for(int k = 0; k < board.size(); k++) {
//			
//			IProperty pro = board.get(k);
//			System.out.println(pro.getName());
//		}
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Board Complete!");
		System.out.println("");
	}
		
	public static void fillDecks() {
		
		communityChest.add(new Card(ANSI_GREEN + "Zoinks" + ANSI_RESET, 00, "Advance to Go(Collect $200))", false));
        communityChest.add(new Card(ANSI_GREEN + "Zoinks" + ANSI_RESET, 00, "Bank Error in your favor - collect $200", false));
        communityChest.add(new Card(ANSI_GREEN + "Zoinks" + ANSI_RESET, 00, "Doctors's fees - Pay $50", false));
        communityChest.add(new Card(ANSI_GREEN + "Zoinks" + ANSI_RESET, 00, "Get Out of Jail Free", false));
        communityChest.add(new Card(ANSI_GREEN + "Zoinks" + ANSI_RESET, 00, "Go Directly to Jail - Do not Pass Go, do not collect $200", false));
        communityChest.add(new Card(ANSI_GREEN + "Zoinks" + ANSI_RESET, 00, "Grand opening of the Opera, collect $50 from each player", false));
        communityChest.add(new Card(ANSI_GREEN + "Zoinks" + ANSI_RESET, 00, "Income Tax Refund - Collect $20", false));
        communityChest.add(new Card(ANSI_GREEN + "Zoinks" + ANSI_RESET, 00, "Life Insurance Matures, collect $100", false));
        communityChest.add(new Card(ANSI_GREEN + "Zoinks" + ANSI_RESET, 00, "Pay Hospital Fee of $100", false));
        communityChest.add(new Card(ANSI_GREEN + "Zoinks" + ANSI_RESET, 00, "Pay School Fee of $50", false));
        communityChest.add(new Card(ANSI_GREEN + "Zoinks" + ANSI_RESET, 00, "You are assessed for Street Repairs - pay $40 per house, $115 per Hotel", false));
        communityChest.add(new Card(ANSI_GREEN + "Zoinks" + ANSI_RESET, 00, "You have won second prize in a Beauty contest, collect $10", false));
        communityChest.add(new Card(ANSI_GREEN + "Zoinks" + ANSI_RESET, 00, "You inherit $100", false));
        communityChest.add(new Card(ANSI_GREEN + "Zoinks" + ANSI_RESET, 00, "From sale of Stock you get $50", false));
        communityChest.add(new Card(ANSI_GREEN + "Zoinks" + ANSI_RESET, 00, "XMAS Fund Matures, collect $100", false));
        
        
        chance.add(new Card(ANSI_RED + "Jinkies" + ANSI_RESET, 00, "Advance to Go(Collect $200)", false));
        chance.add(new Card(ANSI_RED + "Jinkies" + ANSI_RESET, 00, "Advance to Illinois Ave. - if you pass Go, collect $200", false));
        chance.add(new Card(ANSI_RED + "Jinkies" + ANSI_RESET, 00, "Advance token to the nearest Utility.\nIf unowned, you may buy it from the Bank.\nIf owned, throw dice and pay owner a total of 10 times the amount shown.", false));
        chance.add(new Card(ANSI_RED + "Jinkies" + ANSI_RESET, 00, "Advance token to the nearest Railroad.\nIf unowned, you may buy it from the Bank.\nIf owned, pay the owner twice the amount that they are entitled", false));
        chance.add(new Card(ANSI_RED + "Jinkies" + ANSI_RESET, 00, "Advance token to the nearest Railroad.\nIf unowned, you may buy it from the Bank.\nIf owned, pay the owner twice the amount that they are entitled", false));
        chance.add(new Card(ANSI_RED + "Jinkies" + ANSI_RESET, 00, "Advance to St. Charles Place - if you pass Go, collect $200", false));
        chance.add(new Card(ANSI_RED + "Jinkies" + ANSI_RESET, 00, "Bank pays you dividend of $50", false));
        chance.add(new Card(ANSI_RED + "Jinkies" + ANSI_RESET, 00, "Get out of Jail free.", false));
        chance.add(new Card(ANSI_RED + "Jinkies" + ANSI_RESET, 00, "Go back 3 spaces", false));
        chance.add(new Card(ANSI_RED + "Jinkies" + ANSI_RESET, 00, "You are assessed for street repairs, pay $25 for each house and $100 for each hotel", false));
        chance.add(new Card(ANSI_RED + "Jinkies" + ANSI_RESET, 00, "Pay Poor tax of $15", false));
        chance.add(new Card(ANSI_RED + "Jinkies" + ANSI_RESET, 00, "Take a trip on the Reading Railroad - if you pass Go, collect $200", false));
        chance.add(new Card(ANSI_RED + "Jinkies" + ANSI_RESET, 00, "Take a walk on the Boardwalk - advance token to Boardwalk", false));
        chance.add(new Card(ANSI_RED + "Jinkies" + ANSI_RESET, 00, "You have been elected Chairman of the board, pay each player $50", false));
        chance.add(new Card(ANSI_RED + "Jinkies" + ANSI_RESET, 00, "Building Loan Matures, collect $150", false));
	}
}
