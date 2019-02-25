
package carpurchaseassignment.util;

/**
 *
 * @author saurbh.mishra@jungleworks.com
 *
 * This is an abstract class which defines the structure of a class
 * in this class every car will have int id,String model and int price
 * an abstract method resaleValue() which will be override by every Car
 * 
 */
public abstract class Car{
    public int id;
    public String model;
    public int price;
    
    public int getId(){
        return id;
    }
    public String getModel(){
        return model;
    }
    public int getPrice(){
        return price;
    }
    
    public abstract int resaleValue();
}

/**
 * 
 *car hyundai, toyota and maruti will extend Car class and override ResaleValue
 * Hyundai will have a resale value of 40% of the price
 * Maruti will have a resale value of 60% of the total price
 * Toyota will have a resale value of 80% of the total price
 * 
 */


