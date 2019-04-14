package com.yan.entity.many2many;

import java.util.HashSet;
import java.util.Set;


/**
 * Course entity. @author MyEclipse Persistence Tools
 */

public class Course  implements java.io.Serializable {


    // Fields    

     private Long id;
     private String title;
     private Set students = new HashSet(0);


    // Constructors

    /** default constructor */
    public Course() {
    }

    
    /** full constructor */
    public Course(String title, Set students) {
        this.title = title;
        this.students = students;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public Set getStudents() {
        return this.students;
    }
    
    public void setStudents(Set students) {
        this.students = students;
    }
   








}