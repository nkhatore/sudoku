import java.util.HashSet;

/**
 * Created by nkhatore on 7/3/17.
 */
public class Solver {

    private Grid grid;
    private int x;
    private int y;

    public Solver(Grid given) {
        grid = given;
        x = 0;
        y = 0;
        for (int[] arr : grid.grid) {
            fillRow(arr);
            y++;
        }
    }

    private void fillRow(int[] row) {
        for (int cell : row) {
            x++;
            if (cell == 0) {
                for (int i = 1; i <= 9; i++) {
                    checkBox(i);
                }
            }
        }
    }

    private boolean checkBox(int num) {
        if (x < 3 && y < 3) {
            if (grid.AC13.contains(num)) {
                return false;
            }
        } else if (x > 2 && x < 6 && y < 3) {
            if (grid.AC46.contains(num)) {
                return false;
            }
        } else if (x > 5 && x < 9 && y < 3) {
            if (grid.AC79.contains(num)) {
                return false;
            }
        } else if (x < 3 && y > 2 && y < 6) {
            if (grid.DF13.contains(num)) {
                return false;
            }
        } else if (x > 2 && x < 6 && y > 2 && y < 6) {
            if (grid.DF46.contains(num)) {
                return false;
            }
        } else if (x > 5 && x < 9 && y > 2 && y < 6) {
            if (grid.DF79.contains(num)) {
                return false;
            }
        } else if (x < 3 && y > 5 && y < 9) {
            if (grid.GI13.contains(num)) {
                return false;
            }
        } else if (x > 2 && x < 6 && y > 5 && y < 9) {
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

}
