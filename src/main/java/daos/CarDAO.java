package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.CarDTO;

public class CarDAO implements ICarDAO{

    @Override
    public CarDTO findById(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM car WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return extractCarFromResultSet(rs);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }
    

    private CarDTO extractCarFromResultSet(ResultSet rs) throws SQLException {
        CarDTO car = new CarDTO();

        car.setId( rs.getInt("id") );
        car.setMake( rs.getString("make"));
        car.setModel( rs.getString("model"));
        car.setColor( rs.getString("color"));
        car.setVin( rs.getString("vin"));
        car.setYear( rs.getInt("year") );

    
        return car;
    }


    @Override
    public List<CarDTO> findAll() {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM car");
            ResultSet rs = ps.executeQuery();

            List<CarDTO> arr = new ArrayList<>();

            while (rs.next()) {
                CarDTO carry = extractCarFromResultSet(rs);
                arr.add(carry);
            }
            return arr;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }
    

    @Override
    public CarDTO update(CarDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public CarDTO create(CarDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    
    
}
