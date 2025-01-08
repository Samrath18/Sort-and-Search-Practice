package sortAndSearch;

/*
 * Samrath Singh
 * ICS4UO-B
 * Sort and Search
 * 2023/04/17
 * This program utilizes sort and search methods to create a database and locate a specific piece of data in it.
 * The data is sorted and can be searched using the keyfield or any other fields.
 */

import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JComboBox;

public class SortSearch extends JFrame { //Start of class

	//Declare class variables
	private static JPanel contentPane, panel, panel1;
	private static JTextField menu, textField1, idField;
	private static JButton add, edit, delete, close, cancel, save, cont;
	private static JLabel enterID, enterName, selectStudent; 
	private static JRadioButton grd9, grd10, grd11, grd12;
	private static ButtonGroup grp;
	private static JComboBox comboBox;

	public String studentID, name, grade, data, userChoice;
	public int c1 = 0, b, funcCheck;
	public boolean unique = false;

	//Create array
	Student students [] = new Student[100];
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SortSearch frame = new SortSearch();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SortSearch() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBounds(0, 0, 92, 261);
		contentPane.add(panel);
		panel.setLayout(null);

		panel1 = new JPanel();
		panel1.setBounds(102, 11, 322, 57);
		contentPane.add(panel1);
		panel1.setLayout(null);

		add = new JButton("Add");
		add.setBounds(1, 56, 89, 23);
		contentPane.add(add);

		edit = new JButton("Edit");
		edit.setBounds(1, 93, 89, 23);
		contentPane.add(edit);

		delete = new JButton("Delete");
		delete.setBounds(1, 127, 89, 23);
		contentPane.add(delete);

		close = new JButton("Close");
		close.setBounds(1, 214, 89, 23);
		contentPane.add(close);

		cancel = new JButton("Cancel");
		cancel.setBounds(273, 227, 89, 23);
		contentPane.add(cancel);

		save = new JButton("Save");
		save.setBounds(124, 227, 89, 23);
		contentPane.add(save);

		menu = new JTextField();
		menu.setText("Menu");
		menu.setBounds(4, 28, 86, 20);
		contentPane.add(menu);
		menu.setColumns(10);

		textField1 = new JTextField();
		textField1.setBounds(263, 131, 86, 20);
		contentPane.add(textField1);
		textField1.setColumns(10);

		idField = new JTextField();
		idField.setColumns(10);
		idField.setBounds(263, 100, 86, 20);
		contentPane.add(idField);

		enterID = new JLabel("Enter Student ID");
		enterID.setBounds(163, 100, 92, 14);
		contentPane.add(enterID);

		enterName = new JLabel("Enter Name");
		enterName.setBounds(174, 134, 56, 14);
		contentPane.add(enterName);

		selectStudent = new JLabel("Seclect Student");
		selectStudent.setBounds(54, 6, 84, 14);
		contentPane.add(selectStudent);

		grd9 = new JRadioButton("Grade 9");
		grd9.setBounds(124, 171, 109, 23);
		contentPane.add(grd9);

		grd10 = new JRadioButton("Grade 10");
		grd10.setBounds(263, 171, 109, 23);
		contentPane.add(grd10);

		grd11 = new JRadioButton("Grade 11");
		grd11.setBounds(124, 197, 109, 23);
		contentPane.add(grd11);

		grd12 = new JRadioButton("Grade 12");
		grd12.setBounds(263, 197, 109, 23);
		contentPane.add(grd12);

		comboBox = new JComboBox();
		comboBox.setBounds(54, 31, 84, 15);
		contentPane.add(comboBox);

		cont = new JButton("Continue");
		cont.setBounds(191, 27, 89, 23);
		contentPane.add(cont);

		grp = new ButtonGroup();
		grp.add(grd9);
		grp.add(grd10);
		grp.add(grd11);
		grp.add(grd12);

		//Read 
		try { //Try statement
			BufferedReader input; //Object to connect to file
			input = new BufferedReader(new FileReader("data.txt")); //Instantiate BufferedReader
			data = input.readLine(); //Read line

			int cnt0 = 0;

			while(data != null) { //While data is not null
				cnt0++; //Update lines number
				if (cnt0 == 1) { // = 1
					name = data; //Save data to name
				}
				else if(cnt0 == 2) { // = 2
					grade = data; //Save data to grade 
				}
				else if(cnt0 == 3) { //== 3
					studentID = data; //Save data to studentID
					students[c1] = new Student(studentID, name, grade); //Create the object
					c1++; //Update number of lines
					cnt0 = 0; //Reset to zero
				}

				data = input.readLine(); //Read next line
			}
			input.close(); //Close reader
		}

		catch(Exception e) { //Catch statement
			System.out.println("Error"); //Print statement if error
		}
		
		add.addActionListener(new ActionListener() { //Action listener for add button
			public void actionPerformed(ActionEvent arg0) {
				//Set statuses
				save.setEnabled(true);
				save.setVisible(true);
				cancel.setEnabled(true);
				panel1.setVisible(true);
				selectStudent.setVisible(true);
				comboBox.setVisible(true);
				grd9.setEnabled(true);
				grd10.setEnabled(true);
				grd11.setEnabled(true);
				grd12.setEnabled(true);
				funcCheck = 1;
			}
		});
		edit.addActionListener(new ActionListener() { //Action listener for edit button
			public void actionPerformed(ActionEvent arg0) {
				funcCheck = 2; //Function check 2
				panel1.setVisible(true); //Set visible
				comboBox.removeAllItems(); //Clear box
				comboBox.addItem(""); //Add blank item

				for(int count = 0; count < c1; count++) { //For conditions
					studentID = students[count].getstudentID(); //Get studentID
					comboBox.addItem(studentID); //Add studentID to box
				}
			}
		});
		delete.addActionListener(new ActionListener() { //Action listener for delete button
			public void actionPerformed(ActionEvent arg0) {
				funcCheck = 3; //Function check 3
				comboBox.removeAllItems(); //Clear box
				comboBox.addItem(""); //Add blank item

				for(int count = 0; count < c1; count++) { //For conditions
					studentID = students[count].getstudentID(); //Get studentID
					comboBox.addItem(studentID); //Add studentID
				}
			}
		});
		comboBox.addActionListener(new ActionListener() { //Action listener for comboBox button
			public void actionPerformed(ActionEvent arg0) {
				if(funcCheck == 2 ) { //Function check  = 2
					cont.setText("Edit"); //Set text

				}
				else if(funcCheck == 3) { //Function check = 3
					cont.setText("Continue"); //Set text
				}
			}
		});
		cont.addActionListener(new ActionListener() { //Action listener for cont button
			public void actionPerformed(ActionEvent arg0) {

				b = search(c1, studentID, students); //Call search method

				textField1.setText(students[b].getName()); //Set text
				idField.setText(students[b].getstudentID()); //Set text

				if(students[b].getGrade().equalsIgnoreCase("Grade 9")) { //If condition
					grd9.setSelected(true); //Set the selected
				}
				else if(students[b].getGrade().equalsIgnoreCase("Grade 10")) { //If condition
					grd10.setSelected(true); //Set the selected
				}
				else if(students[b].getGrade().equalsIgnoreCase("Grade 11")) { //If condition
					grd11.setSelected(true); //Set the selected
				}
				else if(students[b].getGrade().equalsIgnoreCase("Grade 12")) { //If condition
					grd12.setSelected(true); //Set the selected
				}
				if(funcCheck == 2) { //If condition
					
					//Set statuses
					save.setEnabled(true);
					save.setVisible(true);
					save.setText("Save");
					cancel.setEnabled(true);
					cancel.setText("Cancel");
					textField1.setEnabled(true);
					idField.setEnabled(true);
					grd9.setEnabled(true);
					grd10.setEnabled(true);
					grd11.setEnabled(true);
					grd12.setEnabled(true);
				}
				else if(funcCheck == 3) { //If condition
					
					//Set statuses
					save.setEnabled(true);
					save.setVisible(true);
					save.setText("Delete");
					cancel.setText("Cancel");
					cancel.setEnabled(true);
					textField1.setEnabled(true);
					idField.setEnabled(true);
					grd9.setEnabled(false);
					grd10.setEnabled(false);
					grd11.setEnabled(false);
					grd12.setEnabled(false);
				}
			}
		});
		comboBox.addActionListener(new ActionListener() { //Action listener for comboBox
			public void actionPerformed(ActionEvent arg0) {
				name = textField1.getText(); //Get text
				studentID = idField.getText(); //Get studentID

				int cnt = 0; //Set counter
				while(unique = false && cnt < c1 && funcCheck == 1 ) { //Unique false and function check 1
					if(!studentID.equalsIgnoreCase(students[cnt].getstudentID())) { //Get studentID
						unique = false; //Set false
					}
					else { //Else
						unique = true; //Set true
					}
					cnt++; //Update
				}
				if (unique == false) { //Unique false

					if(funcCheck == 1) { //Function check = 1
						students[c1] = new Student(studentID, name, grade); //Create the object
						c1++; //Update
						sort(c1, students); //Sort
					}
					else if(funcCheck == 2) { //Function check = 2
						students[b].setName(name); //Set name
						students[b].setGrade(grade); //Set grade
					}
					else if(funcCheck == 3) { //Function check = 3
						for(int count = b+1; b++ < c1; count++) { //For condition
							students[count-1] = students[count]; //Minus object
						}
						c1--; //Update
					}
					//Set statuses
					save.setEnabled(false);
					save.setVisible(false);
					save.setText("Delete");
					grp.clearSelection();
					cancel.setText("Cancel");
					cancel.setEnabled(true);
					textField1.setEnabled(false);
					textField1.setText("");
					idField.setEnabled(false);
					idField.setText("");
					grd9.setEnabled(false);
					grd10.setEnabled(false);
					grd11.setEnabled(false);
					grd12.setEnabled(false);
				}
				else { //Else statement
					unique = false; //Set unique as false
				}
			}
		});
		cancel.addActionListener(new ActionListener() { //Action listener for cancel button
			public void actionPerformed(ActionEvent arg0) {
				//Set statuses
				save.setEnabled(false);
				save.setVisible(false);
				save.setText("Delete");
				grp.clearSelection();
				cancel.setText("Cancel");
				cancel.setEnabled(true);
				textField1.setEnabled(false);
				textField1.setText("");
				idField.setEnabled(false);
				idField.setText("");
				grd9.setEnabled(false);
				grd10.setEnabled(false);
				grd11.setEnabled(false);
				grd12.setEnabled(false);
			}
		});
		close.addActionListener(new ActionListener() { //Action listener for close button
			public void actionPerformed(ActionEvent arg0) {
				try { //Try statement
					PrintWriter output; //Object output
					output = new PrintWriter(new FileWriter("data.txt")); //Initialize writer

					for(int cnt=0; cnt<c1; cnt++) { //For condition
						
						//Get fields
						output.println(students[cnt].getName());
						output.println(students[cnt].getGrade());
						output.println(students[cnt].getstudentID());
					}
					output.close(); //Close writer
				}
				catch(Exception ee) { //Catch statement
					System.out.println("Error"); //Print if error
				}
				System.exit(0); //Exit program
			}
		});
		
		/**
		 * Sorting method
		 */
		public int sort (int c1, Student[] students) {
			int y, x;
			Student key;

			for(x=1; x<c1; x++) { //For condition
				key = students[x]; //Key equals students
				y = x-1; //Set y

				while(y >= 0 && Integer.valueOf(Student[y].getstudentID()) > Intger.valueOf(key.getstudentID())){ //While statement
					students[y+1] = students[y]; //Add student
					y--; //Update
				}
				students[y+1] = key; //Make equal to key
			}
		}

		/**
		 * Search method
		 */
		public int search (int c1, String studentID, student[] students) {
			
			//Declare variables
			int first, last, middle;
			int first = 1;
			int middle = 0;
			int last = c1;

			while(!students[middle].getstudentID().equalsIgnoreCase(studentID)) { //While statement
				middle = first + (last-first) / 2; //Find middle

				if(Integer.valueOf(students[middle].getstudentID() < Integer.valueOf(studentID))){ //If condition
					first = middle++; //Update
				}
				else if (Integer.valueOf(students[middle].getstudentID() <I nteger.valueOf(studentID))){ //Else if condition
					last = middle --; //Update
				}
				return middle; //Return middle
			}
		}
	}
}
