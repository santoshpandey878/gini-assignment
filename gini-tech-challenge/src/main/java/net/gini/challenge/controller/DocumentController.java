package net.gini.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.gini.challenge.core.utils.DtoConverter;
import net.gini.challenge.dto.DocumentDto;
import net.gini.challenge.service.DocumentService;

/**
 *Document Controller responsible to handle client requests to list document details
 * DTO is used to interact with client.
 */
@RestController
@RequestMapping("documents")
@Api(value = "Document Controller responsible to handle client requests to list document details.")
public class DocumentController {

	private final DocumentService documentService;
	private final DtoConverter dtoConverter;

	@Autowired
	public DocumentController(DocumentService documentService,
			DtoConverter dtoConverter) {
		this.documentService = documentService;
		this.dtoConverter = dtoConverter;
	}

	/**
	 * API to update page count of document
	 * @param addPages
	 * @param removePages
	 * @return
	 */
	@PatchMapping("/{documentId}")
	@ApiOperation(value = "API to update page count of document")
	public DocumentDto updateDocumentPageCount(@PathVariable("documentId") int documentId,
			@RequestParam(name = "addPages", defaultValue = "0") int addPages,
			@RequestParam(name = "removePages", defaultValue = "0") int removePages) {
		return dtoConverter.convert(documentService.updateDocumentPageCount(documentId, addPages, removePages), DocumentDto.class);
	}


}