package com.yan.extend2;

import java.math.BigDecimal;


/**
 * Man entity. @author MyEclipse Persistence Tools
 */

public abstract class Man  implements java.io.Serializable {


    // Fields    

     private BigDecimal id;
     private String name;


    // Constructors

    /** default constructor */
    public Man() {
    }

    
    /** full constructor */
    public Man(String name) {
        this.name = name;
    }

   
    // Property accessors

    public BigDecimal getId() {
        return this.id;
    }
    
    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
   








}