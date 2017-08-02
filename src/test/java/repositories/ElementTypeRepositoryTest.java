package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Element;
import com.astontech.hr.domain.ElementType;
import com.astontech.hr.repositories.ElementTypeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)//sets up the spring junit class when tests are run
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class}) // read the repository configuration
public class ElementTypeRepositoryTest
{
    @Autowired
    private ElementTypeRepository elementTypeRepository;

    @Test
    public void testSaveElementType()
    {
        // setup element
        ElementType elementType = new ElementType();
        elementType.setElementTypeName("Work");

        // save element, verify it has ID after the save
        assertNull(elementType.getId()); // if it's not null the assert will fail
        elementTypeRepository.save(elementType);// save element which will give it an Id
        assertNotNull(elementType.getId());// checks the Id is not null anymore (should pass)

        //fetch
        ElementType fetchedElementType = elementTypeRepository.findOne(elementType.getId());
        assertNotNull(fetchedElementType);
        assertEquals(elementType.getId(), fetchedElementType.getId());

        // update
        fetchedElementType.setElementTypeName("Home");
        elementTypeRepository.save(fetchedElementType);

        ElementType updatedElementType = elementTypeRepository.findOne(fetchedElementType.getId());
        assertEquals(updatedElementType.getElementTypeName(), "Home");
    }

    @Test
    public void testFindByType()
    {
        ElementType elementType = new ElementType("Work");
        elementTypeRepository.save(elementType);

        ElementType foundByTypeElement = elementTypeRepository.findByElementTypeName("Work");

        assertEquals(elementType.getId(), foundByTypeElement.getId());
    }

    @Test
    public void testFindAllByType()
    {
        ElementType elementType1 = new ElementType("FindTest");
        elementTypeRepository.save(elementType1);
        ElementType elementType2 = new ElementType("FindTest");
        elementTypeRepository.save(elementType2);
        ElementType elementType3 = new ElementType("FindTest");
        elementTypeRepository.save(elementType3);

        List<ElementType> foundAllByTypeElement = elementTypeRepository.findAllByElementTypeName("FindTest");

        assertEquals(3, foundAllByTypeElement.size());
    }

    @Test
    public void testFindAllByTypeIgnoreCase()
    {
        ElementType elementType1 = new ElementType("FindTest");
        elementTypeRepository.save(elementType1);
        ElementType elementType2 = new ElementType("findTest");
        elementTypeRepository.save(elementType2);
        ElementType elementType3 = new ElementType("Findtest");
        elementTypeRepository.save(elementType3);

        List<ElementType> foundAllByTypeElementIgnoreCase
                = elementTypeRepository.findAllByElementTypeNameIgnoreCase("FindTest");

        assertEquals(3, foundAllByTypeElementIgnoreCase.size());
    }

    @Test
    public void testCountByName()
    {
        ElementType element1 = new ElementType("element1");
        elementTypeRepository.save(element1);
        ElementType element2 = new ElementType("element1");
        elementTypeRepository.save(element2);
        ElementType element3 = new ElementType("element2");
        elementTypeRepository.save(element3);

        int count = elementTypeRepository.countByElementTypeName("element1");

        assertEquals(2,count);
    }

    @Test
    public void testDeleteByName()
    {
        ElementType element1 = new ElementType("element1");
        elementTypeRepository.save(element1);
        ElementType element2 = new ElementType("element2");
        elementTypeRepository.save(element2);
        ElementType element3 = new ElementType("element3");
        elementTypeRepository.save(element3);

        int delete = elementTypeRepository.deleteByElementTypeName("element2");
        delete+= elementTypeRepository.deleteByElementTypeName("element3");

        assertEquals(2, delete);
    }


}
