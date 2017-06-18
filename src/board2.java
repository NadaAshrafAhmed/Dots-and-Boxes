import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.jpl7.Term;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class board2 {

	public JFrame frame;
	static int N;
	static int DEPTH;
	static Term board;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					board2 window = new board1();
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
	public board2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 644, 569);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("4-5");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(51, 117, 90, 13);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("2-3");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(151, 35, 90, 13);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_6 = new JButton("1-2");
		btnNewButton_6.setBounds(51, 35, 90, 13);
		frame.getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("5-6");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_7.setBounds(151, 117, 90, 13);
		frame.getContentPane().add(btnNewButton_7);
		
		JButton btnNewButton_3 = new JButton("4-7");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(39, 123, 13, 90);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_8 = new JButton("6-9");
		btnNewButton_8.setBounds(239, 123, 13, 90);
		frame.getContentPane().add(btnNewButton_8);
		
		JButton btnNewButton_11 = new JButton("2-5");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_11.setBounds(141, 35, 13, 90);
		frame.getContentPane().add(btnNewButton_11);
		
		JButton btnNewButton_9 = new JButton("3-6");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_9.setBounds(239, 35, 13, 90);
		frame.getContentPane().add(btnNewButton_9);
		
		JButton btnNewButton_4 = new JButton("1-4");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(39, 35, 13, 90);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("5-8");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_5.setBounds(141, 123, 13, 90);
		frame.getContentPane().add(btnNewButton_5);
		
		JLabel lblNewLabel = new JLabel("1-2-5-4");
		lblNewLabel.setBounds(51, 48, 90, 68);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("2-3-6-5");
		lblNewLabel_1.setBounds(151, 48, 90, 68);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("4-5-8-7");
		lblNewLabel_2.setBounds(51, 130, 90, 70);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("5-6-9-8");
		lblNewLabel_3.setBounds(151, 130, 90, 70);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton button = new JButton("4-5");
		button.setBounds(51, 208, 90, 13);
		frame.getContentPane().add(button);
		
		JButton button_4 = new JButton("5-6");
		button_4.setBounds(151, 208, 90, 13);
		frame.getContentPane().add(button_4);
		
		JButton button_6 = new JButton("4-7");
		button_6.setBounds(39, 299, 13, 90);
		frame.getContentPane().add(button_6);
		
		JButton button_7 = new JButton("6-9");
		button_7.setBounds(239, 299, 13, 90);
		frame.getContentPane().add(button_7);
		
		JButton button_8 = new JButton("2-5");
		button_8.setBounds(141, 211, 13, 90);
		frame.getContentPane().add(button_8);
		
		JButton button_9 = new JButton("3-6");
		button_9.setBounds(239, 211, 13, 90);
		frame.getContentPane().add(button_9);
		
		JButton button_10 = new JButton("1-4");
		button_10.setBounds(39, 211, 13, 90);
		frame.getContentPane().add(button_10);
		
		JButton button_11 = new JButton("5-8");
		button_11.setBounds(141, 299, 13, 90);
		frame.getContentPane().add(button_11);
		
		JLabel label = new JLabel("1-2-5-4");
		label.setBounds(51, 223, 90, 68);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("2-3-6-5");
		label_1.setBounds(151, 223, 90, 68);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("4-5-8-7");
		label_2.setBounds(51, 305, 90, 70);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("5-6-9-8");
		label_3.setBounds(151, 305, 90, 70);
		frame.getContentPane().add(label_3);
		
		JButton button_14 = new JButton("2-5");
		button_14.setBounds(341, 211, 13, 90);
		frame.getContentPane().add(button_14);
		
		JButton button_15 = new JButton("4-5");
		button_15.setBounds(251, 208, 90, 13);
		frame.getContentPane().add(button_15);
		
		JButton button_16 = new JButton("5-6");
		button_16.setBounds(351, 208, 90, 13);
		frame.getContentPane().add(button_16);
		
		JButton button_17 = new JButton("3-6");
		button_17.setBounds(439, 211, 13, 90);
		frame.getContentPane().add(button_17);
		
		JButton button_18 = new JButton("6-9");
		button_18.setBounds(439, 299, 13, 90);
		frame.getContentPane().add(button_18);
		
		JButton button_20 = new JButton("5-8");
		button_20.setBounds(341, 299, 13, 90);
		frame.getContentPane().add(button_20);
		
		JButton button_23 = new JButton("2-5");
		button_23.setBounds(541, 211, 13, 90);
		frame.getContentPane().add(button_23);
		
		JButton button_24 = new JButton("4-5");
		button_24.setBounds(451, 293, 90, 13);
		frame.getContentPane().add(button_24);
		
		JButton button_25 = new JButton("5-8");
		button_25.setBounds(541, 299, 13, 90);
		frame.getContentPane().add(button_25);
		
		JLabel label_4 = new JLabel("1-2-5-4");
		label_4.setBounds(249, 223, 90, 68);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("2-3-6-5");
		label_5.setBounds(349, 223, 90, 68);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("4-5-8-7");
		label_6.setBounds(249, 305, 90, 70);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("5-6-9-8");
		label_7.setBounds(349, 305, 90, 70);
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("1-2-5-4");
		label_8.setBounds(451, 223, 90, 68);
		frame.getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("4-5-8-7");
		label_9.setBounds(451, 305, 90, 70);
		frame.getContentPane().add(label_9);
		
		JButton button_27 = new JButton("4-5");
		button_27.setBounds(51, 382, 90, 13);
		frame.getContentPane().add(button_27);
		
		JButton button_30 = new JButton("8-9");
		button_30.setBounds(151, 465, 90, 13);
		frame.getContentPane().add(button_30);
		
		JButton button_31 = new JButton("5-6");
		button_31.setBounds(151, 382, 90, 13);
		frame.getContentPane().add(button_31);
		
		JButton button_32 = new JButton("7-8");
		button_32.setBounds(51, 465, 90, 13);
		frame.getContentPane().add(button_32);
		
		JButton button_33 = new JButton("4-7");
		button_33.setBounds(39, 388, 13, 90);
		frame.getContentPane().add(button_33);
		
		JButton button_34 = new JButton("6-9");
		button_34.setBounds(239, 388, 13, 90);
		frame.getContentPane().add(button_34);
		
		JButton button_38 = new JButton("5-8");
		button_38.setBounds(141, 388, 13, 90);
		frame.getContentPane().add(button_38);
		
		JLabel label_12 = new JLabel("4-5-8-7");
		label_12.setBounds(51, 394, 90, 70);
		frame.getContentPane().add(label_12);
		
		JLabel label_13 = new JLabel("5-6-9-8");
		label_13.setBounds(151, 394, 90, 70);
		frame.getContentPane().add(label_13);
		
		JButton button_42 = new JButton("4-5");
		button_42.setBounds(251, 382, 90, 13);
		frame.getContentPane().add(button_42);
		
		JButton button_43 = new JButton("5-6");
		button_43.setBounds(351, 382, 90, 13);
		frame.getContentPane().add(button_43);
		
		JButton button_45 = new JButton("6-9");
		button_45.setBounds(439, 388, 13, 90);
		frame.getContentPane().add(button_45);
		
		JButton button_46 = new JButton("8-9");
		button_46.setBounds(351, 465, 90, 13);
		frame.getContentPane().add(button_46);
		
		JButton button_47 = new JButton("5-8");
		button_47.setBounds(341, 388, 13, 90);
		frame.getContentPane().add(button_47);
		
		JButton button_48 = new JButton("7-8");
		button_48.setBounds(251, 465, 90, 13);
		frame.getContentPane().add(button_48);
		
		JButton button_51 = new JButton("4-5");
		button_51.setBounds(451, 382, 90, 13);
		frame.getContentPane().add(button_51);
		
		JButton button_52 = new JButton("5-8");
		button_52.setBounds(541, 388, 13, 90);
		frame.getContentPane().add(button_52);
		
		JButton button_53 = new JButton("7-8");
		button_53.setBounds(451, 465, 90, 13);
		frame.getContentPane().add(button_53);
		
		JLabel label_16 = new JLabel("4-5-8-7");
		label_16.setBounds(249, 394, 90, 70);
		frame.getContentPane().add(label_16);
		
		JLabel label_17 = new JLabel("5-6-9-8");
		label_17.setBounds(349, 394, 90, 70);
		frame.getContentPane().add(label_17);
		
		JLabel label_19 = new JLabel("4-5-8-7");
		label_19.setBounds(451, 394, 90, 70);
		frame.getContentPane().add(label_19);
		
		JButton button_3 = new JButton("4-5");
		button_3.setBounds(251, 117, 90, 13);
		frame.getContentPane().add(button_3);
		
		JButton button_5 = new JButton("2-3");
		button_5.setBounds(351, 35, 90, 13);
		frame.getContentPane().add(button_5);
		
		JButton button_19 = new JButton("1-2");
		button_19.setBounds(251, 35, 90, 13);
		frame.getContentPane().add(button_19);
		
		JButton button_26 = new JButton("5-6");
		button_26.setBounds(351, 117, 90, 13);
		frame.getContentPane().add(button_26);
		
		JButton button_35 = new JButton("6-9");
		button_35.setBounds(439, 123, 13, 90);
		frame.getContentPane().add(button_35);
		
		JButton button_36 = new JButton("2-5");
		button_36.setBounds(341, 35, 13, 90);
		frame.getContentPane().add(button_36);
		
		JButton button_37 = new JButton("3-6");
		button_37.setBounds(439, 35, 13, 90);
		frame.getContentPane().add(button_37);
		
		JButton button_40 = new JButton("5-8");
		button_40.setBounds(341, 123, 13, 90);
		frame.getContentPane().add(button_40);
		
		JLabel label_10 = new JLabel("1-2-5-4");
		label_10.setBounds(251, 47, 90, 68);
		frame.getContentPane().add(label_10);
		
		JLabel label_11 = new JLabel("2-3-6-5");
		label_11.setBounds(351, 47, 90, 68);
		frame.getContentPane().add(label_11);
		
		JLabel label_14 = new JLabel("4-5-8-7");
		label_14.setBounds(251, 129, 90, 70);
		frame.getContentPane().add(label_14);
		
		JLabel label_15 = new JLabel("5-6-9-8");
		label_15.setBounds(351, 129, 90, 70);
		frame.getContentPane().add(label_15);
		
		JButton button_41 = new JButton("1-2");
		button_41.setBounds(451, 35, 90, 13);
		frame.getContentPane().add(button_41);
		
		JButton button_49 = new JButton("2-5");
		button_49.setBounds(541, 35, 13, 90);
		frame.getContentPane().add(button_49);
		
		JButton button_50 = new JButton("4-5");
		button_50.setBounds(451, 117, 90, 13);
		frame.getContentPane().add(button_50);
		
		JButton button_58 = new JButton("5-8");
		button_58.setBounds(541, 123, 13, 90);
		frame.getContentPane().add(button_58);
		
		JLabel label_18 = new JLabel("1-2-5-4");
		label_18.setBounds(449, 47, 90, 68);
		frame.getContentPane().add(label_18);
		
		JLabel label_21 = new JLabel("4-5-8-7");
		label_21.setBounds(451, 133, 90, 70);
		frame.getContentPane().add(label_21);
		
		JButton button_1 = new JButton("4-5");
		button_1.setBounds(451, 208, 90, 13);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("5-6");
		button_2.setBounds(351, 293, 90, 13);
		frame.getContentPane().add(button_2);
		
		JButton button_12 = new JButton("4-5");
		button_12.setBounds(251, 293, 90, 13);
		frame.getContentPane().add(button_12);
		
		JButton button_13 = new JButton("5-6");
		button_13.setBounds(151, 293, 90, 13);
		frame.getContentPane().add(button_13);
		
		JButton button_21 = new JButton("4-5");
		button_21.setBounds(51, 293, 90, 13);
		frame.getContentPane().add(button_21);
	}
}
