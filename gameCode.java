import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      int grid_size = 3;
      int[][] grid = new int[grid_size][grid_size];
      int userSymbol = 1;
      int computerSymbol = 2;
      boolean gameIsOn = true;
        
      //Games main loop
      while (gameIsOn) {

        //Code for users turn
        userTurn(grid);
        printGrid(grid, grid_size);
        if (checkWin(grid, userSymbol)) {
          System.out.println("User wins!");
          gameIsOn = false;
          break;
        } 

        //Code for computers turn
        computerTurn(grid);
        System.out.println("Oponents turn:");
        printGrid(grid, grid_size);
        if (checkWin(grid, computerSymbol)) {
          System.out.println("Computer wins!");
          gameIsOn = false;
          break;
        }

        //Code to check if grid is full and if there is a draw.
        if (checkDraw(grid, grid_size)) {
          System.out.println("It's a draw!");
          gameIsOn = false;
          break;
        }
      }
    }

    // Function to handle users turn.
    public static void userTurn(int[][] grid) {
      Scanner scanner = new Scanner(System.in);
      boolean emptyField = true;
      while (emptyField) {
        System.out.println("Your turn. Write row number (1/2/3):");
        int row = scanner.nextInt() - 1;
        System.out.println("Write column number (1/2/3):");
        int column = scanner.nextInt() - 1;
          if (grid[row][column] == 0) {
            grid[row][column] = 1;
            emptyField = false;
          } else {
            System.out.println("Field is already taken. Please choose another one.");
          }
      }
    }

    // Function to handle computers turn. 
    public static void computerTurn(int[][] grid) {
      boolean emptyField = true;
      while (emptyField) {
        int row = (int)(Math.random() * 3);
        int column = (int)(Math.random() * 3);
          if (grid[row][column] == 0) {
            grid[row][column] = 2;
            emptyField = false;
          } 
      }
    }

    // Function that print out grid. 
    public static void printGrid(int[][] grid, int grid_size) {
      for (int i = 0; i < grid_size; i++) {
          for (int j = 0; j < grid_size; j++) {
            System.out.print(grid[i][j] + " ");
          }
        System.out.println();
      }
    }

    // Function that checks each line if there is a win. 
    public static boolean checkWin(int[][] grid, int symbol) {
      // Check rows
      for (int i = 0; i < grid.length; i++) {
        if (grid[i][0] != 0 && grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) {
          return true;
        }
      }
      // Check columns
      for (int i = 0; i < grid.length; i++) {
        if (grid[0][i] != 0 && grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i]) {
          return true;
        }
      }
      // Check diagonals
      if (grid[0][0] == symbol && grid[1][1] == symbol && grid[2][2] == symbol) {
        return true;
      };
      if (grid[0][2] == symbol && grid[1][1] == symbol && grid[2][0] == symbol) {
        return true;
      };

      return false;
    }

    // Function that checks if grid is full and if there is a draw. 
    public static boolean checkDraw(int[][] grid, int grid_size) {
      int filledFields = 0;
      for (int i = 0; i < grid_size; i++) {
          for (int j = 0; j < grid_size; j++) {
            if (grid[i][j] != 0) {
              filledFields ++;
            }
          }
      }
      return filledFields == grid_size * grid_size;
    }
}
