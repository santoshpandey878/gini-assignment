package net.gini.challenge.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.gini.challenge.core.constant.MessageConstant;
import net.gini.challenge.core.utils.MessageUtil;
import net.gini.challenge.dao.DocumentRepository;
import net.gini.challenge.entity.Document;
import net.gini.challenge.exception.ResourceNotFoundException;
import net.gini.challenge.exception.ServiceException;
import net.gini.challenge.service.DocumentService;

/**
 * Service class responsible to have all business logic for Document
 *
 */
@Service
public class DocumentServiceImpl implements DocumentService {

	private final DocumentRepository documentRepository;
	private final MessageUtil message;

	@Autowired
	public DocumentServiceImpl(DocumentRepository documentRepository,
			MessageUtil message) {
		this.documentRepository = documentRepository;
		this.message = message;
	}

	@Override
	public Document getDocumentById(int documentId) {
		return documentRepository.findById(documentId)
				.orElseThrow(() -> new ResourceNotFoundException(message.get(MessageConstant.DOCUMENT_NOT_FOUND, documentId)));
	}

	@Override
	public List<Document> getAllDocumentsWithoutSerialNumber() {
		return documentRepository.findAllBySerialNumberIsNull();
	}

	@Transactional
	@Override
	public void updateDocumentSerialNumber(int documentId, String serialNumber) {
		Document document = documentRepository.getOne(documentId);
		document.setSerialNumber(serialNumber);
		documentRepository.save(document);
	}

	@Transactional
	@Override
	public Document updateDocumentPageCount(int documentId, int addPages, int removePages) {
		Document document = getDocumentById(documentId);
		//Validate pages
		validatePages(document.getPages(), addPages, removePages);
		document.setPages((document.getPages() + addPages) - removePages);
		return documentRepository.save(document);
	}

	/**
	 * Method to validate pages to add/remove in a document
	 * @param totalPages
	 * @param addPages
	 * @param removePages
	 */
	private void validatePages(int totalPages, int addPages, int removePages) {
		if(addPages <= 0 && removePages <= 0) {
			throw new ServiceException(message.get(MessageConstant.INVALID_PAGES));
		} else if(addPages < 0) {
			throw new ServiceException(message.get(MessageConstant.INVALID_ADD_PAGES));
		} else if(removePages < 0) {
			throw new ServiceException(message.get(MessageConstant.INVALID_REMOVE_PAGES));
		}

		if(((totalPages + addPages) - removePages) < 0) {
			throw new ServiceException(message.get(MessageConstant.INSUFFICIENT_DOCUMENT_PAGES));
		}

	}

}
