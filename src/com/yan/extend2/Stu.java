package com.yan.extend2;



/**
 * Stu entity. @author MyEclipse Persistence Tools
 */

public class Stu extends com.yan.extend2.Man implements java.io.Serializable {


    // Fields    

     private Double score;


    // Constructors

    /** default constructor */
    public Stu() {
    }

    
    /** full constructor */
    public Stu(String name, Double score) {
        super(name);        
        this.score = score;
    }

   
    // Property accessors

    public Double getScore() {
        return this.score;
    }
    
    public void setScore(Double score) {
        this.score = score;
    }
   








}