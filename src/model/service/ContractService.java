package model.service;

import model.entities.Contract;
import model.entities.Installment;
import model.service.interfaces.OnlinePaymentService;

import java.time.LocalDate;

public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, int months) {
        double valuePerMonth = contract.getTotalPayment() / months;
        for (int i = 1; i <= months; i++) {
            LocalDate date = contract.getDate().plusMonths(i);
            double interest = onlinePaymentService.interest(valuePerMonth, i);

            double fee = onlinePaymentService.paymentFee(valuePerMonth + interest);

            double quota = valuePerMonth + interest + fee;
            contract.getInstallments().add(new Installment(date, quota));
        }
    }
}
