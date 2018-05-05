package ExecuteDo;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class doCheckLogin extends AbstractInterceptor  {
	//δ��¼ʱ�ķ��ص���~
	private InputStream falsebook;
	public InputStream getFalsebook() {
		return falsebook;
	}
	public void setFalsebook(InputStream falsebook) {
		this.falsebook = falsebook;
	}


	@Override
	public String intercept(ActionInvocation invocation)  throws Exception {
		//Map session = invocation.getInvocationContext().getSession();
		Map session = ActionContext.getContext().getSession();
		System.out.println(session);
		//���һ��ʼ��û�е�¼��ʱ��,��û��session���key����,���ԼӶ�һ���ж�
		if(session.get("PWDSTATE")==null){
			String result = invocation.invoke();
			return result;
		}
		else{
			if(session.get("PWDSTATE").equals(0)){
				return "truebook";
			}
			else{
				String result = invocation.invoke();
				return result;
			}
		}
	}

}
