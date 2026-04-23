package com.devtalles.proyecto.product.service;

import com.devtalles.proyecto.product.exception.InvalidProductDataException;
import com.devtalles.proyecto.product.exception.ProductNotFoundException;
import com.devtalles.proyecto.product.interfaces.ProductRepository;
import com.devtalles.proyecto.product.model.Product;
import com.devtalles.proyecto.product.model.ProductCategory;
import com.devtalles.proyecto.product.utils.Validates;

import java.util.List;
import java.util.Optional;

public class ProductService {
//    Es una buena práctica de diseño orientado a interfaces, porque:
//
//    Favorece el principio de inversión de dependencias (D del SOLID).
//
//    Facilita la inyección de dependencias, ya sea manual o con frameworks como Spring.
//
//    Permite cambiar la implementación sin tocar la lógica del servicio
//    (ej., cambiar de una lista en memoria a una base de datos real).
//
//    Mejora el testeo unitario, ya que podés usar mocks o stubs fácilmente.
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() throws InvalidProductDataException {
        return productRepository.findAll();
    }

    public List<Product> getAllProductsByCategory(ProductCategory category){
        return productRepository.findByCategory(category);
    }

    public Optional<Product> getProductById(Long id){
        return productRepository.findById(id);
    }

//    ✔ Responsabilidad del servicio:
//La capa de servicio se encarga de la lógica de negocio, y validar los datos antes de persistirlos o procesarlos es parte de esa lógica.
//
//❌ El repositorio:
//Su única responsabilidad es acceder a los datos (leer, guardar, eliminar), no validar.
// Meter validaciones ahí rompe el principio de responsabilidad única (SRP).
//    🧩 ¿Validar en la vista o en el servicio?
//            ✅ Se pueden hacer validaciones en la vista, pero no deben reemplazar las validaciones del servicio.
//            🎯 ¿Por qué?
//            💻 Vista (consola, GUI, web):
//    Valida solo para mejorar la experiencia del usuario.
//
//    Ejemplo: no dejar que el usuario ingrese un precio negativo, pedir que complete todos los campos, etc.
//
//    Evita errores evidentes antes de mandar datos a la capa de lógica.
//
//    Pero puede fallar o ser evitada (por error humano, scripts, manipulación externa, etc.).
//
//            ⚙ Servicio:
//    Valida por seguridad y consistencia del dominio.
//
//    Las reglas de negocio deben cumplirse siempre, venga el dato de donde venga.
//
//    Si se salta la vista (por un test, un API, etc.), las validaciones aún se ejecutan.

    public void saveProduct(Product product) throws InvalidProductDataException, ProductNotFoundException {
        ProductValidator.validate(product);
        if(!productRepository.existsById(product.getId())) {
            productRepository.save(product);
            System.out.println("El producto con ID: " + product.getId() + " ha sido agregado.");
        }else {
            throw new ProductNotFoundException("El producto con el ID: " + product.getId() + " que desea ya existe.");
        }
    }

    public void deleteProduct(Long id) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()) {
            productRepository.delete(id);
            System.out.println("El producto con ID: " + id + " ha sido eliminado.");
        }else {
            throw new ProductNotFoundException("El producto con el ID: " + id + " que desea eliminar no existe.");
        }
    }

    public void updateProduct(Product product) throws ProductNotFoundException, InvalidProductDataException {
        Optional<Product> optionalProduct = productRepository.findById(product.getId());
        if(optionalProduct.isPresent()) {
            productRepository.update(optionalProduct);
            System.out.println("El producto con ID: " + product.getId() + " ha sido actualizado.");
        }else {
            throw new ProductNotFoundException("El producto con el ID: " + product.getId() + "que desea eliminar no existe.");
        }
    }
}
