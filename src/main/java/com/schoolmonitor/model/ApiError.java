package com.schoolmonitor.model;

import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
/**
 * @author PrabhjeetS
 * @version 1.0
 */
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;
@Component
public class ApiError {
private int httpStatusValue;
private String httpStatusCode;
private Set<Entry<String,List<String>>> headerMappings;
private String webRequest;
private String exceptionMessage;
public int getHttpStatusValue() {
	return httpStatusValue;
}
public void setHttpStatusValue(int httpStatusValue) {
	this.httpStatusValue = httpStatusValue;
}
public String getHttpStatusCode() {
	return httpStatusCode;
}
public void setHttpStatusCode(String httpStatusCode) {
	this.httpStatusCode = httpStatusCode;
}
public Set<Entry<String, List<String>>> getHeaderMappings() {
	return headerMappings;
}
public void setHeaderMappings(Set<Entry<String, List<String>>> headerMappings) {
	this.headerMappings = headerMappings;
}


public String getWebRequest() {
	return webRequest;
}
public void setWebRequest(String webRequest) {
	this.webRequest = webRequest;
}
public String getExceptionMessage() {
	return exceptionMessage;
}
public void setExceptionMessage(String exceptionMessage) {
	this.exceptionMessage = exceptionMessage;
}

}
