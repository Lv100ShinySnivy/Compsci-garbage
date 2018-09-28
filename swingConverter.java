import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class swingConverter implements ActionListener{
	
	private JPanel inputPanel = initInputPanel();
	private JTextField inputText;
	private JTextArea resultArea;
	private JButton enterButton;
	
	public swingConverter() {
		javax.swing.JFrame aThing = new javax.swing.JFrame("Base Converter");
		aThing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		aThing.setResizable(false);
		aThing.setSize(600, 500);
		aThing.add(inputPanel);
		aThing.setVisible(true);
	}
	
	private JPanel initInputPanel() {
		JPanel panel1 = new JPanel();
		panel1.setPreferredSize(new java.awt.Dimension(600, 500));
		panel1.setLayout(null);
		
		JLabel label1 = new JLabel("Enter a base-10 number");
		label1.setBounds(50, 50, 220, 30);
		panel1.add(label1);
		
		JTextField text1;
		text1 = inputText = new JTextField();
		text1.setBounds(230, 50, 100, 30);
		panel1.add(text1);
		
		JButton button1 = new JButton("Enter");
		button1.setActionCommand("Enter");
		button1.setBounds(340, 50, 80, 30);
		button1.addActionListener(this);
		panel1.add(button1);
		enterButton = button1;
		
		JButton button2 = new JButton("Reset");
		button2.setActionCommand("Reset");
		button2.setBounds(430, 50, 80, 30);
		button2.addActionListener(this);
		panel1.add(button2);
		
		JTextArea textArea1;
		textArea1 = resultArea = new JTextArea();
		resultArea.setBounds(50, 180, 500, 200);
		resultArea.setEditable(false);
		resultArea.setBackground(java.awt.Color.GREEN);
		panel1.add(resultArea);
		
		
		
		JLabel label2 = new JLabel("Enter a radius");
		label2.setBounds(50, 50, 220, 30); //continue here
		panel1.add(label2);
		
		JTextField text2;
		text2 = inputText = new JTextField();
		text2.setBounds(230, 50, 100, 30);
		panel1.add(text2);
		
		JButton button3 = new JButton("Enter");
		button3.setActionCommand("Enter");
		button3.setBounds(340, 50, 80, 30);
		button3.addActionListener(this);
		panel1.add(button3);
		enterButton = button3;
		
		JButton button4 = new JButton("Reset");
		button4.setActionCommand("Reset");
		button4.setBounds(430, 50, 80, 30);
		button4.addActionListener(this);
		panel1.add(button4);
		
		JTextArea textArea2;
		textArea2 = resultArea = new JTextArea();
		resultArea.setBounds(50, 180, 500, 200);
		resultArea.setEditable(false);
		resultArea.setBackground(java.awt.Color.GREEN);
		panel1.add(resultArea);
		
		return panel1;
	}
	
	public static void main(String[] args) throws Exception {
		new swingConverter();
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		// TODO Auto-generated method stub
		String command = ev.getActionCommand();
		if (command.equals("Enter")) {
			showResult();
		} else if (command.equals("Reset")) {
			reset();
		}
	}
	private void showResult() {
		// TODO Auto-generated method stub
		String hexUpperCase;
		inputText.setEnabled(false);
		enterButton.setEnabled(false);
		
		Integer n = getInputNumber();
		if (n == null) {
			resultArea.append("Invald Number");
			return;
		}
		
		int baseTen = n.intValue();
		resultArea.append("Decimal = " + baseTen + "\n");
		resultArea.append("Bianary = " + Integer.toString(baseTen, 2) + "\n");
		resultArea.append("Octal = " + Integer.toString(baseTen, 8) + "\n");
		resultArea.append("Hexidecimal = " + Integer.toString(baseTen, 16) + "\n");
		
		hexUpperCase = Integer.toString(baseTen, 16).toUpperCase();
		resultArea.append("Hexadecimal = " + hexUpperCase);
	}

	private Integer getInputNumber() {
		// TODO Auto-generated method stub
		try {
			Integer n = Integer.parseInt(inputText.getText());
			return n;
		} catch (Exception e) {
			return null;
		}
	}

	private void reset() {
		inputText.setText("");
		resultArea.setText("");
		inputText.setEnabled(true);
		enterButton.setEnabled(true);
		inputText.requestFocus();
	}
}
