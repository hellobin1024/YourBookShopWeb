package ExecuteDo;
/*�����������˼�������
 * �������ҵ�ͼ��������������
 * ����ÿ������ͼ���µķ�ҳ��ѯ����~
 * */
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

import HibernatePack.HibernateSessionFactory;
import Info.PageBookList;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class doFindBook extends ActionSupport {
//ǰ̨����ķ���
public String chooseBook;
public String getChooseBook() {
	return chooseBook;
}
public void setChooseBook(String chooseBook) {
	this.chooseBook = chooseBook;
}
//
public String bOOKSUM;
public String getbOOKSUM() {
	return bOOKSUM;
}
public void setbOOKSUM(String bOOKSUM) {
	this.bOOKSUM = bOOKSUM;
}
//���ص���
public InputStream bookSum;
public InputStream getBookSum() {
	return bookSum;
}
public void setBookSum(InputStream bookSum) {
	this.bookSum = bookSum;
}
//��info�������������ʽ�Ķ���
public List<PageBookList>pagebooklist;
public List<PageBookList> getPagebooklist() {
	return pagebooklist;
}
public void setPagebooklist(List<PageBookList> pagebooklist) {
	this.pagebooklist = pagebooklist;
}
//ǰ�˴��ľ���Ҫ���ĳҳ
public Integer howPage;
public Integer getHowPage() {
	return howPage;
}
public void setHowPage(Integer howPage) {
	this.howPage = howPage;
}
//����ĳһҳʱ��������
public String bookLeiBie;
public String getBookLeiBie() {
	return bookLeiBie;
}
public void setBookLeiBie(String bookLeiBie) {
	this.bookLeiBie = bookLeiBie;
}
//���ص�JSONArray����
public String bbbbooklist;
public String getBbbbooklist() {
	return bbbbooklist;
}
public void setBbbbooklist(String bbbbooklist) {
	this.bbbbooklist = bbbbooklist;
}

//����ͼ������---1
public String execute() throws UnsupportedEncodingException{
		String bOOKSUM = FindBookdeal(chooseBook);		
		int totalRecord =Integer.parseInt(bOOKSUM);
		//����ҳ��
		//int a = (totalRecord  + 5  - 1) / 5;
		
		bOOKSUM = String.valueOf(totalRecord);
		bookSum = new ByteArrayInputStream(bOOKSUM.getBytes("utf-8"));
		return SUCCESS;
		
}
//����ͼ������---2	
public String FindBookdeal(String chooseBook){

		Session session = HibernateSessionFactory.getSession();
		//������
		Transaction tx =session.beginTransaction();
		//����һ�������з��໹�Ǿ�����ҵ
		if(chooseBook.equals("���з���")){
			Query query = session.createQuery("select count(*) from PythonbookCopy");
				String str = query.uniqueResult().toString();
				return str;
		}
		else{
			Query query = session.createQuery("select count(*) from PythonbookCopy  where leibie ='"+chooseBook+"'");
				String str = query.uniqueResult().toString();
				return str;
		}
		
	}
	
//����ÿһҳ���鼮����----1
public String FindCurrentPageBook(){
	//start����ӵڼ�����ʼ��;5�Ļ���ָ����ٸ�����~,bookLeiBie��������
	int start = (howPage-1)*5;
	pagebooklist = getNewsByPage(start,5,bookLeiBie);
	/*
	 *ת��ΪJSONArray���ݸ�ʽ,��������[{},{},{},{}....]������԰ٶ�JSONObject,�ͣ�JSONArray~��� 
	 */
	JSONArray ssss = JSONArray.fromObject(pagebooklist);
	bbbbooklist = ssss.toString();
	
	return SUCCESS;
	
}
//����ÿһҳ���鼮����----2
public List<PageBookList> getNewsByPage(int start, int i,String bookLeiBie){
	if(bookLeiBie.equals("���з���")){
		try{
			Session session = HibernateSessionFactory.getSession();
			//��Ϊ���������������������������
			Query query = session.createQuery("from PythonbookCopy");
			query.setFirstResult(start);
			query.setMaxResults(i);
			return query.list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	else{
		try{
			Session session = HibernateSessionFactory.getSession();
			//�����ɸѡ����ķ��࣬�ٽ��з�ҳ��ѯ��HQL������ѵ㣬��һ��~
			Query query = session.createQuery("from PythonbookCopy where leibie='"+bookLeiBie+"'");
			query.setFirstResult(start);
			query.setMaxResults(i);
			return query.list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	
	
}

}



