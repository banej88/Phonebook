package com.Branko.Phonebook;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Listeners implements ActionListener {

							private JTextArea name;
							private JTextArea surname;
							private JTextArea address;
							private JTextArea phone;
							private JTextArea result;
							private JTextArea jmbg;
							private JButton search;
							private JButton insert;
							private JLabel error;
							Database b;
							
							
							public Listeners(JTextArea name,JTextArea surname,JTextArea address,JTextArea phone,
									JButton insert,JTextArea result,JButton search,JTextArea jmbg,JLabel error) {
								
								
								this.name=name;
								this.surname=surname;
								this.address=address;
								this.phone=phone;
								this.insert=insert;	
								this.result=result;
								this.search=search;
								this.jmbg=jmbg;
								this.error=error;
								this.b = new Database();
								
							}
							
							
	
							public void actionPerformed(ActionEvent ae) {
								
										int jmbgs=0;
										
										if(jmbg.getText().matches("^[0-9]*$") & !jmbg.getText().isEmpty()) {
											
										error.setText("");	
										
										jmbgs = Integer.parseInt(jmbg.getText());
										
										
										}else if(!jmbg.getText().matches("^[0-9]*$")){
											
											error.setText("Please enter number value");
										}
										
										
										
										
										if(ae.getSource()==insert) {
											
											if(name.getText().isEmpty() || surname.getText().isEmpty() || 
													address.getText().isEmpty() || phone.getText().isEmpty() || jmbg.getText().isEmpty()) {
												
												
											}else {
											
											try {
												b.add(name.getText(), surname.getText(), address.getText(), phone.getText(),jmbgs);
												
												result.setText("Sucessfuly added\n"+"Jmbg: "+jmbgs+"\nName: "+name.getText()+"\nSurname: "+surname.getText()+"\nAddress: "+address.getText()+"\nPhone: "+phone.getText());
												
											} catch (Exception e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
											
											}	
											

											
										}else if(ae.getSource()==search) {
											
											
												try {
													
													result.setText(b.load(name.getText(), surname.getText(), address.getText(), phone.getText(),jmbgs));
													
													
												} catch (Exception e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
											
											
											
										}
								
								
								
								
							}
}
