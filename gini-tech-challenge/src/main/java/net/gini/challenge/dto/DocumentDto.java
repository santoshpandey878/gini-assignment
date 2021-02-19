package net.gini.challenge.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(description="All details about document.")
public class DocumentDto {

	private int id;
	private String type;
	private String serialNumber;
	private int pages;

	public DocumentDto() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

}
