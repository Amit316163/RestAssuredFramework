package com.qa.api.pojo2;

public class SetLimits {
	
	private String channel;
	private int limitPerTran;
	private int dailylimit;
	private int velocity;
	private String setProfileName;
	
	
	public SetLimits(String channel, int limitPerTran, int dailylimit, int velocity, String setProfileName) {
		this.channel = channel;
		this.limitPerTran = limitPerTran;
		this.dailylimit = dailylimit;
		this.velocity = velocity;
		this.setProfileName = setProfileName;
	}
	
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public int getLimitPerTran() {
		return limitPerTran;
	}
	public void setLimitPerTran(int limitPerTran) {
		this.limitPerTran = limitPerTran;
	}
	public int getDailylimit() {
		return dailylimit;
	}
	public void setDailylimit(int dailylimit) {
		this.dailylimit = dailylimit;
	}
	public int getVelocity() {
		return velocity;
	}
	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}
	public String getSetProfileName() {
		return setProfileName;
	}
	public void setSetProfileName(String setProfileName) {
		this.setProfileName = setProfileName;
	}
	

}
