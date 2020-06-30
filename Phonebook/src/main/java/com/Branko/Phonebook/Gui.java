package com.Branko.Phonebook;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.*;

public class Gui implements Runnable {

				
							private JFrame frame;
							private JTextField name=new JTextField();
							private JTextField surname=new JTextField();
							private JTextField address=new JTextField();
							private JTextField phone=new JTextField();
							private JButton search=new JButton("Serach");
							private JButton insert=new JButton("Insert");
							private JTextPane result = new JTextPane();
							private JTextField jmbg = new JTextField();
							private JLabel error = new JLabel();
							private Font f = new Font("Ariel",Font.PLAIN,17);
							private Font r = new Font("Ariel",Font.PLAIN,15);
							private JScrollPane jp;
							
							
							public void run() {
								
								
									frame = new JFrame("Phonebook");
									
									frame.setPreferredSize(new Dimension(600,650));
									
									frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
									
									createComponent(frame.getContentPane());		
									
									ImageIcon icon = new ImageIcon("resources/phonebook.png");
									frame.setIconImage(icon.getImage());
									
									
									frame.pack();
									
									
									frame.setLocationRelativeTo(null);
									
									frame.setVisible(true);
									
									jmbg.setBorder(new LineBorder(Color.BLACK));
									jmbg.setFont(f);
									name.setBorder(new LineBorder(Color.BLACK));
									name.setFont(f);
									surname.setBorder(new LineBorder(Color.BLACK));
									surname.setFont(f);
									address.setBorder(new LineBorder(Color.BLACK));
									address.setFont(f);
									phone.setBorder(new LineBorder(Color.BLACK));
									phone.setFont(f);
									result.setEditable(false);
									result.setBackground(Color.white);
									result.setForeground(Color.black);
									
									
									
									SimpleAttributeSet attributeSet = new SimpleAttributeSet();
								    StyleConstants.setItalic(attributeSet, true);
								    StyleConstants.setAlignment(attributeSet, StyleConstants.ALIGN_CENTER);
								    StyleConstants.setFontSize(attributeSet, 18);
								    StyleConstants.setForeground(attributeSet, Color.black);
								    StyleConstants.setBackground(attributeSet, Color.white);
								    result.setCharacterAttributes(attributeSet, true);
								    result.setParagraphAttributes(attributeSet, false);
								    Border border = BorderFactory.createLineBorder(Color.BLACK);
								    result.setBorder(BorderFactory.createCompoundBorder(border,
								            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
								    
							        
								    		
									
							}
							
							public void createComponent(Container container) {
								
										jp = new JScrollPane(resultGrid(), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
										jp.setBorder(null);
										
										container.setLayout(new GridLayout(2,1));

						        		container.add(group());
						        		container.add(jp);

						        		
							}
							
							public JPanel resultGrid() {
								
								JPanel pane = new JPanel();
								pane.setLayout(new BorderLayout());
								
								
								pane.add(new JLabel(" "),BorderLayout.NORTH);
								pane.add(new JLabel("   "),BorderLayout.EAST);
								pane.add(new JLabel("   "),BorderLayout.WEST);
								pane.add(new JLabel(" "),BorderLayout.SOUTH);
								pane.add(result,BorderLayout.CENTER);
								
								
								return pane;
							}
							
							public JPanel jmbgGrid() {
								
								JPanel pane = new JPanel(new GridLayout(1,3));
								JLabel nameID = new JLabel("Jmbg ", SwingConstants.RIGHT);
								pane.add(nameID);
								nameID.setFont(f);
								pane.add(this.jmbg);
								pane.add(error);
								
								return pane;
							}
							
							public JPanel nameGrid() {
								
								JPanel pane = new JPanel(new GridLayout(1,3));
								JLabel nameID = new JLabel("Name ", SwingConstants.RIGHT);
								pane.add(nameID);
								nameID.setFont(f);
								pane.add(this.name);
								pane.add(new JLabel());
								
								return pane;
							}
							
							public JPanel surnameGrid() {
								
								JPanel pane = new JPanel(new GridLayout(1,3));
								JLabel surnameID = new JLabel("Surname ", SwingConstants.RIGHT);
								pane.add(surnameID);
								surnameID.setFont(f);
								pane.add(this.surname);
								pane.add(new JLabel());

								return pane;
							}
							
							public JPanel addressGrid() {
								
								JPanel pane = new JPanel(new GridLayout(1,3));
								JLabel addressID = new JLabel("Address ", SwingConstants.RIGHT);
								pane.add(addressID);
								addressID.setFont(f);
								pane.add(this.address);
								pane.add(new JLabel());

								return pane;
							}
							
							public JPanel phoneGrid() {
								
								JPanel pane = new JPanel(new GridLayout(1,3));
								JLabel phoneID = new JLabel("Phone ", SwingConstants.RIGHT);
								pane.add(phoneID);
								phoneID.setFont(f);
								pane.add(this.phone);
								pane.add(new JLabel());

								return pane;
							}
							
							public JPanel buttonGrid() {
								
								JPanel pane = new JPanel(new GridLayout(1,4));
							
								
								pane.add(new JLabel());
								pane.add(this.insert);
								pane.add(new JLabel());
								Listeners b = new Listeners(name,surname,address,phone,insert,result,search,jmbg,error);
								insert.addActionListener(b);
								pane.add(search);
								search.addActionListener(b);
								pane.add(new JLabel());
			
								return pane;
							}
							
							
							public JPanel group() {
								
								
								JPanel pane = new JPanel(new GridLayout(13,1));
								
								pane.add(new JLabel());
				        		pane.add(jmbgGrid());
								pane.add(new JLabel());
				        		pane.add(nameGrid());
				        		pane.add(new JLabel());
				        		pane.add(surnameGrid());
				        	    pane.add(new JLabel());
				        		pane.add(addressGrid());
				        		pane.add(new JLabel());
				        		pane.add(phoneGrid());
				        		pane.add(new JLabel());
				        		pane.add(buttonGrid());
				        		pane.add(new JLabel());
								
								
								return pane;
								
								
								
							}
							

						
							
							
	
	
}
