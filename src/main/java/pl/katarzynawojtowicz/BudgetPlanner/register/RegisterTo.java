package pl.katarzynawojtowicz.BudgetPlanner.register;

public class RegisterTo {
	private String name;
	private String lastName;
	private String login;
	private String password;
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public void setEmail(String email) {
		this.email = email;
	}

	public RegisterTo(String name, String lastName, String login, String password, String email) {
		this.name = name;
		this.lastName = lastName;
		this.login = login;
		this.password = password;
		this.email = email;
	}

	public RegisterTo() {
		// TODO Auto-generated constructor stub
	}

}
