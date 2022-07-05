

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.Charset;

import javax.xml.bind.JAXBException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
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
import com.xml.converter.utility.ResponseHandlerUtility;

public class Test {

	public static void main(String[] args) throws IOException, SOAPException, TransformerConfigurationException,
			TransformerException, TransformerFactoryConfigurationError, JAXBException {
//input 1 : Fault : Failure
		String xmlInput = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n" + "<soapenv:Envelope\n"
				+ "	xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"\n"
				+ "	xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" + "	<soapenv:Body>\n"
				+ "		<soapenv:Fault>\n" + "			<faultcode>F6101</faultcode>\n"
				+ "			<faultstring>Wrong User</faultstring>\n"
				+ "			<detail>\n" + "				<ns1:ServiceException\n"
				+ "					xmlns:ns1=\"http://www.csapi.org/schema/parlayx/common/v2_1\">\n"
				+ "					<messageId>F6101</messageId>\n"
				+ "					<text>Wrong User</text>\n"
				+ "					<variables></variables>\n" + "				</ns1:ServiceException>\n"
				+ "			</detail>\n" + "		</soapenv:Fault>\n" + "	</soapenv:Body>\n" + "</soapenv:Envelope>";



		// input 2 : No fault :success
//		String xmlInput = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n" + "<soapenv:Envelope\n"
//				+ "	xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"\n"
//				+ "	xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" + "	<soapenv:Body>\n"
//				+ "		<ns1:chargeAmountResponse\n" + "			xmlns:ns1=\"http://amount_charging/v2_1/local\">\n"
//				+ "		</ns1:chargeAmountResponse>\n" + "	</soapenv:Body>\n" + "</soapenv:Envelope>";

		MessageFactory factory = MessageFactory.newInstance();
		SOAPMessage message = factory.createMessage(new MimeHeaders(),
				new ByteArrayInputStream(xmlInput.getBytes(Charset.forName("UTF-8"))));
		System.out.println(ResponseHandlerUtility.handleResponse(message));

	}
}
