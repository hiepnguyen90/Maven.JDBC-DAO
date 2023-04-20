import daos.CarDAO;
import models.CarDTO;

public class App {
    public static void main(String[] args) {
        CarDAO carDao = new CarDAO();
        CarDTO car = new CarDTO(1234, "Ferari", "Spider", 2023, "Yellow", "asdfg1231231");      

        carDao.update(car);

    
    }
}
