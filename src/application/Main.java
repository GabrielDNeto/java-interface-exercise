package application;

import model.entities.Contract;
import model.entities.Installment;
import model.service.ContractService;
import model.service.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmtDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre com os dados do contrato:");
        System.out.print("Número do contrato: ");
        int contractNumber = sc.nextInt();
        sc.nextLine();
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate contractDate = LocalDate.parse(sc.nextLine(), fmtDate);

        System.out.print("Valor do contrato: ");
        Double contractValue = sc.nextDouble();

        System.out.print("Entre com o número de parcelas: ");
        int installments = sc.nextInt();

        Contract contract = new Contract(contractNumber, contractDate, contractValue);

        ContractService contractService = new ContractService(new PaypalService());

        contractService.processContract(contract, installments);

        System.out.println("Parcelas:");
        for (Installment installment : contract.getInstallments()) {
            System.out.println(installment.toString());
        }


        sc.close();
    }
}