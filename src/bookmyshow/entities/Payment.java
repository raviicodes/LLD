package bookmyshow.entities;

import bookmyshow.enums.PaymentStatus;

import java.time.LocalDate;
import java.util.UUID;

public class Payment {
     private UUID transactionId;
     private double amount;
     private PaymentStatus paymentStatus;
     private LocalDate paymentDate;

    public Payment(double amount, PaymentStatus paymentStatus, LocalDate paymentDate) {
         this.transactionId=UUID.randomUUID();
        this.amount = amount;
        this.paymentStatus = paymentStatus;
        this.paymentDate = paymentDate;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }
}
