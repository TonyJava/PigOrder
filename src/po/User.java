package po;

/**
 * @author m1786
 *
 */
public  class User {
	private int uid;//id ����
	private String uname;//�û���
	private String upassword;//
	private String idno;//���֤��
	private String realname;//��ʵ����
	private int admin;//�Ƿ��ǹ���Ա
	
	public User(){
		super();
	}
	public User(int uid,String uname,String upassword,String idno,String realname,int admin){
		this.uid=uid;
		this.uname=uname;
		this.upassword=upassword;
		this.idno=idno;
		this.realname=realname;
		this.admin=admin;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getIdno() {
		return idno;
	}
	public void setIdno(String idno) {
		this.idno = idno;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	
	
	
	
}
