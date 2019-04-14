package com.yan.extends1;



/**
 * Dog entity. @author MyEclipse Persistence Tools
 */

public class Dog extends com.yan.extends1.Animal implements java.io.Serializable {


    // Fields    

     private String catalog;


    // Constructors

    /** default constructor */
    public Dog() {
    }

    
    /** full constructor */
    public Dog(String name, String catalog) {
        super(name);        
        this.catalog = catalog;
    }

   
    // Property accessors

    public String getCatalog() {
        return this.catalog;
    }
    
    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }
   








}