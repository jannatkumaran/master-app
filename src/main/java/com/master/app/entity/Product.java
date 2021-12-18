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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="product")
public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "product_id")
	@SequenceGenerator(name = "entitySeq", sequenceName = "SEQ_PRODUCT_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entitySeq")
	private Long productId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="status")
	private String status;
	
	@Column(name="date")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_master_id")
	private Master master;
	 
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY, targetEntity = ProductDetails.class, cascade = CascadeType.ALL)
	private List<ProductDetails> productDetails;

	
	
	
	

}
