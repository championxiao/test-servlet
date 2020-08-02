package com.yc.test.entity;

import java.io.Serializable;

import com.yc.test.util.StringUtil;

public class GoodsInfo implements Serializable {
	private static final long serialVersionUID = 3805744806193408017L;
	private Integer gno;
	private String gname;
	private Integer tno;
	private double price;
	private String intro;
	private Integer balance;
	private String pics;
	private String unit;
	private String qperied;
	private String weight;
	private String descr;
	private String pic;
	private String tname;
	public String toString() {
		return "GoodsInfo [gno=" + gno + ",gname" + gname + ",tno=" + tno +"]";
	}
	public Integer getGno() {
		return gno;
	}
	public void setGno(Integer gno) {
		this.gno = gno;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public Integer getTno() {
		return tno;
	}
	public void setTno(Integer tno) {
		this.tno = tno;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	public String getPics() {
		return pics;
	}
	public void setPics(String pics) {
		this.pics = pics;
		setPic(pics);
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getQperied() {
		return qperied;
	}
	public void setQperied(String qperied) {
		this.qperied = qperied;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pics) {
		if(!StringUtil.checkNull(pics)) {
			this.pic = pics.split(";")[0];
			return;
		}
		this.pic = pics;
		
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
}
