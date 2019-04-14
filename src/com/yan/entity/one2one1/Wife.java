package com.yan.entity.one2one1;



/**
 * Wife entity. @author MyEclipse Persistence Tools
 */

public class Wife  implements java.io.Serializable {


    // Fields    

     private Long id;
     private Husband husband;
     private String name;


    // Constructors

    /** default constructor */
    public Wife() {
    }

    
    /** full constructor */
    public Wife(Husband husband, String name) {
        this.husband = husband;
        this.name = name;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public Husband getHusband() {
        return this.husband;
    }
    
    public void setHusband(Husband husband) {
        this.husband = husband;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
   








}