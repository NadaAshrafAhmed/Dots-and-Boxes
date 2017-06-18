import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.jpl7.Query;
import org.jpl7.Term;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.List;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class board1 {

	public JFrame frame;
	static int N;
	static int DEPTH;
	static Term BOARD;
	int P=1;
	boolean[] arr=new boolean[12];
	JButton btnNewButton_6 = new JButton();//("1-2");
	JButton btnNewButton_1 = new JButton();//("2-3");
	JButton btnNewButton = new JButton();//("4-5");
	JButton btnNewButton_10 = new JButton();//("8-9");
	JButton btnNewButton_7 = new JButton();//("5-6");
	JButton btnNewButton_2 = new JButton();//("7-8");
	JButton btnNewButton_3 = new JButton();//("4-7");
	JButton btnNewButton_8 = new JButton();//("6-9");
	JButton btnNewButton_11 = new JButton();//("2-5");
	JButton btnNewButton_9 = new JButton();//("3-6");
	JButton btnNewButton_4 = new JButton();//("1-4");
	JButton btnNewButton_5 = new JButton();//("5-8");
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					board1 window = new board1();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public board1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public void Play2()
	{
		if(P==2)
		{
			String s="alphabetamax("+BOARD+","+DEPTH+","+N+",-4,4,_,NEWS,NEWS2)";
			Query q1= new Query(s);
			Term BOARD2=BOARD;
			BOARD=q1.oneSolution().get("NEWS");
			Term ch=q1.oneSolution().get("NEWS2");
			System.out.println(BOARD);
			System.out.println(ch);
			s="is12("+ch+")";
			Query q4= new Query(s);
			if(q4.hasSolution())
			{
				btnNewButton_6.doClick();
			}
			s="is23("+ch+")";
			Query q5= new Query(s);
			if(q5.hasSolution())
			{
				btnNewButton_1.doClick();
			}
			s="is45("+ch+")";
			Query q6= new Query(s);
			if(q6.hasSolution())
			{
				btnNewButton.doClick();
			}
			s="is56("+ch+")";
			Query q7= new Query(s);
			if(q7.hasSolution())
			{
				btnNewButton_7.doClick();
			}
			s="is78("+ch+")";
			Query q8= new Query(s);
			if(q8.hasSolution())
			{
				btnNewButton_2.doClick();
			}
			s="is89("+ch+")";
			Query q9= new Query(s);
			if(q9.hasSolution())
			{
				btnNewButton_10.doClick();
			}
			s="is14("+ch+")";
			Query q10= new Query(s);
			if(q10.hasSolution())
			{
				btnNewButton_4.doClick();
			}
			s="is25("+ch+")";
			Query q11= new Query(s);
			if(q11.hasSolution())
			{
				btnNewButton_11.doClick();
			}
			s="is36("+ch+")";
			Query q12= new Query(s);
			if(q12.hasSolution())
			{
				btnNewButton_9.doClick();
			}
			s="is47("+ch+")";
			Query q13= new Query(s);
			if(q13.hasSolution())
			{
				btnNewButton_3.doClick();
			}
			s="is58("+ch+")";
			Query q14= new Query(s);
			if(q14.hasSolution())
			{
				btnNewButton_5.doClick();
			}
			s="is69("+ch+")";
			Query q15= new Query(s);
			if(q15.hasSolution())
			{
				btnNewButton_8.doClick();
			}
			s="f("+BOARD2+","+BOARD+",R)";
			Query q2= new Query(s);
			Term R =q2.oneSolution().get("R");
			s="isR("+R+")";
			Query q3= new Query(s);
			color();
			if(q3.hasSolution())
			{
				P=2;
				
				Play2();
			}
			else
			{
				P=1;
			}
			//P=1;
		}
	}
	
	public void color()
	{
		int i=0,j=0;
		String s="color("+BOARD+",0,0,P)";
		Query q1= new Query (s);
		Term P=q1.oneSolution().get("P");
		s="isPA("+P+")";
		String s2="isPB("+P+")";
		Query q2= new Query (s);
		Query q3= new Query (s2);
		//System.out.println(P);
		if(q2.hasSolution())
		{
			textField.setBackground(Color.BLUE);
			
		}
		else if (q3.hasSolution())
		{
			textField.setBackground(Color.RED);
		}
		
		i=0;
		j=1;
		s="color("+BOARD+","+i+","+j+",P)";
		 q1= new Query (s);
		 P=q1.oneSolution().get("P");
		s="isPA("+P+")";
		s2="isPB("+P+")";
		 q2= new Query (s);
		 q3= new Query (s2);
		if(q2.hasSolution())
		{
			textField_1.setBackground(Color.BLUE);
		}
		else if (q3.hasSolution())
		{
			textField_1.setBackground(Color.RED);
		}
		
		i=1;
		j=0;
		s="color("+BOARD+","+i+","+j+",P)";
		 q1= new Query (s);
		 P=q1.oneSolution().get("P");
		s="isPA("+P+")";
		s2="isPB("+P+")";
		 q2= new Query (s);
		 q3= new Query (s2);
		if(q2.hasSolution())
		{
			textField_2.setBackground(Color.BLUE);
		}
		else if (q3.hasSolution())
		{
			textField_2.setBackground(Color.RED);
		}
		
		i=1;
		j=1;
		s="color("+BOARD+","+i+","+j+",P)";
		 q1= new Query (s);
		 P=q1.oneSolution().get("P");
		s="isPA("+P+")";
		s2="isPB("+P+")";
		 q2= new Query (s);
		 q3= new Query (s2);
		if(q2.hasSolution())
		{
			textField_3.setBackground(Color.BLUE);
		}
		else if (q3.hasSolution())
		{
			textField_3.setBackground(Color.RED);
		}
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 601, 413);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(arr[0]==false)
				{
					if(P==1)
					{
						btnNewButton.setBackground(Color.BLUE);
						String s="play(4,5,'A ',"+BOARD+",NEWS,2,R)";
						Query q1=new Query(s);
						BOARD=q1.oneSolution().get("NEWS");
						Term R=q1.oneSolution().get("R");
						s="isR("+R+")";
						Query q2=new Query(s);
						if(q2.hasSolution())
						{
							P=1;
						}
						else
						{
							P=2;
							Play2();
						}
					}
					else if(P==2)
					{
						btnNewButton.setBackground(Color.RED);
					}
					arr[0]=true;
					color();
				}
			}
		});
		btnNewButton.setBounds(169, 168, 90, 13);
		frame.getContentPane().add(btnNewButton);
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(arr[1]==false)
				{
					if(P==1)
					{
						btnNewButton_1.setBackground(Color.BLUE);
						String s="play(2,3,'A ',"+BOARD+",NEWS,2,R)";
						Query q1=new Query(s);
						BOARD=q1.oneSolution().get("NEWS");
						Term R=q1.oneSolution().get("R");
						s="isR("+R+")";
						Query q2=new Query(s);
						if(q2.hasSolution())
						{
							P=1;
						}
						else
						{
							P=2;
							Play2();
						}
					}
					else if(P==2)
					{
						btnNewButton_1.setBackground(Color.RED);
					}
					arr[1]=true;
					color();
				}
			}
		});
		btnNewButton_1.setBounds(269, 86, 90, 13);
		frame.getContentPane().add(btnNewButton_1);
		
		
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(arr[6]==false)
				{
					if(P==1)
					{
						btnNewButton_6.setBackground(Color.BLUE);
//						String List="[1,2,3]";
//						System.out.println(BOARD);
////						String s2="len("+BOARD+","+"M)";
//						String s2="len([],M)";
//						Query q3= new Query(s2);
//						System.out.println(q3.hasSolution());
						
						String s="play(1,2,'A ',"+BOARD+",NEWS,2,R)";
						Query q1=new Query(s);
						BOARD=q1.oneSolution().get("NEWS");
						System.out.println(BOARD);
						Term R=q1.oneSolution().get("R");
						s="isR("+R+")";
						Query q2=new Query(s);
						if(q2.hasSolution())
						{
							P=1;
						}
						else
						{
							P=2;
							Play2();
						}
					}
					else if(P==2)
					{
						btnNewButton_6.setBackground(Color.RED);
					}
					
					arr[6]=true;
					color();
				}
			}
		});
		btnNewButton_6.setBounds(169, 86, 90, 13);
		frame.getContentPane().add(btnNewButton_6);
		
		
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(arr[10]==false)
				{
					if(P==1)
					{
						btnNewButton_10.setBackground(Color.BLUE);
						String s="play(8,9,'A ',"+BOARD+",NEWS,2,R)";
						Query q1=new Query(s);
						BOARD=q1.oneSolution().get("NEWS");
						Term R=q1.oneSolution().get("R");
						s="isR("+R+")";
						Query q2=new Query(s);
						if(q2.hasSolution())
						{
							P=1;
						}
						else
						{
							P=2;
							Play2();
						}
					}
					else if(P==2)
					{
						btnNewButton_10.setBackground(Color.RED);
					}
					arr[10]=true;
					color();
				}
			}
		});
		btnNewButton_10.setBounds(269, 251, 90, 13);
		frame.getContentPane().add(btnNewButton_10);
		
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(arr[7]==false)
				{
					if(P==1)
					{
						btnNewButton_7.setBackground(Color.BLUE);
						String s="play(5,6,'A ',"+BOARD+",NEWS,2,R)";
						Query q1=new Query(s);
						BOARD=q1.oneSolution().get("NEWS");
						Term R=q1.oneSolution().get("R");
						s="isR("+R+")";
						Query q2=new Query(s);
						if(q2.hasSolution())
						{
							P=1;
						}
						else
						{
							P=2;
							Play2();
						}
					}
					else if(P==2)
					{
						btnNewButton_7.setBackground(Color.RED);
					}
					arr[7]=true;
					color();
				}
			}
		});
		btnNewButton_7.setBounds(269, 168, 90, 13);
		frame.getContentPane().add(btnNewButton_7);
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(arr[2]==false)
				{
					if(P==1)
					{
						btnNewButton_2.setBackground(Color.BLUE);
						String s="play(7,8,'A ',"+BOARD+",NEWS,2,R)";
						Query q1=new Query(s);
						BOARD=q1.oneSolution().get("NEWS");
						Term R=q1.oneSolution().get("R");
						s="isR("+R+")";
						Query q2=new Query(s);
						if(q2.hasSolution())
						{
							P=1;
						}
						else
						{
							P=2;
							Play2();
						}
					}
					else if(P==2)
					{
						btnNewButton_2.setBackground(Color.RED);
					}
					arr[2]=true;
					color();
				}
			}
		});
		btnNewButton_2.setBounds(169, 251, 90, 13);
		frame.getContentPane().add(btnNewButton_2);
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(arr[3]==false)
				{
					if(P==1)
					{
						btnNewButton_3.setBackground(Color.BLUE);
						String s="play(4,7,'A ',"+BOARD+",NEWS,2,R)";
						Query q1=new Query(s);
						BOARD=q1.oneSolution().get("NEWS");
						Term R=q1.oneSolution().get("R");
						s="isR("+R+")";
						Query q2=new Query(s);
						if(q2.hasSolution())
						{
							P=1;
						}
						else
						{
							P=2;
							Play2();
						}
					}
					else if(P==2)
					{
						btnNewButton_3.setBackground(Color.RED);
					}
					arr[3]=true;
					color();
				}
			}
		});
		btnNewButton_3.setBounds(157, 174, 13, 90);
		frame.getContentPane().add(btnNewButton_3);
		
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(arr[8]==false)
				{
					if(P==1)
					{
						btnNewButton_8.setBackground(Color.BLUE);
						String s="play(6,9,'A ',"+BOARD+",NEWS,2,R)";
						Query q1=new Query(s);
						BOARD=q1.oneSolution().get("NEWS");
						Term R=q1.oneSolution().get("R");
						s="isR("+R+")";
						Query q2=new Query(s);
						if(q2.hasSolution())
						{
							P=1;
						}
						else
						{
							P=2;
							Play2();
						}
					}
					else if(P==2)
					{
						btnNewButton_8.setBackground(Color.RED);
					}
					arr[8]=true;
					color();
				}
			}
		});
		btnNewButton_8.setBounds(357, 174, 13, 90);
		frame.getContentPane().add(btnNewButton_8);
		
		
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(arr[11]==false)
				{
					if(P==1)
					{
						btnNewButton_11.setBackground(Color.BLUE);
						String s="play(2,5,'A ',"+BOARD+",NEWS,2,R)";
						Query q1=new Query(s);
						BOARD=q1.oneSolution().get("NEWS");
						Term R=q1.oneSolution().get("R");
						s="isR("+R+")";
						Query q2=new Query(s);
						if(q2.hasSolution())
						{
							P=1;
						}
						else
						{
							P=2;
							Play2();
						}
					}
					else if(P==2)
					{
						btnNewButton_11.setBackground(Color.RED);
					}
					arr[11]=true;
					color();
				}
			}
		});
		btnNewButton_11.setBounds(259, 86, 13, 90);
		frame.getContentPane().add(btnNewButton_11);
		
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(arr[9]==false)
				{
					if(P==1)
					{
						btnNewButton_9.setBackground(Color.BLUE);
						String s="play(3,6,'A ',"+BOARD+",NEWS,2,R)";
						Query q1=new Query(s);
						BOARD=q1.oneSolution().get("NEWS");
						Term R=q1.oneSolution().get("R");
						s="isR("+R+")";
						Query q2=new Query(s);
						if(q2.hasSolution())
						{
							P=1;
						}
						else
						{
							P=2;
							Play2();
						}
					}
					else if(P==2)
					{
						btnNewButton_9.setBackground(Color.RED);
					}
					arr[9]=true;
					color();
				}
			}
		});
		btnNewButton_9.setBounds(357, 86, 13, 90);
		frame.getContentPane().add(btnNewButton_9);
		
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(arr[4]==false)
				{
					if(P==1)
					{
						btnNewButton_4.setBackground(Color.BLUE);
						String s="play(1,4,'A ',"+BOARD+",NEWS,2,R)";
						Query q1=new Query(s);
						BOARD=q1.oneSolution().get("NEWS");
						Term R=q1.oneSolution().get("R");
						s="isR("+R+")";
						Query q2=new Query(s);
						if(q2.hasSolution())
						{
							P=1;
						}
						else
						{
							P=2;
							Play2();
						}
					}
					else if(P==2)
					{
						btnNewButton_4.setBackground(Color.RED);
					}
					arr[4]=true;
					color();
				}
			}
		});
		btnNewButton_4.setBounds(157, 86, 13, 90);
		frame.getContentPane().add(btnNewButton_4);
		
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(arr[5]==false)
				{
					if(P==1)
					{
						btnNewButton_5.setBackground(Color.BLUE);
						String s="play(5,8,'A ',"+BOARD+",NEWS,2,R)";
						Query q1=new Query(s);
						BOARD=q1.oneSolution().get("NEWS");
						Term R=q1.oneSolution().get("R");
						s="isR("+R+")";
						Query q2=new Query(s);
						if(q2.hasSolution())
						{
							P=1;
						}
						else
						{
							P=2;
							Play2();
						}
					}
					else if(P==2)
					{
						btnNewButton_5.setBackground(Color.RED);
					}
					arr[5]=true;
					color();
				}
			}
		});
		btnNewButton_5.setBounds(259, 174, 13, 90);
		frame.getContentPane().add(btnNewButton_5);
		
		textField = new JTextField();
		
		textField.setBounds(169, 96, 90, 71);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(273, 96, 86, 71);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(169, 183, 90, 71);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(273, 183, 86, 71);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
	}
}
