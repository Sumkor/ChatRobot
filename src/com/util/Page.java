package com.util;

public class Page {
	private int totalNumber;//������
	private int pageNumber = 5;//ÿҳ��ʾ����
	private int totalPage;//��ҳ��
	private int currentPage;//��ǰҳ��
	
	private int dbIndex;//limit�������ӵڼ�����ʼȡ
	private int dbNumber;//limit������һ��ȡ������
	
	/**
	 * ����totalNumber��currentPage(�ⲿ����)������������ֵ
	 */
	public void count(){
		//������ҳ��
		int totalNumberTemp = this.totalNumber / this.pageNumber;
		int plus = this.totalNumber % this.pageNumber == 0 ? 0 : 1;
		totalNumberTemp += plus;
		if(totalNumberTemp<=0){
			totalNumberTemp=1;
		}
		this.totalPage=totalNumberTemp;
		
		//���õ�ǰҳ��
		if(this.totalPage<this.currentPage){
			this.currentPage=this.totalNumber;
		}
		if(this.currentPage<=0){
			this.currentPage=1;
		}
		
		//����limit����
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
