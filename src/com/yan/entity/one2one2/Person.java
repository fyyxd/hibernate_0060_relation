package com.yan.entity.one2one2;



/**
 * Person entity. @author MyEclipse Persistence Tools
 */

public class Person  implements java.io.Serializable {


    // Fields    

     private Long id;
     private String username;
     private IdCard idCard;


    // Constructors

    /** default constructor */
    public Person() {
    }

    
    /** full constructor */
    public Person(String username, IdCard idCard) {
        this.username = username;
        this.idCard = idCard;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public IdCard getIdCard() {
        return this.idCard;
    }
    
    public void setIdCard(IdCard idCard) {
        this.idCard = idCard;
    }
   








}