package Info;

public class PageBookList implements java.io.Serializable {
	
	private Integer id;
	private String title;
	private String author;
	private String belongg;
	private String leibie;
	private String summaryy;
	private String picUrl;
	
	public PageBookList(){
		
	}
	public PageBookList(Integer id,String title,String author,String belongg,String leibie,String summaryy,String picUrl){
		this.id = id;
		this.title = title;
		this.author = author;
		this.belongg = belongg;
		this.leibie = leibie;
		this.summaryy = summaryy;
		this.picUrl = picUrl;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLeibie() {
		return leibie;
	}
	public void setLeibie(String leibie) {
		this.leibie = leibie;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBelongg() {
		return belongg;
	}
	public void setBelongg(String belongg) {
		this.belongg = belongg;
	}
	public String getSummaryy() {
		return summaryy;
	}
	public void setSummaryy(String summaryy) {
		this.summaryy = summaryy;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	
	
}
