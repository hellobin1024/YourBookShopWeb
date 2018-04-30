package Deal;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import HibernatePack.HibernateSessionFactory;
import HibernatePack.Userinfo;

public class registerdeal {
	public String judgeregister(String registerUserName,String registerPassWord,
			String registerUserEmail,String registerUserRealName,short a, String registerUserProblem, String registerUserAnswer){
		List<?> list=null;
		String Name = registerUserName;
		
		Userinfo user = new Userinfo(registerUserName,registerPassWord,
				registerUserEmail, registerUserRealName,a,registerUserProblem,registerUserAnswer);
		
		Session session = HibernateSessionFactory.getSession();
		//打开事务
		Transaction tx =session.beginTransaction();
		try{
			//判断是否已经存在该用户名!
			
			//要注意因为在Hibernate的映射中,所以表明和关键字名是要和类的名以及类中的名字相同才行,而不是数据库中的表名和字段名!
			list = session.createQuery("from Userinfo where userName ='"+Name+"'").list();
			
			if(list.size()>0){
				return "FALSE";
			}
			//注意此处数据库，因为主键是ID,所以增加的新用户,在数据库中,ID是间断开来的!~
			else{
				session.save(user);
				tx.commit();
				session.close();
				return "TRUE";
			}

		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		return "FALSE";
	}
}
