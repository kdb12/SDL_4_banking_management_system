package com.bank.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Image;
import javax.swing.border.TitledBorder;

import com.bank.gui.LoginPages.AdminLogin;
import com.bank.gui.LoginPages.UserLogin;

import database.MyDataBase;
import socket.GuiClient;

import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		
				try {
					MyDataBase.doConnection();
					GuiClient.setS(new Socket("localhost",5812));
					StartPage frame = new StartPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	


	/**
	 * Create the frame.
	 */
	public StartPage() {
		
    	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 587, 432);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ImageIcon ic=new ImageIcon("src//remove.png");
		Image img=ic.getImage();
		img=img.getScaledInstance(55,55, Image.SCALE_SMOOTH);
		ic=new ImageIcon(img);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int p=JOptionPane.showConfirmDialog(contentPane, "DO YOU WANT TO EXIT?","EXIT",JOptionPane.YES_NO_OPTION);
				if(p==JOptionPane.YES_OPTION)
				{
					dispose();
					try {
						GuiClient.getDout().writeInt(3);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
			}
		});
		lblNewLabel_2.setBounds(491, 13, 60, 60);
		
		lblNewLabel_2.setIcon(ic);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0), 5), "START PAGE", TitledBorder.CENTER, TitledBorder.BELOW_TOP, new Font("Tahoma",Font.BOLD,50), Color.RED));
		panel.setBounds(12, 13, 563, 406);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.add(lblNewLabel_2);
		JButton btnAdmin = new JButton("ADMIN");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
					new AdminLogin().setVisible(true);
					dispose();
				
				
			}
		});
		btnAdmin.setIcon(new ImageIcon("src//icons8-admin-settings-male-48.png"));
		btnAdmin.setBounds(141, 111, 278, 78);
		panel.add(btnAdmin);
		btnAdmin.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		btnAdmin.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnAdmin.setForeground(new Color(255, 255, 204));
		btnAdmin.setBackground(Color.BLACK);
		btnAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		
		ic=new ImageIcon("src//user.png");
		img=ic.getImage();
		img=img.getScaledInstance(55,55, Image.SCALE_SMOOTH);
		ic=new ImageIcon(img);
		JButton btnUser = new JButton("USER");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
					new UserLogin().setVisible(true);
					
				
				dispose();
			}
		});
		btnUser.setIcon(ic);
		btnUser.setBackground(Color.BLACK);
		btnUser.setBounds(141, 244, 278, 78);
		panel.add(btnUser);
		btnUser.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnUser.setForeground(new Color(255, 255, 204));
		btnUser.setHorizontalAlignment(SwingConstants.CENTER);
		btnUser.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		
		
	}
}
