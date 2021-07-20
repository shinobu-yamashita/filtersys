package sample.Beans;

public class MenuBeans implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String m_menu_menunm = "";
	private int m_menu_menuix = 0;
	private String m_menu_menunn = "";
	private String m_menu_menumm = "";
	private String m_menu_active = "0";


	//menunm propaty
	public String getMenunm() {
		return this.m_menu_menunm;
	}
	public void setMenunm(String val) {
		this.m_menu_menunm = val;
	}


	//menuix propaty
	public int getMenuix() {
		return this.m_menu_menuix;
	}
	public void setMenuix(int val) {
		this.m_menu_menuix = val;
	}


	//menunn propaty
	public String getMenunn() {
		return this.m_menu_menunn;
	}
	public void setMenunn(String val) {
		this.m_menu_menunn = val;
	}


	//menumm propaty
	public String getMenumm() {
		return this.m_menu_menumm;
	}
	public void setMenumm(String val) {
		this.m_menu_menumm = val;
	}


	//active propaty
	public String getActive() {
		return this.m_menu_active;
	}
	public void setActive(String val) {
		this.m_menu_active = val;
	}


}
