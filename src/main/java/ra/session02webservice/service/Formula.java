package ra.session02webservice.service;

public interface Formula {
    // Khai báo một phương thức trừu tượng.
    double calculate(int a);

    // Khai báo một phương thức không trừu tượng.
    // Sử dụng từ khóa default.
    // Hàm tính căn bậc 2 của một số.
    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}


