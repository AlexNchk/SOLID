import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        HashMap<String, Integer> products = new HashMap<>();
        products.put("Хлеб", 56);
        products.put("Масло", 153);
        products.put("Колбаса", 211);
        products.put("Пирожок", 45);

        System.out.println("В МАГАЗИНЕ В НАЛИЧИИ");
        for (Map.Entry<String, Integer> productAndPrice : products.entrySet()) {
            System.out.println(productAndPrice.getKey() + " за " + productAndPrice.getValue() + " руб./шт.");
        }

        System.out.println("Введите два слова: название товара и количество. Или end");
        Scanner scanner = new Scanner(System.in);
        Basket purchase = new Basket(products);//добавлен конструктор вместо магического числа 4
        try {//добавлена обработка исключения
            while (true) {
                String line = scanner.nextLine();
                if ("end".equals(line)) break;
                String[] parts = line.split(" ");
                String product = parts[0];
                if (products.containsKey(product)) {//добавил проверку на корректный ввод названия товара
                    int count = Integer.parseInt(parts[1]);
                    purchase.addPurchase(product, count);
                } else {
                    System.out.println("Введите корректные данные, попробуйте еще раз");
                }
            }
        } catch (Exception e) {
            System.out.println("Вы ввели недопустистимые данные, программа завершена");
        }
        long sum = purchase.sum(products);
        System.out.println("ИТОГО: " + sum);
    }
}
