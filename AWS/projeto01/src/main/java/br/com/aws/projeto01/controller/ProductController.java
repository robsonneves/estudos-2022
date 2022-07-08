package br.com.aws.projeto01.controller;

import br.com.aws.projeto01.enums.EventType;
import br.com.aws.projeto01.model.Product;
import br.com.aws.projeto01.repository.ProductRepository;
import br.com.aws.projeto01.service.ProductPublisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductRepository productRepository;
    private ProductPublisher productPublisher;

    @Autowired
    public  ProductController(ProductRepository productRepository,
                              ProductPublisher productPublisher
    ){
        this.productRepository = productRepository;
        this.productPublisher = productPublisher;
    }

    @GetMapping
    public Iterable<Product> findAll(){

        return productRepository.findAll();
    }

    public ResponseEntity<Product> findById(@PathVariable long id){

        Optional<Product> optProduct = productRepository.findById(id);
        if(optProduct.isPresent()){
            return new ResponseEntity<Product>(optProduct.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) throws JsonProcessingException {

        Product productCreate = productRepository.save(product);

        productPublisher.publishProductEvent(productCreate, EventType.PRODUCT_CREATED, "matilde");
        return new ResponseEntity<Product>(productCreate, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id]")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable("id") long id) throws JsonProcessingException {

        if (productRepository.existsById(id)){

            Product productUpdate = productRepository.save(product);

            productPublisher.publishProductEvent(productUpdate, EventType.PRODUCT_UPDATE, "doralice");
            return new ResponseEntity<Product>(productUpdate, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") long id) throws JsonProcessingException {

        Optional<Product> optProduct = productRepository.findById(id);
        if (optProduct.isPresent()){

            Product product = optProduct.get();
            productRepository.delete(product);

            productPublisher.publishProductEvent(product, EventType.PRODUCT_DELETED, "hannah");
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/bycode")
    public ResponseEntity<Product> findByCode(@RequestParam String code){

        Optional<Product> optProduct = productRepository.findByCode(code);
        if (optProduct.isPresent()){

            return new ResponseEntity<Product>(optProduct.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
