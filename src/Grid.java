import java.util.HashSet;
import java.util.Stack;

public class Grid {

    int[][] grid;
    private HashSet<Integer> AC13 = new HashSet<>();
    private HashSet<Integer> AC46 = new HashSet<>();
    private HashSet<Integer> AC79 = new HashSet<>();
    private HashSet<Integer> DF13 = new HashSet<>();
    private HashSet<Integer> DF46 = new HashSet<>();
    private HashSet<Integer> DF79 = new HashSet<>();
    private HashSet<Integer> GI13 = new HashSet<>();
    private HashSet<Integer> GI46 = new HashSet<>();
    private HashSet<Integer> GI79 = new HashSet<>();
    Cell curr;
    Stack<Cell> filledIn;

    Grid(int[][] given) {
        if (given.length != 9 || given[0].length != 9) {
            throw new IllegalArgumentException("Incorrect dimensions.");
        }
        grid = given;
        curr = new Cell(0, 0);
        filledIn = new Stack<>();
        for (curr.y = 0; curr.y < 9; curr.y++) {
            for (curr.x = 0; curr.x < 9; curr.x++) {
                int num = grid[curr.y][curr.x];
                if (num != 0) {
                    if (!checkBox(num) || !checkRow(num) || !checkCol(num)) {
                        throw new IllegalArgumentException("Given puzzle is invalid.");
                    }
                    addToBox(num);
                }
            }
        }
        curr.x = 0;
        curr.y = 0;
    }

    boolean checkGrid() {
        return true;
    }

    boolean checkBox(int num) {
        if (curr.x < 3 && curr.y < 3) {
            if (AC13.contains(num)) {
                return false;
            }
        } else if (curr.x > 2 && curr.x < 6 && curr.y < 3) {
            if (AC46.contains(num)) {
                return false;
            }
        } else if (curr.x > 5 && curr.x < 9 && curr.y < 3) {
            if (AC79.contains(num)) {
                return false;
            }
        } else if (curr.x < 3 && curr.y > 2 && curr.y < 6) {
            if (DF13.contains(num)) {
                return false;
            }
        } else if (curr.x > 2 && curr.x < 6 && curr.y > 2 && curr.y < 6) {
            if (DF46.contains(num)) {
                return false;
            }
        } else if (curr.x > 5 && curr.x < 9 && curr.y > 2 && curr.y < 6) {
            if (DF79.contains(num)) {
                return false;
            }
        } else if (curr.x < 3 && curr.y > 5 && curr.y < 9) {
            if (GI13.contains(num)) {
                return false;
            }
        } else if (curr.x > 2 && curr.x < 6 && curr.y > 5 && curr.y < 9) {
            if (GI46.contains(num)) {
                return false;
            }
        } else {
            if (GI79.contains(num)) {
                return false;
            }
        }
        return true;
    }

    boolean checkRow(int num) {
        for (int x = 0; x < 9; x++) {
            if (grid[curr.y][x] == num && x != curr.x) {
                return false;
            }
        }
        return true;
    }

    boolean checkCol(int num) {
        for (int y = 0; y < 9; y++) {
            if (grid[y][curr.x] == num && y != curr.y) {
                return false;
            }
        }
        return true;
    }

    void addToBox(int num) {
        if (curr.x < 3 && curr.y < 3) {
            AC13.add(num);
        } else if (curr.x > 2 && curr.x < 6 && curr.y < 3) {
            AC46.add(num);
        } else if (curr.x > 5 && curr.x < 9 && curr.y < 3) {
            AC79.add(num);
        } else if (curr.x < 3 && curr.y > 2 && curr.y < 6) {
            DF13.add(num);
        } else if (curr.x > 2 && curr.x < 6 && curr.y > 2 && curr.y < 6) {
            DF46.add(num);
        } else if (curr.x > 5 && curr.x < 9 && curr.y > 2 && curr.y < 6) {
            DF79.add(num);
        } else if (curr.x < 3 && curr.y > 5 && curr.y < 9) {
            GI13.add(num);
        } else if (curr.x > 2 && curr.x < 6 && curr.y > 5 && curr.y < 9) {
            GI46.add(num);
        } else {
            GI79.add(num);
        }
    }

    void removeFromBox(int num) {
        if (curr.x < 3 && curr.y < 3) {
            AC13.remove(num);
        } else if (curr.x > 2 && curr.x < 6 && curr.y < 3) {
            AC46.remove(num);
        } else if (curr.x > 5 && curr.x < 9 && curr.y < 3) {
            AC79.remove(num);
        } else if (curr.x < 3 && curr.y > 2 && curr.y < 6) {
            DF13.remove(num);
        } else if (curr.x > 2 && curr.x < 6 && curr.y > 2 && curr.y < 6) {
            DF46.remove(num);
        } else if (curr.x > 5 && curr.x < 9 && curr.y > 2 && curr.y < 6) {
            DF79.remove(num);
        } else if (curr.x < 3 && curr.y > 5 && curr.y < 9) {
            GI13.remove(num);
        } else if (curr.x > 2 && curr.x < 6 && curr.y > 5 && curr.y < 9) {
            GI46.remove(num);
        } else {
            GI79.remove(num);
        }
    }

    void printGrid() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (j == 3 || j == 6) {
                    System.out.print("| ");
                }
                if (grid[i][j] == 0) {
                    System.out.print("- ");
                } else {
                    System.out.print(grid[i][j] + " ");
                }
                if (j == 8) {
                    System.out.println();
                }
            }
            if (i == 2 || i == 5) {
                System.out.println("---------------------");
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[9][9];
        for (int i = 0; i < 9; i++) {
            grid[i][i] = i + 1;
        }
        Grid g = new Grid(grid);
        g.printGrid();
        Solver sol = new Solver(g);
        System.out.println();
        g.printGrid();
    }
}
