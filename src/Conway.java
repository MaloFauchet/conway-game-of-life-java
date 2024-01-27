public class Conway {
    private int row;
    private int column;
    private int[][] grid;

    public Conway(int row_num, int column_num) {
        row = row_num;
        column = column_num;
        grid = new int[row][column];

        initGrid();
    }

    public void initGrid() {
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

    public void printGrid() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] != 0) {
                    System.out.print('X');
                } else {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }
}
