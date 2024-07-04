import java.util.Scanner;
 class TemperatureConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the temperature value: ");
        double temperature = scanner.nextDouble();

        System.out.print("Enter the original unit of measurement (C, F, K): ");
        String originalUnit = scanner.next().toUpperCase();

        System.out.print("Enter the target unit of measurement (C, F, K): ");
        String targetUnit = scanner.next().toUpperCase();

        double convertedTemperature = convertTemperature(temperature, originalUnit, targetUnit);

        System.out.printf("%.2f %s is equal to %.2f %s%n", temperature, originalUnit, convertedTemperature, targetUnit);

        scanner.close();
    }

    public static double convertTemperature(double temp, String fromUnit, String toUnit) {
        double result = 0.0;

        if (fromUnit.equals("C") && toUnit.equals("F")) {
            result = celsiusToFahrenheit(temp);
        } else if (fromUnit.equals("C") && toUnit.equals("K")) {
            result = celsiusToKelvin(temp);
        } else if (fromUnit.equals("F") && toUnit.equals("C")) {
            result = fahrenheitToCelsius(temp);
        } else if (fromUnit.equals("F") && toUnit.equals("K")) {
            result = fahrenheitToKelvin(temp);
        } else if (fromUnit.equals("K") && toUnit.equals("C")) {
            result = kelvinToCelsius(temp);
        } else if (fromUnit.equals("K") && toUnit.equals("F")) {
            result = kelvinToFahrenheit(temp);
        } else if (fromUnit.equals(toUnit)) {
            result = temp; // If units are the same, no conversion needed
        } else {
            throw new IllegalArgumentException("Invalid conversion between temperature units");
        }

        return result;
    }

    public static double celsiusToFahrenheit(double celsius) {
        return celsius * 9 / 5 + 32;
    }

    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double fahrenheitToKelvin(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9 + 273.15;
    }

    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public static double kelvinToFahrenheit(double kelvin) {
        return kelvin * 9 / 5 - 459.67;
    }
}

