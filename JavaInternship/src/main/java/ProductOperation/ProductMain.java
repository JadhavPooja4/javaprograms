package ProductOperation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static ProductOperation.ProductOperation.stmt;

public class ProductMain {
    static Scanner sc=new Scanner(System.in);
    private static ProductOperation po=new ProductOperation();

    public static void main(String[]args){
        operations();
    }

    private static void operations(){
        boolean status=true;
        while (status){
            System.out.println("1.Add Product");
            System.out.println("2.Delete Product");
            System.out.println("3.Display Product");
            System.out.println("4.Update Product");
            System.out.println("5.Exit");

            int choice= sc.nextInt();
            switch (choice){
                case 1:
                    addProduct();
                    break;

                case 2:
                    deleteProduct();
                    break;

                case 3:
                    displayProduct();
                    break;

                case 4:
                    updateProduct();
                    break;

                case 5:
                    System.out.println("Thank You for visiting....");
                    status=false;
                    break;
            }
        }
    }

    private  static void addProduct(){
        System.out.println("Enter Product Id");
        int id=sc.nextInt();

        System.out.println("Enter Product Name");
        String name=sc.next();

        System.out.println("Enter Product Category");
        String category=sc.next();

        System.out.println("Enter Product Price");
        double price=sc.nextDouble();

        System.out.println("Enter Product Quantity");
        int qty=sc.nextInt();

        po.addData(id,name,category,price,qty);
    }

    private static void deleteProduct(){
        System.out.println("Enter product name");
        String name=sc.next();
        po.deleteData(name);
    }

    private static void displayProduct(){
        ResultSet rs=null;
        String displayQuery="select * from product";

        try {
            rs=stmt.executeQuery(displayQuery);
            while (rs.next()){
                System.out.println(rs.getInt(1)+"\t"+
                                    rs.getString(2)+"\t"+
                                    rs.getString(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void updateProduct(){
        System.out.println("Enter Product Id");
        int id=sc.nextInt();
        System.out.println("Enter Product price to Update");
        double price=sc.nextDouble();

        String updateQuery="update product set Product_Price="+price+"where Product_id="+id;

        try {
            int count =stmt.executeUpdate(updateQuery);
            if (count>0){
                System.out.println("Data Updated Successfully....!");
            }else {
                System.out.println("Data Not Found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
