package net.gini.challenge.dao;

import java.util.List;

import net.gini.challenge.entity.Document;

/**
 * Repository to handle all database operation for Document
 */
public interface DocumentRepository extends BaseRepository<Document, Integer>{

	/**
	 * Method to find all documents without a serial number
	 * @return
	 */
	List<Document> findAllBySerialNumberIsNull();
}