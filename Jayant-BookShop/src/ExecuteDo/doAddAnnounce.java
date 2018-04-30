package ExecuteDo;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

import HibernatePack.Announceinfo;
import HibernatePack.HibernateSessionFactory;

public class doAddAnnounce extends ActionSupport {
	private String newanno;
	private InputStream ssst;
	
	
	public InputStream getSsst() {
		return ssst;
	}
	public void setSsst(InputStream ssst) {
		this.ssst = ssst;
	}
	public String getNewanno() {
		return newanno;
	}
	public void setNewanno(String newanno) {
		this.newanno = newanno;
	}
	//action�ӹ�����execute����
	public String execute() throws UnsupportedEncodingException{
	
		Timestamp d = new Timestamp(System.currentTimeMillis()); 
		String result = annodeal(newanno,d);
		String string = "1";
		ssst = new ByteArrayInputStream(string.getBytes("utf-8"));
		
		return SUCCESS;
		
		
	}
	//�����¹���Ĳ���
	public String annodeal(String s,Timestamp d){
		//��java�е�ʱ��תΪsql�е�ʱ���ʽ
		
		
		Announceinfo newannoo  =new Announceinfo(s,d);
		
		Session session = HibernateSessionFactory.getSession();
		//������
		Transaction tx =session.beginTransaction();
		//������һ���������
		session.save(newannoo);
		tx.commit();
		session.close();
		return "TRUE";
		
	}
}
