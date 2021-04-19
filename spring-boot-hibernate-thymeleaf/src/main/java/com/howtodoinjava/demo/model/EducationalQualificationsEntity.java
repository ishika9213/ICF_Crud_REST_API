package com.howtodoinjava.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_EDUCATIONAL_QUALIFICATIONS")
public class EducationalQualificationsEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name="employee_id")
    public long eid;
    
    @Column(name="type")
    public String type;
    
    @Column(name="start_date")
    public String start_date;
   
    @Column(name="end_date")
    public String end_date;

    @Column(name="Institution")
    public String institution;

    @Column(name="address")
    public String address;

    @Column(name="percentage")
    public double percentage;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

    @Override
    public String toString() {
        return "EducationalQualificationsEntity [employee_id=" + eid +
        	",type=" + type +  
            ", start_date=" + start_date + 
            ", end_date=" + end_date +
            ", institution=" + institution + 
            ", address=" + address + 
            ", percentage=" + percentage + "]";
    }
}