/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventory.management;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;

/**
 *
 * @author yogit
 */
public class LandingPage extends JFrame implements ActionListener {
        JFrame frame;
        
        JButton category;
        JButton product;
        JButton customer;
        JButton order;
        JButton viewOrder;
        JButton logout;
        
        
        //Category
        JPanel categorypanel;
        JTable category_table;
        DefaultTableModel model;
        JLabel category_head;
        JLabel addCategorylabel;
        JTextField addCategory;
        JButton addCategorybutton;
        JScrollPane scrollPane;
        JScrollPane scrollPane1;
        JScrollPane scrollPane2;
        JTextField catecolumn1;
        JTextField catecolumn2;
        
        
        //Product
        JPanel productpanel;
        JTable product_table;
        DefaultTableModel product_model;
        JLabel product_head;
        JLabel addproduct_label;
        JLabel addQuantity_label;
        JLabel addPrice_label;
        JLabel addCate_label;
        JTextField addproduct_tf;
        JTextField addQuantity_tf;
        JTextField addPrice_tf;
        JComboBox<String> addCate_cb;
        JButton addproductbutton;
        JTextField procolumn1;
        JTextField procolumn2;
        JTextField procolumn3;
        JTextField procolumn4;
        JTextField procolumn5;
        
        //Customer
        JPanel customerpanel;
        JTable customer_table;
        DefaultTableModel customer_model;
        JLabel customer_head;
        JLabel addcustomername_label;
        JTextField addcustomername_tf;
        JLabel addcustomerphone_label;
        JTextField addcustomerphone_tf;
        JLabel addcustomeremail_label;
        JTextField addcustomeremail_tf;
        JLabel addcustomeradd_label;
        JTextArea addcustomeradd_tf;
        JButton addcustomerbutton;
        JScrollPane customerscrollPane;
        JTextField cuscolumn1;
        JTextField cuscolumn2;
        JTextField cuscolumn3;
        JTextField cuscolumn4;
        JTextField cuscolumn5;
        
        //Order
        JPanel panel1;
        JLabel orderlabel;
        JLabel addcus_label1;
        JComboBox<String> addcus_cb1;
        JLabel addCate_label1;
        JComboBox<String> addCate_cb1;
        JLabel addpro_label1;
        JComboBox<String> addpro_cb1;
        JLabel cusname;
        JTextField cusnametf;
        JLabel cusquantity;
        JTextField cusquantitytf;
        JButton Addtocart;
        JPanel panel2;
        JTable ordertable;
        DefaultTableModel order_model;
        JScrollPane sp;
        JButton save;
        JLabel total;
        JTextField totaltf;
        JButton reset;
        
        
        //viewOrder
        JPanel vopanel;
        JPanel vopanel2;
        DefaultTableModel vomodel;
        JTable votable;
        JScrollPane vosp;
        
        
        static final String JDBC_URL = "jdbc:mysql://localhost:3306/";
        static final String DB_NAME = "InventoryDB";
        static final String USER = "root"; 
        static final String PASSWORD = "admin123";
        
    LandingPage(){
        frame=new JFrame("Inventory System");
        frame.setSize(950,650);
        Color c1=new Color(61,92,91);
        Color c=new Color(153,196,204);
        
        //CATEGORY 
        categorypanel=new JPanel();
        categorypanel.setBounds(20, 20, 890, 500);
        categorypanel.setLayout(null);
        categorypanel.setBackground(c);
        categorypanel.setVisible(false);
        
        category_head=new JLabel("CATEGORIES");
        category_head.setBounds(430,20,150,30);
        category_head.setFont(new Font("cursive", Font.BOLD, 20));
        
        addCategorylabel=new JLabel("Add category");
        addCategorylabel.setFont(new Font("cursive", Font.BOLD, 14));
        addCategorylabel.setBounds(500,150,120,30);
        
        addCategory=new JTextField();
        addCategory.setBounds(600,150,200,30);
        
        model = new DefaultTableModel();
        category_table = new JTable(model);
        category_table.setBounds(80, 80, 400, 400);
        loadcate(model);
        scrollPane = new JScrollPane(category_table);
        
        catecolumn1=new JTextField("ID");
        catecolumn1.setBounds(80,60,200,20);
        catecolumn1.setEditable(false);
        catecolumn2=new JTextField("Category");
        catecolumn2.setBounds(280,60,200,20);
        catecolumn2.setEditable(false);
        
        
        addCategorybutton=new JButton("ADD");
        addCategorybutton.setBounds(610,200,70, 40);
        addCategorybutton.setFont(new Font("cursive", Font.BOLD, 14));
        addCategorybutton.addActionListener(this);
        addCategorybutton.setForeground(Color.WHITE);
        addCategorybutton.setBackground(c1);
        addCategorybutton.setFocusPainted(false);
        
        category=new JButton("Category");
        category.setFont(new Font("cursive", Font.BOLD, 14));
        category.setBounds(50, 550, 120, 30);
        
        category.setBackground(c1);
        category.setForeground(Color.WHITE);
        category.setFocusPainted(false);
        
        
        
        //PRODUCT 
        productpanel=new JPanel();
        productpanel.setBounds(20,20,890,500);
        productpanel.setLayout(null);
        productpanel.setBackground(c);
        
        
        product_head=new JLabel("PRODUCTS");
        product_head.setBounds(430,20,150,30);
        product_head.setFont(new Font("cursive", Font.BOLD, 20));
        
        
        product_model = new DefaultTableModel();
        product_table = new JTable(product_model);
        product_table.setBounds(50, 90, 500, 350);
        
        loaddata(product_model);
        scrollPane1 = new JScrollPane(product_table);
        
        procolumn1=new JTextField("ID");
        procolumn1.setBounds(50,70,100,20);
        procolumn1.setEditable(false);
        procolumn2=new JTextField("Product");
        procolumn2.setBounds(150,70,100,20);
        procolumn2.setEditable(false);
        procolumn3=new JTextField("Quantity");
        procolumn3.setBounds(250,70,100,20);
        procolumn3.setEditable(false);
        procolumn4=new JTextField("Price");
        procolumn4.setBounds(350,70,100,20);
        procolumn4.setEditable(false);
        procolumn5=new JTextField("Category");
        procolumn5.setBounds(450,70,100,20);
        procolumn5.setEditable(false);
        
        
        addproduct_label=new JLabel("Product Name :");
        addproduct_label.setBounds(570,100,120,30);
        addproduct_tf=new JTextField();
        addproduct_tf.setBounds(670,100,200,30);
        addQuantity_label=new JLabel("Quantity :");
        addQuantity_label.setBounds(605,150,120,30);
        addQuantity_tf=new JTextField();
        addQuantity_tf.setBounds(670,150,200,30);
        addPrice_label=new JLabel("Price :");
        addPrice_label.setBounds(620,200,120,30);
        addPrice_tf=new JTextField();
        addPrice_tf.setBounds(670,200,200,30);
        addCate_label=new JLabel("Category :");
        addCate_label.setBounds(605,250,120,30);
        addCate_cb=new JComboBox<>();
        addCate_cb.setBounds(670, 250, 120, 30);
        loadcategories(addCate_cb);
        
        addproductbutton=new JButton("ADD");
        addproductbutton.setBounds(700,300,70, 40);
        addproductbutton.setFont(new Font("cursive", Font.BOLD, 14));
        addproductbutton.addActionListener(this);
        addproductbutton.setForeground(Color.WHITE);
        addproductbutton.setBackground(c1);
        addproductbutton.setFocusPainted(false);
        
        
        
        product=new JButton("Product");
        product.setFont(new Font("cursive", Font.BOLD, 14));
        product.setBounds(190, 550, 120, 30);
        product.setBackground(c1);
        product.setForeground(Color.WHITE);
        product.setFocusPainted(false);
        product.addActionListener(this);
        productpanel.setVisible(false);
      
        
        //CUSTOMER
        customerpanel=new JPanel();
        customerpanel.setBounds(20, 20, 890, 500);
        customerpanel.setLayout(null);
        customerpanel.setBackground(c);
        
        customer_model = new DefaultTableModel();
        customer_table = new JTable(customer_model);
        customer_table.setBounds(50, 80, 500, 400);
        loadcustomer(customer_model);
        scrollPane2 = new JScrollPane(customer_table);
        
        customer_head=new JLabel("Customers");
        customer_head.setBounds(430,20,150,30);
        customer_head.setFont(new Font("cursive", Font.BOLD, 20));
        
        cuscolumn1=new JTextField("ID");
        cuscolumn1.setBounds(50,60,100,20);
        cuscolumn1.setEditable(false);
        cuscolumn2=new JTextField("Name");
        cuscolumn2.setBounds(150,60,100,20);
        cuscolumn2.setEditable(false);
        cuscolumn3=new JTextField("Phone NO.");
        cuscolumn3.setBounds(250,60,100,20);
        cuscolumn3.setEditable(false);
        cuscolumn4=new JTextField("Email");
        cuscolumn4.setBounds(350,60,100,20);
        cuscolumn4.setEditable(false);
        cuscolumn5=new JTextField("Address");
        cuscolumn5.setBounds(450,60,100,20);
        cuscolumn5.setEditable(false);
        
        
        addcustomername_label=new JLabel("Name :");
        addcustomername_label.setBounds(620,150,120,30);
        addcustomername_tf=new JTextField();
        addcustomername_tf.setBounds(670,150,200,30);
        
        addcustomerphone_label=new JLabel("Phone No :");
        addcustomerphone_label.setBounds(600,200,120,30);
        addcustomerphone_tf=new JTextField();
        addcustomerphone_tf.setBounds(670,200,200,30);
        
        addcustomeremail_label=new JLabel("Email :");
        addcustomeremail_label.setBounds(620,250,120,30);
        addcustomeremail_tf=new JTextField();
        addcustomeremail_tf.setBounds(670,250,200,30);
        
        addcustomeradd_label=new JLabel("Address :");
        addcustomeradd_label.setBounds(600,300,120,30);
        addcustomeradd_tf=new JTextArea();
        addcustomeradd_tf = new JTextArea();
        addcustomeradd_tf.setLineWrap(true); 
        addcustomeradd_tf.setWrapStyleWord(true); 

       
        customerscrollPane = new JScrollPane(addcustomeradd_tf);
        customerscrollPane.setBounds(670, 300, 200, 50);
        
        addcustomerbutton=new JButton("ADD");
        addcustomerbutton.setBounds(700,400,70, 40);
        addcustomerbutton.setFont(new Font("cursive", Font.BOLD, 14));
        addcustomerbutton.addActionListener(this);
        addcustomerbutton.setForeground(Color.WHITE);
        addcustomerbutton.setBackground(c1);
        addcustomerbutton.setFocusPainted(false);
        
        customer=new JButton("Customer");
        customer.setFont(new Font("cursive", Font.BOLD, 14));
        customer.setBounds(330, 550, 120, 30);
        customer.setBackground(c1);
        customer.setForeground(Color.WHITE);
        customer.setFocusPainted(false);
        customer.addActionListener(this);
        customerpanel.setVisible(false);
        
        
        //ORDER
        panel1=new JPanel();
        panel1.setBounds(20, 20, 890, 500);
        panel1.setLayout(null);
        panel1.setBackground(c);
        panel1.setVisible(false);
        
        orderlabel=new JLabel("Orders");
        orderlabel.setBounds(430,20,150,30);
        orderlabel.setFont(new Font("cursive", Font.BOLD, 20));
        
        addcus_label1=new JLabel("Customer ID :");
        addcus_label1.setBounds(50,100,120,30);
        addcus_cb1=new JComboBox<>();
        addcus_cb1.setBounds(150, 100, 120, 30);
        loadcus(addcus_cb1);
        
        cusname=new JLabel("Customer name :");
        cusname.setBounds(30,140,120,30);
        cusnametf=new JTextField();
        cusnametf.setBounds(150,140,120,30);
        cusnametf.setEditable(false);
        
        addcus_cb1.addActionListener(e->{
            String selectedId = (String)addcus_cb1.getSelectedItem();
            if (selectedId != null) {
                String customerName = getCustomerName(selectedId);
                cusnametf.setText(customerName);
            }
        });
        
        addCate_label1=new JLabel("Category :");
        addCate_label1.setBounds(70,180,120,30);
        addCate_cb1=new JComboBox<>();
        addCate_cb1.setBounds(150, 180, 120, 30);
        loadcategories(addCate_cb1);
        
        addpro_label1=new JLabel("Product :");
        addpro_label1.setBounds(70,220,120,30);
        addpro_cb1=new JComboBox<>();
        addpro_cb1.setBounds(150, 220, 120, 30);
        loadproducts(addpro_cb1);
        
        cusquantity=new JLabel("Quantity :");
        cusquantity.setBounds(70,260,120,30);
        cusquantitytf=new JTextField();
        cusquantitytf.setBounds(150,260,120,30);
        
        Addtocart=new JButton("Add to Cart");
        Addtocart.setBounds(100,320,200,30);
        Addtocart.addActionListener(this);
        
        reset=new JButton("Reset");
        reset.setBounds(100,370,200,30);
        reset.addActionListener(this);
        
        panel2=new JPanel();
        panel2.setBounds(350,70,500,300);
        panel2.setBackground(c1);
        
        order_model=new DefaultTableModel();
        ordertable=new JTable(order_model);
        order_model.addColumn("ID");
        order_model.addColumn("Name");
        order_model.addColumn("Category");
        order_model.addColumn("Product");
        order_model.addColumn("Quantity");
        order_model.addColumn("Price");
        sp=new JScrollPane(ordertable);
        panel2.add(sp);
        panel1.add(panel2);
        
        order=new JButton("Order");
        order.setFont(new Font("cursive", Font.BOLD, 14));
        order.setBounds(470, 550, 120, 30);
        order.setBackground(c1);
        order.setForeground(Color.WHITE);
        order.setFocusPainted(false);
        order.addActionListener(this);
        
        save=new JButton("Place Order");
        save.setBounds(700,400,120,30);
        save.addActionListener(this);
        
        total=new JLabel("Total Amount:");
        total.setBounds(400,400,100,30);
        
        totaltf=new JTextField();
        totaltf.setBounds(500,400,120,30);
        totaltf.setEditable(false);
        
        
        
        //VIEWORDER
        vopanel=new JPanel();
        vopanel.setBounds(20, 20, 890, 500);
        vopanel.setLayout(null);
        vopanel.setBackground(c);
        vopanel.setVisible(false);
        
        JLabel volabel=new JLabel("View Orders");
        volabel.setBounds(430,20,150,30);
        volabel.setFont(new Font("cursive", Font.BOLD, 20));
        
        vopanel2=new JPanel();
        vopanel2.setBounds(220,100,500,300);
        vopanel2.setBackground(c1);
        
        
        vomodel=new DefaultTableModel();
        votable=new JTable(vomodel);
        vomodel.addColumn("ID");
        vomodel.addColumn("Name");
        vomodel.addColumn("Product");
        vomodel.addColumn("Category");
        vomodel.addColumn("Price");
        vomodel.addColumn("DateTime");
        vosp=new JScrollPane(votable);
        vopanel2.add(vosp);
        loadcart(vomodel);
        
        viewOrder=new JButton("View Order");
        viewOrder.setFont(new Font("cursive", Font.BOLD, 14));
        viewOrder.setBounds(610, 550, 120, 30);
        viewOrder.setBackground(c1);
        viewOrder.setForeground(Color.WHITE);
        viewOrder.setFocusPainted(false);
        viewOrder.addActionListener(this);
        
        
        //Logout
        logout=new JButton("Logout");
        logout.setFont(new Font("cursive", Font.BOLD, 14));
        logout.setBounds(750, 550, 120, 30);
        logout.setBackground(c1);
        logout.setForeground(Color.WHITE);
        logout.setFocusPainted(false);
        logout.addActionListener(this);
        
        //Frame
        frame.add(category);
        frame.add(order);
        frame.add(product);
        frame.add(customer);
        frame.add(viewOrder);
        frame.add(logout);
        frame.add(categorypanel);
        frame.add(productpanel);
        frame.add(customerpanel);
        frame.add(panel1);
        frame.add(vopanel);
        
        
       
        
        //Category
        category.addActionListener(this);
        categorypanel.add(category_table);
        categorypanel.add(category_head);
        categorypanel.add(addCategory);
        categorypanel.add(addCategorylabel);
        categorypanel.add(addCategorybutton);
        categorypanel.add(catecolumn1);
        categorypanel.add(catecolumn2);
        
        
        //Product
        productpanel.add(product_head);
        productpanel.add(product_table);
        productpanel.add(addproduct_label);
        productpanel.add(addQuantity_label);
        productpanel.add(addPrice_label);
        productpanel.add(addCate_label);
        productpanel.add(addproduct_tf);
        productpanel.add(addQuantity_tf);
        productpanel.add(addPrice_tf);
        productpanel.add(addCate_cb);
        productpanel.add(addproductbutton);
        productpanel.add(scrollPane1);
        productpanel.add(procolumn1);
        productpanel.add(procolumn2);
        productpanel.add(procolumn3);
        productpanel.add(procolumn4);
        productpanel.add(procolumn5);
        
        
        //Customer
        customerpanel.add(customer_table);
        customerpanel.add(customer_head);
        customerpanel.add(customerscrollPane);
        customerpanel.add(addcustomeradd_label);
        customerpanel.add(addcustomeremail_tf);
        customerpanel.add(addcustomeremail_label);
        customerpanel.add(addcustomerphone_tf);
        customerpanel.add(addcustomerphone_label);
        customerpanel.add(addcustomername_tf);
        customerpanel.add(addcustomername_label);
        customerpanel.add(addcustomerbutton);
        customerpanel.add(scrollPane2);
        customerpanel.add(cuscolumn1);
        customerpanel.add(cuscolumn2);
        customerpanel.add(cuscolumn3);
        customerpanel.add(cuscolumn4);
        customerpanel.add(cuscolumn5);
        
        //Order
        panel1.add(orderlabel);
        panel1.add(addcus_label1);
        panel1.add(addcus_cb1);
        panel1.add(addCate_label1);
        panel1.add(addCate_cb1);
        panel1.add(addpro_label1);
        panel1.add(addpro_cb1);
        panel1.add(cusname);
        panel1.add(cusnametf);
        panel1.add(cusquantity);
        panel1.add(cusquantitytf);
        panel1.add(Addtocart);
        panel1.add(save);
        panel1.add(total);
        panel1.add(totaltf);
        panel1.add(reset);
        
        //vieworder
        vopanel.add(vopanel2);
        vopanel.add(volabel);
        
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
   
    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource()==category){
                vopanel.setVisible(false);
                panel1.setVisible(false);
                productpanel.setVisible(false);
                customerpanel.setVisible(false);
                categorypanel.setVisible(true);
            }
            else if(e.getSource()==addCategorybutton){
                String category=addCategory.getText();
                String dbURL = JDBC_URL + DB_NAME;
                if(!category.isEmpty()){
                try (Connection conn = DriverManager.getConnection(dbURL, USER, PASSWORD);
                     Statement insert = conn.createStatement();Statement select = conn.createStatement()){// to create database
                          String insertQuery="INSERT INTO category(C_Name) VALUES ('"+category+"');";
                          insert.executeUpdate(insertQuery);
                          String selectQuery="Select * from category ;";
                          ResultSet rs = select.executeQuery(selectQuery);
                          if(rs.last()){
                              Object[] row=new Object[2];
                              row[0]=rs.getInt("C_ID");
                              row[1]=rs.getString("C_Name");
                              model.addRow(row);
                           }
                          addCategory.setText("");

                        } catch (SQLException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                }else{
                    JOptionPane.showMessageDialog(this,"Fields are empty");
                }
            }
            else if(e.getSource()==product){
                vopanel.setVisible(false);
                categorypanel.setVisible(false);
                productpanel.setVisible(true);
            }
            else if(e.getSource()==addproductbutton){
                String product=addproduct_tf.getText();
                String quantity=addQuantity_tf.getText();
                String price=addPrice_tf.getText();
                String category=(String)addCate_cb.getSelectedItem();
                String dbURL = JDBC_URL + DB_NAME;
                if(!product.isEmpty() && !quantity.isEmpty() && !price.isEmpty() && !category.isEmpty()){
                try (Connection conn = DriverManager.getConnection(dbURL, USER, PASSWORD);
                     Statement insert = conn.createStatement();Statement select = conn.createStatement()){
                          String insertQuery="INSERT INTO product(P_Name,Quantity,Price,C_Name) VALUES ('"+product+"','"+quantity+"','"+price+"','"+category+"');";
                          insert.executeUpdate(insertQuery);
                          String selectQuery="Select * from product ;";
                          ResultSet rs = select.executeQuery(selectQuery);
                          if(rs.last()){
                              Object[] row=new Object[5];
                              row[0]=rs.getInt("P_ID");
                              row[1]=rs.getString("P_Name");
                              row[2]=rs.getString("Quantity");
                              row[3]=rs.getString("Price");
                              row[4]=rs.getString("C_Name");
                              product_model.addRow(row);
                           }
                           addproduct_tf.setText("");
                           addQuantity_tf.setText("");
                           addPrice_tf.setText("");

                        } catch (SQLException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }}else{
                    JOptionPane.showMessageDialog(this,"Fields are empty");
                }
            }
            else if(e.getSource()==customer){
                vopanel.setVisible(false);
                panel1.setVisible(false);
                categorypanel.setVisible(false);
                productpanel.setVisible(false);
                customerpanel.setVisible(true);
            }
            else if(e.getSource()==addcustomerbutton){
                String name=addcustomername_tf.getText();
                String email=addcustomeremail_tf.getText();
                String phone=addcustomerphone_tf.getText();
                String address=addcustomeradd_tf.getText();
                String dbURL = JDBC_URL + DB_NAME;
                if(!name.isEmpty() && !email.isEmpty() && !phone.isEmpty() && !address.isEmpty()){
                if(isvalidmail(email) ){
                    int size=phone.length();
                    if(size==10){
                    try (Connection conn = DriverManager.getConnection(dbURL, USER, PASSWORD);
                         Statement insert = conn.createStatement();Statement select = conn.createStatement()){
                         
                         String insertQuery="INSERT INTO customer(C_Name,PhoneNo,email,Address) VALUES ('"+name+"','"+phone+"','"+email+"','"+address+"');";
                              insert.executeUpdate(insertQuery);
                              String selectQuery="Select * from customer ;";
                              ResultSet rs = select.executeQuery(selectQuery);
                              if(rs.last()){
                                  Object[] row=new Object[5];
                                  row[0]=rs.getString("C_ID");
                                  row[1]=rs.getString("C_Name");
                                  row[2]=rs.getString("PhoneNo");
                                  row[3]=rs.getString("email");
                                  row[4]=rs.getString("Address");
                                  customer_model.addRow(row);
                               }
                               addcustomername_tf.setText("");
                               addcustomeremail_tf.setText("");
                               addcustomerphone_tf.setText("");
                               addcustomeradd_tf.setText("");  
                    }
                    catch (SQLException ex) {
                    Logger.getLogger(LandingPage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                  }
                    else{
                    JOptionPane.showMessageDialog(this,"Invalid Phone no");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(this,"Invalid email ");
                }}
                else{
                    JOptionPane.showMessageDialog(this,"Fields are empty");
                }
            }
            else if(e.getSource()==order){
                vopanel.setVisible(false);
                categorypanel.setVisible(false);
                productpanel.setVisible(false);
                customerpanel.setVisible(false);
                panel1.setVisible(true);
            }
            else if(e.getSource()==viewOrder){
                categorypanel.setVisible(false);
                productpanel.setVisible(false);
                customerpanel.setVisible(false);
                panel1.setVisible(false);
                vopanel.setVisible(true);
            }
            else if(e.getSource()==logout){
                frame.dispose();
                new Login();
            }
            else if(e.getSource()==Addtocart){
                try{
                    String productname=(String)addpro_cb1.getSelectedItem();
                    String catename=(String)addCate_cb1.getSelectedItem();
                    String newquantity=cusquantitytf.getText();
                    int quant=Integer.parseInt(newquantity);
                    String id=(String)addcus_cb1.getSelectedItem();
                    String custname=cusnametf.getText();
                    if(!productname.isEmpty() &&!catename.isEmpty() && !newquantity.isEmpty() && !id.isEmpty() && !custname.isEmpty()){
                        if(avilable(quant,productname)){
                            Object[] row=new Object[6];
                            row[0]=id;
                            row[1]=custname;
                            row[2]=catename;
                            row[3]=productname;
                            row[4]=quant;
                            try{
                                String dbURL = JDBC_URL + DB_NAME;
                                Connection conn = DriverManager.getConnection(dbURL, USER, PASSWORD);
                                Statement stmt = conn.createStatement();
                                ResultSet rs = stmt.executeQuery("SELECT * FROM product where P_Name='"+row[3]+"';");
                                while(rs.next()){
                                    row[5]=rs.getInt("Price"); 
                                }       
                            }
                            catch(Exception ex){
                                ex.printStackTrace();
                            }
                            order_model.addRow(row);
                        }
                        else{
                                int quanti=0;
                                try{
                                    String dbURL = JDBC_URL + DB_NAME;
                                    Connection conn = DriverManager.getConnection(dbURL, USER, PASSWORD);
                                    Statement stmt = conn.createStatement();
                                    ResultSet rs = stmt.executeQuery("SELECT * FROM product where P_Name='"+productname+"';");
                                    while(rs.next()){
                                        quanti=rs.getInt("Quantity"); 
                                    }  
                                }
                                catch(Exception ex){
                                    ex.printStackTrace();
                                }
                                JOptionPane.showMessageDialog(this,"We have "+quanti+" quantity in Stock");        
                        }
                            
                    }
                    else{
                        JOptionPane.showMessageDialog(this,"Empty fields");
                    }
                    int totalAmount = 0;
                    for (int rowIndex = 0; rowIndex < order_model.getRowCount(); rowIndex++) {
                        int quantity = (int) order_model.getValueAt(rowIndex, 4); // Quantity column index
                        int price = (int) order_model.getValueAt(rowIndex, 5); // Price column index
                        totalAmount += quantity * price; // Multiply and accumulate
                    }
                    totaltf.setText(String.valueOf(totalAmount));
                }
                catch(HeadlessException | NumberFormatException ex){
                    JOptionPane.showMessageDialog(this,"Empty fields");
                }
                
            }
            else if(e.getSource()==save){
                int price = 0;
                String productname=(String)addpro_cb1.getSelectedItem();
                String catename=(String)addCate_cb1.getSelectedItem();
                String newquantity=cusquantitytf.getText();
                int quant=Integer.parseInt(newquantity);
                String id=(String)addcus_cb1.getSelectedItem();
                int ID=Integer.parseInt(id);
                String custname=cusnametf.getText();
                try{
                        String dbURL = JDBC_URL + DB_NAME;
                        Connection conn = DriverManager.getConnection(dbURL, USER, PASSWORD);
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM product where P_Name='"+productname+"';");
                        while(rs.next()){
                            price=rs.getInt("Price"); 
                        }       
                }
                catch(Exception ex){
                                ex.printStackTrace();
                }
                insertOrder(productname,catename,quant,ID,custname,price);
                try{
                        for (int rowIndex = 0; rowIndex < order_model.getRowCount(); rowIndex++) {
                                String pro_name = (String)order_model.getValueAt(rowIndex,3); 
                                String dbURL = JDBC_URL + DB_NAME;
                                Connection conn = DriverManager.getConnection(dbURL, USER, PASSWORD);
                                Statement stmt = conn.createStatement();
                                String update="Update product set Quantity=Quantity-"+quant+" WHERE P_Name='"+pro_name+"';";
                                stmt.executeUpdate(update);
                        }
                }
                catch(Exception ex){
                                ex.printStackTrace();
                }
                JOptionPane.showMessageDialog(this,"Order Placed");
            }
            else if(e.getSource()==reset){
                addpro_cb1.setSelectedIndex(0);
                addCate_cb1.setSelectedIndex(0);
                cusquantitytf.setText("");
                addcus_cb1.setSelectedIndex(0);
                cusnametf.setText("");
                model.setRowCount(0); 
            }
    }
    
    public static void loaddata(DefaultTableModel product_model){
                product_model.setRowCount(0);
                product_model.addColumn("ID");
                product_model.addColumn("Product");
                product_model.addColumn("Quantity");
                product_model.addColumn("Price");
                product_model.addColumn("Category");
            // Database connection detail
                        String dbURL = JDBC_URL + DB_NAME;
                        try (Connection conn = DriverManager.getConnection(dbURL, USER, PASSWORD);
                         Statement stmt = conn.createStatement();
                         ResultSet rs = stmt.executeQuery("SELECT * FROM product")) {
                         
                        // Iterate through the result set and add rows to the table model
                        while (rs.next()) {
                            Object[] row=new Object[5];
                            row[0] = rs.getInt("P_ID");
                            row[1] = rs.getString("P_Name");
                            row[2] = rs.getInt("Quantity");
                            row[3] = rs.getFloat("Price");
                            row[4] = rs.getString("C_Name");

                            // Add row to the table model
                            product_model.addRow(row);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

    }

    public static void loadcategories(JComboBox<String> addCate_cb) {
                        String dbURL = JDBC_URL + DB_NAME;
                        try (Connection conn = DriverManager.getConnection(dbURL, USER, PASSWORD);
                         Statement stmt = conn.createStatement();
                         ResultSet rs = stmt.executeQuery("SELECT C_Name FROM category")) {
                         addCate_cb.removeAllItems();
                        // Iterate through the result set and add rows to the table model
                        while (rs.next()) {
                            addCate_cb.addItem(rs.getString("C_Name"));
                        }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
    }
    
    public static void loadcustomer(DefaultTableModel customer_model){
            customer_model.setRowCount(0);
            customer_model.addColumn("ID");
            customer_model.addColumn("Name");
            customer_model.addColumn("PhoneNo");
            customer_model.addColumn("Email");
            customer_model.addColumn("Address");
            // Database connection detail
                String dbURL = JDBC_URL + DB_NAME;
                        try (Connection conn = DriverManager.getConnection(dbURL, USER, PASSWORD);
                         Statement stmt = conn.createStatement();
                         ResultSet rs = stmt.executeQuery("SELECT * FROM customer;")) {
                         
                         while (rs.next()) {
                            Object[] row=new Object[5];
                            row[0] = rs.getString("C_ID");
                            row[1] = rs.getString("C_Name");
                            row[2] = rs.getString("PhoneNo");
                            row[3] = rs.getString("email");
                            row[4] = rs.getString("Address");

                            // Add row to the table model
                            customer_model.addRow(row);
                        }
                        
                        
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

    }

    private boolean isvalidmail(String email) {
                String emailRegex = "^[a-zA-Z0-9._%+-]+@gmail\\.com$";
                Pattern pattern = Pattern.compile(emailRegex);
                Matcher matcher = pattern.matcher(email);
                return matcher.matches();  
    }

    private void loadcate(DefaultTableModel model) {
                                
                model.setRowCount(0);
                model.setColumnCount(0); 

                model.addColumn("ID");
                model.addColumn("Name");

                String dbURL = JDBC_URL + DB_NAME;
                try (Connection conn = DriverManager.getConnection(dbURL, USER, PASSWORD);
                     Statement select = conn.createStatement()) {
                    String selectQuery = "SELECT * FROM category;";
                    ResultSet rs = select.executeQuery(selectQuery);
                    while (rs.next()) {
                        Object[] row = new Object[2];
                        row[0] = rs.getInt("C_ID");
                        row[1] = rs.getString("C_Name");
                        model.addRow(row);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    
    private void loadproducts(JComboBox<String> addpro_cb1) {
                        String dbURL = JDBC_URL + DB_NAME;
                        try (Connection conn = DriverManager.getConnection(dbURL, USER, PASSWORD);
                            Statement stmt = conn.createStatement();
                        ){
                           ResultSet rs = stmt.executeQuery("SELECT * FROM product;");
                           addpro_cb1.removeAllItems();
                           while (rs.next()) {
                               addpro_cb1.addItem(rs.getString("P_Name"));
                           }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
    }

    private void loadcus(JComboBox<String> addcus_cb1) {
                        String dbURL = JDBC_URL + DB_NAME;
                        try (Connection conn = DriverManager.getConnection(dbURL, USER, PASSWORD);
                            Statement stmt = conn.createStatement();
                        ){
                           ResultSet rs = stmt.executeQuery("SELECT * FROM customer;");
                           addcus_cb1.removeAllItems();
                           while (rs.next()) {
                               addcus_cb1.addItem(rs.getString("C_ID"));
                           }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
    }

    private String getCustomerName(String selectedId) {
        String customerName = "";
        String dbURL = JDBC_URL + DB_NAME;
        try (Connection conn = DriverManager.getConnection(dbURL, USER, PASSWORD);Statement stmt = conn.createStatement();) {
            ResultSet rs = stmt.executeQuery("SELECT C_Name FROM customer WHERE C_ID ='"+selectedId+"';");
            if (rs.next()) {
                customerName = rs.getString("C_Name");
            } else {
                customerName = "Not Found";
            }
        } catch (Exception e) {
            e.printStackTrace();
            customerName = "Error"; 
        }
        return customerName;
    }

    private void insertOrder(String productname, String catename, int quant, int id, String custname,int price) {
        try{
            String dbURL = JDBC_URL + DB_NAME;
            Connection conn = DriverManager.getConnection(dbURL, USER, PASSWORD);
            
            String sql = "INSERT INTO orders (id,product, quantity, price, category,timestamp,cust_name) VALUES (?,?, ?, ?, ?,NOW(),?);";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,id);
            stmt.setString(2,productname);
            stmt.setInt(3,quant);
            stmt.setInt(4,price);
            stmt.setString(5,catename);
            stmt.setString(6,custname);
            stmt.executeUpdate();
            System.out.println("Order inserted successfully.");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    private boolean avilable(int quant, String productname) {
        int quantity=0;
        try{
            String dbURL = JDBC_URL + DB_NAME;
            Connection conn = DriverManager.getConnection(dbURL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM product where P_Name='"+productname+"';");
            while(rs.next()){
                quantity=rs.getInt("Quantity"); 
            }  
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        if(quant<quantity){
            return true;
        }
        return false;
    }

    private void loadcart(DefaultTableModel vomodel) {
       try{
            String dbURL = JDBC_URL + DB_NAME;
            Connection conn = DriverManager.getConnection(dbURL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            String select ="Select * from orders;";
            ResultSet rs=stmt.executeQuery(select);
            while(rs.next()){
                Object[] row=new Object[6];
                row[0] = rs.getInt("id");
                row[1] = rs.getString("cust_name");
                row[2] = rs.getString("product");
                row[3] = rs.getString("category");
                row[4] = rs.getInt("price");    
                row[5]=rs.getTimestamp("timestamp");
                vomodel.addRow(row);
            }
          
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
