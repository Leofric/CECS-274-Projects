package edu.lab_4;

public class CashRegisterTester {

	public static void main(String[] args) {
		CashRegister register1 = new CashRegister();		
		CashRegister register2 = new CashRegister(5.0);		

		register1.addItem(5);
		register1.addItem(10.10);
		register1.addItem(1.90);
		System.out.printf("%-10.2f",register1.getCount());
		System.out.printf("Expected 3 : count\n");				
		System.out.printf("%-10.2f",register1.getTotal());
		System.out.printf("Expected $17 + tax\n");				
		System.out.printf("%-10.2f", register1.getChangeDue(25));			
		System.out.printf("Expected $6.47\n");
		register2.addItem(10);									
		System.out.printf("%-10.2f",register2.getTotal());				
		System.out.printf("Expected ($10-$5) + tax\n");			
		System.out.printf("%-10.2f", register2.getChangeDue(20));
		System.out.printf("Expected $15-tax");
	}
}
