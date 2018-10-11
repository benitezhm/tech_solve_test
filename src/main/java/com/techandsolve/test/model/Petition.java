/**
 * 
 */
package com.techandsolve.test.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

/**
 * @author miguel
 *
 */
@Data
@Entity
public class Petition {
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getIdentification() {
		return identification;
	}

	public void setIdentification(int identification) {
		this.identification = identification;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	private @Id @GeneratedValue Long id;
	private int identification;
	private Date date = new Date();;
	
	protected Petition() { }
	
	public Petition(int identification) {
		this.identification = identification;
	}

}
