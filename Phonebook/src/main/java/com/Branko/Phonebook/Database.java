package com.Branko.Phonebook;

import java.sql.*;

public class Database {
						
						private String url;
						private String username;
						private String password;
						private String insert;
						
						
						
						public Database() {
							
							this.url="jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7351957";
							this.username="sql7351957";
							this.password="8pGmQHebMF";
							
							
							
						}

						
						public void add(String name,String surname,String address,String phone,Integer jmbg) throws Exception {
												
							String insert = "Insert into people values("+jmbg+",'"+name+"',"+"'"+surname+"',"+"'"+address+"','"+phone+"')";
							
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection con  = DriverManager.getConnection(url,username,password);
							Statement st = con.createStatement();
							int add = st.executeUpdate(insert);
							st.close();
							con.close();
								
							
						}
						
						public String load(String name,String surname,String address,String phone,Integer jmbg) throws Exception {
							
							String nameSQL="'"+name+"%'";
							String surnameSQL="'"+surname+"%'";
							String addressSQL="'"+address+"%'";
							String phoneSQL="'"+phone+"%'";
							
							String searchq="";
							
							
							if(jmbg!=null || !name.isEmpty() || !surname.isEmpty() || !address.isEmpty() || !phone.isEmpty()) {
								
							searchq = "Select * from people where name LIKE"+nameSQL+" && surname LIKE"+surnameSQL+
									" && address LIKE"+addressSQL+" && phone LIKE"+phoneSQL;	
								
							}
							
						
							if(jmbg==null && name.isEmpty() && surname.isEmpty() && address.isEmpty() && phone.isEmpty()){
								
							searchq = "Select 1 from dual where false";
								
							}
							
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection con  = DriverManager.getConnection(url,username,password);
							Statement st = con.createStatement();
							ResultSet rs = st.executeQuery(searchq);
							String r = "";
							int i=1;
							
							while(rs.next()) {
								
									r = r+"Result: "+i+"\n\n"+"Jmbg: "+rs.getString("jmbg")+"\nName: "+rs.getString("name")+"\nSurname: "+rs.getString("surname")+"\nAddress: "+rs.getString("address")+"\nPhone: "+rs.getString("phone")+"\n\n";
									i++;
							}
							
							
							
							st.close();
							con.close();
								
							return r;
						}
									

}
