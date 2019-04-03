package lesson30.DZ;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class ProjectDAO {
    private static Set<Project> projects = new TreeSet<>();

    public static void setProjects(Set<Project> projects) {
        ProjectDAO.projects = projects;
    }

    public static Collection projectsByCustomer(Customer customer) {
        Set<Project> projectsByCustomer = new TreeSet<>();

        for (Project project : projects) {
            if (project.getCustomer().equals(customer))
                projectsByCustomer.add(project);
        }
        return projectsByCustomer;
    }

}
