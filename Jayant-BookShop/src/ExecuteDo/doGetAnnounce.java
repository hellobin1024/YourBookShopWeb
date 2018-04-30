package ExecuteDo;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import com.opensymphony.xwork2.ActionSupport;

import Deal.Announcedeal;

public class doGetAnnounce extends ActionSupport {
	private String Boool;
	//¹«¸æÁ÷~
	private InputStream cc;
	
	public InputStream getCc() {
		return cc;
	}
	public void setCc(InputStream cc) {
		this.cc = cc;
	}
	public String getBoool() {
		return Boool;
	}
	public void setBoool(String boool) {
		Boool = boool;
	}
	
	public String execute() throws UnsupportedEncodingException{
		Announcedeal announcedeal = new Announcedeal();
		String result = announcedeal.getanno(Boool);
		cc = new ByteArrayInputStream(result.getBytes("utf-8"));
		
		return SUCCESS;
		
	}
}
