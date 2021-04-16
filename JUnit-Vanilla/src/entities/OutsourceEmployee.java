package entities;

public class OutsourceEmployee extends Employee{
	
	private final double additionalCharge = 1.1;


	public OutsourceEmployee(String name, int hours, double valuePerHour) {
		super(name, hours, valuePerHour);
	}

	@Override
	public void setHours(int hours) {
		if (hours > 42) {
			throw new IllegalArgumentException("O empregado da empresa pode trabalhar até o limite de 42 hs mensais");
		}
		this.hours = hours;
	}

	public double getAdditionalCharge() {
		return additionalCharge;
	}
	
	@Override
	public void payment() {
		super.payment();
			salary = salary + salary*additionalCharge;
			salary = Math.round(salary*100)/100.0;
	}
	
	
}
