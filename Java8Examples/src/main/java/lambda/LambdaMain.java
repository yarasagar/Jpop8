package lambda;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class LambdaMain {

    static Supplier<List<Employee>> listSupplier = () -> getEmployeeRecords();

    public static void main(String[] args) {
        queries();
    }

    private static void queries() {
        //Query 3.1 : How many male and female employees are there in the organization?
        Map<String, Long> noOfMaleAndFemaleCount = listSupplier.get()
                .stream().collect(groupingBy(Employee::getGender, counting()));
        System.out.println(noOfMaleAndFemaleCount);
        Map<String, List<Employee>> noOfMaleAndFemaleCount2 = listSupplier.get()
                .stream().collect(groupingBy(Employee::getGender));
        System.out.println(noOfMaleAndFemaleCount2);
        //Query 3.2 : Print the name of all departments in the organization?
        List<String> departList = listSupplier.get().stream()
                .map(Employee::getDepartment).distinct().collect(Collectors.toList());
        System.out.println(departList);
        //Query 3.3 : What is the average age of male and female employees?
        Map<String, Double> avgOfAges = listSupplier.get().stream()
                .collect(groupingBy(Employee::getGender, averagingDouble(Employee::getAge)));
        System.out.println(avgOfAges);
        //Query 3.4 : Get the details of highest paid employee in the organization?
        Optional<Employee> e = listSupplier.get().stream().sorted((o1, o2) -> (int) (o2.salary-o1.salary))
                .findFirst();
        System.out.println(e.toString());
        Optional<Employee> e2 = listSupplier.get().stream().collect(Collectors.maxBy(
                Comparator.comparingDouble(Employee::getSalary)));
        System.out.println(e2.toString());
        //Query 3.5 : Get the names of all employees who have joined after 2015?
        List<String> employeeList = listSupplier.get().stream()
                .filter(emp -> emp.getYearOfJoining() > 2015).map(Employee::getName).collect(toList());
        System.out.println(employeeList);
        //Query 3.6 : Count the number of employees in each department?
        Map<String, Long> empCountForDepart = listSupplier.get().stream()
                .collect(groupingBy(Employee::getDepartment, counting()));
        System.out.println(empCountForDepart);
        //Query 3.7 : What is the average salary of each department?
        Map<String, Double> avgSalary = listSupplier.get().stream()
                .collect(groupingBy(Employee::getDepartment, averagingDouble(Employee::getSalary)));
        System.out.println(avgSalary);
        //Query 3.8 : Get the details of youngest male employee in the product development department?
        Optional<Employee> employee = listSupplier.get().stream()
                .filter(emp -> "Male".equals(emp.gender) && "Product Development".equals(emp.department))
//                .collect(minBy(Comparator.comparing(Employee::getAge)));
                .min(Comparator.comparing(Employee::getAge));
        System.out.println(employee);
        //Query 3.9 : Who has the most working experience in the organization?
        Optional<Employee> expEmp = listSupplier.get().stream()
                .min(Comparator.comparing(Employee::getYearOfJoining));
        System.out.println(expEmp);
        //Query 3.10 : How many male and female employees are there in the sales and marketing team?
        Map<String, Long> countOfEmp = listSupplier.get().stream()
                .filter(emps -> "Sales And Marketing".equals(emps.department))
                .collect(groupingBy(Employee::getGender, counting()));
        System.out.println(countOfEmp);
        //Query 3.11 : What is the average salary of male and female employees?
        Map<String, Double> avgSalary2 = listSupplier.get().stream()
                .collect(groupingBy(Employee::getGender, averagingDouble(Employee::getSalary)));
        System.out.println(avgSalary2);
        //Query 3.12 : List down the names of all employees in each department?
        Map<String, List<Employee>> deptWithEmps = listSupplier.get().stream()
                .collect(groupingBy(Employee::getDepartment));
        for(Map.Entry<String, List<Employee>> entry : deptWithEmps.entrySet()){
            System.out.println("Department is : "+entry.getKey());
            entry.getValue().stream().forEach(emp -> System.out.print(emp.name+" "));
            System.out.println();
        }
        //Query 3.13 : What is the average salary and total salary of the whole organization?
        OptionalDouble avgSal = listSupplier.get().stream().mapToDouble(Employee::getSalary).average();
        System.out.println(avgSal.toString());
        Double totSal = listSupplier.get().stream().mapToDouble(Employee::getSalary).sum();
        System.out.println(totSal);
        //Query 3.14 : Separate the employees who are younger or equal to 25 years from those
        // employees who are older than 25 years.
        Map<Boolean, List<Employee>> partEmps = listSupplier.get().stream()
                .collect(Collectors.partitioningBy(emp -> emp.age > 25));
        System.out.println(partEmps);
        //Query 3.15 : Who is the oldest employee in the organization? What is his age and which department he belongs to?
        Optional<Employee> oldEmp = listSupplier.get().stream()
                .max(Comparator.comparing(Employee::getAge));
        System.out.println(oldEmp.get().age+" "+oldEmp.get().department);
    }

    public static List<Employee> getEmployeeRecords(){
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

        return employeeList;
    }
}
