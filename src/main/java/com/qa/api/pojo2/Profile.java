package com.qa.api.pojo2;

import java.util.List;

public class Profile {
	
	private String currencyCode;
	private String institudeCode;
	private String profileName;
	private List<SetLimits> SetLimits=null;
	
	
	
	public Profile(String currencyCode, String institudeCode, String profileName,
			List<com.qa.api.pojo2.SetLimits> setLimits) {
		this.currencyCode = currencyCode;
		this.institudeCode = institudeCode;
		this.profileName = profileName;
		SetLimits = setLimits;
	}
	
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public String getInstitudeCode() {
		return institudeCode;
	}
	public void setInstitudeCode(String institudeCode) {
		this.institudeCode = institudeCode;
	}
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	public List<SetLimits> getSetLimits() {
		return SetLimits;
	}
	public void setSetLimits(List<SetLimits> setLimits) {
		SetLimits = setLimits;
	}

}
