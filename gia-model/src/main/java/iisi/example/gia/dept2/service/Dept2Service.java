package iisi.example.gia.dept2.service;

import iisi.example.gia.dept2.dao.Dept2DAO;
import iisi.example.gia.dept2.dto.Dept2AddDTO;
import iisi.example.gia.dept2.dto.Dept2InfoDTO;
import iisi.example.gia.dept2.dto.Dept2UpdateDTO;
import iisi.example.gia.dept2.entity.Dept2DO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class Dept2Service {

    @Autowired
    private Dept2DAO dept2DAO;

    // INSERT
    @Transactional
    public int add(Dept2AddDTO deptAddDTO){
        // 創建 VO 包裝資料
        Dept2DO dept2DO = new Dept2DO();

        // 取出請求參數 ，包裝 VO
        dept2DO.setDname(deptAddDTO.getDname());
        dept2DO.setLoc(deptAddDTO.getLoc());

        return dept2DAO.insert(dept2DO);
    }

    // DELETE
    @Transactional
    public int delete(Integer deptno){
        return dept2DAO.delete(deptno);
    }

    // UPDATE
    @Transactional
    public int update(Dept2UpdateDTO deptUpdateDTO){
        // 創建 VO 包裝資料
        Dept2DO dept2DO = new Dept2DO();

        // 取出請求參數，包裝 VO
        dept2DO.setDeptno(deptUpdateDTO.getDeptno());
        dept2DO.setDname(deptUpdateDTO.getDname());
        dept2DO.setLoc(deptUpdateDTO.getLoc());

        return dept2DAO.update(dept2DO);
    }

    // SELECT One
    public Dept2InfoDTO findOne(Integer deptno){
        // 查詢取得 VO
        Dept2DO dept2DO = dept2DAO.selectOne(deptno);

        // 創建 DTO 包裝資料
        Dept2InfoDTO resDTO = new Dept2InfoDTO();
        // 將 VO 資料包裝 DTO
        resDTO.setDeptno(dept2DO.getDeptno());
        resDTO.setDname(dept2DO.getDname());
        resDTO.setLoc(dept2DO.getLoc());

        return resDTO;
    }

    // SELECT All
    public List<Dept2InfoDTO> listDepts(){
        // 創建 List 包裝 DTO
        List<Dept2InfoDTO> listAll = new ArrayList<Dept2InfoDTO>();

        // 迴圈取出 VO ，包裝成DTO 並加進 List
        for(Dept2DO dept2DO : dept2DAO.selectAll()){
            // 創建 DTO 包裝資料
            Dept2InfoDTO dept = new Dept2InfoDTO();

            dept.setDeptno(dept2DO.getDeptno());
            dept.setDname(dept2DO.getDname());
            dept.setLoc(dept2DO.getLoc());

            listAll.add(dept);
        }

        return listAll;
    }

}
