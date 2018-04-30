package ExecuteDo;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

import Deal.registerdeal;
import HibernatePack.HibernateSessionFactory;
import HibernatePack.Userinfo;


public class doregister extends ActionSupport{
	
	//一切注册用户都先为普通用户，初始的管理员可以决定谁是谁不是!
	private short a=0;
	//找回密码时返回的密保 流~
	private InputStream rresult;
	public InputStream getRresult() {
		return rresult;
	}
	public void setRresult(InputStream rresult) {
		this.rresult = rresult;
	}
	//找回密码时传递进的参数用户名
	private String findUserName;
	public String getFindUserName() {
		return findUserName;
	}
	public void setFindUserName(String findUserName) {
		this.findUserName = findUserName;
	}
	//注册返回回struts的流数据类型
	private InputStream is;
	public InputStream getIs() {
		return is;
	}
	public void setIs(InputStream is) {
		this.is = is;
	}
	//注册时传进来的用户名
	private String registerUserName;
	public String getRegisterUserName() {
		return registerUserName;
	}
	public void setRegisterUserName(String registerUserName) {
		this.registerUserName = registerUserName;
	}
	//注册时传进来的密码
	private String registerPassWord;
	public String getRegisterPassWord() {
		return registerPassWord;
	}
	public void setRegisterPassWord(String registerPassWord) {
		this.registerPassWord = registerPassWord;
	}
	//注册时传进来的邮箱
	private String registerUserEmail;
	public String getRegisterUserEmail() {
		return registerUserEmail;
	}
	public void setRegisterUserEmail(String registerUserEmail) {
		this.registerUserEmail = registerUserEmail;
	}
	//注册时传进来的真实姓名
	private String registerUserRealName;
	public String getRegisterUserRealName() {
		return registerUserRealName;
	}
	public void setRegisterUserRealName(String registerUserRealName) {
		this.registerUserRealName = registerUserRealName;
	}
	//注册时传进来的用户选择的密保
	private String registerUserProblem;
	public String getRegisterUserProblem() {
		return registerUserProblem;
	}
	public void setRegisterUserProblem(String registerUserProblem) {
		this.registerUserProblem = registerUserProblem;
	}
	//注册时填写的用户密保答案
	private String registerUserAnswer;
	public String getRegisterUserAnswer() {
		return registerUserAnswer;
	}
	public void setRegisterUserAnswer(String registerUserAnswer) {
		this.registerUserAnswer = registerUserAnswer;
	}
	//修改密码按钮提交后返回的验证相关信息流
	private InputStream rresult2;
	public InputStream getRresult2() {
		return rresult2;
	}
	public void setRresult2(InputStream rresult2) {
		this.rresult2 = rresult2;
	}
	//修改密码时提交进来的用户名
	private String formUserName;
	public String getFormUserName() {
		return formUserName;
	}
	public void setFormUserName(String formUserName) {
		this.formUserName = formUserName;
	}
	//修改密码时提交进来的密保答案
	private String formAnswer;
	public String getFormAnswer() {
		return formAnswer;
	}
	public void setFormAnswer(String formAnswer) {
		this.formAnswer = formAnswer;
	}
	//修改密码时提交进来的新密码
	private String formNewPwd;
	public String getFormNewPwd() {
		return formNewPwd;
	}
	public void setFormNewPwd(String formNewPwd) {
		this.formNewPwd = formNewPwd;
	}
	
	
	
	//注册用户时的执行方法
	public String execute() {
		
		registerdeal userregister = new registerdeal();
		String end = userregister.judgeregister(registerUserName, registerPassWord, registerUserEmail, registerUserRealName, a,
				registerUserProblem,registerUserAnswer	);
		StringBuffer result = new StringBuffer();
		
		
		//返回流的时候和login返回json数据时一样，不要忘记了相应的get/set方法!!!
		try {
			if(end=="TRUE"){
				result.append("1");
				String string = result.toString();
				is = new ByteArrayInputStream(string.getBytes("utf-8"));
				System.out.println(is);
			}
			if(end=="FALSE"){
				result.append("0");
				String string = result.toString();
				is = new ByteArrayInputStream(string.getBytes("utf-8"));
			}
		} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
		}
			return SUCCESS;
		}
		
	//忘记密码action执行的方法(1)
	public String FindPassWord() throws UnsupportedEncodingException{
		
		String result = FindPwdQuestion(findUserName);
		if(result=="nonono"){
			rresult = new ByteArrayInputStream(result.getBytes("utf-8"));
			return ERROR;
		}
		else{
			rresult = new ByteArrayInputStream(result.getBytes("utf-8"));
			return SUCCESS;
		}
		
	}
	//忘记密码action执行的方法(2)
	public String FindPwdQuestion(String ss){
		List<?> list=null;
		Session session = HibernateSessionFactory.getSession();
		//打开事务
		Transaction tx =session.beginTransaction();
		list = session.createQuery("from Userinfo where userName ='"+ss+"'").list();
		
		//如果用户名存在就去获取密保问题
		if(list.size()>0){
			Query query = session.createQuery("select problem from Userinfo where userName ='"+ss+"'");
			String str = query.uniqueResult().toString();
			return str;
		}
		else{
			return "nonono";
		}
		
		
	}
	
	//验证密保问题以及判断正误写入新密码(1)
	public String ChangePassWord() throws UnsupportedEncodingException{
	String rr = ChangePassWord2(formUserName,formAnswer,formNewPwd);
	if(rr.equals("eRanswer")){
		rresult2 = new ByteArrayInputStream(rr.getBytes("utf-8"));
		return SUCCESS;
	}
	else{
		//返回 是  "Suanswer"时，表示修改成功
		rresult2 = new ByteArrayInputStream(rr.getBytes("utf-8"));
		return SUCCESS;
	}
	
	
	}
	
	//验证密保问题以及判断正误写入新密码(2)
	public String ChangePassWord2(String formUserName2, String formAnswer2, String formNewPwd2){
		Session session = HibernateSessionFactory.getSession();
		//打开事务
		Transaction tx =session.beginTransaction();
		//查找密保答案
		Query query = session.createQuery("select answer from Userinfo where userName ='"+formUserName2+"'");
		String strr = query.uniqueResult().toString();
		//查找该用户id
		
		Query query2 = session.createQuery("select id from Userinfo where userName ='"+formUserName2+"'");
		String strr2 = query2.uniqueResult().toString();
		int aaaa = Integer.parseInt(strr2);
		
		if(strr.equals(formAnswer2)){
			//密保正确的话，进行修改密码操作
			Userinfo change = (Userinfo)session.get(Userinfo.class,aaaa);
			change.setPassWord(formNewPwd2);
			tx.commit();
			session.close();
			return "Suanswer";
		}
		else{
			return "eRanswer";
		}
		
		
	}
	
}
	
	

