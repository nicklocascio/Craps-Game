import java.util.Scanner;

public class CrapsGame
	{
	static int totalDice;
	static int dice1;
	static int dice2;
	static int point;
	static int wager;
	static int balance = 100;
	static int money;
	public static int rollDice()
		{
		dice1 = (int)(Math.random()*6)+1;
		dice2 = (int)(Math.random()*6)+1;
		totalDice = dice1 + dice2;
		return totalDice;
		}
	public static int takeWager()
		{
		System.out.println("How much would you like to wager?");		
		Scanner wager = new Scanner(System.in);
		money = wager.nextInt();
		if(money > balance || money < 0)
			{
			takeWager();
			}
		return money;
		}
	public static void main(String[] args)
		{
		Scanner greeting = new Scanner(System.in);
		System.out.println("What is your name?");
		String name = greeting.nextLine();
		System.out.println("Hello " + name + ". You have $" + balance);
		takeWager();
		System.out.println("You wagered $" + money);
		System.out.println("Rolling dice now.");
		boolean stillRolling = true;
		rollDice();
			{
			if(totalDice == 7 || totalDice == 11)
				{
				System.out.println(name + ", you rolled a " + dice1 + " and a " + dice2 + " for a total of " + totalDice + ". You won!");
				stillRolling = false;
				System.out.println("You now have $" + (100 + money));
				}
			else if(totalDice == 2 || totalDice == 12)
				{
				System.out.println(name + ", you rolled a " + dice1 + " and a " + dice2 + " for a total of " + totalDice + ". You lost. I'm sorry!");
				stillRolling = false;
				System.out.println("You now have $" + (100 - money));
				}
			else
				{
				System.out.println(name + ", you rolled a " + dice1 + " and a " + dice2 + " for a total of " + totalDice + ". Your point is: " + totalDice);
				stillRolling = true;
				point = totalDice;
				Scanner rollAgain = new Scanner(System.in);
				System.out.println("Press enter to roll again.");
				String hello = rollAgain.nextLine();
				}
			}
		while(stillRolling)
			{
			rollDice();
				{
				if(totalDice == point)
					{
					System.out.println("You rolled a " + dice1 + " and a " + dice2 + " for a total of " + totalDice + ", which matches your point. You win!");
					stillRolling = false;
					System.out.println("You now have $" + (100 + money));
					}
				else if(totalDice == 7)
					{
					System.out.println("You rolled a " + dice1 + " and a " + dice2 + " for a total of " + totalDice + ". You lost. I'm sorry, " + name);
					stillRolling = false;
					System.out.println("You now have $" + (100 - money));
					}
				else
					{
					System.out.println("Your point is " + point + ", but you rolled a " + dice1 + " and a " + dice2 + " for a total of " + totalDice );
					stillRolling = true;
					Scanner rollAgain = new Scanner(System.in);
					System.out.println("Press enter to roll again.");
					String hello = rollAgain.nextLine();
					}
				}
			}
		}
	}
