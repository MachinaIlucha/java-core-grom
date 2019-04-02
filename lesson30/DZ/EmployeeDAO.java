package lesson30.DZ;

import lesson30.DZ.exeption.BadRequestException;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class EmployeeDAO {
    private static Set<Employee> employees = new TreeSet<>();

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public static Collection employeesByProject(String projectName) {
        Set<Employee> employeesByProject = new TreeSet<>();

        for (Employee emp : employees) {
            Collection<Project> projects = emp.getProjects();
            for (Project project : projects) {
                if (project.getName() == projectName)
                    employeesByProject.add(emp);
            }
        }
        return employeesByProject;
    }

    public static Collection projectsByEmployee(Employee employee) throws BadRequestException {
        for (Employee emp : employees) {
            if (emp.equals(employee))
                return emp.getProjects();
        }

        throw new BadRequestException("No employee with lastname: " + employee.getLastName());
    }

    public static Collection employeesWithoutProject() {
        Set<Employee> employeesWithoutProject = new TreeSet<>();

        for (Employee emp : employees) {
            if (emp.getProjects() == null)
                employeesWithoutProject.add(emp);
        }

        return employeesWithoutProject;
    }

    public static Collection employeesByTeamLead(Employee lead) throws BadRequestException {
        Set<Employee> employeesByLead = new TreeSet<>();
        Collection<Project> projects = projectsByEmployee(lead);

        for (Employee employee : employees) {
            if (employee.getProjects() == projects && !employee.equals(lead))
                employeesByLead.add(employee);
        }
        return employeesByLead;
    }

    public static Collection teamLeadsByEmployee(Employee employee) throws BadRequestException {
        Set<Employee> leadsByEmployee = new TreeSet<>();
        Collection<Project> projects = projectsByEmployee(employee);

        for (Project project : projects) {
            for (Employee emp : employees) {
                if (emp.getPosition() == Position.TEAM_LEAD && emp.getProjects().contains(project))
                    leadsByEmployee.add(emp);
            }
        }
        return leadsByEmployee;
    }

    public static Collection employeesByCustomerProjects(Customer customer) {
        Set<Employee> employeesByCustomerProjects = new TreeSet<>();
        Collection<Project> projects = ProjectDAO.projectsByCustomer(customer);

        for (Project project : projects) {
            for (Employee emp : employees) {
                if (emp.getProjects().contains(project))
                    employeesByCustomerProjects.add(emp);
            }
        }
        return employeesByCustomerProjects;
    }
}
