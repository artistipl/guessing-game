package guessingGameUI;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {
	private JTextField txtGuess;
	private JLabel lblInfo;
	private JButton btnGuess;
	private int theNumber;
	private int counter = 0;
	private JButton btnPlayAgain;

	public void checkGuess() {
		String guessText = txtGuess.getText();
		String message;
		counter++;
		try {
			int guessInt = Integer.parseInt(guessText);
			if (guessInt > theNumber) {
				message = "Liczba " + guessInt + " jest wyższa od mojej.";
			} else if (guessInt < theNumber) {
				message = "Liczba " + guessInt + " jest niższa od mojej.";
			} else {
				message = "Brawo! " + guessInt + " to liczba, którą miałem na myśli! Wystarczyło Ci " + counter + " prób.";
				btnPlayAgain.setVisible(true);
				btnGuess.setEnabled(false);
			}
		} catch (NumberFormatException e) {
			message = "Wprowadż poprawną liczbę od 1 do 100!";
		}

		lblInfo.setText(message);
		txtGuess.requestFocus();
		txtGuess.selectAll();

	}

	public void newGame() {
		counter = 0;
		theNumber = (int) (Math.random() * 100 + 1);
		btnPlayAgain.setVisible(false);
		btnGuess.setEnabled(true);
	}

	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Zgadywanka");
		getContentPane().setLayout(null);

		JLabel lblTitle = new JLabel("Gra Zgadywanka");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTitle.setBounds(10, 19, 414, 29);
		getContentPane().add(lblTitle);

		JLabel lblInstruction = new JLabel("Zgadnij jaki numer między 1 a 100 mam na myśli:");
		lblInstruction.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstruction.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInstruction.setBounds(10, 67, 414, 29);
		getContentPane().add(lblInstruction);

		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		txtGuess.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtGuess.setBounds(171, 115, 93, 29);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);

		btnGuess = new JButton("Zgaduję!");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnGuess.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGuess.setBounds(146, 163, 143, 29);
		getContentPane().add(btnGuess);

		lblInfo = new JLabel("Wprowadz numer i kliknij przycisk Zgaduję!");
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setBounds(10, 211, 414, 29);
		getContentPane().add(lblInfo);
		
		btnPlayAgain = new JButton("Zagraj ponownie");
		btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblInfo.setText("Wprowadz numer i kliknij przycisk Zgaduję!");
				newGame();
			}
		});
		btnPlayAgain.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnPlayAgain.setBounds(146, 257, 143, 29);
		getContentPane().add(btnPlayAgain);
		btnPlayAgain.setVisible(false);
	}

	public static void main(String[] args) {
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450, 350));
		theGame.setVisible(true);

	}
}
