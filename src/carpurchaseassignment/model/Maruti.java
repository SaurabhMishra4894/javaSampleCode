
package carpurchaseassignment.model;

import carpurchaseassignment.util.Car;

public class Maruti extends Car{
    
    /**
     * 
     * Maruti constructor which will get values while Initializing
     * 
     * @param carId int value as CarId
     * @param carModel String value for CarModel
     * @param carPrice int value for carPrice
     * 
     */
    
    public Maruti(final int carId,final String carModel,final int carPrice){
        this.id = carId;
        this.model = carModel;
        this.price = carPrice;
        
    }
    //Overriding resale value for Maruti as 60 % of Price
    @Override
    public int resaleValue(){
        return (int) (0.6*getPrice());
    }    
}
