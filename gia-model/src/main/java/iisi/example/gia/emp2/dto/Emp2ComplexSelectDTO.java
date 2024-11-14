package iisi.example.gia.emp2.dto;

import java.math.BigDecimal;
import java.sql.Date;

// 包裝動態查詢資料與資料庫溝通
public class Emp2ComplexSelectDTO {

    private Integer empno;
    private String ename;
    private String job;
    private String dname;
    private Date startDate;
    private Date endDate;
    private BigDecimal bottomSal;
    private BigDecimal topSal;

    // 分頁用
    private Integer Offset; // 起始位置
    private Integer limit; // 每頁筆數

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

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getBottomSal() {
        return bottomSal;
    }

    public void setBottomSal(BigDecimal bottomSal) {
        this.bottomSal = bottomSal;
    }

    public BigDecimal getTopSal() {
        return topSal;
    }

    public void setTopSal(BigDecimal topSal) {
        this.topSal = topSal;
    }

    public Integer getOffset() {
        return Offset;
    }

    public void setOffset(Integer offset) {
        Offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

}
