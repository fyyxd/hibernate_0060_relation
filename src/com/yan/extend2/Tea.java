package com.yan.extend2;



/**
 * Tea entity. @author MyEclipse Persistence Tools
 */

public class Tea extends com.yan.extend2.Man implements java.io.Serializable {


    // Fields    

     private Double salary;


    // Constructors

    /** default constructor */
    public Tea() {
    }

    
    /** full constructor */
    public Tea(String name, Double salary) {
        super(name);        
        this.salary = salary;
    }

   
    // Property accessors

    public Double getSalary() {
        return this.salary;
    }
    
    public void setSalary(Double salary) {
        this.salary = salary;
    }
   








}