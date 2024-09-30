package ProductOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductOperation {
    static Connection con=null;
    static Statement stmt=null;

    static {
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee","root","sql123");
            stmt= con.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addData(int id, String name, String category, double price, int qty){
        String insertQuery="insert into product values("+id+",'"+name+"','"+category+"',"+price+","+qty+")";
        try {
            int count =con.createStatement().executeUpdate(insertQuery);
            if (count>0){
                System.out.println(count+" Data Added Successfully....!");
            }else {
                System.out.println("something went wrong....!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteData(String name){
        String deleteQuery="delete from product where Product_Name='"+name+"'";
        try {
            int count=stmt.executeUpdate(deleteQuery);
            if (count>0){
                System.out.println("count+ Data Deleted Successfully....!");
            }else {
                System.out.println("Something Went Wrong....!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
