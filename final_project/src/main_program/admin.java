package main_program;

public class admin {
	protected String account ;
	protected String password ;
	protected String name ;
	
	public admin(String name,String account,String password) {
		setName( name);
		setAccount( account);
		setPassword( password);
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "\naccount=" + account + ", password=" + password + ", name=" + name ;
	}
	
	
	
}
