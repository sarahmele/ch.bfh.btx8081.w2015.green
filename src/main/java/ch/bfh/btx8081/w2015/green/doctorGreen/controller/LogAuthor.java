package ch.bfh.btx8081.w2015.green.doctorGreen.controller;

import java.io.IOException;
import java.util.Iterator;
/*import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;*/
/**
 * Class Used to Authenticate User during Login procedure
 */
//import application.LogAuthor;

public class LogAuthor {
	public String AuthorResult=null;
	/*public Document createJDOMviaSAX(String filename) throws JDOMException,
	IOException {
return new SAXBuilder().build(filename);
	}*/
 public LogAuthor(){
	  
 }
 	//Check whether the Input of the User is valid or different from the
 	//authentication sheet
   public void CheckAcces(String MyLog, String MyPassw){
	   
	   //String AuthorResult;
	   
	 /*  Document doc=null;
		try {
			doc = new LogAuthor().createJDOMviaSAX("LoginFile.xml");
			
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		Element root = doc.getRootElement();

		Iterator<Element> secUIDIter = root.getChildren("SecUID").iterator();
		
		secUIDIter = root.getChildren("SecUID").iterator();
		while (secUIDIter.hasNext()) {
			Element SecUID = secUIDIter.next();
			if (SecUID.getAttribute("name").getValue().compareTo(MyLog) == 0) {
				Iterator<Element> secuPWIter = SecUID.getChildren("SecuPW")
						.iterator();
				while (secuPWIter.hasNext()) {
					Element SecuPW = secuPWIter.next();

					if (SecuPW.getText().compareTo(MyPassw) == 0) {
						SecUID.removeContent(SecuPW);
						System.out.println("access sucessful->run programm");
						AuthorResult="true";
					
					} else{
						System.out.println("no access-> password is not correct");
					AuthorResult="false";
					break;
				}
				}
			}
              //AuthorResult="This Login does not exist";
             // System.out.println("Login is not correct");
		}
		//deny access to Homeview
	if (AuthorResult=="No Login"){
		System.out.println("Login is not correct");
	}*/
}
   public String getResult(){
		return AuthorResult;
   }
  
}
