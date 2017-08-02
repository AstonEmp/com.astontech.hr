package com.astontech.hr.bootstrap;

import com.astontech.hr.services.ElementService;
import com.astontech.hr.services.ElementTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class SeedData implements ApplicationListener<ContextRefreshedEvent>
{
    @Autowired
    private ElementService elementService;

    @Autowired
    private ElementTypeService elementTypeService;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        generateElementAndElementTypeNames();
    }

    private void generateElementAndElementTypeNames()
    {
//        ElementType laptopType = new ElementType("Laptop");
//        ElementType tvType = new ElementType("TV");
//        ElementType tacoType = new ElementType("Taco");
//
//        List<Element> elementList = new ArrayList<>();
//        List<Element> elementList2 = new ArrayList<>();
//        List<Element> elementList3 = new ArrayList<>();
//
//        elementList.add(new Element("Acer"));
//        elementList.add(new Element("Dell"));
//        elementList.add(new Element("Samsung"));
//        elementList.add(new Element("Apple"));
//        elementList.add(new Element("Asus"));
//
//        elementList2.add(new Element("Samsung"));
//        elementList2.add(new Element("LG"));
//        elementList2.add(new Element("Toshiba"));
//        elementList2.add(new Element("Sony"));
//        elementList2.add(new Element("Insignia"));
//
//        elementList3.add(new Element("Chicken"));
//        elementList3.add(new Element("Beef"));
//        elementList3.add(new Element("Steak"));
//        elementList3.add(new Element("Bean"));
//
//
//        laptopType.setElementList(elementList);
//        tvType.setElementList(elementList2);
//        tacoType.setElementList(elementList3);
//
//        elementTypeService.saveElementType(laptopType);
//        elementTypeService.saveElementType(tvType);
//        elementTypeService.saveElementType(tacoType);
    }
}
