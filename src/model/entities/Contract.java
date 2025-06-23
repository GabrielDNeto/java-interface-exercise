package model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {
    private Integer number;
    private LocalDate date;
    private Double totalPayment;
    private List<Installment> installments = new ArrayList<>();

    public Contract(Integer number, LocalDate date, Double totalPayment) {
        this.number = number;
        this.date = date;
        this.totalPayment = totalPayment;
    }

    public Integer getNumber() {
        return number;
    }

    public LocalDate getDate() {
        return date;
    }

    public Double getTotalPayment() {
        return totalPayment;
    }

    public List<Installment> getInstallments() {
        return installments;
    }
}
