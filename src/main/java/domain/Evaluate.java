package domain;

public class Evaluate {
    private String orderId;
    private String orderEvaluate;

    public Evaluate() {
    }

    public Evaluate(String orderId, String orderEvaluate) {
        this.orderId = orderId;
        this.orderEvaluate = orderEvaluate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderEvaluate() {
        return orderEvaluate;
    }

    public void setOrderEvaluate(String orderEvaluate) {
        this.orderEvaluate = orderEvaluate;
    }

    @Override
    public String toString() {
        return "Evaluate{" +
                "orderId='" + orderId + '\'' +
                ", orderEvaluate='" + orderEvaluate + '\'' +
                '}';
    }
}
