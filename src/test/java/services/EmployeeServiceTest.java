//package services;
//
//import com.astontech.hr.Application;
//import com.astontech.hr.domain.Employee;
//import com.astontech.hr.services.EmployeeService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNull;
//import static org.junit.Assert.assertEquals;
//
//@RunWith(SpringJUnit4ClassRunner.class)//sets up the spring junit class when tests are run
//@SpringBootTest(classes = Application.class)
//@WebAppConfiguration
//public class EmployeeServiceTest
//{
//    @Autowired
//    private EmployeeService employeeService;
//
//    @Test
//    public void employeeServiceSaveTest()
//    {
//        Employee employee = new Employee();
//
//        employee.setFirstName("Eric");
//        employee.setLastName("Braun");
//        employee.setBackground("Java Developer");
//
//        assertNull(employee.getId());
//        employeeService.saveEmployee(employee);
//        assertNotNull(employee.getId());
//
//        //fetch
//        Employee fetchedEmployee = employeeService.getEmployeeById(employee.getId());
//        assertNotNull(fetchedEmployee);
//        assertEquals(employee.getId(),fetchedEmployee.getId());
//
//        //update
//        fetchedEmployee.setFirstName("EricTest");
//        employeeService.saveEmployee(fetchedEmployee);
//
//        Employee updatedEmployee = employeeService.getEmployeeById(fetchedEmployee.getId());
//        assertEquals("EricTest", updatedEmployee.getFirstName());
//    }
//}
