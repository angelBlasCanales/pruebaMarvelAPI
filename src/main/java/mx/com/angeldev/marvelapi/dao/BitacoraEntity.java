package mx.com.angeldev.marvelapi.dao;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class BitacoraEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfConsult;
	
	private String serviceConsulted;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateOfConsult() {
		return dateOfConsult;
	}

	public void setDateOfConsult(Date dateOfConsult) {
		this.dateOfConsult = dateOfConsult;
	}

	public String getServiceConsulted() {
		return serviceConsulted;
	}

	public void setServiceConsulted(String serviceConsulted) {
		this.serviceConsulted = serviceConsulted;
	}

}
