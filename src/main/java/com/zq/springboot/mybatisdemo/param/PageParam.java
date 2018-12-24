package com.zq.springboot.mybatisdemo.param;
//分页基础类
/*
多条件分页查询是我们在实际工作中最常使用的一个功能，MyBatis 也特别擅长处理这类的问题。
在实际工作中，会对分页进行简单的封装，方便前端使用。另外在 Web 开发规范使用中，一般 Web 层的参数会以 param 为后缀的对象进行传参，
以 entity 为后缀的对象负责和数据库打交道，以 result 结尾的实体类一般用于封装返回的数据。
 */
public class PageParam {
    private int beginLine;       //起始行
    private Integer pageSize = 3;  //默认每页3个记录，可以让前端自行传参自动修改
    private Integer currentPage=0; 	   // 当前页

    public int getBeginLine() {
        return pageSize*currentPage;
    }//自动计算起始行

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    @Override
    public String toString() {
        return "PageParam{" +
                "beginLine=" + beginLine +
                ", pageSize=" + pageSize +
                ", currentPage=" + currentPage +
                '}';
    }
}
