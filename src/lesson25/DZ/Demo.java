package lesson25.DZ;

public class Demo {
    public static void main(String[] args) throws Exception {
        GeneralDAO<Solution> generalDAO = new GeneralDAO();

        Solution solution = new Solution("Kirill");
        Solution solution5 = new Solution("Kirill");
        Solution solution2 = new Solution("Oleg");
        Solution solution3 = new Solution("Peter");
        Solution solution4 = new Solution("Illia");

        generalDAO.save(solution);
        generalDAO.save(solution5);
    }
}
