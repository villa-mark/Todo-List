package todo.project.register;

import java.awt.event.*;
import javax.swing.*;

import todo.project.*;
import todo.project.login.*;
import todo.project.user.UserController;

public class RegisterController extends Components implements MouseListener, ActionListener, KeyListener{
	static int mark = 0;
	static int id = 0;
	public void addRegisterFrame() {
		
		frameMark = 1;
		
		//LABEL-TEXTFIELD  -> Add REGISTER, FIRSTNAME, LASTNAME, USERNAME, and PASSWORD label and text field
			ProjectView.addLabel(registerLbl, window, 0, 0, 490, 100, "--REGISTER--", "Monospaced", 65, "BOLD", "CENTER");
			ProjectView.setBGLabel(registerLbl, 0x000000, 0x000000, false);
			
			ProjectView.addLabel(firstNameLbl, window, 20, 120, 140, 30, "First Name:", "Monospaced", 20, "BOLD", "LEFT");
			ProjectView.setBGLabel(firstNameLbl, 0x000000, 0x000000, false);
			
			firstNameTxt = new JTextField();
			ProjectView.addTextField(firstNameTxt, window, "", 160, 120, 300, 31, false, "MV Boli", 15, "PLAIN");
			firstNameTxt.addKeyListener(this);
		
			ProjectView.addLabel(lastNameLbl, window, 20, 170, 140, 30, "Last Name:", "Monospaced", 20, "BOLD", "LEFT");
			ProjectView.setBGLabel(lastNameLbl, 0x000000, 0x000000, false);
			
			lastNameTxt = new JTextField();
			ProjectView.addTextField(lastNameTxt, window, "", 160, 170, 300, 31, false, "MV Boli", 15, "PLAIN");
			lastNameTxt.addKeyListener(this);
			
			ProjectView.addLabel(usernameRegisterLbl, window, 20, 220, 140, 30, "Username:", "Monospaced", 20, "BOLD", "LEFT");
			ProjectView.setBGLabel(usernameRegisterLbl, 0x000000, 0x000000, false);
			
			usernameRegisterTxt = new JTextField();
			ProjectView.addTextField(usernameRegisterTxt, window, "", 160, 220, 300, 31, false, "MV Boli", 15, "PLAIN");
			usernameRegisterTxt.addKeyListener(this);
			
			ProjectView.addLabel(passRegisterLbl, window, 20, 270, 140, 30, "Password:", "Monospaced", 20, "BOLD", "LEFT");
			ProjectView.setBGLabel(passRegisterLbl, 0x000000, 0x000000, false);
			
			passRegisterTxt = new JTextField();
			ProjectView.addTextField(passRegisterTxt, window, "", 160, 270, 300, 31, false, "MV Boli", 15, "PLAIN");
			passRegisterTxt.addKeyListener(this);
			
		//BUTTON	-> Check condition:
						//TRUE	-> Add CANCEL and SUBMIT button
						//FALSE -> Add LOGIN button
			if(mark == 0) {
				//CANCEL BUTTON
					cancelBtn = new JButton();
					ProjectView.addButton(window, cancelBtn, "CANCEL", 130, 410, 150, 30, 20, "Monospaced", false, true, "BOLD");
					cancelBtn.addMouseListener(this);
				
				//SUBMIT BUTTON
					submitBtn = new JButton();
					ProjectView.addButton(window, submitBtn, "SUBMIT", 300, 410, 150, 30, 20, "Monospaced", false, true, "BOLD");
					submitBtn.addMouseListener(this);
					submitBtn.addActionListener(this);
			}else {
				frameMark = 7;
				//LOGIN BUTTON
					loginRegisterBtn = new JButton();
					ProjectView.addButton(window, loginRegisterBtn, "LOGIN", 300, 410, 150, 30, 20, "Monospaced", false, true, "BOLD");
					loginRegisterBtn.addMouseListener(this);
			}
			
		//SET FRAME VISIBILITY
			ProjectView.setFrameVisibilty(window);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == submitBtn) {
			ProjectView.emptyFrame(window);
			if(!(firstNameTxt.getText().isEmpty() || lastNameTxt.getText().isEmpty() || usernameRegisterTxt.getText().isEmpty() || passRegisterTxt.getText().isEmpty())) {
				if(UserController.accountCheck(passRegisterTxt.getText(), usernameRegisterTxt.getText())) {
					ProjectView.addLabel(successMessage, window, 0, 330, 500, 50, "Account Already Exist!", "MV Boli", 30, "BOLD", "CENTER");
					ProjectView.setBGLabel(successMessage, 0x000000, 0xE69393, true);
					mark = 0;
					addRegisterFrame();
				}else {
					UserController.addDataIntoFile(firstNameTxt.getText(), lastNameTxt.getText(), passRegisterTxt.getText(), usernameRegisterTxt.getText());
					ProjectView.addLabel(successMessage, window, 0, 330, 500, 50, "Registered Successfully!", "MV Boli", 30, "BOLD", "CENTER");
					ProjectView.setBGLabel(successMessage, 0x000000, 0xA9F36A, true);
					mark = 1;
					addRegisterFrame();
				}
			}else {
				ProjectView.addLabel(successMessage, window, 0, 330, 500, 50, "Please enter your information!", "MV Boli", 28, "BOLD", "CENTER");
				ProjectView.setBGLabel(successMessage, 0x000000, 0xE69393, true);
				mark = 0;
				addRegisterFrame();
			}
		}
		
	}
	
	@Override
	public void mouseClicked(MouseEvent event) {
		if(event.getSource() == cancelBtn) {
			ProjectView.emptyFrame(window);
			LoginController login = new LoginController();
			login.addLoginFrame();
		}
		if(event.getSource() == loginRegisterBtn) {
			ProjectView.emptyFrame(window);
			mark = 0;
			LoginController login = new LoginController();
			login.addLoginFrame();

		}
		
	}

	@Override
	public void mouseEntered(MouseEvent event) {
		if(event.getSource() == cancelBtn) {
			ProjectView.setBackAndForegroundBtn(cancelBtn, 250, 0, 0, 0xFBBEB5);
			ProjectView.setModeBtn(cancelBtn, "BOLD", 23, "Monospaced");
		}
		if(event.getSource() == submitBtn) {
			ProjectView.setBackAndForegroundBtn(submitBtn, 0, 0, 0, 0xA9F36A);
			ProjectView.setModeBtn(submitBtn, "BOLD", 23, "Monospaced");
		}
		if(event.getSource() == loginRegisterBtn) {
			ProjectView.setBackAndForegroundBtn(loginRegisterBtn, 0, 0, 0, 0xA9F36A);
			ProjectView.setModeBtn(loginRegisterBtn, "BOLD", 23, "Monospaced");
		}
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		if(frameMark == 1) {
			ProjectView.setBackAndForegroundBtn(cancelBtn, 0, 0, 0, 0xFBCEB1);
			ProjectView.setModeBtn(cancelBtn, "PLAIN", 20, "Monospaced");
			ProjectView.setBackAndForegroundBtn(submitBtn, 0, 0, 0, 0xFBCEB1);
			ProjectView.setModeBtn(submitBtn, "PLAIN", 20, "Monospaced");
		}
		if(frameMark == 7) {
			ProjectView.setBackAndForegroundBtn(loginRegisterBtn, 0, 0, 0, 0xFBCEB1);
			ProjectView.setModeBtn(loginRegisterBtn, "PLAIN", 20, "Monospaced");
		}
		
	}
	@Override
	public void keyPressed(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.VK_ENTER) {
			submitBtn.doClick();
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
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}