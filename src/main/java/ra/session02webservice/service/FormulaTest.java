package ra.session02webservice.service;

import java.time.LocalDate;

public class FormulaTest {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now(); // Lấy ngày hiện tại
        // Lấy ngày hiện tại trừ 1 ngày
        LocalDate yesterday = today.minusDays(1);
        // Lấy ngày hiện tại cộng 1 ngày
        LocalDate tomorrow = today.plusDays(1);
        System.out.println("Ngày hôm qua là : "+yesterday);
        System.out.println("Ngày hôm nay là : "+today);
        System.out.println("Ngày mai là : "+tomorrow);
    }
}





