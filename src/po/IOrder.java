package po;

public class IOrder {
	private int oid;
	private int userid;
	private String finaladdress;
	private int frequencyid;
	private double price;
	private int state;
	public IOrder(){
		super();
	}
	public IOrder(int oid, int userid, String finaladdress, int frequencyid, double price, int state) {
		super();
		this.oid = oid;
		this.userid = userid;
		this.finaladdress = finaladdress;
		this.frequencyid = frequencyid;
		this.price = price;
		this.state = state;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getFinaladdress() {
		return finaladdress;
	}
	public void setFinaladdress(String finaladdress) {
		this.finaladdress = finaladdress;
	}
	public int getFrequencyid() {
		return frequencyid;
	}
	public void setFrequencyid(int frequencyid) {
		this.frequencyid = frequencyid;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
}
