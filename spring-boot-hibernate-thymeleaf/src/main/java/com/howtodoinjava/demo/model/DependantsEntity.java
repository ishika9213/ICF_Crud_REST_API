package com.howtodoinjava.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_DEPENDANTS")
public class DependantsEntity {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @Column(name="employee_id")
    public long eid;

    @Column(name="first_name")
    public String firstName;
    
    @Column(name="last_name")
    public String lastName;
   
    @Column(name="gender")
    public char gender;

    @Column(name="DOB")
    public String dob;

    @Column(name="relationship")
    public String relationship;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public long getEid() {
		return eid;
	}

	public void setEid(long eid) {
		this.eid = eid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getDOB() {
		return dob;
	}

	public void setDOB(String dob) {
		this.dob = dob;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}


    @Override
    public String toString() {
        return "DependantsEntity [employee_id=" + eid +
        	",firstName=" + firstName + 
        	", lastName=" + lastName + 
        	", gender=" + gender + 
        	", DOB=" + dob + 
        	", relationship=" + relationship + "]";
    }
}