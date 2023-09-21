package com.amdocs.CargoManagementSystem.entity;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "CARGO")
public class Cargo {

	@Id
	@Column(name = "CNO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cno;
	@Column(name = "NAME")
	private String name;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PHNO")
	private Long phno;
	
	@OneToMany(mappedBy = "cargo", cascade = CascadeType.ALL)
    private Set<Truck> truck = new HashSet<>();
	
	public Integer getCno() {
		return cno;
	}
	public void setCno(Integer cno) {
		this.cno = cno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhno() {
		return phno;
	}
	public void setPhno(Long phno) {
		this.phno = phno;
	}
	

	public Cargo(Integer cno, String name, String email, Long phno) {
		super();
		this.cno = cno;
		this.name = name;
		this.email = email;
		this.phno = phno;
		
	}
	public Cargo() {
		super();
	}
	
}
