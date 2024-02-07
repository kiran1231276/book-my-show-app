public class Method6 {
    public static void main(String[] args) {

        Method6 m = new Method6();

        Product p = new Product();
        p.productId = 101;
        p.productName = "Sugar";
        p.productPrice = 35.0;

        m.productData(p);
    }
    void productData(Product p){
        System.out.println(p.productId+" "+p.productName+" "+p.productPrice);
    }
}

class Product{
    int productId;
    String productName;
    double productPrice;
}