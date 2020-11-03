package com.bank.gui.LoginPages;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.bank.gui.LoadingPage;
import com.bank.gui.StartPage;
import com.bank.gui.Current.CurrentAdmin;
import com.bank.gui.Current.CurrentUser;

import database.MyDataBase;
import socket.GuiClient;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtBankName;
	private JTextField txtId;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogin frame = new UserLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserLogin() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0), 5), "USER AUTHENTICATION", TitledBorder.CENTER, TitledBorder.TOP,  new Font("Tahoma",Font.BOLD,20), Color.GREEN));
		panel.setBounds(12, 13, 561, 474);
		contentPane.add(panel);
		panel.setLayout(null);
		
		ImageIcon ic=new ImageIcon("src//back.png");
		Image img=ic.getImage();
		img=img.getScaledInstance(70,70, Image.SCALE_SMOOTH);
		ic=new ImageIcon(img);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new StartPage().setVisible(true);
				dispose();
			}
		});
		lblNewLabel.setIcon(ic);
		lblNewLabel.setBounds(12, 25, 76, 70);
		panel.add(lblNewLabel);
		
		txtBankName = new JTextField();
		txtBankName.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtBankName.setForeground(Color.BLACK);
		txtBankName.setCaretColor(Color.YELLOW);
		txtBankName.setOpaque(false);
		txtBankName.setBounds(123, 115, 324, 49);
		panel.add(txtBankName);
		txtBankName.setColumns(10);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtId.setOpaque(false);
		txtId.setColumns(10);
		txtId.setCaretColor(Color.YELLOW);
		txtId.setBounds(123, 213, 324, 49);
		panel.add(txtId);
		
		txtPassword = new JPasswordField();
		txtPassword.setEchoChar('*');
		txtPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtPassword.setOpaque(false);
		txtPassword.setColumns(10);
		txtPassword.setCaretColor(Color.YELLOW);
		txtPassword.setBounds(123, 310, 324, 49);
		panel.add(txtPassword);
		
		JLabel lblNewLabel_1 = new JLabel("ENTER BANKNAME");
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setBounds(123, 86, 105, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblEnterId = new JLabel("ENTER ID");
		lblEnterId.setForeground(Color.YELLOW);
		lblEnterId.setBounds(123, 184, 105, 16);
		panel.add(lblEnterId);
		
		JLabel lblEnterpassword = new JLabel("ENTER PASSWORD");
		lblEnterpassword.setForeground(Color.YELLOW);
		lblEnterpassword.setBounds(123, 281, 126, 16);
		panel.add(lblEnterpassword);
		
		JCheckBox showPass = new JCheckBox("SHOW PASSWORD");
		showPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(showPass.isSelected())
				{
					txtPassword.setEchoChar((char)0);
				}
				else
				{
					txtPassword.setEchoChar('*');
				}
			}
		});
		showPass.setForeground(Color.YELLOW);
		showPass.setBackground(Color.RED);
		showPass.setBounds(217, 373, 143, 25);
		panel.add(showPass);
		
		JButton button = new JButton("LOGIN");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				if(txtId.getText().isEmpty()|| txtPassword.getText().isEmpty() || txtBankName.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "EMPTY CREDENTIALS");
				}
				else {
					
				HashMap<String , String> details=new HashMap<>();
				details.put("BANKNAME", txtBankName.getText());
				details.put("ID", txtId.getText());
				details.put("PASSWORD",txtPassword.getText());
				try {
					GuiClient.getDout().writeInt(2);
					GuiClient.getCout().writeObject(details);
					int isuser=GuiClient.getDin().readInt();
					if(isuser==1)
					{
						new LoadingPage(false).setVisible(true);
						CurrentUser.setId(txtId.getText());
						CurrentUser.setPassword(txtPassword.getText());
						CurrentUser.setBankname(txtBankName.getText());
						ResultSet rs=MyDataBase.getConn().createStatement().executeQuery("select uaccno from accountholders where uid='"+txtId.getText()+"' and bname='"+txtBankName.getText()+"' and upassword = '"+txtPassword.getText()+"'");  
						if(rs.next())
						{
							CurrentUser.setAccno(rs.getString(1));
						}
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "INVALID ID OR PASSWORD");
					}
				} catch (IOException | SQLException e) {
					
					JOptionPane.showMessageDialog(null,e);
				}
				
				}
				
				
				
			}
		});
		button.setForeground(Color.BLUE);
		button.setFont(new Font("Tahoma", Font.BOLD, 30));
		button.setBackground(Color.ORANGE);
		button.setBounds(191, 410, 174, 34);
		panel.add(button);
	}
}
