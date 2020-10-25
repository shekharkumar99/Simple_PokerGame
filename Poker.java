import java.util.Arrays;
import java.util.Scanner; 
//for sorting arrays

public class Poker {
	public static void main(String[] args) {
		
		String ans = "y" ;
		int player1 =0; //Number of rounds won by player1
		int player2 =0; //Number of rounds won by player2
		Scanner sc = new Scanner(System.in);
		
	while(ans.equals( "y") || ans.equals( "Y")) {
		
		System.out.println("Enter the cards");
		
		String line = sc.nextLine();
		String []cards = line.split(" ");
		
	

		if (cards.length > 10) {
			System.out.println("NOT UNDERTAKEN");
			System.exit(0);
		} // this program cannot handle more than 5 arguments
		
		if (cards.length < 10) {
			System.out.println("Error: Enter Atleast 10 Cards");
			System.exit(0);
		} // only 10 cards can form a poker hand
		
		int[] Player1_ranks = new int[5];
		// this array is for the rank of each card
		char[] Player1_suits = new char[5];
        // this array is for the suit of each card
        int[] Player2_ranks = new int[5];
		// this array is for the rank of each card
		char[] Player2_suits = new char[5];
		// this array is for the suit of each card
		
		
		for (int i = 0; i < 10; i++) {
			if (cards[i].length() != 2) {
				System.out.println("Error: invalid card name '" 
						+ cards[i] + "'");
				System.exit(0);
				// if an argument doesn't contain 2 characters
	            // it's not a valid card
            }
			// Split the cards for two players
            if(i<5){
			
			Player1_ranks[i] = rank.toNum(cards[i].toUpperCase().charAt(0));
            Player1_suits[i] = suit.toSuit(cards[i].toUpperCase().charAt(1));
            }
            else {
            	int j =5;
            Player2_ranks[i - j] = rank.toNum(cards[i].toUpperCase().charAt(0));
            Player2_suits[i -j] = suit.toSuit(cards[i].toUpperCase().charAt(1));
            

            }
			
        }
		
		//Hand Evaluation for player 1
        Arrays.sort(Player1_ranks); // sorting array
		
		boolean str_player1 = rank.findStraight(Player1_ranks); // if there is a straight
		boolean flu_player1 = suit.findFlush(Player1_suits); // if there is a flush
		int maxfreq_player1 = rank.findMode(Player1_ranks)[0];
		// highest frequency of a rank in ranks
		int mode_player1 = rank.findMode(Player1_ranks)[1]; 
		// mode of ranks
		int anotherpair_player1 = rank.findAnotherPair(Player1_ranks);
		// if there is another pair, what it is
		
		String maxrank_player1 = rank.toRank(Player1_ranks[4]);
		boolean Royalflush_player1 = rank.Royalflush(Player1_ranks);
		
		
		//  Hand Evaluation for player 2
		Arrays.sort(Player2_ranks);
		boolean str_player2 = rank.findStraight(Player2_ranks); // if there is a straight
		boolean flu_player2 = suit.findFlush(Player2_suits); // if there is a flush
		int maxfreq_player2 = rank.findMode(Player2_ranks)[0]; 
		// highest frequency of a rank in ranks
		int mode_player2 = rank.findMode(Player2_ranks)[1]; 
		// mode of ranks
		int anotherpair_player2 = rank.findAnotherPair(Player2_ranks);
		// if there is another pair, what it is
		
		String maxrank_player2 = rank.toRank(Player2_ranks[4]);
		boolean Royalflush_player2 = rank.Royalflush(Player2_ranks);
		
		//Check the cards for each player
//		for(int value :Player1_ranks)
//		{
//			System.out.println(value);
//		}
//		for(int value :Player2_ranks)
//		{
//			System.out.println(value);
//		}
		
		
		//Evaluating Hands
		// Check for Royal FLush
		if(Royalflush_player1) {
			player1 ++;
		}
		else if(Royalflush_player2) {
			player2++;
		}
		
		// Check for Straight Flush
		else if(str_player1 && flu_player1) {
			player1++;
			
		}
		else if(str_player2 && flu_player2) {
			player2++;
		}
		
		//Check for Four of a kind
		else if(maxfreq_player1 >= 4 && maxfreq_player2 >= 4) {
			if(mode_player1 > mode_player2){
				player1++;
			}
			else {
				player2++;
			}
		}
		else if(maxfreq_player1 == 4){
			player1 ++;
			
		}
		else if(maxfreq_player2 == 4){
			player2 ++;
			
		}
		
		 // Check for Straight
		else if(str_player1 && str_player2) {
			if(Player1_ranks[4] > Player2_ranks[4]) {
				player1 ++;
			}
			else {
				player2++;
			}
		}
		else if(str_player1) {
			player1 ++;
		}
		else if(str_player2) {
			player2 ++;
		}
		
		//Check for Flush
		else if(flu_player1 && flu_player2) {
			if(Player1_ranks[4] > Player2_ranks[4]) {
				player1 ++;
			}
			else {
				player2++;
			}
			
		}
		else if(flu_player1) {
			player1 ++;
		}
		else if(flu_player2) {
			player2 ++;
		}
		
		// Check for three of a kind
		else if(maxfreq_player1 ==3 && maxfreq_player2 ==3) {
			if(mode_player1 > mode_player2) {
				player1++;
			}
			else {
				player2++;
			}
			
			
		}
		else if(maxfreq_player1 == 3) {
			player1 ++;
			
		}
		else if(maxfreq_player2 == 3) {
			player2 ++;
			
		}
		
		//Check for Two pair
		else if (maxfreq_player1 == 2 && anotherpair_player1 != 0 && maxfreq_player2 ==2 && anotherpair_player2 != 0)
		{
			if(anotherpair_player1 > anotherpair_player2) {
				player1++;
			}
			else {
				player2++;
			}
			
		}
		else if(maxfreq_player1 == 2 && anotherpair_player1 != 0) {
			player1 ++;
		}
		else if(maxfreq_player2 == 2 && anotherpair_player2 != 0) {
			player2 ++;
		}
		
		// Check for Pair
		else if (maxfreq_player1 == 2 && anotherpair_player1 == 0 && maxfreq_player2 ==2 && anotherpair_player2 == 0)
		{
			if(mode_player1 > mode_player2) {
				player1++;
			}
			else {
				player2++;
			}
			
		}
		else if(maxfreq_player1 == 2 && anotherpair_player1 == 0) {
			player1 ++;
		}
		else if(maxfreq_player2 == 2 && anotherpair_player2 == 0) {
			player2 ++;
		}
		// High Card
		else if(Player1_ranks[4] > Player2_ranks[4])
		{
			player1 ++;
		}
		else {
			player2 ++;
		}
		
		//Display Result
		System.out.println("Player 1 won : " + player1);
		System.out.println("Player 2 won : " + player2);
		// To play again press y
		System.out.println("Press Y to Play Again");
		ans = sc.nextLine();
		
	}
	sc.close();
	System.exit(1);
		
	}
	
}