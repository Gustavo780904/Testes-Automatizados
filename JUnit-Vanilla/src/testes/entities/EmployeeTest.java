package testes.entities;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Employee;
import entities.OutsourceEmployee;
import tests.factory.PaymentFactory;

public class EmployeeTest {
	/*******************
	 * Employee*
	 *******************/
	// setHour atende a regra
	@Test
	public void setHoursShouldAllowed() {
		int expectedValue = 40;
		Employee fn = PaymentFactory.createPayment("Marcos Dutra", 0, 30.0);
		Assertions.assertEquals(0, fn.getHours());
		fn.setHours(expectedValue);
		Assertions.assertEquals(expectedValue, fn.getHours());
	}

	// setHour não atende a regra
	@Test
	public void setHoursShoulThrowExeptionWhenExceededMaximumAllowed() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Employee fn = PaymentFactory.createPayment("Joao", 0, 0);
			fn.setHours(50);
		});
	}

	// metodo payment atende a regra
	@Test
	public void paymentSholdGreaterOrEqualThanMinimum() {	
		Employee fn = PaymentFactory.createPayment("Elvis Presley", 40, 30.0);
		fn.payment();
		Assertions.assertEquals(1200.00, fn.getSalary());
		fn.setValuePerHour(27.5);
		fn.payment();
		Assertions.assertEquals(1100.00, fn.getSalary());
	}

	// metodo payment não atende a regra
	@Test
	public void paymentShouldThrowExeptionWhenSalaryBelowMin() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Employee fn = PaymentFactory.createPayment("Marcio", 40, 20);
			fn.payment();
		});
	}
	// Nome não pode ser vazio nem com espaços
	@Test
	public void nameMustNotBeNullOrBlank() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			PaymentFactory.createPayment(null, 40, 20);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			PaymentFactory.createPayment("   ", 40, 20);
		});
	}

	//	Construtor atende a regra
	@Test
	public void constructorShouldInstanceEmployee() {
		Employee fn = new Employee("Gustavo", 40, 30.0);
		Assert.assertEquals("Gustavo", fn.getName());
		Assert.assertEquals(40, fn.getHours(), 0.0);
		Assert.assertEquals(30.0, fn.getValuePerHour(),0.0);
	}

	//Construtor não atende a regra
	@Test
	public void constructorShouldNotInstanceEmployee() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			PaymentFactory.createOutsourcePayment("Gustavo", 45, 30.0);
		});
	}

	/*******************
	 * OutSourseEmployee*
	 *******************/

	// setHours atende a regra
	@Test
	public void setHoursOutsourceEmployeeShouldAllowed() {
		int expectedValue = 42;
		OutsourceEmployee fn = PaymentFactory.createOutsourcePayment("Andre", 0, 30.0);
		fn.setHours(expectedValue);
		Assertions.assertEquals(expectedValue, fn.getHours());
	}

	// setHours n atende a regra
	@Test
	public void setHoursOutsourceEmployeeShoulThrowExeptionWhenExceededMaximumAllowed() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			OutsourceEmployee fn = PaymentFactory.createOutsourcePayment("José", 40, 30.0);
			fn.setHours(50);
		});
	}

	// salario do terceirizado não atende a regra
	@Test
	public void paymentOutSourceEmployeeShouldThrowExeptionWhenSalaryMinorMinimumAndHoursAllowed() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			OutsourceEmployee fn = PaymentFactory.createOutsourcePayment("Osvaldo", 42, 20.0);
			fn.payment();
		});
	}

	// calculo do bonus
	@Test
	public void paymentOutSourceEmployeeShouldCalculateSalaryWhithAdditionalCharge() {
		double expectedValue = 2646.0;
		OutsourceEmployee fn = PaymentFactory.createOutsourcePayment("Maria", 42, 30.0);
		fn.payment();
		Assertions.assertEquals(expectedValue, fn.getSalary());
	}
//	Construtor atende a regra
	@Test
	public void constructorShouldInstanceOutsourceEmployee() {
		OutsourceEmployee fn = new OutsourceEmployee("Gustavo", 42, 30.0);
		Assert.assertEquals("Gustavo", fn.getName());
		Assert.assertEquals(42, fn.getHours(),0.0);
		Assert.assertEquals(30.0, fn.getValuePerHour(),0.0);
	}
	
	
}
