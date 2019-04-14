package com.yan.extends1;



/**
 * Cat entity. @author MyEclipse Persistence Tools
 */

public class Cat extends com.yan.extends1.Animal implements java.io.Serializable {


    // Fields    

     private String color;


    // Constructors

    /** default constructor */
    public Cat() {
    }

    
    /** full constructor */
    public Cat(String name, String color) {
        super(name);        
        this.color = color;
    }

   
    // Property accessors

    public String getColor() {
        return this.color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
   








}