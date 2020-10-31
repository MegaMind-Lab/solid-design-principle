package refactored.hr.taxes;

import refactored.hr.personnel.Employee;

public interface TaxCalculator {
    double calculate(Employee employee);
}
