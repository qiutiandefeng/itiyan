package com.yfhl.common;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 *
 * @Description 分页参数
 * 
 */
public class PageInfo {
    private int totalPage = 1;//总页数
    
    private int prePage = 1;//上一页
    
    private int nextPage = 1;//下一页
    
    private int totalRec = 0;//总记录数
    
    private int currentPageRec = 0;//当前页面记录数
    
    private final int defaultPageSize = 20;
    
    private int pageSize = defaultPageSize;//每页显示条数
    
    private int pageIndex = 1;//当前页面索引
    
    private int[] pageNumbers;//页码显示
    
    private Map<Integer, Integer> allNumbers;
    
    private int signSize = 4;//每页显示数目
    
    public PageInfo() {
    	
    }
    
    public PageInfo(int pageIndex, int pageSize) {
        this.pageSize = pageSize;
        this.pageIndex = pageIndex;
    }
    
    /**
     * 
     * @Description 当前页面记录数
     */
    public int getCurrentPageRec() {
        if (pageIndex == 1) {
            if (totalRec >= pageSize) {
                currentPageRec = pageSize;
            } else {
                currentPageRec = totalRec;
            }
        } else if (pageIndex == totalPage) {
            currentPageRec = totalRec - (pageSize * (pageIndex - 1));
        } else {
            currentPageRec = pageSize;
        }
        
        return currentPageRec;
    }
    
    public void setCurrentPageRec(int currentPageRec) {
        this.currentPageRec = currentPageRec;
    }
    
    public int getSignSize() {
        return signSize;
    }
    
    public void setSignSize(int signSize) {
        this.signSize = signSize;
    }
    
    public int getPageIndex() {
        return pageIndex;
    }
    
    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex > 0 ? pageIndex : 1;
    }
    
    public int getNextPage() {
        return nextPage;
    }
    
    public void setNextPage(int nextPage) {
        this.nextPage = nextPage > this.totalPage ? this.totalPage : nextPage;
    }
    
    public int getPageSize() {
        return pageSize;
    }
    
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize > 0 ? pageSize : 10;
    }
    
    public int getPrePage() {
        return prePage;
    }
    
    public void setPrePage(int prePage) {
        this.prePage = prePage < 1 ? 1 : prePage;
    }
    
    public int getTotalPage() {
        return totalPage;
    }
    
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage > 0 ? totalPage : 1;
    }
    
    public int getTotalRec() {
        return totalRec;
    }
    
    public void setTotalRec(int totalRec) {
        this.totalRec = totalRec > -1 ? totalRec : 0;
        this.setTotalPage((this.getTotalRec() - (this.getTotalRec() % this.getPageSize())) / this.getPageSize() + 1);
        this.setNextPage(this.getPageSize() > this.getPageIndex() ? this.getPageIndex() + 1 : this.getPageIndex());
    }
    
    public int[] getPageNumbers() {
        return pageNumbers;
    }
    
    public void setPageNumbers(int[] pageNumbers) {
        this.pageNumbers = pageNumbers;
    }
    
    public Map<Integer, Integer> getAllNumbers() {
        return allNumbers;
    }
    
    public void setAllNumbers(Map<Integer, Integer> allNumbers) {
        this.allNumbers = allNumbers;
    }
    
    public PageInfo pageHelp(PageInfo pageInfo) {
        pageInfo.setTotalPage((pageInfo.getTotalRec() % pageInfo.getPageSize() == 0) ? (pageInfo.getTotalRec() / pageInfo.getPageSize())
            : (pageInfo.getTotalRec() / pageInfo.getPageSize()) + 1);
        int begin = (pageInfo.getPageIndex() - (pageInfo.getSignSize() + 1) > 0) ? pageInfo.getPageIndex() - (pageInfo.getSignSize() + 1) : 0;
        int end =
            (pageInfo.getPageIndex() + pageInfo.getSignSize() < pageInfo.getTotalPage()) ? pageInfo.getPageIndex() + pageInfo.getSignSize()
                : pageInfo.getTotalPage();
        int[] pageNumbers = new int[end - begin];
        int j = 0;
        for (int i = begin; i < end; i++) {
            pageNumbers[j] = i + 1;
            j++;
        }
        Map<Integer, Integer> allNumbers = new HashMap<Integer, Integer>();
        for (int i = 0; i < pageInfo.getTotalPage(); i++) {
            allNumbers.put(new Integer(i + 1), new Integer(i + 1));
        }
        pageInfo.setAllNumbers(allNumbers);
        pageInfo.setPageNumbers(pageNumbers);
        pageInfo.setPrePage(pageInfo.getPageIndex() - 1);
        pageInfo.setNextPage(pageInfo.getPageIndex() + 1);
        return pageInfo;
    }


	@Override
	public String toString() {
		return "PageInfo [totalPage=" + totalPage + ", prePage=" + prePage
				+ ", nextPage=" + nextPage + ", totalRec=" + totalRec
				+ ", currentPageRec=" + currentPageRec + ", defaultPageSize="
				+ defaultPageSize + ", pageSize=" + pageSize + ", pageIndex="
				+ pageIndex + ", pageNumbers=" + Arrays.toString(pageNumbers)
				+ ", allNumbers=" + allNumbers + ", signSize=" + signSize + "]";
	}

    
    
    
}