package com.astontech.hr.services.impl;

import com.astontech.hr.domain.Element;
import com.astontech.hr.domain.ElementType;
import com.astontech.hr.repositories.ElementTypeRepository;
import com.astontech.hr.services.ElementTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElementTypeServiceImpl implements ElementTypeService
{
    @Autowired
    private ElementTypeRepository elementTypeRepository;

    @Override
    public Iterable<ElementType> listAllElementTypeNames() {
        return elementTypeRepository.findAll();
    }

    @Override
    public ElementType getElementTypeById(Integer id) {
        return elementTypeRepository.findOne(id);
    }

    @Override
    public ElementType saveElementTypeName(ElementType elementTypeName) {
        return elementTypeRepository.save(elementTypeName);
    }

    @Override
    public Iterable<ElementType> saveElementTypeNameList(Iterable<ElementType> elementTypeIterable) {
        return elementTypeRepository.save(elementTypeIterable);
    }

    @Override
    public void deleteElementTypeName(Integer id)
    {
        elementTypeRepository.delete(id);
    }

    @Override
    public ElementType findByElementTypeName(String elementTypeName) {
        return elementTypeRepository.findByElementTypeName(elementTypeName);
    }

    @Override
    public List<ElementType> findAllByElementTypeName(String elementTypeName) {
        return elementTypeRepository.findAllByElementTypeName(elementTypeName);
    }

    @Override
    public List<ElementType> findAllByElementTypeNameIgnoreCase(String elementTypeName) {
        return elementTypeRepository.findAllByElementTypeNameIgnoreCase(elementTypeName);
    }

    @Override
    public Integer countByElementTypeName(String elementTypeName) {
        return elementTypeRepository.countByElementTypeName(elementTypeName);
    }

    @Override
    public Integer deleteByElementTypeName(String elementTypeName) {
        return elementTypeRepository.deleteByElementTypeName(elementTypeName);
    }
}
