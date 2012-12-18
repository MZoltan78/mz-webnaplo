package com.mz.webnaplo.response;

import java.util.ArrayList;
import java.util.List;

public class StatusResponse {

	private Boolean success;
	private List<String> message;

	public StatusResponse() {
		this.message = new ArrayList<String>(1);
	}

	public StatusResponse(Boolean success, String message) {
		this();
		this.success = success;
		this.message.add(message);
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public List<String> getMessage() {
		return message;
	}

	public void setMessage(List<String> message) {
		this.message = message;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StatusResponse [success=");
		builder.append(success);
		builder.append(", messages=");
		for (String mess: message) {
			builder.append(mess +", ");
		}		
		builder.append("]");
		return builder.toString();
	}
}
