public class Employee implements Comparable {
    private int salary;
    private String name;
    private String department;
    private String titleString;
    private int titleInt;
    private Employee supervisor;
    public Employee(int salary, String name, String department, String titleString){
        this.salary = salary;
        this.name = name;
        this.department = department;
        this.titleString = titleString;
        this.titleInt = 1;
        this.supervisor = null;
    }



    public Employee(int salary, String name, String department, String titleString, int titleInt){
        this.salary = salary;
        this.name = name;
        this.department = department;
        this.titleString = titleString;
        this.titleInt = titleInt;
    }
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTitleString() {
        return titleString;
    }

    public void setTitleString(String titleString) {
        this.titleString = titleString;
    }
    public int getTitleInt() {
        return titleInt;
    }

    public void setTitleInt(int titleInt) {
        this.titleInt = titleInt;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public Employee getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Employee supervisor) {
        this.supervisor = supervisor;
    }
}
