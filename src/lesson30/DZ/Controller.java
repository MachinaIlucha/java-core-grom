package lesson30.DZ;

import lesson30.DZ.exeption.BadRequestException;

import java.util.Collection;

public class Controller {

    public Collection employeesByProject(String projectName) {
        return EmployeeDAO.employeesByProject(projectName);
    }

    public Collection projectsByEmployee(Employee employee) throws BadRequestException {
        return EmployeeDAO.projectsByEmployee(employee);
    }

    public Collection employeesByDepartmentWithoutProject(DepartmentType departmentType) {
        return DepartmentDAO.employeesByDepartmentWithoutProject(departmentType);
    }

    public Collection employeesWithoutProject() {
        return EmployeeDAO.employeesWithoutProject();
    }

    public Collection employeesByTeamLead(Employee lead) throws BadRequestException {
        return EmployeeDAO.employeesByTeamLead(lead);
    }

    public Collection teamLeadsByEmployee(Employee employee) throws BadRequestException {
        return EmployeeDAO.teamLeadsByEmployee(employee);
    }

    public Collection projectsByCustomer(Customer customer) {
        return ProjectDAO.projectsByCustomer(customer);
    }

    public Collection employeesByCustomerProjects(Customer customer) {
        return EmployeeDAO.employeesByCustomerProjects(customer);
    }


}
