package selenium_cherkasov.model;

public class User  {

	private String id;
	private String username;
	private String email;
	private String password;
	private String role;
	private String firstName;
	private String lastName;
	
	
	public User userRegister(String username, String firstname, String lastname, String password, String role) {
		return new User().setUsername(username).setFirstName(firstname).setLastName(lastname).setPassword(password).setRole(role);
	}
	
	public User userLogin(String username, String password) {
		return new User().setUsername(username).setPassword(password);
	}

	public String getId() {
		return id;
	}
	public User setId(String id) {
		this.id = id;
		return this;
	}
	public String getUsername() {
		return username;
	}
	public User setUsername(String username) {
		this.username = username;
		return this;
	}
	public String getFirstName() {
		return firstName;
	}
	public User setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	public String getLastName() {
		return lastName;
	}
	public User setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public User setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public User setPassword(String password) {
		this.password = password;
		return this;
	}
	public String getRole() {
		return role;
	}
	public User setRole(String role) {
		this.role = role;
		return this;
	}
	
}
