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
├── build/classes/           → Compiled .class files
├── data/                    → Persistent .txt files and posters (auto-copied to dist/)
│   ├── customers.txt
│   ├── staff.txt
│   ├── movies.txt
│   ├── showtimes.txt
│   ├── purchases.txt
│   └── posters/
├── dist/                    → Final packaged JAR and copied data/
│   ├── MovieMunchTheater.jar
│   ├── lib/AbsoluteLayout.jar
│   └── data/
├── nbproject/               → NetBeans project configuration
├── src/                     → Source code
│   ├── io/
│   ├── model/
│   ├── netbeans_gui/
│   └── service/
├── test/                    → Test files
├── run_movie_munch.bat      → GUI launcher for JAR file
├── README.txt               → This file

==============================
🛠 How to Compile and Run
==============================

   ⚠️ Must have Java 21 or higher

► Using NetBeans (Recommended)
1. Open the project in NetBeans.
2. Go to **Project Properties > Run** and confirm the correct main class (e.g., `Main`).
3. Clean and Build the project.
   - This automatically packages `MovieMunchTheater.jar` and copies the `data/` folder to `dist/`.
4. Run the project from NetBeans or launch the JAR as described below.

► Using Command Line

From the project root:

1. Compile manually (requires AbsoluteLayout for NetBeans GUI):
   javac -cp "dist/lib/AbsoluteLayout.jar" -d build\classes src\io\*.java src\model\*.java src\netbeans_gui\*.java src\service\*.java

2. Run from project root:
   java -cp "build\classes;dist/lib/AbsoluteLayout.jar" Main

   ⚠️ Have To Run From /Movie Theater System.

► Using the Executable JAR

From `dist/`, run:
   java -jar MovieMunchTheater.jar

► Using Included `.bat` Files

- run_movie_munch.bat → Launches the JAR from GUI

Double-click either from the root folder. Ensure the `data/` directory is present.

==============================
✅ Notes
==============================
- All data is stored in relative paths (e.g., `data/customers.txt`) and must exist when the application runs.
- NetBeans automatically copies the `data/` folder after build thanks to a `-post-jar` task in `build.xml`.
- The system will fail silently on double-click if required files are missing — use `run_console.bat` to debug.
