/*In this class(ConnectFourStart) is where our methods that are called at the launch of the program are stored. 
It gives a description of what the user can expect and helps with the proceess of running the mode selected. */
import java.util.Scanner;

public class ConnectFourStartProgress {

      //This is just the welcoming screen letting the user know what's going on
      public static void welcome() {
        System.out.println ();
         System.out.println ("Hello this is connect 4, similiar to tic-tac-toe the goal is to connect 4 in a row before your opponent.");
         System.out.println("Below is the game board along with numbers attached to each column indicating the number of the column:");
         System.out.println();
         }

      public static String[][] exampleBoard() {
      
      // We are creating a 2d String array that has 8 rows and 15 columns	
         String[][] previewBoard = new String[8][15];

		// Similiar to the game board method this is the same process but with an extra row numbering the columns
	    	for (int i = 0; i < previewBoard.length; i++) {
			   for (int j = 0; j < previewBoard[i].length; j++) {

			   	/* If a column goes into 2 with a 0 remainder then we will add a line in that
				   index */
			   	if (j % 2 == 0)
					previewBoard[i][j] = "|";

			   	// If it doesn't go into 2 then it will add a space in the index
			   	else
			   		previewBoard[i][j] = " ";
   
			   	/*  If the index of the row is = to 6 then we are creating the bottom of the
			   	    board */
				   if (i == 6)
				   	previewBoard[i][j] = "-";
           
             /* Due to every other j value needing to be a specific number we just decided to hard code as we weren't needing to do a whole lot of coding for this part */
             
             if (i == 7) {
               if (j % 2 == 0) {
                  previewBoard[i][j] = "-";
                  
               } else if (j == 1)  
                   previewBoard[i][j] = "0";
               
                 else if (j == 3)  
                   previewBoard[i][j] = "1";
                   
                 else if (j ==5)  
                   previewBoard[i][j] = "2";
                   
                 else if (j ==7)  
                   previewBoard[i][j] = "3";
                  
                 else if (j ==9)  
                   previewBoard[i][j] = "4";
              
                 else if (j ==11)  
                   previewBoard[i][j] = "5";
               
                 else if (j ==13)  
                   previewBoard[i][j] = "6";
               
            }        
			 
			}  
		}  
      return previewBoard;
     }
     
   
     //In this method we are printing the previewBoard we previously created.
     	public static void printPreview(String[][] previewBoard) {
		   for (int i = 0; i < previewBoard.length; i++) {
		   	for (int j = 0; j < previewBoard[i].length; j++) {
		   		System.out.print(previewBoard[i][j]);
		   	}
		   	System.out.println();
		   }
	    }
       
     //In this method we are taking the user's input to determine the game mode selected
     public static int gameMode() {
          
         //Here we are creating an object for the Scanner function
         Scanner scan = new Scanner(System.in);
         
         int mode = scan.nextInt();
         
         return mode;
       
       }
}     

