package com.jgal.web.crud.jpa.model;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
 
import org.hibernate.annotations.GenericGenerator;
 
 
@Entity
@Table( name = "users" )
public class User {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;
     
    @Column(name="first_name", length=255)
    private String firstName;
    @Column(name="last_name", length=255)
    private String lastName;
    @Column(length=2)
    private String age;
    @Column(length=1)
    private String gender;
     
    public User(){
         
    }
     
    public User(String firstName, String lastName, String age,
            String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }
     
     
    public Long getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getAge() {
        return age;
    }
    public String getGender() {
        return gender;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    public void setAge(String age) {
        this.age = age;
    }
 
    public void setGender(String gender) {
        this.gender = gender;
    }
     
}