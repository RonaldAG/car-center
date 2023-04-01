package br.com.carsoft.dao;

import br.com.carsoft.model.Car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CarDao {

    public void createCar(Car car){
        String SQL = "INSERT INTO CAR (NAME) VALUES (?)";


        try{
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setString(1, car.getName());
            statement.execute();
            System.out.println("success in connection");
            statement.close();
        }
        catch (Exception e){
            System.out.println("fail in connection");
        }
    }
}
