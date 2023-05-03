
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class PotatoDisease extends JFrame implements ActionListener,ItemListener  {
	JLabel l1,l2,l3,l4,l5,l6,a;
	JComboBox cb,cb1;
	JButton b1,b2,b3,b4;
	JTextField f1,f2,f3,f4,f5,f6;
 public PotatoDisease(){
	setSize(1400,1200);
	setVisible(true);
	setLayout(null);
	setTitle("plant disease");
	
	a=new JLabel ("Colors");
	a.setBounds(100,50,80,30);
	add(a);
	
	cb=new JComboBox();
	cb.addItem("Pink");
	cb.addItem("Yellow");
	cb.addItem("Green");
	cb.addItem("grey");
	cb.setBounds(250,50,100,30);
	add(cb);
	cb.addItemListener((ItemListener) this);
	
	cb1=new JComboBox();
	cb1.addItem("tomato");
	cb1.addItem("potato");
	cb1.setBounds(800,300,250,50);
	add(cb1);
	
	l1=new JLabel ("disease_id");
	l1.setBounds(700,400,100,40);
	add(l1);
	f1 = new JTextField();
	f1.setBounds(800,400,500,40);
	add(f1);
	
	b1=new JButton ("find");
	b1.setBounds(800,700,200,40);
	add(b1);
	b1.addActionListener(this);

	l2=new JLabel (" disease_name");
	l2.setBounds(700,500,100,40);
	add(l2);
	f2 = new JTextField();
	f2.setBounds(800,500,500,40);
	add(f2);
	
	l3=new JLabel ("causes");
	l3.setBounds(700,550,100,40);
	add(l3);
	f3 = new JTextField();
	f3.setBounds(800,550,500,40);
	add(f3);
	
	l4=new JLabel ("precation");
	l4.setBounds(700,600,100,40);
	add(l4);
	f4 = new JTextField();
	f4.setBounds(800,600,500,40);
	add(f4);
	
	l5=new JLabel ("solution");
	l5.setBounds(700,650,100,40);
	add(l5);
	f5 = new JTextField();
	f5.setBounds(800,650,500,40);
	add(f5);
	
	l6=new JLabel ("image_id ");
	l6.setBounds(700,450,100,40);
	add(l6);
	f6 = new JTextField();
	f6.setBounds(800,450,500,40);
	add(f6);
	
	b2=new JButton ("Update");
	b2.setBounds(1000,700,200,40);
	add(b2);
	b2.addActionListener(this);
	
	b3=new JButton ("Save");
	b3.setBounds(1000,750,200,40);
	add(b3);
	b3.addActionListener(this);
	
	b4=new JButton ("Delete");
	b4.setBounds(800,750,200,40);
	add(b4);
	b4.addActionListener(this);

	setDefaultCloseOperation(EXIT_ON_CLOSE);
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PotatoDisease ob = new PotatoDisease();
	}
	public void itemStateChanged(ItemEvent ae) {
		// TODO Auto-generated method stub
		if(cb.getSelectedIndex()==0) {
			getContentPane().setBackground(Color.PINK);
		}
		if(cb.getSelectedIndex()==1) {
			getContentPane().setBackground(Color.YELLOW);
		}
		if(cb.getSelectedIndex()==2) {
			getContentPane().setBackground(Color.GREEN);
		}
		if(cb.getSelectedIndex()==3) {
			getContentPane().setBackground(Color.GRAY);
		}
		
	}

	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
	
		if(ae.getSource()==b1) {
		Connection con;
		PreparedStatement st;
		ResultSet rs;
		
		try {
			// load drive
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// load connection
			con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
					//
		//	String sql ="select UserId,UserName,UserPhone,UserEmail,UserPassword from Users where UserId =? ";
			String sql ="select disease_id, disease_name,causes,precaution,solution,image_id from potato_disease where disease_name =? ";
			
			int a= Integer.parseInt(f1.getText());
			st= con.prepareStatement(sql);
			st.setInt(1,a);
			
			rs = st.executeQuery();
			if(rs.next()) {
				f2.setText(rs.getString(2));
				f3.setText(rs.getString(3));
				f4.setText(rs.getString(4));
				f5.setText(rs.getString(5));
				f6.setText(rs.getString(6));
				//f6.setText(String.valueOf(rs.getString(5)));
				
			
			
		
		}
			else {
				JOptionPane.showMessageDialog(this,"data is not present");
			}
			
			con.close();
		}
			catch(Exception ex)
			{
				System.out.println(ex.toString());
		}

			
			}
if(ae.getSource()==b2) {
	
		Connection con;
		PreparedStatement st;
		ResultSet rs;
		
		try {
			// load drive
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// load connection
			con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
					//
			
			String sql ="update potato_disease set disease_name=?,causes=?,precaution=?,solution=?,image_id=?  where disease_id =? ";
			
			int a= Integer.parseInt(f1.getText());
			String b=f2.getText();
			String c=f3.getText();
			String d=f4.getText();
			String e=f5.getText();
			String f=f6.getText();
	
			st= con.prepareStatement(sql);
			
			st.setString(1, b);
			st.setString(2, c);
			st.setString(3, d);
			st.setString(4, e);
			st.setString(5, f);
			st.setInt(6,a);
			int g=st.executeUpdate();
		
				JOptionPane.showMessageDialog(this,"data is updated");
			
			con.close();
		}
			catch(Exception ex)
			{
				System.out.println(ex.toString());
			}

		
}


//public void actionPerformed(ActionEvent ae) {
	// TODO Auto-generated method stub
	Connection con;
	PreparedStatement st;
	
if(ae.getSource()==b3) {
	try {
		// load drive
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// load connection
		con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				//
		//st=con.createStatement();
		//
		//rs= st.executeQuery("select * from staff");

		String sql ="insert into potato_disease values(?,?,?,?,?,?)";
		st= con.prepareStatement(sql);
		int a= Integer.parseInt(f1.getText());
		String b = f2.getText();
		String c = f3.getText();
		String d = f4.getText();
		String e = f5.getText();
		String f = f6.getText();
		//int f = Integer.parseInt(f6.getText());
		st.setInt(1,a);
		st.setString(2,b);
		st.setString(3,c);
		st.setString(4,d);
		st.setString(5,e);
		st.setString(6,f);
		int g= st.executeUpdate();
		
	
		con.close();
		JOptionPane.showMessageDialog(this,"data Saved");
	
	}
		
		
	
		catch(Exception ex)
		{
			System.out.println(ex.toString());
	}
}
		
	

			

if(ae.getSource()==b4) 
try {
	// load drive
	Class.forName("oracle.jdbc.driver.OracleDriver");
	// load connection
	con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//
	//st=con.createStatement();
	//
	//rs= st.executeQuery("select * from staff");
	String sql ="delete  from potato_disease where disease_id = ?";
	st= con.prepareStatement(sql);
	int a= Integer.parseInt(f1.getText());
	
	st.setInt(1,a);

	
	
	
	int g= st.executeUpdate();
	

	con.close();
	JOptionPane.showMessageDialog(this,"data deleted");

}
	
	

	catch(Exception ex)
	{
		System.out.println(ex.toString());
}

	
	}



	}
	


