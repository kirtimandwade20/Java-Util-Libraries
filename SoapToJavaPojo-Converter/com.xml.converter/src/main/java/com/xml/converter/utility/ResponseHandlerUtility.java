package com.xml.converter.utility;

import java.io.StringWriter;

import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.json.JSONObject;
import org.json.XML;

import com.google.gson.Gson;
import com.xml.converter.pojo.Constants;
import com.xml.converter.pojo.Detail;
import com.xml.converter.pojo.Fault;

public class ResponseHandlerUtility {
	static Gson gson = new Gson();
	
	
	private ResponseHandlerUtility() {
		super();
	}

	public static Fault handleResponse(SOAPMessage soapMessage) throws SOAPException, TransformerConfigurationException,
			TransformerException, TransformerFactoryConfigurationError {
		if (soapMessage != null) {
			SOAPBody body = soapMessage.getSOAPBody();
			if (body != null && body.getFault() != null) {
				String soapXml = convertToString(body);

				JSONObject jsonObject = XML.toJSONObject(soapXml);
				JSONObject faultObj = ((JSONObject) jsonObject.get(Constants.FAULT_STRING));
				JSONObject detailObj = ((JSONObject) jsonObject.get(Constants.FAULT_STRING)).getJSONObject(Constants.DETAIL_STRING)
						.getJSONObject(Constants.SERVICE_EXCEPTION_STRING);
				Fault fault = gson.fromJson(faultObj.toString(), Fault.class);
				Detail detail = gson.fromJson(detailObj.toString(), Detail.class);
				fault.setDetail(detail);
				fault.setStatus(Constants.FAILURE);
				return fault;
			} else if (body != null) {
				return new Fault(Constants.SUCCESS);
			}
		}
		return null;

	}

	private static String convertToString(SOAPBody body)
			throws TransformerException, TransformerConfigurationException, TransformerFactoryConfigurationError {
		StringWriter sw = new StringWriter();
		TransformerFactory.newInstance().newTransformer().transform(new DOMSource(body.getFault()),
				new StreamResult(sw));
		String xml = sw.toString();
		return xml;
	}
}
