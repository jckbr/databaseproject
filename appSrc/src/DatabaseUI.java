import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import java.util.HashMap;
import java.util.Scanner;
import java.util.*;
import java.lang.Object;


public class DatabaseUI
{
	public static Connection conn;
	public static Statement statement = null;
	public static Statement stmt = null;
	public static JFrame frame = new JFrame("Game Rental Database");
	
    public static void main(String args[]) throws ClassNotFoundException, SQLException
    {
        // Creating the Frame
    	//JFrame frame = new JFrame("Game Rental Database");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        //connect the database
        try
        {
    		Class.forName("org.sqlite.JDBC");
    		String url = "jdbc:sqlite:./appSrc/src/gameStoreData.db";

    		conn = DriverManager.getConnection(url);

    		System.out.println("Connection success");
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    		System.out.println("Connection failed");
    		System.exit(0);
    	} 
        Statement stmt = conn.createStatement();
        
        // Adding buttons
        JButton newTransButton = new JButton("New Transaction");
        newTransButton.setBounds(0,50,50,50);
        JButton delButton = new JButton("Delete");
        delButton.setBounds(0,50,100,50);
        JButton updateButton = new JButton("Update");
        updateButton.setBounds(0,50,100,50);
        JButton nextButton = new JButton("Next");
        nextButton.setBounds(0,50,100,50);
        JButton prevButton = new JButton("Previous");
        prevButton.setBounds(0,50,100,50);
        frame.add(newTransButton);
        frame.add(delButton);
        frame.add(updateButton);
        frame.add(nextButton);
        frame.add(prevButton);
        

        // Setting flow style
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));

        
        //Init Game Table
        String sql = "SELECT * FROM 'Games';";
        
        ResultSet rs = stmt.executeQuery(sql);
        
        int gColAm = rs.getMetaData().getColumnCount();
        
        String gameColumn [] = {"ID Number", "Name", "Genre", "Release Date", "Price", "Store ID"};
       
        DefaultTableModel gameTableModel = new DefaultTableModel(gameColumn, 0);
        
        JTable gameTable= new JTable(gameTableModel);
        
        while(rs.next()) {
        	Object[] gameRow = new Object[gColAm];
        	
        	gameRow[0] = rs.getInt("gID");
        	gameRow[1] = rs.getString("name");
        	gameRow[2] = rs.getString("genre");
        	gameRow[3] = rs.getDate("releaseDate");
        	gameRow[4] = rs.getDouble("price");
        	gameRow[5] = rs.getInt("sID");
        	
        	gameTableModel.addRow(gameRow);
        	
        }
        
        gameTable.setBounds(0,40,300,300);
        JScrollPane sp = new JScrollPane(gameTable);
        
        //Init Buyers Table
        sql = "SELECT * FROM 'Buyers'";
        
        rs = stmt.executeQuery(sql);
        
        int bColAm = rs.getMetaData().getColumnCount();
        
        String buyerColumn[] = {"ID Number", "Name", "Interest"};
        
        DefaultTableModel buyerTableModel = new DefaultTableModel(buyerColumn, 0);
        
        JTable buyerTable= new JTable(buyerTableModel);
        
        while(rs.next()) {
        	Object[] buyerRow = new Object[bColAm];
        	
        	buyerRow[0] = rs.getInt("bID");
        	buyerRow[1] = rs.getString("name");
        	buyerRow[2] = rs.getString("interest");
        	
        	buyerTableModel.addRow(buyerRow);
        	
        }
        
        buyerTable.setBounds(0,40,300,300);
        JScrollPane sp4 = new JScrollPane(buyerTable);
        
        //Init Employee Table
        sql = "SELECT * FROM 'Employee';";
        
        rs = stmt.executeQuery(sql);
        
        int eColAm = rs.getMetaData().getColumnCount();
        
        String employeeColumn [] = {"ID Number", "Name", "Pay Rate", "Hire Date"};
       
        DefaultTableModel employeeTableModel = new DefaultTableModel(employeeColumn, 0);
        
        JTable employeeTable= new JTable(employeeTableModel);
        
        while(rs.next()) {
        	Object[] employeeRow = new Object[eColAm];
        	
        	employeeRow[0] = rs.getInt("eID");
        	employeeRow[1] = rs.getString("name");
        	employeeRow[2] = rs.getInt("payRate");
        	employeeRow[3] = rs.getDate("hireDate");
        	
        	gameTableModel.addRow(employeeRow);
        	
        }
        
        employeeTable.setBounds(0,40,300,300);
        JScrollPane sp1 = new JScrollPane(employeeTable);
        
        //Init Manager Table
        sql = "SELECT * FROM 'Manager';";
        
        rs = stmt.executeQuery(sql);
        
        int mColAm = rs.getMetaData().getColumnCount();
        
        String managerColumn[] = {"Employee ID Number", "Store ID Number"};
        
        DefaultTableModel managerTableModel = new DefaultTableModel(managerColumn, 0);
        
        JTable managerTable = new JTable(managerTableModel);
        
        while(rs.next()) {
        	Object[] managerRow = new Object[mColAm];
        	
        	managerRow[0] = rs.getInt("eID");
        	managerRow[1] = rs.getInt("sID");
        	
        	managerTableModel.addRow(managerRow);
        }
        
        managerTable.setBounds(0,40,300,300);
        JScrollPane sp2 = new JScrollPane(managerTable);
        
        //Init Rent Table
        sql = "SELECT * FROM 'Rent';";
        
        rs = stmt.executeQuery(sql);
        
        int rColAm = rs.getMetaData().getColumnCount();
        
        String rentColumn[] = {"Employee ID Number", "Transaction Number", "Buyer ID Number", "Game ID Number"};
        
        DefaultTableModel rentTableModel = new DefaultTableModel(rentColumn, 0);
        
        JTable rentTable = new JTable(managerTableModel);
        
        while(rs.next()) {
        	Object[] rentRow = new Object[rColAm];
        	
        	rentRow[0] = rs.getInt("eID");
        	rentRow[1] = rs.getInt("transactionNum");
        	rentRow[2] = rs.getInt("bID");
        	rentRow[3] = rs.getInt("gID");
        	
        	rentTableModel.addRow(rentRow);
        }
        
        rentTable.setBounds(0,40,300,300);
        JScrollPane sp5 = new JScrollPane(rentTable);
        
        //Init Store Table
        sql = "SELECT * FROM 'Store';";
        
        rs = stmt.executeQuery(sql);
        
        int sColAm = rs.getMetaData().getColumnCount();
        
        String storeColumn[] = {"Store ID Number", "Region", "Employee Count", "Game Count"};
        
        DefaultTableModel storeTableModel = new DefaultTableModel(storeColumn, 0);
        
        JTable storeTable = new JTable(storeTableModel);
        
        while(rs.next()) {
        	Object[] storeRow = new Object[sColAm];
        	
        	storeRow[0] = rs.getInt("sID");
        	storeRow[1] = rs.getString("region");
        	storeRow[2] = rs.getInt("employeeCount");
        	storeRow[3] = rs.getInt("gameCount");
        	
        	storeTableModel.addRow(storeRow);
        }
        
        storeTable.setBounds(0,40,300,300);
        JScrollPane sp3 = new JScrollPane(storeTable);
        
      //adding a dropdown for the table menus
        String[] tableOptions = {"Games", "Employees", "Managers", "Stores", "Buyers", "Rents"};
        JComboBox tableChoice = new JComboBox(tableOptions);
        
        ActionListener cbAction = new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String choice = (String) tableChoice.getSelectedItem();
        		
        		frame.remove(sp);
        		frame.remove(sp1);
        		frame.remove(sp2);
        		frame.remove(sp3);
        		frame.remove(sp4);
        		frame.remove(sp5);
        		
        		switch(choice) {
        			case "Games":
        		        frame.add(sp);
        		        frame.validate();

        		        frame.setVisible(true);
        		        break;
        			case "Employees":
        		        frame.add(sp1);

        		        frame.setVisible(true);
        		        break;
        			case "Managers":
        		        frame.add(sp2);

        		        frame.setVisible(true);
        		        break;
        			case "Stores":
        		        frame.add(sp3);

        		        frame.setVisible(true);
        		        break;
        			case "Buyers":
        		        frame.add(sp4);

        		        frame.setVisible(true);
        		        break;
        			case "Rents":
        		        frame.add(sp5);

        		        frame.setVisible(true);
        		        break;
        		}
        	}
        };
        
        tableChoice.addActionListener(cbAction);
        frame.add(tableChoice);
        
        frame.setVisible(true);
        
        // Button Listeners

        //New Transaction Listener
        sql = "SELECT eID FROM 'Employee';";
        ResultSet Ers = stmt.executeQuery(sql);
        sql = "SELECT gID FROM 'Games';";
		ResultSet Grs = stmt.executeQuery(sql);
		sql = "SELECT bID FROM 'Buyers';";
		ResultSet Brs = stmt.executeQuery(sql);
		
        newTransButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e){
        		frame.remove(sp);
        		frame.remove(sp1);
        		frame.remove(sp2);
        		frame.remove(sp3);
        		frame.remove(sp4);
        		frame.remove(sp5);
        		updateTransaction(Ers, Grs, Brs);
        	}
        }
        );
        
        rs.close();
        stmt.close();
        conn.close();
    }
    
    public static void updateTransaction(ResultSet Ers, ResultSet Grs, ResultSet Brs) {
    	//adds to the transaction list and pushes the change to the database, then re-loads the table
    	ArrayList<Integer> emplID = new ArrayList<Integer>();
    	ArrayList<Integer> gamID = new ArrayList<Integer>();
    	ArrayList<Integer> buyID = new ArrayList<Integer>();
    	try {
			
			while(Ers.next()) {
				emplID.add(Ers.getInt("eID"));
			}
			
			while(Grs.next()) {
				gamID.add(Grs.getInt("gID"));
			}
			
			while(Brs.next()) {
				buyID.add(Brs.getInt("bID"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	Integer[] EidNums = emplID.toArray(new Integer[0]);
    	Integer[] gIdNums = gamID.toArray(new Integer[0]);
    	Integer[] bIdNums = buyID.toArray(new Integer[0]);
    	
    	JPanel panel1 = new JPanel(new FlowLayout());
    	JPanel p1 = new JPanel(new FlowLayout());
    	JPanel p2 = new JPanel(new FlowLayout());
    	JPanel p3 = new JPanel(new FlowLayout());
    	JComboBox em = new JComboBox(EidNums);
    	JLabel emLab = new JLabel("Select Employee ID");
    	JComboBox ga = new JComboBox(gIdNums);
    	JLabel gaLab = new JLabel("Select Game ID");
    	JComboBox bu = new JComboBox(bIdNums);
    	JLabel buLab = new JLabel("Select Buyer ID");
    	
    	JButton finishButton = new JButton("Save");
    	finishButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			//send update and remove the panel1 from frame. then return
    		}
    	});
    	
    	p1.add(emLab);
    	p1.add(em);
    	p2.add(gaLab);
    	p2.add(ga);
    	p3.add(buLab);
    	p3.add(bu);
    	
    	panel1.add(p1);
    	panel1.add(p2);
    	panel1.add(p3);
    	panel1.add(finishButton);
    	frame.add(panel1);
    	frame.setVisible(true);
    	
    	
    }

}
