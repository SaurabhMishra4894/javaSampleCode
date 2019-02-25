/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carpurchaseassignment.model;

import carpurchaseassignment.util.Car;

public class Maruti extends Car{
    public Maruti(final int carId,final String carModel,final int carPrice){
        this.id = carId;
        this.model = carModel;
        this.price = carPrice;
        
    }
    //Overriding resale value for Maruti
    @Override
    public int resaleValue(){
        return (int) (0.6*getPrice());
    }    
}
