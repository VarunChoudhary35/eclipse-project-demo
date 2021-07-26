package com.maybank.pms.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;

@ConfigurationProperties("company")
@Controller
public class CompanyDetails {
	private String name;
	private String city;
	private String ceoName;
	public CompanyDetails() {
		// TODO Auto-generated constructor stub
	}
	public CompanyDetails(String name, String city, String ceoName) {
		super();
		this.name = name;
		this.city = city;
		this.ceoName = ceoName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCeoName() {
		return ceoName;
	}
	public void setCeoName(String ceoName) {
		this.ceoName = ceoName;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CompanyDetails [name=");
		builder.append(name);
		builder.append(", city=");
		builder.append(city);
		builder.append(", ceoName=");
		builder.append(ceoName);
		builder.append("]");
		return builder.toString();
	}
}