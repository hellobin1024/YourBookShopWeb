package ExecuteDo;
/*这个类里包括了几个方法
 * 查找所找的图书分类的总书数量
 * 查找每个分类图书下的分页查询方法~
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
//前台传入的分类
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
//返回的流
public InputStream bookSum;
public InputStream getBookSum() {
	return bookSum;
}
public void setBookSum(InputStream bookSum) {
	this.bookSum = bookSum;
}
//从info包内引入这个格式的队列
public List<PageBookList>pagebooklist;
public List<PageBookList> getPagebooklist() {
	return pagebooklist;
}
public void setPagebooklist(List<PageBookList> pagebooklist) {
	this.pagebooklist = pagebooklist;
}
//前端传的具体要查的某页
public Integer howPage;
public Integer getHowPage() {
	return howPage;
}
public void setHowPage(Integer howPage) {
	this.howPage = howPage;
}
//查找某一页时候的书类别
public String bookLeiBie;
public String getBookLeiBie() {
	return bookLeiBie;
}
public void setBookLeiBie(String bookLeiBie) {
	this.bookLeiBie = bookLeiBie;
}
//返回的JSONArray数据
public String bbbbooklist;
public String getBbbbooklist() {
	return bbbbooklist;
}
public void setBbbbooklist(String bbbbooklist) {
	this.bbbbooklist = bbbbooklist;
}

//查找图书总数---1
public String execute() throws UnsupportedEncodingException{
		String bOOKSUM = FindBookdeal(chooseBook);		
		int totalRecord =Integer.parseInt(bOOKSUM);
		//计算页数
		//int a = (totalRecord  + 5  - 1) / 5;
		
		bOOKSUM = String.valueOf(totalRecord);
		bookSum = new ByteArrayInputStream(bOOKSUM.getBytes("utf-8"));
		return SUCCESS;
		
}
//查找图书总数---2	
public String FindBookdeal(String chooseBook){

		Session session = HibernateSessionFactory.getSession();
		//打开事务
		Transaction tx =session.beginTransaction();
		//区分一下是所有分类还是具体行业
		if(chooseBook.equals("所有分类")){
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
	
//查找每一页的书籍内容----1
public String FindCurrentPageBook(){
	//start计算从第几个开始查;5的话是指查多少个数据~,bookLeiBie是书的类别
	int start = (howPage-1)*5;
	pagebooklist = getNewsByPage(start,5,bookLeiBie);
	/*
	 *转换为JSONArray数据格式,具体如下[{},{},{},{}....]详情可以百度JSONObject,和，JSONArray~查的 
	 */
	JSONArray ssss = JSONArray.fromObject(pagebooklist);
	bbbbooklist = ssss.toString();
	
	return SUCCESS;
	
}
//查找每一页的书籍内容----2
public List<PageBookList> getNewsByPage(int start, int i,String bookLeiBie){
	if(bookLeiBie.equals("所有分类")){
		try{
			Session session = HibernateSessionFactory.getSession();
			//分为两种情况，所欲分类是特殊的情况
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
			//解决先筛选出书的分类，再进行分页查询的HQL语句是难点，想一想~
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



