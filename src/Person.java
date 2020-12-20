// Person Class.
public class Person implements Comparable
{
    private String name;
    private int idNumber;
    private int birthYear;

    // Constructor.
    public Person(String name, int idNumber, int birthYear)
    {
        this.setName(name);
        this.setIdNumber(idNumber);
        this.setBirthYear(birthYear);
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setIdNumber(int idNumber)
    {
        this.idNumber = idNumber;
    }

    public int getIdNumber()
    {
        return idNumber;
    }

    public void setBirthYear(int birthYear)
    {
        this.birthYear = birthYear;
    }

    public int getBirthYear()
    {
        return birthYear;
    }

    @Override
    public int compareTo(Object o)
    {
        Person p = (Person) o;
        if (this.getBirthYear() < p.getBirthYear())
            return 1;
        else if (p.getBirthYear() < this.getBirthYear())
            return -1;
        else return 0;
    }

    @Override
    public String toString()
    {
        return "Person{" +
                "name='" + name + '\'' +
                ", idNumber=" + idNumber +
                ", birthYear=" + birthYear +
                '}';
    }
}
