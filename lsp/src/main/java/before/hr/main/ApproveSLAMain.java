package before.hr.main;

import before.hr.logging.ConsoleLogger;
import before.hr.persistence.EmployeeFileSerializer;
import before.hr.persistence.EmployeeRepository;
import before.hr.personnel.Employee;
import before.hr.personnel.ServiceLicenseAgreement;
import before.hr.personnel.Subcontractor;

import java.util.List;

public class ApproveSLAMain {
    public static void main(String[] args) {
        // Create dependencies
        ConsoleLogger consoleLogger = new ConsoleLogger();
        EmployeeFileSerializer employeeFileSerializer = new EmployeeFileSerializer();
        EmployeeRepository repository = new EmployeeRepository(employeeFileSerializer);

        // Define SLA
        int minTimeOffPercent = 98;
        int maxResolutionDays = 2;
        ServiceLicenseAgreement companySla = new ServiceLicenseAgreement(
                minTimeOffPercent,
                maxResolutionDays);

        // Grab subcontractors
        List<Employee> subcontractors = repository.findAll();

        for (Employee e : subcontractors){
            if(e instanceof  Subcontractor){
                Subcontractor s = (Subcontractor)e;
                s.approveSLA(companySla);
            }
        }
    }
}
