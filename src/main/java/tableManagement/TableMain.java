package tableManagement;

import java.util.Scanner;

public class TableMain {
    public static void runTable(TableList tableList) {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println("""
                    Enter your choice:
                    1.) Assign customer to a table by ID
                    2.) Assign customer to a table by size
                    3.) Open a table
                    4.) Reserve a table by ID
                    5.) Reserve a table by size
                    6.) View table status
                    7.) Back
                    """);

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter the table ID: ");
                    int tableId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter the customer name: ");
                    String customerName = scanner.nextLine();

                    tableList.assignCustomerById(tableId, customerName);
                }
                case 2 -> {
                    System.out.print("Enter the table size: ");
                    int tableSize = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter the customer name: ");
                    String customerNameBySize = scanner.nextLine();
                    tableList.assignCustomerBySize(tableSize, customerNameBySize);
                }
                case 3 -> {
                    System.out.print("Enter the table ID to free: ");
                    int tableIdToFree = Integer.parseInt(scanner.nextLine());
                    tableList.freeTable(tableIdToFree);
                }
                case 4 -> {
                    System.out.print("Enter the table ID to reserve: ");
                    int tableIdToReserve = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter the customer name for reservation: ");
                    String reserveCustomerName = scanner.nextLine();
                    tableList.reserveTableById(tableIdToReserve, reserveCustomerName);
                }
                case 5 -> {
                    System.out.print("Enter the table size to reserve: ");
                    int tableSizeToReserve = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter the customer name for reservation: ");
                    String reserveCustomerNameBySize = scanner.nextLine();
                    tableList.reserveTableBySize(tableSizeToReserve, reserveCustomerNameBySize);
                }
                case 6 -> {
                    System.out.println("Table Status:");
                    tableList.printAllTableStatus();
                }
                case 7 -> {
                    System.out.println("Exiting");
                    loop = false;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }

//    private static void assignCustomerToTableById(int tableId, String customerName, Tablelist tableList) {
//        for (Map.Entry<Integer, Table> table : tableList.) {
//            if (table.getTableId() == tableId) {
//                table.assignCustomer(customerName);
//                return;
//            }
//        }
//        System.out.println("Invalid table ID.");
//    }

//    private static void assignCustomerToTableBySize(int tableSize, String customerName, Tablelist tableList) {
//        Table selectedTable = null;
//        int closestSizeDifference = Integer.MAX_VALUE;
//
//        for (Table table : tables) {
//            if (table.getStatus().equals("Available") && table.getTableSize() >= tableSize) {
//                int sizeDifference = table.getTableSize() - tableSize;
//                if (sizeDifference < closestSizeDifference) {
//                    closestSizeDifference = sizeDifference;
//                    selectedTable = table;
//                }
//            }
//        }

//        if (selectedTable != null) {
//            selectedTable.assignCustomer(customerName);
//        } else {
//            System.out.println("No available table with the specified size or larger.");
//        }
//    }

//    private static void freeTable(int tableId, Tablelist tableList) {
//        for (Table table : tables) {
//            if (table.getTableId() == tableId) {
//                table.freeTable();
//                return;
//            }
//        }
//        System.out.println("Invalid table ID.");
//    }

//    private static void reserveTableById(int tableId, String customerName) {
//        for (Table table : tables) {
//            if (table.getTableId() == tableId) {
//                table.reserveTable(customerName);
//                return;
//            }
//        }
//        System.out.println("Invalid table ID.");
//    }

//    private static void reserveTableBySize(int tableSize, String customerName, Tablelist tableList) {
//        Table selectedTable = null;
//
//        for (Table table : tables) {
//            if (table.getStatus().equals("Available") && table.getTableSize() == tableSize) {
//                selectedTable = table;
//                break;
//            }
//        }
//
//        if (selectedTable != null) {
//            selectedTable.reserveTable(customerName);
//        } else {
//            System.out.println("No available table with the specified size.");
//        }
//    }

//    private static void printTableStatus(Table table) {
//        System.out.println("Table ID: " + table.getTableId());
//        System.out.println("Table Size: " + table.getTableSize());
//        System.out.println("Status: " + table.getStatus());
//        if (table.getAssignedCustomer() != null) {
//            System.out.println("Assigned Customer: " + table.getAssignedCustomer());
//        }
//        System.out.println();
//    }
}
