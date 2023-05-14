import com.digdes.dto.EmployeeDto;
import com.digdes.model.Employee;
import com.digdes.repository.impl.EmployeeRepoFile;
import com.digdes.service.EmployeeService;
import com.digdes.service.impl.EmployeeServiceFile;
import com.digdes.util.exception.BLLException;

public class Main {
    public static void main(String[] args) {
        EmployeeDto employeeDto1 = new EmployeeDto();
        employeeDto1.setName("Алексей");
        employeeDto1.setLastname("Александрович");
        employeeDto1.setPatronymic("Алексеев");
        employeeDto1.setEmail("alexeevaa@gmail.com");
        employeeDto1.setAccount("AlexAA");
        employeeDto1.setEmployeeStatus("active");

        EmployeeDto employeeDto2 = new EmployeeDto();
        employeeDto2.setName("Иван");
        employeeDto2.setLastname("Александрович");
        employeeDto2.setPatronymic("Иванов");
        employeeDto2.setEmail("ivanovai@gmail.com");
        employeeDto2.setAccount("IvanovAI");
        employeeDto2.setEmployeeStatus("active");

        EmployeeService employeeService = new EmployeeServiceFile(new EmployeeRepoFile());

        try{
            System.out.println("Создание:");
            Employee employee1 = employeeService.create(employeeDto1);
            Employee employee2 = employeeService.create(employeeDto2);
            System.out.println(employee1);
            System.out.println(employee2);

            System.out.println("\nПолучение:");
            // 6056c5ae-c9ed-4fd1-bdcb-a1556241d737
            // a4155456-8794-4526-bb4f-029ae6ffb728
            employee1 = employeeService.getById(employee1.getId());
            employee2 = employeeService.getById(employee2.getId());
            System.out.println(employee1);
            System.out.println(employee2);

            System.out.println("\nУдаление:");
            employeeService.deleteById(employee2.getId());

            for (Employee e : employeeService.getAll()){
                System.out.println(e);
            }

        } catch(BLLException e){
            System.out.println(e.getMessage());
        }
    }
}
