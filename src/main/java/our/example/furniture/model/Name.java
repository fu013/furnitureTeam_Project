package our.example.furniture.model;

public class Name {
    private String USERS;
    private String AGE;

    @Override
    public String toString() {
        System.out.println("key = USERS");
        System.out.println("value = " + USERS);
        System.out.println("key = AGE");
        System.out.println("value = " + AGE);
        return "호출";
    }
}
