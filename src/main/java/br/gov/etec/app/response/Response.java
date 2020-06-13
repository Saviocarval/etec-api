package br.gov.etec.app.response;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Response<T> {
	
	private T data;
	private List<LinkedHashMap<String, Object>> errors;	

	
	public Response() {
		
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<LinkedHashMap<String, Object>> getErrors() {
		if ( this.errors == null ) {
			this.errors = new  ArrayList<>();
		}
		return errors;
	}

	public void setErrors(List<LinkedHashMap<String, Object>> erros) {
		this.errors = erros;
	}
		

}
