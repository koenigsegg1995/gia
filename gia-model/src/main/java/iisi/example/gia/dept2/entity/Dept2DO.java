package iisi.example.gia.dept2.entity;

import java.io.Serializable;

// 後端存取資料庫使用
public class Dept2DO implements Serializable {

	private Integer deptno;
	private String dname;
	private String loc;

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

}
