package com.bantu;
public class LockDown {
	void dailyLife()
	{
	System.out.println("Eat");
	System.out.println("Take Online Class");
	System.out.println("Play Ludo");
	System.out.println("Sleep");
	dailyLife();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LockDown ld= new LockDown();
		ld.dailyLife();
		}}

