//package repositories;
//
//import com.astontech.hr.configuration.RepositoryConfiguration;
//import com.astontech.hr.domain.Contact;
//import com.astontech.hr.repositories.ContactRepository;
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
//public class ContactRepositoryTest
//{
//    @Autowired
//    private ContactRepository contactRepository;
//
//    @Test
//    public void testSaveContact()
//    {
//        // setup contact
//        Contact contact = new Contact();
//        contact.setEmailAddress("eric@outlook.com");
//
//        // save contact, verify it has ID after the save
//        assertNull(contact.getId()); // if it's not null the assert will fail
//        contactRepository.save(contact);// save contact which will give it an Id
//        assertNotNull(contact.getId());// checks the Id is not null anymore (should pass)
//
//        //fetch
//        Contact fetchedContact = contactRepository.findOne(contact.getId());
//        assertNotNull(fetchedContact);
//        assertEquals(contact.getId(), fetchedContact.getId());
//
//        // update
//        fetchedContact.setEmailAddress("bill@outlook.com");
//        contactRepository.save(fetchedContact);
//
//        Contact updatedContact = contactRepository.findOne(fetchedContact.getId());
//        assertEquals(updatedContact.getEmailAddress(), "bill@outlook.com");
//    }
//
//    @Test
//    public void testSaveContactList()
//    {
//        contactRepository.deleteAll();
//
//        List<Contact> contactList = new ArrayList<>();
//
//        contactList.add(new Contact("bill@outlook.com"));
//        contactList.add(new Contact("bob@outlook.com"));
//        contactList.add(new Contact("eric@outlook.com"));
//        contactList.add(new Contact("sally@outlook.com"));
//
//        contactRepository.save(contactList);
//
//        List<Contact> fetchedContactList = contactRepository.findAll();
//
//        int count = 0;
//        for(Contact contact : fetchedContactList)
//        {
//            count++;
//            System.out.println("count" + count + " " + contact.getEmailAddress());
//        }
//
//        assertEquals(4,count);
//    }
//
//    @Test
//    public void testFindAllByEmailIgnoreCase()
//    {
//        contactRepository.deleteAll();
//        Contact contact1 = new Contact("Eric@outlook.com");
//        contactRepository.save(contact1);
//        Contact contact2 = new Contact("eric@outlook.com");
//        contactRepository.save(contact2);
//        Contact contact3 = new Contact("EriC@outlook.com");
//        contactRepository.save(contact3);
//
//        List<Contact> foundAllByStateContactIgnoreCase
//                = contactRepository.findAllByEmailAddressIgnoreCase("eric@outlook.com");
//
//        assertEquals(3, foundAllByStateContactIgnoreCase.size());
//    }
//}
