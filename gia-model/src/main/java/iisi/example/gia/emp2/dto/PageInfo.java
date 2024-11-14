package iisi.example.gia.emp2.dto;

// 當前分頁資訊
public class PageInfo {

    private Integer page;
    private Integer totalPages;
    private Integer selectEmpsCount;

    // Getters & Setters
    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getSelectEmpsCount() {
        return selectEmpsCount;
    }

    public void setSelectEmpsCount(Integer selectEmpsCount) {
        this.selectEmpsCount = selectEmpsCount;
    }

}
