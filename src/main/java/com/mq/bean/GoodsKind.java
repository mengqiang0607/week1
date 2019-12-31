package com.mq.bean;

public class GoodsKind {
	
	private int gid;
	private String gname;
	public GoodsKind() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	@Override
	public String toString() {
		return "GoodsKind [gid=" + gid + ", gname=" + gname + "]";
	}
	
	

}
