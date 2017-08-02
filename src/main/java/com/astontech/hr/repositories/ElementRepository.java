package com.astontech.hr.repositories;


import com.astontech.hr.domain.Element;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;


public interface ElementRepository extends CrudRepository<Element, Integer>
{

    // will auto generate the required code from the structure of the method name
    Element findByElementName(String elementName);

    List<Element> findAllByElementName (String elementName);

    List<Element> findAllByElementNameIgnoreCase (String elementName);


    Integer countByElementName(String elementName);

    @Transactional
    Integer deleteByElementName(String elementName);

}
