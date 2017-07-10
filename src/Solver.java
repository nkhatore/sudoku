import java.util.HashSet;
import java.util.Stack;

public class Solver {

    private int[][] grid;
    private HashSet<Integer> AC13 = new HashSet<>();
    private HashSet<Integer> AC46 = new HashSet<>();
    private HashSet<Integer> AC79 = new HashSet<>();
    private HashSet<Integer> DF13 = new HashSet<>();
    private HashSet<Integer> DF46 = new HashSet<>();
    private HashSet<Integer> DF79 = new HashSet<>();
    private HashSet<Integer> GI13 = new HashSet<>();
    private HashSet<Integer> GI46 = new HashSet<>();
    private HashSet<Integer> GI79 = new HashSet<>();
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

    public Solver() {
        grid = new int[9][9];
        curr = new Coord(0,0);
        filledIn = new Stack<>();
        while (curr.y < 9) {
            if (curr.x == 9) {
                curr.x = 0;
                curr.y++;
            } else {
                if (grid[curr.y][curr.x] == 0) {
                    fillCell(1);
                }
                curr.x++;
            }
        }
    }

    private void fillCell(int start) {
        for (int i = start; i <= 9; i++) {
            if (checkBox(i) && checkRow(i) && checkCol(i)) {
                grid[curr.y][curr.x] = i;
                addToBox(i);
                filledIn.push(new Coord(curr.x, curr.y));
                return;
            }
        }
        curr = filledIn.pop();
        int newStart = grid[curr.y][curr.x];
        removeFromBox(newStart);
        grid[curr.y][curr.x] = 0;
        fillCell(newStart + 1);
    }

    private boolean checkBox(int num) {
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

    private boolean checkRow(int num) {
        for (int cell : grid[curr.y]) {
            if (cell == num) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCol(int num) {
        for (int i = 0; i < 9; i++) {
            if (grid[i][curr.x] == num) {
                return false;
            }
        }
        return true;
    }

    private void addToBox(int num) {
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

    private void removeFromBox(int num) {
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

    public static void main(String[] args) {
        Solver sol = new Solver();
        /*sol.grid[0][0] = 5;
        sol.grid[0][1] = 4;
        sol.grid[0][3] = 8;
        sol.grid[0][7] = 1;
        sol.grid[1][2] = 7;
        sol.grid[1][6] = 6;
        sol.grid[2][0] = 2;
        sol.grid[2][4] = 5;
        sol.grid[2][5] = 9;
        sol.grid[3][0] = 7;
        sol.grid[3][6] = 1;
        sol.grid[4][0] = 8;
        sol.grid[4][3] = 2;
        sol.grid[4][5] = 5;
        sol.grid[4][8] = 4;
        sol.grid[5][2] = 1;
        sol.grid[5][8] = 6;
        sol.grid[6][3] = 9;
        sol.grid[6][4] = 2;
        sol.grid[6][8] = 5;
        sol.grid[7][2] = 3;
        sol.grid[7][6] = 8;
        sol.grid[8][1] = 7;
        sol.grid[8][5] = 1;
        sol.grid[8][1] = 7;
        sol.grid[8][7] = 4;
        sol.grid[8][8] = 3;*/
    }
}
