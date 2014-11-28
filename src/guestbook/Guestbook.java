package guestbook;

import java.sql.Date;

public class Guestbook {
	// 필드 선언.
	private long id;
	private String name;
	private String content;
	private Date createDate;
	private String ip;
	
	// 기본 생성자
	public Guestbook(){
		createDate 
			= new Date(System.currentTimeMillis());
	}
	
	

	public Guestbook(long id, String name, String content, String ip) {
		this(); // 자기 자신의 생성자를 호출
		this.id = id;
		this.name = name;
		this.content = content;
		this.ip = ip;
	}



	// getter, setter 를 만든다.
	// getId(), seId() 메소드를 id property 라고도
	// 부른다.
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {
		return "Guestbook [id=" + id + ", name=" + name + ", content="
				+ content + ", createDate=" + createDate + ", ip=" + ip + "]";
	}
	
	
}
