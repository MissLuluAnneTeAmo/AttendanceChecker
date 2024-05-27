public class Person {

    private String name;
    private String username;
    private int age;
    private boolean isAttended;
    private int code;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getSection()
    {
        return section;
    }

    public void setSection(String section)
    {
        this.section = section;
    }

    public boolean isAttended()
    {
        return isAttended;
    }

    public void setAttended(boolean attended)
    {
        isAttended = attended;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }
}
