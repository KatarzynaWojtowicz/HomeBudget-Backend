package pl.katarzynawojtowicz.BudgetPlanner.user;

public class UserTo {
	private long id;
	private String login;
	private String password;
	private String email;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public UserTo(long id, String login, String password) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
	}

	public UserTo() {
		super();
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
