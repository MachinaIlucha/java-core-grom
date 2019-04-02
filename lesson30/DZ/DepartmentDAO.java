package lesson30.DZ;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class DepartmentDAO {
    private static Set<Department> departments = new TreeSet<>();

    public static void setDepartments(Set<Department> departments) {
        DepartmentDAO.departments = departments;
    }

    public static Collection employeesByDepartmentWithoutProject(DepartmentType departmentType) {
        Set<Employee> employeeWithoutProject = new TreeSet<>();

        Iterator<Department> iterator = departments.iterator();

        Employee employee;

        while (iterator.hasNext()) {
            for (Department dp : departments) {
                if (dp.getType() == departmentType) {
                    Iterator<Employee> iteratorEmployee = dp.getEmployees().iterator();
                    while (iteratorEmployee.hasNext()) {
                        employee = iteratorEmployee.next();
                        if (employee.getProjects() == null)
                            employeeWithoutProject.add(employee);
                    }
                }
            }

        }

        return employeeWithoutProject;
    }
}
