/* In this class (ConnectFourProcess) this is where the bulk of the programming is done.
Here we are creating our gameboard that's being used, the process for the pieces to be set onto the board,
and how the program will determine if there's a winner. 
*/

import java.util.Scanner;
import java.util.Random;

public class ConnectFourProcessProgress {

   //Here we are creating a field as we will be using this variable in multiple classes and methods
   //Here I was trying to create a variable newGame that we would alter with the menuSelection method: public static int newGame = 1;
	public static String[][] createPattern() {

		// Right here we are creating a 2d String array that has 7 rows and 15 columns
		String[][] gameBoard = new String[7][15];

		/* Here we use a nested for loop to insert our lines and spaces into the
		   specific indexes of the 2d array.
		   Using a nested for loop makes the inner for loop complete its iterations
		   before moving to the outer loop again then it will repeat the process */
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {

				/* If a column goes into 2 with a 0 remainder then we will add a line in that
				   index */
				if (j % 2 == 0)
					gameBoard[i][j] = "|";

				// If it doesn't go into 2 then it will add a space in the index
				else
					gameBoard[i][j] = " ";

				/*  If the index of the row is = to 6 then we are creating the bottom of the
				   board */
				if (i == 6)
					gameBoard[i][j] = "-";
			}
		}

		// We are returning the pattern that we have created
		return gameBoard;
	}

	// This method is printing the pattern to the console
	public static void printPattern(String[][] gameBoard) {
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				System.out.print(gameBoard[i][j]);
			}
			System.out.println();
		}
	}

	/* In this method we place the string "R" into the specified index for the Red
	   piece */
	public static void dropRed(String[][] gameBoard) {

		System.out.println("Drop a red piece at column (0-6): ");

		// Here we take in user input the can select a number between 0-6 or 7 if they want to access the menu
		Scanner scan = new Scanner(System.in);

		/* Then we perform this equation which puts it in an open space index not one
		   that already contains a line, or the bottom of the board */
		int red = 2 * scan.nextInt() + 1;
      
       /*Here is where I have the menu methods run if red == 15
      if (red == 15) {
       menuScreen();
       process.menuSelection();
       printPattern(gameBoard);
       
       This right here is the coding that will happen if resume is hit as it exits out of the menuSelection loop
       and will resume the game like normal but it'll need to prompt the user to enter a valid number
       
       System.out.print("Red please select a column: ");
       red = 2 * scan.nextInt() + 1;
       
       while ((red < 0) || (red > 13)) {
    
         System.out.println("Invalid number, please try a number 0-6:");
         red = 2 * scan.nextInt() + 1;
         
         if ((red >= 0) && (red <= 13 )) {
            break;
            } 
      }
       
     } else
      */
      if(red == 16){
		  menuScreen();
	  }
      
      /* In this while loop we are testing the user input to make sure it follows within the range of 0-6 and 7
      if not we prompt them to enter a valid number other wise it crashes the program.*/
      while ((red < 0) || (red > 13)) {
    
         System.out.println("Invalid number, please try a number 0-6:");
         red = 2 * scan.nextInt() + 1;
         
         if ((red >= 0) && (red <= 13 )) {
            break;
            } 
      }      
      
      /* This is a for loop to determine how the program should go about placing the red user's desire piece */
		for (int i = 6; i >= 0; i--) {
                
         if ((gameBoard[0][red] == "B") || (gameBoard[0][red] == "R")) {
         
         //In this while loop we are testing to see if the column is full, if so it'll prompt the user to enter another input.
             while ((gameBoard[0][red] == "B") || (gameBoard[0][red] == "R")) {           
               System.out.println("Column full, please enter a different column: ");
               red = 2 * scan.nextInt() + 1;
             }
         } 
         
			/* This is a condition that runs and it says if there is a blank space where the
			    user wanted to put the piece then put it in that index */        
         if (gameBoard[i][red] == " ") {
				gameBoard[i][red] = "R";
				break;
			}
		}      

	}

	/* In this method we place the string "B" into the specified index for the Blue
	   piece */
	public static void dropBlue(String[][] gameBoard) {

		System.out.println("Drop a blue Piece at column (0-6): ");

		// Here we take in user input the can select a number between 0-6
		Scanner scan = new Scanner(System.in);

		/* Then we perform this equation which puts it in an open space index not one
		   that already contains a line, or the bottom of the board */
		int blue = 2 * scan.nextInt() + 1;
                
      /* In this while loop we are testing the user input to make sure it follows within the range of 0-6 and 
      if not we prompt them to enter a valid numberother wise it crashes program.*/
      while ((blue < 0) || (blue > 13)) {
    
         System.out.println("Invalid number, please try a number 0-6:");
         blue = 2 * scan.nextInt() + 1;
         
         if ((blue >= 0) && (blue <= 13 )) {
            break;
            } 
      }

      /* This is a for loop to determine how the program should go about placing the blue user's desire piece */
		for (int i = 6; i >= 0; i--) {
                
         if ((gameBoard[0][blue] == "B") || (gameBoard[0][blue] == "R")) {
         
         //In this while loop we are testing to see if the column is full, if so it'll prompt the user to enter another input.
             while ((gameBoard[0][blue] == "B") || (gameBoard[0][blue] == "R")) {           
               System.out.println("Column full, please enter a different column: ");
               blue = 2 * scan.nextInt() + 1;
             }
         } 
         
         
			/* This is a condition that runs and it says if there is a blank space where the
			    user wanted to put the piece then put it in that index. */         
         if (gameBoard[i][blue] == " ") {
				gameBoard[i][blue] = "B";
				break;
			}
		}
	}
   
   
   /* In this method we are playing against the AI and we are using a random 
   int method to determine where the AI will be placing their piece */
	
   public static void dropRedAI(String[][] gameBoard) {

		System.out.println("AI has selected a move ");

		// Here we are creating an instance so we can use the random method later on to let the AI select a random number
		Random random = new Random();
               
		/* Then we perform this equation which puts it in an open space index not one
		   that already contains a line, or the bottom of the board */
		int red = 2 * random.nextInt(7) + 1;

    /* This is a for loop to determine how the program should go about placing the AI's generated placement */
		for (int i = 6; i >= 0; i--) {
                
         if ((gameBoard[0][red] == "B") || (gameBoard[0][red] == "R")) {
         
         /*In this while loop we are testing to see if the column is full, if so the program
         will keep generating until it has a valid column number */
             while ((gameBoard[0][red] == "B") || (gameBoard[0][red] == "R")) {           
               red = 2 * random.nextInt(7) + 1;
             }
         } 
         
         
			/* This is a condition that runs and it says if there is a blank space where the
			    program wanted to put the piece then put it in that index. */         
         if (gameBoard[i][red] == " ") {
				gameBoard[i][red] = "R";
				break;
			}
		}
		
	}

	/* In this method we check all the possibilities of a win
	   We use some conditional statements in a nested for loop to check to
	   see if there is four connected, so for index "space" contains four of the
	   same strings "pieces" Then there is a winner */
	public static String checkWinner(String[][] gameBoard) {

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j += 2) {
				if ((gameBoard[i][j + 1] != " ") && (gameBoard[i][j + 3] != " ") && (gameBoard[i][j + 5] != " ") && (gameBoard[i][j + 7] != " ")
						&& ((gameBoard[i][j + 1] == gameBoard[i][j + 3]) && (gameBoard[i][j + 3] == gameBoard[i][j + 5])
								&& (gameBoard[i][j + 5] == gameBoard[i][j + 7])))
					return gameBoard[i][j + 1];
			}
		}
		for (int i = 1; i < 15; i += 2) {
			for (int j = 0; j < 3; j++) {
				if ((gameBoard[j][i] != " ") && (gameBoard[j + 1][i] != " ") && (gameBoard[j + 2][i] != " ") && (gameBoard[j + 3][i] != " ")
						&& ((gameBoard[j][i] == gameBoard[j + 1][i]) && (gameBoard[j + 1][i] == gameBoard[j + 2][i]) && (gameBoard[j + 2][i] == gameBoard[j + 3][i])))
					return gameBoard[j][i];
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 1; j < 9; j += 2) {
				if ((gameBoard[i][j] != " ") && (gameBoard[i + 1][j + 2] != " ") && (gameBoard[i + 2][j + 4] != " ") && (gameBoard[i + 3][j + 6] != " ")
						&& ((gameBoard[i][j] == gameBoard[i + 1][j + 2]) && (gameBoard[i + 1][j + 2] == gameBoard[i + 2][j + 4])
								&& (gameBoard[i + 2][j + 4] == gameBoard[i + 3][j + 6])))
					return gameBoard[i][j];
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 7; j < 15; j += 2) {
				if ((gameBoard[i][j] != " ") && (gameBoard[i + 1][j - 2] != " ") && (gameBoard[i + 2][j - 4] != " ") && (gameBoard[i + 3][j - 6] != " ")
						&& ((gameBoard[i][j] == gameBoard[i + 1][j - 2]) && (gameBoard[i + 1][j - 2] == gameBoard[i + 2][j - 4])
								&& (gameBoard[i + 2][j - 4] == gameBoard[i + 3][j - 6])))
					return gameBoard[i][j];
			}
		}
		/* If none of these conditions are met then return null and continue on with the
		   program */
		return null;
	}
      //In this method we are creating our menu screen 
      public static void menuScreen(){
         Scanner scan = new Scanner(System.in);
         System.out.println("+----------------------+");
         System.out.println("|         Menu         |");
         System.out.println("+----------------------+");
         System.out.println("| Press 1 for new game |");
         System.out.println("| Press 2 to exit      |");
         System.out.println("+----------------------+");
		 System.out.print("Enter your selection: ");
		 menuSelection();
		 System.out.println();
		 
      }
       /*In this method we are evaluating the user's input and performing the appropriate action selected. This is where I'm mainly having troubles with as I'm trying to figure
       out how to update the newGame variable in the main class based off the following method*/
         public static int menuSelection(){
            Scanner scan = new Scanner(System.in);
            int returnValue = 1;
            int menuOption = scan.nextInt();
        
       //This while statement is used to determine whether or not the user is selecting a valid option from the menu screen.
            while((menuOption < 0)||(menuOption > 2)) {
                System.out.print("Not a valid option, please press 1 for new game or 2 to resume: ");
                menuOption = scan.nextInt();
            }
              
            if(menuOption == 1 ){
               returnValue = 0;
            }
            if(menuOption == 2){
               returnValue = 1;
            }
            return returnValue;
       }
      
     
       
}