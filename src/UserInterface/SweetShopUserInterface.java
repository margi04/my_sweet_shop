package UserInterface;
import model.Sweet;
import service.SweetShopInventory;

import javax.swing.*;

public class SweetShopUserInterface {
	// This class implements the GUI for the Sweet Shop using Java Swing
	
	    public static void main(String[] args) {
	        SweetShopInventory manager = new SweetShopInventory();

	        // Preload some sample sweets
	        manager.addSweet(new Sweet(1001, "Kaju Katli", "Nut-Based", 50.0, 20));
	        manager.addSweet(new Sweet(1002, "Gajar Halwa", "Vegetable-Based", 30.0, 15));
	        manager.addSweet(new Sweet(1003, "Gulab Jamun", "Milk-Based", 10.0, 50));

	        // Create JFrame
	        JFrame frame = new JFrame("My Sweet Shop");
	        frame.setSize(600, 500);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setLayout(null);

	        // Output area to display messages and sweet list
	        JTextArea output = new JTextArea();
	        output.setBounds(20, 300, 550, 150);
	        output.setEditable(false);

	        // Input fields for sweet properties
	        JTextField idField = new JTextField();
	        JTextField nameField = new JTextField();
	        JTextField categoryField = new JTextField();
	        JTextField priceField = new JTextField();
	        JTextField qtyField = new JTextField();

	        // Labels for input fields
	        JLabel[] labels = {
	            new JLabel("ID:"), new JLabel("Name:"), new JLabel("Category:"),
	            new JLabel("Price:"), new JLabel("Quantity:")
	        };
	        JTextField[] fields = { idField, nameField, categoryField, priceField, qtyField };

	        // Add labels and text fields to frame
	        for (int i = 0; i < labels.length; i++) {
	            labels[i].setBounds(20, 20 + i * 30, 100, 25);
	            fields[i].setBounds(120, 20 + i * 30, 150, 25);
	            frame.add(labels[i]);
	            frame.add(fields[i]);
	        }

	        // Button titles and setup
	        String[] btnTexts = {"Add", "View", "Delete", "Search", "Sort Name", "Sort Price", "Buy", "Restock"};
	        JButton[] buttons = new JButton[btnTexts.length];

	        for (int i = 0; i < btnTexts.length; i++) {
	            buttons[i] = new JButton(btnTexts[i]);
	            buttons[i].setBounds(300 + (i % 2) * 130, 20 + (i / 2) * 30, 120, 25);
	            frame.add(buttons[i]);
	        }

	        // Button: Add Sweet
	        buttons[0].addActionListener(e -> {
	            Sweet s = new Sweet(
	                Integer.parseInt(idField.getText()),
	                nameField.getText(),
	                categoryField.getText(),
	                Double.parseDouble(priceField.getText()),
	                Integer.parseInt(qtyField.getText())
	            );
	            output.setText(manager.addSweet(s) ? " Sweet added." : "Duplicate ID!");
	        });

	        // Button: View All Sweets
	        buttons[1].addActionListener(e -> {
	            StringBuilder sb = new StringBuilder(" All Sweets:");
	            for (Sweet s : manager.getAllSweets()) sb.append(format(s)).append("");
	            output.setText(sb.toString());
	        });

	        // Button: Delete Sweet
	        buttons[2].addActionListener(e -> {
	            int id = Integer.parseInt(idField.getText());
	            output.setText(manager.deleteSweet(id) ? " Deleted." : " Not Found.");
	        });

	        // Button: Search Sweet
	        buttons[3].addActionListener(e -> {
	            String name = nameField.getText();
	            String category = categoryField.getText();
	            double min = priceField.getText().isEmpty() ? 0 : Double.parseDouble(priceField.getText());
	            double max = 1000;

	            StringBuilder sb = new StringBuilder("Search Results:");
	            if (!name.isEmpty())
	                manager.searchByName(name).forEach(s -> sb.append(format(s)).append(""));
	            else if (!category.isEmpty())
	                manager.searchByCategory(category).forEach(s -> sb.append(format(s)).append(""));
	            else
	                manager.searchByPriceRange(min, max).forEach(s -> sb.append(format(s)).append(""));

	            output.setText(sb.toString());
	        });

	        // Button: Sort by Name
	        buttons[4].addActionListener(e -> {
	            StringBuilder sb = new StringBuilder("Sorted by Name:");
	            manager.sortByName().forEach(s -> sb.append(format(s)).append(""));
	            output.setText(sb.toString());
	        });

	        // Button: Sort by Price
	        buttons[5].addActionListener(e -> {
	            StringBuilder sb = new StringBuilder("💰 Sorted by Price:");
	            manager.sortByPrice().forEach(s -> sb.append(format(s)).append(""));
	            output.setText(sb.toString());
	        });

	        // Button: Purchase Sweet
	        buttons[6].addActionListener(e -> {
	            int id = Integer.parseInt(idField.getText());
	            int qty = Integer.parseInt(qtyField.getText());
	            output.setText(manager.purchaseSweet(id, qty) ? " Purchased." : "Not enough stock or invalid ID.");
	        });

	        // Button: Restock Sweet
	        buttons[7].addActionListener(e -> {
	            int id = Integer.parseInt(idField.getText());
	            int qty = Integer.parseInt(qtyField.getText());
	            output.setText(manager.restockSweet(id, qty) ? "Restocked." : "Invalid ID.");
	        });

	        // Add output area and show frame
	        frame.add(output);
	        frame.setVisible(true);
	    }

	    // Helper method to format sweet details
	    private static String format(Sweet s) {
	        return s.getId() + " | " + s.getName() + " | " + s.getCategory() + " | ₹" + s.getPrice() + " | Qty: " + s.getQuantity()+ "\n";
	        
	    }
	}

