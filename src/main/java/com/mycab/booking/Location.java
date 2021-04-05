package com.mycab.booking;

public class Location {
	private Integer locationId;
	private String vehiclelNo;
	private String vehiclelCategory;
	private String available;
	private String driverContactNo;
	
	public Location(Integer locationId, String vehiclelNo, String vehiclelCategory, String available,
			String driverContactNo) {
		super();
		this.locationId = locationId;
		this.vehiclelNo = vehiclelNo;
		this.vehiclelCategory = vehiclelCategory;
		this.available = available;
		this.driverContactNo = driverContactNo;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public String getVehiclelNo() {
		return vehiclelNo;
	}

	public String getVehiclelCategory() {
		return vehiclelCategory;
	}
	
	public boolean isCar() {
		return "car".equalsIgnoreCase(getVehiclelCategory());
	}
	
	public boolean isBike() {
		return "bike".equalsIgnoreCase(getVehiclelCategory());
	}
	
	public boolean isAuto() {
		return "auto".equalsIgnoreCase(getVehiclelCategory());
	}

	public boolean isAvailable() {
		return "YES".equalsIgnoreCase(available);
	}

	public String getDriverContactNo() {
		return driverContactNo;
	}

	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", vehiclelNo=" + vehiclelNo + ", vehiclelCategory="
				+ vehiclelCategory + ", available=" + available + ", driverContactNo=" + driverContactNo + "]";
	}
	
	
	
}
