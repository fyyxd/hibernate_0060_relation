package com.yan.extends1;



/**
 * Animal entity. @author MyEclipse Persistence Tools
 */

public class Animal  implements java.io.Serializable {


    // Fields    

     private Long id;
     private String name;


    // Constructors

    /** default constructor */
    public Animal() {
    }

    
    /** full constructor */
    public Animal(String name) {
        this.name = name;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
   








}