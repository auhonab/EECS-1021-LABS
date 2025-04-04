# EECS 1021: Object-Oriented Programming – 2024-2025

Welcome to the GitHub repository for **EECS 1021** at **York University**. This course focuses on learning and applying object-oriented programming (OOP) principles using Java and integrating software with physical hardware systems such as Arduino.

## 📚 Course Information

- **Course Name**: EECS 1021: Object-Oriented Programming  
- **Academic Year**: 2024–2025  
- **Instructor**: [Dr. James Smith](https://lassonde.yorku.ca/users/drsmith)  
- **Institution**: [York University](https://www.yorku.ca)

## 🧪 Labs Overview

This repository includes all code, documentation, and materials for **Labs A through J**. Each lab builds upon programming concepts and real-world applications to help students develop a strong foundation in OOP and system integration.

### 🔍 Lab Index

- **Lab 0** – Introduction to Java and IDE Setup
- **Lab A** – Print and Scan
- **Lab B** – Make MIDI Music with Java  
- **Lab C** – The Util Library in Java (2 week lab)  
- **Lab D** – Conditionals and Loops a.k.a. The Guessing Game
- **Lab E** – Reading Text Documents a.k.a. Hydrometric & Air Quality CSV File-Reading  
- **Lab F** – Connecting your Grove/Arduino Hardware to Java
- **Lab G** – Using the Display on your Arduino-Compatible Board  
- **Lab H** – Asynchronous Events on your Arduino  
- **Lab I** – Matrix  
- **Lab J** – jMusic 2 - drum and piano 

## 🔌 Arduino Grove Board Setup for Labs F-H

### Set up your Arduino or Grove board
1. Download the [Arduino IDE](https://www.arduino.cc/en/Main/Software)
2. Connect the Grove board to your computer
3. Open the Arduino IDE
4. Go to `Tools > Board` and select `Arduino Uno`
5. Go to `File > Examples > Firmata > StandardFirmata`
6. Compile and upload the sketch to your device
7. Identify your Arduino port:
   - Go to `Tools > Port`
   - Note which ports are listed
   - Disconnect the USB cable from your board
   - Check `Tools > Port` again - the missing port is your Arduino
   - Reconnect the USB cable and verify the port reappears
   - This is the port you'll use in Java

### Create a Java Project in IntelliJ for Firmata
1. Create a new Java project with a main class
2. Add required libraries via Maven:

#### For Windows 10/11 & macOS Apple Silicon (M1/M2/M3):
```xml
<dependencies>
    <!-- JSSC -->
    <dependency>
        <groupId>io.github.java-native</groupId>
        <artifactId>jssc</artifactId>
        <version>2.9.4</version>
    </dependency>
    
    <!-- Firmata4J -->
    <dependency>
        <groupId>com.github.kurbatov</groupId>
        <artifactId>firmata4j</artifactId>
        <version>2.3.8</version>
    </dependency>
    
    <!-- SLF4J -->
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-jcl</artifactId>
        <version>1.7.3</version>
    </dependency>
</dependencies>
```

#### For Older macOS Intel (pre-2021):
```xml
<dependencies>
    <!-- Firmata4J -->
    <dependency>
        <groupId>com.github.kurbatov</groupId>
        <artifactId>firmata4j</artifactId>
        <version>2.3.8</version>
    </dependency>
    
    <!-- SLF4J -->
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-jcl</artifactId>
        <version>1.7.3</version>
    </dependency>
</dependencies>
```

#### Alternative: Manual JAR Import
Download [Firmata4J v2.3.9 JAR](https://www.yorku.ca/professor/drsmith/2025/02/24/version-2-3-9-of-firmata4j/) and add to your project libraries.

## 🛠️ Technologies Used

- **Programming Language**: Java  
- **Hardware**: Arduino (UNO or compatible), Grove Seed Board  
- **Development Tools**: IntelliJ IDEA, Arduino IDE  
- **Libraries/Frameworks**: Firmata4J, JSSC, SLF4J  

## 📁 Repository Structure

Each lab folder typically contains:
- Source Code (Java files)

## 👩‍💻 Created and Solutions By

**Auhona Basu**  
Computer Engineering | York University

## 📄 License

This repository is intended for **educational use only**. Please do not copy or redistribute the content without permission. All content belongs to the respective students and course instructors at York University.

---

Feel free to explore, learn, and build. Happy coding!
