package ExecuteDo;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Deal.logindeal;
import net.sf.json.JSONObject;

public class dologin extends ActionSupport {
	private String loginInputUserName;
	private String loginInputPassword;
	private String result;
	private InputStream yes;
	
	public InputStream getYes() {
		return yes;
	}
	public void setYes(InputStream yes) {
		this.yes = yes;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public String getLoginInputUserName() {
		return loginInputUserName;
	}
	public void setLoginInputUserName(String loginInputUserName) {
		this.loginInputUserName = loginInputUserName;
	}
	
	public String getLoginInputPassword() {
		return loginInputPassword;
	}
	public void setLoginInputPassword(String loginInputPassword) {
		this.loginInputPassword = loginInputPassword;
	}
	
	
	Map<String,Object> map = new HashMap<String,Object>();
	
	public String execute(){
		
		logindeal userlogin = new logindeal();
		map = userlogin.judgelogin(loginInputUserName,loginInputPassword);
		
		//�����ص�map����ת����JSON����;����ǵõ�����Ҫ�����jar�������򲻽��еı���
		JSONObject jsonObject = JSONObject.fromObject(map);
		result = jsonObject.toString();
		
		//����½״̬��¼��Session������֤;��ȡ������״̬�Լ��û�Ȩ��״̬
		Object a = map.get("pwdstate");
		Object b = map.get("IsMG");
		if(a.equals(0)){
			ActionContext.getContext().getSession().put("USERNAME",loginInputUserName);
			ActionContext.getContext().getSession().put("PWDSTATE",a);
			ActionContext.getContext().getSession().put("ISMG",b);
		}
		
		return SUCCESS;
	}
	
	//��̬���õ��˳���¼
	public String exitLogin() throws UnsupportedEncodingException{
		ActionContext ac = ActionContext.getContext();
        Map session = ac.getSession();
        session.clear();
		if(session.isEmpty()){
			String string = "1";
			yes = new ByteArrayInputStream(string.getBytes("utf-8"));
			return SUCCESS;
		}
		return ERROR;
	}
	
	
	
}
