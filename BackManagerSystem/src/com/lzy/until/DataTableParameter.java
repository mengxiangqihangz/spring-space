package com.lzy.until;

public class DataTableParameter {

		private String sEcho;//请求服务器端的次数
		private String sSearch;//搜索文本
		private int iDisplayLength;//每页显示数量
		private int iDisplayStart;//每页的跨度数量
		private int iColumns;//列数
		private int iSortingCols;//排序列的数量
		private String sColumns;//逗号分割所有的列
		public String getsEcho() {
			return sEcho;
		}
		public void setsEcho(String sEcho) {
			this.sEcho = sEcho;
		}
		public String getsSearch() {
			return sSearch;
		}
		public void setsSearch(String sSearch) {
			this.sSearch = sSearch;
		}
		public int getiDisplayLength() {
			return iDisplayLength;
		}
		public void setiDisplayLength(int iDisplayLength) {
			this.iDisplayLength = iDisplayLength;
		}
		public int getiDisplayStart() {
			return iDisplayStart;
		}
		public void setiDisplayStart(int iDisplayStart) {
			this.iDisplayStart = iDisplayStart;
		}
		public int getiColumns() {
			return iColumns;
		}
		public void setiColumns(int iColumns) {
			this.iColumns = iColumns;
		}
		public int getiSortingCols() {
			return iSortingCols;
		}
		public void setiSortingCols(int iSortingCols) {
			this.iSortingCols = iSortingCols;
		}
		public String getsColumns() {
			return sColumns;
		}
		public void setsColumns(String sColumns) {
			this.sColumns = sColumns;
		}
		
		
		
		
}
