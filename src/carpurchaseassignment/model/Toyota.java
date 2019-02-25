/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carpurchaseassignment.model;

import carpurchaseassignment.util.Car;

 public class Toyota extends Car{
    public Toyota(final int carId,final String carModel,final int carPrice){
        this.id = carId;
        this.model = carModel;
        this.price = carPrice;
        
    }
    //overriding resale value for Toyota
    @Override
    public int resaleValue(){
        return (int) (0.8*getPrice());
    }    
}