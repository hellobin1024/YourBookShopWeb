package HibernatePack;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * PythonbookCopy entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pythonbook_copy", catalog = "yourbookshop")

public class PythonbookCopy implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private String author;
	private String belongg;
	private String leibie;
	private String summaryy;
	private String picUrl;

	// Constructors

	/** default constructor */
	public PythonbookCopy() {
	}

	/** full constructor */
	public PythonbookCopy(String title, String author, String belongg, String leibie, String summaryy, String picUrl) {
		this.title = title;
		this.author = author;
		this.belongg = belongg;
		this.leibie = leibie;
		this.summaryy = summaryy;
		this.picUrl = picUrl;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "title", nullable = false)

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "author", nullable = false)

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Column(name = "belongg", nullable = false)

	public String getBelongg() {
		return this.belongg;
	}

	public void setBelongg(String belongg) {
		this.belongg = belongg;
	}

	@Column(name = "leibie", nullable = false)

	public String getLeibie() {
		return this.leibie;
	}

	public void setLeibie(String leibie) {
		this.leibie = leibie;
	}

	@Column(name = "summaryy", nullable = false, length = 1000)

	public String getSummaryy() {
		return this.summaryy;
	}

	public void setSummaryy(String summaryy) {
		this.summaryy = summaryy;
	}

	@Column(name = "PicUrl", nullable = false)

	public String getPicUrl() {
		return this.picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

}