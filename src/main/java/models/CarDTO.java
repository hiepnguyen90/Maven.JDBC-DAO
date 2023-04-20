package models;

public class CarDTO implements ICarDTO{
    Integer id;
    String make;
    String model;
    Integer year;
    String color;
    String vin;



    
    public CarDTO() {
    }





    @Override
    public String toString() {
        return "CarDTO [id=" + id + ", make=" + make + ", model=" + model + ", year=" + year + ", color=" + color
                + ", vin=" + vin + "]";
    }


    public CarDTO(Integer id, String make, String model, Integer year, String color, String vin) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.vin = vin;
    }




    public void setId(Integer id) {
        this.id = id;
    }




    public void setMake(String make) {
        this.make = make;
    }




    public void setModel(String model) {
        this.model = model;
    }




    public void setColor(String color) {
        this.color = color;
    }




    public void setYear(Integer year) {
        this.year = year;
    }




    public void setVin(String vin) {
        this.vin = vin;
    }




    public String getMake() {
        return make;
    }




    public String getModel() {
        return model;
    }




    public String getColor() {
        return color;
    }




    public Integer getYear() {
        return year;
    }




    public String getVin() {
        return vin;
    }




    @Override
    public int getId() {
        
    return id;
    }
    
}
