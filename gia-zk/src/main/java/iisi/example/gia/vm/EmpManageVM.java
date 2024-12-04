package iisi.example.gia.vm;

import iisi.example.gia.dept2.dto.Dept2InfoDTO;
import iisi.example.gia.dept2.service.Dept2Service;
import iisi.example.gia.emp2.dto.*;
import iisi.example.gia.emp2.service.Emp2Service;
import lombok.Getter;
import lombok.Setter;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.*;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;
import org.zkoss.zul.Messagebox;
import java.util.List;
import java.util.Set;

@VariableResolver(DelegatingVariableResolver.class)
public class EmpManageVM {

    @WireVariable("emp2Service")
    private Emp2Service empService;
    @WireVariable("dept2Service")
    private Dept2Service deptService;

    // 接收查詢條件
    private Emp2ComplexSelectReq empSelectReq = new Emp2ComplexSelectReq();
    // 查詢結果
    private Emp2ComplexSelectViewDTO empSelectRes = new Emp2ComplexSelectViewDTO();

    // 接收新增修改資料
    private Emp2Req empReq = new Emp2Req();

    // 視窗名稱
    private Boolean isAdd;
    // 修改視窗顯示
    private boolean editDialogVisible = false;

    // 下拉式選單內容
    private Set<String> jobs;
    private List<Dept2InfoDTO> depts;

    @Init
    public void init(){
        jobs = empService.listJobs();
        depts = deptService.listDepts();
    }

    /*************** Command ***************/
    // 顯示新增視窗
    @Command
    @NotifyChange({"empReq", "editDialogVisible", "isAdd"})
    public void showAddDialog(){
        // 顯示視窗名稱為 新增員工
        isAdd = true;

        // 創建 Req 接收資料
        empReq = new Emp2Req();

        // 顯示視窗
        editDialogVisible = true;
    }

    // 查詢
    @Command
    @NotifyChange("empSelectRes")
    public void select(){
        // 創建 DTO 包裝 Req ，給 Service 查詢
        Emp2ComplexSelectReqDTO empSelectReqDTO = new Emp2ComplexSelectReqDTO();

        empSelectReqDTO.setEmpno(empSelectReq.getEmpno());
        empSelectReqDTO.setEname(empSelectReq.getEname());
        empSelectReqDTO.setJob(empSelectReq.getJob());
        try {
            empSelectReqDTO.setDname(empSelectReq.getDept().getDname());
        }catch(NullPointerException e){
            empSelectReqDTO.setDname(null);
        }
        empSelectReqDTO.setStartDate(empSelectReq.getStartDate());
        empSelectReqDTO.setEndDate(empSelectReq.getEndDate());
        empSelectReqDTO.setBottomSal(empSelectReq.getBottomSal());
        empSelectReqDTO.setTopSal(empSelectReq.getTopSal());

        // 暫時測試用
        empSelectReqDTO.setLimit(20);

        empSelectRes = empService.selectEmps(empSelectReqDTO);
    }

    // 刪除
    @Command
    public void delete(@BindingParam Integer empno){
        // 確認是否刪除
        Messagebox.show(
                "確認要刪除嗎?",
                "確認",
                Messagebox.YES | Messagebox.NO,
                Messagebox.QUESTION, // 圖示
                event -> {
                    if(Messagebox.ON_YES.equals(event.getName())){
                        empService.deleteEmp(empno);
                    }
                    // 更新搜尋結果
                    select();

                    // 手動通知畫面更新
                    BindUtils.postNotifyChange(this, "empSelectRes");
                }
        );
    }

    // 新增 & 修改
    @Command
    @NotifyChange({"empSelectRes", "editDialogVisible"})
    public void saveEdit(){
        // 判斷 新增 or 修改
        if(isAdd){ // 新增
            // 包裝成 DTO
            Emp2AddDTO empAddDTO = new Emp2AddDTO();
            empAddDTO.setEname(empReq.getEname());
            empAddDTO.setJob(empReq.getJob());
            empAddDTO.setHiredate(empReq.getHiredate());
            empAddDTO.setSal(empReq.getSal());
            empAddDTO.setComm(empReq.getComm());
            empAddDTO.setDeptno(empReq.getDept().getDeptno());

            // 新增
            empService.addEmp(empAddDTO);
        } else{
            // 包裝成 DTO
            Emp2UpdateDTO empUpdateDTO = new Emp2UpdateDTO();
            empUpdateDTO.setEmpno(empReq.getEmpno());
            empUpdateDTO.setEname(empReq.getEname());
            empUpdateDTO.setJob(empReq.getJob());
            empUpdateDTO.setHiredate(empReq.getHiredate());
            empUpdateDTO.setSal(empReq.getSal());
            empUpdateDTO.setComm(empReq.getComm());
            empUpdateDTO.setDeptno(empReq.getDept().getDeptno());

            // 修改
            empService.updateEmp(empUpdateDTO);
        }

        // 關閉視窗
        editDialogVisible = false;

        // 更新搜尋結果
        select();
    }

    // 顯示修改視窗
    @Command
    @NotifyChange({"empReq", "editDialogVisible", "isAdd"})
    public void showUpdateDialog(@BindingParam Integer empno){
        // 顯示視窗名稱為 修改員工
        isAdd = false;

        // 得到修改的員工
        Emp2SelectOneDTO empSelectOneDTO = empService.selectOne(empno);

        // 包裝成 Req
        empReq.setEmpno(empSelectOneDTO.getEmpno());
        empReq.setEname(empSelectOneDTO.getEname());
        empReq.setJob(empSelectOneDTO.getJob());
        empReq.setHiredate(empSelectOneDTO.getHiredate());
        empReq.setSal(empSelectOneDTO.getSal());
        empReq.setComm(empSelectOneDTO.getComm());
        empReq.setDept(deptService.findOne(empSelectOneDTO.getDeptno()));

        // 顯示視窗
        editDialogVisible = true;
    }

    // 關閉修改視窗
    @Command
    @NotifyChange("editDialogVisible")
    public void closeEditDialog(){
        editDialogVisible = false;
    }

    /*************** Command ***************/

    // Getter & Setter
    public Emp2ComplexSelectReq getEmpSelectReq() {
        return empSelectReq;
    }

    public void setEmpSelectReq(Emp2ComplexSelectReq empSelectReq) {
        this.empSelectReq = empSelectReq;
    }

    public Emp2ComplexSelectViewDTO getEmpSelectRes() {
        return empSelectRes;
    }

    public void setEmpSelectRes(Emp2ComplexSelectViewDTO empSelectRes) {
        this.empSelectRes = empSelectRes;
    }

    public Emp2Req getEmpReq() {
        return empReq;
    }

    public void setEmpReq(Emp2Req empReq) {
        this.empReq = empReq;
    }

    public Boolean getIsAdd() {
        return isAdd;
    }

    public void setIsAdd(Boolean add) {
        isAdd = add;
    }

    public boolean isEditDialogVisible() {
        return editDialogVisible;
    }

    public void setEditDialogVisible(boolean editDialogVisible) {
        this.editDialogVisible = editDialogVisible;
    }

    public Set<String> getJobs() {
        return jobs;
    }

    public void setJobs(Set<String> jobs) {
        this.jobs = jobs;
    }

    public List<Dept2InfoDTO> getDepts() {
        return depts;
    }

    public void setDepts(List<Dept2InfoDTO> depts) {
        this.depts = depts;
    }

}
