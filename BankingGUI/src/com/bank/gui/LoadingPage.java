package com.bank.gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.Font;

public class LoadingPage extends JFrame implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JProgressBar progressBar;
	boolean isAdmin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoadingPage frame = new LoadingPage(true);
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
	public LoadingPage(boolean b) {
		this.isAdmin=b;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 625);
		this.setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		//panel.setBackground(Color.BLACK);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 255, 0), 5), "LOADING", TitledBorder.CENTER, TitledBorder.TOP, new Font("TAHOMA",Font.BOLD,50), Color.BLACK));
		panel.setBounds(0, 0, 506, 625);
		contentPane.add(panel);
		panel.setLayout(null);
		
		progressBar = new JProgressBar();
		progressBar.setFont(new Font("Tahoma", Font.BOLD, 25));
		progressBar.setBounds(71, 229, 373, 60);
		panel.add(progressBar);
		progressBar.setStringPainted(true);
		progressBar.setValue(0);
		progressBar.setBackground(Color.WHITE);
		progressBar.setForeground(Color.RED);
		
		JLabel lblLoading = new JLabel("");
		lblLoading.setBounds(158, 336, 191, 119);
		panel.add(lblLoading);
		lblLoading.setBackground(Color.YELLOW);
		lblLoading.setIcon(new ImageIcon("src//loading (1).gif"));
		
		JLabel lblNewLabel_1 = new JLabel(" PLEASE WAIT.....");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(82, 83, 362, 89);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("LOGGING IN ......");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel_2.setBounds(82, 495, 362, 55);
		panel.add(lblNewLabel_2);
		
		Thread T=new Thread(this);
		T.start();
		
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1;i<=100;i++)
		{
			progressBar.setValue(i);
			try 
			{
				
				
					Thread.sleep(50);
				
			} catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
//		dispose();
		
		if(this.isAdmin)
		{
			JOptionPane.showMessageDialog(this.contentPane,"ADMIN LOGGED IN SUCCESSFULLY");
			new AdminPage().setVisible(true);
			dispose();
		}
		else
		{
			JOptionPane.showMessageDialog(this.contentPane,"USER LOGGED IN SUCCESSFULLY");
			new UserPage().setVisible(true);
			dispose();
		}
		
		
	}
}
