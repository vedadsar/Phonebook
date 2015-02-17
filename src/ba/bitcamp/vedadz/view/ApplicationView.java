package ba.bitcamp.vedadz.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream.GetField;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ba.bitcamp.vedadz.controller.ApplicationController;
import ba.bitcamp.vedadz.model.Contact;

/**
 * Class from view package.
 * Create all our GUIs. It extends our
 * Main class.
 * @author vedad
 *
 */
public class ApplicationView extends Main{	
	
	/**
	 * Method which creates home panel and
	 * puting it into main frame.
	 */
	public static void home(){
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
				ApplicationController.list();	
				
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
	/**
	 * Method which creates list view of all contacts.
	 * Has JScrollPane. Size of our panel is constantly increased
	 * depending on size of our phonebook because this way we
	 * can controll our jscrollpane.
	 * @param all
	 */
	public static void list(Contact[] all) {
		int buttonHeight = 50;
		JPanel content = new JPanel();
		content.setPreferredSize(new Dimension(ApplicationView.windowWidth-10, all.length *(buttonHeight +20)));
		JButton back = new JButton("back");		
		JButton add = new JButton("add");
		
		back.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				ApplicationController.home();				
			}
		});
		add.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				ApplicationController.addContact();
				
			}
		});
		content.add(add);
		content.add(back);
		
		if(all.length<1){
			JLabel message = new JLabel("You have no friends");
			content.add(message);
		}
		
		
		//TODO adding contact
		
		for(int i=0; i<all.length; i++) {
			JButton current = new JButton(all[i].getDisplayName());
			current.setName(""+all[i].getID());
			current.setPreferredSize(new Dimension(ApplicationView.windowWidth - 75,buttonHeight));
			current.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JButton clicked = (JButton)(e.getSource());
					int id = Integer.parseInt(clicked.getName());
					System.out.println("Korisnik: " +id);
					
				}
			});
			content.add(current);
			
		}
		JScrollPane sp = new JScrollPane(content);
		sp.setPreferredSize(new Dimension(ApplicationView.windowWidth-10, ApplicationView.windowHeight));
		sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		Main.replacePanel(sp);
	}
	
}
