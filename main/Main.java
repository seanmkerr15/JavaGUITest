package main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

public class Main {
	private static int count = 0;
	public static void main(String[] args) {
		//Creating a container
		JFrame window = new JFrame("Counter"); //kinda creates a new object for JFrame ****
		window.setVisible(true);//Makes our window visible ***
		window.setSize(300, 300); //customizes our window size ****
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //When the x in the application is clicked it terminates the program
		
		//Components
		JButton button = new JButton("Click Me!"); //A button you can click on.
		JLabel label = new JLabel("Count: 0"); //Creates text that the window displays
		
		//can change size of your components (do not use unless have to)
		button.setPreferredSize(new Dimension(100,100));
		window.add(button); //adds component button
		
		/*
		 * passes the code that is executed through this class 
		 * that makes sure the code does something
		 */
		button.addActionListener(e -> {
			//code that is executed when button is pressed
			count++;
			label.setText("Count: " + count); //updates our label
		});
		
		//Need structure for our components
		//always uses Flow-Layout which arranges elements side-by-side
		JPanel panel = new JPanel(); //Container or box where you can put your components.
		panel.add(button);
		panel.add(label);
		
		/*
		panel.setLayout(new GridLayout(8,8));
		panel.add(button);
		panel.add(label);
		*/
		
		/*
		//Allows you to control where things are places as a X-Y layout
		//Can set where you want things here
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		//or here (I'm guessing)
		panel.add(button, BoxLayout.X_AXIS);
		panel.add(label);
		*/
		
		/*
		set Layout lets you change from Flow-Layout
		//Commented out to show the Box-layout
		panel.setLayout(new BorderLayout()); //Allows you to control where things are placed (N, W, S, E)
		panel.add(button, BorderLayout.SOUTH);
		panel.add(label, BorderLayout.NORTH);
		*/
		
		//panel.add(button); commented out to show BorderLayout 
		//panel.add(label); This was used for Flow-Layout
		panel.setBackground(Color.GRAY);
		//need to add the panel to the window
		window.add(panel);
		
		
		
	}

}
