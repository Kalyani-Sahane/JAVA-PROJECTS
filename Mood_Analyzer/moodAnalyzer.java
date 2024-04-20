package Mood_Analyzer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class moodAnalyzer extends JFrame {

    private JTextField nameTextField;
    private JButton happyButton, sadButton, angryButton;
    private JLabel outputLabel;

    private String[] happyJokes = {
            "GO AND SUBSCRIBE CS CORNER.",
            "Why don't scientists trust atoms? Because they make up everything!",
            "What do you call a bear with no teeth? A gummy bear!"
    };

    private String[] sadQuotes = {
            "GO AND SUBSCRIBE CS CORNER.",
            "The only way to do great work is to love what you do.",
            "When one door closes, another opens."
    };

    private String[] angryQuotes = {
            "Why did the computer keep freezing? Because it left its Windows open!",
            "For every minute you are angry you lose sixty seconds of happiness.",
            "GO AND SUBSCRIBE CS CORNER."
    };

    public moodAnalyzer() {
        setTitle("Mood Analyzer App");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JLabel nameLabel = new JLabel("Enter your name: ");
        nameTextField = new JTextField(20);
        inputPanel.add(nameLabel);
        inputPanel.add(nameTextField);

        JPanel moodPanel = new JPanel();
        moodPanel.setLayout(new FlowLayout());

        happyButton = new JButton("Happy");
        sadButton = new JButton("Sad");
        angryButton = new JButton("Angry");

        moodPanel.add(happyButton);
        moodPanel.add(sadButton);
        moodPanel.add(angryButton);

        // Modify the font of the outputLabel
        outputLabel = new JLabel("HII HOW ARE YOU ?");
        outputLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Create a custom font
        Font customFont = new Font("Arial", Font.BOLD, 19); // Font name, style, and size

        // Set the custom font to the outputLabel
        outputLabel.setFont(customFont);
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(moodPanel, BorderLayout.CENTER);
        mainPanel.add(outputLabel, BorderLayout.SOUTH);

        add(mainPanel);

        happyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayMessage("Happy");
            }
        });

        sadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayMessage("Sad");
            }
        });

        angryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayMessage("Angry");
            }
        });
    }

    private void displayMessage(String mood) {
        String name = nameTextField.getText();
        String message;

        switch (mood) {
            case "Happy":
                message = name + ", THAT GREAT here is  a joke for you:\n" + getRandomJoke(happyJokes);
                break;
            case "Sad":
                message = name + ", DONT BE SAD ,here's a quote for you:\n" + getRandomQuote(sadQuotes);
                break;
            case "Angry":
                message = name + ", ANGER IS ENEMY ,here's a quote for you:\n" + getRandomQuote(angryQuotes);
                break;
            default:
                message = "Invalid mood selection.";
                break;
        }

        outputLabel.setText(message);
    }

    private String getRandomJoke(String[] jokes) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(jokes.length);
        return jokes[randomIndex];
    }

    private String getRandomQuote(String[] quotes) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(quotes.length);
        return quotes[randomIndex];
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new moodAnalyzer().setVisible(true);
            }
        });
    }
}