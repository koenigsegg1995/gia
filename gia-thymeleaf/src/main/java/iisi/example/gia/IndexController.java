package iisi.example.gia;

import iisi.example.gia.dept2.service.Dept2Service;
import iisi.example.gia.emp2.dto.Emp2ComplexSelectReqDTO;
import iisi.example.gia.emp2.dto.Emp2ComplexSelectViewDTO;
import iisi.example.gia.emp2.service.Emp2Service;
import iisi.example.gia.emp2.view.Emp2ComplexSelectReq;
import iisi.example.gia.emp2.view.Emp2ComplexSelectResVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.stream.Collectors;

// 導向首頁
@Controller
public class IndexController {

    @Autowired
    private Emp2Service emp2Service;

    @Autowired
    private Dept2Service dept2Service;

    /*************** 導向主頁 *************/
    @GetMapping("/")
    public String index(ModelMap model, Authentication authentication){
        // 用戶資訊加入 model
        if(authentication != null){
            model.addAttribute("username", authentication.getName());
            model.addAttribute("role", authentication.getAuthorities().stream()
                                                    .map(a -> a.getAuthority().replace("ROLE_", ""))
                                                    .collect(Collectors.joining(", ")));
        }

        // 創建空 OBJECT 等待包裝動態查詢內容
        Emp2ComplexSelectReq empSelectReq = new Emp2ComplexSelectReq();
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

        // 預設無條件查詢，顯示所有員工
        model.addAttribute("empSelectResVO", empSelecResVO);

        return "index";
    }

    /*************** 查詢 (工作) **********/

    @ModelAttribute
    public void listJobs(ModelMap model){
        model.addAttribute("jobs", emp2Service.listJobs());
    }

    /*************** 查詢 (部門) **********/
    @ModelAttribute
    public void listDepts(ModelMap model){
        model.addAttribute("depts", dept2Service.listDepts());
    }

}
