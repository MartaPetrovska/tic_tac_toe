import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      boolean gameContinues = true;
      int grid_size = 3;
        int[][] grid = new int[grid_size][grid_size];
        
      while (gameContinues) {
        addValue(grid);
        printArray(grid, grid_size);
      }
    }

    public static void addValue(int[][] grid) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your turn. Write row number (0/1/2):");
        int row = scanner.nextInt();
        System.out.println("Write column number (0/1/2):");
        int column = scanner.nextInt();
        grid[row][column] = 1;
    }

    public static void printArray(int[][] array, int grid_size) {
        for (int i = 0; i < grid_size; i++) {
            for (int j = 0; j < grid_size; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
