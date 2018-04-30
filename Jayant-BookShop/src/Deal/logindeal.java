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
	 * 以下登录判断--
	 * 
	 * return 0:成功-用户名也存在/return 1:用户名不存在/return 2:密码错误 /return -1:异常情况/根据数据库 1是管理员---0不是管理员
	 */
	public Map<String, Object> judgelogin(String loginusername,String loginpassword){
		Statement stm;
		//用Map,键值对存Json数据
		Map<String,Object> map =new HashMap<String,Object>();
		
		try{
			stm = dbConn.getConn().createStatement();
			ResultSet rs = stm.executeQuery("select * from userinfo where UserName='"+loginusername+"'");
			while(rs.next()){
				String pwd = rs.getString("PassWord");
				int IsMG = rs.getInt("IsMG");
				if(pwd.equals(loginpassword)){
					map.put("pwdstate",0);//密码状态
					map.put("Userstate",0);//用户名状态
					map.put("UserName",loginusername);//回用户名
					map.put("IsMG",IsMG);//返回是否管理员状态
					return map;
				}
				else{
					map.put("pwdstate",2);//密码状态
					map.put("Userstate",0);//用户名状态
					map.put("UserName",loginusername);//回用户名
					map.put("IsMG",IsMG);//返回是否管理员状态
					return map;
				}
				
			}	
			map.put("pwdstate",2);//密码状态
			map.put("Userstate",1);//用户名状态
			map.put("UserName",1);//回用户名
			map.put("IsMG",0);//返回是否管理员状态--0不是管理员
			return map;
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		map.put("pwdstate",-1);//密码状态
		map.put("Userstate",-1);//用户名状态
		map.put("UserName",-1);//回用户名
		map.put("IsMG",0);//返回是否管理员状态--0不是管理员
		return map;
		
	}
	
	
}
