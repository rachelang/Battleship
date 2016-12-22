import java.util.Scanner;
import java.util.Random;

public class Battleship
{
private int board[][];
private Random generator;
public static void main(String args[])
{
    System.out.print("\f");
  int intro = 1;
  //introduction
    while(intro==1){
System.out.println("BATTLESHIP"); 
System.out.println("__________");
System.out.println("");
System.out.println("Rules:");
System.out.println("-The computer will randomly place 3 ships, each spanning 3 spaces");
System.out.println(" in random directions.");
System.out.println("-The goal is to guess the location of all parts of the 3 ships.");
System.out.println("-Attempts are unlimited, but the lesser the attempts, the better the rank."); 
System.out.println("***When you hit empty water, the hit will appear as 1.");
System.out.println("***When you successfully hit part of a ship, the hit will appear as 7.");
System.out.println("");
System.out.println("GOOD LUCK!");
Scanner one = new Scanner(System.in);
System.out.println("Press 1 to continue");   
int cont = one.nextInt();
if(cont ==1){break;}

}
    
System.out.print("\f");

//Creates the 2d array for the board that will be DISPLAYED.    
int board[][] = new int [7][];

board[0] = new int[7];
board[1] = new int[7];
board[2] = new int[7];
board[3] = new int[7];
board[4] = new int[7];
board[5] = new int[7];
board[6] = new int[7];
//Creates the corresponding 2d array for the board that will be checked for ship locations. This array will not be displayed.
int Displayboard[][] = new int [7][];

Displayboard[0] = new int[7];
Displayboard[1] = new int[7];
Displayboard[2] = new int[7];
Displayboard[3] = new int[7];
Displayboard[4] = new int[7];
Displayboard[5] = new int[7];
Displayboard[6] = new int[7];

//generates random locations for 3 times
for(int i =1;i<4;i++)
{
Random generator=new Random();
//generate random row
int row=generator.nextInt(7); 
//generate random column
int column=generator.nextInt(7);
//generate random direction
int direction=generator.nextInt(4);
//0 is up
//1 is down
//2 is left
//3 is right

//checks if the coordinates will not be out of bounds. 
if(direction == 0 && (row-2) >= 0 && Displayboard[row][column]!=7 && Displayboard[row-1][column]!=7 && Displayboard[row-2][column]!=7)
{
Displayboard[row][column]=7;
Displayboard[row-1][column]=7;
Displayboard[row-2][column]=7;
}
else if(direction == 1 && (row+2) <= 6 && Displayboard[row][column]!=7 && Displayboard[row+1][column]!=7 && Displayboard[row+2][column]!=7)
{
Displayboard[row][column]=7;
Displayboard[row+1][column]=7;
Displayboard[row+2][column]=7;
}
else if(direction == 2 && (column-2) >= 0 && Displayboard[row][column]!=7 && Displayboard[row][column-1]!=7 && Displayboard[row][column-2]!=7)
{
Displayboard[row][column]=7;
Displayboard[row][column-1]=7;
Displayboard[row][column-2]=7;
}
else if(direction == 3 && (column+2 )<= 6 && Displayboard[row][column]!=7 && Displayboard[row][column+1]!=7 && Displayboard[row][column+2]!=7)
{
Displayboard[row][column]=7;
Displayboard[row][column+1]=7;
Displayboard[row][column+2]=7;
}
else //if out of bounds, it randomly guesses again.
{
    i=i-1;

}

}
int attempts = 0;

System.out.println("BATTLESHIP"); 
System.out.println("__________");
System.out.println("");
System.out.println((attempts)+" attempts");
System.out.println("        COLUMNS");
System.out.println("     1 2 3 4 5 6 7");
System.out.println("     _____________");
String rows = (" ROWS  ");

//prints the board
    for(int i =0;i<7;i++)
{
            System.out.print(rows.charAt(i)+" "+(i+1)+"|");
    for(int j =0;j<7;j++)
    {
   
    System.out.print(" "+board[i][j]);
    }
    System.out.println();
}


int go = 1;

//let the user guess
while(go==1)
{

    Scanner in = new Scanner(System.in);
    System.out.println("Guess Row?");
    int guessRow= in.nextInt()-1;
    //If the guess is out of bounds, the following code will prompt the user again.
    while (guessRow<0 || guessRow>6)
    {
    System.out.println("INVALID GUESS");
        System.out.println("Guess Row?");
    guessRow= in.nextInt()-1;
    }

    System.out.println("Guess Column?");
    int guessColumn= in.nextInt()-1;
    while (guessColumn<0 || guessColumn>6)
    {
          System.out.println("INVALID GUESS");
    System.out.println("Guess Column?");
    guessColumn= in.nextInt()-1;
    }
    System.out.print("\f");
    attempts = attempts+1;
    System.out.println("BATTLESHIP"); 
    System.out.println("__________");
System.out.println("");
String grammar=(" attempts");
if(attempts==1){grammar=grammar.substring(0,8);}
System.out.println((attempts)+grammar);

//checks if the guess hit a ship or empty water
    if(Displayboard[guessRow][guessColumn]==7)
    {
        board[guessRow][guessColumn]=7;
        System.out.println("SUCCESSFUL HIT");
    }
    else
    {
        board[guessRow][guessColumn]=1;
        System.out.println("HIT EMPTY WATER");
    }
    //prints out the board
System.out.println("        COLUMNS");
System.out.println("     1 2 3 4 5 6 7");
System.out.println("     _____________");
//hits stands for the number of ship parts hit. If all ship parts are hit, the player wins.
int hits = 0;

    for(int i =0;i<7;i++)
{
            System.out.print(rows.charAt(i)+" "+(i+1)+"|");
    for(int j =0;j<7;j++)
    {
   
    System.out.print(" "+board[i][j]);
    if(board[i][j]==7)
    {
        hits= hits+1;
    }
    }
    System.out.println();
}
//when the user hits all ships:
if (hits ==9)
{
    System.out.println("ALL SHIPS HIT: SUCCESS!!!");
    //prints out the ranks based on the number of attempts taken
    if(attempts<=10)
    {    System.out.println((attempts)+ " attempts. RANK: CHIEF COMMANDER MASTER");}
    else if(attempts<=20)
     {    System.out.println((attempts)+ " attempts. RANK: CHIEF COMMANDER OFFICER");}    
     else if(attempts<=25)
     {    System.out.println((attempts)+ " attempts. RANK: SENIOR CHIEF PETTY OFFICER");} 
          else if(attempts<=30)
     {    System.out.println((attempts)+ " attempts. RANK: PETTY OFFICER");} 
          else if(attempts<=35)
     {    System.out.println((attempts)+ " attempts. RANK: SEAMAN");} 
          else 
     {    System.out.println((attempts)+ " attempts. RANK: NOOB");} 
        
    break;
    //ends program
}
}



}
}

