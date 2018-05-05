package ExecuteDo;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class doCheckLogin extends AbstractInterceptor  {
	//未登录时的返回的流~
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
		//如果一开始并没有登录的时候,是没有session这个key键的,所以加多一个判断
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
