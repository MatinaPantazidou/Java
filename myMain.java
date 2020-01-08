/* Pantazidou Matina */
package testtest;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.mysql.jdbc.Statement;

public class myMain {

	private JFrame frame;
	private JLabel zero;
	private JLabel one;
	private JLabel two;
	private JLabel cal_label;
	private  JTextField textField;
	private  JTextField textField_1;
	
	

 	/**
 	 * Create the application.
 	 */
 	public myMain() {
		initialize();
 		clock();
 		
 	}
 
	
	
     	public void clock() {
     		Calendar cal=new GregorianCalendar();
     		int day=cal.get(Calendar.DAY_OF_MONTH);
     		int month=cal.get(Calendar.MONTH)+1;//January equals to 0 in output!
     		int year=cal.get(Calendar.YEAR);
     		cal_label.setText("Ημερομηνία: "+day+":"+month+":"+year);
     		
     		
     	}
     
     
     	/**
     	 * Initialize the contents of the frame.
     	 */
     	private void initialize() {
     		frame = new JFrame();
    		frame.setBounds(100, 100, 803, 400);
     		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     		frame.getContentPane().setLayout(null);
     		
     		JButton button = new JButton("ΥΠΟΒΟΛΗ");
     		button.setForeground(Color.BLUE);
     		
     		button.setBounds(300, 300, 180, 23);
     		frame.getContentPane().add(button);
     		
     		button.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent arg0) {	
    			
    				try{
    					Connection conne = null;
    					String str, strn;
    					Class.forName("com.mysql.jdbc.Driver");
    					conne = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "");
    					Statement st = (Statement) conne.createStatement();
    					str = textField.getText();
    					//System.out.println(str);	
    					strn = textField_1.getText();
    					//System.out.println("finally");
    					st.executeUpdate("Insert into email(name,email) values('"+str+"','"+strn+"')");
    					JOptionPane.showMessageDialog(null,"Data is successfully inserted into the database." );
    				
    					st.close();
    					conne.close();
    					}
    					catch(Exception e){
    					System.out.println(e);
    					}
    				System.exit(0);
     			}
     		});
     		
     		
     		JButton btnNewButton_1 = new JButton("\u0395\u039E\u039F\u0394\u039F\u03A3");
     		btnNewButton_1.addActionListener(new ActionListener() {
     			public void actionPerformed(ActionEvent e) {
     				System.exit(0);
     			}
     		});
     		btnNewButton_1.setBounds(688, 300, 89, 23);
     		frame.getContentPane().add(btnNewButton_1);
     		
     		zero = new JLabel("ΦΟΡΜΑ ΚΑΤΑΧΩΡΗΣΗΣ");
     		zero.setForeground(Color.GRAY);
     		zero.setFont(new Font("Tahoma", Font.BOLD, 20));
     		zero.setBounds(279, 10, 300, 40);
     		frame.getContentPane().add(zero);
     		
     		
     		one = new JLabel("Ονοματεπώνυμο:");
     		one.setBounds(21, 100, 176, 23);
     		frame.getContentPane().add(one);
     		
     		textField = new JTextField();
     		textField.setBounds(250, 100, 200, 23);
     		frame.getContentPane().add(textField);
     		textField.setColumns(10);
     		
     		two = new JLabel("Διεύθυνση ηλεκτρονικού ταχυδρομείου:");
     		two.setBounds(21, 150, 230, 50);
     		frame.getContentPane().add(two);
     		
     		textField_1 = new JTextField();
     		textField_1.setBounds(250, 165, 200, 23);
     		frame.getContentPane().add(textField_1);
     		textField_1.setColumns(10);
     		
     		cal_label = new JLabel("Date");
     		cal_label.setBounds(21, 250, 214, 14);
     		frame.getContentPane().add(cal_label);
     	}
     	
     		public static Connection getConnection() throws Exception{
     			try {
     				String driver = "com.mysql.jdbc.Driver";
     				String url = "jdbc:mysql://localhost:3306/mydatabase";
     				String username = "root";
     				String password = "";
     				Class.forName(driver);
     				Connection conne = DriverManager.getConnection(url, username, password);
     				System.out.println("Connection established");
     				return conne;
     				
     			}catch(Exception e) { System.out.println(e);}
     			
     			
     			return null;
     			
     			
     			}
     		
     		
     		/**
     		 * Launch the application.
     			 * @throws Exception 
     		 */
     		public static void main(String[] args) throws Exception {
     			getConnection();
     				EventQueue.invokeLater(new Runnable() {
     				public void run() {
     				 try {
     					myMain window = new myMain();
     					window.frame.setVisible(true);
     		     				
     		     					
     		     				} catch (Exception e) {
     		     					e.printStackTrace();
     		     				}
     		     			}
     		     		});
     		     	}
     		 
     			}
     			

     
     
