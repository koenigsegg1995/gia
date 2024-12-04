package iisi.example.gia.emp2.view;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;
import java.util.Date;

// 動態查詢用，包裝使用者輸入搜尋參數
public class Emp2ComplexSelectReq {

    @Min(value = 1, message = "編號必須大於 1 ")
    @Max(value = 9999, message = "編號不能大於 9999")
    private Integer empno;

    @Pattern(regexp="[A-Za-z\\s]*", message = "請輸入大小寫英文姓名")
    private String ename;

    private String job;
    private String dname;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    @DecimalMin(value = "0.0", inclusive = false, message = "薪水必須大於 0")
    @Digits(integer = 5, fraction = 2, message = "整數不能大於 5 位，小數不能大於 2 位")
    private BigDecimal bottomSal;

    @DecimalMin(value = "0.0", inclusive = false, message = "薪水必須大於 0")
    @Digits(integer = 5, fraction = 2, message = "整數不能大於 5 位，小數不能大於 2 位")
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
