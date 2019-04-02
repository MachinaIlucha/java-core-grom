package lesson23;

public final class Validator {
    private String name;
    private final int checkCount;

    public Validator(String name, int checkCount) {
        this.name = name;
        this.checkCount = checkCount;
    }

    public final boolean validate(){
        //
        // logic 1
        //

        return false;
    }

    public String getName() {
        return name;
    }

    public int getCheckCount() {
        return checkCount;
    }
}