package net.gini.challenge.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import net.gini.challenge.bo.ClientResponseBO;
import net.gini.challenge.core.utils.JsonToJavaUtil;
import net.gini.challenge.entity.Document;
import net.gini.challenge.service.DocumentSchedulerService;
import net.gini.challenge.service.DocumentService;

@Service
@EnableAsync
public class DocumentSchedulerServiceImpl implements DocumentSchedulerService {

	@Value("${client.api.uri}")
	private String apiURL;
	private static final String PROCESSING_STATUS_OK = "OK";
	private static final String PARAM_DELIMITER = "/";

	private final DocumentService documentService;
	private final RestTemplate restTemplate;
	private final DocumentSchedulerService documentSchedulerService;

	@Autowired
	public DocumentSchedulerServiceImpl(DocumentService documentService,
			RestTemplate restTemplate,
			@Lazy DocumentSchedulerService documentSchedulerService) {
		this.documentService = documentService;
		this.restTemplate = restTemplate;
		this.documentSchedulerService = documentSchedulerService;
	}

	@Async
	@Override
	public void startDocumentUpdaterJobAsync() {
		//Get all documents without a serial number
		List<Document> documents = documentService.getAllDocumentsWithoutSerialNumber();
		//Start thread to get the serial number from external client
		documents.forEach(document -> documentSchedulerService.getDocumentSerialNumber(document.getId()));
	}

	@Async
	@Override
	public void getDocumentSerialNumber(int documentId) {
		ResponseEntity<String> entity = restTemplate.getForEntity(apiURL+PARAM_DELIMITER+documentId, String.class);
		if(entity.getStatusCode() == HttpStatus.OK) {
			ClientResponseBO response = JsonToJavaUtil.jsonObjectToJavaObject(entity.getBody(), ClientResponseBO.class);
			if(PROCESSING_STATUS_OK.equals(response.getProcessingStatus())) {
				documentService.updateDocumentSerialNumber(documentId, response.getInvoiceId());
			}
		}
	}

}
