package fr.arolla.jour2;

/**
 *
 */
public interface InvoiceNotifier {

    void notify(String cardNumber, BillingService.DiscountedPrice price);
}
