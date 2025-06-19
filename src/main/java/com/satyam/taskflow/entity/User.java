package com.satyam.taskflow.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(unique = true , nullable = false)
private String username;

@Column(nullable = false)
private String password;

@OneToMany(mappedBy = "user" , cascade = CascadeType.ALL , orphanRemoval = true)
private List<Task> tasks= new ArrayList<Task>();

public void addTask(Task t){
    tasks.add(t);
    t.setUser(this);
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public List<Task> getTasks() {
	return tasks;
}

}
