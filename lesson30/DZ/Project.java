package lesson30.DZ;

public class Project implements Comparable<Project> {
    private String name;
    private Customer customer;

    public Project(String name, Customer customer) {
        this.name = name;
        this.customer = customer;
    }

    public String getName() {
        return name;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public int compareTo(Project project) {
        return project.name.compareTo(this.name);
    }
}
