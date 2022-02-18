package com.jaden.expenses.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@NotNull
    @Size(min = 1, max = 200, message = "Expense name must be between 1 - 200 characters.")
    private String name;

    @NotNull
    @Size(min = 1, max = 200, message = "Vendor must be between 1 - 200 characters.")
    private String vendor;
    
    @NotNull
    @Min(value=1, message = "Must be at least 1 dollar.")
    private Integer amount;
    
    @NotNull
    @Size(min = 5, max = 200, message = "Description must be between 5 - 200 characters.")
    private String description;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public Expense() {
    }
    
    public Expense(String name, String vendor, int amount, String description) {
        this.name = name;
        this.vendor = vendor;
        this.amount = amount;
        this.description = description;
    }
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

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

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
    
}

