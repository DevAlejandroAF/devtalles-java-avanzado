package com.devtalles.proyecto;
import com.devtalles.proyecto.product.controller.ProductController;
import com.devtalles.proyecto.product.interfaces.ProductRepository;
import com.devtalles.proyecto.product.repository.ProductRepositoryServices;
import com.devtalles.proyecto.product.service.ProductService;
import com.devtalles.proyecto.product.view.ProductView;

public class Main {
    public static void main(String[] args) {

        ProductRepository repositoryServices = new ProductRepositoryServices();
        ProductService productService = new ProductService(repositoryServices);
        ProductController controller = new ProductController(productService);
        ProductView view = new ProductView(controller);
        view.showMenu();

    }
}