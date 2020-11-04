package com.bank.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.CardLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;


import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import com.bank.gui.Current.CurrentAdmin;
import com.bank.gui.Current.CurrentUser;
import com.bank.gui.Dialogs.AddBank;

import database.MyDataBase;
import net.proteanit.sql.DbUtils;
import socket.GuiClient;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.ComponentOrientation;
import java.awt.ScrollPane;


public class AdminPage extends JFrame implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtId;
	private JTextField txtAccNo;
	private JTextField txtPhone;
	private JTextField txtBalance;
	private JPasswordField txtPassword;
	private JTable tableUsers;
	private JTextField txtSearch;
	private JTextField textField_7;
	private JTextField textField_8;
	private JPasswordField textField_9;
	boolean isVisi=true;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel pnlCreateUser;
	private JPanel pnlShowUser;
	private JPanel pnlRequests;
	private JPanel pnlTransactions;
	private JPanel pnlSearchUser;
	private JComboBox comboBox; 
	private JButton btsearch;
	private JButton btnCreateUser;
	private JButton btnShowUser;
	private JButton btnRequest;
	private JButton btnTransaction;
	private JButton btnSearchUser;
	private JButton btnBankInfo;
	private JButton btnLogOut;
	private JPanel pnlLogOut;
	private JPanel pnlBankInfo;
	private JTable tableTransactions;
	private JTextField textField;
	private JTable sresults;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage frame = new AdminPage();
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
	public AdminPage() 
	{
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 5, 1354, 953);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(null);
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 117, 293, 836);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnCreateUser = new JButton(" CREATE USERS");
		btnCreateUser.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		ImageIcon ic=new ImageIcon("src//plus.png");
		Image img=ic.getImage();
		img=img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ic=new ImageIcon(img);
		btnCreateUser.setIcon(ic);

		Color btnPanel=Color.ORANGE;
		
		
		panel.add(btnCreateUser);
		
		btnShowUser = new JButton(" SHOW USERS");
		btnShowUser.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		ic=new ImageIcon("src//show.png");
		img=ic.getImage();
		img=img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ic=new ImageIcon(img);
		btnShowUser.setIcon(ic);
		panel.add(btnShowUser);
		ic=new ImageIcon("src//notification.png");
		img=ic.getImage();
		img=img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ic=new ImageIcon(img);
		btnRequest = new JButton(" REQUESTS");
		btnRequest.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		btnRequest.setIcon(ic);
		panel.add(btnRequest);
		
		btnTransaction = new JButton("TRANSACTIONS");
		btnTransaction.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		ic=new ImageIcon("src//transaction.png");
		img=ic.getImage();
		img=img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ic=new ImageIcon(img);
		btnTransaction.setIcon(ic);
		panel.add(btnTransaction);
		
		btnSearchUser = new JButton(" SEARCH USER");
		btnSearchUser.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		ic=new ImageIcon("src//search (1).png");
		img=ic.getImage();
		img=img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ic=new ImageIcon(img);
		btnSearchUser.setIcon(ic);
		panel.add(btnSearchUser);
		
		btnBankInfo = new JButton(" BANK INFO");
		btnBankInfo.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		btnBankInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		ic=new ImageIcon("src//mobile-banking.png");
		img=ic.getImage();
		img=img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ic=new ImageIcon(img);
		btnBankInfo.setIcon(ic);
		panel.add(btnBankInfo);
		
		btnLogOut = new JButton(" LOG OUT");
		btnLogOut.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		ic=new ImageIcon("src//logout.png");
		img=ic.getImage();
		img=img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ic=new ImageIcon(img);
		btnLogOut.setIcon(ic);
		panel.add(btnLogOut);
		
		btnCreateUser.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnSearchUser.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnBankInfo.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnRequest.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnShowUser.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnTransaction.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		btnCreateUser.setForeground(btnPanel);
		btnLogOut.setForeground(btnPanel);
		btnSearchUser.setForeground(btnPanel);
		btnBankInfo.setForeground(btnPanel);
		btnRequest.setForeground(btnPanel);
		btnShowUser.setForeground(btnPanel);
		btnTransaction.setForeground(btnPanel);
		
		btnPanel=Color.DARK_GRAY;
		
		btnCreateUser.setBackground(btnPanel);
		btnLogOut.setBackground(btnPanel);
		btnSearchUser.setBackground(btnPanel);
		btnBankInfo.setBackground(btnPanel);
		btnRequest.setBackground(btnPanel);
		btnShowUser.setBackground(btnPanel);
		btnTransaction.setBackground(btnPanel);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(291, 117, 1063, 836);
		contentPane.add(panel_1);
		CardLayout card=new CardLayout(0, 0);
		panel_1.setLayout(card);
		
		pnlCreateUser = new JPanel();
		pnlCreateUser.setForeground(Color.WHITE);
		pnlCreateUser.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0), 5, true), "CREATE USER", TitledBorder.CENTER, TitledBorder.BELOW_TOP,new Font("Tahoma",Font.BOLD,50), Color.RED));
		pnlCreateUser.setBackground(Color.BLACK);
		panel_1.add(pnlCreateUser, "CREATE");
		pnlCreateUser.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(534, 115, 14, 600);
		pnlCreateUser.add(separator);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtName.setOpaque(false);
		txtName.setForeground(Color.WHITE);
		txtName.setBackground(Color.GRAY);
		txtName.setBounds(82, 174, 404, 65);
		pnlCreateUser.add(txtName);
		txtName.setCaretColor(Color.white);
		txtName.setColumns(10);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtId.setForeground(Color.WHITE);
		txtId.setOpaque(false);
		txtId.setColumns(10);
		txtId.setBounds(82, 370, 404, 65);
		txtId.setCaretColor(Color.white);
		pnlCreateUser.add(txtId);
		
		txtAccNo = new JTextField();
		txtAccNo.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtAccNo.setForeground(Color.WHITE);
		txtAccNo.setColumns(10);
		txtAccNo.setOpaque(false);
		txtAccNo.setBounds(82, 573, 404, 65);
		txtAccNo.setCaretColor(Color.white);
		pnlCreateUser.add(txtAccNo);
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtPhone.setForeground(Color.WHITE);
		txtPhone.setColumns(10);
		txtPhone.setOpaque(false);
		txtPhone.setBounds(586, 174, 404, 65);
		txtPhone.setCaretColor(Color.white);
		pnlCreateUser.add(txtPhone);
		
		txtBalance = new JTextField();
		txtBalance.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtBalance.setForeground(Color.WHITE);
		txtBalance.setColumns(10);
		txtBalance.setOpaque(false);
		txtBalance.setBounds(586, 370, 404, 65);
		txtBalance.setCaretColor(Color.white);
		pnlCreateUser.add(txtBalance);
		
		txtPassword = new JPasswordField();
		txtPassword.setEchoChar('*');
		txtPassword.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtPassword.setForeground(Color.WHITE);
		this.txtPassword.setOpaque(false);
		txtPassword.setBounds(586, 573, 404, 65);
		txtPassword.setCaretColor(Color.white);
		pnlCreateUser.add(txtPassword);
		
		JLabel lblNewLabel_1 = new JLabel("ENTER NAME");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setBounds(82, 145, 240, 30);
		pnlCreateUser.add(lblNewLabel_1);
		
		JLabel lblEnterId = new JLabel("ENTER ID");
		lblEnterId.setForeground(Color.YELLOW);
		lblEnterId.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEnterId.setBounds(82, 341, 240, 30);
		pnlCreateUser.add(lblEnterId);
		
		JLabel lblEnterAccountNumber = new JLabel("ENTER ACCNO.");
		lblEnterAccountNumber.setForeground(Color.YELLOW);
		lblEnterAccountNumber.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEnterAccountNumber.setBounds(82, 545, 240, 30);
		pnlCreateUser.add(lblEnterAccountNumber);
		
		JLabel lblEnterPhoneno = new JLabel("ENTER PHONENO.");
		lblEnterPhoneno.setForeground(Color.YELLOW);
		lblEnterPhoneno.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEnterPhoneno.setBounds(586, 145, 301, 30);
		pnlCreateUser.add(lblEnterPhoneno);
		
		JLabel lblEnterInitialdeposit = new JLabel("ENTER INITIAL DEPOSIT");
		lblEnterInitialdeposit.setForeground(Color.YELLOW);
		lblEnterInitialdeposit.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEnterInitialdeposit.setBounds(586, 341, 404, 30);
		pnlCreateUser.add(lblEnterInitialdeposit);
		
		JLabel lblEnterPassword = new JLabel("ENTER PASSWORD");
		lblEnterPassword.setForeground(Color.YELLOW);
		lblEnterPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEnterPassword.setBounds(586, 545, 404, 30);
		pnlCreateUser.add(lblEnterPassword);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					
					MyDataBase.addUser(txtName.getText(), txtId.getText(), txtPassword.getText(), Double.parseDouble(txtPhone.getText()), txtAccNo.getText(), Double.parseDouble(txtBalance.getText()),CurrentAdmin.getBankname());           
		                              		            
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e.getMessage());
					
				}
			}
		});
		btnNewButton.setForeground(new Color(50, 205, 50));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(204, 255, 255));
		btnNewButton.setIcon(new ImageIcon("src//Save-icon.png"));
		btnNewButton.setBounds(355, 750, 131, 49);
		pnlCreateUser.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CLEAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtName.setText("");
				txtId.setText("");
				txtPassword.setText("");
				txtPhone.setText("");
				txtAccNo.setText("");
				txtBalance.setText("");
				txtName.requestFocus();
			}
		});
		btnNewButton_1.setForeground(new Color(50, 205, 50));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBackground(new Color(204, 255, 255));
		btnNewButton_1.setIcon(new ImageIcon("src//Actions-edit-clear-icon.png"));
		btnNewButton_1.setBounds(586, 750, 131, 49);
		pnlCreateUser.add(btnNewButton_1);
		
		pnlShowUser = new JPanel();
		pnlShowUser.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0), 5, true), "CURRENT ACCOUNTHOLDERS", TitledBorder.CENTER, TitledBorder.BELOW_TOP, new Font("Tahoma",Font.BOLD,50), new Color(255, 0, 0)));
		pnlShowUser.setBackground(Color.BLACK);
		panel_1.add(pnlShowUser, "SHOW");
		pnlShowUser.setLayout(null);
		
		
//		);
		JScrollPane uScroll = new JScrollPane();
		uScroll.setBackground(new Color(0, 0, 255));
		uScroll.setLocation(12, 82);
		uScroll.setSize(1039, 729);
		uScroll.setVisible(true);
		
		pnlShowUser.add(uScroll);
		
		tableUsers = new JTable();
		tableUsers.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableUsers.setBackground(Color.BLACK);
		tableUsers.setForeground(Color.WHITE);
		tableUsers.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		
		tableUsers.setRowHeight(70);
		uScroll.setViewportView(tableUsers);
		
		pnlRequests = new JPanel();
		pnlRequests.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0), 5, true), "REQUESTS", TitledBorder.CENTER, TitledBorder.BELOW_TOP, new Font("Tahoma",Font.BOLD,50), Color.RED));
		pnlRequests.setBackground(Color.BLACK);
		panel_1.add(pnlRequests, "REQUEST");
		pnlRequests.setLayout(null);
		
		pnlTransactions = new JPanel();
		pnlTransactions.setBackground(Color.BLACK);
		pnlTransactions.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0), 5, true), "TRANSACTIONS", TitledBorder.CENTER, TitledBorder.BELOW_TOP, new Font("Tahoma",Font.BOLD,50), Color.RED));
		panel_1.add(pnlTransactions, "TRANSACTION");
		
		pnlSearchUser = new JPanel();
		pnlSearchUser.setBackground(Color.BLACK);
		pnlSearchUser.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0), 5, true), "SEARCH USER", TitledBorder.CENTER, TitledBorder.BELOW_TOP, new Font("Tahoma",Font.BOLD,50), Color.RED));
		panel_1.add(pnlSearchUser, "SEARCH");
		pnlSearchUser.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setBorder(null);
		comboBox.setForeground(Color.YELLOW);
		comboBox.setBackground(Color.BLACK);
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"BY MOBILE NUMBER ", "BY NAME"}));
		comboBox.setSelectedIndex(0);
		
		comboBox.setBounds(301, 110, 360, 63);
		pnlSearchUser.add(comboBox);
		
		txtSearch = new JTextField();
		txtSearch.setCaretColor(Color.WHITE);
		txtSearch.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtSearch.setForeground(Color.WHITE);
		txtSearch.setOpaque(false);
		txtSearch.setBounds(174, 276, 420, 48);
		pnlSearchUser.add(txtSearch);
		txtSearch.setColumns(10);
		
		btsearch =  new JButton("SEARCH");
		btsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String p=(String) comboBox.getSelectedItem();
				if(p.contains("MOBILE"))
				{
					
						try 
						{
							searchResult(Double.parseDouble(txtSearch.getText()), CurrentAdmin.getBankname());
						} 
						catch (NumberFormatException e) 
						{
							
							JOptionPane.showMessageDialog(null, "PHONE NUMBER CAN NOT BE STRING");
						} 
						catch (SQLException e) 
						{
							
							JOptionPane.showMessageDialog(null, e);
						}
					
					
				}
				else if(p.contains("NAME"))
				{
					try 
					{
						searchResult(txtSearch.getText(), CurrentAdmin.getBankname());
					} 
					catch (SQLException e) 
					{
						
						JOptionPane.showMessageDialog(null, e);
					}
				}
			}
		});
		btsearch.setBackground(Color.BLACK);
		btsearch.setFont(new Font("Tahoma", Font.BOLD, 15));
		btsearch.setForeground(Color.YELLOW);
		btsearch.setBounds(606, 282, 132, 37);
		pnlSearchUser.add(btsearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.BLACK);
		scrollPane.setBounds(61, 418, 967, 381);
		pnlSearchUser.add(scrollPane);
		
		scrollPane.setVisible(true);
		
		sresults=new JTable();
		sresults.setBackground(Color.BLACK);
		sresults.setForeground(Color.WHITE);
		sresults.setRowHeight(70);
		sresults.setFont(new Font("Tahoma", Font.BOLD, 25));
		sresults.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(sresults);
		
		pnlBankInfo = new JPanel();
		pnlBankInfo.setBackground(Color.BLACK);
		pnlBankInfo.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0), 5, true), "BANK INFO", TitledBorder.CENTER, TitledBorder.BELOW_TOP, new Font("Tahoma",Font.BOLD,50), Color.RED));

		panel_1.add(pnlBankInfo, "INFO");
		pnlBankInfo.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 25));
		textField.setForeground(Color.WHITE);
		textField.setEditable(false);
		textField.setOpaque(false);
		textField.setBounds(359, 208, 564, 66);
		pnlBankInfo.add(textField);
		textField.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.BOLD, 25));
		textField_7.setForeground(Color.WHITE);
		textField_7.setEditable(false);
		textField_7.setOpaque(false);
		textField_7.setBackground(Color.BLACK);
		textField_7.setBounds(359, 371, 564, 66);
		pnlBankInfo.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setForeground(Color.WHITE);
		textField_8.setFont(new Font("Tahoma", Font.BOLD, 25));
		textField_8.setEditable(false);
		textField_8.setOpaque(false);
		textField_8.setColumns(10);
		textField_8.setBounds(359, 542, 564, 66);
		pnlBankInfo.add(textField_8);
		
		textField_9 = new JPasswordField();
		textField_9.setForeground(Color.WHITE);
		textField_9.setFont(new Font("Tahoma", Font.BOLD, 25));
		textField_9.setEchoChar('*');
		textField_9.setEditable(false);
		textField_9.setOpaque(false);
		textField_9.setColumns(10);
		textField_9.setBounds(359, 689, 564, 66);
		pnlBankInfo.add(textField_9);
		
		JLabel lblNewLabel_4 = new JLabel("NAME");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_4.setForeground(Color.YELLOW);
		lblNewLabel_4.setBounds(148, 208, 186, 66);
		pnlBankInfo.add(lblNewLabel_4);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.TRAILING);
		lblId.setForeground(Color.YELLOW);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblId.setBounds(161, 371, 186, 66);
		pnlBankInfo.add(lblId);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAddress.setForeground(Color.YELLOW);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAddress.setBounds(161, 542, 186, 66);
		pnlBankInfo.add(lblAddress);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPassword.setForeground(Color.YELLOW);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPassword.setBounds(161, 689, 186, 66);
		pnlBankInfo.add(lblPassword);
		
		JButton btnNewButton_2 = new JButton("SHOW");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField_9.getEchoChar()=='*')
				{
					textField_9.setEchoChar((char)0);
					btnNewButton_2.setText("HIDE");
				}
				else
				{
					textField_9.setEchoChar('*');
					btnNewButton_2.setText("SHOW");
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBounds(935, 689, 116, 66);
		pnlBankInfo.add(btnNewButton_2);
		
		pnlLogOut = new JPanel();
		pnlLogOut.setBackground(Color.BLACK);
		pnlLogOut.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0), 5, true), "LOG OUT", TitledBorder.CENTER, TitledBorder.BELOW_TOP, new Font("Tahoma",Font.BOLD,50), Color.RED));
		panel_1.add(pnlLogOut, "LOGOUT");
		pnlLogOut.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("src//logout.png"));
		lblNewLabel_3.setBounds(65, 75, 692, 715);
		pnlLogOut.add(lblNewLabel_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.RED, 5, true));
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(0, 0, 1354, 117);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMIN WINDOW");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 60));
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setBounds(0, 0, 506, 117);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_8 = new JLabel("");
		ic=new ImageIcon("src//remove.png");
		img=ic.getImage();
		img=img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		ic=new ImageIcon(img);
		lblNewLabel_8.setIcon(ic);
		lblNewLabel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int p=JOptionPane.showConfirmDialog(contentPane, "DO YOU WANT TO EXIT","EXIT",JOptionPane.YES_NO_OPTION);
				if(p==JOptionPane.YES_OPTION)
				{
					try {
						GuiClient.getDout().writeInt(3);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					dispose();
				}
				else
				{
					
				}
				
			}
		});
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 70));
		lblNewLabel_8.setForeground(Color.RED);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(1242, 0, 112, 117);
		panel_2.add(lblNewLabel_8);
		pnlTransactions.setLayout(null);
		
		
		JScrollPane js2=new JScrollPane();
		js2.setBounds(31, 76, 1004, 731);
		js2.setVisible(true);
		this.pnlTransactions.add(js2);
		
		tableTransactions = new JTable();
		tableTransactions.setForeground(Color.WHITE);
		tableTransactions.setBackground(Color.BLACK);
		tableTransactions.setFont(new Font("Tahoma", Font.BOLD, 25));
		js2.setViewportView(tableTransactions);
		this.tableTransactions.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		this.tableTransactions.setRowHeight(70);
		
		
		btnShowUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(panel_1, "SHOW");
				
				try 
				{
				
				  String sql="select uname,uid,uaccno,uphone,ubalance,upassword from ACCOUNTHOLDERS where bname='"+CurrentAdmin.getBankname()+"'";
		          PreparedStatement pst = MyDataBase.getConn().prepareStatement(sql);
		          ResultSet rs = pst.executeQuery();
		          tableUsers.setVisible(false);
		          tableUsers.setModel(DbUtils.resultSetToTableModel(rs));		          
		          JTableHeader head=tableUsers.getTableHeader();		          
		          head.setFont(new Font("TAHOMA",Font.BOLD,30));
		          head.setBackground(Color.YELLOW);
		          TableColumnModel P=head.getColumnModel();  
		          P.getColumn(0).setHeaderValue("NAME");
		          P.getColumn(0).setPreferredWidth(150);
		          P.getColumn(1).setHeaderValue("ID");
		          P.getColumn(1).setPreferredWidth(50);
		          P.getColumn(2).setHeaderValue("ACCOUNT_NUMBER");
		          P.getColumn(2).setPreferredWidth(350);
		          P.getColumn(3).setHeaderValue("PHONE_NUMBER");
		          P.getColumn(3).setPreferredWidth(300);
		          P.getColumn(4).setHeaderValue("BALANCE");
		          P.getColumn(4).setPreferredWidth(150);
		          P.getColumn(5).setHeaderValue("PASSWORD");
		          P.getColumn(5).setPreferredWidth(200);
		          tableUsers.setCellSelectionEnabled(false);
		          tableUsers.setEnabled(false);
		          tableUsers.setVisible(true);
		            
		         }
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		
		btnCreateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(panel_1, "CREATE");
					
				
			}
		});
		
		btnTransaction.addActionListener(new ActionListener() {					
			public void actionPerformed(ActionEvent arg0) {
				card.show(panel_1, "TRANSACTION");
				
				try 
				{
				
					
				 
		          ResultSet rs = MyDataBase.getConn().createStatement().executeQuery("SELECT * FROM transactions where sbname='"+CurrentAdmin.getBankname()+"' or rbname='"+CurrentAdmin.getBankname()+"' order by date desc");
		          tableTransactions.setVisible(false);
		          tableTransactions.setModel(DbUtils.resultSetToTableModel(rs));		          
		          JTableHeader head=tableTransactions.getTableHeader();		          
		          head.setFont(new Font("TAHOMA",Font.BOLD,30));
		          head.setBackground(Color.YELLOW);
		          TableColumnModel P=head.getColumnModel();  
		          P.getColumn(0).setHeaderValue("SENDER ACC_NO");
		          P.getColumn(0).setPreferredWidth(150);
		          P.getColumn(1).setHeaderValue("RECEIVER ACC-NO");
		          P.getColumn(1).setPreferredWidth(50);
		          P.getColumn(2).setHeaderValue("SENDER BANK_NAME");
		          P.getColumn(2).setPreferredWidth(350);
		          P.getColumn(3).setHeaderValue("RECEIVER BANK_NAME");
		          P.getColumn(3).setPreferredWidth(300);
		          P.getColumn(4).setHeaderValue("DATE & TIME");
		          P.getColumn(4).setPreferredWidth(150);
		          P.getColumn(5).setHeaderValue("MONEY");
		          P.getColumn(5).setPreferredWidth(200);
		          P.getColumn(6).setHeaderValue("TYPE");
		          P.getColumn(6).setPreferredWidth(50);
		          tableTransactions.setCellSelectionEnabled(false);
		          tableTransactions.setEnabled(false);
		          tableTransactions.setVisible(true);
		            
		         }
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
			}			
		});
		

		btnSearchUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sresults.setVisible(false);
				card.show(panel_1, "SEARCH");
			}
		});
		

		btnRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(panel_1, "REQUEST");
				try
				{
				ResultSet RS=MyDataBase.getConn().createStatement().executeQuery("select * from requests where bname='"+CurrentAdmin.getBankname()+"' order by ubalance desc");
				
				
					while(RS.next())
					{
						
                        
						if(RS.getString(1).equals("TO CHANGE PHONE NUMBER"))
                        {
                            
                            int K=JOptionPane.showConfirmDialog(pnlRequests,"request from id:"+RS.getString(4)+" \nto change phone number to "+RS.getDouble(3)+"\n do you want to accept it?","REQUEST",JOptionPane.YES_NO_OPTION);
                            
                            if(K==JOptionPane.YES_OPTION)
                            {
                                MyDataBase.getConn().createStatement().executeUpdate("update accountholders set uphone='"+RS.getDouble(3)+"' where uid='"+RS.getString(4)+"' and bname='"+RS.getString(5)+"'");
                                MyDataBase.addNotifications("REQUEST ACCEPTED", CurrentUser.getId(), CurrentUser.getBankname());
                            }
                            else if(K==JOptionPane.NO_OPTION)
                            {
                            	MyDataBase.addNotifications("REQUEST REJECTED", CurrentUser.getId(), CurrentUser.getBankname());
                            }
                        }
                        else if(RS.getString(1).equals("TO CHANGE NAME"))
                        {
                            
                            int K=JOptionPane.showConfirmDialog(pnlRequests,"request from id:"+RS.getString(4)+" \nto change name  to "+RS.getString(2)+"\n do you want to accept it?","REQUEST",JOptionPane.YES_NO_OPTION);
                            
                            if(K==JOptionPane.YES_OPTION)
                            {
                                MyDataBase.getConn().createStatement().executeUpdate("update accountholders set uname='"+RS.getString(2)+"' where uid='"+RS.getString(4)+"' and bname='"+RS.getString(5)+"'");
                                MyDataBase.addNotifications("REQUEST ACCEPTED", CurrentUser.getId(), CurrentUser.getBankname());
                            }
                            else if(K==JOptionPane.NO_OPTION)
                            {
                            	MyDataBase.addNotifications("REQUEST REJECTED", CurrentUser.getId(), CurrentUser.getBankname());
                            }
                        }
                        else
                        {
                            
                            int K=JOptionPane.showConfirmDialog(pnlRequests,"request from id:"+RS.getString(4)+" \nto change name and phone number to "+RS.getString(2)+" and "+RS.getDouble(3)+"\n do you want to accept it?","REQUEST",JOptionPane.YES_NO_OPTION);
                            
                            if(K==JOptionPane.YES_OPTION)
                            {
                                MyDataBase.getConn().createStatement().executeUpdate("update accountholders set uname='"+RS.getString(2)+"', uphone='"+RS.getDouble(3)+"' where uid='"+RS.getString(4)+"' and bname='"+RS.getString(5)+"'");
                                MyDataBase.addNotifications("REQUEST ACCEPTED", CurrentUser.getId(), CurrentUser.getBankname());
                            }
                            else if(K==JOptionPane.NO_OPTION)
                            {
                            	MyDataBase.addNotifications("REQUEST REJECTED", CurrentUser.getId(), CurrentUser.getBankname());
                            }
                        }
                       
						
					}
					RS.close();
					MyDataBase.removeRequests(CurrentAdmin.getBankname());
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		

		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(panel_1, "LOGOUT");
				int r=JOptionPane.showConfirmDialog(pnlLogOut, "DO YOU WANT TO LOG OUT..??..","LOG OUT",JOptionPane.YES_NO_OPTION);
				if(r==JOptionPane.YES_OPTION)
				{
					new StartPage().setVisible(true);
					dispose();
				}
			}
		});
		
		btnBankInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(panel_1, "INFO");
				textField.setText(CurrentAdmin.getBankname());
				textField_7.setText(String.valueOf(CurrentAdmin.getId()));
				textField_8.setText(CurrentAdmin.getBankaddress());
				textField_9.setText(CurrentAdmin.getPassword());
			}
		});
		this.btnCreateUser.addMouseListener(this);
		this.btnShowUser.addMouseListener(this);
		this.btnRequest.addMouseListener(this);
		this.btnBankInfo.addMouseListener(this);
		this.btnLogOut.addMouseListener(this);
		this.btnSearchUser.addMouseListener(this);
		this.btnTransaction.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {}

	@Override
	public void mouseEntered(MouseEvent arg0) 
	{
		((JButton)arg0.getSource()).setBackground(Color.BLACK);
	}

	@Override
	public void mouseExited(MouseEvent arg0) 
	{
		((JButton)arg0.getSource()).setBackground(Color.DARK_GRAY);
	}

	@Override
	public void mousePressed(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {}
	
    <T> void searchResult(T key,String bname) throws SQLException 
    {
        Statement st=MyDataBase.getConn().createStatement();
        ResultSet rs;
        if(key instanceof Double)
        {
            rs=st.executeQuery("select uname,uid,uaccno,uphone,ubalance,upassword from ACCOUNTHOLDERS where uphone='"+key+"' and bname='"+bname+"'");
            
            sresults.setModel(DbUtils.resultSetToTableModel(rs));
            JTableHeader head=sresults.getTableHeader();		          
	          head.setFont(new Font("TAHOMA",Font.BOLD,30));
	          head.setBackground(Color.YELLOW);
	          TableColumnModel P=head.getColumnModel();  
	          P.getColumn(0).setHeaderValue("NAME");
	          P.getColumn(0).setPreferredWidth(150);
	          P.getColumn(1).setHeaderValue("ID");
	          P.getColumn(1).setPreferredWidth(50);
	          P.getColumn(2).setHeaderValue("ACCOUNT_NUMBER");
	          P.getColumn(2).setPreferredWidth(350);
	          P.getColumn(3).setHeaderValue("PHONE_NUMBER");
	          P.getColumn(3).setPreferredWidth(300);
	          P.getColumn(4).setHeaderValue("BALANCE");
	          P.getColumn(4).setPreferredWidth(150);
	          P.getColumn(5).setHeaderValue("PASSWORD");
	          P.getColumn(5).setPreferredWidth(200);
	          sresults.setCellSelectionEnabled(false);
	          sresults.setEnabled(false);
	          sresults.setVisible(true);
            
            rs.close();
        }
        else if(key instanceof String)
        {
            rs=st.executeQuery("select uname,uid,uaccno,uphone,ubalance,upassword from ACCOUNTHOLDERS where uname='"+key+"' and bname='"+bname+"'");
            sresults.setModel(DbUtils.resultSetToTableModel(rs)); 
            JTableHeader head=sresults.getTableHeader();		          
	          head.setFont(new Font("TAHOMA",Font.BOLD,30));
	          head.setBackground(Color.YELLOW);
	          TableColumnModel P=head.getColumnModel();  
	          P.getColumn(0).setHeaderValue("NAME");
	          P.getColumn(0).setPreferredWidth(150);
	          P.getColumn(1).setHeaderValue("ID");
	          P.getColumn(1).setPreferredWidth(50);
	          P.getColumn(2).setHeaderValue("ACCOUNT_NUMBER");
	          P.getColumn(2).setPreferredWidth(350);
	          P.getColumn(3).setHeaderValue("PHONE_NUMBER");
	          P.getColumn(3).setPreferredWidth(300);
	          P.getColumn(4).setHeaderValue("BALANCE");
	          P.getColumn(4).setPreferredWidth(150);
	          P.getColumn(5).setHeaderValue("PASSWORD");
	          P.getColumn(5).setPreferredWidth(200);
	          sresults.setCellSelectionEnabled(false);
	          sresults.setEnabled(false);
	          sresults.setVisible(true);
             rs.close();                      
        }       
            
    }
}
