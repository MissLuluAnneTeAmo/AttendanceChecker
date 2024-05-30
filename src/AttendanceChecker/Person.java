package AttendanceChecker;
public class Person {

    private String name;
    private String id;
    private String section;
    public boolean isAttended;
    private String code;
    public Person(String name, String section) {
        this.name = name;
        this.section = section;
    }

    public Person(String name, String section, String id, String code) {
        this.name = name;
        this.id = id;
        this.section = section;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String username)
    {
        this.id = username;
    }

    public String getSection()
    {
        return section;
    }

    public void setSection(String section)
    {
        this.section = section;
    }

    public void setAttended(boolean attended)
    {
        isAttended = attended;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public boolean setAttended() {
        return false;
    }
}
