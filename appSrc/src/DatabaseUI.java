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
	
    public static void main(String args[]) throws ClassNotFoundException, SQLException
    {
        // Creating the Frame
        JFrame frame = new JFrame("Game Rental Database");
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
        JButton newButton = new JButton("New");
        newButton.setBounds(0,50,50,50);
        JButton delButton = new JButton("Delete");
        delButton.setBounds(0,50,100,50);
        JButton updateButton = new JButton("Update");
        updateButton.setBounds(0,50,100,50);
        JButton nextButton = new JButton("Next");
        nextButton.setBounds(0,50,100,50);
        JButton prevButton = new JButton("Previous");
        prevButton.setBounds(0,50,100,50);
        frame.add(newButton);
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
        
        //display table on gui
        gameTable.setBounds(0,40,300,300);
        JScrollPane sp = new JScrollPane(gameTable);
        frame.add(sp);

        frame.setVisible(true);

        // Button Listeners

        newButton.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e){}});
        
        rs.close();
        stmt.close();
        conn.close();
    }


    boolean generateRandom()
    {
        HashMap<Integer, String> dictionary = new HashMap<Integer, String>();

        try
        {
            File dict = new File("words_alpha.txt");
            Scanner readDict = new Scanner(dict);

            while(readDict.hasNextLine())
            {

            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found. Make sure file 'words-alpha.txt' is in src folder.");
        }
    }
    

}
