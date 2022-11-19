package com.example.bean;

import java.util.Date;

public class BoardVO {
	private int seq;
	private String fisrtName;
	private String lastName;
	private String team;
	private int age;
	private String aav;
	private int teamControl;
	private Date regdate;
	private int cnt;
	private String photo;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getFisrtName() {
		return fisrtName;
	}
	public void setFisrtName(String fisrtName) {
		this.fisrtName = fisrtName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
	public String getAav() { return aav; }
	public void setAav( String aav) { this.aav = aav; }
	public int getTeamControl() { return teamControl; }
	public void setTeamControl(int teamControl) { this.teamControl = teamControl; }
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public void setPhoto(String photo) { this.photo = photo; }
	public String getPhoto() { return photo; }
}
