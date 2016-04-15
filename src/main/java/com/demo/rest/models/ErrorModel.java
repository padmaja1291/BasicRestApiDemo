package com.demo.rest.models;

import org.codehaus.jackson.annotate.JsonPropertyOrder;
/**
 * Model Class for Error
 * @author Padmaja Krishnakumar
 * @version 1.0
 * @since 12 April 2016
 */
@JsonPropertyOrder({ "verb", "url","message" })
public class ErrorModel {
	private String verb;
	private String url;
	private String message;

	
	public ErrorModel(String verb, String url, String message) {
		super();
		this.verb = verb;
		this.url = url;
		this.message = message;
	}

	public String getVerb() {
		return verb;
	}

	public String getUrl() {
		return url;
	}


	public String getMessage() {
		return message;
	}

}
