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
        car.setYear( rs.getInt("year"));
        car.setColor( rs.getString("color"));
        car.setVin( rs.getString("vin"));
        

    
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
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE car SET id=?, make=?, model=?, year=?, color=?, vin=?");
            ps.setInt(1, dto.getId());
            ps.setString(2, dto.getMake());
            ps.setString(3, dto.getModel());
            ps.setInt(4, dto.getYear());
            ps.setString(5, dto.getColor());
            ps.setString(6, dto.getVin());
          
            
            ps.executeUpdate();
    
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
        return dto;
    }

    @Override
    public CarDTO create(CarDTO dto) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO car VALUES (?, ?, ?, ?, ?, ?)");
            ps.setInt(1, dto.getId());
            ps.setString(2, dto.getMake());
            ps.setString(3, dto.getModel());
            ps.setInt(4, dto.getYear());
            ps.setString(5, dto.getColor());
            ps.setString(6, dto.getVin());
            ps.executeUpdate();
    
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
        return dto;
    }


    @Override
    public void delete(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT * FROM car WHERE id=?");
            ps.executeUpdate("DELETE FROM car WHERE id=" + id);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
    
}
