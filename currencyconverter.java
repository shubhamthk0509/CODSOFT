import java.util.HashMap;
import java.util.Scanner;

// Mock API client to simulate fetching exchange rates
class ExchangeRateAPI {
    // Hardcoded exchange rates for demonstration
    private static final HashMap<String, Double> exchangeRates = new HashMap<>();

    static {
        // Example exchange rates (base: USD)
        exchangeRates.put("USD_TO_EUR", 0.92);
        exchangeRates.put("USD_TO_GBP", 0.77);
        exchangeRates.put("USD_TO_INR", 84.08);
        exchangeRates.put("EUR_TO_USD", 1.09);
        exchangeRates.put("GBP_TO_USD", 1.30);
        exchangeRates.put("INR_TO_USD", 0.012);
    }

    // Method to fetch exchange rate between two currencies
    public static double getExchangeRate(String baseCurrency, String targetCurrency) {
        String key = baseCurrency + "TO" + targetCurrency;
        if (exchangeRates.containsKey(key)) {
            return exchangeRates.get(key);
        } else {
            System.out.println("Exchange rate not available for the selected currencies.");
            return -1;
        }
    }
}

// Main class for the Currency Converter
public class CurrencyConverter {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // List of supported currencies
        String[] supportedCurrencies = {"USD", "EUR", "GBP", "INR"};
        
        // User input: Base currency
        System.out.println("Select base currency (USD, EUR, GBP, INR): ");
        String baseCurrency = scanner.next().toUpperCase();
        if (!isValidCurrency(baseCurrency, supportedCurrencies)) {
            System.out.println("Invalid base currency!");
            return;
        }

        // User input: Target currency
        System.out.println("Select target currency (USD, EUR, GBP, INR): ");
        String targetCurrency = scanner.next().toUpperCase();
        if (!isValidCurrency(targetCurrency, supportedCurrencies)) {
            System.out.println("Invalid target currency!");
            return;
        }

        // User input: Amount to convert
        System.out.print("Enter amount to convert: ");
        double amount = scanner.nextDouble();

        // Fetch the exchange rate using the API (simulated in this case)
        double exchangeRate = ExchangeRateAPI.getExchangeRate(baseCurrency, targetCurrency);
        
        // Check if valid exchange rate was found
        if (exchangeRate == -1) {
            return;
        }

        // Perform currency conversion
        double convertedAmount = amount * exchangeRate;

        // Display result
        System.out.printf("Converted Amount: %.2f %s\n", convertedAmount, targetCurrency);

        scanner.close();
    }

    // Helper method to validate if the currency is supported
    private static boolean isValidCurrency(String currency, String[] supportedCurrencies) {
        for (String supportedCurrency : supportedCurrencies) {
            if (supportedCurrency.equals(currency)) {
                return true;
            }
        }
        return false;
    }
}