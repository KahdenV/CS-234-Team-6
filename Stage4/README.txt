Movie Theater System - Stage 4

==============================
📄 Overview
==============================
This Java-based movie theater system features a full GUI application for managing customers, staff, movies, showtimes, ticket purchases, and concessions.

It was developed in NetBeans using Swing and supports:
- Multiple GUI windows
- File-based data persistence (.txt files)
- Full CRUD operations
- Inheritance (e.g., User → Customer/Staff)
- A menu for navigation and a reports window

==============================
📁 File Structure
==============================
C:.
├── build/classes/         → Compiled .class files
│   └── [package folders]
├── data/                  → Persistent .txt files and posters
│   ├── customers.txt
│   ├── staff.txt
│   ├── movies.txt
│   ├── showtimes.txt
│   ├── purchases.txt
│   └── posters/
├── nbproject/             → NetBeans project configuration
├── src/                   → Source code
│   ├── io/
│   ├── model/
│   ├── netbeans_gui/
│   └── service/
├── test/                  → Test files
├── MovieTheaterSystem.jar → Executable JAR
├── README.txt             → This file

==============================
🛠 How to Compile and Run
==============================

► Using NetBeans (Recommended)
1. Open the project in NetBeans.
2. Clean and Build the project.
3. Run Main.java to launch the GUI.

► Using Command Line
1. Compile:
   javac -d build/classes src/**/*.java

2. Run:
   cd build/classes
   java netbeans_gui.Main

► Using the Executable JAR
   java -jar MovieTheaterSystem.jar

Ensure the `data/` folder with all `.txt` files is in the same directory as your `.jar` file or your working directory when running from command line.

