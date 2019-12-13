package problem.DDEnter;

import javax.xml.crypto.Data;

public class MemberDTO {
	// 1. 변수(DB Table 참조)
	private String ano;
	private String aname;
	private String major;
	private String groupyn;
	private String groupnm;
	private int sal;
	private Data regdate;

	// 2. 생성자(Default, 전역변수 All)
	public MemberDTO() {
	}

	public MemberDTO(String ano, String aname, String major, 
			String groupyn, String groupnm, int sal, Data regdate) {
		super();
		this.ano = ano;
		this.aname = aname;
		this.major = major;
		this.groupyn = groupyn;
		this.groupnm = groupnm;
		this.sal = sal;
		this.regdate = regdate;
	}
	

	public MemberDTO(String aname, String major, String groupyn, String groupnm, int sal) {
		super();
		this.aname = aname;
		this.major = major;
		this.groupyn = groupyn;
		this.groupnm = groupnm;
		this.sal = sal;
	}
	
	

	public MemberDTO(String ano, String aname, String major, String groupyn, String groupnm, int sal) {
		super();
		this.ano = ano;
		this.aname = aname;
		this.major = major;
		this.groupyn = groupyn;
		this.groupnm = groupnm;
		this.sal = sal;
	}

	// 3. getter(), setter()
	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getGroupyn() {
		return groupyn;
	}

	public void setGroupyn(String groupyn) {
		this.groupyn = groupyn;
	}

	public String getGroupnm() {
		return groupnm;
	}

	public void setGroupnm(String groupnm) {
		this.groupnm = groupnm;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public Data getRegdate() {
		return regdate;
	}

	public void setRegdate(Data regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "MemberDTO [ano=" + ano + ", aname=" + aname + ", major=" + major + ", groupyn=" + groupyn + ", groupnm="
				+ groupnm + ", sal=" + sal + ", regdate=" + regdate + "]";
	}
	
	//4.toString()
	
}
