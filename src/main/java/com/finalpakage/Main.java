package com.finalpakage;

public class Main {
	public static void main(String [] args) {
		Dao aDao=new Dao();
		Entity entity=new Entity(1, "shiv", "sde1",100000);
		aDao.insertingData(entity);
		aDao.gettingAllData();
		boolean a=aDao.deletingData(1);
		System.out.println(" deletion successful "+a);
		
		
		// through user data can be taken using scanner and BufferedReader as well
	}
}

