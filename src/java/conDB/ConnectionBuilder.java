/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conDB;
import java.sql.*;
/**
 *
 * @uthor Fame
 */
public class ConnectionBuilder {
   
    public static Connection getConnection(){
        Connection con = null;
        try{           
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://54.213.76.163:3306/seniorproject?useUnicode=true&characterEncoding=UTF-8","username","Forbisimo@08");
        }catch(ClassNotFoundException e){
            System.out.println(e);
          
        }catch(SQLException e){
            System.out.println(e);
          
        }
        return con;               
    }
    public static void main(String[] args) {
        Connection con = getConnection();
        
    }
    
    
}
