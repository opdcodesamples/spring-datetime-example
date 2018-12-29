package org.osmand.springdatetime;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	private long id;

	@Version
	private int version;

	private String description;

	private String status;
	
	// don't do anything in entity
	private Timestamp orderDate;

	public Order(long id) {
	}

	protected Order() {
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

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", version=" + version + ", description=" + description + ", status=" + status
				+ ", orderDate=" + orderDate + "]";
	}
	
	
}
