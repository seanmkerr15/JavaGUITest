package actualmain;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;

public class actualMain {
	//beep beep
	//User interface should always run in a separate GUI thread
	//CHECK OUT PACKAGE MAIN AND MAIN CLASS TO LEARN ABOUT THESE PROGRAMS.

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new actualMain().createAndShowGUI());

	}
	
	//create our GUI properly
	private void createAndShowGUI() {
		JFrame frame = new JFrame("Whatever");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,500);
		//layout manager so the elements don't override each other.
		frame.setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		//allows user to enter their name
		JTextField name = new JTextField();
		panel.add(new JLabel("Name:"));
		panel.add(name);
		
		//Selection Menu
		//starting value, minimum value, maximum value, by how much does it go up each time.
		JSpinner age = new JSpinner(new SpinnerNumberModel(18, 0 ,120, 1));
		panel.add(age);
		
		//Pick Gender
		//must create one for each selection
		JRadioButton man = new JRadioButton("Man");
		JRadioButton woman = new JRadioButton("Woman");
		JRadioButton other = new JRadioButton("Other");
		//ButtonGroup forces only one selection
		ButtonGroup gender = new ButtonGroup();
		gender.add(man);
		gender.add(woman);
		gender.add(other);
		panel.add(man);
		panel.add(woman);
		panel.add(other);
		
		//Selection List
		//Have to specify as an array type the same as your generic(String in this case)
		String[] gamesList = {"Minecraft", "Clash of Clans", "Legend of Zelda"};
		JComboBox<String> game = new JComboBox<>(gamesList);
		panel.add(game);
		
		//Multiple Selections
		//have to create one for each
		JCheckBox hobby1 = new JCheckBox("Reading");
		JCheckBox hobby2 = new JCheckBox("Sports");
		JCheckBox hobby3 = new JCheckBox("Music");
		JCheckBox hobby4 = new JCheckBox("Gaming");
		panel.add(new JLabel("Hobbys: "));
		panel.add(hobby1);
		panel.add(hobby2);
		panel.add(hobby3);
		panel.add(hobby4);
		
		//Button to submit the form
		JButton submit = new JButton("Submit");
		
		//Text area where results are displayed
		JTextArea results = new JTextArea();
		//Preventing writing in result box
		results.setEditable(false);
		
		submit.addActionListener(e -> {
			results.setText("🥳🥳🥳Results: \n\n");
			//Show results for JTextField
			results.append("Name: " + name.getText() + "\n");
			//Show results for JSpinner
			results.append("Age: " + age.getValue() + "\n");
			//Shows results for JRadioButton
			String selection = man.isSelected() ? "Man" :
							   woman.isSelected() ? "Woman" :
							   other.isSelected() ? "Other" :
								   "Not Specified";
			results.append("Gender: " + selection + "\n");
			//shows results for Selection List
			results.append("Favorite Game: " + game.getSelectedItem() + "\n");
			//Shows results for JCheckBox
			StringBuilder hobbies = new StringBuilder();
			//adds ", " to allow multiple to get printed nicely
			if (hobby1.isSelected()) hobbies.append("Reading, ");
			if (hobby2.isSelected()) hobbies.append("Sports, ");	
			if (hobby3.isSelected()) hobbies.append("Music, ");
			if (hobby4.isSelected()) hobbies.append("Gaming, ");
			//if more than one hobby is picked then decrease length by two
			//removes ", " for last selection
			if(hobbies.length() > 0) {
			hobbies.setLength(hobbies.length() - 2);
			}
			//Continuation of adding results for JCheckBox
			results.append("Hobbies: " + hobbies + "\n");
		});
		
		frame.add(panel, BorderLayout.NORTH);
		frame.add(submit, BorderLayout.CENTER);
		frame.add(results, BorderLayout.SOUTH);
		
		frame.setVisible(true);
		
	}

}
