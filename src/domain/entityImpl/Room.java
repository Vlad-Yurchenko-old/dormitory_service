package domain.entityImpl;

import domain.Entity;

public class Room extends Entity{

	private int number;
	private int dormitoryID;
	private int countFree;
	private String gender;
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getDormitoryID() {
		return dormitoryID;
	}
	public void setDormitoryID(int dormitoryID) {
		this.dormitoryID = dormitoryID;
	}
	public int getCountFree() {
		return countFree;
	}
	public void setCountFree(int countFree) {
		this.countFree = countFree;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
