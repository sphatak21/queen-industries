import java.lang.reflect.Array;
import java.util.ArrayList;

public class Director extends Manager {
    private int stockShares;
    public Director(int salary, int stockShares, int bonus, String name, String department, String titleString, ArrayList<Employee> reports, int titleInt) throws Exception {
            super( salary, bonus, name, department, titleString, reports, titleInt);
            this.stockShares = stockShares;

    }
    public void adjustSalary(int change, Employee e) throws Exception{
        ArrayList<Employee> reports = this.getReports();
        if(reports.contains(e)){
            e.setSalary(e.getSalary() + change);
            return;
        }else if(!reports.contains(e)){
            for(Employee emp : reports){
                if(emp.getTitleInt() == Company.MANAGER){
                    Manager m = (Manager) emp;
                    if(m.getReports().contains(e)){
                        e.setSalary(e.getSalary() + change);
                        return;
                    }

                }
            }
        }
        throw new java.lang.Exception("ERROR: cannot alter salary of an Employee who is not a report.");


    }
}
