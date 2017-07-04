import java.util.HashSet;

/**
 * Created by nkhatore on 6/24/17.
 */
public class Grid {

    public int[][] grid = new int[9][9];
    public int[] A = grid[0];
    public int[] B = grid[1];
    public int[] C = grid[2];
    public int[] D = grid[3];
    public int[] E = grid[4];
    public int[] F = grid[5];
    public int[] G = grid[6];
    public int[] H = grid[7];
    public int[] I = grid[8];
    public HashSet<Integer> AC13 = new HashSet<>();
    public HashSet<Integer> AC46 = new HashSet<>();
    public HashSet<Integer> AC79 = new HashSet<>();
    public HashSet<Integer> DF13 = new HashSet<>();
    public HashSet<Integer> DF46 = new HashSet<>();
    public HashSet<Integer> DF79 = new HashSet<>();
    public HashSet<Integer> GI13 = new HashSet<>();
    public HashSet<Integer> GI46 = new HashSet<>();
    public HashSet<Integer> GI79 = new HashSet<>();
    public static int x;
    public static int y;

    public Grid() {

    }

    public static void main(String[] args) {
        System.out.println("Let's solve a Sudoku puzzle. Please enter the numbers from left to right, top to bottom.");
        System.out.println("If a space is blank, denote it with a 0.");
        System.out.println("What is the first number (top left)?");
        while (y <= 9) {

        }
    }
}
