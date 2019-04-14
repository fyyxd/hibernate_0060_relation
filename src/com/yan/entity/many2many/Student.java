package com.yan.entity.many2many;

import java.util.HashSet;
import java.util.Set;


public class Student  implements java.io.Serializable {


    // Fields    

     private Long id;
     private String name;
     private Set courses = new HashSet(0);


    // Constructors

    /** default constructor */
    public Student() {
    }

    
    /** full constructor */
    public Student(String name, Set courses) {
        this.name = name;
        this.courses = courses;
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

    public Set getCourses() {
        return this.courses;
    }
    
    public void setCourses(Set courses) {
        this.courses = courses;
    }
   








}