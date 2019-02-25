
package carpurchaseassignment.controller;

/**
 *
 * @author saurbh.mishra@jungleworks.com
 */


import carpurchaseassignment.model.Customer;
import carpurchaseassignment.util.Car;
import carpurchaseassignment.model.Hyundai;
import carpurchaseassignment.model.Maruti;
import carpurchaseassignment.model.Toyota;
import carpurchaseassignment.util.Validate;
import java.util.ArrayList;
import java.util.Collections;

import java.util.Comparator;

/**
 * 
 * class Admin have 5 tasks to perform 
 * Add new Customer, 
 * Add new Car to an existing Customer, 
 * List all Customers with their cars sorted by name, 
 * List individual Customer based on ID, 
 * Generate prizes for the customer.
 * 
 * 
 */


public final class Admin{
    ArrayList<Customer> customerList;
    private final static int HYUNDAI = 1;
    private final static int TOYOTA = 2;
    private final static int MARUTI = 3;
    private final static int RANDOM_SELECTION_COUNT = 6;
    private int USER_AVAILABLE = 0;
    
    
   public  Admin() {
        this.customerList = new ArrayList<>();
    }
    
    /**
     * 
     * Method addCustomer add new Customer to arraylist<> customerList
     * 
     * {@link customerList} for Storing and retrieving Customers
     * 
     * @param Id int This is input id of the user
     * @param Name String This is input Name of the user
     * 
     */
    public void addCustomer(final int Id,final String Name){
        int CUSTOMER_COUNT =0;
        for (Customer customerlist : customerList) {
            if (customerlist.getId() == Id) {
                CUSTOMER_COUNT++;
                break;
            }
        }
        if(CUSTOMER_COUNT >0){
            System.out.println("User Already Exists with this Id. Please try another Id");
        }
        else{
            Customer customer = new Customer(Id,Name);
            customerList.add(customer);
            System.out.println("Customer Added Successfully");
        }
        System.out.println(" --------------------------------- ");
    }
    /**
     * 
     * Method listCustomer list all Customers from arraylist<> customerList
     * Method listCustomer calls function userDetail for every user and returns user details with cars he owns
     * 
     * {@link userDetail} for displaying Customer details
     * 
     * 
     */
    public void listCustomers(){
        Comparator<Customer> comparator = (Customer aCustomer, Customer bCustomer) 
                -> aCustomer.getName().compareTo(bCustomer.getName());
        Collections.sort(customerList,comparator);
        customerList.stream().forEach((customerlist) -> {
            userDetail(customerlist.getId());
        });
    }
    
    /**
     * 
    * Method listCustomer displays check if the user exists with this id and then displays the details
    * using the function userDetails()
    * 
    * {@link userDetail} for displaying Customer details
    * 
    * @param Id int This is input id of the user
    * 
    * 
    */
    public void listCustomer(final int Id){
        customerList.stream().filter((customerList1) -> (customerList1.getId() == Id)).forEach((_item) -> {
            USER_AVAILABLE++;
        });
        if(USER_AVAILABLE > 0){
            System.out.println("User Found with details as :");
            userDetail(Id);
        }
        else{
            System.out.println("User Not Found !!!");
        }
        USER_AVAILABLE = 0;
    }
    
    /**
     * 
    * Method userDetails displays all the details of the user with the cars he/she owns
    * 
    * {@link customerList<>} for retrieving Customer details
    * 
    * @param Id int This is input id of the user
    * 
    */
    public void userDetail(final int Id){
        
        System.out.println("UserId"+"  "+"UserName");
        customerList.stream().forEach((Customer customer) -> {
            if(customer.getId() == Id){
                System.out.println(customer.getId()+" ->  "+customer.getName());
                if(customer.getUserCars().size()>0){
                    System.out.println("CarId"+" "+"CarModel"+" "+"CarPrice"+" "+"CarResaleValue");
                    customer.getUserCars().stream().forEach((userCar) -> {
                    System.out.println(userCar.id+"  "+userCar.model+"  "+userCar.price+"      "+userCar.resaleValue());
                    });
                }
                
            }
            
        });
        System.out.println(" --------------------------------- ");
    }
    /**
    * Method AddCarToUser add new car to the user based on the id
    * Method reads various input from the user 
    * input from user during runtime will be the details of car
    * 
    * {@link addCarToUser } for retrieving Customer details
    *
    * @param Id int This is input id of the user
    * 
    */
    public void addCarToUser(final int Id){
        
        customerList.stream().forEach((customerlist) -> {
            if(customerlist.getId() == Id){
                USER_AVAILABLE++;
                System.out.println("User Found with the give Id");
                Validate validate = new Validate();
                
                ArrayList<Car> UserCars = customerlist.getUserCars();
                System.out.println("Enter Car details :");
                System.out.println("Enter Car Id");
                int carId = validate.readValidatedInt();
                System.out.println("Enter Car Model");
                String carModel = validate.readValidatedString();
                System.out.println("Enter Car Price");
                int carPrice = validate.readValidatedInt();
                System.out.println("Enter Car Type:");
                System.out.println("Enter 1 for Hyundai ");
                System.out.println("Enter 2 for Toyota:");
                System.out.println("Enter 3 for Maruti:");
                int CarType = validate.readValidatedInt();
                switch(CarType){
                    case HYUNDAI:
                        Car hyundaiCar = new Hyundai(carId,carModel,carPrice);
                        hyundaiCar.resaleValue();
                        UserCars.add(hyundaiCar); 
                        System.out.println("Hyundai car added successfully");
                        break;
                    case TOYOTA:
                        Car toyotaCar = new Toyota(carId,carModel,carPrice);
                        toyotaCar.resaleValue();
                        UserCars.add(toyotaCar); 
                        System.out.println("Toyota car added successfully");
                        break;
                    case MARUTI:
                        Car marutiCar = new Maruti(carId,carModel,carPrice);
                        
                        marutiCar.resaleValue();
                        UserCars.add(marutiCar); 
                        System.out.println("Maruti car added successfully");
                        break;
                    default:
                        System.out.println("Invalid Input. Please try again");
                }

            }

            
        });
        if(USER_AVAILABLE == 0){
            System.out.println("User Does not exist");
        }
        USER_AVAILABLE =0;
        System.out.println(" --------------------------------- ");
        
    }
    
    /**
     * 
     * Method GeneratePrize generates the prizes to the user
     * 
     * {@link userDetails(int) } for displaying Customer details
     * 
     * @param adminList ArrayList<Integer> This is the input which has three Id's entered by the admin
     * 
     */
    
    public void generatePrize(final ArrayList<Integer> adminList){
        
        ArrayList<Customer> customers = customerList;
        ArrayList<Integer> newRandomElements =new ArrayList<>();
        Collections.shuffle(customers);
        System.out.println(" The winners for this contest are : ");
        if(customers.size() <= RANDOM_SELECTION_COUNT){
            customers.stream().forEach((customer) -> {
            newRandomElements.add(customer.getId());
            });
            newRandomElements.retainAll(adminList);
            newRandomElements.stream().forEach((randomElements) -> {
            userDetail(randomElements);
            });
        }
        else{
            for(int i=0;i < RANDOM_SELECTION_COUNT;i++){
                newRandomElements.add(customers.get(i).getId());
            }
            newRandomElements.retainAll(adminList);
            newRandomElements.stream().forEach((sixElements) -> {
            userDetail(sixElements);
            });
        }
        System.out.println(" --------------------------------- ");
    }
}