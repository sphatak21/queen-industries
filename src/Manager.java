import java.util.ArrayList;
public class Manager extends Employee {
    private int bonus;
    private ArrayList<Employee> reports;
    public Manager(int salary, int bonus, String name, String department, String titleString, ArrayList<Employee> reports, int titleInt) throws Exception {
        super(salary, name, department, titleString, titleInt);
        this.bonus = bonus;
        for(Employee e : reports){
            if(e.getTitleInt() >= titleInt){
                throw new java.lang.Exception("ERROR: cannot supervise an Employee of an equal or greater tier.");
            }
        }
        this.reports = reports;
    }
    public void hire(Employee e) throws Exception {
            if(this.getTitleInt() > e.getTitleInt()){
                e.setSupervisor(this);
                reports.add(e);
                Company.addStaff(e);
                System.out.println("LOG: new Employee hired " + "(" + e.getName() + ", " + e.getDepartment() + ", " + e.getTitleString() +")");
            }else{
                throw new java.lang.Exception("ERROR: cannot hire an Employee who is not a direct or indirect report.");

            }
    }

    public ArrayList<Employee> getReports() {
        return reports;
    }

    public boolean fire(Employee e) throws Exception{
        if(reports.contains(e)){

            if(this.getTitleInt() > e.getTitleInt()){
                if(e.getTitleInt() > 1){
                    Manager m = (Manager) e;
                    for(Employee emp : m.getReports()){
                        this.hire(emp);
                    }
                }
                System.out.println("LOG: existing Employee fired " + "(" + e.getName() + ", " + e.getDepartment() + ", " + e.getTitleString() +")");
                Company.removeStaff(e);
                return reports.remove(e);
            }else {
                throw new java.lang.Exception("ERROR: cannot fire an Employee of an equal or greater tier.");
            }
        }else {
            throw new java.lang.Exception("ERROR: cannot fire an Employee who is not a direct or indirect report.");
        }
    }
}
