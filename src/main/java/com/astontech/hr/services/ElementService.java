package com.astontech.hr.services;

import com.astontech.hr.domain.Element;

import javax.transaction.Transactional;
import java.util.List;

public interface ElementService
{
    Iterable<Element> listAllElements();

    Element getElementById(Integer id);

    Element saveElement(Element element);

    Iterable<Element> saveElementList(Iterable<Element> elementIterable);

    void deleteElement(Integer id);

    // will auto generate the required code from the structure of the method name
    /*
    custom repository methods
     */
    Element findByElementName(String elementName);

    List<Element> findAllByElementName (String elementName);

    List<Element> findAllByElementNameIgnoreCase (String elementName);


    Integer countByElementName(String elementName);

    @Transactional
    Integer deleteByElementName(String elementName);

}
