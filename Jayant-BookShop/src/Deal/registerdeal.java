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
		//������
		Transaction tx =session.beginTransaction();
		try{
			//�ж��Ƿ��Ѿ����ڸ��û���!
			
			//Ҫע����Ϊ��Hibernate��ӳ����,���Ա����͹ؼ�������Ҫ��������Լ����е�������ͬ����,���������ݿ��еı������ֶ���!
			list = session.createQuery("from Userinfo where userName ='"+Name+"'").list();
			
			if(list.size()>0){
				return "FALSE";
			}
			//ע��˴����ݿ⣬��Ϊ������ID,�������ӵ����û�,�����ݿ���,ID�Ǽ�Ͽ�����!~
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
