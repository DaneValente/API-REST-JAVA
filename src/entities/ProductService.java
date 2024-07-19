package entities;

import exceptions.Exist;
import db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ItemService {
    private Connection conn;
    private PreparedStatement st;


    public Product CriarItem(Product product) throws SQLException, Exist {
        if (CriarItem(product).equals(true)) {
            throw new Exist("Item com este nome já existe: " + product.getName());
        }
        else {
            try {
                conn = DB.getConnection();
                st = conn.prepareStatement( "INSERT INTO product (Name, Quantity, Price) VALUES (?, ?, ?)");

                st.setString(1, product.getName());
                st.setDouble(2, product.getQuantity());
                st.setDouble(3, product.getPrice());

                st.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return product;
        }
    }


}
