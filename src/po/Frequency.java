package po;

public class Frequency {
	private int fid;//序号
	private String fname;//车次
	private String faddress;//终点站
	private String starttime;//开车时间
	private double kilometers;//距离
	private String type;//类型
	private int level;//级别
	
	public Frequency(){
		super();
	}

	public Frequency(int fid, String fname, String faddress, String starttime, double kilometers, String type,
			int level) {
		super();
		this.fid = fid;
		this.fname = fname;
		this.faddress = faddress;
		this.starttime = starttime;
		this.kilometers = kilometers;
		this.type = type;
		this.level = level;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFaddress() {
		return faddress;
	}

	public void setFaddress(String faddress) {
		this.faddress = faddress;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public double getKilometers() {
		return kilometers;
	}

	public void setKilometers(double kilometers) {
		this.kilometers = kilometers;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	
}
