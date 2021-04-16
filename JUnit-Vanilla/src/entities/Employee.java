package entities;

public class Employee {
	private String name;
	protected int hours;
	private double valuePerHour;
	protected double salary;

//	public Employee () {
//		
//	}
	public Employee(String name, int hours, double valuePerHour) {
		setName(name);
		setHours(hours);
		this.valuePerHour = valuePerHour;
	}

	public double getSalary() {
		return salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null||name.isBlank())
			throw new IllegalArgumentException("O nome deve ser informado");
		this.name = name;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		if (hours > 40) {
			throw new IllegalArgumentException("O empregado da empresa pode trabalhar até o limite de 40 hs mensais");
		}
		this.hours = hours;
	}

	public double getValuePerHour() {
		return valuePerHour;
	}

	public void setValuePerHour(double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}

	public void payment() {
			salary = hours * valuePerHour;
			if (salary < 1100.00)
				throw new IllegalArgumentException("O salário não pode ser inferior a R$1100.00");
			
	}
}
