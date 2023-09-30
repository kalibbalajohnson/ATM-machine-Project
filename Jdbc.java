
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.*;

public class Jdbc {

    public static void clearScreen() {

        System.out.println("\033[H\033[2J");
        System.out.flush();
        
    }
    
    public static void main(String[] args) {
        try {
            
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        String Url="jdbc:mysql://localhost/Bank";
        String password="Johnson11";
        String user="Johnson";
        Connection con = DriverManager.getConnection(Url,user,password);
        System.out.println("Database connection successfull");

      /*Statement stm = con.createStatement();
        String qry= "CREATE DATABASE jesa";
        stm.execute(qry);
        System.out.println("db created successfully");
    
    
        String createtblqry="CREATE TABLE jesa_Atm_Machine(ID INT PRIMARY KEY , First_Name VARCHAR(255) NOT NULL, Last_Name VARCHAR(255) NOT NULL, Account_Balance VARCHAR(255) NOT NULL)";
        stm.execute(createtblqry);
        System.out.println("table created successfully");*/

 String yo;
 String fini;
 String finito;


Scanner sc = new Scanner (System.in);

//----------------------------------AUTHENTICATION-------------------------------------------------------------------
System.out.println("WELCOME"+ "\n" + "Please insert your ID number");
String id = sc.nextLine();
clearScreen();

//-------------------------------- ----MENU--------------------------------------------------------------------------
System.out.println("Please choose what you intend to do below");
System.out.println("1.register" +"\n" + "2.Deposit" + "\n" + "3.Withdraw");
String one = sc.nextLine();
clearScreen();

switch (one) {
//-------------------------------------REGISTERING-------------------------------------------------------------------
    case "1":
    do{
        System.out.println(" PLEASE REGISTER BELOW"+"\n"+ "Enter your ID number");
    String ID11 =sc.next();
    System.out.println("Enter your first_name");
    String first_name=sc.next();
    System.out.println("Enter your last_name");
    String last_name=sc.next();
    System.out.println("Enter your Account balance");
    String amount=sc.next();
    
    System.out.println("Do you comfirm the above information");
    yo=sc.next();

    String insquery="insert into jesa_Atm_Machine (ID,First_name, Last_name, Account_Balance)" + "values (?,?,?,?)";
    PreparedStatement prep= con.prepareStatement(insquery);
    prep.setString(1, ID11 );
    prep.setString(2, first_name);
    prep.setString(3,last_name );
    prep.setString(4, amount);
    prep.execute();
    

    System.out.println("REGISTRATION INFORMATION");

}while(!yo.equalsIgnoreCase("yes")); 
clearScreen();
break;

//--------------------------------------DEPOSITING------------------------------------------------------------------
    case "2":                                                                                             
do{
    System.out.println("Please insert your ID NUMBER");
String ID2 = sc.nextLine();
int ID1 = Integer.parseInt(ID2);

    System.out.println("Please insert an amount you want to Deposit");
String deposit = sc.nextLine();

System.out.println("Do you want to complete transaction");
 fini = sc.nextLine();

 String dequery="UPDATE atm_machine SET Account_Balance = ? where ID=?";
 PreparedStatement prep1=con.prepareStatement(dequery);
 prep1.setString(1, deposit);
 prep1.setInt(2, ID1);
 prep1.executeUpdate();
 

System.out.println("Thank you! you have deposited UGX " + deposit + " on your account");
}while(!fini.equalsIgnoreCase("yes")); 

break;

//-------------------------------------WITHDRAWING-------------------------------------------------------------------
    case "3":
    do{
        System.out.println("Please insert ID number");
        String ID3 = sc.nextLine();
        int ID4 = Integer.parseInt(ID3);


        System.out.println("Please insert an amount you want to Withdraw");
    String withdraw = sc.nextLine();
   
    System.out.println("do you want to complete withdraw");
    finito = sc.nextLine();
    String wiquery="UPDATE users SET Account_Balance= ? where ID=?";
    PreparedStatement prep=con.prepareStatement(wiquery);
    prep.setString(1, withdraw);
    prep.setInt(2, ID4);
    prep.executeUpdate();


    System.out.println("You have withdrawn UGX " + withdraw+ " from your account");
    }while(!finito.equalsIgnoreCase("yes")); 
    
default:
 System.out.println("Make another command");

} 
}catch (Exception e) {
    System.out.println("error" + e.getMessage());;
}

 

    

}
}

