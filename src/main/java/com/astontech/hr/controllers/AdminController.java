package com.astontech.hr.controllers;

import com.astontech.hr.domain.*;
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

    private Integer vehicleId;
    private Integer modelId;
    private Integer makeId;


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

    //region Vehicle Add/List
    @RequestMapping(value = "/admin/vehicle/add", method = RequestMethod.GET)
    public String adminVehicleGet(Model model)
    {
        model.addAttribute("vehicleVO", new VehicleVO());//form model attribute is VehicleVO
        model.addAttribute("vehicleMakeList",vehicleMakeService.listAllVehicleMakes());
        model.addAttribute("vehicleModelList", vehicleModelService.listAllVehicleModels());
        //passes empty objeect and catches object on postback
        //model.addAttribute("warningAlert","visible");
        return "admin/vehicle/vehicle_add";
    }

    @RequestMapping(value = "/admin/vehicle/add", method = RequestMethod.POST)
    public String adminVehiclePost(VehicleVO vehicleVO, Model model)
    {
        saveVehicleVO(vehicleVO);//save element type and element type list to database

//        boolean success = true;
//        if(success)
//            model.addAttribute("successAlert","visible");
//        else
//            model.addAttribute("errorAlert","visible");
//
        model.addAttribute("vehicleVO", new VehicleVO());
        return "admin/vehicle/vehicle_add";
    }

    @RequestMapping(value = "/admin/vehicle/list", method = RequestMethod.GET)
    public String adminVehicleList(Model model)
    {
        model.addAttribute("vehicleMakeList", vehicleMakeService.listAllVehicleMakes());
        return "admin/vehicle/vehicle_list";
    }

    @RequestMapping(value = "/admin/vehicleMake/list", method = RequestMethod.GET)
    public String adminVehicleMakeList(Model model)
    {
        model.addAttribute("vehicleMakeList", vehicleMakeService.listAllVehicleMakes());
        return "admin/vehiclemake/vehicleMake_list";
    }

    @RequestMapping(value = "/admin/vehicleModel/list", method = RequestMethod.GET)
    public String adminVehicleModelList(Model model)
    {
        model.addAttribute("vehicleMakeList", vehicleMakeService.listAllVehicleMakes());
        return "admin/vehiclemodel/vehicleModel_list";
    }

    @RequestMapping(value = "/admin/vehicleMake/add", method = RequestMethod.POST)
    public String adminVehicleMakePost(VehicleVO vehicleVO, Model model)
    {
        vehicleVO.splitNewMakesIntoArray();

        saveVehicleMakeAndVehicleModelFromVO(vehicleVO);//save element type and element type list to database

        boolean success = true;
        if(success)
            model.addAttribute("successAlert","visible");
        else
            model.addAttribute("errorAlert","visible");

        model.addAttribute("elementVO", new ElementVO());
        return "admin/vehiclemake/vehicleMake_add";
    }

    private void saveVehicleMakeAndVehicleModelFromVO(VehicleVO vehicleVO)
    {
        List<VehicleModel> newVehicleModelList = new ArrayList<>();
        for(String str : vehicleVO.getNewVehicleMakeArray())
        {
            newVehicleModelList.add(new VehicleModel(str));
        }
        VehicleMake newVehicleMake = new VehicleMake(vehicleVO.getNewVehicleMake());
        newVehicleMake.setVehicleModelList(newVehicleModelList);

        vehicleMakeService.saveVehicleMake(newVehicleMake);
    }

    @RequestMapping(value = "/admin/vehicleMake/add", method = RequestMethod.GET)
    public String adminVehicleMakeGet(Model model)
    {
        model.addAttribute("vehicleVO", new VehicleVO());//form model attribute is VehicleVO
        //passes empty objeect and catches object on postback
        //model.addAttribute("warningAlert","visible");
        return "admin/vehiclemake/vehicleMake_add";
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

    //region VEHICLE
    private void saveVehicleVO(VehicleVO vehicleVO)
    {
        Vehicle newVehicle = new Vehicle(vehicleVO.getNewVehicleOwner(),vehicleVO.getNewVehicleYear(),vehicleVO.getNewVehicleVIN(),
                vehicleVO.getNewVehicleColor(),vehicleVO.getNewVehicleLicensePlate());

        vehicleService.saveVehicle(newVehicle);
    }

    @RequestMapping(value = "/admin/vehicle/edit/{makeId_modelId_vehicleId}", method = RequestMethod.GET)
    public String adminVehicleMakeUpdate(@PathVariable String makeId_modelId_vehicleId,Model model) {
        String [] ids = stringSpliter(makeId_modelId_vehicleId);
        makeId = Integer.parseInt(ids[0]);
        modelId = Integer.parseInt(ids[1]);
        vehicleId = Integer.parseInt(ids[2]);

        model.addAttribute("vehicleMakeList",vehicleMakeService.listAllVehicleMakes());
        model.addAttribute("vehicleVO", new VehicleVO());

        model.addAttribute("vehicleMakeEdit",vehicleMakeService.getVehicleMakeById(makeId));
        model.addAttribute("vehicleModelEdit",vehicleModelService.getVehicleModelById(modelId));
        model.addAttribute("vehicleEdit",vehicleService.getVehicleById(vehicleId));

        return "admin/vehicle/vehicle_edit";
    }

    @RequestMapping(value = "/admin/vehicle/edit", method = RequestMethod.POST)
    public String adminVehicleUpdatePost(VehicleVO vehicleVO){



        vehicleMakeService.updateVehicleMake(vehicleVO,makeId,modelId,vehicleId);

        return "redirect:list";
    }

    @RequestMapping(value = "/admin/vehicle/delete/{id}", method = RequestMethod.GET)
    public String vehicleDelete(@PathVariable int id)
    {
        vehicleService.deleteVehicle(id);
        return "redirect:/admin/vehicle/list/";
    }

    @RequestMapping(value = "/admin/vehicleMake/delete/{id}", method = RequestMethod.GET)
    public String vehicleMakeDelete(@PathVariable int id)
    {
        vehicleMakeService.deleteVehicleMake(id);
        return "redirect:/admin/vehicleMake/list/";
    }

    @RequestMapping(value = "/admin/vehicleModel/delete/{id}", method = RequestMethod.GET)
    public String vehicleModelDelete(@PathVariable int id)
    {
        vehicleModelService.deleteVehicleModel(id);
        return "redirect:/admin/vehicleModel/list/";
    }

    @RequestMapping(value = "/admin/vehicleMake/edit/{id}", method = RequestMethod.GET)
    public String vehicleMakeEdit(@PathVariable int id, Model model)
    {
        VehicleMake vehicleMake = vehicleMakeService.getVehicleMakeById(id);

        model.addAttribute("vehicleMake", vehicleMake);
        return "admin/vehiclemake/vehicleMake_edit";
    }

    @RequestMapping(value = "/admin/vehicleMake/update",method = RequestMethod.POST)
    public String vehicleMakeUpdate(VehicleMake vehicleMake, Model model, @RequestParam("inputNewModel") String newModel)
    {
        // if newModel (unbound text box) has a value, add it to the list
        if(!newModel.equals(""))
        {
            if(vehicleMake.getVehicleModelList() == null)//allow updates after all elements have been removed from a list
            {
                List<VehicleModel> vehicleModelList = new ArrayList<VehicleModel>();
                vehicleModelList.add(new VehicleModel(newModel));
                vehicleMake.setVehicleModelList(vehicleModelList);
            }
            else
            {
                vehicleMake.getVehicleModelList().add(new VehicleModel(newModel));
            }
        }

        // itterate through the list of elements and remove the rows completely that have had a item removed
        for(int i = 0; i < vehicleMake.getVehicleModelList().size();i++)
        {
            // check to see if element name is empty
            if(vehicleMake.getVehicleModelList().get(i).getVehicleModelName().equals(""))
            {
                // element name is blank remove it from the list
                vehicleMake.getVehicleModelList().remove(i);
            }
        }

        vehicleMakeService.saveVehicleMake(vehicleMake);
        return"redirect:/admin/vehicleMake/edit/" + vehicleMake.getId();
    }

    //endregion

    //endregion

    private String[] stringSpliter(String s){
        return s.split("_");
    }
}
