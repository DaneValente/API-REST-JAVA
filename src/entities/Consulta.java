package db;


import entities.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Consulta {

    private static Connection connection = null;
    private static Statement statement = null;

    public static void main(String[] args){
        // teste
        List<Product> product = GetByName("biscoito");
        System.out.println(product.toString());

    }

    public static Product GetById(int id){
        // função que retorna o objeto pelo id
        List<Product> list = new ArrayList<>();
        try {
            connection = DB.getConnection();
            statement = connection.createStatement();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM product WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet query = preparedStatement.executeQuery();

            while(query.next()){
                Product product= new Product();
                product.setId(id);
                product.setName(query.getString("name"));
                product.setQuantity(query.getInt("quantity"));
                product.setPrice(query.getDouble("price"));
                list.add(product);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return list.getFirst();
    }

    public static List<Product> GetByName (String name) {
        // função que retorna o objeto pelo nome
        List<Product> list = new ArrayList<>();
        try {
            connection = DB.getConnection();
            statement = connection.createStatement();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM product WHERE name=?");
            preparedStatement.setString(1, name);
            ResultSet query = preparedStatement.executeQuery();

            while (query.next()) {
                Product product = new Product();
                product.setId(query.getInt("id"));
                product.setName(name);
                product.setQuantity(query.getInt("quantity"));
                product.setPrice(query.getDouble("price"));
                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    


}
