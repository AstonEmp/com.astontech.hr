package com.astontech.hr.services;

import com.astontech.hr.domain.Element;
import com.astontech.hr.domain.ElementType;

import javax.transaction.Transactional;
import java.util.List;

public interface ElementTypeService
{
    Iterable<ElementType> listAllElementTypeNames();

    ElementType getElementTypeById(Integer id);

    ElementType saveElementTypeName(ElementType elementType);

    Iterable<ElementType> saveElementTypeNameList(Iterable<ElementType> elementTypeIterable);

    void deleteElementTypeName(Integer id);

    /*
    custom Repository methods
     */
    // will auto generate the required code from the structure of the method name
    ElementType findByElementTypeName(String elementType);

    List<ElementType> findAllByElementTypeName (String elementType);

    List<ElementType> findAllByElementTypeNameIgnoreCase (String elementType);

    Integer countByElementTypeName(String elementType);

    @Transactional
    Integer deleteByElementTypeName(String elementType);
}
