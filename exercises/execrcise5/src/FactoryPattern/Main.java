package FactoryPattern;

// Step1
interface PaymentProcessor {
    void processPayment(double amount);
}

// Step2
class CreditCardProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
        // Additional credit card processing logic
    }
}

class PayPalProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
        // Additional PayPal processing logic
    }
}

class BitcoinProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Bitcoin payment of $" + amount);
        // Additional Bitcoin processing logic
    }
}

// step 4
interface PaymentProcessorFactory {
    PaymentProcessor createPaymentProcessor();
}


class CreditCardFactory implements PaymentProcessorFactory {
    @Override
    public PaymentProcessor createPaymentProcessor() {
        return new CreditCardProcessor();
    }
}

class PayPalFactory implements PaymentProcessorFactory {
    @Override
    public PaymentProcessor createPaymentProcessor() {
        return new PayPalProcessor();
    }
}

class BitcoinFactory implements PaymentProcessorFactory {
    @Override
    public PaymentProcessor createPaymentProcessor() {
        return new BitcoinProcessor();
    }
}

public class Main {
    public static void main(String[] args) {
        // Create factories
        PaymentProcessorFactory creditCardFactory = new CreditCardFactory();
        PaymentProcessorFactory payPalFactory = new PayPalFactory();
        PaymentProcessorFactory bitcoinFactory = new BitcoinFactory();

        // Use factories to create payment processors
        PaymentProcessor creditCardProcessor = creditCardFactory.createPaymentProcessor();
        PaymentProcessor payPalProcessor = payPalFactory.createPaymentProcessor();
        PaymentProcessor bitcoinProcessor = bitcoinFactory.createPaymentProcessor();

        // Process payments
        creditCardProcessor.processPayment(100.0);
        payPalProcessor.processPayment(50.0);
        bitcoinProcessor.processPayment(75.0);
    }
}