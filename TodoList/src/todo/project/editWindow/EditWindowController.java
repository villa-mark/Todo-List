package todo.project.editWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import todo.project.viewWindow.*;
import todo.project.*;

public class EditWindowController extends Components implements MouseListener, ActionListener{
	int count = 0;
	public void addEditFrame() {
		frameMark = 6;
			
		//BUTTON -> Add BACK, SAVE, and DELETE button
			//BACK BUTTON
				backViewBtn = new JButton();
				ProjectView.addButton(window, backViewBtn, "<< BACK", 10, 10, 120, 30, 20, "MV Boli", true, true, "PLAIN");
				backViewBtn.addMouseListener(this);
			
			//SAVE BUTTON
				saveBtn = new JButton();
				ProjectView.addButton(window, saveBtn, "SAVE", 120, 410, 100, 33, 15, "Arial", false, false, "PLAIN");
				saveBtn.setEnabled(false);
				
			//DELETE BUTTON
				deleteBtn = new JButton();
				ProjectView.addButton(window, deleteBtn, "DELETE", 250, 410, 100, 33, 15, "Arial", false, false, "PLAIN");
				deleteBtn.addActionListener(this);
				deleteBtn.setEnabled(false);
		
		//PANEL -> Add EDIT PANEL
			editPnl = new JPanel();
			ProjectView.addPanel(window, editPnl, 350, 50);
	
			//Update Panel's content corresponding to the data from the file
			updatePanel();
		//SET FRAME VISIBILITY
			ProjectView.setFrameVisibilty(window);
	}
	
	void updatePanel() {
		ProjectView.emptyPanel(editPnl);
		ProjectModel.convertDataFromFileToArrayList(data);
		if(!(data.size() == 0)) {
			int yAxis = 3;
			//Dynamic Components
				updateDataTxtArea = new JTextArea[data.size()];
				delCheckBox = new JCheckBox[data.size()];
				
			for(int indexNum = data.size()-1; indexNum>=0; indexNum--) {
				//CHECK BOX
					delCheckBox[indexNum] = new JCheckBox();
					ProjectView.addCheckBox(window, delCheckBox[indexNum], editPnl, yAxis);
					delCheckBox[indexNum].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent event) {
							int zeroCheck = 0;
							ProjectModel.convertDataFromFileToArrayList(data);
							for(int indexLoop = 0; indexLoop < data.size();indexLoop++) {
								if(delCheckBox[indexLoop].isSelected()) {
									deleteBtn.setEnabled(true);
									zeroCheck++;
								}
							}
							if(zeroCheck == 0) {deleteBtn.setEnabled(false);}
							ProjectModel.clearData(data);
						}
					});
				
				//TEXT AREA
					updateDataTxtArea[indexNum] = new JTextArea();
					ProjectView.addTextArea(window, editPnl, updateDataTxtArea[indexNum], yAxis, data.get(indexNum));
					updateDataTxtArea[indexNum].getDocument().addDocumentListener(new DocumentListener() {

						@Override
						public void insertUpdate(DocumentEvent e) {
							saveBtn.setEnabled(true);
							
						}

						@Override
						public void removeUpdate(DocumentEvent e) {
							saveBtn.setEnabled(true);
							
						}

						@Override
						public void changedUpdate(DocumentEvent e) {
							// TODO Auto-generated method stub
							
						}
						
					});
					
				yAxis += 23;
				count++;
			}
			saveBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					ProjectModel.deleteAllDataInFile();
					saveBtn.setEnabled(false);
					for(int i = 0; i<count; i++) {
						String data;
						int count = 0;
						for(int loop = 0; loop< updateDataTxtArea[i].getText().length(); loop++) {
							if(Character.isWhitespace(updateDataTxtArea[i].getText().charAt(loop))) {
								count++;
							}else {break;}
						}
						data = updateDataTxtArea[i].getText().substring(count);
						ProjectModel.addDataInFile(data);
					}
				}
			});
			ProjectModel.clearData(data);
		}else{ProjectView.emptyLabelText(emptyLbl, editPnl, data.size());}//Display A message saying "THERE'S CURRENTLY NO TASK ADDED"
	
	}
	public void actionPerformed(ActionEvent event) {
		//WHEN EDIT BUTTON IS CLICK		
		if(event.getSource() == deleteBtn) {
			ProjectModel.convertDataFromFileToArrayList(data);
			ProjectModel.deleteAllDataInFile();
			
			for(int indexBox = 0; indexBox < data.size(); indexBox++) {
				if(delCheckBox[indexBox].isSelected()) {
					continue;
				}else {
					ProjectModel.addDataInFile(data.get(indexBox));
				}
			}
			ProjectModel.clearData(data);
			ProjectView.emptyFrame(window);
			addEditFrame();
		}

	}

	@Override
	public void mouseClicked(MouseEvent event) {
		if(event.getSource() == backViewBtn) {
			ProjectView.emptyFrame(window);
			
			ViewWindowController view = new ViewWindowController();
			view.addViewFrame();
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
		if(event.getSource() == backViewBtn) {
			ProjectView.setBackAndForegroundBtn(backViewBtn, 100, 0, 0, 0xFBBEB5);
			ProjectView.setModeBtn(backViewBtn, "BOLD", 23, "MV Boli");
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		ProjectView.setBackAndForegroundBtn(backViewBtn, 0, 0, 0, 0xFBCEB1);
		ProjectView.setModeBtn(backViewBtn, "PLAIN", 20, "MV Boli");
	}
}