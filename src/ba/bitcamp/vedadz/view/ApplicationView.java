package ba.bitcamp.vedadz.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ba.bitcamp.vedadz.controller.ApplicationController;
import ba.bitcamp.vedadz.model.Contact;

public class ApplicationView extends Main{
	
	
	
	public static void home(Contact c){
		JPanel panel = new JPanel();
		JLabel panelName = new JLabel("Phonebook");		
		JButton show = new JButton("Show contacts");
		JButton add = new JButton("Add contact");
		
		panelName.setPreferredSize(new Dimension(300, 100));
		panelName.setHorizontalAlignment(SwingConstants.CENTER);
		show.setPreferredSize(new Dimension(300,100));
		add.setPreferredSize(new Dimension(300,100));
		//Listeners for buttons
		show.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//ContactControler.list();
			
				
			}
		});
		
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// ContactController.newContact();
				ApplicationController.addContact();
			}
		});
		
		panel.add(panelName);
		panel.add(add);
		panel.add(show);
		//Treba brisati
		Main.replacePanel(panel);
	}
	
	/**
	 * View for adding contact.
	 */
	public static void add(){
		JPanel addPanel = new JPanel();
		JLabel name = new JLabel("Name");
		JLabel surname = new JLabel("Surname");
		JLabel number = new JLabel("Number");
		final JTextField nameTextField = new JTextField();
		final JTextField surnameTextField = new JTextField();
		final JTextField numberTextField = new JTextField();
		JButton addButton = new JButton("Add");
		JButton back = new JButton("Back");
		
		//Action listeners for buttons
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public  void actionPerformed(ActionEvent e) {
				/* get data from input
				 * and send it to create method
				 */
				String cName = nameTextField.getText();
				String cSurname = surnameTextField.getText();
				String cNumber = numberTextField.getText();
				ApplicationController.create(cName, cSurname, cNumber);
			}
		});
		
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ApplicationController.home();
				
			}
		});
		
		//Setting size and alignment of elements
		name.setPreferredSize(new Dimension(350,50));
		name.setHorizontalAlignment(SwingConstants.CENTER);
		nameTextField.setPreferredSize(new Dimension(350,50));
		surname.setPreferredSize(new Dimension(350,50));
		surname.setHorizontalAlignment(SwingConstants.CENTER);
		surnameTextField.setPreferredSize(new Dimension(350,50));
		number.setPreferredSize(new Dimension(350,50));
		number.setHorizontalAlignment(SwingConstants.CENTER);
		numberTextField.setPreferredSize(new Dimension(350,50));	
	
		//adding elements to panel.
		addPanel.add(name);
		addPanel.add(nameTextField);
		addPanel.add(surname);
		addPanel.add(surnameTextField);
		addPanel.add(number);
		addPanel.add(numberTextField);
		addPanel.add(addButton);
		addPanel.add(back);
		Main.replacePanel(addPanel);
		
	}
	
}
