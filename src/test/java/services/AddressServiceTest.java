//package services;
//
//import com.astontech.hr.Application;
//import com.astontech.hr.domain.Address;
//import com.astontech.hr.services.AddressService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNull;
//
//@RunWith(SpringJUnit4ClassRunner.class)//sets up the spring junit class when tests are run
//@SpringApplicationConfiguration(classes = {Application.class}) // read the repository configuration
//@WebAppConfiguration
//public class AddressServiceTest
//{
//    @Autowired
//    private AddressService addressService;
//
//    @Test
//    public void addressServiceSaveTest()
//    {
//        Address address = new Address();
//
//        address.setStreetAddress("111 Main Street");
//        address.setCity("Fargo");
//        address.setState("ND");
//        address.setZip("58104");
//
//        assertNull(address.getId());
//        addressService.saveAddress(address);
//        assertNotNull(address.getId());
//
//        //fetch
//        Address fetchedAddress = addressService.getAddressById(address.getId());
//        assertNotNull(fetchedAddress);
//        assertEquals(address.getId(),fetchedAddress.getId());
//
//        //update
//        fetchedAddress.setStreetAddress("Main Street Test");
//        fetchedAddress.setCity("City Test");
//        fetchedAddress.setState("State Test");
//        fetchedAddress.setZip("zip test");
//        addressService.saveAddress(fetchedAddress);
//
//        Address updatedAddress = addressService.getAddressById(fetchedAddress.getId());
//        assertEquals("Main Street Test", updatedAddress.getStreetAddress());
//    }
//}
