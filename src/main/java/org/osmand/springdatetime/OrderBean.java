package org.osmand.springdatetime;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class OrderBean {
	private long id;

	private int version;

	private String description;

	private String status;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date orderDate;

	public OrderBean(long id) {
	}

	protected OrderBean() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "OrderBean [id=" + id + ", version=" + version + ", description=" + description + ", status=" + status
				+ ", orderDate=" + orderDate + "]";
	}
	
	

}
