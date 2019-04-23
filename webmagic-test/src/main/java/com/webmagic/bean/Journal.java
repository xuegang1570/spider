package com.webmagic.bean;

public class Journal {

	private String title;
	private String titleDesc;
	private String issue;
	private String dateStr;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitleDesc() {
		return titleDesc;
	}
	public void setTitleDesc(String titleDesc) {
		this.titleDesc = titleDesc;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public String getDateStr() {
		return dateStr;
	}
	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}
	
	@Override
	public String toString() {
		return "Journal [title=" + title + ", titleDesc=" + titleDesc + ", issue=" + issue + ", dateStr=" + dateStr
				+ "]";
	}

}