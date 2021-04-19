package com.howtodoinjava.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_EMPLOYEES")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="first_name")
    public String firstName;
    
    @Column(name="last_name")
    public String lastName;

    @Column(name="employment_id")
    public String eid;
    
    @Column(name="start_date")
    public String start_date;

    @Column(name="end_date")
    public String end_date;
 	
 	@Column(name="designation")
    public String designation;

    @Column(name="department")
    public String department;

    @Column(name="status")
    public String status;

    @Column(name="DOB")
    public String dob;

    @Column(name="reporting_mgr")
    public String reporting_mgr;

    @Column(name="gender")
    public char gender;

    @Column(name="blood_group")
    public String blood_group;

    @Column(name="address")
    public String address;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getEmploymentID() {
		return eid;
	}

	public void setEmploymentID(String eid) {
		this.eid = eid;
	}

	public String getStartDate() {
		return start_date;
	}

	public void setStartDate(String start_date) {
		this.start_date = start_date;
	}

	public String getEndDate() {
		return end_date;
	}

	public void setEndDate(String end_date) {
		this.end_date = end_date;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDOB() {
		return dob;
	}

	public void setDOB(String dob) {
		this.dob = dob;
	}

	public String getReportingMgr() {
		return reporting_mgr;
	}

	public void setReportingMgr(String reporting_mgr) {
		this.reporting_mgr = reporting_mgr;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getBloodGroup() {
		return blood_group;
	}

	public void setBloodGroup(String blood_group) {
		this.blood_group = blood_group;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

    @Override
    public String toString() {
        return "EmployeeEntity [id=" + id + ", firstName=" + firstName + 
                ", lastName=" + lastName + ", eid=" + eid   + 
                ", start_date=" + start_date + ", end_date=" + end_date +
                 ", designation=" + designation + ", department=" + department + 
                 ", status=" + status + ", dob=" + dob + ", reporting_mgr=" + reporting_mgr + 
                 ", gender=" + gender + ", blood_group=" + blood_group + 
                 ", address=" + address + "]";
    }
}