package iisi.example.gia.emp2.service;

import iisi.example.gia.emp2.dao.Emp2DAO;
import iisi.example.gia.emp2.dto.*;
import iisi.example.gia.emp2.dto.Emp2ComplexSelectRes;
import iisi.example.gia.emp2.entity.Emp2DO;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class Emp2Service {
    
    @Autowired
    private Emp2DAO emp2DAO;

    // INSERT
    @Transactional
    public int addEmp(Emp2AddDTO empAddDTO){
        // 創建 DO 包裝資料
        Emp2DO emp2DO = new Emp2DO();

        // 取出請求參數，包裝 VO
        emp2DO.setEname(empAddDTO.getEname());
        emp2DO.setJob(empAddDTO.getJob());
        emp2DO.setHiredate(new java.sql.Date(empAddDTO.getHiredate().getTime()));
        emp2DO.setSal(empAddDTO.getSal());
        emp2DO.setComm(empAddDTO.getComm());
        emp2DO.setDeptno(empAddDTO.getDeptno());

        return emp2DAO.insert(emp2DO);
    }

    // DELETE
    @Transactional
    public int deleteEmp(Integer empno){
        return emp2DAO.delete(empno);
    }

    // UPDATE
    @Transactional
    public int updateEmp(Emp2UpdateDTO empUpdateDTO){
        // 創建 VO 包裝資料
        Emp2DO emp2DO = new Emp2DO();

        // 取出請求參數，包裝 VO
        emp2DO.setEmpno(empUpdateDTO.getEmpno());
        emp2DO.setEname(empUpdateDTO.getEname());
        emp2DO.setJob(empUpdateDTO.getJob());
        emp2DO.setSal(empUpdateDTO.getSal());
        emp2DO.setComm(empUpdateDTO.getComm());
        emp2DO.setDeptno(empUpdateDTO.getDeptno());

        return emp2DAO.update(emp2DO);
    }

    // Complex SELECT
    public Emp2ComplexSelectViewDTO selectEmps(Emp2ComplexSelectReqDTO empComplexSelectReqDTO){
        // 創建 DTO 傳送資料給資料庫
        Emp2ComplexSelectDTO empComplexSelectDTO = new Emp2ComplexSelectDTO();

        /*** 設定 Req 資料進 DTO ，並排除空字串 ***/
        empComplexSelectDTO.setEmpno(empComplexSelectReqDTO.getEmpno());

        // 首次進入頁面值為 null
        if(empComplexSelectReqDTO.getEname() != null){
            if(empComplexSelectReqDTO.getEname().trim().isEmpty()) {
                empComplexSelectDTO.setEname(null);
            }else{
                empComplexSelectDTO.setEname(empComplexSelectReqDTO.getEname().trim());
            }
        }

        if(empComplexSelectReqDTO.getJob() != null){
            if(empComplexSelectReqDTO.getJob().trim().isEmpty()) {
                empComplexSelectDTO.setJob(null);
            }else{
                empComplexSelectDTO.setJob(empComplexSelectReqDTO.getJob().trim());
            }
        }

        if(empComplexSelectReqDTO.getDname() != null){
            if(empComplexSelectReqDTO.getDname().trim().isEmpty()){
                empComplexSelectDTO.setDname(null);
            }else{
                empComplexSelectDTO.setDname(empComplexSelectReqDTO.getDname().trim());
            }
        }

        if(empComplexSelectReqDTO.getStartDate() != null){
            if(empComplexSelectReqDTO.getStartDate().toString().trim().isEmpty()){
                empComplexSelectDTO.setStartDate(null);
            }else {
                empComplexSelectDTO.setStartDate(new java.sql.Date(empComplexSelectReqDTO.getStartDate().getTime()));
            }
        }

        if(empComplexSelectReqDTO.getEndDate() != null){
            if(empComplexSelectReqDTO.getEndDate().toString().trim().isEmpty()){
                empComplexSelectDTO.setEndDate(null);
            }else{
                empComplexSelectDTO.setEndDate(new java.sql.Date(empComplexSelectReqDTO.getEndDate().getTime()));
            }
        }

        if(empComplexSelectReqDTO.getBottomSal() != null){
            if(empComplexSelectReqDTO.getBottomSal().toString().trim().isEmpty()){
                empComplexSelectDTO.setBottomSal(null);
            }else{
                empComplexSelectDTO.setBottomSal(empComplexSelectReqDTO.getBottomSal());
            }
        }

        if(empComplexSelectReqDTO.getTopSal() != null){
            if(empComplexSelectReqDTO.getTopSal().toString().trim().isEmpty()){
                empComplexSelectDTO.setTopSal(null);
            }else{
                empComplexSelectDTO.setTopSal(empComplexSelectReqDTO.getTopSal());
            }
        }

        empComplexSelectDTO.setOffset((empComplexSelectReqDTO.getPage() - 1) * empComplexSelectReqDTO.getLimit());

        empComplexSelectDTO.setLimit(empComplexSelectReqDTO.getLimit());

        /************************************/

        // 得到 Emp2WithDnameDTO 集合
        List<Emp2WithDnameDTO> empDTOs = emp2DAO.selectEmps(empComplexSelectDTO);

        // 取得查詢結果筆數
        Integer selectEmpsCount = emp2DAO.selectEmpsCount(empComplexSelectDTO);
        Integer totalPages = (int)(Math.ceil((double)selectEmpsCount / empComplexSelectReqDTO.getLimit()));

        // 創建 Emp2ComplexSelectRes 集合
        List<Emp2ComplexSelectRes> empSelectRes = new ArrayList<Emp2ComplexSelectRes>();

        // 包裝成 Emp2ComplexSelectRes 並裝進集合
        for(Emp2WithDnameDTO empDTO : empDTOs){
            // 創建 empSelectRes 供前端顯示
            Emp2ComplexSelectRes emp = new Emp2ComplexSelectRes();

            // 設定資料進 empSelectRes
            emp.setEmpno(empDTO.getEmpno());
            emp.setEname(empDTO.getEname());
            emp.setJob(empDTO.getJob());
            emp.setHiredate(empDTO.getHiredate());
            emp.setDname(empDTO.getDname());
            emp.setSal(empDTO.getSal());

            empSelectRes.add(emp);
        }

        // 創建 PageInfo 設定分頁資訊
        PageInfo pageInfo = new PageInfo();

        pageInfo.setPage(empComplexSelectReqDTO.getPage());
        pageInfo.setTotalPages(totalPages);
        pageInfo.setSelectEmpsCount(selectEmpsCount);

        // 創建 VO 包裝兩個資訊
        Emp2ComplexSelectViewDTO empSelectViewDTO = new Emp2ComplexSelectViewDTO();
        empSelectViewDTO.setEmpSelectRes(empSelectRes);
        empSelectViewDTO.setPageInfo(pageInfo);

        return empSelectViewDTO;
    }

    // SELECT One (給更新帶入資料用)
    public Emp2SelectOneDTO selectOne(Integer empno){
        // 查詢取得 DO
        Emp2DO emp2DO = emp2DAO.selectOne(empno);

        // 創建 DTO 包裝資料
        Emp2SelectOneDTO emp2SelectOneDTO = new Emp2SelectOneDTO();
        // 將 VO 資料包裝 DTO
        emp2SelectOneDTO.setEmpno(emp2DO.getEmpno());
        emp2SelectOneDTO.setEname(emp2DO.getEname());
        emp2SelectOneDTO.setJob(emp2DO.getJob());
        emp2SelectOneDTO.setHiredate(emp2DO.getHiredate());
        emp2SelectOneDTO.setSal(emp2DO.getSal());
        emp2SelectOneDTO.setComm(emp2DO.getComm());
        emp2SelectOneDTO.setDeptno(emp2DO.getDeptno());

        return emp2SelectOneDTO;
    }

    // SELECT Jobs (給搜尋下拉式選單使用)
    public Set<String> listJobs(){
        return emp2DAO.listJobs();
    }

}
