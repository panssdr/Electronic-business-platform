package domain;

import java.math.BigDecimal;

public class HeyTea {
    private int id;
    private String name;
    private BigDecimal price;
    private String category;
    private int sales;
    private int stock;
    private String imgPath;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {

            this.imgPath = imgPath;

    }

    public HeyTea() {
    }

    @Override
    public String toString() {
        return "HeyTea{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", sales=" + sales +
                ", stock=" + stock +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }

    public HeyTea(int id, String name, BigDecimal price, String category, Integer sales, Integer stock, String imgPath) {
        this.id=id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.sales = sales;
        this.stock = stock;
        //要求给定的奶茶图片路径不能为空
        if(imgPath!=null&&"".equals(imgPath)){
            this.imgPath = imgPath;
        }
    }
}
