package net.gini.challenge.service;

import java.util.List;

import net.gini.challenge.entity.Document;

public interface DocumentService {

	/**
	 * Method to fetch single document by id
	 * @param documentId
	 * @return
	 */
	Document getDocumentById(int documentId);

	/**
	 * Method to get all documents without a serial number
	 */
	List<Document> getAllDocumentsWithoutSerialNumber();

	/**
	 * Method to update document serial number
	 * @param documentId
	 * @param serialNumber
	 */
	void updateDocumentSerialNumber(int documentId, String serialNumber);

	/**
	 * Method to update document page count
	 * @param addPages
	 * @param removePages
	 * @return
	 */
	Document updateDocumentPageCount(int documentId, int addPages, int removePages);


}
