package com.fuint.framework.pagination;

import org.springframework.data.domain.Page;
import java.io.Serializable;
import java.util.List;

/**
 * 分页请求响应结果对象
 *
 * @param <T>
 * Created by FSQ
 * CopyRight https://www.fuint.cn
 */
public class PaginationResponse<T> implements Serializable {

    private static final long serialVersionUID = 1115676724739520700L;

    /**
     * 当前页码
     */
    private int currentPage;
    /**
     * 每页大小
     */
    private int pageSize;
    /**
     * 总页数
     */
    private int totalPages;
    private int numberOfElements;
    /**
     * 总记录数
     */
    private long totalElements;
    /**
     * 是否有上一页
     */
    private boolean hasPreviousPage;
    /**
     * 是否是第一页
     */
    private boolean isFirstPage;
    /**
     * 是否有下一页
     */
    private boolean hasNextPage;
    /**
     * 是否是最后一页
     */
    private boolean isLastPage;
    /**
     * 是否有内容
     */
    private boolean hasContent;
    /**
     * 结果集合
     */
    private List<T> content;

    /**
     * 构造方法
     */
    public <T> PaginationResponse(final Page<T> page, final Class<? extends T> clz) {
        this.currentPage = page.getNumber();
        this.pageSize = page.getSize();
        this.totalPages = page.getTotalPages();
        this.numberOfElements = page.getNumberOfElements();
        this.totalElements = page.getTotalElements();
        this.hasPreviousPage = page.hasPrevious();
        this.isFirstPage = page.isFirst();
        this.hasNextPage = page.hasNext();
        this.isLastPage = page.isLast();
        if (page.getContent() != null && page.getContent().size() > 0) {
            this.hasContent = true;
        }

    }


    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public boolean isFirstPage() {
        return isFirstPage;
    }

    public void setFirstPage(boolean isFirstPage) {
        this.isFirstPage = isFirstPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public boolean isLastPage() {
        return isLastPage;
    }

    public void setLastPage(boolean isLastPage) {
        this.isLastPage = isLastPage;
    }

    public boolean isHasContent() {
        return hasContent;
    }

    public void setHasContent(boolean hasContent) {
        this.hasContent = hasContent;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }
}
