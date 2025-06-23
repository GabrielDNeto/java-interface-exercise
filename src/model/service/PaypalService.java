package model.service;

import model.service.interfaces.OnlinePaymentService;

public class PaypalService implements OnlinePaymentService {
    public Double paymentFee(double amount) {
        return amount * 0.02;
    }

    public Double interest(double amount, int months) {
        return amount * 0.01 * months;
    }
}
