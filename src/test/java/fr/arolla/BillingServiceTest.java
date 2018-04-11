package fr.arolla;

import fr.arolla.jour2.*;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 *
 */
public class BillingServiceTest {

    public static final String CARD_NUMBER = "443454432";
    private InvoiceNotifier notifier = Mockito.mock(InvoiceNotifier.class);
    private Travels travels = Mockito.mock(Travels.class);
    private Prices prices = Mockito.mock(Prices.class);
    private Discounts discounts = Mockito.mock(Discounts.class);
    private BillingService service;

    @Test
    public void should_sum() {
        // Given
        int billableCentsExpected = 6000;
        when(travels.all()).thenReturn(getJourneys());
        when(prices.getPrice(any(Journey.class))).thenReturn(Price.fromCents(100000));
        when(discounts.getDiscount(any(Customer.class))).thenReturn(Discount.fromPercentage(1));
        service = new BillingService(travels, notifier, discounts, prices);

        // When
        BillingService.DiscountedPrice billableAmount = service.getBillableAmount(CARD_NUMBER);

        // Then
        assertThat(billableAmount.getPrice().getCents()).isEqualTo(billableCentsExpected);
    }

    @Test
    public void should_sum_invalid_cardNumber() {
        // Given
        int billableCentsExpected = 0;
        Journey journey = getJourney("1");
        journey.setId("1");
        when(travels.all()).thenReturn(Collections.singleton(journey));
        when(prices.getPrice(any(Journey.class))).thenReturn(Price.fromCents(100000));
        when(discounts.getDiscount(any(Customer.class))).thenReturn(Discount.fromPercentage(1));
        service = new BillingService(travels, notifier, discounts, prices);

        // When
        BillingService.DiscountedPrice billableAmount = service.getBillableAmount(CARD_NUMBER);

        // Then
        assertThat(billableAmount.getPrice().getCents()).isEqualTo(billableCentsExpected);
    }

    @Test
    public void should_notifier_is_called() {
        // Given
        int called_1_time = 1;
        when(discounts.getDiscount(any(Customer.class))).thenReturn(Discount.fromPercentage(1));
        service = new BillingService(travels, notifier, discounts, prices);

        // When
        service.getBillableAmount(CARD_NUMBER);

        // Then
        verify(notifier, times(called_1_time)).notify(anyString(), any(BillingService.DiscountedPrice.class));
    }

    public Collection<Journey> getJourneys() {
        Set<Journey> journeys = new HashSet<>();
        for(int i=1; i<7; i++){
            journeys.add(getJourney(String.valueOf(i)));
        }
        return journeys;
    }

    private Journey getJourney(String i) {
        Journey journey = new Journey();
        journey.setId(CARD_NUMBER);
        journey.setType(i);
        return journey;
    }
}