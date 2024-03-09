package todo.project;

import javax.swing.*;
import java.util.ArrayList;

public abstract class Components {
	//FRAME
		public static JFrame window = new JFrame();
	//COMPONENTS
		//LOGIN WINDOW
			public JLabel loginLbl = new JLabel();
			public JLabel usernameLbl = new JLabel();
			public JLabel passLbl = new JLabel();
			public JLabel warnLbl = new JLabel();
			public JButton loginBtn;
			public JButton registerBtn;
			public JTextField usernameTxt;
			public JPasswordField passTxt;
		//REGISTER WINDOW
			public JLabel registerLbl = new JLabel();
			public JLabel firstNameLbl = new JLabel();
			public JLabel lastNameLbl = new JLabel();
			public JLabel usernameRegisterLbl = new JLabel();
			public JLabel passRegisterLbl = new JLabel();
			public JLabel successMessage = new JLabel();
			public JButton cancelBtn;
			public JButton submitBtn;
			public JButton loginRegisterBtn;
			public JTextField firstNameTxt;
			public JTextField lastNameTxt;
			public JTextField usernameRegisterTxt;
			public JTextField passRegisterTxt;
		//MAIN FRAME WINDOW
			public JLabel todoLbl = new JLabel();
			public JLabel greetings1Lbl = new JLabel();
			public JLabel greetings2Lbl = new JLabel();
			public JButton addBtn;
			public JButton viewBtn;
			public JButton aboutBtn;
			public JButton logoutBtn;
		//ADD FRAME WINDOW
			public JTextField addItemTxt;
			public JButton addItemBtn;
			public JButton clearBtn;
			public JPanel addItemPnl;
			public JLabel[] displayDataLbl;
		//VIEW FRAME WINDOW
			public JButton emptyBtn;
			public JButton editBtn;
			public JPanel viewItemPnl;
			public JLabel[] viewDataLbl;
		//EDIT FRAME WINDOW
			public JButton backViewBtn;
			public JButton saveBtn;
			public JButton deleteBtn;
			public static JCheckBox[] delCheckBox;
			public static JTextArea[] updateDataTxtArea;
			public JPanel editPnl;
			public JLabel emptyLbl = new JLabel();
		//ABOUT FRAME WINDOW 
			public JButton backMainBtn;
			public JLabel aboutLbl = new JLabel();
			public JLabel designLbl = new JLabel();
			public JTextArea aboutText;
			public JTextArea textArea = new JTextArea();
	
	//DATA
		public ArrayList<String> data = new ArrayList<String>();
		public int frameMark;
		public static int id = 0;
		public String defaultHolder = "   Add Items....";
		
}
