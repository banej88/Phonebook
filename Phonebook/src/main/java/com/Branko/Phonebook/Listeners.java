package com.Branko.Phonebook;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Listeners implements ActionListener {

							private JTextField name;
							private JTextField surname;
							private JTextField address;
							private JTextField phone;
							private JTextPane result;
							private JTextField jmbg;
							private JButton search;
							private JButton insert;
							private JLabel error;
							private JLabel errorName;
							private JLabel errorSurname;
							private JLabel errorAddress;
							private JLabel errorPhone;
							Database b;
							
							
							public Listeners(JTextField name,JTextField surname,JTextField address,JTextField phone,
									JButton insert,JTextPane result,JButton search,JTextField jmbg,JLabel error,
									JLabel errorName,JLabel errorSurname,JLabel errorAddress,JLabel errorPhone) {
								
								
								this.name=name;
								this.surname=surname;
								this.address=address;
								this.phone=phone;
								this.insert=insert;	
								this.result=result;
								this.search=search;
								this.jmbg=jmbg;
								this.error=error;
								this.errorName=errorName;
								this.errorSurname=errorSurname;
								this.errorAddress=errorAddress;
								this.errorPhone=errorPhone;
								this.b = new Database();
								
							}
							
							
	
							public void actionPerformed(ActionEvent ae) {
								
										int jmbgs=0;
										
										if(jmbg.getText().matches("^[0-9]*$") & !jmbg.getText().isEmpty()) {
											
										error.setText("");	
										
										jmbgs = Integer.parseInt(jmbg.getText());
										
										
										}else if(!jmbg.getText().matches("^[0-9]*$")){
											
											error.setText(" Please enter numbers only");
										}

										
										if(ae.getSource()==insert) {
											
											if(jmbg==null || name.getText().isEmpty() || surname.getText().isEmpty() || 
													address.getText().isEmpty() || phone.getText().isEmpty() || jmbg.getText().isEmpty()) {
													
													if(jmbg.getText().isEmpty()) {
														error.setText(" Please enter Jmbg");
													}
													if(name.getText().isEmpty()) {
														errorName.setText(" Please enter Name");
													}else {
														errorName.setText("");
													}
													if(surname.getText().isEmpty()) {
														errorSurname.setText(" Please enter Surname");
													}else {
														errorSurname.setText("");
													}
													if(address.getText().isEmpty()) {
														errorAddress.setText(" Please enter Address");
													}else {
														errorAddress.setText("");
													}
													if(phone.getText().isEmpty()) {
														errorPhone.setText(" Please enter Phone");
													}else {
														errorPhone.setText("");
													}
												
												
											}else {
											
											try {
												b.add(name.getText(), surname.getText(), address.getText(), phone.getText(),jmbgs);
												errorPhone.setText("");
												errorAddress.setText("");
												errorSurname.setText("");
												errorName.setText("");
												error.setText("");
												
												result.setText("Sucessfuly added\n\n"+"Jmbg: "+jmbgs+"\nName: "+name.getText()+"\nSurname: "+surname.getText()+"\nAddress: "+address.getText()+"\nPhone: "+phone.getText());
												
												name.setText("");
												surname.setText("");
												address.setText("");
												phone.setText("");
												jmbg.setText("");
												
												
												
											} catch (Exception e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
											
											}	
											

											
										}else if(ae.getSource()==search) {
											
											if(jmbg.getText().isEmpty()) {
												
												jmbgs=-1;
											}
											
											
												try {
													
													result.setText(b.load(name.getText(), surname.getText(), address.getText(), phone.getText(),jmbgs));
													errorPhone.setText("");
													errorAddress.setText("");
													errorSurname.setText("");
													errorName.setText("");
													error.setText("");
													
												} catch (Exception e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
											
											
											
										}
								
								
								
								
							}
}
