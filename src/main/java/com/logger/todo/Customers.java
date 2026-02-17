package com.logger.todo;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customers {
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

private int id;

private String name;

private String surname;

private String email;

private Timestamp created_at;

private Timestamp last_seen;




public void setId(int id){
    this.id=id;
}
public void setName(String name){
    this.name=name;
}
public void setEmail(String name){
    this.email=name;
}

public void setSurname(String name){
    this.surname=name;
}

public void setCreated(Timestamp t){
    this.created_at=t;
}

public void setLast(Timestamp t){
    this.last_seen=t;
}




public int getId(){
   return this.id;
}
public String getName(){
    return this.name;
}
public String getEmail(){
    return this.email;
}

public String getSurname(){
    return this.surname;
}

public Timestamp getCreated(){
    return this.created_at;
}

public Timestamp getLast(){
     return this.last_seen;
}



}
