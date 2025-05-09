Movie Theater System - Stage 4
==============================

📄 Overview
==============================
This Java-based movie theater system features a full GUI application for managing:
- 🎟️ Customers & Staff
- 🎥 Movies & Showtimes
- 🍿 Concessions
- 💳 Ticket Purchases
- 💾 File-based persistence

Built using Java Swing, following object-oriented design principles.

==============================
📁 File Structure
==============================
C:.
├── build/classes/              → Compiled .class files
├── data/                       → App data (auto-copied to dist/)
│   ├── customers.txt
│   ├── staff.txt
│   ├── movies.txt
│   ├── showtimes.txt
│   ├── purchases.txt
│   └── posters/
├── dist/                       → Final runnable JAR and required assets
│   ├── MovieMunchTheater.jar
│   ├── lib/
│   │   └── AbsoluteLayout.jar
│   └── data/
├── lib/                        → External libraries
│   └── absolutelayout/AbsoluteLayout.jar
├── nbproject/                  → NetBeans config
├── src/                        → Java source files
│   ├── io/
│   ├── model/
│   ├── netbeans_gui/
│   └── service/
├── test/                       → Unit tests (optional)
├── build.xml                   → Ant build file
├── manifest.mf                 → Custom manifest for JAR
├── run_movie_munch.bat         → One-click launcher (Windows)

==============================
🛠 How to Compile and Run
==============================

⚠️ Prerequisites:
- Java 21 or higher
- NetBeans IDE (recommended) or command-line tools

------------------------------
✅ Option 1: Run with NetBeans (Recommended)
------------------------------
1. Open the project in NetBeans.
2. Go to: Project Properties > Run
   - Set Main Class to: Main
3. Click Clean and Build.
4. Press Run to launch the GUI.

------------------------------
✅ Option 2: Run via Command Line
------------------------------
1. From the project root folder:

Compile:
javac -cp "dist/lib/AbsoluteLayout.jar" -d build\classes src\io\*.java src\model\*.java src\netbeans_gui\*.java src\service\*.java

Run:
cd "C:\Users\Kahden Vienna\Music\Git\CS-234-Team-6\Stage4\Movie Theater System"
java -cp "build\classes;dist/lib/AbsoluteLayout.jar" Main

⚠️ You must run this from the /Movie Theater System directory due to relative classpath dependencies.

------------------------------
✅ Option 3: Run Executable JAR
------------------------------
From inside the dist folder:

java -jar MovieMunchTheater.jar

Ensure these files exist in dist/:
- MovieMunchTheater.jar
- data/ (folder)
- lib/AbsoluteLayout.jar

------------------------------
✅ Option 4: Run via Batch File
------------------------------
Double-click:
run_movie_munch.bat

This will launch the JAR with the proper classpath and environment setup.

==============================
📝 Notes
==============================
- AbsoluteLayout.jar is required to render the GUI properly.
- Purchase records are written to data/purchases.txt on each transaction.
- All data is stored in plain text and persists between sessions.

==============================
✅ You're ready to run the system!
==============================
