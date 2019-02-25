/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carpurchaseassignment;

/**
 *
 * @author saurabh.mishra@jungleworks.com
 */


import carpurchaseassignment.controller.Admin;
import carpurchaseassignment.util.Validate;
import java.util.ArrayList;

/**
 * 
 * 
 * Main Class is the first class to get executed.
 * The class aims at showing the menu to the user and redirect user to the desired function
 * case : ADD_NEW_CUSTOMER  add new customer after taking ID and NAME from user
 * case : ADD_CAR_TO_CUSTOMER add car to customer after taking ID of the user for which car is added
 * case : LIST-CUSTOMERS list all the customers with their details such as name/cars 
 * case : LIST_CUSTOMER list the customer details after taking the id of the customer
 * case : GENERATE_PRIZES generate Prizes with following logic
 * -------- Admin will input 3 Id of Users Valid/Invalid. System will generate 6 random Id of existing users if User count is greater than 6
 * --------else existing customers will be system generated Id
 * --------System will then print details of the user who will be common in system generated ID and 
 * 
 *
 */

public final class CarPurchaseAssignment {
    private static final int ADD_NEW_CUSTOMER = 1;
    private static final int ADD_CAR_TO_CUSTOMER = 2;
    private static final int LIST_CUSTOMERS = 3;
    private static final int LIST_CUSTOMER = 4;
    private static final int GENERATE_PRIZES = 5;
    
    /**
     * Main function Used with switch case for User input
     * 
     * Validate Class is Used for Validation
     * Switch cases have been used to handle various input cases
     * 
     *
     * 
     * @param args not Used
     * 
     */
    
    public static void main(String[] args){
        
        String RepeatMenu = "y";
        
        Admin admin = new Admin();
        while(RepeatMenu.equals("Y") || RepeatMenu.equals("y")){
            System.out.println("Welcome Admin Here are your Options");
            Validate validate = new Validate();
            
            System.out.println("1. Press 1 to add new Customer");
            System.out.println("2. Press 2 to add new Car to an Existing Customer");
            System.out.println("3. Press 3 to List all Customers with their cars Sorted by Name");
            System.out.println("4. Press 4 to List individual Customer based on ID");
            System.out.println("5. Press 5 to Generate prizes for the customer");
            int input = validate.readValidatedInt();
            switch(input){
            case ADD_NEW_CUSTOMER:
                System.out.println("Enter new UserId");
                int UserId = validate.readValidatedInt();
                System.out.println("Enter new User Name");
                String UserName = validate.readValidatedString();
                admin.addCustomer(UserId,UserName);
                break;
            case ADD_CAR_TO_CUSTOMER:
                System.out.println("Enter Id of the user");
                admin.addCarToUser(validate.readValidatedInt());
                break;
            case LIST_CUSTOMERS:
                admin.listCustomers();
                break;
            case LIST_CUSTOMER:
                System.out.println("Enter Id of the user");
                admin.listCustomer(validate.readValidatedInt());
                break;
            case GENERATE_PRIZES:
                System.out.println("Enter 3 random ids for prize selection");
                System.out.println("Enter First id");
                int firstId = validate.readValidatedInt();
                System.out.println("Enter Second id");
                int secondId = validate.readValidatedInt();
                System.out.println("Enter Third id");
                int thirdId = validate.readValidatedInt();
                ArrayList<Integer> adminId = new ArrayList<>();
                adminId.add(firstId);
                adminId.add(secondId);
                adminId.add(thirdId);
                admin.generatePrize(adminId);
                break;
            default:
                System.out.println("Invalid Input Want to go again (y/n) ?");
            }
            System.out.println("Repeat menu enter Y or any other character to exit !!");
        RepeatMenu = validate.readValidatedString();
        }
        
        
        
    }
}

