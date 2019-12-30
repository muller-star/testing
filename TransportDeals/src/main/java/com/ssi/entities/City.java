package com.ssi.entities;

@Entity
public class City {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cityCode;
	private String cityname;
	private String state;
	public int getCityCode() {
		return cityCode;
	}
	public void setCityCode(int cityCode) {
		this.cityCode = cityCode;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
