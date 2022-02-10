import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class CollectionsExample {

    public static void main(String[] args) {
        ArrayList<Employee> arrayList = new ArrayList<>();
        arrayList.add(new Employee(52, "emp2", "admin"));
        arrayList.add(new Employee(51, "emp1", "user"));
        arrayList.add(new Employee(53, "emp3", "admin"));
        Collections.sort(arrayList, (e1, e2) -> e1.empName.compareTo(e2.empName));
        arrayList.stream().forEach(x -> System.out.println(x.empName));
        arrayList.stream().filter(x -> x.role.equals("admin"))
                .forEach(x -> System.out.println(x.empName));

        Arrays.asList("red","green","blue")
                .stream()
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);
        IntStream.range(1,5)
                .forEach(System.out::println);
        System.out.println(sumOfIds(arrayList));
    }

    public static int sumOfIds(ArrayList<Employee> employees){
        return employees.stream().mapToInt(x -> x.getEmpId()).sum();
    }
}
