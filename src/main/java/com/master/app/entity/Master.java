package com.master.app.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author kumaresan.k
 *
 */
@Entity
@Table(name = "master_product_config")
public class Master implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "product_master_id")
	@SequenceGenerator(name = "entitySeq", sequenceName = "SEQ_PRODUCT_MASTER_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entitySeq")
	private Long id;

	@Column(name = "product_brand_name")
	private String name;

	@Column(name = "status")
	private String status;

	@Temporal(TemporalType.DATE)
	@Column(name = "date")
	private Date date;
	
	@OneToMany(mappedBy = "master", fetch = FetchType.LAZY, targetEntity = Product.class, cascade = CascadeType.ALL)
	private List<Product> product;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Master [id=" + id + ", name=" + name + ", status=" + status + ", date=" + date + "]";
	}

	
}
