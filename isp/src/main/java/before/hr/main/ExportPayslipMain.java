package before.hr.main;

import before.hr.documents.Payslip;
import before.hr.logging.ConsoleLogger;
import before.hr.persistence.EmployeeFileSerializer;
import before.hr.persistence.EmployeeRepository;
import before.hr.personnel.Employee;

import java.time.Month;
import java.util.List;

// ISP Example
public class ExportPayslipMain {
    public static void main(String[] args) {
        // Create dependencies
        ConsoleLogger consoleLogger = new ConsoleLogger();
        EmployeeFileSerializer employeeFileSerializer = new EmployeeFileSerializer();
        EmployeeRepository repository = new EmployeeRepository(employeeFileSerializer);

        // Grab employees
        List<Employee> employees = repository.findAll();

        for (Employee employee : employees){
            Payslip payslip = new Payslip(employee , Month.AUGUST);

            String exportableText = payslip.toTxt().toUpperCase();
            System.out.println(exportableText);
        }
    }
}
