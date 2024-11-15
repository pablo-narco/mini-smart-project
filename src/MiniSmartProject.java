import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MiniSmartProject {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            showMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> calculator();
                case 2 -> currencyConverter();
                case 3 -> numberConverter();
                case 4 -> interviewQuestions();
                case 5 -> {
                    System.out.println("Dastur tugadi.");
                    return;
                }
                default -> System.out.println("Noto'g'ri tanlov. Qayta urinib ko'ring.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n==== Mini Smart Project ====");
        System.out.println("1 -> Calculator");
        System.out.println("2 -> Convertor Money");
        System.out.println("3 -> Convertor Number");
        System.out.println("4 -> Interview Questions Answer");
        System.out.println("5 -> Exit");
        System.out.print("Tanlovingiz: ");
    }

    private static void calculator() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== Kalkulyator ===");
        System.out.println("1 -> Qo'shish (+)");
        System.out.println("2 -> Ayirish (-)");
        System.out.println("3 -> Ko'paytirish (*)");
        System.out.println("4 -> Bo'lish (/)");
        System.out.println("5 -> Daraja (^)");
        System.out.print("Tanlovingiz: ");
        int choice = scanner.nextInt();

        System.out.print("Birinchi son: ");
        double num1 = scanner.nextDouble();
        System.out.print("Ikkinchi son: ");
        double num2 = scanner.nextDouble();

        switch (choice) {
            case 1 -> System.out.println("Natija: " + (num1 + num2));
            case 2 -> System.out.println("Natija: " + (num1 - num2));
            case 3 -> System.out.println("Natija: " + (num1 * num2));
            case 4 -> System.out.println("Natija: " + (num1 / num2));
            case 5 -> System.out.println("Natija: " + Math.pow(num1, num2));
            default -> System.out.println("Noto'g'ri amal.");
        }
    }

    private static void currencyConverter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== Valyuta Konvertori ===");
        System.out.println("1 -> USD -> UZS");
        System.out.println("2 -> EUR -> UZS");
        System.out.println("3 -> RUB -> UZS");
        System.out.println("4 -> UZS -> USD");
        System.out.print("Tanlovingiz: ");
        int choice = scanner.nextInt();

        System.out.print("Miqdorni kiriting: ");
        double amount = scanner.nextDouble();

        switch (choice) {
            case 1 -> System.out.println("Natija: " + (amount * 11300) + " UZS");
            case 2 -> System.out.println("Natija: " + (amount * 12500) + " UZS");
            case 3 -> System.out.println("Natija: " + (amount * 150) + " UZS");
            case 4 -> System.out.println("Natija: " + (amount / 11300) + " USD");
            default -> System.out.println("Noto'g'ri tanlov.");
        }
    }

    private static void numberConverter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== Sonlar Konvertori ===");
        System.out.print("Asosiy sanoq sistemasi (2/8/10/16): ");
        int fromBase = scanner.nextInt();
        System.out.print("Manzil sanoq sistemasi (2/8/10/16): ");
        int toBase = scanner.nextInt();
        scanner.nextLine(); // Enterni yutish
        System.out.print("Sonni kiriting: ");
        String number = scanner.nextLine();

        try {
            int decimalValue = Integer.parseInt(number, fromBase);
            String result = Integer.toString(decimalValue, toBase).toUpperCase();
            System.out.println("Natija: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Noto'g'ri son formati.");
        }
    }

    private static void interviewQuestions() {
        System.out.println("\n=== Intervyu Savollari ===");
        String fileName = "interview_questions.txt";
        String packageName = "com.example.interview";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("1. OOP nima?\nJavob: Obyektga yo'naltirilgan dasturlash paradigmasi.\n\n");
            writer.write("2. Java nima?\nJavob: Platformaga bog'liq bo'lmagan dasturlash tili.\n\n");
            writer.write("3. Polimorfizm nima?\nJavob: Bir xil metodni turli xil shakllarda bajarish qobiliyati.\n\n");
            writer.write("4. Inkapsulyatsiya nima?\nJavob: Ma'lumotlarni himoya qilish.\n\n");
            writer.write("5. Inheritance nima?\nJavob: Klasslar o'rtasida meros olish munosabati.\n\n");

            System.out.println("Savollar va javoblar " + fileName + " fayliga yozildi.");
            System.out.println("Javoblar package: " + packageName);
        } catch (IOException e) {
            System.out.println("Fayl yozishda xatolik: " + e.getMessage());
        }
    }
}
