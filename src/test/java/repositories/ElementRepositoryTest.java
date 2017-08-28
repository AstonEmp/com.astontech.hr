//package repositories;
//
//import com.astontech.hr.configuration.RepositoryConfiguration;
//import com.astontech.hr.domain.Element;
//import com.astontech.hr.repositories.ElementRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
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
//@SpringBootTest(classes = RepositoryConfiguration.class)
//public class ElementRepositoryTest
//{
//    @Autowired
//    private ElementRepository elementRepository;
//
//    @Test
//    public void testSaveElement()
//    {
//        // setup element
//        Element element = new Element();
//        element.setElementName("Phone");
//
//        // save element, verify it has ID after the save
//        assertNull(element.getId()); // if it's not null the assert will fail
//        elementRepository.save(element);// save element which will give it an Id
//        assertNotNull(element.getId());// checks the Id is not null anymore (should pass)
//
//        //fetch
//        Element fetchedElement = elementRepository.findOne(element.getId());
//        assertNotNull(fetchedElement);
//        assertEquals(element.getId(), fetchedElement.getId());
//
//        // update
//        fetchedElement.setElementName("Email");
//        elementRepository.save(fetchedElement);
//
//        Element updatedElement = elementRepository.findOne(fetchedElement.getId());
//        assertEquals(updatedElement.getElementName(), "Email");
//    }
//
//    @Test
//    public void testSaveElementList()
//    {
//        List<Element> elementList = new ArrayList<>();
//
//        elementList.add(new Element("Phone"));
//        elementList.add(new Element("Email"));
//        elementList.add(new Element("Laptop"));
//        elementList.add(new Element("PayRate"));
//
//        elementRepository.save(elementList);
//
//        Iterable<Element> fetchedElementList = elementRepository.findAll();
//
//        int count = 0;
//        for(Element element : fetchedElementList)
//        {
//            count++;
//            System.out.println("count" + count + " " +element.getElementName());
//        }
//
//        assertEquals(4,count);
//    }
//
//    @Test
//    public void testFindByName()
//    {
//        Element element = new Element("FindTest");
//        elementRepository.save(element);
//
//        Element foundByNameElement = elementRepository.findByElementName("FindTest");
//
//        assertEquals(element.getId(), foundByNameElement.getId());
//    }
//
//    @Test
//    public void testFindAllByName()
//    {
//        Element element1 = new Element("FindTest");
//        elementRepository.save(element1);
//        Element element2 = new Element("FindTest");
//        elementRepository.save(element2);
//        Element element3 = new Element("FindTest");
//        elementRepository.save(element3);
//
//        List<Element> foundAllByNameElement = elementRepository.findAllByElementName("FindTest");
//
//        assertEquals(3, foundAllByNameElement.size());
//    }
//
//    @Test
//    public void testFindAllByNameIgnoreCase()
//    {
//        Element element1 = new Element("findTest");
//        elementRepository.save(element1);
//        Element element2 = new Element("Findtest");
//        elementRepository.save(element2);
//        Element element3 = new Element("FiNdTest");
//        elementRepository.save(element3);
//
//        List<Element> foundAllByNameElementIgnoreCase
//                = elementRepository.findAllByElementNameIgnoreCase("FindTest");
//
//        assertEquals(3, foundAllByNameElementIgnoreCase.size());
//    }
//
//    @Test
//    public void testCountByName()
//    {
//        Element element1 = new Element("element1");
//        elementRepository.save(element1);
//        Element element2 = new Element("element1");
//        elementRepository.save(element2);
//        Element element3 = new Element("element2");
//        elementRepository.save(element3);
//
//        int count = elementRepository.countByElementName("element1");
//
//        assertEquals(2,count);
//    }
//
//
//    @Test
//    public void testDeleteByName()
//    {
//        Element element1 = new Element("element1");
//        elementRepository.save(element1);
//        Element element2 = new Element("element2");
//        elementRepository.save(element2);
//        Element element3 = new Element("element3");
//        elementRepository.save(element3);
//
//        int delete = elementRepository.deleteByElementName("element2");
//        delete+= elementRepository.deleteByElementName("element3");
//
//        assertEquals(2, delete);
//    }
//}
