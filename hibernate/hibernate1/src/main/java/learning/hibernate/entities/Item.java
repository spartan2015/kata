package learning.hibernate.entities;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.stat.CategorizedStatistics;

@Entity
@Table(name="item")
public class Item {
	Long id;
	String name;
	String description;
	BigDecimal initialPrice;
	BigDecimal reservePrice;
	Date startDate;
	Date endDate;
	Date approvalDatetime;
	
	Set<Category> cateogries;
		
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getInitialPrice() {
		return initialPrice;
	}
	public void setInitialPrice(BigDecimal initialPrice) {
		this.initialPrice = initialPrice;
	}
	public BigDecimal getReservePrice() {
		return reservePrice;
	}
	public void setReservePrice(BigDecimal reservePrice) {
		this.reservePrice = reservePrice;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getApprovalDatetime() {		
		return approvalDatetime;
	
	}
	public void setApprovalDatetime(Date approvalDatetime) {
		this.approvalDatetime = approvalDatetime;
	}
	public Set<Category> getCateogries() {
		return Collections.unmodifiableSet(cateogries); //!!!!!
	}
	public void setCateogries(Set<Category> cateogries) {
		this.cateogries = cateogries;
	}	
	public void addCategory(Category c){
		// both sides here - the node graph - replace all references in the node graph
		//1. this object side
		this.cateogries.add(c);
		//2. the other object side
		c.getItems().add(this);
	}
}
