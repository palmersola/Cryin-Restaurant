package salesReport;

import orderProcessing.OrderService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

public class DailySalesReport {

    private double totalRevenue;
    private String filename = "src/main/java/salesReport/salesReport.txt";

    public void setTotalRevenue(double price) {
        this.totalRevenue += price;
    }

    public void generateReport(Restaurant res) {
        LocalDate today = LocalDate.now();

        System.out.println("Daily Sales Report - " + today);
        System.out.println("-------------------------------------");
        System.out.println("Total Revenue: $" + totalRevenue + "\n");

        System.out.println(res.getMenu().displayPopular());

        System.out.println(res.getTables().totalRevenue());

        System.out.println(res.getOrders().displayAll());
    }

    public void exportReport( Restaurant res) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            LocalDate today = LocalDate.now();

            writer.write("Daily Sales Report - " + today + "\n");
            writer.write("-------------------------------------\n");
            writer.write("Total Revenue: $" + totalRevenue + "\n\n");

            writer.write(res.getMenu().displayPopular());
            writer.newLine();
            writer.write(res.getTables().totalRevenue());
            writer.newLine();
            writer.write(res.getOrders().displayAll());

            System.out.println("Daily sales report exported to file: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void runReport(Restaurant res) {
        Scanner scanner = new Scanner(System.in);
        DailySalesReport report = res.getReport();
        boolean loop = true;

        while(loop) {
            System.out.println("""
                    Welcome Manager
                       1.) View Sales Report
                       2.) Export Sales Report
                       3.) Back
                    """);
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> report.generateReport(res);
                case 2 -> report.exportReport(res);
                case 3 -> loop = false;
            }
        }
    }
}
