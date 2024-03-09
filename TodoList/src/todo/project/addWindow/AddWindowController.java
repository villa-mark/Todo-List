package todo.project.addWindow;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;


import todo.project.*;
import todo.project.mainWindow.MainWindowController;

public class AddWindowController extends Components implements ActionListener, MouseListener, KeyListener{
	ArrayList<String> inputedData = new ArrayList<String>();
	public void addAddFrame() {
		//TEXTFIELD	-> Add ADD ITEM text field
			addItemTxt = new JTextField();
			ProjectView.addTextField(addItemTxt, window, defaultHolder, 30, 80, 300, 33, true, "Arial", 15, "PLAIN");
			addItemTxt.addMouseListener(this);
			addItemTxt.addKeyListener(this);
			
		//BUTTON	-> Add BACK, ADDITEM and CLEAR button
			//ADD ITEM BUTTON
				addItemBtn = new JButton();
				ProjectView.addButton(window, addItemBtn, "Add", 331, 80, 60, 33, 15, "Arial", false, false, "PLAIN");
				addItemBtn.addActionListener(this);
		
			//CLEAR ITEM BUTTON
				clearBtn = new JButton();
				ProjectView.addButton(window, clearBtn, "Clear", 392, 80, 70, 33, 15, "Arial", false, false, "PLAIN");
				clearBtn.addActionListener(this);
				
			//BACK BUTTON
				backMainBtn = new JButton();
				ProjectView.addButton(window, backMainBtn, "<< BACK", 10, 10, 120, 30, 20, "MV Boli", true, true, "PLAIN");
				backMainBtn.addMouseListener(this);
			
				
				ProjectView.disableBtn(addItemBtn, clearBtn);
			
		//PANEL	-> Add VIEWPANEL
			addItemPnl = new JPanel();
			ProjectView.addPanel(window, addItemPnl, 300, 130);
			ProjectModel.updatePanel(inputedData, displayDataLbl, addItemPnl, window);
			
		//SET FRAME VISIBILITY	
			ProjectView.setFrameVisibilty(window);
	
		
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		//WHEN CLEAR BUTTON IS CLICK
		if(event.getSource() == clearBtn) {
			if(!addItemTxt.getText().equals(defaultHolder)) {
				ProjectView.disableTextField(addItemTxt);
				ProjectView.disableBtn(addItemBtn, clearBtn);
			}
		}
	//WHEN ADD ITEM BUTTON IS CLICK
		if(event.getSource() == addItemBtn) {
			inputedData.add(addItemTxt.getText());
			ProjectModel.addDataInFile(addItemTxt.getText());
			ProjectView.disableTextField(addItemTxt);
			ProjectView.disableBtn(addItemBtn, clearBtn);
			ProjectView.emptyPanel(addItemPnl);
			ProjectView.emptyFrame(window);
			addAddFrame();
		}
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		if(event.getSource() == backMainBtn) {
			ProjectView.emptyFrame(window);
			inputedData.clear();
			MainWindowController main = new MainWindowController();
			main.addMainFrame();
		}
		
		//WHEN TEXT FIELD BUTTON IS CLICK	
		if(event.getSource() == addItemTxt) {
			ProjectView.enableTextField(addItemTxt);
			ProjectView.enableBtn(addItemBtn, clearBtn);
			
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.VK_ENTER) {
			addItemBtn.doClick();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}