package todo.project.aboutWindow;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import todo.project.*;
import todo.project.Components;
import todo.project.mainWindow.*;

public class AboutWindowController extends Components implements MouseListener{
	
	public void addAboutFrame() {
		frameMark = 5;

		//LABEL	-> Add ABOUT and DESIGN label
			ProjectView.addLabel(aboutLbl, window, 0, 0, 490, 100, "---ABOUT---", "Monospaced", 50, "BOLD", "CENTER");
			ProjectView.addLabel(designLbl, window, 0, 370, 490, 100, "-----------", "Monospaced", 50, "BOLD", "CENTER");
		
		//TEXTAREA	-> Add about text area
			ProjectView.addTextArea(textArea, window, 10, 90, 470, 300);
		
		//BUTTON	-> Add BACK button
			//BACK BUTTON
			backMainBtn = new JButton();
			ProjectView.addButton(window, backMainBtn, "<< BACK", 10, 10, 120, 30, 20, "MV Boli", true, true, "PLAIN");
			backMainBtn.addMouseListener(this);
				
		//SET FRAME VISIBILITY
			ProjectView.setFrameVisibilty(window);
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		if(event.getSource() == backMainBtn) {
			ProjectView.emptyFrame(window);
			MainWindowController main = new MainWindowController();
			main.addMainFrame();
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent event) {
		if(event.getSource() == backMainBtn) {
			ProjectView.setBackAndForegroundBtn(backMainBtn, 100, 0, 0, 0xFBBEB5);
			ProjectView.setModeBtn(backMainBtn, "BOLD", 23, "MV Boli");
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		ProjectView.setBackAndForegroundBtn(backMainBtn, 0, 0, 0, 0xFBCEB1);
		ProjectView.setModeBtn(backMainBtn, "PLAIN", 20, "MV Boli");
	
	}
}