
# My Sweet Shop – Java Inventory Management System

*My Sweet Shop* is a basic Java-based inventory management system for managing sweets in a shop. It allows you to **add**, **view**, **delete**, **search**, **sort**, **purchase**, and **restock** sweet items, all through a simple **Java Swing GUI** interface.


## Features

- ✅ Add new sweet items manually
- 📋 View all available sweets
- 🔍 Search sweets by name, category, or price range
- 📊 Sort sweets by name or price
- 🛒 Purchase sweets (decreases quantity)
- 📦 Restock sweets (increases quantity)
- ❌ Delete sweets by ID
- 💾 Data stored in-memory using Java collections

---

## 🧑‍💻 Technologies Used

- **Java 11+**
- **Swing** (Java GUI)
- **JUnit 5** (for testing)
- **Git** (for version control)

---

# Project Structure

```
My_sweet_shop/
├── src/
│   ├── model/
│   │   └── Sweet.java                # Data model
│   ├── service/
│   │   └── SweetShopInventory.java  # Business logic
│   └── UserInterface/
│       └── SweetShopUserInterface.java # Swing GUI
├── test/
│   └── my_sweet_shop/
│       └── SweetShopInventory_test.java # Unit tests (JUnit 5)
├── README.md
├── images/
│   ├── ui-screenshot.png
│   └── add-sweet-demo.png
```

---

#How to Run

1. Open the project in **Eclipse**
2. Right-click `SweetShopUserInterface.java` → **Run As > Java Application**
3. A GUI window will launch — start adding and managing sweets!

---

# How to Run Tests

1. Open `SweetShopInventory_test.java`
2. Right-click → **Run As > JUnit Test**
3. All business logic functions (add, purchase, restock, etc.) will be tested




#Git Version Control Commands

```bash
git init
git add .
git commit -m "🎯 Initial version of My Sweet Shop"
git remote add origin https://github.com/yourusername/my_sweet_shop.git
git push -u origin master
```



# Developed By

*Margi Vagh*  


