package by.itclass.model.entities;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
public class OrderItem {
    private String orderId;
    @NonNull private int itemType; //какая таблица laptop или Tv
    @NonNull private int itemId; // id конкретного товара
    @NonNull private String itemVendor; //
    @NonNull private String itemModel;
    @NonNull private double itemPrice;
    @Setter
    @NonNull private int quantity; //колличесво

}
