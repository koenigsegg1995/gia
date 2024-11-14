package iisi.example.gia.emp2.dto;

import iisi.example.gia.dept2.dto.Dept2InfoDTO;

import java.math.BigDecimal;
import java.sql.Date;

// 包裝 Select & Update 資料用
public class Emp2Req {

    private Integer empno;
    private String ename;
    private String job;
    private Date hiredate;
    private BigDecimal sal;
    private BigDecimal comm;
    private Dept2InfoDTO dept;

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public BigDecimal getSal() {
        return sal;
    }

    public void setSal(BigDecimal sal) {
        this.sal = sal;
    }

    public BigDecimal getComm() {
        return comm;
    }

    public void setComm(BigDecimal comm) {
        this.comm = comm;
    }

    public Dept2InfoDTO getDept() {
        return dept;
    }

    public void setDept(Dept2InfoDTO dept) {
        this.dept = dept;
    }

}
