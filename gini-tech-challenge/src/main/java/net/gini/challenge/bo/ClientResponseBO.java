package net.gini.challenge.bo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientResponseBO {

	public ClientResponseBO() {}

	@JsonProperty("PROCESSING_STATUS")
	private String processingStatus;

	@JsonProperty("INVOICE_ID")
	private String invoiceId;

	public String getProcessingStatus() {
		return processingStatus;
	}

	public void setProcessingStatus(String processingStatus) {
		this.processingStatus = processingStatus;
	}

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}


}
