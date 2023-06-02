package com.JpaRepository;


import com.Bean.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Repository
public interface InventoryJpaRepo extends JpaRepository <Product, Integer>{

    public default int StockAvailable(List<Product> plist){
        int balance = 0;
        balance = plist.stream().map(p -> p.getQuantity()*p.getUnitPrice()).mapToInt(Integer::intValue).sum();
       /*for(Product p : plist){
           balance =balance+ (p.getQuantity()*p.getUnitPrice());
       }*/
       return balance;
    }

    public default List<Product> FetchByCategory(List<Product> plist,String Category){
        List<Product> qlist = new ArrayList<>();
        qlist = plist.stream().filter(p->p.getCategory().equalsIgnoreCase(Category)).collect(Collectors.toList());
        /*for(Product p : plist){
            if(p.getCategory().equalsIgnoreCase(Category)){
                qlist.add(p);
            }
        }*/
        return qlist;
    }

}
