package tableManagement;

import java.util.HashMap;
import java.util.Map;

public class TableList {

    private final HashMap<Integer, Table> list;
    public TableList(){
        this.list = new HashMap<>();
    }

    public void addTable(Table table){
        this.list.put(table.getTableId(), table);
    }

    public Table getTable(int id) {
        return list.get(id);
    }

    public void assignCustomerById(int tableId, String customerName) {
        for (Map.Entry<Integer, Table> table : this.list.entrySet()) {
            if (table.getKey() == tableId) {
                table.getValue().assignCustomer(customerName);
                return;
            }
        }
        System.out.println("Invalid table ID.");
    }

    public void assignCustomerBySize(int tableSize, String customerName) {
        Table selectedTable = null;
        int closestSizeDifference = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Table> table : this.list.entrySet()) {
            Table currentTable = table.getValue();
            if (currentTable.getStatus().equals("Available") && currentTable.getTableSize() >= tableSize) {
                int sizeDifference = currentTable.getTableSize() - tableSize;
                if (sizeDifference < closestSizeDifference) {
                    closestSizeDifference = sizeDifference;
                    selectedTable = currentTable;
                }
            }
        }

        if (selectedTable != null) {
            selectedTable.assignCustomer(customerName);
        } else {
            System.out.println("No available table with the specified size or larger.");
        }
    }

    public void freeTable(int tableId) {
        for (Map.Entry<Integer, Table> table : this.list.entrySet()) {
            if (table.getKey() == tableId) {
                table.getValue().freeTable();
                return;
            }
        }
        System.out.println("Invalid table ID.");
    }

    public void reserveTableById(int tableId, String customerName) {
        for (Map.Entry<Integer, Table> table : this.list.entrySet()) {
            if (table.getKey() == tableId) {
                table.getValue().reserveTable(customerName);
                return;
            }
        }
        System.out.println("Invalid table ID.");
    }

    public void reserveTableBySize(int tableSize, String customerName) {
        Table selectedTable = null;

        for (Map.Entry<Integer, Table> table : this.list.entrySet()) {
        Table currentTable = table.getValue();
            if (currentTable.getStatus().equals("Available") && currentTable.getTableSize() == tableSize) {
                selectedTable = currentTable;
                break;
            }
        }

        if (selectedTable != null) {
            selectedTable.reserveTable(customerName);
        } else {
            System.out.println("No available table with the specified size.");
        }
    }

    public void printTableStatus(Table table) {
        System.out.println("Table ID: " + table.getTableId());
        System.out.println("Table Size: " + table.getTableSize());
        System.out.println("Status: " + table.getStatus());
        if (table.getAssignedCustomer() != null) {
            System.out.println("Assigned Customer: " + table.getAssignedCustomer());
        }
        System.out.println();
    }

    public void printAllTableStatus(){
        for (Map.Entry<Integer, Table> table : this.list.entrySet())
            printTableStatus(table.getValue());
    }

    public String totalRevenue(){
        StringBuilder all = new StringBuilder();
        for (Map.Entry<Integer, Table> table : this.list.entrySet())
            all.append("\n   Table ").append(table.getValue().getTableId())
                    .append(": $").append(table.getValue().getTableRevenue());
        return "Table Sales Report:" + all ;
    }
}
