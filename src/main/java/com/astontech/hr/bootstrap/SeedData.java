package com.astontech.hr.bootstrap;

import com.astontech.hr.domain.*;
import com.astontech.hr.repositories.EmployeeRepository;
import com.astontech.hr.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SeedData implements ApplicationListener<ContextRefreshedEvent>
{
    private final ElementTypeService elementTypeService;

    private final VehicleMakeService vehicleMakeService;

    private final EmployeeService employeeService;

    private final ContactService contactService;

    @Autowired
    public SeedData(ElementTypeService elementTypeService,VehicleMakeService vehicleMakeService, EmployeeService employeeService,
                    ContactService contactService)
    {
        this.contactService = contactService;
        this.elementTypeService = elementTypeService;
        this.vehicleMakeService = vehicleMakeService;
        this.employeeService = employeeService;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event)
    {
//        generateElementAndElementTypeNames();
//        generateVehiclesVehicleModelsAndVehicleMakes();
//        generateEmployees();
//        generateContacts();
    }

    public void generateEmployees()
    {
        Employee employee = new Employee();
        employee.setFirstName("Eric");
        employee.setLastName("Braun");
        employee.setBackground("Java Developer");
        employeeService.saveEmployee(employee);

        Employee employee2 = new Employee();
        employee2.setFirstName("Jesse");
        employee2.setLastName("Braun");
        employee2.setBackground("Electrical Engineer");
        employeeService.saveEmployee(employee2);

        Employee employee3 = new Employee();
        employee3.setFirstName("Tony");
        employee3.setLastName("Morano");
        employee3.setBackground("Java Developer");
        employeeService.saveEmployee(employee3);

        Employee employee4 = new Employee();
        employee4.setFirstName("Bipin");
        employee4.setLastName("Butala");
        employee4.setBackground("Java Developer");
        employeeService.saveEmployee(employee4);
    }

    public void generateVehiclesVehicleModelsAndVehicleMakes()
    {

        VehicleMake vehicleMake = new VehicleMake("Chevrolet");
        VehicleMake vehicleMake2 = new VehicleMake("Ford");
        VehicleMake vehicleMake3 = new VehicleMake("Subaru");


        List<Vehicle> vehicleList = new ArrayList<>();
        List<Vehicle> vehicleList3 = new ArrayList<>();
        List<Vehicle> vehicleList6 = new ArrayList<>();
        List<VehicleModel> vehicleModelList = new ArrayList<>();
        List<VehicleModel> vehicleModelList2 = new ArrayList<>();
        List<VehicleModel> vehicleModelList3 = new ArrayList<>();

        vehicleModelList.add(new VehicleModel("Cruze"));
        vehicleModelList.add(new VehicleModel("Silverado"));
        vehicleModelList.add(new VehicleModel("Camaro"));
        vehicleModelList.add(new VehicleModel("Impala"));

        vehicleModelList2.add(new VehicleModel("F-150"));
        vehicleModelList2.add(new VehicleModel("Taurus"));
        vehicleModelList2.add(new VehicleModel("Fiesta"));
        vehicleModelList2.add(new VehicleModel("Mustang"));

        vehicleModelList3.add(new VehicleModel("Impreza"));
        vehicleModelList3.add(new VehicleModel("WRX"));
        vehicleModelList3.add(new VehicleModel("BRZ"));
        vehicleModelList3.add(new VehicleModel("Legacy"));

        vehicleList.add(new Vehicle("Eric",2010,"283497","red","387392"));

        vehicleList3.add(new Vehicle("Sally",2005,"3948adsf","green","3947jl"));

        vehicleList6.add(new Vehicle("Bill",2009,"1254","blue","923nsd"));


        vehicleModelList.get(1).setVehicleList(vehicleList);
        vehicleModelList2.get(2).setVehicleList(vehicleList3);
        vehicleModelList3.get(3).setVehicleList(vehicleList6);



        vehicleMake.setVehicleModelList(vehicleModelList);
        vehicleMake2.setVehicleModelList(vehicleModelList2);
        vehicleMake3.setVehicleModelList(vehicleModelList3);


        vehicleMakeService.saveVehicleMake(vehicleMake);
        vehicleMakeService.saveVehicleMake(vehicleMake2);
        vehicleMakeService.saveVehicleMake(vehicleMake3);
    }

    private void generateElementAndElementTypeNames()
    {
        ElementType laptopType = new ElementType("Laptop");
        ElementType tvType = new ElementType("TV");
        ElementType tacoType = new ElementType("Taco");

        List<Element> elementList = new ArrayList<>();
        List<Element> elementList2 = new ArrayList<>();
        List<Element> elementList3 = new ArrayList<>();

        elementList.add(new Element("Acer"));
        elementList.add(new Element("Dell"));
        elementList.add(new Element("Samsung"));
        elementList.add(new Element("Apple"));
        elementList.add(new Element("Asus"));

        elementList2.add(new Element("Samsung"));
        elementList2.add(new Element("LG"));
        elementList2.add(new Element("Toshiba"));
        elementList2.add(new Element("Sony"));
        elementList2.add(new Element("Insignia"));

        elementList3.add(new Element("Chicken"));
        elementList3.add(new Element("Beef"));
        elementList3.add(new Element("Steak"));
        elementList3.add(new Element("Bean"));


        laptopType.setElementList(elementList);
        tvType.setElementList(elementList2);
        tacoType.setElementList(elementList3);

        elementTypeService.saveElementTypeName(laptopType);
        elementTypeService.saveElementTypeName(tvType);
        elementTypeService.saveElementTypeName(tacoType);

    }

    public void generateContacts()
    {

        contactService.deleteAll();
        Project project = new Project();
        project.setProjectName("Rest Project");

        Project project2 = new Project();
        project2.setProjectName("Client Project");

        Project project3 = new Project();
        project3.setProjectName("Java Project");

        Project project4 = new Project();
        project4.setProjectName("New Project");

        List<Project> projectList = new ArrayList<>();
        projectList.add(project);
        projectList.add(project2);


        List<Project> projectList2 = new ArrayList<>();
        projectList2.add(project3);
        projectList2.add(project4);

        List<Address> addressList = new ArrayList<>();
        List<Address> addressList2 = new ArrayList<>();

        addressList.add(new Address("111 Main Street","Fargo","ND","58104"));
        addressList.add(new Address("121 South Street","Minneapolis","MN","55404"));

        addressList2.add(new Address("143 North Street","Sioux Falls","SD","13245"));
        addressList2.add(new Address("178 West Street","Big Sky","MT","12345"));

        Employee employee = new Employee();
        employee.setFirstName("Eric");
        employee.setLastName("Braun");
        employee.setBackground("Java Developer");
        employee.setProjectList(projectList);

        Employee employee2 = new Employee();
        employee2.setFirstName("Bill");
        employee2.setLastName("Joe");
        employee2.setBackground("Master Developer");
        employee2.setProjectList(projectList2);

        Contact contact = new Contact();
        contact.setEmailAddress("Eric@outlook.com");
        contact.setAddressList(addressList);
        contact.setEmployee(employee);

        Contact contact2 = new Contact();
        contact2.setEmailAddress("Bill@outlook.com");
        contact2.setAddressList(addressList2);
        contact2.setEmployee(employee2);

        contactService.saveContact(contact);
        contactService.saveContact(contact2);
    }
}
