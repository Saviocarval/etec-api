package br.gov.etec.app.error;

public class ErrorResponse {
	private final String message;
    private final int code;
    private final String status;
    private final String objectName;
    
	public ErrorResponse(String message, int code, String status, String objectName) {
		super();
		this.message = message;
		this.code = code;
		this.status = status;
		this.objectName = objectName;
	}
	
	public String getMessage() {
		return message;
	}
	public int getCode() {
		return code;
	}
	public String getStatus() {
		return status;
	}
	public String getObjectName() {
		return objectName;
	}
    
    
    
}
