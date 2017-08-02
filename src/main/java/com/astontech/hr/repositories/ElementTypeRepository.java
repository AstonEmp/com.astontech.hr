package com.astontech.hr.repositories;

import com.astontech.hr.domain.ElementType;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface ElementTypeRepository extends CrudRepository<ElementType, Integer>
{

    // will auto generate the required code from the structure of the method name
    ElementType findByElementTypeName(String elementTypeName);

    List<ElementType> findAllByElementTypeName (String elementTypeName);

    List<ElementType> findAllByElementTypeNameIgnoreCase (String elementTypeName);

    Integer countByElementTypeName(String elementTypeName);

    @Transactional
    Integer deleteByElementTypeName(String elementTypeName);
}
