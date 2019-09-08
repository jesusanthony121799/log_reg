
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Acer Aspire E 15
 */
public class register_class {
 connections cn = new connections();
 
 public int addprofile(String firstname,String lastname, String username,String password,String cpass){
     int x=0;
try{
        Class.forName(cn.driver);
        Connection con = DriverManager.getConnection(cn.local,cn.ps,cn.sr);
        PreparedStatement st = con.prepareStatement("Insert into bsit23 values (null,?,?,?,md5(?))");
        st.setString(1, firstname);
        st.setString(2, lastname);
        st.setString(3, username);
        st.setString(4, password);
        x = st.executeUpdate(); 
        
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(connections.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(connections.class.getName()).log(Level.SEVERE, null, ex);
    }return x; 
}
public int confirmPassword(String pass, String newpass){
    int r = 0;

    if(pass.equals(newpass)){
     r=1;   
    }else{
     r=0;  
    }
   return r;
}
 
 public int checkUsername(String username){
     int x = 0;
     try {
         Class.forName(cn.driver);
         Connection con = DriverManager.getConnection(cn.local,cn.ps,cn.sr);
         PreparedStatement pre = con.prepareStatement("Select * from bsit23 where username = ?");
         pre.setString(1, username);
         ResultSet rs = pre.executeQuery();
         if(rs.next()){
         x = 1;
         }else{
         x = 0 ;   
         }
     } catch (ClassNotFoundException ex) {
         Logger.getLogger(register_class.class.getName()).log(Level.SEVERE, null, ex);
     } catch (SQLException ex) {
         Logger.getLogger(register_class.class.getName()).log(Level.SEVERE, null, ex);
     }return x;
 }
 public int login(String username,String passW){
     int x = 0;
     try {
         Class.forName(cn.driver);
         Connection con = DriverManager.getConnection(cn.local,cn.ps,cn.sr);
         PreparedStatement pre = con.prepareStatement("Select * from bsit23 where username = ? and password = md5(?)");
         pre.setString(1, username);
         pre.setString(2, passW);
         ResultSet rs = pre.executeQuery();
         if(rs.next()){
         x = 1;
         }else{
         x = 0 ;   
         }
     } catch (ClassNotFoundException ex) {
         Logger.getLogger(register_class.class.getName()).log(Level.SEVERE, null, ex);
     } catch (SQLException ex) {
         Logger.getLogger(register_class.class.getName()).log(Level.SEVERE, null, ex);
     }return x;
 }

}
