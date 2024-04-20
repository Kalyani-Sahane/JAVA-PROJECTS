package Calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class calc extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	double first_no ;
	double second_no;
	double result;
	String operation;
	String answer;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calc frame = new calc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public calc() {
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 321, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 45, 287, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnbackspace = new JButton("B");
		btnbackspace.setFont(new Font("Dialog", Font.BOLD, 20));
		btnbackspace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String backspace=null;
				if(textField.getText().length()>0) 
				{
					StringBuilder str=new StringBuilder(textField.getText());
				str.deleteCharAt(textField.getText().length()-1);
				backspace=str.toString();
				textField.setText(backspace);
				}
				
			}
		});
		btnbackspace.setBounds(10, 84, 72, 62);
		contentPane.add(btnbackspace);
		
		JButton btnC = new JButton("C");
		btnC.setFont(new Font("Dialog", Font.BOLD, 20));
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				
				
			}
		});
		btnC.setBounds(82, 84, 72, 62);
		contentPane.add(btnC);
		
		JButton btn0 = new JButton("0");
		btn0.setFont(new Font("Dialog", Font.BOLD, 20));
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=textField.getText()
		                +btn0.getText();
						textField.setText(number);
			}
		});
		btn0.setBounds(153, 84, 72, 62);
		contentPane.add(btn0);
		
		JButton BTNADD = new JButton("+");
		BTNADD.setFont(new Font("Dialog", Font.BOLD, 20));
		BTNADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first_no=Double.parseDouble(textField.getText());
				textField.setText("");
				operation="+";
			}
		});
		BTNADD.setBounds(225, 84, 72, 62);
		contentPane.add(BTNADD);
		
		JButton btn7 = new JButton("7");
		btn7.setFont(new Font("Dialog", Font.BOLD, 20));
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=textField.getText()
		                +btn7.getText();
						textField.setText(number);
			}
		});
		btn7.setBounds(10, 147, 72, 62);
		contentPane.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.setFont(new Font("Dialog", Font.BOLD, 20));
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=textField.getText()
		                +btn8.getText();
						textField.setText(number);
			}
		});
		btn8.setBounds(82, 147, 72, 62);
		contentPane.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.setFont(new Font("Dialog", Font.BOLD, 20));
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=textField.getText()
		                +btn9.getText();
						textField.setText(number);
			}
		});
		btn9.setBounds(153, 147, 72, 62);
		contentPane.add(btn9);
		
		JButton BTNSUB = new JButton("-");
		BTNSUB.setFont(new Font("Dialog", Font.BOLD, 20));
		BTNSUB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first_no=Double.parseDouble(textField.getText());
				textField.setText("");
				operation="-";
			}
		});
		BTNSUB.setBounds(225, 147, 72, 62);
		contentPane.add(BTNSUB);
		
		JButton btn4 = new JButton("4");
		btn4.setFont(new Font("Dialog", Font.BOLD, 20));
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=textField.getText()
		                +btn4.getText();
						textField.setText(number);
			}
		});
		btn4.setBounds(10, 210, 72, 62);
		contentPane.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.setFont(new Font("Dialog", Font.BOLD, 20));
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=textField.getText()
		                +btn5.getText();
						textField.setText(number);
			}
		});
		btn5.setBounds(82, 210, 72, 62);
		contentPane.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.setFont(new Font("Dialog", Font.BOLD, 20));
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=textField.getText()
		                +btn6.getText();
						textField.setText(number);
			}
		});
		btn6.setBounds(153, 210, 72, 62);
		contentPane.add(btn6);
		
		JButton BTNMUL = new JButton("*");
		BTNMUL.setFont(new Font("Dialog", Font.BOLD, 20));
		BTNMUL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first_no=Double.parseDouble(textField.getText());
				textField.setText("");
				operation="*";
			}
		});
		BTNMUL.setBounds(225, 210, 72, 62);
		contentPane.add(BTNMUL);
		
		JButton btn1 = new JButton("1");
		btn1.setFont(new Font("Dialog", Font.BOLD, 20));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=textField.getText()
                +btn1.getText();
				textField.setText(number);
				
				}
		});
		btn1.setBounds(10, 273, 72, 62);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.setFont(new Font("Dialog", Font.BOLD, 20));
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=textField.getText()
		                +btn2.getText();
						textField.setText(number);
			}
		});
		btn2.setBounds(82, 273, 72, 62);
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.setFont(new Font("Dialog", Font.BOLD, 20));
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=textField.getText()
		                +btn3.getText();
						textField.setText(number);
			}
		});
		btn3.setBounds(153, 273, 72, 62);
		contentPane.add(btn3);
		
		JButton BTNDIV = new JButton("/");
		BTNDIV.setFont(new Font("Dialog", Font.BOLD, 20));
		BTNDIV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first_no=Double.parseDouble(textField.getText());
				textField.setText("");
				operation="/";
			}
		});
		BTNDIV.setBounds(225, 273, 72, 62);
		contentPane.add(BTNDIV);
		
		JButton btn00 = new JButton("00");
		btn00.setFont(new Font("Dialog", Font.BOLD, 20));
		btn00.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=textField.getText()
		                +btn00.getText();
						textField.setText(number);
			}
		});
		btn00.setBounds(10, 334, 72, 62);
		contentPane.add(btn00);
		
		JButton btndecimal = new JButton(".");
		btndecimal.setFont(new Font("Dialog", Font.BOLD, 20));
		btndecimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=textField.getText()
		                +btndecimal.getText();
						textField.setText(number);
			}
		});
		btndecimal.setBounds(82, 334, 72, 62);
		contentPane.add(btndecimal);
		
		JButton btnequal = new JButton("=");
		btnequal.setFont(new Font("Dialog", Font.BOLD, 20));
		btnequal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String answer;
				second_no=Double.parseDouble(textField.getText());
				if(operation=="+")
				{
					result=first_no+second_no;
					answer=String.format("%.2f", result);
					textField.setText(answer);
					
				}
				else if(operation=="-")
				{
					result=first_no-second_no;
					answer=String.format("%.2f",result);
					textField.setText(answer);
					
				}
				else if(operation=="*")
				{
					result=first_no*second_no;
					answer=String.format("%.2f",result);
					textField.setText(answer);
				}
				else if(operation=="/")
				{
					result=first_no/second_no;
					answer=String.format("%.2f",result);
					textField.setText(answer);
				}
				else if(operation=="%")
				{
					result=first_no%second_no;
					answer=String.format("%.2f",result);
					textField.setText(answer);
				}
			}
				
		});
		btnequal.setBounds(153, 334, 72, 62);
		contentPane.add(btnequal);
		
		JButton BTNMOD = new JButton("%");
		BTNMOD.setFont(new Font("Dialog", Font.BOLD, 20));
		BTNMOD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first_no=Double.parseDouble(textField.getText());
				textField.setText("");
				operation="%";
			}
		});
		BTNMOD.setBounds(225, 334, 72, 62);
		contentPane.add(BTNMOD);
		JLabel lblNewLabel = new JLabel("CALCULATOR");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 287, 30);
		contentPane.add(lblNewLabel);
	}
}
