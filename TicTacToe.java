import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        char choice, winner;
        int player, userSelectedRow, userSelectedColumn;
        String play;

        char[][] grid = new char[3][3];

        player = rand.nextInt(2) + 1;

        //User Chooses to exit
        do {
            grid[0][0] = 'A';
            grid[0][1] = 'A';
            grid[0][2] = 'A';
            grid[1][0] = 'A';
            grid[1][1] = 'A';
            grid[1][2] = 'A';
            grid[2][0] = 'A';
            grid[2][1] = 'A';
            grid[2][2] = 'A';
            //Determine the winner
            do {
                //prints tic tac toe board
                //Users Selection
                //Loop until user selects available spot
                if (player == 1) {
                    boolean userSelectedEmptySpot = false;
                    //Loop 3
                    do {

                        System.out.println("Which Row would you like (0-2)?");
                        userSelectedRow = sc.nextInt();
                        System.out.println("Which Column would you like (0-2)?");
                        userSelectedColumn = sc.nextInt();
                        if (grid[userSelectedRow][userSelectedColumn] != 'X' && grid[userSelectedRow][userSelectedColumn] != 'O') {
                            grid[userSelectedRow][userSelectedColumn] = 'X';
                            userSelectedEmptySpot = true;
                            //Set computer to play
                            player = 2;
                        } else {
                            userSelectedEmptySpot = false;
                        }
                    } while (!userSelectedEmptySpot);
                    printGrid(grid);
                }
                //Set Computer to play

                else if (player == 2) {
                    boolean computerSelectedEmptySpot = false;
                    //Loop until valid spot is selected by rand number
                    do {
                        int computerSelectedRow, computerSelectedColumn;
                        computerSelectedColumn = rand.nextInt(3);
                        computerSelectedRow = rand.nextInt(3);

                        if (grid[computerSelectedRow][computerSelectedColumn] != 'X' && grid[computerSelectedRow][computerSelectedColumn] != 'O') {
                            grid[computerSelectedRow][computerSelectedColumn] = 'O';
                            computerSelectedEmptySpot = true;
                            player = 1;
                        } else {
                            computerSelectedEmptySpot = false;
                        }
                    } while (!computerSelectedEmptySpot);
                    printGrid(grid);
                }

                //End of checkWin
                //Loop 2
            } while (checkWin(grid) == 'N'); // Checkwin return N if the 3*3 matrix is not filled and no one is winner.
            //Player exit
            char returnToken = checkWin(grid);
            switch (returnToken) {
                case 'X':
                    printGrid(grid);
                    System.out.println("Player 1 (User) won");
                    break;
                case 'O':
                    printGrid(grid);
                    System.out.println("Player 2 (Computer) won");
                    break;
                case 'D':
                    printGrid(grid);
                    System.out.println("Game is Draw.....");
                    break;
            }
            System.out.println("Do you want to play again? (Yes or No)");
            sc.nextLine();
            play = sc.nextLine();
        } while (play.equalsIgnoreCase("yes"));

    }

    public static char checkWin(char[][] grid) {
        char row1[] = new char[3];
        char row2[] = new char[3];
        char row3[] = new char[3];
        char col1[] = new char[3];
        char col2[] = new char[3];
        char col3[] = new char[3];
        char upD[] = new char[3];
        char downD[] = new char[3];
        //Player Winner
        //player 1 won row 1
        if (grid[0][0] == 'X' && grid[0][1] == 'X' && grid[0][2] == 'X') {
            return 'X';
        }
        //player 1 won row 2
        if (grid[1][0] == 'X' && grid[1][1] == 'X' && grid[1][2] == 'X') {
            return 'X';
        }
        //player 1 won row 3
        if (grid[2][0] == 'X' && grid[2][1] == 'X' && grid[2][2] == 'X') {
            return 'X';
        }
        //player 1 won column 1
        if (grid[0][0] == 'X' && grid[1][0] == 'X' && grid[2][0] == 'X') {
            return 'X';
        }
        //player 1 won column 2
        if (grid[0][1] == 'X' && grid[1][1] == 'X' && grid[2][1] == 'X') {
            return 'X';
        }

        //player 1 won column 3
        if (grid[0][2] == 'X' && grid[1][2] == 'X' && grid[2][2] == 'X') {
            return 'X';
        }
        //player 1 won upD
        if (grid[2][0] == 'X' && grid[1][1] == 'X' && grid[0][2] == 'X') {
            return 'X';
        }
        //player 1 won downD
        if (grid[0][0] == 'X' && grid[1][1] == 'X' && grid[2][2] == 'X') {
            return 'X';
        }
        //Computer Winner
        //
        //
        //
        //Computer won row 1
        if (grid[0][0] == 'O' && grid[0][1] == 'O' && grid[0][2] == 'O') {
            return 'O';
        }
        //Computer won row 2
        if (grid[1][0] == 'O' && grid[1][1] == 'O' && grid[1][2] == 'O') {
            return 'O';
        }
        //Computer won row 3
        if (grid[2][0] == 'O' && grid[2][1] == 'O' && grid[2][2] == 'O') {
            return 'O';
        }
        //Computer won column 1
        if (grid[0][0] == 'O' && grid[1][0] == 'O' && grid[2][0] == 'O') {
            return 'O';
        }
        //Computer won column 2
        if (grid[0][1] == 'O' && grid[1][1] == 'O' && grid[2][1] == 'O') {
            return 'O';
        }
        //Computer won column 3
        if (grid[0][2] == 'O' && grid[1][2] == 'O' && grid[2][2] == 'O') {
            return 'O';
        }
        //Computer won upD
        if (grid[2][0] == 'O' && grid[1][1] == 'O' && grid[0][2] == 'O') {
            return 'O';
        }
        //Computer won downD
        if (grid[0][0] == 'O' && grid[1][1] == 'O' && grid[2][2] == 'O') {
            return 'O';
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == 'X' || grid[i][j] == 'O') {
                    // position filled
                } else {
                    // posittion empty so return no player won but play should continue;
                    return 'N';
                }
            }
        }
        //Draw
        return 'D';
    }

    public static void printGrid(char arr[][]) {
        System.out.println("------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == 'A') {
                    System.out.print("  ");
                } else {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
        
    }
}