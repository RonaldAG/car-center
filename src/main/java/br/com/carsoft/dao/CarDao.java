package br.com.carsoft.dao;

import br.com.carsoft.connection.ConnectionFactory;
import br.com.carsoft.model.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDao {

    private Connection connection;

    public CarDao(){
            this.connection = ConnectionFactory.getConnection();
    }
    public void createCar(Car car){
        String SQL = "INSERT INTO CAR (NAME) VALUES (?)";


        try(PreparedStatement statement = connection.prepareStatement(SQL)){
            statement.setString(1, car.getName());
            statement.execute();
            System.out.println("success in connection");
        }
        catch (Exception e){
            System.out.println("fail in connection");
        }
    }

    public List<Car> findAll(){
        String SQL = "SELECT * FROM CAR";

        try (PreparedStatement statement = connection.prepareStatement(SQL)){
            statement.execute();
            List<Car> cars = new ArrayList<>();

            ResultSet resultSet = statement.getResultSet();

            while(resultSet.next()){
                Car car = new Car(resultSet.getString(2), resultSet.getString(1));
                cars.add(car);
            }

            return cars;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteById(String carId){
        String SQL = "DELETE CAR WHERE ID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)){
            preparedStatement.setString(1, carId);

            preparedStatement.execute();

            System.out.println("Success on delete car with id: " + carId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
