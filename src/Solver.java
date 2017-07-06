import java.util.Stack;

/**
 * Created by nkhatore on 7/3/17.
 */
public class Solver {

    private Grid grid;
    private Coord curr;
    private Stack<Coord> filledIn;

    private class Coord {
        public int x;
        public int y;
        private Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public Solver(Grid given) {
        grid = given;
        curr = new Coord(0,0);
        filledIn = new Stack<>();
        for (int[] arr : grid.grid) {
            fillRow(arr);
            curr.x = 0;
            curr.y++;
        }
    }

    private void fillRow(int[] row) {
        for (int cell : row) {
            if (cell == 0) {
                for (int i = 1; i <= 9; i++) {
                    if (!checkBox(i) || !checkRow(i) || !checkCol(i)) {
                        grid.grid[curr.y][curr.x] = i;
                        filledIn.push(new Coord(curr.x, curr.y));
                        break;
                    }
                }
            }
            curr.x++;
        }
    }

    private boolean checkBox(int num) {
        if (curr.x < 3 && curr.y < 3) {
            if (grid.AC13.contains(num)) {
                return false;
            }
        } else if (curr.x > 2 && curr.x < 6 && curr.y < 3) {
            if (grid.AC46.contains(num)) {
                return false;
            }
        } else if (curr.x > 5 && curr.x < 9 && curr.y < 3) {
            if (grid.AC79.contains(num)) {
                return false;
            }
        } else if (curr.x < 3 && curr.y > 2 && curr.y < 6) {
            if (grid.DF13.contains(num)) {
                return false;
            }
        } else if (curr.x > 2 && curr.x < 6 && curr.y > 2 && curr.y < 6) {
            if (grid.DF46.contains(num)) {
                return false;
            }
        } else if (curr.x > 5 && curr.x < 9 && curr.y > 2 && curr.y < 6) {
            if (grid.DF79.contains(num)) {
                return false;
            }
        } else if (curr.x < 3 && curr.y > 5 && curr.y < 9) {
            if (grid.GI13.contains(num)) {
                return false;
            }
        } else if (curr.x > 2 && curr.x < 6 && curr.y > 5 && curr.y < 9) {
            if (grid.GI46.contains(num)) {
                return false;
            }
        } else {
            if (grid.GI79.contains(num)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkRow(int num) {
        for (int cell : grid.grid[curr.y]) {
            if (cell == num) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCol(int num) {
        for (int i = 0; i < 9; i++) {
            if (grid.grid[i][curr.x] == num) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
