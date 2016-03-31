package kr.co.beany.sample.vo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "body")
	   public class Body {
	   @XmlElement
	   private String msg;

	   public String getMessage() {
	      return msg;
	   }

	   public void setMessage(String message) {
	       this.msg = message;
	   }
	   }
