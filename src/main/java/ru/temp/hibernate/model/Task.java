package ru.temp.hibernate.model;

import javax.persistence.*;

@Entity
@Table(name="task")
public class Task {

	int id;
	String name;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Task() {
	}
}
