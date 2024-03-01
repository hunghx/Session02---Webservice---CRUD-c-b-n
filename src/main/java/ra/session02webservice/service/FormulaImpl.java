package ra.session02webservice.service;

class FormulaImpl implements Formula {
    // Chỉ cần thực hiện phương thức trừu tượng của Formula.
    @Override
    public double calculate(int a) {
        return a * a - a;
    }
}



