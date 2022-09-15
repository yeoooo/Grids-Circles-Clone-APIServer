package com.example.gccoffee.Service;

import com.example.gccoffee.Repository.ProductRepository;
import com.example.gccoffee.model.Category;
import com.example.gccoffee.model.Product;
import com.example.gccoffee.model.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    public final ProductRepository productRepository;
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public Optional<Product> findByName(String productName) {
        return productRepository.findByProductName(productName);
    }

//    @Override
//    public Optional<UUID> findIdByName(String productName) {
//        return productRepository.findIdByName(productName);
//    }


    @Override
    @Transactional
    public Product save(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    @Transactional
    public Product cancel(Product product) {
        return null;
    }

    @Override
    @Transactional
    public Product update(Product target, String name, long price, int quantity, String description) {
        return productRepository.save(
                target.builder()
                .dto(ProductDTO.builder()
                                .id(target.getProductId())
                                .name(name)
                                .price(price)
                                .quantity(quantity)
                                .category(target.getCategory())
                                .description(description)
                                .build()
                ).build());
//        ProductDTO.builder()
//                .id(target.getProductId())
//                .name(name)
//                .price(price)
//                .quantity(quantity)
////                .category(target.getCategory())
//                .description(description)
//                .build()

    }

    @Override
    public Optional<Product> findById(UUID id) {
        Optional<Product> product =  productRepository.findById(id);
        if (product.isEmpty()) {
            throw new IllegalStateException("there's no such product");
        }else{
            return product;
        }
    }

    @Override
    @Transactional
    public String delete(UUID id) {
        Optional<Product> target = findById(id);
        productRepository.delete(target.get());
        return target.get().toString();

    }

    @Override
    public List<Product> findByCategory(Category category) {
        List<Product> found = productRepository.findByCategory(category);
//        if (found.size() == 0) {
//            throw new IllegalStateException("there is no product with the category");
//        } else {
            return found;
//        }
    }


}
