package com.astontech.hr.domain.VO;


public class VehicleVO
{
    //region PROPERTIES
    private String newVehicleOwner;
    private int newVehicleYear;
    private String newVehicleVIN;
    private String newVehicleColor;
    private String newVehicleLicensePlate;
    private String newVehicleModels;
    private String newVehicleMake;
    private String newVehicleModelId;
    private String newVehicleMakeId;
    private String[] newVehicleMakeArray;

    //endregion

    //region CONSTRUCTORS
    public VehicleVO(){}
    //endregion

    //region GETTERS / SETTERS
    public String getNewVehicleOwner() {
        return newVehicleOwner;
    }

    public void setNewVehicleOwner(String newVehicleOwner) {
        this.newVehicleOwner = newVehicleOwner;
    }

    public int getNewVehicleYear() {
        return newVehicleYear;
    }

    public void setNewVehicleYear(int newVehicleYear) {
        this.newVehicleYear = newVehicleYear;
    }

    public String getNewVehicleVIN() {
        return newVehicleVIN;
    }

    public void setNewVehicleVIN(String newVehicleVIN) {
        this.newVehicleVIN = newVehicleVIN;
    }

    public String getNewVehicleColor() {
        return newVehicleColor;
    }

    public void setNewVehicleColor(String newVehicleColor) {
        this.newVehicleColor = newVehicleColor;
    }

    public String getNewVehicleLicensePlate() {
        return newVehicleLicensePlate;
    }

    public void setNewVehicleLicensePlate(String newVehicleLicensePlate) {
        this.newVehicleLicensePlate = newVehicleLicensePlate;
    }

    public String getNewVehicleModel() {
        return newVehicleModels;
    }

    public void setNewVehicleModel(String newVehicleModel) {
        this.newVehicleModels = newVehicleModel;
    }

    public String getNewVehicleMake() {
        return newVehicleMake;
    }

    public void setNewVehicleMake(String newVehicleMake) {
        this.newVehicleMake = newVehicleMake;
    }

    public String getNewVehicleModelId() {
        return newVehicleModelId;
    }

    public void setNewVehicleModelId(String newVehicleModelId) {
        this.newVehicleModelId = newVehicleModelId;
    }

    public String getNewVehicleMakeId() {
        return newVehicleMakeId;
    }

    public void setNewVehicleMakeId(String newVehicleMakeId) {
        this.newVehicleMakeId = newVehicleMakeId;
    }

    public String[] getNewVehicleMakeArray() {
        return newVehicleMakeArray;
    }

    public void setNewVehicleMakeArray(String[] newVehicleMakeArray) {
        this.newVehicleMakeArray = newVehicleMakeArray;
    }

    public void splitNewMakesIntoArray()
    {
        //regex for splitting on a new line or carriage return is "\\r?\\n"
        this.setNewVehicleMakeArray(this.getNewVehicleModel().split("\\r?\\n"));
    }
    //endregion


}
