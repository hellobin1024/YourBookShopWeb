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
	
	//һ��ע���û�����Ϊ��ͨ�û�����ʼ�Ĺ���Ա���Ծ���˭��˭����!
	private short a=0;
	//�һ�����ʱ���ص��ܱ� ��~
	private InputStream rresult;
	public InputStream getRresult() {
		return rresult;
	}
	public void setRresult(InputStream rresult) {
		this.rresult = rresult;
	}
	//�һ�����ʱ���ݽ��Ĳ����û���
	private String findUserName;
	public String getFindUserName() {
		return findUserName;
	}
	public void setFindUserName(String findUserName) {
		this.findUserName = findUserName;
	}
	//ע�᷵�ػ�struts������������
	private InputStream is;
	public InputStream getIs() {
		return is;
	}
	public void setIs(InputStream is) {
		this.is = is;
	}
	//ע��ʱ���������û���
	private String registerUserName;
	public String getRegisterUserName() {
		return registerUserName;
	}
	public void setRegisterUserName(String registerUserName) {
		this.registerUserName = registerUserName;
	}
	//ע��ʱ������������
	private String registerPassWord;
	public String getRegisterPassWord() {
		return registerPassWord;
	}
	public void setRegisterPassWord(String registerPassWord) {
		this.registerPassWord = registerPassWord;
	}
	//ע��ʱ������������
	private String registerUserEmail;
	public String getRegisterUserEmail() {
		return registerUserEmail;
	}
	public void setRegisterUserEmail(String registerUserEmail) {
		this.registerUserEmail = registerUserEmail;
	}
	//ע��ʱ����������ʵ����
	private String registerUserRealName;
	public String getRegisterUserRealName() {
		return registerUserRealName;
	}
	public void setRegisterUserRealName(String registerUserRealName) {
		this.registerUserRealName = registerUserRealName;
	}
	//ע��ʱ���������û�ѡ����ܱ�
	private String registerUserProblem;
	public String getRegisterUserProblem() {
		return registerUserProblem;
	}
	public void setRegisterUserProblem(String registerUserProblem) {
		this.registerUserProblem = registerUserProblem;
	}
	//ע��ʱ��д���û��ܱ���
	private String registerUserAnswer;
	public String getRegisterUserAnswer() {
		return registerUserAnswer;
	}
	public void setRegisterUserAnswer(String registerUserAnswer) {
		this.registerUserAnswer = registerUserAnswer;
	}
	//�޸����밴ť�ύ�󷵻ص���֤�����Ϣ��
	private InputStream rresult2;
	public InputStream getRresult2() {
		return rresult2;
	}
	public void setRresult2(InputStream rresult2) {
		this.rresult2 = rresult2;
	}
	//�޸�����ʱ�ύ�������û���
	private String formUserName;
	public String getFormUserName() {
		return formUserName;
	}
	public void setFormUserName(String formUserName) {
		this.formUserName = formUserName;
	}
	//�޸�����ʱ�ύ�������ܱ���
	private String formAnswer;
	public String getFormAnswer() {
		return formAnswer;
	}
	public void setFormAnswer(String formAnswer) {
		this.formAnswer = formAnswer;
	}
	//�޸�����ʱ�ύ������������
	private String formNewPwd;
	public String getFormNewPwd() {
		return formNewPwd;
	}
	public void setFormNewPwd(String formNewPwd) {
		this.formNewPwd = formNewPwd;
	}
	
	
	
	//ע���û�ʱ��ִ�з���
	public String execute() {
		
		registerdeal userregister = new registerdeal();
		String end = userregister.judgeregister(registerUserName, registerPassWord, registerUserEmail, registerUserRealName, a,
				registerUserProblem,registerUserAnswer	);
		StringBuffer result = new StringBuffer();
		
		
		//��������ʱ���login����json����ʱһ������Ҫ��������Ӧ��get/set����!!!
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
		
	//��������actionִ�еķ���(1)
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
	//��������actionִ�еķ���(2)
	public String FindPwdQuestion(String ss){
		List<?> list=null;
		Session session = HibernateSessionFactory.getSession();
		//������
		Transaction tx =session.beginTransaction();
		list = session.createQuery("from Userinfo where userName ='"+ss+"'").list();
		
		//����û������ھ�ȥ��ȡ�ܱ�����
		if(list.size()>0){
			Query query = session.createQuery("select problem from Userinfo where userName ='"+ss+"'");
			String str = query.uniqueResult().toString();
			return str;
		}
		else{
			return "nonono";
		}
		
		
	}
	
	//��֤�ܱ������Լ��ж�����д��������(1)
	public String ChangePassWord() throws UnsupportedEncodingException{
	String rr = ChangePassWord2(formUserName,formAnswer,formNewPwd);
	if(rr.equals("eRanswer")){
		rresult2 = new ByteArrayInputStream(rr.getBytes("utf-8"));
		return SUCCESS;
	}
	else{
		//���� ��  "Suanswer"ʱ����ʾ�޸ĳɹ�
		rresult2 = new ByteArrayInputStream(rr.getBytes("utf-8"));
		return SUCCESS;
	}
	
	
	}
	
	//��֤�ܱ������Լ��ж�����д��������(2)
	public String ChangePassWord2(String formUserName2, String formAnswer2, String formNewPwd2){
		Session session = HibernateSessionFactory.getSession();
		//������
		Transaction tx =session.beginTransaction();
		//�����ܱ���
		Query query = session.createQuery("select answer from Userinfo where userName ='"+formUserName2+"'");
		String strr = query.uniqueResult().toString();
		//���Ҹ��û�id
		
		Query query2 = session.createQuery("select id from Userinfo where userName ='"+formUserName2+"'");
		String strr2 = query2.uniqueResult().toString();
		int aaaa = Integer.parseInt(strr2);
		
		if(strr.equals(formAnswer2)){
			//�ܱ���ȷ�Ļ��������޸��������
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
	
	

