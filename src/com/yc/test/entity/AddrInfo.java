package com.yc.test.entity;

import java.io.Serializable;

public class AddrInfo implements Serializable{

	private static final long serialVersionUID = 490032695343194473L;
	private String ano;
	private Integer mno;
	private String name;
	private String tel;
	private String province;
	private String city;
	private String area;
	private String addr;
	private Integer flag;
	private Integer status;
	private String temp;
	
	public String toString() {
		return "AddrInfo [ano=" + ano + ",mno=" + mno + ",name=" + name +",tel=" + tel +",province="
				+ province +",city=" + city + ",area=" + area + ",addr=" + addr + ",flag=" + flag +",status=" 
				+ status +",temp" + temp +"]";
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public Integer getMno() {
		return mno;
	}

	public void setMno(Integer mno) {
		this.mno = mno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}
	


}
