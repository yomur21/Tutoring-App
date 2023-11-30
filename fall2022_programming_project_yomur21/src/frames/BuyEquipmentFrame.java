package frames;

import javax.swing.JFrame;

import student.Student;
import system.TutoringSystem;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import course.Equipment;
import exceptions.CannotBuyEquipmentException;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class BuyEquipmentFrame extends JFrame{

    private Student student;
    private TutoringSystem tsystem;
    
    public BuyEquipmentFrame(Student s, TutoringSystem ts) {
    	getContentPane().setBackground(new Color(128, 128, 255));
    	this.student=s;
    	this.tsystem=ts;
    	getContentPane().setLayout(null);
    	
    	JLabel lblNewLabel = new JLabel("Choose the piece of equipment you would like to buy.");
    	lblNewLabel.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
    	lblNewLabel.setBounds(48, 22, 356, 15);
    	getContentPane().add(lblNewLabel);
    	
    	/**
    	 * I used a JComboBox to make the student pick an equipment to buy.
    	 * The "ShowEquipment" method of the system returns an array of strings, which
    	 * the JComboBox constructor takes as an argument.
    	 */
    	JComboBox comboBox = new JComboBox(tsystem.ShowEquipment());
    	comboBox.setBounds(104, 62, 209, 21);
    	getContentPane().add(comboBox);
    	
    	JButton btnNewButton = new JButton("Buy");
    	btnNewButton.setBackground(new Color(251, 198, 249));
    	btnNewButton.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
    	btnNewButton.setBounds(166, 93, 85, 21);
    	getContentPane().add(btnNewButton);
    	/**
    	 * When the button is clicked, I got the selected item, turned it into a string
    	 * and since each item starts with the name of the equipment,
    	 * I obtained the equipment name from there. 
    	 * 
    	 * The method first tries to call the buyEquipment method, which might
    	 * throw a "CannotBuyEquipmentException" if the student's balance is not enough.
    	 * If an exception is caught, it displays the error message on a JOptionPane.
    	 * 
    	 * If there is no error, the equipment is successfully bought. 
    	 */
    	btnNewButton.addActionListener(e-> {
    		for (Equipment eq: tsystem.getAllEquipmentsList()) {
    			if ((comboBox.getSelectedItem().toString()).startsWith(eq.getName())) {
    				try {
						student.buyEquipment(eq);
						JOptionPane.showMessageDialog(null, "Equipment successfully bought! Please login again to see your updated balance.");
					} catch (CannotBuyEquipmentException e1) {
						JOptionPane.showMessageDialog(null, e1);
						return;
					}
    			}
    		}
    	});
    	
    }
}
