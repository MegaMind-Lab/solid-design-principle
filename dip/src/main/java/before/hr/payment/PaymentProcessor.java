package before.hr.payment;

import before.hr.notifications.EmailSender;
import before.hr.persistence.EmployeeFileRepository;
import before.hr.persistence.EmployeeFileSerializer;
import before.hr.personnel.Employee;

import java.util.List;

public class PaymentProcessor {

    private EmployeeFileRepository employeeRepository;

    public PaymentProcessor(){
        EmployeeFileSerializer serializer =
                new EmployeeFileSerializer();
        this.employeeRepository =
                new EmployeeFileRepository(serializer);
    }

    public int sendPayments(){
        List<Employee> employees = this.employeeRepository.findAll();
        int totalPayments = 0;

        for(Employee employee : employees){
            totalPayments += employee.getMonthlyIncome();
            EmailSender.notify(employee);
        }

        return totalPayments;
    }
}
