package com.yan.extend3;



/**
 * Jiaotong entity. @author MyEclipse Persistence Tools
 */

public class Jiaotong  implements java.io.Serializable {


    // Fields    

     private Long id;
     private String name;


    // Constructors

    /** default constructor */
    public Jiaotong() {
    }

    
    /** full constructor */
    public Jiaotong(String name) {
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