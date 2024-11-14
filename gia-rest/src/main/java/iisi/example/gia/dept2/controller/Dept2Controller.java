package iisi.example.gia.dept2.controller;

import iisi.example.gia.dept2.dto.Dept2AddDTO;
import iisi.example.gia.dept2.dto.Dept2InfoDTO;
import iisi.example.gia.dept2.dto.Dept2UpdateDTO;
import iisi.example.gia.dept2.service.Dept2Service;
import iisi.example.gia.dept2.view.Dept2AddReq;
import iisi.example.gia.dept2.view.Dept2InfoResVO;
import iisi.example.gia.dept2.view.Dept2UpdateReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/dept2")
public class Dept2Controller {

    @Autowired
    private Dept2Service dept2Service;

    // 新增
    @PostMapping("add")
    public int addDept2(@RequestBody Dept2AddReq deptAddReq) {
        // 包裝 DTO 交由 Service 新增
        Dept2AddDTO deptAddDTO = new Dept2AddDTO();
        deptAddDTO.setDname(deptAddReq.getDname());
        deptAddDTO.setLoc(deptAddReq.getLoc());

        return dept2Service.add(deptAddDTO);
    }

    // 刪除
    @DeleteMapping("delete/{deptno}")
    public int deleteDept2(@PathVariable Integer deptno){
        // 交由 Service 控制 DAO 刪除資料
        return dept2Service.delete(deptno);
    }

    // 修改
    @PutMapping("update")
    public int updateDept2(@RequestBody Dept2UpdateReq deptUpdateReq){
        // 包裝 DTO 交由 Service 修改
        Dept2UpdateDTO deptUpdateDTO = new Dept2UpdateDTO();
        deptUpdateDTO.setDeptno(deptUpdateReq.getDeptno());
        deptUpdateDTO.setDname(deptUpdateReq.getDname());
        deptUpdateDTO.setLoc(deptUpdateReq.getLoc());

        // 交由 Service 控制 DAO 刪除資料
        return dept2Service.update(deptUpdateDTO);
    }

    // 查詢 (單一)
    @GetMapping("findOne/{deptno}")
    public Dept2InfoResVO findOne(@PathVariable Integer deptno){
        // 交由 Service 查詢取得 DTO
        Dept2InfoDTO deptInfoDTO = dept2Service.findOne(deptno);

        // 包裝成 VO 提供前端
        Dept2InfoResVO deptInfoResVO = new Dept2InfoResVO();
        deptInfoResVO.setDeptno(deptInfoDTO.getDeptno());
        deptInfoResVO.setDname(deptInfoDTO.getDname());
        deptInfoResVO.setLoc(deptInfoDTO.getLoc());

        return deptInfoResVO;
    }

    // 查詢 (全部)
    @GetMapping("findAll")
    public List<Dept2InfoResVO> findAll(){
        // 交由 Service 控制 DAO 查詢資料
        List<Dept2InfoDTO> listAll = dept2Service.listDepts();

        // 包裝 VO 提供前端
        List<Dept2InfoResVO> findAll = new ArrayList<Dept2InfoResVO>();

        for(Dept2InfoDTO deptInfoDTO : listAll){
            Dept2InfoResVO deptInfoResVO = new Dept2InfoResVO();

            deptInfoResVO.setDeptno(deptInfoDTO.getDeptno());
            deptInfoResVO.setDname(deptInfoDTO.getDname());
            deptInfoResVO.setLoc(deptInfoDTO.getLoc());

            findAll.add(deptInfoResVO);
        }

        return findAll;
    }

}
