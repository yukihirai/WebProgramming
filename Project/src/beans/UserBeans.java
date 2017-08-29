package beans;

import java.io.Serializable;

public class UserBeans implements Serializable{
	private String id;
	private String login_id;
	private String name;
	private String birth_date;
	private String password;
	private String create_date;
	private String update_date;


	public UserBeans() {

	}

	public UserBeans(String id,String login_id,String name,String birth_date,String password,String create_date,String update_date) {
		this.id = id;
		this.login_id = login_id;
		this.name = name;
		this.birth_date = birth_date;
		this.password = password;
		this.create_date = create_date;
		this.update_date = update_date;
	}
	public UserBeans(String login_id,String password) {
		this.login_id = login_id;
		this.password = password;

	}
	public UserBeans(String login_id,String name,String birth_date,String password,String create_date,String update_date) {
		this.login_id = login_id;
		this.name = name;
		this.birth_date = birth_date;
		this.password = password;
		this.create_date = create_date;
		this.update_date = update_date;
	}
	public UserBeans(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth_date() {
//		UtilLogic.convertDate(birth_date);
		return birth_date;
	}
	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}



}
