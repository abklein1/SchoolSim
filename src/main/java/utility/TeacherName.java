package utility;

public class TeacherName implements PName {

    private String firstName;
    private String lastName;

    public TeacherName(){
        this.firstName = null;
        this.lastName = null;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }
}
