package Deal;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import HibernatePack.HibernateSessionFactory;

public class Announcedeal {
	public String getanno(String Boool){
		
			Session session = HibernateSessionFactory.getSession();
			//打开事务
			Transaction tx =session.beginTransaction();
			Query query = session.createQuery("select announce from Announceinfo where time="
					+ "(select MAX(time) from Announceinfo)");
			String str = query.uniqueResult().toString();
			return str;
			
	}
}
