
package ba.bitcamp.vedadz.view;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JFrame;

public class Main {	
	
		private static JFrame window = null;
		protected final static int windowWidth = 400;
		protected final static int windowHeight = 500;
		
		public static  void init(){
			window = new JFrame("BitBook");
			window.setSize(windowWidth, windowHeight);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.setResizable(false);
			
		}
		
		protected static void setVisible(){
			window.validate();
			window.repaint();
			window.setVisible(true);
		}
		
		protected  static void replacePanel(Container panel){
			//TODO izbrisati stari panel ubaciti novi
			window.setContentPane(panel);
			setVisible();
			
		}
		
}
