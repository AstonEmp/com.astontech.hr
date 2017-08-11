package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Employee;
import com.astontech.hr.repositories.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)//sets up the spring junit class when tests are run
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class}) // read the repository configuration
public class EmployeeRepositoryTest
{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testSave()
    {
        Employee employee = new Employee();
        employee.setFirstName("Eric");
        employee.setLastName("Braun");
        employee.setBackground("Java Developer");

        assertNull(employee.getId());
        employeeRepository.save(employee);
        assertNotNull(employee.getId());

        //fetch
        Employee fetchedEmployee = employeeRepository.findOne(employee.getId());
        assertNotNull(fetchedEmployee);
        assertEquals(employee.getId(),fetchedEmployee.getId());

        //update
        fetchedEmployee.setFirstName("Eric");
        employeeRepository.save(fetchedEmployee);

        Employee fetchUpdatedEmployee = employeeRepository.findOne(fetchedEmployee.getId());
        assertEquals("Eric", fetchUpdatedEmployee.getFirstName());
    }
}
