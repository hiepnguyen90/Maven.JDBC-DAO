import daos.CarDAO;

public class App {
    public static void main(String[] args) {
        CarDAO carDao = new CarDAO();
        

        System.out.println(carDao.findAll());
    }
}
