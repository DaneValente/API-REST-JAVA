package Application;

import entities.ProductService;
import entities.Product;
import db.DB;

public class ProgramInsert {
    public static void main(String[] args) {

        ProductService productService = new ProductService();

        try {
            Product novoProduto = new Product("banana-maça", 1.0, 1);

            try {
                productService.NewProduct(novoProduto);
                System.out.println("Novo produto foi adicionado ao banco de dados.");
            } catch (Error e) {
                System.err.println("Erro: " + e.getMessage());
            }

        } catch (Error e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DB.closeConnection();
        }
    }
}
