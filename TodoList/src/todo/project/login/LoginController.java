package todo.project.login;

import todo.project.Components;
import todo.project.mainWindow.*;
import todo.project.register.*;
import todo.project.ProjectView;
import todo.project.user.UserController;
import javax.swing.*;
import java.awt.event.*;


public class LoginController extends Components implements MouseListener, KeyListener, ActionListener{
	public static String name;
	//Add a Login Window along with it's components
		/*Arguments for:
		 * 
		 *	addLabel -> (JLabel <Obj>, JFrame <Obj>, 
		 *				 xAxis <int>, yAxis <int>, width <int>, hieght <int>, 
		 *				 TEXT <String>, FontStyle <String>, FontSize <int>, 
		 *				 FontMode <String>, text alignment <String>)
		 *
		 *  setBGlabel -> 	(JLabel <Obj>, foreground color <int>, 
		 *  				 background color <int>, opaque <boolean>)
		 *  
		 *  addTextField/   -> (JTextField <Obj>, JFrame <obj>, TEXT <String>, 
		 *  addpasswordField   xAxis <int>, yAxis <int>, width <int>, hieght <int>, 
		 *  				   background <boolean>, FontStyle <String>, FontSize <int>,
		 *  				   FontMode <String>)
		 *  
		 *  addButton	-> (JFrame <obj>, JButton <obj>, TEXT <String>,
		 *  				xAxis <int>, yAxis <int>, width <int>, hieght <int>,  
		 *  				FonstStyle <String>, Border <boolean>, background <boolean>
		 *  				Font Mode <String>)
		 *  
		 *************************************************************************************/
	
			public void addLoginFrame() {
				//LABEL-TEXTFIELD -> Add LOGIN, USERNAME and  PASSWORD Label and text field
					//LOGIN lbl
						ProjectView.addLabel(loginLbl, window, 0, 0, 490, 100, "---LOGIN---", "Monospaced", 70, "BOLD", "CENTER");
						ProjectView.setBGLabel(loginLbl, 0x000000, 0x000000, false);
						
					//Username lbl
						ProjectView.addLabel(usernameLbl, window, 100, 110, 110, 30, "Username:", "Monospaced", 20, "BOLD", "LEFT");
						ProjectView.setBGLabel(usernameLbl, 0x000000, 0x000000, false);
						
					//usernane txtfield
						usernameTxt = new JTextField();
						ProjectView.addTextField(usernameTxt, window, "", 100, 150, 300, 40, true, "MV Boli", 15, "PLAIN");
						usernameTxt.addKeyListener(this);
						usernameTxt.addMouseListener(this);
						
					//password lbl
						ProjectView.addLabel(passLbl, window, 100, 200, 110, 30, "Password:", "Monospaced", 20, "BOLD", "LEFT");
						ProjectView.setBGLabel(passLbl, 0x000000, 0x000000, false);
						
					//password txtfield
						passTxt = new JPasswordField();
						ProjectView.addPasswordField(passTxt, window,100, 240, 300, 40);
						passTxt.addKeyListener(this);
						passTxt.addMouseListener(this);
				
				//BUTTON	-> Add LOGIN and REGISTER button
					//LOGIN BUTTON
						loginBtn = new JButton();
						ProjectView.addButton(window, loginBtn, "LOGIN", 160, 325, 180, 30, 20, "Monospaced", false, true, "BOLD");
						loginBtn.addMouseListener(this);
						loginBtn.addActionListener(this);
					
					//REGISTER BUTTON
						registerBtn = new JButton();
						ProjectView.addButton(window, registerBtn, "REGISTER", 160, 375, 180, 30, 20, "Monospaced", false, true, "BOLD");
						registerBtn.addMouseListener(this);
					
				//Set frame Visibility
					ProjectView.setFrameVisibilty(window);
			}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == loginBtn) {
			ProjectView.emptyFrame(window);
			
			//Check passTxt and usernameTxt if empty
			if(!(passTxt.getText().isEmpty() || usernameTxt.getText().isEmpty() )) {
				//check if the inputed data is recorded in the user file
				if(UserController.accountCheck( passTxt.getText() , usernameTxt.getText())) {
					MainWindowController mainWindow = new MainWindowController();
					name = UserController.getFullName(passTxt.getText(), usernameTxt.getText());
					mainWindow.addMainFrame();
				}else {
					ProjectView.addLabel(warnLbl, window, 0, 285, 500, 30, "Account Doesn't Exist", "Monospaced", 20, "BOLD", "CENTER");
					ProjectView.setBGLabel(warnLbl, 0xC44343, 0x000000, false);
					addLoginFrame();
				}
			}else {
				ProjectView.addLabel(warnLbl, window, 0, 285, 500, 30, "Please Input Data", "Monospaced", 20, "BOLD", "CENTER");
				ProjectView.setBGLabel(warnLbl, 0xC44343, 0x000000, false);
				addLoginFrame();
			}
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent event) {
		if(event.getSource() == registerBtn) {
			ProjectView.emptyFrame(window);
			RegisterController register = new RegisterController();
			register.addRegisterFrame();
		}
	}

	@Override
	public void mouseEntered(MouseEvent event) {
		if(event.getSource() == loginBtn) {
			ProjectView.setBackAndForegroundBtn(loginBtn, 0, 0, 0, 0xA9F36A);
			ProjectView.setModeBtn(loginBtn, "BOLD", 23, "Monospaced");
		}
		if(event.getSource() == registerBtn) {
			ProjectView.setBackAndForegroundBtn(registerBtn, 0, 0, 0, 0xA9F36A);
			ProjectView.setModeBtn(registerBtn, "BOLD", 23, "Monospaced");
		}
		if(event.getSource() == passTxt) {
			ProjectView.setBackgroundOpaque(passTxt, 0xFBBEB5, true);
		}
		if(event.getSource() == usernameTxt) {
			ProjectView.setBackgroundOpaque(usernameTxt, 0xFBBEB5, true);
		}
	}

	@Override
	public void mouseExited(MouseEvent event) {
		// TODO Auto-generated method stub
		if(frameMark == 0) {
			ProjectView.setBackAndForegroundBtn(loginBtn, 0, 0, 0, 0xFBCEB1);
			ProjectView.setBackAndForegroundBtn(registerBtn, 0, 0, 0, 0xFBCEB1);
			ProjectView.setModeBtn(registerBtn, "PLAIN", 20, "Monospaced");
			ProjectView.setModeBtn(loginBtn, "PLAIN", 20, "Monospaced");
		}
		if(event.getSource() == passTxt) {
			ProjectView.setBackgroundOpaque(passTxt, 0x9E813C, false);
		}
		if(event.getSource() == usernameTxt) {
			ProjectView.setBackgroundOpaque(usernameTxt, 0xFBBEB5, false);
		}
	}
	

	@Override
	public void keyPressed(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.VK_ENTER) {
			loginBtn.doClick();
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
	public void keyTyped(KeyEvent event) {
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
