package todo.project.mainWindow;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import todo.project.Components;
import todo.project.ProjectView;
import todo.project.login.*;
import todo.project.aboutWindow.*;
import todo.project.viewWindow.*;
import todo.project.addWindow.*;


public class MainWindowController extends Components implements MouseListener{
	public void addMainFrame() {
		
		//LABEL	-> Add TODO and GREETINGS Label
			ProjectView.addLabel(todoLbl, window, 0, 0, 490, 100, "---TO*DO---", "Monospaced", 70, "BOLD", "CENTER");
			ProjectView.setBGLabel(todoLbl, 0x000000, 0xA9F36A, false);
			ProjectView.addLabel(greetings1Lbl, window, 0, 102, 490, 20, "   * Hello "+ LoginController.name + ",", "Monospaced", 17, "PLAIN", "LEFT");
			ProjectView.setBGLabel(greetings1Lbl, 0x000000, 0xA9F36A, false);
			ProjectView.addLabel(greetings2Lbl, window, 80, 122, 490, 20, "Let's Add some task.........:)", "Monospaced", 17, "PLAIN", "LEFT");
			ProjectView.setBGLabel(greetings2Lbl, 0x000000, 0xA9F36A, false);
			
		//BUTTON	-> Add ADD, VIEW, ABOUT, and LOGOUT button
			//ADD BUTTON
				addBtn = new JButton();
				ProjectView.addButton(window, addBtn, "ADD ITEM", 0, 175, 500, 60, 30, "MV Boli", true, true, "PLAIN");
				addBtn.addMouseListener(this);
				
			//VIEW BUTTON
				viewBtn = new JButton();
				ProjectView.addButton(window, viewBtn, "VIEW ITEM", 0, 255, 500, 60, 30, "MV Boli", true, true, "PLAIN");
				viewBtn.addMouseListener(this);
				
			//ABOUT ABOUT
				aboutBtn = new JButton();
				ProjectView.addButton(window, aboutBtn, "ABOUT", 0, 335, 500, 60, 30, "MV Boli", true, true, "PLAIN");
				aboutBtn.addMouseListener(this);
				
			//LOGOUT BUTTON
				logoutBtn = new JButton();
				ProjectView.addButton(window, logoutBtn, "LOGOUT", 10, 420, 120, 30, 20, "MV Boli", true, true, "PLAIN");
				logoutBtn.addMouseListener(this);
			
		//SET FRAME VISIBILITY	
			ProjectView.setFrameVisibilty(window);
			
		
	}
	
	@Override
	public void mouseClicked(MouseEvent event) {
		if(event.getSource() == logoutBtn) {
			ProjectView.emptyFrame(window);
			
			LoginController login = new LoginController();
			login.addLoginFrame();
		}
		if(event.getSource() == addBtn) {
			ProjectView.emptyFrame(window);
			AddWindowController add = new AddWindowController();
			add.addAddFrame();
			
		}
		if(event.getSource() == viewBtn) {
			ProjectView.emptyFrame(window);
			ViewWindowController view = new ViewWindowController();
			view.addViewFrame();
		}
		if(event.getSource() == aboutBtn) {
			ProjectView.emptyFrame(window);
			AboutWindowController about = new AboutWindowController();
			about.addAboutFrame();
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
		if(event.getSource() == addBtn) {
			ProjectView.formatBtnClick(addBtn, viewBtn, aboutBtn, 90, 60, 60, 10, 0, 0, 40, 30, 30);
			ProjectView.setBackAndForegroundBtn(addBtn, 50, 50, 150, 0xFBBEB5);
		}
		if(event.getSource() == viewBtn) {
			ProjectView.formatBtnClick(addBtn, viewBtn, aboutBtn, 60, 90, 60, 0, 20, 0, 30, 40, 30);
			ProjectView.setBackAndForegroundBtn(viewBtn, 50, 50, 150, 0xFBBEB5);
		}
		if(event.getSource() == aboutBtn) {
			ProjectView.formatBtnClick(addBtn, viewBtn, aboutBtn, 60, 60, 90, 0, 0, 20, 30, 30, 40);
			ProjectView.setBackAndForegroundBtn(aboutBtn, 50, 50, 150, 0xFBBEB5);
		}
		if(event.getSource() == logoutBtn) {
			ProjectView.setBackAndForegroundBtn(logoutBtn, 250, 0, 0, 0xFBBEB5);
			ProjectView.setModeBtn(logoutBtn, "BOLD", 23, "Monospaced");
		}
		
	}

	@Override
	public void mouseExited(MouseEvent event) {
		ProjectView.formatBtnClick(addBtn, viewBtn, aboutBtn, 60, 60, 60, 0, 0, 0, 30, 30, 30);
		ProjectView.setBackAndForegroundBtn(addBtn, 0, 0, 0, 0xFBCEB1);
		ProjectView.setBackAndForegroundBtn(viewBtn, 0, 0, 0, 0xFBCEB1);
		ProjectView.setBackAndForegroundBtn(aboutBtn, 0, 0, 0, 0xFBCEB1);
		ProjectView.setBackAndForegroundBtn(logoutBtn, 0, 0, 0, 0xFBCEB1);
		ProjectView.setModeBtn(logoutBtn, "PLAIN", 20, "MV Boli");

	}
}