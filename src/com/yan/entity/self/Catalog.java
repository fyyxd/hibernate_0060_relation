package com.yan.entity.self;

import java.util.HashSet;
import java.util.Set;


/**
 * Catalog entity. @author MyEclipse Persistence Tools
 */

public class Catalog  implements java.io.Serializable {


    // Fields    

     private Long id;
     private Catalog parent;
     private String title;
     private Set children = new HashSet(0);


    // Constructors

    /** default constructor */
    public Catalog() {
    }

	/** minimal constructor */
    public Catalog(String title) {
        this.title = title;
    }
    
    /** full constructor */
    public Catalog(Catalog parent, String title, Set children) {
        this.parent = parent;
        this.title = title;
        this.children = children;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public Catalog getParent() {
        return this.parent;
    }
    
    public void setParent(Catalog parent) {
        this.parent = parent;
    }

    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public Set getChildren() {
        return this.children;
    }
    
    public void setChildren(Set children) {
        this.children = children;
    }
   








}