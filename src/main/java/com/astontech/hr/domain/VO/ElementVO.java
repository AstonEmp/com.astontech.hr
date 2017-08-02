package com.astontech.hr.domain.VO;

public class ElementVO
{
    //region PROPERTIES
    private String newElementType;
    private String newElements;
    private String[] newElementArray;
    //endregion

    //region CONSTRUCTORS
    public ElementVO(){}
    //endregion

    //region ACCESSORS / MUTATORS
    public String getNewElementType() {
        return newElementType;
    }

    public void setNewElementType(String newElementType) {
        this.newElementType = newElementType;
    }

    public String getNewElements() {
        return newElements;
    }

    public void setNewElements(String newElements) {
        this.newElements = newElements;
    }


    public String[] getNewElementArray() {
        return newElementArray;
    }

    public void setNewElementArray(String[] newElementArray) {
        this.newElementArray = newElementArray;
    }
    //endregion

    //region CUSTOM METHODS

    public void splitNewElementsIntoArray()
    {
        //regex for splitting on a new line or carriage return is "\\r?\\n"
        this.setNewElementArray(this.getNewElements().split("\\r?\\n"));
    }

    //endregion
}
