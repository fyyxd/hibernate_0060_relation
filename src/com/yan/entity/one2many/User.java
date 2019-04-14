package com.yan.entity.one2many;



/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User  implements java.io.Serializable {


    // Fields    

     private Long id;
     private Role role;
     private String userame;


    // Constructors

    /** default constructor */
    public User() {
    }

    
    /** full constructor */
    public User(Role role, String userame) {
        this.role = role;
        this.userame = userame;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return this.role;
    }
    
    public void setRole(Role role) {
        this.role = role;
    }

    public String getUserame() {
        return this.userame;
    }
    
    public void setUserame(String userame) {
        this.userame = userame;
    }
   








}