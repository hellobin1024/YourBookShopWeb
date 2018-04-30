package HibernatePack;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Userinfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "userinfo", catalog = "yourbookshop")

public class Userinfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private String userName;
	private String passWord;
	private String email;
	private String realName;
	private Short isMg;
	private String problem;
	private String answer;

	// Constructors

	/** default constructor */
	public Userinfo() {
	}

	/** full constructor */
	public Userinfo(String userName, String passWord, String email, String realName, Short isMg, String problem,
			String answer) {
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
		this.realName = realName;
		this.isMg = isMg;
		this.problem = problem;
		this.answer = answer;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID", unique = true, nullable = false)

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "UserName", nullable = false, length = 20)

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "PassWord", nullable = false, length = 20)

	public String getPassWord() {
		return this.passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Column(name = "Email", nullable = false, length = 50)

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "RealName", nullable = false, length = 10)

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	@Column(name = "IsMG", nullable = false)

	public Short getIsMg() {
		return this.isMg;
	}

	public void setIsMg(Short isMg) {
		this.isMg = isMg;
	}

	@Column(name = "Problem", nullable = false, length = 200)

	public String getProblem() {
		return this.problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	@Column(name = "Answer", nullable = false, length = 200)

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}