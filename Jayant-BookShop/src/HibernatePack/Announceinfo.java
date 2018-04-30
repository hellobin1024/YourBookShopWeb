package HibernatePack;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Announceinfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "announceinfo", catalog = "yourbookshop")

public class Announceinfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private String announce;
	private Timestamp time;

	// Constructors

	/** default constructor */
	public Announceinfo() {
	}

	/** full constructor */
	public Announceinfo(String announce, Timestamp time) {
		this.announce = announce;
		this.time = time;
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

	@Column(name = "Announce", nullable = false, length = 200)

	public String getAnnounce() {
		return this.announce;
	}

	public void setAnnounce(String announce) {
		this.announce = announce;
	}

	@Column(name = "Time", nullable = false, length = 19)

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

}