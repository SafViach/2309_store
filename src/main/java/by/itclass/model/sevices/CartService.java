package by.itclass.model.sevices;

import by.itclass.model.entities.OrderItem;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import static by.itclass.constants.AppConst.*;

public class CartService {
    private static CartService service;

    private CartService(){}

    public static CartService getInstance(){
        return service == null ? new CartService() : service;
    }

    public List<OrderItem> processCart(HttpSession session , String cartAction , OrderItem item){
        var orderItems = session.getAttribute(ORDER_ITEMS_ATTR);
        List<OrderItem> items = orderItems != null ? (List<OrderItem>)orderItems : new ArrayList<>();
        switch (cartAction){
            case "add" -> items.add(item);
            case "remove" -> items.remove(item);
            //case "increase" -> items.forEach(it -> changePurchase(it , item , true));
//            case "decrease" -> items.forEach(it -> changePurchase(it , item , false));
            case "change" ->  items.forEach(it -> setPurchase(it , item));
//                switch (change){
//                    case "increase"-> item.setQuantity(item.getQuantity() + 1);
//                    case "decrease"-> item.setQuantity(item.getQuantity() - 1);
//                }
//            }
        }
        return items;
    }
//    private void changePurchase (OrderItem sourceItem , OrderItem changedItem , boolean isPlus){
//        if(sourceItem.equals(changedItem)){
//            var quantity = sourceItem.getQuantity();
//            sourceItem.setQuantity(isPlus ? quantity + 1 : quantity - 1);
//        }
//    }
private void setPurchase (OrderItem sourceItem , OrderItem changedItem ){
    if(sourceItem.equals(changedItem)){
        sourceItem.setQuantity(changedItem.getQuantity());
    }
}

}
