package com.bank.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.InputMethodListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.InputMethodEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import com.bank.gui.Current.CurrentUser;
import com.bank.gui.Dialogs.AddBank;
import com.mysql.jdbc.PreparedStatement;

import java.sql.*;

import database.MyDataBase;
import net.proteanit.sql.DbUtils;
import socket.GuiClient;

import javax.swing.event.CaretEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Component;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import javax.swing.ScrollPaneConstants;

public class UserPage extends JFrame implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnSendMoney;
	private JButton btnAddMoney;
	private JButton btnWithdrawMoney;
	private JButton btnTransactions;
	private JButton btnUpdate;
	private JButton btnNotifications;
	private JButton btnLogOut;
	private JPanel panel_2;
	private JPanel pnlSend;
	private JPanel pnlAdd;
	private JPanel pnlWithdraw;
	private JPanel pnlTransactions;
	private JPanel pnlUpdate;
	private JPanel pnlNotifications;
	private JPanel pnlLogOut;
	private CardLayout card;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JLabel lblEnterAccountNumber;
	private JLabel lblEnterAmount;
	private JTextField textField_5;
	private JTextField textField_6;
	private JPanel pnlUserDetails;
	private JButton btnUserDetails;
	private JButton btnSend;
	private JLabel label_4;
	private JTextField textField_8;
	private JLabel lblId;
	private JTextField textField_9;
	private JLabel lblMobileNumber;
	private JTextField textField_10;
	private JLabel lblAccountNumber;
	private JTextField textField_11;
	private JLabel lblBalance;
	private JTextField textField_12;
	private JLabel lblBankName;
	private JTextField textField_13;
	private JLabel lblPassword;
	private JPasswordField textField_14;
	private JButton btnNewButton_1;
	
	private JTextField txtUpdateName;
	private JTextField txtUpdatePhone;
	private JButton btnOk;
	private JScrollPane js;
	private JTable tableTransaction;
	private JScrollPane scrollnotify;
	private JTable nTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserPage frame = new UserPage();
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
	public UserPage() {
		this.setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 5, 1354, 953);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		card = new CardLayout(0, 0);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(Color.RED, 5));
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 1354, 117);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUserWindow = new JLabel("USER WINDOW");
		lblUserWindow.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserWindow.setForeground(Color.YELLOW);
		lblUserWindow.setFont(new Font("Calibri", Font.BOLD, 60));
		lblUserWindow.setBounds(0, 0, 506, 117);
		panel.add(lblUserWindow);
		
		JLabel lblNewLabel = new JLabel("");
		ImageIcon ic = new ImageIcon("src//remove.png");
		Image img = ic.getImage();
		img=img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		ic=new ImageIcon(img);
		lblNewLabel.setIcon(ic);
		lblNewLabel.addMouseListener(new MouseAdapter() {
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
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 70));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(1242, 0, 112, 117);
		panel.add(lblNewLabel);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(0, 117, 293, 836);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnSendMoney = new JButton("TRANSFER");
		btnSendMoney.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		ic=new ImageIcon("src//sendmoney.png");
		img=ic.getImage();
		img=img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ic=new ImageIcon(img);
		
		btnSendMoney.setIcon(ic);
		btnSendMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(panel_2,"SEND");
			
				
				
			}
		});
		btnSendMoney.setForeground(Color.ORANGE);
		btnSendMoney.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnSendMoney.setBackground(Color.DARK_GRAY);
		panel_1.add(btnSendMoney);
		
		btnAddMoney = new JButton("DEPOSIT");
		btnAddMoney.setIconTextGap(10);
		btnAddMoney.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		ic=new ImageIcon("src//add-button.png");
		img=ic.getImage();
		img=img.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		ic=new ImageIcon(img);
		btnAddMoney.setIcon(ic);
		btnAddMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(panel_2,"ADD");
			}
		});
		btnAddMoney.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnAddMoney.setForeground(Color.ORANGE);
		btnAddMoney.setBackground(Color.DARK_GRAY);
		panel_1.add(btnAddMoney);
		
		btnWithdrawMoney = new JButton("WITHDRAW");
		btnWithdrawMoney.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		ic=new ImageIcon("src//withdraw.png");
		img=ic.getImage();
		img=img.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		ic=new ImageIcon(img);
		btnWithdrawMoney.setIcon(ic);
		btnWithdrawMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(panel_2,"WITHDRAW");
			}
		});
		btnWithdrawMoney.setForeground(Color.ORANGE);
		btnWithdrawMoney.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnWithdrawMoney.setBackground(Color.DARK_GRAY);
		panel_1.add(btnWithdrawMoney);
		
		btnTransactions = new JButton("TRANSACTIONS");
		btnTransactions.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		ic=new ImageIcon("src//transaction.png");
		img=ic.getImage();
		img=img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ic=new ImageIcon(img);
		btnTransactions.setIcon(ic);
		btnTransactions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(panel_2,"TRANSACTIONS");
							
				try {
					
				    ResultSet Trans=MyDataBase.getConn().createStatement().executeQuery("Select * from transactions where (saccno='"+CurrentUser.getAccno()+"' or raccno='"+CurrentUser.getAccno()+"' ) and (sbname='"+CurrentUser.getBankname()+"' or rbname='"+CurrentUser.getBankname()+"') order by date desc");
					tableTransaction.setModel(DbUtils.resultSetToTableModel(Trans));
					
					  JTableHeader header=tableTransaction.getTableHeader();
					  header.setFont(new Font("Tahoma",Font.BOLD,30));
					  
					  TableColumnModel P=header.getColumnModel();
					  
					  P.getColumn(0).setHeaderValue("SENDER ACC_NO");
			          P.getColumn(0).setPreferredWidth(350);
			          P.getColumn(1).setHeaderValue("RECEIVER ACC-NO");
			          P.getColumn(1).setPreferredWidth(350);
			          P.getColumn(2).setHeaderValue("SENDER BANK_NAME");
			          P.getColumn(2).setPreferredWidth(350);
			          P.getColumn(3).setHeaderValue("RECEIVER BANK_NAME");
			          P.getColumn(3).setPreferredWidth(350);
			          P.getColumn(4).setHeaderValue("DATE & TIME");
			          P.getColumn(4).setPreferredWidth(350);
			          P.getColumn(5).setHeaderValue("MONEY");
			          P.getColumn(5).setPreferredWidth(100);
			          P.getColumn(6).setHeaderValue("TYPE");
			          P.getColumn(6).setPreferredWidth(350);
			          tableTransaction.setCellSelectionEnabled(false);
			          tableTransaction.setEnabled(false);
			          tableTransaction.setVisible(true);
					
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
			}
		});
		
		btnUserDetails = new JButton("USER DETAILS");
		
		ic=new ImageIcon("src//user.png");
		img=ic.getImage();
		img=img.getScaledInstance(50,50, Image.SCALE_SMOOTH);
		ic=new ImageIcon(img);
		btnUserDetails.setIcon(ic);
		btnUserDetails.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		btnUserDetails.setForeground(Color.ORANGE);
		btnUserDetails.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnUserDetails.setBackground(Color.DARK_GRAY);
		panel_1.add(btnUserDetails);
		btnTransactions.setForeground(Color.ORANGE);
		btnTransactions.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnTransactions.setBackground(Color.DARK_GRAY);
		panel_1.add(btnTransactions);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		ic = new ImageIcon("src//pencil.png");
		img = ic.getImage();
		img=img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ic=new ImageIcon(img);
		btnUpdate.setIcon(ic);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(panel_2,"UPDATE");
				
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnUpdate.setForeground(Color.ORANGE);
		btnUpdate.setBackground(Color.DARK_GRAY);
		panel_1.add(btnUpdate);
		
		btnNotifications = new JButton("NOTIFICATIONS");
		btnNotifications.setIconTextGap(0);
		btnNotifications.setHorizontalAlignment(SwingConstants.LEADING);
		btnNotifications.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		ic = new ImageIcon("src//bell.png");
		img = ic.getImage();
		img=img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ic=new ImageIcon(img);
		btnNotifications.setIcon(ic);
		btnNotifications.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(panel_2,"NOTIFICATIONS");
				  try 
				  {
					nTable.setVisible(false);
					ResultSet kk=MyDataBase.getConn().createStatement().executeQuery("select Notify from notifications where bname='"+CurrentUser.getBankname()+"' and uid='"+CurrentUser.getId()+"' order by date desc");
					nTable.setModel(DbUtils.resultSetToTableModel(kk));
					JTableHeader header=nTable.getTableHeader();
					header.setFont(new Font("Tahoma",Font.BOLD,30));
					
					nTable.setVisible(true);
				  }
				  catch (SQLException e)
				  {
					 JOptionPane.showMessageDialog(null,e);
				  }
                  
			}
		});
		btnNotifications.setForeground(Color.ORANGE);
		btnNotifications.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNotifications.setBackground(Color.DARK_GRAY);
		panel_1.add(btnNotifications);
		
		btnLogOut = new JButton("LOG OUT");
		ic=new ImageIcon("src//logout.png");
		img=ic.getImage();
		img=img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ic=new ImageIcon(img);
		btnLogOut.setIcon(ic);
		btnLogOut.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(panel_2,"LOG OUT");
				int op=JOptionPane.showConfirmDialog(null, "DO YOU WANT TO LOG OUT ?? ", "LOG OUT", JOptionPane.YES_NO_OPTION);
				if(op==JOptionPane.YES_OPTION)
				{
					new StartPage().setVisible(true);
					dispose();
				}
			}
		});
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnLogOut.setForeground(Color.ORANGE);
		btnLogOut.setBackground(Color.DARK_GRAY);
		panel_1.add(btnLogOut);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(291, 117, 1063, 836);
		contentPane.add(panel_2);
		
		panel_2.setLayout(card);
		
		pnlSend = new JPanel();
		pnlSend.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0), 5), "SEND MONEY", TitledBorder.CENTER, TitledBorder.BELOW_TOP, new Font("Tahoma",Font.BOLD,50),Color.RED));
		pnlSend.setBackground(Color.BLACK);
		panel_2.add(pnlSend, "SEND");
		pnlSend.setLayout(null);
		
		pnlAdd = new JPanel();
		pnlAdd.setForeground(Color.YELLOW);
		pnlAdd.setBackground(Color.BLACK);
		panel_2.add(pnlAdd, "ADD");
		this.pnlAdd.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0), 5), "ADD MONEY", TitledBorder.CENTER, TitledBorder.BELOW_TOP, new Font("Tahoma",Font.BOLD,50),Color.RED));
		pnlAdd.setLayout(null);
		
		textField_5 = new JTextField();
		textField_5.setOpaque(false);
		textField_5.setForeground(Color.WHITE);
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_5.setColumns(10);
		textField_5.setCaretColor(Color.WHITE);
		textField_5.setBounds(264, 229, 352, 56);
		pnlAdd.add(textField_5);
		
		JLabel label = new JLabel("ENTER AMOUNT");
		label.setForeground(Color.YELLOW);
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(264, 200, 352, 16);
		pnlAdd.add(label);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(textField_5.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "EMPTY AMOUNT");
				}
				else if(textField_5.getText().contains("-"))
				{
					JOptionPane.showMessageDialog(null, "NEGATIVE  AMOUNT");
				}
				else {
				try 
				{
					double amount=Double.parseDouble(textField_5.getText());
					double balance=0.0;
					try
					{
						ResultSet rst = MyDataBase.getConn().createStatement().executeQuery("select ubalance from accountholders where bname='"+CurrentUser.getBankname()+"' and uaccno='"+CurrentUser.getAccno()+"'");
						if(rst.next())
						{
							balance=rst.getDouble(1);
						}
					} 
					catch (SQLException e1) 
					{
						JOptionPane.showMessageDialog(pnlSend, e1);
					}
					MyDataBase.updateBalance(CurrentUser.getAccno(), balance+amount, CurrentUser.getBankname());
					 MyDataBase.addTransactions(CurrentUser.getAccno(), CurrentUser.getAccno(), CurrentUser.getBankname(), CurrentUser.getBankname(), amount, "DEPOSIT");
					 JOptionPane.showMessageDialog(null, "MONEY HAS BEEN DEPOSITED SUCCESSFULLY");
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(pnlAdd, "MONEY CAN NOT BE NEGATIVE");
				}
				
			}
			}
		});
		btnNewButton.setForeground(Color.YELLOW);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.setBounds(383, 530, 146, 56);
		pnlAdd.add(btnNewButton);
		
		pnlWithdraw = new JPanel();
		pnlWithdraw.setBackground(Color.BLACK);
		panel_2.add(pnlWithdraw, "WITHDRAW");
		pnlWithdraw.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0), 5), "WITHDRAW MONEY", TitledBorder.CENTER, TitledBorder.BELOW_TOP, new Font("Tahoma",Font.BOLD,50),Color.RED));
		pnlWithdraw.setLayout(null);
		
		textField_6 = new JTextField();
		textField_6.setOpaque(false);
		textField_6.setForeground(Color.WHITE);
		textField_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_6.setColumns(10);
		textField_6.setCaretColor(Color.WHITE);
		textField_6.setBounds(272, 175, 352, 56);
		pnlWithdraw.add(textField_6);
		
		JLabel label_2 = new JLabel("ENTER AMOUNT");
		label_2.setForeground(Color.YELLOW);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_2.setBounds(272, 146, 352, 16);
		pnlWithdraw.add(label_2);
		
		JButton btnWithdraw = new JButton("WITHDRAW");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(textField_6.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "EMPTY AMOUNT");
				}
				else if(textField_6.getText().contains("-"))
				{
					JOptionPane.showMessageDialog(null, "NEGATIVE  AMOUNT");
				}
				else {
				try 
				{
					double amount=Double.parseDouble(textField_6.getText());
					double balance=0.0;
					try
					{
						ResultSet rst = MyDataBase.getConn().createStatement().executeQuery("select ubalance from accountholders where bname='"+CurrentUser.getBankname()+"' and uaccno='"+CurrentUser.getAccno()+"'");
						if(rst.next())
						{
							balance=rst.getDouble(1);
						}
					} 
					catch (SQLException e1) 
					{
						JOptionPane.showMessageDialog(pnlSend, e1);
					}
					if(balance > amount)
					{
					    MyDataBase.updateBalance(CurrentUser.getAccno(), balance-amount, CurrentUser.getBankname());
					    MyDataBase.addTransactions(CurrentUser.getAccno(), CurrentUser.getAccno(), CurrentUser.getBankname(), CurrentUser.getBankname(), amount, "WITHDRAW");
					    JOptionPane.showMessageDialog(null, "MONEY WITHDRAWL SUCCESSFULLY");
					}
					else
					{
						JOptionPane.showMessageDialog(pnlAdd, "LOW BALANCE !!!");
					}
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(pnlAdd, "MONEY CAN NOT BE STRING");
				}
			}
			}
		});
		btnWithdraw.setForeground(Color.YELLOW);
		btnWithdraw.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnWithdraw.setBackground(Color.BLACK);
		btnWithdraw.setBounds(337, 452, 196, 56);
		pnlWithdraw.add(btnWithdraw);
		
		pnlTransactions = new JPanel();
		pnlTransactions.setBackground(Color.BLACK);
		panel_2.add(pnlTransactions, "TRANSACTIONS");
		pnlTransactions.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0), 5), "TRANSACTIONS", TitledBorder.CENTER, TitledBorder.BELOW_TOP, new Font("Tahoma",Font.BOLD,50),Color.RED));
		pnlTransactions.setLayout(null);
		
		js=new JScrollPane();
		js.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		js.setBounds(53, 90, 977, 703);
		js.setVisible(true);
		pnlTransactions.add(js);
		
		tableTransaction=new JTable();
		tableTransaction.setForeground(Color.WHITE);
		tableTransaction.setFont(new Font("Tahoma", Font.BOLD, 25));
		tableTransaction.setBackground(Color.BLACK);
		tableTransaction.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableTransaction.setRowHeight(70);
		tableTransaction.setEnabled(false);
		js.setViewportView(tableTransaction);
		
		pnlUpdate = new JPanel();
		pnlUpdate.setBackground(Color.BLACK);
		panel_2.add(pnlUpdate, "UPDATE");
		pnlUpdate.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0), 5), "UPDATE", TitledBorder.CENTER, TitledBorder.BELOW_TOP, new Font("Tahoma",Font.BOLD,50),Color.RED));
		pnlUpdate.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("NAME");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(229, 241, 213, 68);
		pnlUpdate.add(lblNewLabel_1);
		
		txtUpdateName = new JTextField();
		txtUpdateName.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtUpdateName.setCaretColor(Color.WHITE);
		txtUpdateName.setForeground(Color.WHITE);
		txtUpdateName.setEditable(false);
		txtUpdateName.setOpaque(false);
		txtUpdateName.setBounds(454, 241, 423, 68);
		pnlUpdate.add(txtUpdateName);
		txtUpdateName.setColumns(10);
		
		JLabel lblPhone = new JLabel("PHONE");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPhone.setForeground(Color.YELLOW);
		lblPhone.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPhone.setBounds(229, 377, 213, 68);
		pnlUpdate.add(lblPhone);
		
		txtUpdatePhone = new JTextField();
		txtUpdatePhone.setCaretColor(Color.WHITE);
		txtUpdatePhone.setBackground(Color.BLACK);
		txtUpdatePhone.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtUpdatePhone.setForeground(Color.WHITE);
		txtUpdatePhone.setEditable(false);
		txtUpdatePhone.setOpaque(false);
		txtUpdatePhone.setColumns(10);
		txtUpdatePhone.setBounds(454, 377, 423, 68);
		pnlUpdate.add(txtUpdatePhone);
		
		JButton btnEdit = new JButton("EDIT");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtUpdateName.setEditable(true);
				txtUpdatePhone.setEditable(true);
				
				
			}
		});
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnEdit.setIcon(new ImageIcon("src//edit.png"));
		btnEdit.setForeground(new Color(100, 149, 237));
		btnEdit.setBackground(Color.ORANGE);
		btnEdit.setBounds(434, 543, 143, 54);
		pnlUpdate.add(btnEdit);
		
		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUpdateName.setEditable(false);
				txtUpdatePhone.setEditable(false);
				double cp = 0,balance = 0;
				String cn = null;
				try {
				ResultSet rnp = MyDataBase.getConn().createStatement().executeQuery("select uname , uphone, ubalance from accountholders where bname='"+CurrentUser.getBankname()+"' and uaccno='"+CurrentUser.getAccno()+"'");
				if(rnp.next())
				{
					cp = rnp.getDouble(2);
					cn=rnp.getString(1);
					balance=rnp.getDouble(3);
				}}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, e);
				}
				if(txtUpdateName.getText().isEmpty() && txtUpdatePhone.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "EMPTY FIELDS");
				}
				else if(txtUpdateName.getText().isEmpty())
				{
					try {
					PreparedStatement pst=(PreparedStatement) MyDataBase.getConn().prepareStatement("insert into requests values(?,?,?,?,?,?)");
					pst.setString(1, "TO CHANGE PHONE NUMBER");
					pst.setString(2, cn);
					pst.setDouble(3, Double.parseDouble(txtUpdatePhone.getText().toString()));
					pst.setString(4, CurrentUser.getId());
					pst.setString(5, CurrentUser.getBankname());
					pst.setDouble(6,balance);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "REQUEST HAS BEEN SENT ON ADMIN SIDE");
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null, e);
					}
				}
				else if(txtUpdatePhone.getText().isEmpty())
				{ try {
					PreparedStatement pst=(PreparedStatement) MyDataBase.getConn().prepareStatement("insert into requests values(?,?,?,?,?,?)");
					pst.setString(1, "TO CHANGE NAME");
					pst.setString(2, txtUpdateName.getText());
					pst.setDouble(3, cp);
					pst.setString(4, CurrentUser.getId());
					pst.setString(5, CurrentUser.getBankname());
					pst.setDouble(6,balance);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "REQUEST HAS BEEN SENT ON ADMIN SIDE");
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, e);
				}
				}
				else
				{
				try {
				double p=Double.parseDouble(txtUpdatePhone.getText().toString());
				String name=txtUpdateName.getText().toString();
				
					if(cp!=p && !cn.equals(txtUpdateName.getText()))
					{
						PreparedStatement pst=(PreparedStatement) MyDataBase.getConn().prepareStatement("insert into requests values(?,?,?,?,?,?)");
						pst.setString(1, "TO CHANGE BOTH");
						pst.setString(2, name);
						pst.setDouble(3, p);
						pst.setString(4, CurrentUser.getId());
						pst.setString(5, CurrentUser.getBankname());
						pst.setDouble(6,balance);
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "REQUEST HAS BEEN SENT ON ADMIN SIDE");
					}
					else if(cp!=p)
					{
						PreparedStatement pst=(PreparedStatement) MyDataBase.getConn().prepareStatement("insert into requests values(?,?,?,?,?,?)");
						pst.setString(1, "TO CHANGE PHONE NUMBER");
						pst.setString(2, cn);
						pst.setDouble(3, p);
						pst.setString(4, CurrentUser.getId());
						pst.setString(5, CurrentUser.getBankname());
						pst.setDouble(6,balance);
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "REQUEST HAS BEEN SENT ON ADMIN SIDE");
					}
					else if(!cn.equals(txtUpdateName.getText()))
					{
						PreparedStatement pst=(PreparedStatement) MyDataBase.getConn().prepareStatement("insert into requests values(?,?,?,?,?,?)");
						pst.setString(1, "TO CHANGE NAME");
						pst.setString(2, name);
						pst.setDouble(3, cp);
						pst.setString(4, CurrentUser.getId());
						pst.setString(5, CurrentUser.getBankname());
						pst.setDouble(6,balance);
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "REQUEST HAS BEEN SENT ON ADMIN SIDE");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "NO CHANGE");
					}
				}
				catch(Exception exception)
				{
					JOptionPane.showMessageDialog(null, "PHONE NUMBER CAN NOT BE STRING");
				}
				}	
			}
		});
		btnOk.setBackground(Color.ORANGE);
		btnOk.setIcon(new ImageIcon("src//ok-16.png"));
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnOk.setForeground(new Color(100, 149, 237));
		btnOk.setBounds(717, 543, 143, 54);
		pnlUpdate.add(btnOk);
		
		pnlNotifications = new JPanel();
		pnlNotifications.setBackground(Color.BLACK);
		panel_2.add(pnlNotifications, "NOTIFICATIONS");
		pnlNotifications.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0), 5), "NOTIFICATIONS", TitledBorder.CENTER, TitledBorder.BELOW_TOP, new Font("Tahoma",Font.BOLD,50),Color.RED));
		pnlNotifications.setLayout(null);
		
		scrollnotify=new JScrollPane();
		scrollnotify.setBounds(239, 94, 552, 708);
		pnlNotifications.add(scrollnotify);
		
		nTable=new JTable();
		nTable.setEnabled(false);
		nTable.setFont(new Font("Tahoma", Font.BOLD, 25));
		nTable.setBackground(Color.BLACK);
		nTable.setForeground(Color.WHITE);
		nTable.setRowHeight(70);
		scrollnotify.setViewportView(nTable);
		
		pnlLogOut = new JPanel();
		pnlLogOut.setBackground(Color.BLACK);
		panel_2.add(pnlLogOut, "LOG OUT");
		pnlLogOut.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0), 5), "LOG OUT", TitledBorder.CENTER, TitledBorder.BELOW_TOP, new Font("Tahoma",Font.BOLD,50),Color.RED));
		pnlLogOut.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_1.setOpaque(false);
		textField_1.setColumns(10);
		textField_1.setCaretColor(Color.WHITE);
		textField_1.setBounds(351, 383, 307, 56);
		pnlSend.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		
		
		textField_2.setOpaque(false);
		textField_2.setColumns(10);
		textField_2.setCaretColor(Color.WHITE);
		textField_2.setBounds(351, 526, 307, 56);
		pnlSend.add(textField_2);
		
		textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField.setOpaque(false);
		textField.setColumns(10);
		textField.setCaretColor(Color.WHITE);
		textField.setBounds(351, 243, 307, 56);
		pnlSend.add(textField);
		
		lblNewLabel = new JLabel("ENTER BANK NAME");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setBounds(351, 214, 307, 16);
		pnlSend.add(lblNewLabel);
		
		lblEnterAccountNumber = new JLabel("ENTER ACCOUNT NUMBER");
		lblEnterAccountNumber.setForeground(Color.YELLOW);
		lblEnterAccountNumber.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEnterAccountNumber.setBounds(351, 354, 307, 16);
		pnlSend.add(lblEnterAccountNumber);
		
		lblEnterAmount = new JLabel("ENTER AMOUNT");
		lblEnterAmount.setForeground(Color.YELLOW);
		lblEnterAmount.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEnterAmount.setBounds(351, 497, 307, 16);
		pnlSend.add(lblEnterAmount);
		
		btnSend = new JButton("SEND");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				
				if(textField.getText().isEmpty()||textField_1.getText().isEmpty()||textField_2.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(pnlSend, "EMPTY FIELDS");
				}
				else if(textField_2.getText().contains("-"))
				{
					JOptionPane.showMessageDialog(null, "NEGATIVE  AMOUNT");
				}
				else
				{
				
				String rb=textField.getText();
				String ra=textField_1.getText();
				double mny=0.0;
				try
				{
					mny=Double.parseDouble(textField_2.getText());
					double balance =0.0;
					ResultSet rs2;
					try
					{
						rs2 = MyDataBase.getConn().createStatement().executeQuery("select ubalance from accountholders where bname='"+CurrentUser.getBankname()+"' and uaccno='"+CurrentUser.getAccno()+"'");
						if(rs2.next())
						{
							balance=rs2.getDouble(1);
						}
					} 
					catch (SQLException e1) 
					{
						JOptionPane.showMessageDialog(pnlSend, e1);
					}
					try
					 {
						ResultSet rs = MyDataBase.getConn().createStatement().executeQuery("select uaccno,ubalance from accountholders where bname='"+rb+"' and uaccno='"+ra+"'");
						if(rs.next())
						{
							if(rb.equals(CurrentUser.getBankname()))
							{
								if(balance>=mny)
								{
									MyDataBase.updateBalance(rs.getString(1),rs.getDouble(2)+mny,rb);
									MyDataBase.updateBalance(CurrentUser.getAccno(),balance-mny,rb);
									MyDataBase.addTransactions(CurrentUser.getAccno(),rs.getString(1),rb,rb,mny,"TRANSFER");
									JOptionPane.showMessageDialog(pnlSend,"MONEY HAS TRANSFERRED TO RECEIVER SUCCESSFULLY");
								}
								else
								{
									JOptionPane.showMessageDialog(pnlSend,"LOW BALANCE");
								}
							}
							else
							{
								if(balance>=mny+0.04*mny)
								{
									MyDataBase.updateBalance(rs.getString(1),rs.getDouble(2)+mny,rb);
									MyDataBase.updateBalance(CurrentUser.getAccno(),balance-mny-0.04*mny,CurrentUser.getBankname());
									MyDataBase.addTransactions(CurrentUser.getAccno(),rs.getString(1),CurrentUser.getBankname(),rb,mny,"TRANSFER");
									JOptionPane.showMessageDialog(pnlSend,"MONEY HAS TRANSFERRED TO RECEIVER SUCCESSFULLY");
								}
								else
								{
									JOptionPane.showMessageDialog(pnlSend,"LOW BALANCE");
								}
							}
						}
						else
						{
							JOptionPane.showMessageDialog(pnlSend,"INVALID DETAILS OF THE RECEIVER");
						}
					 } 
					 catch (SQLException e)
					 {
						JOptionPane.showMessageDialog(null, e);
					 }
				}
				catch(Exception e2)
				{
					JOptionPane.showMessageDialog(pnlSend, "MONEY CAN NOT BE STRING");
					
				}	
				}
			}
		});
		btnSend.setForeground(Color.YELLOW);
		btnSend.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnSend.setBackground(Color.BLACK);
		btnSend.setBounds(423, 693, 146, 56);
		pnlSend.add(btnSend);
		
		pnlUserDetails = new JPanel();
		pnlUserDetails.setLayout(null);
		pnlUserDetails.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0), 5), "USER DETAILS", TitledBorder.CENTER, TitledBorder.BELOW_TOP, new Font("Tahoma",Font.BOLD,50),Color.RED));
		pnlUserDetails.setBackground(Color.BLACK);
		panel_2.add(pnlUserDetails, "USER DETAILS");
		
		label_4 = new JLabel("NAME");
		label_4.setHorizontalAlignment(SwingConstants.TRAILING);
		label_4.setForeground(Color.YELLOW);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_4.setBounds(339, 159, 94, 50);
		pnlUserDetails.add(label_4);
		
		textField_8 = new JTextField();
		textField_8.setForeground(Color.WHITE);
		textField_8.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_8.setEditable(false);
		textField_8.setOpaque(false);
		textField_8.setColumns(10);
		textField_8.setBounds(441, 159, 325, 50);
		pnlUserDetails.add(textField_8);
		
		lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.TRAILING);
		lblId.setForeground(Color.YELLOW);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblId.setBounds(339, 254, 94, 50);
		pnlUserDetails.add(lblId);
		
		textField_9 = new JTextField();
		textField_9.setForeground(Color.WHITE);
		textField_9.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_9.setEditable(false);
		textField_9.setOpaque(false);
		textField_9.setColumns(10);
		textField_9.setBounds(441, 254, 325, 50);
		pnlUserDetails.add(textField_9);
		
		lblMobileNumber = new JLabel("MOBILE NUMBER");
		lblMobileNumber.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMobileNumber.setForeground(Color.YELLOW);
		lblMobileNumber.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblMobileNumber.setBounds(180, 352, 253, 50);
		pnlUserDetails.add(lblMobileNumber);
		
		textField_10 = new JTextField();
		textField_10.setForeground(Color.WHITE);
		textField_10.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_10.setEditable(false);
		textField_10.setOpaque(false);
		textField_10.setColumns(10);
		textField_10.setBounds(441, 352, 325, 50);
		pnlUserDetails.add(textField_10);
		
		lblAccountNumber = new JLabel("ACCOUNT NUMBER");
		lblAccountNumber.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAccountNumber.setForeground(Color.YELLOW);
		lblAccountNumber.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAccountNumber.setBounds(180, 442, 253, 50);
		pnlUserDetails.add(lblAccountNumber);
		
		textField_11 = new JTextField();
		textField_11.setForeground(Color.WHITE);
		textField_11.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_11.setEditable(false);
		textField_11.setOpaque(false);
		textField_11.setColumns(10);
		textField_11.setBounds(441, 442, 325, 50);
		pnlUserDetails.add(textField_11);
		
		lblBalance = new JLabel("BALANCE");
		lblBalance.setHorizontalAlignment(SwingConstants.TRAILING);
		lblBalance.setForeground(Color.YELLOW);
		lblBalance.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblBalance.setBounds(264, 537, 169, 50);
		pnlUserDetails.add(lblBalance);
		
		textField_12 = new JTextField();
		textField_12.setForeground(Color.WHITE);
		textField_12.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_12.setEditable(false);
		textField_12.setOpaque(false);
		textField_12.setColumns(10);
		textField_12.setBounds(441, 537, 325, 50);
		pnlUserDetails.add(textField_12);
		
		lblBankName = new JLabel("BANK NAME");
		lblBankName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblBankName.setForeground(Color.YELLOW);
		lblBankName.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblBankName.setBounds(264, 635, 169, 50);
		pnlUserDetails.add(lblBankName);
		
		textField_13 = new JTextField();
		textField_13.setForeground(Color.WHITE);
		textField_13.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_13.setEditable(false);
		textField_13.setOpaque(false);
		textField_13.setColumns(10);
		textField_13.setBounds(441, 635, 325, 50);
		pnlUserDetails.add(textField_13);
		
		lblPassword = new JLabel("PASSWORD");
		lblPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPassword.setForeground(Color.YELLOW);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPassword.setBounds(264, 724, 169, 50);
		pnlUserDetails.add(lblPassword);
		
		textField_14 = new JPasswordField();
		textField_14.setForeground(Color.WHITE);
		textField_14.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_14.setEditable(false);
		textField_14.setOpaque(false);
		textField_14.setEchoChar('*');
		textField_14.setText("mmcuhru");
		textField_14.setColumns(10);
		textField_14.setBounds(441, 724, 325, 50);
		pnlUserDetails.add(textField_14);
		
		btnNewButton_1 = new JButton("SHOW");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField_14.getEchoChar()=='*')
				{
					textField_14.setEchoChar((char)0);
					btnNewButton_1.setText("HIDE");
				}
				else
				{
					textField_14.setEchoChar('*');
					btnNewButton_1.setText("SHOW");
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setForeground(Color.YELLOW);
		btnNewButton_1.setBounds(841, 735, 116, 33);
		pnlUserDetails.add(btnNewButton_1);
		
		btnUserDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(panel_2, "USER DETAILS");
				
				try 
				{
					ResultSet rs2 = MyDataBase.getConn().createStatement().executeQuery("select * from accountholders where bname='"+CurrentUser.getBankname()+"' and uaccno='"+CurrentUser.getAccno()+"' and uid='"+CurrentUser.getId()+"' and upassword='"+CurrentUser.getPassword()+"'");
					if(rs2.next())
					{
						textField_8.setText(rs2.getString(1));
						textField_9.setText(rs2.getString(2));
						textField_10.setText(String.valueOf(rs2.getDouble(4)));
						textField_11.setText(CurrentUser.getAccno());
						textField_12.setText(String.valueOf(rs2.getDouble(5)));
						textField_13.setText(CurrentUser.getBankname());
						textField_14.setText(CurrentUser.getPassword());
					}
				} 
				catch (SQLException e) 
				{
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		
		btnSendMoney.addMouseListener(this);
		btnAddMoney.addMouseListener(this);
		btnWithdrawMoney.addMouseListener(this);
		btnTransactions.addMouseListener(this);
		btnUpdate.addMouseListener(this);
		btnNotifications.addMouseListener(this);
		btnLogOut.addMouseListener(this);
		btnUserDetails.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent event) {
		
		((JButton) event.getSource()).setBackground(Color.BLACK);
		
	}

	@Override
	public void mouseExited(MouseEvent event) {
		// TODO Auto-generated method stub
		((JButton) event.getSource()).setBackground(Color.DARK_GRAY);
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
