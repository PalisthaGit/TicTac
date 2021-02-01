import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTac {
	static ArrayList<Integer> playerPosition= new ArrayList<Integer>();
	static ArrayList<Integer> cpuPosition= new ArrayList<Integer>();
	private static String checkWinner;

	public static void main(String[] args) {

		char[][] gameBoard = { { ' ', '|', ' ', '|', ' ' }, { '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' },
				{ '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' } };

		printGameBoard(gameBoard);

		while (true)
		{
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter position");

			int playerPos = scan.nextInt();
			System.out.println(playerPos);
			
			while(playerPosition.contains(playerPos)|| cpuPosition.contains(playerPos))
			{
				System.out.println("Position taken. Enter another position");
				playerPos=scan.nextInt();
			}
			placePiece(gameBoard, playerPos, "player");
			
			String result=checkWinner();
			if(result.length()>0) {
				System.out.println(result);
				break;
				
			}
			
	        Random random= new Random();
	        int cpuPos=random.nextInt(9)+1;
	        
	        while(playerPosition.contains(cpuPos)|| cpuPosition.contains(cpuPos))
			{
				System.out.println("Position taken. Enter another position");
				cpuPos=random.nextInt(9)+1;
			}
			placePiece(gameBoard, cpuPos, "cpu");
			printGameBoard(gameBoard);
			
			result=checkWinner();
			if(result.length()>0) {
				System.out.println(result);
				break;
				
			}
			
			
		}
		
	

	}

	public static void printGameBoard(char[][] gameBoard) {
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard.length; j++) {
				System.out.print(gameBoard[i][j]);

			}
			System.out.println();
		}
	}

	public static void placePiece(char[][] gameBoard, int pos, String user) {
		
		char symbol=' ';
		if(user.equals("player")) {
			symbol='X';
			playerPosition.add(pos);
			
			
		}
		else if(user.equals("cpu")) {
			symbol='O';
			cpuPosition.add(pos);
		}

		switch (pos) {
		case 1:
			gameBoard[0][0] = symbol;
			break;

		case 2:
			gameBoard[0][2] = symbol;
			break;

		case 3:
			gameBoard[0][4] = symbol;
			break;

		case 4:
			gameBoard[2][0] = symbol;
			break;

		case 5:
			gameBoard[2][2] = symbol;
			break;

		case 6:
			gameBoard[2][4] = symbol;
			break;

		case 7:
			gameBoard[4][0] = symbol;
			break;

		case 8:
			gameBoard[4][2] = symbol;
			break;

		case 9:
			gameBoard[4][4] = symbol;
			break;
		}
		printGameBoard(gameBoard);
	}
	

	public static String checkWinner()
	
	{
		List topRow= Arrays.asList(1,2,3);
		List midRow= Arrays.asList(4,5,6);
		List bottomRow= Arrays.asList(7,8,9);
		
		List leftCol= Arrays.asList(1,4,7);
		List midCol= Arrays.asList(2,5,8);
		List rightCol= Arrays.asList(3,6,9);
		
		List cross1= Arrays.asList(1,5,9);
		List cross2= Arrays.asList(3,5,7);
		
		List<List> winning= new ArrayList<List>();
		winning.add(topRow);
		winning.add(midRow);
		winning.add(bottomRow);
		winning.add(leftCol);
		winning.add(midCol);
		winning.add(rightCol);
		winning.add(cross1);
		winning.add(cross2);
		
		for(List l: winning)
		{
			if(playerPosition.containsAll(l))
			{
				return "Congratulations you win";
				
			}
			else if(cpuPosition.containsAll(l))
			{
				return "CPU wins";
			}
			else if(playerPosition.size()+cpuPosition.size()==9) {
				return "CAT";
				
			}
			
		
		}
		return "";	
	}

}
