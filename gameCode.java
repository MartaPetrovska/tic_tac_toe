import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      boolean gameContinues = true;
      int grid_size = 3;
      int[][] grid = new int[grid_size][grid_size];
      int userSymbol = 1;
      int computerSymbol = 2;
        
      while (gameContinues) {
        userTurn(grid);
        printArray(grid, grid_size);
        if (checkLines(grid, userSymbol)) {
          System.out.println("User wins!");
          gameContinues = false;
          break;
        }

        computerTurn(grid);
        System.out.println("Oponents turn:");
        printArray(grid, grid_size);
        if (checkLines(grid, computerSymbol)) {
          System.out.println("Computer wins!");
          gameContinues = false;
          break;
        }
      }
    }

    public static void userTurn(int[][] grid) {
      
      Scanner scanner = new Scanner(System.in);
      boolean emptyField = true;
      
      while (emptyField) {
        System.out.println("Your turn. Write row number (0/1/2):");
        int row = scanner.nextInt();
        System.out.println("Write column number (0/1/2):");
        int column = scanner.nextInt();
          if (grid[row][column] == 0) {
            grid[row][column] = 1;
            emptyField = false;
          } else {
            System.out.println("Field is already taken. Please choose another one.");
          }
      }
    }

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

    public static void printArray(int[][] grid, int grid_size) {
      for (int i = 0; i < grid_size; i++) {
          for (int j = 0; j < grid_size; j++) {
            System.out.print(grid[i][j] + " ");
          }
        System.out.println();
      }
    }

    public static boolean checkLines(int[][] grid, int symbol) {
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
}
