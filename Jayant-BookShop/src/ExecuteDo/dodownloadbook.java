package ExecuteDo;

import java.io.File;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class dodownloadbook extends ActionSupport{
	//���ص��ļ�������
	public InputStream bookfile;
	public InputStream getBookfile() {
		return bookfile;
	}
	public void setBookfile(InputStream bookfile) {
		this.bookfile = bookfile;
	}
	//�ļ���
	public String filename;
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public String execute() throws Exception{
		//String projectPath = ServletActionContext.getServletContext().getRealPath(File.separator+"\\BookFile\\offer.pdf");
		//System.out.println(projectPath);
		//Ŀǰȫ�������ؽ�ָ��pdf,��Ϊû׼����ô���ļ�
		bookfile = ServletActionContext.getServletContext().getResourceAsStream("\\BookFile\\offer.pdf");
		//System.out.println(bookfile);
		filename= new String("��ָOffer.pdf".getBytes(),"ISO8859-1");
		//System.out.println(filename);
		return SUCCESS;
	}
}
