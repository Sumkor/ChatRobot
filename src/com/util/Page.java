package com.util;

public class Page {
	private int totalNumber;//总条数
	private int pageNumber = 5;//每页显示条数
	private int totalPage;//总页数
	private int currentPage;//当前页数
	
	private int dbIndex;//limit参数，从第几条开始取
	private int dbNumber;//limit参数，一共取多少条
	
	/**
	 * 根据totalNumber和currentPage(外部传入)计算其他属性值
	 */
	public void count(){
		//计算总页数
		int totalNumberTemp = this.totalNumber / this.pageNumber;
		int plus = this.totalNumber % this.pageNumber == 0 ? 0 : 1;
		totalNumberTemp += plus;
		if(totalNumberTemp<=0){
			totalNumberTemp=1;
		}
		this.totalPage=totalNumberTemp;
		
		//设置当前页数
		if(this.totalPage<this.currentPage){
			this.currentPage=this.totalNumber;
		}
		if(this.currentPage<=0){
			this.currentPage=1;
		}
		
		//设置limit参数
		this.dbIndex=(this.currentPage-1)*this.pageNumber;
		this.dbNumber=this.pageNumber;
	}
	
	public int getTotalNumber() {
		return totalNumber;
	}
	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
		this.count();
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
		this.count();
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getDbIndex() {
		return dbIndex;
	}
	public void setDbIndex(int dbIndex) {
		this.dbIndex = dbIndex;
	}
	public int getDbNumber() {
		return dbNumber;
	}
	public void setDbNumber(int dbNumber) {
		this.dbNumber = dbNumber;
	}
}
