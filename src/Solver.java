public class Solver {

    private Grid puzzle;
    private int[][] grid;

    Solver(Grid given) {
        this.puzzle = given;
        grid = given.grid;
        while (puzzle.curr.y < 9) {
            if (puzzle.curr.x == 9) {
                puzzle.curr.x = 0;
                puzzle.curr.y++;
            } else {
                if (grid[puzzle.curr.y][puzzle.curr.x] == 0) {
                    fillCell(1);
                }
                puzzle.curr.x++;
            }
        }
    }

    private void fillCell(int start) {
        for (int i = start; i <= 9; i++) {
            if (puzzle.checkBox(i) && puzzle.checkRow(i) && puzzle.checkCol(i)) {
                grid[puzzle.curr.y][puzzle.curr.x] = i;
                puzzle.addToBox(i);
                puzzle.filledIn.push(new Cell(puzzle.curr.x, puzzle.curr.y));
                return;
            }
        }
        puzzle.curr = puzzle.filledIn.pop();
        int newStart = grid[puzzle.curr.y][puzzle.curr.x];
        puzzle.removeFromBox(newStart);
        grid[puzzle.curr.y][puzzle.curr.x] = 0;
        fillCell(newStart + 1);
    }
}
