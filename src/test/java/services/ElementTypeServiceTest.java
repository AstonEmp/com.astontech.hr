package services;

import com.astontech.hr.Application;
import com.astontech.hr.domain.ElementType;
import com.astontech.hr.services.ElementTypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)//sets up the spring junit class when tests are run
@SpringApplicationConfiguration(classes = {Application.class}) // read the repository configuration
@WebAppConfiguration
public class ElementTypeServiceTest
{
    @Autowired
    ElementTypeService elementTypeService;


    @Test
    public void testSaveElementType()
    {
        // setup element
        ElementType elementType = new ElementType();
        elementType.setElementTypeName("Work");

        // save element, verify it has ID after the save
        assertNull(elementType.getId()); // if it's not null the assert will fail
        elementTypeService.saveElementTypeName(elementType);// save element which will give it an Id
        assertNotNull(elementType.getId());// checks the Id is not null anymore (should pass)

        //fetch
        ElementType fetchedElementType = elementTypeService.getElementTypeById(elementType.getId());
        assertNotNull(fetchedElementType);
        assertEquals(elementType.getId(), fetchedElementType.getId());

        // update
        fetchedElementType.setElementTypeName("Home");
        elementTypeService.saveElementTypeName(fetchedElementType);

        ElementType updatedElementType = elementTypeService.getElementTypeById(fetchedElementType.getId());
        assertEquals(updatedElementType.getElementTypeName(), "Home");
    }
}
