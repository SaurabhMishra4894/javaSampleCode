
package carpurchaseassignment.model;

/**
 *
 * @author saurabh.mishra@jungleworks.com
 */


import carpurchaseassignment.util.Car;
import java.util.ArrayList;

/**
 * Class customer defines the properties of the customer.
 * Customer will have an id ,name and list of car.
 * 
 
 * listOfCars while creating user will be empty later on user can add car
 * 
 */
public final class Customer{
    private final int Id;
    private final String Name;
    private final ArrayList<Car> listOfCars;

 /**
  * 
  * Customer constructor to get values of Id and Name
  * 
  * @param Id int The id of the user
  * @param Name String The name of the user
  * 
  * 
  */
    public Customer(final int Id,final String Name) {
        this.Id = Id;
        this.Name = Name;
        this.listOfCars = new ArrayList<>();
    }
    public int getId(){
        return Id;
    }
    public String getName(){
        return Name;
    }
    public ArrayList<Car> getUserCars(){
        return listOfCars;
    }
    
    
    
}
