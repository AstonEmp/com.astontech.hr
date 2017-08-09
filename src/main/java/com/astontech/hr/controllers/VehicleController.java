package com.astontech.hr.controllers;

import com.astontech.hr.domain.VO.ElementVO;
import com.astontech.hr.domain.VO.VehicleVO;
import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.domain.VehicleModel;
import com.astontech.hr.services.VehicleMakeService;
import com.astontech.hr.services.VehicleModelService;
import com.astontech.hr.services.VehicleService;
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
public class VehicleController
{

    //region PROPERTIES AND WIRES
    private Integer vehicleId;
    private Integer modelId;
    private Integer makeId;


    private final VehicleService vehicleService;


    private final VehicleMakeService vehicleMakeService;


    private final VehicleModelService vehicleModelService;

    @Autowired
    public VehicleController(VehicleService vehicleService, VehicleMakeService vehicleMakeService, VehicleModelService vehicleModelService)
    {
        this.vehicleService = vehicleService;
        this.vehicleMakeService = vehicleMakeService;
        this.vehicleModelService = vehicleModelService;
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
        return "admin/vehicle/vehicle_add";
    }

    @RequestMapping(value = "/admin/vehicle/add", method = RequestMethod.POST)
    public String adminVehiclePost(VehicleVO vehicleVO, Model model)
    {
        //LOGIC FOR SUCCESS JQUERY!!!!!!!!!!!!!!!!!!!///
        saveVehicleVO(vehicleVO);//save vehicle to list

        model.addAttribute("vehicleVO", new VehicleVO());
        return "redirect:/admin/vehicle/add";
    }

    @RequestMapping(value = "/admin/vehicle/list", method = RequestMethod.GET)
    public String adminVehicleList(Model model)
    {
        //list used to find the vehicle Makes and Models for each Vehicle
        model.addAttribute("vehicleMakeList", vehicleMakeService.listAllVehicleMakes());

        return "admin/vehicle/vehicle_list";
    }

    //endregion

    //region VEHICLE MAKE
    @RequestMapping(value = "/admin/vehicleMake/list", method = RequestMethod.GET)
    public String adminVehicleMakeList(Model model)
    {
        model.addAttribute("vehicleMakeList", vehicleMakeService.listAllVehicleMakes());
        //used to go through each make and list them dynamically
        return "admin/vehiclemake/vehicleMake_list";
    }

    @RequestMapping(value = "/admin/vehicleMake/add", method = RequestMethod.GET)
    public String adminVehicleMakeGet(Model model)
    {
        model.addAttribute("vehicleVO", new VehicleVO());//form model attribute is VehicleVO
        //passes empty objeect and catches object on postback

        return "admin/vehiclemake/vehicleMake_add";
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
    //endregion

    //region VEHICLE MODEL
    @RequestMapping(value = "/admin/vehicleModel/list", method = RequestMethod.GET)
    public String adminVehicleModelList(Model model)
    {
        model.addAttribute("vehicleMakeList", vehicleMakeService.listAllVehicleMakes());
        return "admin/vehiclemodel/vehicleModel_list";
    }

    //endregion

    //region HELPER METHODS
    private void saveVehicleVO(VehicleVO vehicleVO)
    {
        vehicleMakeService.iterateThroughMakeListCheckifExistsSave(vehicleVO);
    }

    @RequestMapping(value = "/admin/vehicle/edit/{makeId_modelId_vehicleId}", method = RequestMethod.GET)
    public String adminVehicleMakeUpdate(@PathVariable String makeId_modelId_vehicleId, Model model) {
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
    public String adminVehicleUpdatePost(VehicleVO vehicleVO, @RequestParam("selectMake") String selectMake, @RequestParam("selectModel") String selectModel){

        vehicleVO.setNewVehicleMake(selectMake);
        vehicleVO.setNewVehicleModel(selectModel);

        vehicleService.deleteVehicle(vehicleId);

        vehicleMakeService.iterateThroughMakeListCheckifExistsSave(vehicleVO);

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

    private String[] stringSpliter(String s){
        return s.split("_");
    }

    //endregion
}
