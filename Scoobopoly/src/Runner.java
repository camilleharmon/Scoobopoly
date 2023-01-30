import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;
import java.io.*;

public class Runner {

	static ArrayList <Property> board = new ArrayList<Property>();
	static ArrayList <Card> chance = new ArrayList<Card>();
	static ArrayList <Card> communityChest = new ArrayList<Card>();
	static Scanner file;
	
	public static void main(String[] args) throws IOException {
		
		chooseTheme();
		makeBoard();
		fillDecks();
		
		
	}
	
	public static void chooseTheme() throws IOException{
		
		Scanner userIntInput = new Scanner(System.in);
		System.out.println("");
        System.out.println("What theme would you like to play?");
		System.out.println("   1) Classic");
		System.out.println("   2) Scooboploy");

		int theme = userIntInput.nextInt();

		if(theme == 1) {				
			
			System.out.println("No, we're doin Scooby.");
			file = new Scanner(new File("Scoobopoly.txt"));
		}else if(theme == 2) {				
			
			System.out.println("Scooby it is!");
			file = new Scanner(new File("Scoobopoly.txt"));
		}else {				
			System.out.println("Please chose a valid answer.");
			chooseTheme();
		}
	}
	
	public static void makeBoard() throws IOException{
		
		System.out.println("Making board");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Making board.");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Making board..");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Making board...");
		
		//Scanner file = new Scanner(new File("Scoobopoly.txt"));
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
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Board Complete!");
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
