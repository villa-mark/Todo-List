package todo.project;

import java.io.*;
import java.util.*;

import javax.swing.*;

import todo.project.login.*;


public class ProjectModel{
	
	//ADD THE DATA IN THE FILE IN APPEND MODE
		public static void addDataInFile(String data) {
			File file = new File(LoginController.name + "Data.txt");
			try {
				file.createNewFile();
				try (FileWriter fileWrite = new FileWriter(file, true)) {
					fileWrite.write(data + "\n");
				}
			}catch(IOException e) {}
		}
	
	//DELETE ALL THE DATA IN THE FILE
		public static void deleteAllDataInFile() {
			File file = new File(LoginController.name + "Data.txt");
			try {
				file.createNewFile();
				try (FileWriter fileWrite = new FileWriter(file)) {
					fileWrite.write("");
				}
			}catch(IOException e) {}
		}
	
	/*CONVERT THE DATA FROM FILE INTO AN ARRAY OF DATA
		Return the size of the data*/
		public static int convertDataFromFileToArrayList(ArrayList<String> data) {
			File file = new File(LoginController.name + "Data.txt");
			try (Scanner scan = new Scanner(file)) {
				while(scan.hasNextLine()) {
					data.add(scan.nextLine());
				}
				return data.size();
			}catch(IOException e) {}
			return 0;
		}
	
	//CLEAR ALL DATA
		public static void clearData(ArrayList<String> data) {
			data.clear();
		}

		public static boolean updatePanel(ArrayList<String> data, JLabel[] displayDataLbl, JPanel panel, JFrame frame, JLabel label) {
			ProjectModel.convertDataFromFileToArrayList(data);
			panel.setLayout(null);
			if(!(data.size() == 0)) {
				int yAxis = 3;
				
				//Dynamic Component
					displayDataLbl = new JLabel[data.size()];
				
				for(int indexNum = data.size()-1; indexNum>=0; indexNum--) {
					displayDataLbl[indexNum] = new JLabel();
					displayDataLbl[indexNum].setBounds(0, yAxis, 200, 20);
					displayDataLbl[indexNum].setText("-> "+ data.get(indexNum));
					panel.add(displayDataLbl[indexNum]);
					yAxis += 23;
				}
				frame.add(panel);
				ProjectModel.clearData(data);
				return true;
			}ProjectView.emptyLabelText(label, panel, data.size());
			clearData(data);
			return false;
		}
		
		public static void updatePanel(ArrayList<String> data, JLabel[] displayDataLbl, JPanel panel, JFrame frame ) {
			if(!data.isEmpty()) {
				panel.setLayout(null);
				int yAxis = 3;
				
				//Dynamic Component
					displayDataLbl = new JLabel[data.size()];
				
				for(int indexNum = data.size()-1; indexNum>=0; indexNum--) {
					displayDataLbl[indexNum] = new JLabel();
					displayDataLbl[indexNum].setBounds(0, yAxis, 200, 20);
					displayDataLbl[indexNum].setText("-> "+ data.get(indexNum));
					panel.add(displayDataLbl[indexNum]);
					yAxis += 23;
				}
				frame.add(panel);
			}else return;
		
		}
		
}
	
