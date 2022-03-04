package com.jaden.quickpantry.models;

public class Nutrient {
    
    private String name;
	
    private Integer amount;
	
    private String unit;
    
    private Double percentOfDailyNeeds;

    public Nutrient() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Double getPercentOfDailyNeeds() {
		return percentOfDailyNeeds;
	}

	public void setPercentOfDailyNeeds(Double percentOfDailyNeeds) {
		this.percentOfDailyNeeds = percentOfDailyNeeds;
	}

}

