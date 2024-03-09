package todo.project;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

public class ProjectView {
	//**********************************************************************************************************
	//FRAME
	
		//ADD A FORMATED FRAME
			public static void addFrame(JFrame frame) {
				frame.setSize(500, 500);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE	);
				frame.setLayout(null);
				frame.setResizable(false);
				frame.setTitle("To-Do List");
				frame.setLocationRelativeTo(null);
				frame.getContentPane().setBackground(new Color(0xFBCEB1));
			}
			
		//SET FRAME VISBIBLITY
			public static void setFrameVisibilty(JFrame frame) {
				frame.setVisible(true);
			}
	
		//EMPTY FRAME
			public static void emptyFrame(JFrame frame) {
				frame.getContentPane().removeAll();
				frame.validate();
				frame.repaint();
			}
		
	//**********************************************************************************************************
	//LABEL
		//ADD A FORMATED LABEL
			public static void addLabel(JLabel label, JFrame frame, 
								int xAxis, int yAxis, int width, int hieght, 
								String text, String fontStyle, int fontSize, 
								String mode, String alingment) {
				
				label.setBounds(xAxis, yAxis, width, hieght);
				label.setText(text);
	
				//SET HORIZONTAL ALIGNMENT
					if(alingment.equals("CENTER")) {label.setHorizontalAlignment(JLabel.CENTER);}
					else if(alingment.equals("LEFT")) {label.setHorizontalAlignment(JLabel.LEFT);}
					else if(alingment.equals("RIGHT")) {label.setHorizontalAlignment(JLabel.RIGHT);}
				
				//SET TEXT MODE
					if(mode.equals("BOLD")) {label.setFont(new Font(fontStyle, Font.BOLD, fontSize));}
					else if(mode.equals("PLAIN")){label.setFont(new Font(fontStyle, Font.PLAIN, fontSize));}
				
				frame.add(label);
			}
			
			public static void setBGLabel(JLabel label, int colorF, int colorB, boolean opaque) {
				label.setOpaque(opaque);
				label.setBackground(new Color(colorB));
				label.setForeground(new Color(colorF));
			}
			
			public static void emptyLabelText(JLabel label, JPanel panel, int size) {
				if(size == 0) {
					label.setText("THERE'S CURRENTLY NO TASK ADDED");
					label.setBounds(0,  180,  470,  30);
					label.setHorizontalAlignment(JLabel.CENTER);
					label.setFont(new Font("MV Boli", Font.BOLD, 20));
					label.setForeground(Color.red);
					
					panel.add(label);
				}
			}
			
	//**********************************************************************************************************
	//TEXTFIELD
		//ADD A FORMATED TEXTFIELD
			public static void addTextField(JTextField textField, JFrame frame, String text, 
									int xAxis, int yAxis, int width, int hieght, boolean noBackground,
									String fontStyle, int fontSize, String mode) {
				
				textField.setBounds(xAxis, yAxis, width, hieght);
				textField.setText(text);
				
				if(mode.equals("BOLD")) {textField.setFont(new Font(fontStyle, Font.BOLD, fontSize));}
				else if(mode.equals("PLAIN")) {textField.setFont(new Font(fontStyle, Font.PLAIN, fontSize));}
				
				
				if(noBackground) {textField.setBackground(null);}
			
				frame.add(textField);
			}
			
			public static void setBackgroundOpaque(JTextField textfield, int color, boolean opaque) {
				if(!opaque) {textfield.setBackground(null);}
				else {textfield.setBackground(new Color(color));}
				
			}
			
		//ENABLE TEXTFIELD
			public static void enableTextField(JTextField textField) {
				textField.setText(" ");
				textField.setEditable(true);
			}
			
		//DISABLE TEXTFIELD
			public static void disableTextField(JTextField textField) {
				textField.setText("  Add Items....");
				textField.setEditable(false);
			}
	
	//**********************************************************************************************************
		//PASSWORDFIELD
			//ADD A FORMATED PASSWORDFIELD
				public static void addPasswordField(JPasswordField passField, JFrame frame,
										int xAxis, int yAxis, int width, int hieght) {
					passField.setBackground(null);
					passField.setBounds(xAxis, yAxis, width, hieght);
					frame.add(passField);
				}
				
				public static void setBackgroundOpaque(JPasswordField passfield, int color, boolean opaque) {
					if(!opaque) {passfield.setBackground(null);}
					else {passfield.setBackground(new Color(color));}
					
				}
	
	//**********************************************************************************************************
		//BUTTON
			//ADD A FORMATED BUTTON
			public static void addButton(JFrame frame, JButton button, String text, 
										int x, int y, int width, int hieght, int fontSize, 	
										String fontStyle, boolean noBorder, boolean noBackground,
										String mode) {
					
					button.setText(text);
					button.setBounds(x,  y, width, hieght);
					button.setFocusable(false);
					
					if(mode.equals("BOLD")) {button.setFont(new Font(fontStyle, Font.BOLD, fontSize));}
					else if(mode.equals("PLAIN")) {button.setFont(new Font(fontStyle, Font.PLAIN, fontSize));}
					
					if(noBorder) {button.setBorder(null);}
					if(noBackground) {button.setBackground(new Color(0xFBCEB1));}
					
					frame.add(button);
				}
			
			//FORMAT THE BUTTON WHEN CLICK
			public static void formatBtnClick(JButton btnAdd, JButton btnView, JButton btnAbout, 
											int addHieght, int viewHieght, int aboutHieght,
											int deductAdd, int deductView, int deductAbout,
											int fontSizeAdd, int fontSizeView, int fontSizeAbout) {
					
					btnAdd.setBounds(0, 175-deductAdd, 500, addHieght);
					btnView.setBounds(0, 255-deductView, 500, viewHieght);
					btnAbout.setBounds(0, 335-deductAbout, 500, aboutHieght);
					
					btnAdd.setFont(new Font("MV Boli", Font.PLAIN, fontSizeAdd));
					btnView.setFont(new Font("MV Boli", Font.PLAIN, fontSizeView));
					btnAbout.setFont(new Font("MV Boli", Font.PLAIN, fontSizeAbout));
				}
			 	
			//FORMAT COLOR OF THE BUTTON
			public static void setBackAndForegroundBtn(JButton button, int foreR, int foreG, int foreB,  int color) {
					button.setBackground(new Color(color));
					button.setForeground(new Color(foreR, foreG, foreB));
				}
		
			public static void setModeBtn(JButton button, String mode, int fontSize, String fontStyle) {
					if(mode.equals("BOLD")) {button.setFont(new Font(fontStyle, Font.BOLD, fontSize));}
					else if(mode.equals("PLAIN")) {button.setFont(new Font(fontStyle, Font.PLAIN, fontSize));}
				}
			
			public static void setBorder(JButton button, boolean isBorder) {
					Border border = BorderFactory.createLineBorder(Color.gray, 1);
					if(!isBorder) {button.setBorder(null);}
					else {button.setBorder(border);}
				}
			
			//DISABLE BUTTON
			public static void disableBtn(JButton button) {
				button.setEnabled(false);
			}
			
			public static void disableBtn(JButton button1, JButton button2) {
				button1.setEnabled(false);
				button2.setEnabled(false);
			}
			
			//ENABLE BUTTON
			public static void enableBtn(JButton button) {
				button.setEnabled(true);
			}
			
			public static void enableBtn(JButton button1, JButton button2) {
				button1.setEnabled(true);
				button2.setEnabled(true);
			}	

	//**********************************************************************************************************
		//TEXTAREA
			public static void addTextArea(JTextArea textArea, JFrame frame, int xAxix, int yAxis, int width, int hieght) {
				textArea.setBounds(xAxix, yAxis, width, hieght);
				textArea.setEditable(false);
				textArea.setOpaque(true);
				textArea.setBackground(new Color(0xFBBEB1));
				textArea.setText(" HELLO THERE!!!                          "
							   + "                                    "
							   + "I AM MARK ANTHONY VILLAHERMOSA "
							   + " AND THIS MY FINAL PROJECT IN JAVA   WITH ALL THE "
							   + "CONCEPTS OF \"OOP\" THAT IS DUE ON THIS DECEMBER 3, 2023. "
							   + "                                    "
							   + "       THIS IS A SIMPLE TO DO LIST "
							   + "     PROGRAM, THAT FOLLOW'S \"CRUD\"                  FEATURES.");
				textArea.setFont(new Font("DialogInput", Font.PLAIN, 22));
				textArea.setLineWrap(true);
				textArea.setWrapStyleWord(false);
				
				frame.add(textArea);
			}
			//ADD A FORMATED TEXTAREA
			public static void addTextArea(JFrame frame, JPanel panel, JTextArea textArea, int yAxis, String text) {
				textArea.setText("  " + text);
				textArea.setBounds(30, yAxis, 429, 20);
				textArea.setOpaque(true);
				
				panel.add(textArea);
				frame.add(panel);
			}
	
	//**********************************************************************************************************		
		//PANEL
				
			//ADD FORMATED PANEL
			public static void addPanel(JFrame frame, JPanel panel, int hieght, int yAxis) {
					panel.setBounds(10, yAxis, 465, hieght);
					panel.setBackground(new Color(0xFBBEB1));
					panel.setOpaque(true);
					panel.setLayout(null);
					
					frame.add(panel);
				}
		
			//EMPTY PANEL
			public static void emptyPanel(JPanel panel) {
					panel.removeAll();
				}



			//**********************************************************************************************************		
			//CHECKBOX
					
				//ADD A FORMATED CHECKBOX
					public static void addCheckBox(JFrame frame, JCheckBox checkBox, JPanel panel, int yAxis) {
						checkBox.setBounds(3, yAxis, 20, 20);
						checkBox.setBackground(null);
						
						panel.add(checkBox);
						frame.add(panel);
					}
			


















}
