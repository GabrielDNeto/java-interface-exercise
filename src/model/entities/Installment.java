package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment {
    private LocalDate dueDate;
    private Double amount;

    DateTimeFormatter dateFmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Installment(LocalDate dueDate, Double amount) {
        this.dueDate = dueDate;
        this.amount = amount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return dueDate.format(dateFmt) + " - " + String.format("%.2f", amount);
    }
}
