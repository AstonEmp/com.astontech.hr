//package repositories;
//
//import com.astontech.hr.configuration.RepositoryConfiguration;
//import com.astontech.hr.domain.Address;
//import com.astontech.hr.repositories.AddressRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNull;
//
//@RunWith(SpringJUnit4ClassRunner.class)//sets up the spring junit class when tests are run
//@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class}) // read the repository configuration
//public class AddressRepositoryTest
//{
//    @Autowired
//    private AddressRepository addressRepository;
//
//    @Test
//    public void testSaveAddress()
//    {
//        // setup address
//        Address address = new Address();
//        address.setState("ND");
//        address.setCity("Fargo");
//        address.setZip("58104");
//        address.setStreetAddress("111 Main Street");
//
//        // save address, verify it has ID after the save
//        assertNull(address.getId()); // if it's not null the assert will fail
//        addressRepository.save(address);// save address which will give it an Id
//        assertNotNull(address.getId());// checks the Id is not null anymore (should pass)
//
//        //fetch
//        Address fetchedAddress = addressRepository.findOne(address.getId());
//        assertNotNull(fetchedAddress);
//        assertEquals(address.getId(), fetchedAddress.getId());
//
//        // update
//        fetchedAddress.setState("MN");
//        fetchedAddress.setCity("Minneapolis");
//        fetchedAddress.setStreetAddress("123 Main Street");
//        fetchedAddress.setZip("55404");
//        addressRepository.save(fetchedAddress);
//
//        Address updatedAddress = addressRepository.findOne(fetchedAddress.getId());
//        assertEquals(updatedAddress.getCity(), "Minneapolis");
//        assertEquals(updatedAddress.getState(), "MN");
//        assertEquals(updatedAddress.getStreetAddress(), "123 Main Street");
//        assertEquals(updatedAddress.getZip(), "55404");
//    }
//
//    @Test
//    public void testSaveAddressList()
//    {
//        addressRepository.deleteAll();
//
//        List<Address> addressList = new ArrayList<>();
//
//        addressList.add(new Address("111 Main Street","Fargo","ND","58104"));
//        addressList.add(new Address("121 South Street","Minneapolis","MN","55404"));
//        addressList.add(new Address("143 North Street","Sioux Falls","SD","13245"));
//        addressList.add(new Address("178 West Street","Big Sky","MT","12345"));
//
//        addressRepository.save(addressList);
//
//        List<Address> fetchedAddressList = addressRepository.findAll();
//
//        int count = 0;
//        for(Address address : fetchedAddressList)
//        {
//            count++;
//            System.out.println("count" + count + " " + address.getCity());
//        }
//
//        assertEquals(4,count);
//    }
//
//    @Test
//    public void testFindAllByStateIgnoreCase()
//    {
//        Address address1 = new Address("111 Main Street","Fargo","ND","58104");
//        addressRepository.save(address1);
//        Address address2 = new Address("111 Main Street","Fargo","Nd","58104");
//        addressRepository.save(address2);
//        Address address3 = new Address("111 Main Street","Fargo","nD","58104");
//        addressRepository.save(address3);
//
//        List<Address> foundAllByStateAddressIgnoreCase
//                = addressRepository.findAllByStateIgnoreCase("ND");
//
//        assertEquals(3, foundAllByStateAddressIgnoreCase.size());
//    }
//}
