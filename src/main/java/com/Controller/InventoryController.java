package com.Controller;

import com.Bean.Product;
import com.JpaRepository.InventoryJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class InventoryController {


    @Autowired
    InventoryJpaRepo repo;


    @GetMapping("/Products")
    public List<Product> getallproducts()
    {

        return  repo.findAll();
    }

    @PostMapping("/Products")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        Product addedProduct = repo.save(product);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{ProductId}").buildAndExpand(addedProduct.getProductId()).toUri();
        return  ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/Product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id){
        Product product = repo.findById(id).get();
        repo.delete(product);
        if(product!=null)
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.notFound().build();
    }

    @GetMapping("/Product/{id}")
    public Product FindProduct(@PathVariable int id){
        return repo.findById(id).get();
    }

    @PutMapping("Product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product){
        repo.save(product);
        return new ResponseEntity<Product>(product,HttpStatus.OK);
    }
    @GetMapping("/StockValue")
    public int StockAvailable()
    {
        List<Product> plist = new ArrayList<>();
        plist = repo.findAll();
        return   repo.StockAvailable(plist);
    }
    @GetMapping("/CategoryStockValue")
    public int CategoryStockValue(@PathVariable String category)
    {
        List<Product> plist = FindByCategory(category);
        System.out.println("price->"+repo.StockAvailable(plist));
        return   repo.StockAvailable(plist);
    }
    @GetMapping("/Products/{category}")
    public List<Product> FindByCategory(@PathVariable String category)
    {
        System.out.println("fetched category->" + category);
        List<Product> plist;
        plist = repo.findAll();
        List<Product> qlist = repo.FetchByCategory(plist,category);
        return qlist;
    }



}
