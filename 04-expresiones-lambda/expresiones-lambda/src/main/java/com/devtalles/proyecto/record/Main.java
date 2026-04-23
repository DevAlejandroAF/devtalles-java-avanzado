package com.devtalles.proyecto.record;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*Product product = new Product("TV", 200.3);
        product.getName();
        ProductDto productDto = new ProductDto("Notebook", 100.5);
        productDto.name();
        productDto.price();
        ProductDto.methodStatic();*/

        List<ProductDto> products = List.of(
                new ProductDto("Notebook", 1200.0),
                new ProductDto("Mouse", 25.5),
                new ProductDto("Keyboard", 55.0)
        );

//        List<String> discountedProducts = products.stream()
//                .map( productDto -> new ProductDto(productDto.name(), productDto.price()*0.9))
//                .map(productDto -> String.format("%s: $%.2f", productDto.name(), productDto.price()))
//                .toList();

        //System.out.println(discountedProducts);


        Map<String, List<ProductDto>> byPriceRange = products.stream()
                .collect(Collectors.groupingBy(
                        productDto -> productDto.price() > 50.0 ? "Caro" : "Barato"
                ));

        Map<String, Long> countByRange = products.stream()
                .collect(Collectors.groupingBy(
                        productDto -> productDto.price() > 50.0 ? "Caro" : "Barato",
                        Collectors.counting()
                ));


        //System.out.println(byPriceRange);
        //System.out.println(countByRange);

        // 2. Reducción matemática
        Double total = products.stream()
                .map(productDto -> productDto.price())
                .reduce(0.0, (sum, price)-> sum + price);

        System.out.println(total);

        String productSummary = products.stream()
                .map( p -> p.name() + "( $" + p.price() + " )")
                .reduce("", (s1, s2) -> {
                    if(s1.isEmpty()){
                        return s2;
                    }else{
                        return s1 + " | " + s2;
                    }
        });

        System.out.println(productSummary);

         //Conversión entre colecciones

        Set<Double> uniquePrices = products.stream()
                .map(ProductDto::price)
                .collect(Collectors.toSet());

        System.out.println(uniquePrices);


        Map<String, Double> productMap = products.stream()
                .collect(Collectors.toMap(
                        ProductDto::name,
                        ProductDto::price,
                        (oldVal, newVal) -> newVal
                ));

        System.out.println(productMap);

        List<ProductDto> expensiveProducts = productMap.entrySet().stream()
                .filter(e -> e.getValue() > 50.0)
                .map(e -> new ProductDto(e.getKey(), e.getValue()))
                .toList();

        System.out.println(expensiveProducts);




















    }
}
