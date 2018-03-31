package com.wujianbo;

public class TestDoor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Door door= new Door();
		//door.open();
		System.out.println(door.hashCode());
		
		SafeDoor sdoor= new SafeDoor();
		//sdoor.open();
		sdoor.lock();
		sdoor.close();
		sdoor.closeTwo();
		sdoor.closeThre();
		sdoor.lock(9);
	}

}
