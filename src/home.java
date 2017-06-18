import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;

import org.jpl7.*;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.Map;
import java.awt.event.ActionEvent;

public class home {

	private JFrame frame;
	static int C1;
	static int C2;
	static Term board;
	static Term B;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home window = new home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 341);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Beginner");
		rdbtnNewRadioButton.setBounds(31, 73, 109, 23);
		rdbtnNewRadioButton.setSelected(true);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Expert");
		rdbtnNewRadioButton_1.setBounds(31, 130, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Easy");
		rdbtnNewRadioButton_2.setSelected(true);
		rdbtnNewRadioButton_2.setBounds(249, 73, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Medium");
		rdbtnNewRadioButton_3.setBounds(249, 130, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Hard");
		rdbtnNewRadioButton_4.setBounds(249, 179, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_4);
		
		
		ButtonGroup group1 = new ButtonGroup();
		 group1.add(rdbtnNewRadioButton);
		 group1.add(rdbtnNewRadioButton_1);
		 
		ButtonGroup group2 = new ButtonGroup();
		 group2.add(rdbtnNewRadioButton_2);
		 group2.add(rdbtnNewRadioButton_3);
		 group2.add(rdbtnNewRadioButton_4);
		 
		
		JButton btnNewButton = new JButton("Play");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String s="consult('Project.pl')";
				Query q1 =new Query(s);
				System.out.println(q1.hasSolution());
				if (rdbtnNewRadioButton_2.isSelected())
				{
					C2=1;
				}
				else if(rdbtnNewRadioButton_3.isSelected())
				{
					C2=3;
				}
				else if(rdbtnNewRadioButton_4.isSelected())
				{
					C2=5;
				}
				if (rdbtnNewRadioButton.isSelected())
				{
					C1=1;
					s="run(1,1,A)";
					Query q2=new Query(s);
					
					board=q2.oneSolution().get("A");
					
					
					
					//Map<String, Term >[] ss4 = q2.;
					//board=q2.nextElement();
//					q2.allSolutions("A",board);
//					s="test(B,H)";
//					Query q3=new Query(s);
//					q3.open();
//					System.out.println(q3.getSolution().get("H"));
//					System.out.println(board);
				//	for(int i=0;i<ss4.length;i++)
					//{
						//System.out.println(ss4[i].get("S"));
					//}
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								board1 window = new board1();
								window.N=2;
								window.DEPTH=C2;
								window.BOARD=board;
								window.frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
				else if(rdbtnNewRadioButton_1.isSelected())
				{
					C1=2;
					s="run("+C1+",1,A)";
					Query q2=new Query(s);
					board=q2.oneSolution().get("A");
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								board2 window = new board2();
								window.N=5;
								window.DEPTH=C2;
								window.board=board;
								window.frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
				
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(112, 233, 174, 47);
		frame.getContentPane().add(btnNewButton);
	}
}
