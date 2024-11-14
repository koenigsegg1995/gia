package iisi.example.gia.emp2.dto;

import iisi.example.gia.dept2.dto.Dept2InfoDTO;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

// 動態查詢用，包裝使用者輸入搜尋參數
public class Emp2ComplexSelectReq {

    private Integer empno;
    private String ename;
    private String job;
    private Dept2InfoDTO dept;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    private BigDecimal bottomSal;
    private BigDecimal topSal;

    // 分頁用
    private Integer page = 1; // 預設第一頁
    private Integer limit = 5; // 每頁筆數，預設 5 筆

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

    public Dept2InfoDTO getDept() {
        return dept;
    }

    public void setDept(Dept2InfoDTO dept) {
        this.dept = dept;
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

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}