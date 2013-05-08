package LogoGame;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;




public class LogoGame extends JFrame {

		String[] picArray = {"bat.jpg", "chrome.jpg", "Firefox.jpg", "Java.jpg", "Pringles.jpg", "superman.jpg", "Twitter.jpg", "Wika.jpg",
				"youtube.jpg", "rolling.jpg"};
		String[] ansArray = {"Batman", "Chrome", "Firefox", "Java", "Pringles", "Superman", "Twitter", "Wikipedia", "Youtube", "Rolling Stones"};
		
		JPanel main;
		ImageIcon Icon;
		JLabel Label;
		JTextField answer;
		JButton Check;
		
		int correctGuesses=0;
		int randomPick=0;
		
		public LogoGame(){
			this.setLayout(new BorderLayout());
			main= new JPanel();
			main.setLayout(new BorderLayout());
			
			
			Icon = new ImageIcon(picArray[randomPick]);
			Label= new JLabel(Icon);
			main.add(Label, BorderLayout.CENTER);
			
			Font myFont = new Font("Ariel", Font.BOLD, 14);
			
			answer=new JTextField();
			answer.setFont(myFont);
			answer.setHorizontalAlignment(JTextField.CENTER);
			
			ListenForKeys lForKeys = new ListenForKeys();
			answer.addKeyListener(lForKeys);
			
			main.add(answer, BorderLayout.SOUTH);
			
			ListenForButton  lForButton = new ListenForButton();
			
		
			
			Check = new JButton("Check Answer");
			Check.addActionListener(lForButton);
			add(Check, BorderLayout.SOUTH);
			
			add(main);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(400,400);
			this.setLocation(400,350);
			setVisible(true);
		}
		public static void main(String[] args){
			new LogoGame();
		}
		class SuperClass{
			void CheckAnswer(){
				if (answer.getText().equalsIgnoreCase(ansArray[randomPick])) {
					correctGuesses++;
					JOptionPane.showMessageDialog(null, "you guessed right\n"+correctGuesses, "correct guesses", correctGuesses);
					randomPick++;
					if (randomPick>=picArray.length) {
						randomPick=0;
						Icon=new ImageIcon(picArray[randomPick]);
						Label.setIcon(Icon);
						answer.setText("");
					}
				} else JOptionPane.showMessageDialog(null, "Incorrect guess");
				

				
			}

	}
		private class ListenForKeys extends SuperClass implements KeyListener{
			
		
			public void KeyTyped(KeyEvent Ke){}
			
			public void KeyPressed(KeyEvent Ke){
				if(Ke.getKeyCode()== KeyEvent.VK_ENTER)
					CheckAnswer();
			}
			public void keyReleased(KeyEvent ke){}

			
			}
		}


