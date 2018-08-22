package projectGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import javax.swing.JCheckBox;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.Enumeration;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;

public class AreaCalculator {

	private JFrame frame;
	private JTextField firstTextField;
	private JTextField textFieldWidth;
	private JTextField textFieldHeight;
	private JTextField textFieldWidth2;
	private JTextField textFieldRadius;
	private String choice;
	private double area;
	private boolean triangleClicked = false;
	private boolean rectangleClicked = false;
	private boolean squareClicked = false;
	private boolean trapezoidClicked = false;
	private boolean parallelogramClicked = false;
	private boolean circleClicked = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AreaCalculator window = new AreaCalculator();
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
	public AreaCalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 628, 536);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		firstTextField = new JTextField();
		firstTextField.setBackground(Color.YELLOW);
		firstTextField.setEditable(false);
		firstTextField.setHorizontalAlignment(SwingConstants.CENTER);
		firstTextField.setFont(new Font("Tahoma", Font.BOLD, 18));
		firstTextField.setText("Please select ONE of the following shapes:");
		firstTextField.setBounds(0, 0, 610, 48);
		frame.getContentPane().add(firstTextField);
		firstTextField.setColumns(10);
		
		
		JButton calculateButton = new JButton("Calculate");
		calculateButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		calculateButton.setBounds(408, 360, 202, 68);
		frame.getContentPane().add(calculateButton);
		
		JLabel label = new JLabel("The area of the selelcted shape is:");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(0, 441, 308, 43);
		frame.getContentPane().add(label);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textArea.setEditable(false);
		textArea.setBounds(310, 441, 300, 35);
		frame.getContentPane().add(textArea);
		
		JLabel width1 = new JLabel("Base:");
		width1.setFont(new Font("Tahoma", Font.BOLD, 19));
		width1.setBounds(0, 236, 76, 20);
		frame.getContentPane().add(width1);
		
		textFieldWidth = new JTextField();
		textFieldWidth.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldWidth.setBounds(82, 229, 202, 40);
		frame.getContentPane().add(textFieldWidth);
		textFieldWidth.setColumns(10);
		
		JLabel height = new JLabel("Height:");
		height.setFont(new Font("Tahoma", Font.BOLD, 19));
		height.setBounds(0, 288, 76, 22);
		frame.getContentPane().add(height);
		
		textFieldHeight = new JTextField();
		textFieldHeight.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldHeight.setColumns(10);
		textFieldHeight.setBounds(82, 282, 202, 40);
		frame.getContentPane().add(textFieldHeight);
		
		JLabel width2 = new JLabel("Base 2:");
		width2.setFont(new Font("Tahoma", Font.BOLD, 19));
		width2.setBounds(0, 340, 76, 16);
		frame.getContentPane().add(width2);
		
		textFieldWidth2 = new JTextField();
		textFieldWidth2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldWidth2.setColumns(10);
		textFieldWidth2.setBounds(82, 335, 202, 40);
		frame.getContentPane().add(textFieldWidth2);
		
		JLabel radius = new JLabel("Radius:");
		radius.setFont(new Font("Tahoma", Font.BOLD, 19));
		radius.setBounds(0, 392, 76, 16);
		frame.getContentPane().add(radius);
		
		textFieldRadius = new JTextField();
		textFieldRadius.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldRadius.setColumns(10);
		textFieldRadius.setBounds(82, 388, 202, 40);
		frame.getContentPane().add(textFieldRadius);
		
		textFieldWidth.setEditable(false);
		textFieldHeight.setEditable(false);
		textFieldWidth2.setEditable(false);
		textFieldRadius.setEditable(false);
		
		JRadioButton triangleOption = new JRadioButton("Triangle");
		triangleOption.setFont(new Font("Tahoma", Font.PLAIN, 18));
		triangleOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				triangleClicked = true;
				rectangleClicked = false;
				squareClicked = false;
				trapezoidClicked = false;
				parallelogramClicked = false;
				circleClicked = false;

				textFieldWidth.setText("");
				textFieldHeight.setText("");
				textFieldWidth2.setText("");
				textFieldRadius.setText("");
				textArea.setText("");
				textFieldWidth.setEditable(true);
				textFieldHeight.setEditable(true);
				textFieldWidth2.setEditable(false);
				textFieldRadius.setEditable(false);
			}
		});
		triangleOption.setActionCommand("Triangle");
		triangleOption.setBounds(0, 46, 127, 25);
		frame.getContentPane().add(triangleOption);
		
		JRadioButton rectangleOption = new JRadioButton("Rectangle");
		rectangleOption.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rectangleOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				triangleClicked = false;
				rectangleClicked = true;
				squareClicked = false;
				trapezoidClicked = false;
				parallelogramClicked = false;
				circleClicked = false;
				
				textFieldWidth.setText("");
				textFieldHeight.setText("");
				textFieldWidth2.setText("");
				textFieldRadius.setText("");
				textArea.setText("");
				textFieldWidth.setEditable(true);
				textFieldHeight.setEditable(true);
				textFieldWidth2.setEditable(false);
				textFieldRadius.setEditable(false);
			}
		});
		rectangleOption.setActionCommand("Rectangle");
		rectangleOption.setBounds(0, 100, 127, 25);
		frame.getContentPane().add(rectangleOption);
		
		JRadioButton squareOption = new JRadioButton("Square");
		squareOption.setFont(new Font("Tahoma", Font.PLAIN, 18));
		squareOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				triangleClicked = false;
				rectangleClicked = false;
				squareClicked = true;
				trapezoidClicked = false;
				parallelogramClicked = false;
				circleClicked = false;
				
				textFieldWidth.setText("");
				textFieldHeight.setText("");
				textFieldWidth2.setText("");
				textFieldRadius.setText("");
				textArea.setText("");
				textFieldWidth.setEditable(true);
				textFieldHeight.setEditable(false);
				textFieldWidth2.setEditable(false);
				textFieldRadius.setEditable(false);
			}
		});
		squareOption.setActionCommand("Square");
		squareOption.setBounds(400, 46, 127, 25);
		frame.getContentPane().add(squareOption);
		
		JRadioButton parallelogramOption = new JRadioButton("Parallelogram");
		parallelogramOption.setFont(new Font("Tahoma", Font.PLAIN, 18));
		parallelogramOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				triangleClicked = false;
				rectangleClicked = false;
				squareClicked = false;
				trapezoidClicked = false;
				parallelogramClicked = true;
				circleClicked = false;
				
				textFieldWidth.setText("");
				textFieldHeight.setText("");
				textFieldWidth2.setText("");
				textFieldRadius.setText("");
				textArea.setText("");
				textFieldWidth.setEditable(true);
				textFieldHeight.setEditable(true);
				textFieldWidth2.setEditable(false);
				textFieldRadius.setEditable(false);
			}
		});
		parallelogramOption.setActionCommand("Parallelogram");
		parallelogramOption.setBounds(397, 100, 143, 25);
		frame.getContentPane().add(parallelogramOption);
		
		JRadioButton trapezoidOption = new JRadioButton("Trapezoid");
		trapezoidOption.setFont(new Font("Tahoma", Font.PLAIN, 18));
		trapezoidOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				triangleClicked = false;
				rectangleClicked = false;
				squareClicked = false;
				trapezoidClicked = true;
				parallelogramClicked = false;
				circleClicked = false;
				
				textFieldWidth.setText("");
				textFieldHeight.setText("");
				textFieldWidth2.setText("");
				textFieldRadius.setText("");
				textArea.setText("");
				textFieldWidth.setEditable(true);
				textFieldHeight.setEditable(true);
				textFieldWidth2.setEditable(true);
				textFieldRadius.setEditable(false);
			}
		});
		trapezoidOption.setActionCommand("Trapezoid");
		trapezoidOption.setBounds(0, 154, 127, 25);
		frame.getContentPane().add(trapezoidOption);
		
		JRadioButton circleOption = new JRadioButton("Circle");
		circleOption.setFont(new Font("Tahoma", Font.PLAIN, 18));
		circleOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				triangleClicked = false;
				rectangleClicked = false;
				squareClicked = false;
				trapezoidClicked = false;
				parallelogramClicked = false;
				circleClicked = true;
				
				textFieldWidth.setText("");
				textFieldHeight.setText("");
				textFieldWidth2.setText("");
				textFieldRadius.setText("");
				textArea.setText("");
				textFieldWidth.setEditable(false);
				textFieldHeight.setEditable(false);
				textFieldWidth2.setEditable(false);
				textFieldRadius.setEditable(true);
			}
		});
		circleOption.setActionCommand("Circle");
		circleOption.setBounds(400, 154, 127, 25);
		frame.getContentPane().add(circleOption);
		
		ButtonGroup group = new ButtonGroup();
		group.add(triangleOption);
		group.add(rectangleOption);
		group.add(squareOption);
		group.add(parallelogramOption);
		group.add(trapezoidOption);
		group.add(circleOption);
		
		calculateButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					choice = group.getSelection().getActionCommand();
				}catch(NullPointerException ex) {
					JOptionPane.showMessageDialog(frame, "Please select a shape!");
				}
				if(triangleClicked) {
					try {
						area = (Double.parseDouble(textFieldWidth.getText())
								* Double.parseDouble(textFieldHeight.getText()))/2;
						textArea.setText(area + "");
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(frame, "Please enter a valid number!");
					}
					
					
				} else if (rectangleClicked) {
					try {
						area = (Double.parseDouble(textFieldWidth.getText())
								* Double.parseDouble(textFieldHeight.getText()));
						textArea.setText(area + "");
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(frame, "Please enter a valid number!");
					}
					
				} else if (squareClicked) {
					try{
						area = Math.pow(Double.parseDouble(textFieldWidth.getText()), 2);
						textArea.setText(area + "");
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(frame, "Please enter a valid number!");
					}
					
				} else if (parallelogramClicked) {
					try{
						area = (Double.parseDouble(textFieldWidth.getText())
								* Double.parseDouble(textFieldHeight.getText()));
						textArea.setText(area + "");
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(frame, "Please enter a valid number!");
					}
							
				} else if (trapezoidClicked) {
					try{
						area = ((Double.parseDouble(textFieldWidth.getText())
								+ Double.parseDouble(textFieldWidth2.getText()))/2)
								* Double.parseDouble(textFieldHeight.getText());
						textArea.setText(area + "");
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(frame, "Please enter a valid number!");
					}
							
				} else if (circleClicked) {
					try{
						area = Math.PI * Math.pow(Double.parseDouble(textFieldRadius.getText()), 2);
						textArea.setText(area + "");
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(frame, "Please enter a valid number!");
					}
					
				}
			}
		});
	}
}
