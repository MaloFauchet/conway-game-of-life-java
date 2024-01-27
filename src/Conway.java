public class Conway {
    private final int row;
    private final int column;
    private int[][] grid;

    public Conway(int row_num, int column_num) {
        row = row_num;
        column = column_num;
        grid = new int[row][column];

        initGrid();
    }

    private void initGrid() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (Math.random() < 0.2) {
                    grid[i][j] = 1;
                } else {
                    grid[i][j] = 0;
                }
            }
        }
    }

    public int countCellNeighbours(int cell_row, int cell_col) {
        int count = 0;

        // check up
        if (cell_row != 0) {
            count = (grid[cell_row-1][cell_col] != 0) ? count+1 : count;
            // check upleft
            if (cell_col != 0) {
                count = (grid[cell_row-1][cell_col-1] != 0) ? count + 1 : count;
            }
            // check upright
            if (cell_col != column-1) {
                count = (grid[cell_row-1][cell_col+1] != 0) ? count + 1 : count;
            }
        }

        // check down
        if (cell_row != row-1) {
            count = (grid[cell_row+1][cell_col] != 0) ? count+1 : count;
            // check downleft
            if (cell_col != 0) {
                count = (grid[cell_row+1][cell_col-1] != 0) ? count + 1 : count;
            }
            // check downright
            if (cell_col != column-1) {
                count = (grid[cell_row+1][cell_col+1] != 0) ? count + 1 : count;
            }
        }

        // check left
        if (cell_col != 0) {
            count = (grid[cell_row][cell_col-1] != 0) ? count + 1 : count;
        }
        // check right
        if (cell_col != column-1) {
            count = (grid[cell_row][cell_col+1] != 0) ? count + 1 : count;
        }

        return count;
    }

    public void printGrid() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] != 0) {
                    System.out.format("%3c", 'X');
                } else {
                    System.out.format("%3c", '.');
                }
            }
            System.out.println();
        }
    }
}
