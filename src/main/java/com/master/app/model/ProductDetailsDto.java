package com.master.app.model;

import java.io.Serializable;

public class ProductDetailsDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long productDetailId;
	private Double price;
	private String color;
	private Integer ram;
	private Integer storage;
	
	private Long pid;

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

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	@Override
	public String toString() {
		return "ProductDetails [productDetailId=" + productDetailId + ", price=" + price + ", color=" + color + ", ram="
				+ ram + ", storage=" + storage + ", pid=" + pid + "]";
	}

	
	
	
	

}
