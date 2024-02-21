package finalpjt.domain;

import finalpjt.InventoryApplication;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Inventory_table")
@Data
//<<< DDD / Aggregate Root
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long stock;

    @PostPersist
    public void onPostPersist() {}

    public static InventoryRepository repository() {
        InventoryRepository inventoryRepository = InventoryApplication.applicationContext.getBean(
            InventoryRepository.class
        );
        return inventoryRepository;
    }

    //<<< Clean Arch / Port Method
    public static void increaseStock(OrderCanceled orderCanceled) {
        //implement business logic here:

        System.out.println(orderCanceled.getProductId());
        repository().findById(Long.valueOf(orderCanceled.getProductId())).ifPresent(inventory->{
            
            inventory.setStock(inventory.getStock() + orderCanceled.getQty()); // do something
            repository().save(inventory);


         });

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void decreaseStock(OrderPlaced orderPlaced) {
        //implement business logic here:
        System.out.println(orderPlaced.getProductId());
        repository().findById(Long.valueOf(orderPlaced.getProductId())).ifPresent(inventory->{
            
            inventory.setStock(inventory.getStock() - orderPlaced.getQty()); // do something
            repository().save(inventory);


         });

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
