/*Kody Berry and Jevon Castaneda
This is our main class <ConnectFour) that starts the actual program. Incorporating the ConnectFourProcess, ConnectFourStart class, as well as, 
it's own coding it launches a game of connect four. You could either play against the computer or a friend.*/


import java.util.Scanner;

public class ConnectFourProgress {

   	// This is the main method that runs all of the above code.
   	public static void main(String[] args) {
         
         //Here we are initializing a variable which plays a role in restarting the program or ending it entirely
         int programEnd = 1;
        
         while (programEnd == 1){
         
            //This is creating objects for our ConnectFourProcess and our ConnectFourStart class
            ConnectFourProcessProgress connectFourProcess = new ConnectFourProcessProgress ();
            ConnectFourStartProgress connectFourStart = new ConnectFourStartProgress ();
            Scanner scan = new Scanner(System.in);
            int newGame = 1;
            
           //Here I was trying to run a while loop statement based off the value of newGame which I'm trying to have it be altered in the ConnectFourProcessProgress class in the menuSelection method. 
           // while (newGame == 1) {
           //newGame = connectFourProcess.menuSelection();
            
            //We are calling upon on our ConnectFourStart to inform the user of the process
            connectFourStart.welcome();
      
            //Here we are creating that example board 
            String[][] previewBoard = connectFourStart.exampleBoard();
         
            //Here we are creating that previous example board
            connectFourStart.printPreview(previewBoard);
            System.out.println();
            
            //Here we are determining what game mode has been selected from the user
            System.out.print("Press 1 to face a friend or 2 to face the computer: ");
            int mode = connectFourStart.gameMode();
         
            //Here we are using a while loop to ensure the user selects a valid game mode
            while ((mode < 1) || (mode > 2)) {
               System.out.println("Not a valid game mode, enter 1 to face a friend or 2 to face the computer");
               mode = connectFourStart.gameMode();  
               
            }
   
		      // We are creating our board here
		      String[][] gameBoard = connectFourProcess.createPattern();
   
		      /* This boolean will be set as true and once it changes to false in the loop
		      below then we know that we have a winner */
		      boolean loop = true;
   
		      // This is used to know which players turn it is
		      int count = 0;
		      connectFourProcess.printPattern(gameBoard);
		      
            while (loop) {
   
   
		         	// Conditional to know whether it is reds turn or not as well as a nested if loop to determine if the AI needs to be place a piece dependending on the mode selected.
		         	if (count % 2 == 0) {
                     if (mode == 1) {
                        connectFourProcess.dropRed(gameBoard);
                        /*Here is where you would put the break out statement if the newGame variable is changed to 0
                          if (newGame == 0){
                            break;
                          }
                        */
                     }
                     if (mode == 2) {
                        connectFourProcess.dropRedAI(gameBoard);
                     }
   
		      		// Conditional to know whether it is blues turn or not
		         	} else {
                        connectFourProcess.dropBlue(gameBoard);
                     }
		      	

			         // We increment count here so that we can alternate turns
			         count++;

			         // This updates the board
			         connectFourProcess.printPattern(gameBoard);

			         /* If the checkWinner method doesn't return null then this
			         will decide who the winner is */
			         if (connectFourProcess.checkWinner(gameBoard) != null) {
			           	 if (connectFourProcess.checkWinner(gameBoard) == "R") {
			         		 System.out.println("Red player is the winner!");
			      	 } else if (connectFourProcess.checkWinner(gameBoard) == "B") {
			   		       System.out.println("Blue player is the winner!");
			   	   }

			   	// Breaks out of the loop thus ending the program
			   	loop = false;
			   }
            
         }
        
          /*If a winner has been declared, this code will take the user's input and decide whether or not 
          restart the program or to end it completely*/
          System.out.println("Press 1 to start over or 2 to end the program: ");
       
          programEnd = scan.nextInt();  
       
            if ((programEnd < 1) ||(programEnd > 2 )){
       
               while ((programEnd < 1) ||(programEnd > 2 )){
       
                 System.out.println("Not valid press 1 to restart or 2 to exit out");
       
                 programEnd = scan.nextInt();
               }
            }
            
            if (programEnd == 2){
               break;
            } 
           
	   }   //parameter for the while loop for programEnd
      }
       /* pebble distribution:
       Kody Berry: 50% 
       Jevon Castaneda: 50%  */
}
