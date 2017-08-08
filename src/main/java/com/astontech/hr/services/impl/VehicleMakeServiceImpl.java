package com.astontech.hr.services.impl;

import com.astontech.hr.domain.VO.VehicleVO;
import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.domain.VehicleModel;
import com.astontech.hr.repositories.VehicleMakeRepository;
import com.astontech.hr.repositories.VehicleModelRepository;
import com.astontech.hr.services.VehicleMakeService;
import com.astontech.hr.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleMakeServiceImpl implements VehicleMakeService
{

    @Autowired
    private VehicleMakeRepository vehicleMakeRepository;

    @Autowired
    private VehicleModelRepository vehicleModelRepository;

    @Autowired
    private VehicleService vehicleService;

    @Override
    public Iterable<VehicleMake> listAllVehicleMakes() {
        return vehicleMakeRepository.findAll();
    }

    @Override
    public VehicleMake getVehicleMakeById(Integer id) {
        return vehicleMakeRepository.findOne(id);
    }

    @Override
    public VehicleMake saveVehicleMake(VehicleMake vehicleMake) {
        return vehicleMakeRepository.save(vehicleMake);
    }

    @Override
    public Iterable<VehicleMake> saveVehicleMakeList(Iterable<VehicleMake> vehicleMakeIterable) {
        return vehicleMakeRepository.save(vehicleMakeIterable);
    }

    @Override
    public void deleteVehicleMake(Integer id) {
        vehicleMakeRepository.delete(id);
    }

    @Override
    public VehicleMake findByVehicleMakeName(String vehicleMakeName) {
        return vehicleMakeRepository.findByVehicleMakeName(vehicleMakeName);
    }

    @Override
    public List<VehicleMake> findAllByVehicleMakeName(String vehicleMakeName) {
        return vehicleMakeRepository.findAllByVehicleMakeName(vehicleMakeName);
    }

    @Override
    public List<VehicleMake> findAllByVehicleMakeNameIgnoreCase(String vehicleMakeName) {
        return vehicleMakeRepository.findAllByVehicleMakeNameIgnoreCase(vehicleMakeName);
    }

    @Override
    public Integer countByVehicleMakeName(String vehicleMakeName) {
        return vehicleMakeRepository.countByVehicleMakeName(vehicleMakeName);
    }

    @Override
    public VehicleMake iterateThroughMakeListCheckifExistsSave(VehicleVO vehicleVO){
        VehicleMake newVehicleMake = makeANewVehicle(vehicleVO);
        Iterable<VehicleMake> compareMakeList = vehicleMakeRepository.findAll();

        for (VehicleMake vMake : compareMakeList ) {
            if (vMake.getVehicleMakeName().equalsIgnoreCase(vehicleVO.getNewVehicleMake())){

                VehicleMake matchingMake = vehicleMakeRepository.findOne(vMake.getId());

                for(VehicleModel vModel : matchingMake.getVehicleModelList() ){
                    if (vModel.getVehicleModelName().equalsIgnoreCase(vehicleVO.getNewVehicleModel())){

                        vModel.getVehicleList().add(newVehicleMake.getVehicleModelList().get(0).getVehicleList().get(0));
                        return vehicleMakeRepository.save(matchingMake);
                    }
                }

                matchingMake.getVehicleModelList().add(new VehicleModel(vehicleVO.getNewVehicleModel(),
                        newVehicleMake.getVehicleModelList().get(0).getVehicleList()));

                return vehicleMakeRepository.save(matchingMake);

            }
        }

        return vehicleMakeRepository.save(newVehicleMake);
    }

    @Override
    public VehicleMake updateVehicleMake(VehicleVO vehicleVO, Integer makeId, Integer modelId, Integer vehicleId){
        VehicleMake updateThisVehicle = vehicleMakeRepository.findOne(makeId);
        VehicleModel orginalModel = vehicleModelRepository.findOne(modelId);
        Vehicle orginalVehicle = vehicleService.getVehicleById(vehicleId);

        VehicleModel updatedModel =  updateThisVehicle.getVehicleModelList().get(updateThisVehicle.getVehicleModelList().indexOf(orginalModel));
        Vehicle updatedVehicle =  updatedModel.getVehicleList().get(updatedModel.getVehicleList().indexOf(orginalVehicle));

        if(!orginalModel.getVehicleModelName().equalsIgnoreCase(vehicleVO.getNewVehicleModel())
                ||!updateThisVehicle.getVehicleMakeName().equalsIgnoreCase(vehicleVO.getNewVehicleMake())){

            updateThisVehicle.getVehicleModelList().get(updateThisVehicle.getVehicleModelList().indexOf(orginalModel))
                    .getVehicleList().remove(orginalVehicle);//remove original vehicle

            vehicleMakeRepository.save(updateThisVehicle);//save removal
            return iterateThroughMakeListCheckifExistsSave(vehicleVO);//create new vehicle make or mdoel
        }else {

            updatedVehicle.setVIN(vehicleVO.getNewVehicleVIN());//set vin
            updatedVehicle.setLicensePlate(vehicleVO.getNewVehicleLicensePlate());//set plate
            updatedVehicle.setYear(vehicleVO.getNewVehicleYear());//set year
            return vehicleMakeRepository.save(updateThisVehicle);
        }
    }

    //region Helper Methods

    //takes VehicleVo from user input and makes a new Vehicle Make
    private VehicleMake makeANewVehicle(VehicleVO vehicleVO){

        List<Vehicle> newVehicleList = new ArrayList<>();
        Vehicle newVehicle = new Vehicle();
        newVehicle.setLicensePlate(vehicleVO.getNewVehicleLicensePlate());
        newVehicle.setVIN(vehicleVO.getNewVehicleVIN());
        newVehicle.setYear(vehicleVO.getNewVehicleYear());
        newVehicleList.add(newVehicle);


        List<VehicleModel> newVehicleModelList = new ArrayList<>();
        VehicleModel newVehicleModel = new VehicleModel();
        newVehicleModel.setVehicleModelName(vehicleVO.getNewVehicleModel());
        newVehicleModel.setVehicleList(newVehicleList);
        newVehicleModelList.add(newVehicleModel);


        VehicleMake newVehicleMake = new VehicleMake();
        newVehicleMake.setVehicleMakeName(vehicleVO.getNewVehicleMake());
        newVehicleMake.setVehicleModelList(newVehicleModelList);


        return newVehicleMake;
    }
}
