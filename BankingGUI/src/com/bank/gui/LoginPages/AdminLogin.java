package com.bank.gui.LoginPages;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.bank.gui.AdminPage;
import com.bank.gui.LoadingPage;
import com.bank.gui.StartPage;
import com.bank.gui.Current.CurrentAdmin;
import com.bank.gui.Dialogs.AddBank;

import database.MyDataBase;
import socket.GuiClient;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JCheckBox;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
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
	public AdminLogin() {
		this.setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 456);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0), 5), "ADMIN AUTHENTICATION", TitledBorder.CENTER, TitledBorder.CENTER, new Font("Tahoma",Font.BOLD,20), Color.GREEN));
		panel.setBackground(Color.RED);
		panel.setBounds(12, 13, 550, 430);
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
		
		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtId.setOpaque(false);
		txtId.setBounds(113, 130, 347, 57);
		panel.add(txtId);
		txtId.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setEchoChar('*');
		txtPassword.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtPassword.setOpaque(false);
		txtPassword.setColumns(10);
		txtPassword.setBounds(113, 266, 347, 57);
		panel.add(txtPassword);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				if(txtId.getText().isEmpty()|| txtPassword.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "EMPTY CREDENTIALS");
				}
				else 
				{
					
				HashMap<String , String> details=new HashMap<>();
				details.put("ID", txtId.getText());
				details.put("PASSWORD",txtPassword.getText());
				try {
					GuiClient.getDout().writeInt(1);
					GuiClient.getCout().writeObject(details);
					int isadmin=GuiClient.getDin().readInt();
					if(isadmin==1)
					{
						new LoadingPage(true).setVisible(true);
						CurrentAdmin.setId(Integer.parseInt(txtId.getText()));
						CurrentAdmin.setPassword(txtPassword.getText());
						ResultSet rs=MyDataBase.getConn().createStatement().executeQuery("select bname,baddress from banks where bid='"+txtId.getText()+"'");
						
						String bankname = null;
						String baddress = null;
						if(rs.next())
						{
							bankname=rs.getString(1);
							baddress = rs.getString(2);
						}
						CurrentAdmin.setBankname(bankname);
						CurrentAdmin.setBankaddress(baddress);
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "INVALID ID OR PASSWORD");
					}
				} catch (IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				}
			}
		});
		btnLogin.setForeground(Color.BLUE);
		btnLogin.setBackground(Color.ORANGE);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnLogin.setBounds(194, 374, 174, 43);
		panel.add(btnLogin);
		
		JLabel lblNewLabel_1 = new JLabel("ENTER ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setBounds(116, 101, 155, 26);
		panel.add(lblNewLabel_1);
		
		JLabel lblEnterPassword = new JLabel("ENTER PASSWORD");
		lblEnterPassword.setForeground(Color.YELLOW);
		lblEnterPassword.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblEnterPassword.setBounds(116, 234, 252, 26);
		panel.add(lblEnterPassword);
		
		JButton btnAdd = new JButton("ADD BANK");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new AddBank().setVisible(true);
				
			}
		});
		btnAdd.setBackground(Color.RED);
		btnAdd.setForeground(Color.GREEN);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdd.setIcon(new ImageIcon("src//add.png"));
		btnAdd.setHorizontalAlignment(SwingConstants.CENTER);
		btnAdd.setBounds(396, 29, 142, 54);
		panel.add(btnAdd);
		
		JCheckBox showPass = new JCheckBox("SHOW PASSWORD");
		showPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		showPass.setBackground(Color.RED);
		showPass.setForeground(Color.YELLOW);
		showPass.setBounds(219, 332, 149, 25);
		panel.add(showPass);
	}
}
