public class Conway {
    private final int ALIVE = 1;
    private final int DEAD = 0;

    private final char ALIVE_CELL = 'X';
    private final char DEAD_CELL = '.';

    private final int row;
    private final int column;
    private int[][] grid;

    public Conway(int row_num, int column_num) {
        row = row_num;
        column = column_num;
        grid = new int[row][column];

        initGrid();
    }

    /**
     * Inits the grid to dead of alive cell based on random
     */
    private void initGrid() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (Math.random() < 0.2) {
                    grid[i][j] = ALIVE;
                } else {
                    grid[i][j] = DEAD;
                }
            }
        }
    }

    /**
     * Counts the alive neighbours of a given cell
     * @param cell_row row of the given cell
     * @param cell_col column of the given cell
     * @return the number of alive cell around a given cell
     */
    private int countCellNeighbours(int cell_row, int cell_col) {
        int count = 0;

        // check up
        if (cell_row != 0) {
            count = (grid[cell_row-1][cell_col] != DEAD) ? count+1 : count;
            // check upleft
            if (cell_col != 0) {
                count = (grid[cell_row-1][cell_col-1] != DEAD) ? count + 1 : count;
            }
            // check upright
            if (cell_col != column-1) {
                count = (grid[cell_row-1][cell_col+1] != DEAD) ? count + 1 : count;
            }
        }

        // check down
        if (cell_row != row-1) {
            count = (grid[cell_row+1][cell_col] != DEAD) ? count+1 : count;
            // check downleft
            if (cell_col != 0) {
                count = (grid[cell_row+1][cell_col-1] != DEAD) ? count + 1 : count;
            }
            // check downright
            if (cell_col != column-1) {
                count = (grid[cell_row+1][cell_col+1] != DEAD) ? count + 1 : count;
            }
        }

        // check left
        if (cell_col != 0) {
            count = (grid[cell_row][cell_col-1] != DEAD) ? count + 1 : count;
        }
        // check right
        if (cell_col != column-1) {
            count = (grid[cell_row][cell_col+1] != DEAD) ? count + 1 : count;
        }

        return count;
    }

    /**
     * Prints the grid in a human friendly way
     */
    public void printGrid() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] != DEAD) {
                    System.out.format("%3c", ALIVE_CELL);
                } else {
                    System.out.format("%3c", DEAD_CELL);
                }
            }
            System.out.println();
        }
    }
}
