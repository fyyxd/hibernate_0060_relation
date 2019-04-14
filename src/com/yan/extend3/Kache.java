package com.yan.extend3;



/**
 * Kache entity. @author MyEclipse Persistence Tools
 */

public class Kache extends com.yan.extend3.Jiaotong implements java.io.Serializable {


    // Fields    

     private Double zaizhong;


    // Constructors

    /** default constructor */
    public Kache() {
    }

    
    /** full constructor */
    public Kache(String name, Double zaizhong) {
        super(name);        
        this.zaizhong = zaizhong;
    }

   
    // Property accessors

    public Double getZaizhong() {
        return this.zaizhong;
    }
    
    public void setZaizhong(Double zaizhong) {
        this.zaizhong = zaizhong;
    }
   








}