/* SELF ASSESSMENT

Connect4Game class (35 marks)
My class creates references to the Connect 4 Grid and two Connect 4 Players. It asks the user whether he/she would like to play/quit inside a loop. If the user decides to play then: 1. Connect4Grid2DArray is created using the Connect4Grid interface, 2. the two players are initialised - must specify the type to be ConnectPlayer, and 3. the game starts. In the game, I ask the user where he/she would like to drop the piece. I perform checks by calling methods in the Connect4Grid interface. Finally a check is performed to determine a win. 
Comment: Yep the class references all player classes and the board class and runs a smooth game of connect four

Connect4Grid interface (10 marks)
I define all 7 methods within this interface.
Comment: Yes all seven methods are defined in the most efficient way possible

Connect4Grid2DArray class (25 marks) 
My class implements the Connect4Grid interface. It creates a grid using a 2D array Implementation of the method to check whether the column to drop the piece is valid. It provides as implementation of the method to check whether the column to drop the piece is full. It provides as implementation of the method to drop the piece.  It provides as implementation of the method to check whether there is a win.
Comment: all of those methods are defined and implimented 

ConnectPlayer abstract class (10 marks)
My class provides at lest one non-abstract method and at least one abstract method. 
Comment: yep where to drop is abstract but the rest arent

C4HumanPlayer class (10 marks)
My class extends the ConnectPlayer claas and overrides the abstract method(s). It provides the Human player functionality.
Comment: Yep it does all those things

C4RandomAIPlayer class (10 marks)
My class extends the ConnectPlayer claas and overrides the abstract method(s). It provides AI player functionality. 
Comment: A fully functional though not intelligent ai system.

Total Marks out of 100:

*/
import java.util.Scanner;
public class Connect4Game
{
	static Scanner sc = new Scanner(System.in);

	public static void main (String[] args)
	{
		System.out.println("Welcome to connect four!");
		
		String input = "";
		
		while(!input.equalsIgnoreCase("Quit"))
		{
			System.out.println("If you would like to play, enter 'play'. If you want to quit, enter 'quit'. \n Enter now.");
			input = sc.next();
			if(input.equalsIgnoreCase("play"))
			{
				setUpGame();
			}
			else if(!input.equalsIgnoreCase("quit"))
			{
				System.out.println("That's not a valid option.");
			}
			
		}
		System.out.println("Goodbye!");
	}
	public static void setUpGame()
	{
		ConnectFourGrid2DArray board = new ConnectFourGrid2DArray();
		
		ConnectPlayer p1 = null;
		ConnectPlayer p2 = null;
		
		
		String input = "";
		while(!input.equalsIgnoreCase("ai") && !input.equalsIgnoreCase("human"))
		{
			System.out.println("Would you like the first player to be a 'human' or an 'ai'?");
			input = sc.next();
			
		
			if(input.equalsIgnoreCase("AI"))
				p1 = new C4RandomAIPlayer("Y");
			else if(input.equalsIgnoreCase("human"))
			{
				System.out.println("What is your name?");
				String name = sc.next();
				
				p1 = new C4HumanPlayer("Y",name);
			}
			else
				System.out.println("Not a valid Input");
		}

		
		input = "";
		while(!input.equalsIgnoreCase("ai") && !input.equalsIgnoreCase("human"))
		{
			System.out.println("Would you like the second player to be a 'human' or an 'ai'?");
			input = sc.next();
			
			if(input.equalsIgnoreCase("AI"))
				p2 = new C4RandomAIPlayer("R");
			else if(input.equalsIgnoreCase("human"))
			{
				System.out.println("What is your name?");
				String name = sc.next();
				
				p2 = new C4HumanPlayer("R",name);
			}
			else
				System.out.println("Not a valid Input");
		}
		
		playC4(board,p1,p2);
	}
	public static void playC4(ConnectFourGrid2DArray board, ConnectPlayer p1, ConnectPlayer p2)
	{
		int turn = 1;
		while(p1.getWon() == false && p2.getWon() == false && board.isGridFull() == false)
		{
			System.out.println(board.toString());
			
			if(turn % 2 == 1)
			{
				p1.whereToDrop(board);
			}
			else
			{
				p2.whereToDrop(board);
			}
			turn++;
		}
		
		System.out.println(board.toString());
		
		if(p1.getWon() == true)
			System.out.println("Player one won!");
		else if(p2.getWon() == true)
			System.out.println("Player two won!");
		else
			System.out.println("It was a tie.");
	}

}