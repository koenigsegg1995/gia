package iisi.example.gia.emp2.controller;

import iisi.example.gia.dept2.service.Dept2Service;
import iisi.example.gia.emp2.dto.*;
import iisi.example.gia.emp2.service.Emp2Service;
import iisi.example.gia.emp2.view.Emp2AddReq;
import iisi.example.gia.emp2.view.Emp2ComplexSelectReq;
import iisi.example.gia.emp2.view.Emp2ComplexSelectResVO;
import iisi.example.gia.emp2.view.Emp2UpdateReq;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    @GetMapping("goToAdd")
    public String goToAdd(ModelMap model){
        // 創建空 OBJECT 等待包裝新增內容
        Emp2AddReq empAddReq = new Emp2AddReq();

        model.addAttribute("empAddReq", empAddReq);

        return "addEmp";
    }

    // 送出新增
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    @PostMapping("addEmp")
    public String addEmp(@ModelAttribute Emp2AddReq empAddReq) {
        // 轉為 AddDTO
        Emp2AddDTO empAddDTO = new Emp2AddDTO();
        empAddDTO.setEname(empAddReq.getEname());
        empAddDTO.setJob(empAddReq.getJob());
        empAddDTO.setHiredate(empAddReq.getHiredate());
        empAddDTO.setSal(empAddReq.getSal());
        empAddDTO.setComm(empAddReq.getComm());
        empAddDTO.setDeptno(empAddReq.getDeptno());

        // 交由 Service 控制 DAO 新增進資料庫
        emp2Service.addEmp(empAddDTO);

        // 重導回首頁
        return "redirect:/";
    }

    /**************** 刪除 ****************/
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("delete")
    public String deleteEmp(@RequestParam("empno") Integer empno){
        // 交由 Service 控制 DAO 刪除資料
        emp2Service.deleteEmp(empno);

        return "redirect:/";
    }

    /**************** 修改 ****************/

    // 跳轉修改頁面
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
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
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    @PostMapping("updateEmp")
    public String updateEmp(@ModelAttribute Emp2UpdateReq empUpdateReq){
        // 包裝成 DTO 交由 Service 控制 DAO 更新資料
        Emp2UpdateDTO empUpdateDTO = new Emp2UpdateDTO();
        empUpdateDTO.setEmpno(empUpdateReq.getEmpno());
        empUpdateDTO.setEname(empUpdateReq.getEname());
        empUpdateDTO.setJob(empUpdateReq.getJob());
        empUpdateDTO.setHiredate(empUpdateReq.getHiredate());
        empUpdateDTO.setSal(empUpdateReq.getSal());
        empUpdateDTO.setComm(empUpdateReq.getComm());
        empUpdateDTO.setDeptno(empUpdateReq.getDeptno());

        emp2Service.updateEmp(empUpdateDTO);

        return "redirect:/";
    }

    /*************** 查詢 (動態) **********/

    // 送出查詢
    @PostMapping("selectEmp")
    public String selectEmp(@Valid @ModelAttribute Emp2ComplexSelectReq empSelectReq,
                            BindingResult bindingResult,
                            @RequestParam(name = "pageActions", required = false) String pageActions,
                            ModelMap model,
                            HttpSession session){

        // 錯誤驗證
        if(bindingResult.hasErrors()){
            // 保留查詢條件
            model.addAttribute("empSelectReq", empSelectReq);

            // 保留錯誤資訊
            model.addAttribute("org.springframework.validation.BindingResult.empSelectReq", bindingResult);

            // 顯示最近查詢結果
            model.addAttribute("empSelectResVO", session.getAttribute("lastSelect"));

            return "index";
        }

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

        // 保存最近查詢結果
        session.setAttribute("lastSelect", empSelecResVO);

        // 預設無條件查詢，顯示所有員工
        model.addAttribute("empSelectResVO", empSelecResVO);

        return "index";
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
