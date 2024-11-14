package iisi.example.gia.emp2.dto;

import java.math.BigDecimal;
import java.sql.Date;

// 動態查詢結果
public class Emp2ComplexSelectRes {

    private Integer empno;
    private String ename;
    private String job;
    private Date hiredate;
    private String dname;
    private BigDecimal sal;

    //Getters & Setters
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

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public BigDecimal getSal() {
        return sal;
    }

    public void setSal(BigDecimal sal) {
        this.sal = sal;
    }

}
