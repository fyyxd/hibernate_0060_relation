package com.yan.extend3;



/**
 * Jiaoche entity. @author MyEclipse Persistence Tools
 */

public class Jiaoche extends com.yan.extend3.Jiaotong implements java.io.Serializable {


    // Fields    

     private Integer zaike;


    // Constructors

    /** default constructor */
    public Jiaoche() {
    }

    
    /** full constructor */
    public Jiaoche(String name, Integer zaike) {
        super(name);        
        this.zaike = zaike;
    }

   
    // Property accessors

    public Integer getZaike() {
        return this.zaike;
    }
    
    public void setZaike(Integer zaike) {
        this.zaike = zaike;
    }
   








}