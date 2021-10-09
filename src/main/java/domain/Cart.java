package domain;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {

//    private Integer totalCount;
//    private BigDecimal totalPrice;
    private Map<Integer, CartItem> items=new LinkedHashMap<Integer, CartItem>();
    //添加商品项
    public void addItem(CartItem cartItem){
        CartItem item = items.get(cartItem);
        if(item==null){
            items.put(cartItem.getId(),cartItem);
        }else {
            int all=item.getCount()+1;
            item.setCount(all);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
             items.replace(cartItem.getId(),cartItem);
        }
    }

    //删除商品项目
    public void deleteItem(int id){
        items.remove(id);
    }
    //清空购物车
    public void clear(){
     items.clear();
    }
    //更新商品数量
    public void updateCount(int id,int count){

        CartItem item = items.get(id);
        if(item!=null){
            item.setCount(count);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }

    }

    public int getTotalCount() {
        int totalCount=0;
        for(Map.Entry<Integer, CartItem>entry:items.entrySet()){
            totalCount+=entry.getValue().getCount();

        }
        return totalCount;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice=new BigDecimal(0);
        for(Map.Entry<Integer, CartItem>entry:items.entrySet()){
            totalPrice=totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }


    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }




    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }
}
