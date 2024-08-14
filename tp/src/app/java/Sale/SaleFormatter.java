package Sale;

import product.Product;

public class SaleFormatter {

    public static String format(SaleTransaction sale) {
        String products = sale.getProducts().stream()
                .map(Product::toString)
                .reduce("", String::concat);

        PaymentDetails payment = sale.getPaymentDetails();

        return "DATE: " + sale.getDate() + " | " +
                "CLIENTE: " + sale.getCustomer().getName() + "-" + sale.getCustomer().getType().name() + "-" + sale.getCustomer().getState().name() + " | " +
                "\nPRODUTOS: \n" + products + " | " +
                "VALOR TOTAL: " + payment.getAmount() + "\n" +
                "Imposto: " + payment.getTax() + "\n" +
                "Desconto: " + payment.getDiscount() + "\n" +
                "Frete: " + payment.getShipping();
    }
}
