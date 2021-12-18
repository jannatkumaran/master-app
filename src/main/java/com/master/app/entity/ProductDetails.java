package com.master.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="product_details")
public class ProductDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "product_detail_id")
	@SequenceGenerator(name = "entitySeq", sequenceName = "SEQ_PRODUCT_DETAIL_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entitySeq")
	private Long productDetailId;
	
	@Column(name="product_price")
	private Double price;
	
	@Column(name="product_color")
	private String color;
	
	@Column(name="product_ram")
	private Integer ram;
	
	@Column(name="product_storage")
	private Integer storage;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product product;

	
	public Long getProductDetailId() {
		return productDetailId;
	}

	public void setProductDetailId(Long productDetailId) {
		this.productDetailId = productDetailId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getRam() {
		return ram;
	}

	public void setRam(Integer ram) {
		this.ram = ram;
	}

	public Integer getStorage() {
		return storage;
	}

	public void setStorage(Integer storage) {
		this.storage = storage;
	}

	public Product getPid() {
		return product;
	}

	public void setPid(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "ProductDetails [productDetailId=" + productDetailId + ", price=" + price + ", color=" + color + ", ram="
				+ ram + ", storage=" + storage + ", product=" + product + "]";
	}

	
	
	
	

}
