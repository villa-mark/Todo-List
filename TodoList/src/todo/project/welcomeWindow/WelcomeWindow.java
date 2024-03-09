package todo.project.welcomeWindow;

import java.awt.event.*;
import todo.project.*;
import todo.project.login.*;
import javax.swing.JLabel;

public class WelcomeWindow extends Components implements MouseListener{
	JLabel welcomeLbl = new JLabel();
	JLabel clickLbl = new JLabel();
	JLabel designUpLbl = new JLabel();
	JLabel designDownLbl = new JLabel();
	
	//Constructor
		public WelcomeWindow() throws InterruptedException {
			//Add a foramted FRAME 
				ProjectView.addFrame(window);
				
			//Add Label with "WELCOME" text
				ProjectView.addLabel(welcomeLbl, window, 0, 160, 500, 120, "WELCOME", "Monospaced", 70, "BOLD", "CENTER");
			
			//Add Label with "click mew to start" text
				ProjectView.addLabel(clickLbl, window, 150, 250, 200, 20, "click me to start", "SansSerif", 15, "PLAIN", "CENTER");
			
			//Add Label design	
				ProjectView.addLabel(designUpLbl, window, 0, 0, 500, 80, "--------", "Monospaced", 100, "BOLD", "CENTER");
				ProjectView.addLabel(designDownLbl, window, 0, 370, 500, 80, "--------", "Monospaced", 100, "BOLD", "CENTER");
				
			//Add a mouse listener to the welcomeLbl
				welcomeLbl.addMouseListener(this);
				
			//Set Frame to be visible
				window.setVisible(true);
		}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == welcomeLbl) {
			ProjectView.emptyFrame(window);
			LoginController login = new LoginController();
			login.addLoginFrame();
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == welcomeLbl) {
			ProjectView.setBGLabel(welcomeLbl, 0x18125C, 0xFBBEB5, true);
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		ProjectView.setBGLabel(welcomeLbl, 0x000000, 0x0ff654, false);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
