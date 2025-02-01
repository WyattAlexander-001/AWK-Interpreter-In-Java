# AWK-Like Interpreter in Java

This project is a simple AWK interpreter written in Java. It tokenizes, parses, and interprets AWK scripts.

## **Requirements**
- Java Development Kit (JDK 8 or later)
- A terminal or command prompt
- Your Java source files should be inside a `src/` directory, with test scripts (`.txt` files) in the parent `root` folder.

## **How to Compile and Run**

### **1. Navigate to the Project Folder**
Open a terminal and go to the project directory:

```sh
cd /path/to/project-folder-root
```

### **2. Compile the Java Files**
To compile the main application (ignoring JUnit test files):

```sh
javac -encoding UTF-8 -cp src src/*.java
```

### **3. Run the Program**

Run the interpreter with an AWK-like script file:

```sh
java -cp src Main file.txt
```

You can also run other test scripts:

```sh
java -cp src Main for-each-loop.txt
java -cp src Main math-and-logic.txt
java -cp src Main conditional-block.txt
```

## **File Structure**
```
project-folder/
│── src/                   # Java source files
│   ├── Main.java
│   ├── Lexer.java
│   ├── Parser.java
│   ├── Interpreter.java
│── file.txt                # Example script
│── for-each-loop.txt       # Example script
│── math-and-logic.txt      # Example script
│── conditional-block.txt   # Example script
│── README.md               # This file
```

### **4. Running the GUI Version**
A simple graphical user interface (GUI) is available for selecting and running AWK files. To use the GUI:

#### **1. Compile the GUI**
```sh
javac -encoding UTF-8 -cp src src/SimpleGUI.java
```

#### **2. Run the GUI**
```sh
java -cp src SimpleGUI
```



