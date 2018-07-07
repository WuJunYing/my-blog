package com.xiaowuu.common;

import java.util.List;

public class ResultMessage<T> {
	private Integer total;
	private List<T> rows;
	private T columns;
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	public T getColumns() {
		return columns;
	}
	public void setColumns(T columns) {
		this.columns = columns;
	}
}
