package iisi.example.gia.emp2.controller;

import iisi.example.gia.dept2.service.Dept2Service;
import iisi.example.gia.emp2.dto.*;
import iisi.example.gia.emp2.service.Emp2Service;
import iisi.example.gia.emp2.view.Emp2AddReq;
import iisi.example.gia.emp2.view.Emp2ComplexSelectReq;
import iisi.example.gia.emp2.view.Emp2ComplexSelectResVO;
import iisi.example.gia.emp2.view.Emp2UpdateReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/emp2")
public class Emp2Controller {

    @Autowired
    private Emp2Service emp2Service;

    @Autowired
    private Dept2Service dept2Service;

    /**************** 新增 ****************/

    // 跳轉新增頁面
    @GetMapping("goToAdd")
    public String goToAdd(ModelMap model){
        // 創建空 OBJECT 等待包裝新增內容
        Emp2AddReq empAddReq = new Emp2AddReq();

        model.addAttribute("empAddReq", empAddReq);

        return "addEmp";
    }

    // 送出新增
    @PostMapping("addEmp")
    @ResponseBody
    public Integer addEmp(@RequestBody Emp2AddReq empAddReq) {
        // 轉為 AddDTO
        Emp2AddDTO empAddDTO = new Emp2AddDTO();
        empAddDTO.setEname(empAddReq.getEname());
        empAddDTO.setJob(empAddReq.getJob());
        empAddDTO.setHiredate(empAddReq.getHiredate());
        empAddDTO.setSal(empAddReq.getSal());
        empAddDTO.setComm(empAddReq.getComm());
        empAddDTO.setDeptno(empAddReq.getDeptno());

        // 交由 Service 控制 DAO 新增進資料庫
        return emp2Service.addEmp(empAddDTO);
    }

    /**************** 刪除 ****************/
    @DeleteMapping("delete/{empno}")
    @ResponseBody
    public Integer deleteEmp(@PathVariable Integer empno){
        // 交由 Service 控制 DAO 刪除資料
        return emp2Service.deleteEmp(empno);
    }

    /**************** 修改 ****************/

    // 跳轉修改頁面
    @PostMapping("goToUpdate")
    public String goToUpdate(@RequestParam("empno") Integer empno, ModelMap model){
        // 查詢該編號員工資料，並包裝成 Req 給前端顯示並作為 Req 回傳修改
        Emp2SelectOneDTO empSelectOneDTO = emp2Service.selectOne(empno);
        Emp2UpdateReq empUpdateReq = new Emp2UpdateReq();

        empUpdateReq.setEmpno(empSelectOneDTO.getEmpno());
        empUpdateReq.setEname(empSelectOneDTO.getEname());
        empUpdateReq.setJob(empSelectOneDTO.getJob());
        empUpdateReq.setHiredate(empSelectOneDTO.getHiredate());
        empUpdateReq.setSal(empSelectOneDTO.getSal());
        empUpdateReq.setComm(empSelectOneDTO.getComm());
        empUpdateReq.setDeptno(empSelectOneDTO.getDeptno());

        model.addAttribute("empUpdateReq", empUpdateReq);

        return "updateEmp";
    }

    // 送出更新
    @PostMapping("updateEmp")
    @ResponseBody
    public Integer updateEmp(@RequestBody Emp2UpdateReq empUpdateReq){
        // 包裝成 DTO 交由 Service 控制 DAO 更新資料
        Emp2UpdateDTO empUpdateDTO = new Emp2UpdateDTO();
        empUpdateDTO.setEmpno(empUpdateReq.getEmpno());
        empUpdateDTO.setEname(empUpdateReq.getEname());
        empUpdateDTO.setJob(empUpdateReq.getJob());
        empUpdateDTO.setHiredate(empUpdateReq.getHiredate());
        empUpdateDTO.setSal(empUpdateReq.getSal());
        empUpdateDTO.setComm(empUpdateReq.getComm());
        empUpdateDTO.setDeptno(empUpdateReq.getDeptno());

        return emp2Service.updateEmp(empUpdateDTO);
    }

    /*************** 查詢 (動態) **********/

    // 送出查詢
    @PostMapping("selectEmp")
    @ResponseBody
    public Emp2ComplexSelectResVO selectEmp(@RequestBody Emp2ComplexSelectReq empSelectReq, @RequestParam(name = "pageActions", required = false) String pageActions, ModelMap model){
        // 處理上下頁設定
        if("prev".equals(pageActions)) {
            empSelectReq.setPage(empSelectReq.getPage() - 1);
        }else if("next".equals(pageActions)){
            empSelectReq.setPage(empSelectReq.getPage() + 1);
        }

        // 保留查詢條件
        model.addAttribute("empSelectReq", empSelectReq);

        // 包裝 DTO 給 Service 用
        Emp2ComplexSelectReqDTO empComplexSelectReqDTO = new Emp2ComplexSelectReqDTO();
        empComplexSelectReqDTO.setEmpno(empSelectReq.getEmpno());
        empComplexSelectReqDTO.setEname(empSelectReq.getEname());
        empComplexSelectReqDTO.setJob(empSelectReq.getJob());
        empComplexSelectReqDTO.setDname(empSelectReq.getDname());
        empComplexSelectReqDTO.setStartDate(empSelectReq.getStartDate());
        empComplexSelectReqDTO.setEndDate(empSelectReq.getEndDate());
        empComplexSelectReqDTO.setBottomSal(empSelectReq.getBottomSal());
        empComplexSelectReqDTO.setTopSal(empSelectReq.getTopSal());
        empComplexSelectReqDTO.setPage(empSelectReq.getPage());
        empComplexSelectReqDTO.setLimit(empSelectReq.getLimit());

        // 包裝 VO 提供前端
        Emp2ComplexSelectViewDTO empSelectViewDTO = emp2Service.selectEmps(empComplexSelectReqDTO);
        Emp2ComplexSelectResVO empSelecResVO = new Emp2ComplexSelectResVO();

        empSelecResVO.setEmpSelectRes(empSelectViewDTO.getEmpSelectRes());
        empSelecResVO.setPageInfo(empSelectViewDTO.getPageInfo());

        return empSelecResVO;
    }

    // 下拉式選單資料
    @ModelAttribute
    public void listJobs(ModelMap model){
        model.addAttribute("jobs", emp2Service.listJobs());
    }

    @ModelAttribute
    public void listDepts(ModelMap model){
        model.addAttribute("depts", dept2Service.listDepts());
    }

}
