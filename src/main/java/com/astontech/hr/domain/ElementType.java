package com.astontech.hr.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class ElementType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ElementTypeId")
    private Integer Id;

    @Version
    private Integer version;

    private String elementTypeName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) //sub elements will be saved first and
    // retrieving will get all nested subelements
    private List<Element> elementList;

    public ElementType(){}
    public ElementType(String elementTypeName)
    {
        this.elementTypeName = elementTypeName;
    }
    public ElementType(String elementTypeName, List<Element> elementList)
    {
        this.setElementTypeName(elementTypeName);
        this.setElementList(elementList);
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getElementTypeName() {
        return elementTypeName;
    }

    public void setElementTypeName(String elementType) {
        this.elementTypeName = elementType;
    }

    public List<Element> getElementList() {
        return elementList;
    }

    public void setElementList(List<Element> elementList) {
        this.elementList = elementList;
    }
}