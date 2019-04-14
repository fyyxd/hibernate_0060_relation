package com.yan.entity.one2one1;



/**
 * Husband entity. @author MyEclipse Persistence Tools
 */

public class Husband  implements java.io.Serializable {


    // Fields    

     private Long id;
     private String name;
     private Wife wife;


    // Constructors

    /** default constructor */
    public Husband() {
    }

	/** minimal constructor */
    public Husband(String name) {
        this.name = name;
    }
    
    /** full constructor */
    public Husband(String name, Wife wife) {
        this.name = name;
        this.wife = wife;
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

    public Wife getWife() {
        return this.wife;
    }
    
    public void setWife(Wife wife) {
        this.wife = wife;
    }
   








}