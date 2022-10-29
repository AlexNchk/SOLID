import java.util.Map;

public class Basket {
protected Purchase[] purchases;
    //Сюда перенесли логику добавления покупок в корзину из класса Purchase
    public Basket(Map<String, Integer> products) {
        this.purchases = new Purchase[products.size()];//вместо магического числа 4 используем конструктор
    }

    public void addPurchase(String title, int count) {
        for (int i = 0; i < purchases.length; i++) {
            if (purchases[i] == null) {
                purchases[i] = new Purchase(title, count);
                return;
            }
            if (purchases[i].title.equals(title)) {
                purchases[i].count += count;
                return;
            }
        }
    }

    public long sum(Map<String, Integer> prices) {
        long sum = 0;
        System.out.println("КОРЗИНА:");
        for (Purchase purchase : purchases) {//заменил счетчик for на foreach
            if (purchase == null) continue;
            System.out.println("\t" + purchase.title + " " + purchase.count + " шт. в сумме " + (purchase.count * prices.get(purchase.title)) + " руб.");
            sum += (long) purchase.count * prices.get(purchase.title);//добавил кастомизацию вычисления на long
        }
        return sum;
    }
}
