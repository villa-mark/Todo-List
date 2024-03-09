package todo.project.viewWindow;

import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JPanel;

import todo.project.*;
import todo.project.editWindow.*;
import todo.project.mainWindow.MainWindowController;

public class ViewWindowController extends Components implements ActionListener, MouseListener{
	public void addViewFrame() {
		frameMark = 4;
			
		//BUTTON -> Add BACK, EMPTYLIST and EDIT button
			//EMPTYLIST BUTTON
				emptyBtn = new JButton();
				ProjectView.addButton(window, emptyBtn, "Empty List", 220, 10, 150, 33, 15, "Monospaced", false, true, "BOLD");
				emptyBtn.addActionListener(this);
				
			//EDIT BUTTON
				editBtn = new JButton();
				ProjectView.addButton(window, editBtn, "Edit", 375, 10, 100, 33, 15, "Monospaced", false, true, "BOLD");
				editBtn.addActionListener(this);
				
			//BACK BUTTON
				backMainBtn = new JButton();
				ProjectView.addButton(window, backMainBtn, "<< BACK", 10, 10, 120, 30, 20, "MV Boli", true, true, "PLAIN");
				backMainBtn.addMouseListener(this);
				
			
		//PANEL -> Add VIEW PANEL
			viewItemPnl = new JPanel();
			ProjectView.addPanel(window, viewItemPnl, 400, 50);
			if(!ProjectModel.updatePanel(data, viewDataLbl, viewItemPnl, window, emptyLbl)) {
				editBtn.setEnabled(false);
				emptyBtn.setEnabled(false);
			}else {
				editBtn.setEnabled(true);
				emptyBtn.setEnabled(true);
			}
			
			
		//SET FRAME VISIBILITY
			ProjectView.setFrameVisibilty(window);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == editBtn) {
			ProjectView.emptyFrame(window);
			
			EditWindowController edit = new EditWindowController();
			edit.addEditFrame();
		}
		if(event.getSource() == emptyBtn) {
			ProjectView.emptyFrame(window);
			ProjectModel.deleteAllDataInFile();
			addViewFrame();
		}
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
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}