package inventory.management;



import static inventory.management.SignUp.isvalidemail;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
        JFrame frame;
	JTextField user_name;
	JPasswordField password;
        JLabel label1;
        JPanel panel;
	JButton login;
	JLabel user;
	JLabel pass;
        JLabel label2;
        JButton signup;
        static final String JDBC_URL = "jdbc:mysql://localhost:3306/";
        static final String DB_NAME = "InventoryDB";
        static final String USER = "root"; 
        static final String PASSWORD = "admin123";
       
	Login() {
		frame = new JFrame("Login");
		frame.setSize(700,500);
               
                panel=new JPanel();
                panel.setBounds(50, 30, 600, 400);
                panel.setLayout(null);
                Color c=new Color(212,231,245);
                panel.setBackground(c);
                
                label1=new JLabel("Sign In");
                label1.setBounds(260,30,100,50);
                label1.setFont(new Font("Arial", Font.BOLD, 24));
            
                user=new JLabel("User Name :");
                user.setBounds(160, 90, 120, 30);
                user.setFont(new Font("Arial",Font.PLAIN, 20));
                
                user_name=new JTextField();
                user_name.setBounds(300,90, 200, 30);
                user_name.setFont(new Font("Arial",Font.PLAIN, 20));
                
                pass=new JLabel("Password :");
                pass.setBounds(160, 140, 120, 30);
                pass.setFont(new Font("Arial", Font.PLAIN, 20));
                
                password=new JPasswordField(8);
                password.setBounds(300,140, 200, 30);
                password.setFont(new Font("Arial", Font.PLAIN, 20));
                
		login = new JButton("Log in");
		login.setBounds(260,200,100,30);
                login.setFont(new Font("Arial", Font.PLAIN, 20));
                
                label2=new JLabel("Don't have an account?");
                label2.setBounds(120,270,250,50);
                label2.setFont(new Font("Arial", Font.PLAIN, 20));
                
                signup = new JButton("Sign Up");
		signup.setBounds(350,280,120,30);
                signup.setFont(new Font("Arial", Font.PLAIN, 20));
                
                panel.add(user);
                panel.add(pass);
                panel.add(label1);
                panel.add(user_name);
                panel.add(password);
                panel.add(login);
                panel.add(label2);
                panel.add(signup);
                login.addActionListener(this);
                signup.addActionListener(this);
		frame.add(panel);
                frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
                    if(e.getSource()==login){
                        String dbURL = JDBC_URL + DB_NAME;
                        try (Connection conn = DriverManager.getConnection(dbURL, USER, PASSWORD);
             Statement select = conn.createStatement();Statement insert = conn.createStatement()){// to create database
                            String user=user_name.getText();
                            String pass=new String(password.getPassword());
                            if((!user.isEmpty())&&(!pass.isEmpty())){
                                    if(isvalidemail(user)){
                                        if(pass.length()<=8){
                                            System.out.println();
                                            String selectQuery ="SELECT * FROM signup where Username='+"+user+"';" ;
                                            try (ResultSet rs = select.executeQuery(selectQuery)) {
                                                 if(rs.next()){
                                                     String insertQuery="INSERT INTO signin(username,password) VALUES ('"+user+"','"+pass+"');";
                                                     select.executeUpdate(insertQuery);
                                                     frame.dispose();
                                                     new LandingPage();
                                                 }
                                                 else{
                                                  
                                                     JOptionPane.showMessageDialog(this,"Not Signed Up");

                                                 }

                                            }
                                        }
                                        else{
                                                     JOptionPane.showMessageDialog(this,"password length should be 8");
                                                     System.out.println("value exist");
                                        }

                                    } 
                                    else{
                                        JOptionPane.showMessageDialog(this,"Invalid user name");
                                    }
                            }
                            else{
                                JOptionPane.showMessageDialog(this,"Fields are empty");
                            }
            
                    }   catch (SQLException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
               
                    }
                    if (e.getSource() == signup) {
                            frame.dispose(); // Close the SignUp window
                            new SignUp(); // Open the Login window
                    }
        }
                
		    
}
