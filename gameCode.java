import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      int gridSize = 3;
      char[][] grid = new char[gridSize][gridSize];
      char userSymbol = 'X';
      char computerSymbol = 'O';
      boolean gameIsOn = true;
      Scanner scanner = new Scanner(System.in);

      // Initializing game. 
      System.out.println("Welcome to tic-tac-toe game!");
      System.out.println("When it is your turn write row and column coordinates to place your symbol.");
      System.out.println("This is games field.");
      initializeGrid(grid, gridSize);
      System.out.println();

      // Choosing which goes first (user or computer)
      int firstTurn = (int)(Math.random() * 2);
      if (firstTurn == 0) {
        System.out.println("You start the game. Your symbol is X.");
        System.out.println();
      }
      if (firstTurn == 1) {
        System.out.println("Computer starts the game.");
        System.out.println();
      }
      
      //Games main loop
      while (gameIsOn) {
        // If user goes first
        if (firstTurn == 0){
          // Users turn
          userTurn(grid, scanner, userSymbol);
          printGrid(grid, gridSize);
          System.out.println();
          if (checkWin(grid, gridSize)) {
            System.out.println("Congratulation! You won the game!");
            gameIsOn = false;
            break;
          } 

          // Computers turn
          computerTurn(grid, computerSymbol);
          System.out.println("Computers turn:");
          printGrid(grid, gridSize);
          System.out.println();
          if (checkWin(grid, gridSize)) {
            System.out.println("You lost the game!");
            gameIsOn = false;
            break;
          }

        } else { 
          // Computers turn
          computerTurn(grid, computerSymbol);
          System.out.println("Computers turn:");
          printGrid(grid, gridSize);
          System.out.println();
          if (checkWin(grid, gridSize)) {
            System.out.println("You lost the game!");
            gameIsOn = false;
            break;
          }

          // Users turn
          userTurn(grid, scanner, userSymbol);
          printGrid(grid, gridSize);
          System.out.println();
          if (checkWin(grid, gridSize)) {
            System.out.println("Congratulation! You won the game!");
            gameIsOn = false;
            break;
          } 
        }

        //Check for draw.
        if (checkDraw(grid, gridSize)) {
          System.out.println("It's a draw!");
          gameIsOn = false;
          break;
        }
      }
      scanner.close();
    }


  //Initialize grid. 
    public static void initializeGrid(char[][] grid, int gridSize) {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j] = '-';
              System.out.print(grid[i][j] + " ");
            }
          System.out.println();
        }
    }

  // Function that print out grid. 
  public static void printGrid(char[][] grid, int gridSize) {
    for (int i = 0; i < gridSize; i++) {
        for (int j = 0; j < gridSize; j++) {
          System.out.print(grid[i][j] + " ");
        }
      System.out.println();
    }
  }
  
    // Function to handle users turn.
    public static void userTurn(char[][] grid, Scanner scanner, char symbol) {
      boolean emptyField = true;
      while (emptyField) {
        System.out.println("Your turn. Write row number (1/2/3):");
        int row = scanner.nextInt() - 1;
        System.out.println("Write column number (1/2/3):");
        int column = scanner.nextInt() - 1;
        
        if (grid[row][column] == '-') {
          grid[row][column] = symbol;
          emptyField = false;
        } else {
          System.out.println("Field is already taken. Please choose another one.");
        }
      }
    }

  
    // Function to handle computers turn. 
    public static void computerTurn(char[][] grid, char symbol) {
      boolean emptyField = true;
      while (emptyField) {
        int row = (int)(Math.random() * 3);
        int column = (int)(Math.random() * 3);
        
        if (grid[row][column] == '-') {
          grid[row][column] = symbol;
          emptyField = false;
        } 
      }
    }

  
    // Function that checks each line if there is a win. 
    public static boolean checkWin(char[][] grid, int gridSize) {
      // Check rows
      for (int i = 0; i < gridSize; i++) {
        if (grid[i][0] != '-' && grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) {
          return true;
        }
      }
      // Check columns
      for (int i = 0; i < gridSize; i++) {
        if (grid[0][i] != '-' && grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i]) {
          return true;
        }
      }
      // Check diagonals
      if (grid[0][0] != '-' && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
        return true;
      };
      if (grid[0][2] != '-' && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) {
        return true;
      };

      return false;
    }

  
    // Function that checks if grid is full and there is a draw. 
    public static boolean checkDraw(char[][] grid, int gridSize) {
      for (int i = 0; i < gridSize; i++) {
          for (int j = 0; j < gridSize; j++) {
              if (grid[i][j] == '-') {
                  return false;
              }
          }
      }
      return true;
    }
  
}
