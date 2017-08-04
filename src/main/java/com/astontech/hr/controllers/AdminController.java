package com.astontech.hr.controllers;

import com.astontech.hr.domain.Element;
import com.astontech.hr.domain.ElementType;
import com.astontech.hr.domain.VO.ElementVO;
import com.astontech.hr.domain.VO.VehicleMakeVO;
import com.astontech.hr.domain.VO.VehicleVO;
import com.astontech.hr.services.ElementTypeService;
import com.astontech.hr.services.VehicleMakeService;
import com.astontech.hr.services.VehicleModelService;
import com.astontech.hr.services.VehicleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
public class AdminController
{
    //region WIRES
    @Autowired
    private ElementTypeService elementTypeService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VehicleMakeService vehicleMakeService;

    @Autowired
    private VehicleModelService vehicleModelService;

    //endregion

    private Logger log = Logger.getLogger(AdminController.class);

    //region HOME
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminHome()
    {
        return "admin/adminHome";
    }
    //endregion

    //region VehicleMake Add/List
    @RequestMapping(value = "/admin/vehicle/add", method = RequestMethod.GET)
    public String adminVehicleMakeGet(Model model)
    {
        model.addAttribute("vehicleVO", new VehicleVO());//form model attribute is VehicleVO
        model.addAttribute("vehicleMakeList",vehicleMakeService.listAllVehicleMakes());
        //passes empty objeect and catches object on postback
//        model.addAttribute("warningAlert","visible");
        return "admin/vehicle/vehicle_add";
    }



    //endregion



    //region ELEMENT ADD/LIST
    @RequestMapping(value = "/admin/element/add", method = RequestMethod.GET)
    public String adminElementGet(Model model)
    {
        model.addAttribute("elementVO", new ElementVO());//form model attribute is elementVO; passes empty object and catches object on post back
        model.addAttribute("warningAlert","visible");
        return "admin/element/element_add";
    }

    @RequestMapping(value = "/admin/element/add", method = RequestMethod.POST)
    public String adminElementPost(ElementVO elementVO, Model model)
    {
        elementVO.splitNewElementsIntoArray();
        logElementVO(elementVO);

        saveElementTypeAndElementsFromVO(elementVO);//save element type and element type list to database

        boolean success = true;
        if(success)
            model.addAttribute("successAlert","visible");
        else
            model.addAttribute("errorAlert","visible");

        model.addAttribute("elementVO", new ElementVO());
        return "admin/element/element_add";
    }


    @RequestMapping(value = "/admin/element/list", method = RequestMethod.GET)
    public String adminElementList(Model model)
    {
        model.addAttribute("elementTypeList", elementTypeService.listAllElementTypeNames());
        return "admin/element/element_list";
    }
    //endregion

    //region HELPER METHODS

    //region Element/ElementType
    private void saveElementTypeAndElementsFromVO(ElementVO elementVO)
    {
        List<Element> newElementList = new ArrayList<>();
        for(String str : elementVO.getNewElementArray())
        {
            newElementList.add(new Element(str));
        }
        ElementType newElementType = new ElementType(elementVO.getNewElementType());
        newElementType.setElementList(newElementList);

        elementTypeService.saveElementTypeName(newElementType);
    }

    private void logElementVO(ElementVO elementVO)
    {
        log.info("New Element Type Name: " + elementVO.getNewElementType());

        for(String str : elementVO.getNewElementArray())
        {

            log.info("New Element: " + str);
        }

    }

    @RequestMapping(value = "/admin/element/edit/{id}", method = RequestMethod.GET)
    public String elementTypeEdit(@PathVariable int id, Model model)
    {
        ElementType elementType = elementTypeService.getElementTypeById(id);

        model.addAttribute("elementType", elementType);
        return "admin/element/element_edit";
    }

    @RequestMapping(value = "/admin/element/delete/{id}", method = RequestMethod.GET)
    public String elementTypeDelete(@PathVariable int id)
    {
        elementTypeService.deleteElementTypeName(id);
        return "redirect:/admin/element/list/";


    }

    @RequestMapping(value = "/admin/element/update",method = RequestMethod.POST)
    public String elementTypeUpdate(ElementType elementType, Model model, @RequestParam("inputNewElement") String newElement)
    {
        // if newElement (unbound text box) has a value, add it to the list
        if(!newElement.equals(""))
        {
            if(elementType.getElementList() == null)//allow updates after all elements have been removed from a list
            {
                List<Element> elementList = new ArrayList<Element>();
                elementList.add(new Element(newElement));
                elementType.setElementList(elementList);
            }
            else
            {
                elementType.getElementList().add(new Element(newElement));
            }
        }

        // itterate through the list of elements and remove the rows completely that have had a item removed
        for(int i = 0; i < elementType.getElementList().size();i++)
        {
            // check to see if element name is empty
            if(elementType.getElementList().get(i).getElementName().equals(""))
            {
                // element name is blank remove it from the list
                elementType.getElementList().remove(i);
            }
        }

        elementTypeService.saveElementTypeName(elementType);
        return"redirect:/admin/element/edit/" + elementType.getId();
    }
    //endregion

    //endregion
}
