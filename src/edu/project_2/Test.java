package edu.project_2;

public class Test {

	public static void main(String Args[]) {
		CellPhone myPhone = new CellPhone();
		myPhone.call(5625555555l);
		myPhone.call("Tim");
		myPhone.phoneBook.addContact("Tim", 5625559000l, 0,"", "timmy@gmail.com");
		myPhone.phoneBook.addContact("karen", 5625554000l, 2133095555l, "","girl from CECS 274");
		myPhone.phoneBook.addContact("Vet", 3105557777l,0, "petMD@vets.com", "Ask for Dr.Doolittle");
		myPhone.call("Tim");
		myPhone.receiveCall(3235555000l);
		myPhone.receiveCall("Tim");
		myPhone.call("Katherine");
		myPhone.phoneBook.displayAll();
		myPhone.phoneBook.editContact("karen", "NAME", "Katherine");//this doesnt work/literaly did nothing		
		myPhone.phoneBook.display("Katherine");
		myPhone.callCurrentContact();
		myPhone.printLog();
		myPhone.printLog("Tim");
	}

}