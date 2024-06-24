package com.intellect.reportManagement.binding;

public class DashboardResponse {
	
	private Integer userId;
	
	private Integer totalCount;
	
	private Integer entrolled;
	
	private Integer lost;

	public Integer getEntrolled() {
		return entrolled;
	}

	public void setEntrolled(Integer entrolled) {
		this.entrolled = entrolled;
	}

	public Integer getLost() {
		return lost;
	}

	public void setLost(Integer lost) {
		this.lost = lost;
	}
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	@Override
	public String toString() {
		return "DashboardResponse [userId=" + userId + ", totalCount=" + totalCount + ", entrolled=" + entrolled
				+ ", lost=" + lost + "]";
	}
	
	
}
