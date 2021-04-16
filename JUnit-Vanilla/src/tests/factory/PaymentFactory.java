package tests.factory;

import entities.Employee;
import entities.OutsourceEmployee;

public class PaymentFactory {
	public static Employee createPayment(String name, int hours, double valuePerHour) {
		
		return new Employee(name, hours, valuePerHour);
	}
	public static  OutsourceEmployee createOutsourcePayment(String name, int hours, double valuePerHour) {
		
		return new OutsourceEmployee(name, hours, valuePerHour);
	}
}
