package Deal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import BookShopConnJDBC.JDBCConn;

public class logindeal {
	
	JDBCConn dbConn = new JDBCConn();
	/*
	 * ���µ�¼�ж�--
	 * 
	 * return 0:�ɹ�-�û���Ҳ����/return 1:�û���������/return 2:������� /return -1:�쳣���/�������ݿ� 1�ǹ���Ա---0���ǹ���Ա
	 */
	public Map<String, Object> judgelogin(String loginusername,String loginpassword){
		Statement stm;
		//��Map,��ֵ�Դ�Json����
		Map<String,Object> map =new HashMap<String,Object>();
		
		try{
			stm = dbConn.getConn().createStatement();
			ResultSet rs = stm.executeQuery("select * from userinfo where UserName='"+loginusername+"'");
			while(rs.next()){
				String pwd = rs.getString("PassWord");
				int IsMG = rs.getInt("IsMG");
				if(pwd.equals(loginpassword)){
					map.put("pwdstate",0);//����״̬
					map.put("Userstate",0);//�û���״̬
					map.put("UserName",loginusername);//���û���
					map.put("IsMG",IsMG);//�����Ƿ����Ա״̬
					return map;
				}
				else{
					map.put("pwdstate",2);//����״̬
					map.put("Userstate",0);//�û���״̬
					map.put("UserName",loginusername);//���û���
					map.put("IsMG",IsMG);//�����Ƿ����Ա״̬
					return map;
				}
				
			}	
			map.put("pwdstate",2);//����״̬
			map.put("Userstate",1);//�û���״̬
			map.put("UserName",1);//���û���
			map.put("IsMG",0);//�����Ƿ����Ա״̬--0���ǹ���Ա
			return map;
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		map.put("pwdstate",-1);//����״̬
		map.put("Userstate",-1);//�û���״̬
		map.put("UserName",-1);//���û���
		map.put("IsMG",0);//�����Ƿ����Ա״̬--0���ǹ���Ա
		return map;
		
	}
	
	
}
