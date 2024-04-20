
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TTT {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowMainMenu();
        });
    }

    private static void createAndShowMainMenu() {
        JFrame frame = new JFrame("Main Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 600);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JButton singlePlayerButton = new JButton("Single Player");
        JButton twoPlayerButton = new JButton("2 Player");
        JButton quitButton = new JButton("Quit Game");

        singlePlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add code here to start the single-player game
                new SinglePlayer();

                JOptionPane.showMessageDialog(frame, "Starting Single Player Game");
                
            }
        });

        twoPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                new TwoPlayer();
                // Add code here to start the two-player game
                JOptionPane.showMessageDialog(frame, "Starting 2 Player Game");
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Center-align buttons horizontally
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(singlePlayerButton, gbc);

        gbc.gridy = 1;
        panel.add(twoPlayerButton, gbc);

        gbc.gridy = 2;
        panel.add(quitButton, gbc);

        frame.add(panel);
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }
}


class TwoPlayer extends JFrame {
    private JButton[][] buttons;
    private JLabel statusLabel;
    private JButton resetButton;
    private boolean playerX;
    private boolean gameOver;

    public void CallMe(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TwoPlayer game = new TwoPlayer();
                game.setVisible(true);
            }
        });
    }

    public TwoPlayer() {
        setTitle("Tic Tac Toe (TwoPlayer)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 600);
        setLayout(new BorderLayout());

        JPanel gamePanel = new JPanel(new GridLayout(3, 3));
        buttons = new JButton[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
                buttons[i][j].addActionListener(new ButtonClickListener(i, j));
                buttons[i][j].setBackground(Color.cyan);
                gamePanel.add(buttons[i][j]);
            }
        }

        statusLabel = new JLabel("Player X's turn");
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);

        resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });

        add(gamePanel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.NORTH);
        add(resetButton, BorderLayout.SOUTH);

        playerX = true;
        gameOver = false;

        setVisible(true);
    }

    private void resetGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
                buttons[i][j].setBackground(Color.CYAN);
            }
        }
        statusLabel.setText("Player X's turn");
        playerX = true;
        gameOver = false;
    }

    private void checkWin() {
        String[][] board = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = buttons[i][j].getText();
            }
        }

        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2]) && !board[i][0].isEmpty()) {
                gameOver = true;
                buttons[i][0].setBackground(Color.GREEN);
                buttons[i][1].setBackground(Color.GREEN);
                buttons[i][2].setBackground(Color.GREEN);
                statusLabel.setText("Player " + board[i][0] + " wins!");
                disableButtons();
                return;
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j].equals(board[1][j]) && board[0][j].equals(board[2][j]) && !board[0][j].isEmpty()) {
                gameOver = true;
                buttons[0][j].setBackground(Color.GREEN);
                buttons[1][j].setBackground(Color.GREEN);
                buttons[2][j].setBackground(Color.GREEN);
                statusLabel.setText("Player " + board[0][j] + " wins!");
                disableButtons();
                return;
            }
        }

        // Check diagonals
        if (board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]) && !board[0][0].isEmpty()) {
            gameOver = true;
            buttons[0][0].setBackground(Color.GREEN);
            buttons[1][1].setBackground(Color.GREEN);
            buttons[2][2].setBackground(Color.GREEN);
            statusLabel.setText("Player " + board[0][0] + " wins!");
            disableButtons();
            return;
        }

        if (board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]) && !board[0][2].isEmpty()) {
            gameOver = true;
            buttons[0][2].setBackground(Color.GREEN);
            buttons[1][1].setBackground(Color.GREEN);
            buttons[2][0].setBackground(Color.GREEN);
            statusLabel.setText("Player " + board[0][2] + " wins!");
            disableButtons();
            return;
        }

        // Check for a draw
        boolean draw = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].isEmpty()) {
                    draw = false;
                    break;
                }
            }
        }
        if (draw) {
            gameOver = true;
            statusLabel.setText("It's a draw!");
            disableButtons();
        }
    }

    private void disableButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }

    private class ButtonClickListener implements ActionListener {
        private int row;
        private int col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!buttons[row][col].getText().isEmpty() || gameOver) {
                return;
            }

            if (playerX) {
                buttons[row][col].setText("X");
                statusLabel.setText("Player O's turn");
            } else {
                buttons[row][col].setText("O");
                statusLabel.setText("Player X's turn");
            }

            playerX = !playerX;
            buttons[row][col].setEnabled(false);
            checkWin();
        }
    }
}

class SinglePlayer extends JFrame {
    private JButton[][] buttons;
    private JLabel statusLabel;
    private boolean playerTurn;
    private boolean gameOver;

    public void CallMe(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SinglePlayer();
            }
        });
    }

    public SinglePlayer() {
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 600);
        setLayout(new GridLayout(4, 3));

        buttons = new JButton[3][3];
        playerTurn = true;
        gameOver = false;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
                buttons[i][j].addActionListener(new ButtonClickListener(i, j));
                add(buttons[i][j]);
            }
        }

        statusLabel = new JLabel("Player's Turn");
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(statusLabel);

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });
        add(resetButton);

        setVisible(true);
    }

    private void resetGame() {
        playerTurn = true;
        gameOver = false;
        statusLabel.setText("Player's Turn");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
            }
        }
    }

    private class ButtonClickListener implements ActionListener {
        private int row;
        private int col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (buttons[row][col].getText().isEmpty() && !gameOver) {
                if (playerTurn) {
                    buttons[row][col].setText("X");
                    statusLabel.setText("Computer's Turn");
                } else {
                    buttons[row][col].setText("O");
                    statusLabel.setText("Player's Turn");
                }

                buttons[row][col].setEnabled(false);
                playerTurn = !playerTurn;

                if (checkWin()) {
                    if (playerTurn) {
                        statusLabel.setText("Player Wins!");
                    } else {
                        statusLabel.setText("Computer Wins!");
                    }
                    gameOver = true;
                } else if (checkDraw()) {
                    statusLabel.setText("It's a Draw!");
                    gameOver = true;
                } else if (!playerTurn) {
                    makeComputerMove();
                }
            }
        }

        public boolean checkWin() {
            String symbol = playerTurn ? "X" : "O";

            // Check rows
            for (int i = 0; i < 3; i++) {
                if (buttons[i][0].getText().equals(symbol) &&
                        buttons[i][1].getText().equals(symbol) &&
                        buttons[i][2].getText().equals(symbol)) {
                    return true;
                }
            }

            // Check columns
            for (int i = 0; i < 3; i++) {
                if (buttons[0][i].getText().equals(symbol) &&
                        buttons[1][i].getText().equals(symbol) &&
                        buttons[2][i].getText().equals(symbol)) {
                    return true;
                }
            }

            // Check diagonals
            if (buttons[0][0].getText().equals(symbol) &&
                    buttons[1][1].getText().equals(symbol) &&
                    buttons[2][2].getText().equals(symbol)) {
                return true;
            }

            if (buttons[0][2].getText().equals(symbol) &&
                    buttons[1][1].getText().equals(symbol) &&
                    buttons[2][0].getText().equals(symbol)) {
                return true;
            }

            return false;
        }

        private boolean checkDraw() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (buttons[i][j].getText().isEmpty()) {
                        return false;
                    }
                }
            }
            return true;
        }

        private void makeComputerMove() {
            // Generate computer's move randomly
            int row, col;
            do {
                row = (int) (Math.random() * 3);
                col = (int) (Math.random() * 3);
            } while (!buttons[row][col].getText().isEmpty());

            buttons[row][col].setText("O");
            buttons[row][col].setEnabled(false);
            statusLabel.setText("Player's Turn");

            playerTurn = !playerTurn;

            if (checkWin()) {
                if (playerTurn) {
                    statusLabel.setText("Player Wins!");
                } else {
                    statusLabel.setText("Computer Wins!");
                }
                gameOver = true;
            } else if (checkDraw()) {
                statusLabel.setText("It's a Draw!");
                gameOver = true;
            }
        }
    }
}