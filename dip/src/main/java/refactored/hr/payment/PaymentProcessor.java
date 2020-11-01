package refactored.hr.payment;

import refactored.hr.notifications.EmployeeNotifier;
import refactored.hr.persistence.EmployeeRepository;
import refactored.hr.personnel.Employee;

import java.util.List;

public class PaymentProcessor {

    private EmployeeRepository employeeRepository;
    private EmployeeNotifier employeeNotifier;

    public PaymentProcessor(EmployeeRepository employeeRepository,
                            EmployeeNotifier employeeNotifier){
        this.employeeRepository = employeeRepository;
        this.employeeNotifier = employeeNotifier;
    }

    public int sendPayments(){
        List<Employee> employees = this.employeeRepository.findAll();
        int totalPayments = 0;

        for(Employee employee : employees){
            totalPayments += employee.getMonthlyIncome();
            this.employeeNotifier.notify(employee);
        }

        return totalPayments;
    }
}
