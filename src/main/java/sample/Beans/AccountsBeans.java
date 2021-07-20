package sample.Beans;

public class AccountsBeans implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private String m_accounts_userid = "";
	private String m_accounts_passwd = "";
	private String m_accounts_usernm = "";
	private String m_accounts_userac = "0";
	private String m_accounts_menunm = "";
	private String m_accounts_active = "0";
	
	
	//userid propaty
	public String getUserid() {
		return this.m_accounts_userid;
	}
	public void setUserid(String val) {
		this.m_accounts_userid = val;
	}


	//passwd propaty
	public String getPasswd() {
		return this.m_accounts_passwd;
	}
	public void setPasswd(String val) {
		this.m_accounts_passwd = val;
	}


	//usernm propaty
	public String getUsernm() {
		return this.m_accounts_usernm;
	}
	public void setUsernm(String val) {
		this.m_accounts_usernm = val;
	}


	//userac propaty
	public String getUserac() {
		return this.m_accounts_userac;
	}
	public void setUserac(String val) {
		this.m_accounts_userac = val;
	}


	//menunm propaty
	public String getMenunm() {
		return this.m_accounts_menunm;
	}
	public void setMenunm(String val) {
		this.m_accounts_menunm = val;
	}

	
	//active propaty
	public String getActive() {
		return this.m_accounts_active;
	}
	public void setActive(String val) {
		this.m_accounts_active = val;
	}

}
