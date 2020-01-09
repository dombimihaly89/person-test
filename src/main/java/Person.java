public class Person {

    private Cat cat;

    private String lastname;

    private String firstname;

    private int age;

    private boolean isMale;

    private long id;

    public Person(String lastname, String firstname, int age, boolean isMale, long id) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.age = age;
        this.isMale = isMale;
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void grow() {
        this.age++;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", age=" + age +
                ", isMale=" + isMale +
                ", id=" + id +
                '}' + "\n";
    }
}
