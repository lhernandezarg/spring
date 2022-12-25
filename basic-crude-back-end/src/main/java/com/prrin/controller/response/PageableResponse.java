package com.prrin.controller.response;

import java.util.List;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class PageableResponse<T> {

  private List<T> items;
  private Integer currentPage;
  private Integer totalItems;
  private Integer totalPages;

  public PageableResponse(Page<T> page) {
    this.items = page.getContent();
    this.currentPage = page.getNumber();
    this.totalItems = page.getNumberOfElements();
    this.totalPages = page.getTotalPages();
  }
}
