package ba.bitcamp.vedadz.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ApplicationView extends Main{
	
	public static void home(){
		JPanel panel = new JPanel();
		JLabel panelName = new JLabel("Phonebook");
		JButton show = new JButton("Show contacts");
		JButton add = new JButton("Add contact");
		
		panelName.setPreferredSize(new Dimension(300, 100));
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
				
			}
		});
		
		panel.add(panelName);
		panel.add(add);
		panel.add(show);
		Main.replacePanel(panel);
	}
}