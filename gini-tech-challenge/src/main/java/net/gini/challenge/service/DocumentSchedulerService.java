package net.gini.challenge.service;

public interface DocumentSchedulerService {

	/**
	 * Method to start document updater job asynchronously
	 */
	void startDocumentUpdaterJobAsync();

	/**
	 * Method to get the serial number from external client
	 */
	void getDocumentSerialNumber(int documentId);

}
