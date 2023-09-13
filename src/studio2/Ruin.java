package studio2;
import java.util.Scanner;
public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("What is your starting amount?: ");
		double startingAmount = in.nextDouble();
		double amount = startingAmount;
		double winChance = 0.3;
		int winLimit = 10;
		int numberOfTurn = 0;
		int lostCount = 0;
		String result = " ";
		double a = ((1-winChance)/winChance); 
		double expectedRuinRate = 0; 
		for (int simulation = 1; simulation<=500; simulation++)
		{
			while ((amount <= winLimit) && (amount>0))
			{
				if (Math.random()<=winChance)
				{
					amount++;	
					numberOfTurn++;
				}

				else if (Math.random()>winChance)
				{
					amount--;	
					numberOfTurn++;
				}
			}
			if (amount<=0)
			{
				result = "LOSE";
				lostCount++;
			}

			else if (amount>=winLimit)
			{
				result = "WIN";
			}

			System.out.println("Simulation "+simulation+":" + numberOfTurn + " "+ result);

			numberOfTurn = 0;
			amount = startingAmount;
		}
		if (winChance == 0.5)
		{
			expectedRuinRate = (1-(startingAmount/winLimit));
		}
		else 
		{
			expectedRuinRate = (((Math.pow(a, startingAmount))-(Math.pow(a,  winLimit)))/(1-(Math.pow(a,  winLimit))));
		}
		
	System.out.println("Losses: "+lostCount+" Simulation: 500");
	System.out.println("Ruin Rate from Simulation: "+ (lostCount/500.0) +" Expected Ruin Rate: "+ expectedRuinRate);
	
	}

}


