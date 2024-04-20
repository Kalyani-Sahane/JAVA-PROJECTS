import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class SudokuTable extends JFrame {
    public static boolean isSafe(int sudoku[][], int row, int col, int digit) {
        //column

        for(int i=0; i<=8; i++) {
            if(sudoku[i][col] == digit) {
                return false;
            }
        }

        //row
        for(int j=0; j<=8; j++) {
            if(sudoku[row][j] == digit) {
                return false;
            }
        }

        //grid
        int sr = (row/3) * 3;   //starting row
        int sc = (col/3) * 3;   //starting col
        //3x3 grid
        for(int i=sr; i<sr+3; i++) {
            for(int j=sc; j<sc+3; j++) {
                if(sudoku[i][j] == digit) {
                    return false;
                }
            }
        }
        
        return true;
    }

    public static boolean sudokuSolver(int sudoku[][], int row, int col) {
        //base case
        if(row == 9) {
            return true;
        }

        //recursion
        int nextRow = row, nextCol = col+1;
        if(col+1 == 9) {
            nextRow = row+1;
            nextCol = 0;
        }

        if(sudoku[row][col] != 0)  {
            return sudokuSolver(sudoku, nextRow, nextCol);
        }

        for(int digit=1; digit<=9; digit++) {
            if(isSafe(sudoku, row, col, digit))  {
                sudoku[row][col] = digit;
                if(sudokuSolver(sudoku, nextRow, nextCol))  {  //solution exists
                    return true;

                }

                sudoku[row][col] = 0;
            }
        }

        return false;
    }

    public void printSudoku(int sudoku[][]) {
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                System.out.print(sudoku[i][j]+ " ");
                sudokuCells[i][j].setText(""+sudoku[i][j]);
                
            }
            System.out.println();
        }
    }


    JTextField[][] sudokuCells;

    public SudokuTable() {
        int numRows = 9;
        int numCols = 9;

        // Create the 2D array
       int[][] sudoku = new int[numRows][numCols];

        setTitle("Sudoku Table");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        JPanel sudokuPanel = new JPanel(new GridLayout(9, 9));
        sudokuCells = new JTextField[9][9];
        
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                sudokuCells[row][col] = new JTextField(2);
                sudokuCells[row][col].setFont(new Font("Arial", Font.PLAIN, 20));
                sudokuCells[row][col].setHorizontalAlignment(JTextField.CENTER);
                sudokuPanel.add(sudokuCells[row][col]);
            }
        }

        JButton solveButton = new JButton("Solve");
        JButton resetButton = new JButton("Reset");
        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int row = 0; row < 9; row++) {
                    for (int col = 0; col < 9; col++) {
                        String text = sudokuCells[row][col].getText();
                        sudoku[row][col] = Integer.parseInt(text);
                    }
                }

                if(sudokuSolver(sudoku, 0, 0)) {
                    System.out.println("solution exists");
                    printSudoku(sudoku);
                } else {
                    System.out.println("solution does not exists");
                    }
                }

                // Add your Sudoku solving logic here
                // You can retrieve the values from sudokuCells and solve the Sudoku puzzle
                // Update the text fields with the solved values
            });

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for(int row=0; row<9; row++){
                    for(int col=0; col<9; col++){
                        sudokuCells[row][col].setText("");
                    }
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(solveButton);
        buttonPanel.add(resetButton);

        getContentPane().add(sudokuPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SudokuTable instance = new SudokuTable();

        instance.setVisible(true);
        Scanner sc = new Scanner(System.in);
        for(int row=0; row<9; row++){
            for(int col=0; col<9; col++){
                System.out.print("Enter the value for row " + (row + 1) + ", column " + (col + 1) + ": ");
                int num = sc.nextInt();
                String numText = Integer.toString(num);
                char numChar = numText.charAt(0);
                numText = "" + numChar;
                instance.sudokuCells[row][col].setText(numText);
                instance.revalidate();
                instance.repaint();
            }
        }

        sc.close();
    }
}