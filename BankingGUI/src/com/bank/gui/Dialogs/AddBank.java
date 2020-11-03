package com.bank.gui.Dialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;

import com.bank.gui.LoginPages.AdminLogin;

import socket.GuiClient;

import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;

public class AddBank extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;
	private JTextField txtId;
	private JTextField txtAddress;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddBank dialog = new AddBank();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddBank() {
		this.setAlwaysOnTop(true);
		setUndecorated(true);
		setBounds(100, 100, 623, 506);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0), 5), "ADD BANK", TitledBorder.CENTER, TitledBorder.BELOW_TOP, new Font("Tahoma",Font.BOLD,30), Color.RED));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		contentPanel.setLayout(null);
		{
			txtName = new JTextField();
			txtName.setFont(new Font("Tahoma", Font.BOLD, 20));
			txtName.setForeground(Color.YELLOW);
			txtName.setCaretColor(Color.YELLOW);
			txtName.setOpaque(false);
			txtName.setBounds(64, 84, 450, 44);
			contentPanel.add(txtName);
			txtName.setColumns(10);
		}
		{
			txtId = new JTextField();
			txtId.setFont(new Font("Tahoma", Font.BOLD, 20));
			txtId.setCaretColor(Color.YELLOW);
			txtId.setForeground(Color.YELLOW);
			txtId.setOpaque(false);
			txtId.setBounds(64, 179, 450, 44);
			contentPanel.add(txtId);
			txtId.setColumns(10);
		}
		{
			txtAddress = new JTextField();
			txtAddress.setFont(new Font("Tahoma", Font.BOLD, 20));
			txtAddress.setCaretColor(Color.YELLOW);
			txtAddress.setForeground(Color.YELLOW);
			txtAddress.setOpaque(false);
			txtAddress.setBounds(64, 273, 450, 44);
			contentPanel.add(txtAddress);
			txtAddress.setColumns(10);
		}
		
		txtPassword = new JPasswordField();
		txtPassword.setEchoChar('*');
		txtPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtPassword.setCaretColor(Color.YELLOW);
		txtPassword.setForeground(Color.YELLOW);
		txtPassword.setOpaque(false);
		txtPassword.setBounds(64, 364, 450, 44);
		contentPanel.add(txtPassword);
		
		JLabel lblNewLabel = new JLabel("ENTER NAME");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setBounds(64, 55, 121, 16);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ENTER ID");
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setBounds(64, 152, 121, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ENTER ADDRESS");
		lblNewLabel_2.setForeground(Color.YELLOW);
		lblNewLabel_2.setBounds(64, 247, 121, 16);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ENTER PASSWORD");
		lblNewLabel_3.setForeground(Color.YELLOW);
		lblNewLabel_3.setBounds(64, 335, 121, 16);
		contentPanel.add(lblNewLabel_3);
		
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
		showPass.setForeground(Color.GREEN);
		showPass.setBounds(193, 421, 155, 25);
		contentPanel.add(showPass);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.RED);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setForeground(Color.ORANGE);
				okButton.setBackground(Color.BLUE);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						dispose();
						if(txtName.getText().isEmpty() || txtId.getText().isEmpty() || txtAddress.getText().isEmpty() || txtPassword.getText().isEmpty())
						{
							JOptionPane.showMessageDialog(null, "EMPTY FIELDS");
						}
						else
						{
							try {
								GuiClient.getDout().writeInt(0);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							HashMap<String,String> P=new HashMap<>();
							P.put("NAME",txtName.getText());
							P.put("ID", txtId.getText());
							P.put("ADDRESS", txtAddress.getText());
							P.put("PASSWORD",txtPassword.getText());
							
							try {
								GuiClient.getCout().writeObject(P);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}
					}
				});
				
				JButton btnNewButton = new JButton("CANCEL");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						dispose();
						
					}
				});
				btnNewButton.setBackground(Color.BLUE);
				btnNewButton.setForeground(Color.ORANGE);
				buttonPane.add(btnNewButton);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
