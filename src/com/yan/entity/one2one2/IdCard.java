package com.yan.entity.one2one2;



/**
 * IdCard entity. @author MyEclipse Persistence Tools
 */

public class IdCard  implements java.io.Serializable {


    // Fields    

     private Long id;
     private Person person;
     private String cardNo;


    // Constructors

    /** default constructor */
    public IdCard() {
    }

	/** minimal constructor */
    public IdCard(Person person) {
        this.person = person;
    }
    
    /** full constructor */
    public IdCard(Person person, String cardNo) {
        this.person = person;
        this.cardNo = cardNo;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return this.person;
    }
    
    public void setPerson(Person person) {
        this.person = person;
    }

    public String getCardNo() {
        return this.cardNo;
    }
    
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
   








}