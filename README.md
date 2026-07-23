# 🎓 University Society Management System

A **console-based University Society Management System** developed in **Java** using **Object-Oriented Programming (OOP)** principles. The system is designed to manage multiple university societies, their members, events, budgets, attendance, announcements, certificates, and advisors. It also supports **persistent data storage using file handling**.

## 📌 Project Overview

The University Society Management System allows an administrator to manage multiple societies within a university. Each society has its own members, advisor, events, announcements, budget, attendance records, and certificates.

The system follows a **role-based access control** approach where different users have different permissions based on their assigned roles.

## ✨ Features

### 👨‍💼 Admin
- Create new societies
- Delete societies
- Assign advisors to societies
- View all societies

### 👑 President
- Add members to the society
- Remove members
- Create events
- Remove events
- Create society budget
- Allocate budget to events
- Post announcements
- Issue certificates
- View society members

### 👥 Vice President
- Mark attendance
- Update attendance
- View attendance records

### 👨‍💻 Lead
- Remove participants from events
- View participant count

### 🎓 Member
- Login securely
- Register for events
- View announcements
- View personal certificates

### 👨‍🏫 Advisor
- Approve events
- Reject events
- Approve society budget

## 🏗️ Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Java Collections (ArrayList)
- File Handling (Serialization)
- Java Time API
- NetBeans IDE

## 📚 OOP Concepts Implemented

- Classes & Objects
- Encapsulation
- Inheritance
- Method Overloading
- Composition
- Aggregation
- Association
- Abstraction (Interfaces)
- Polymorphism
- Exception Handling
- File Serialization

## 📂 Project Structure

University Society Management System
│
├── Admin
├── Advisor
├── Announcement
├── Attendance
├── Authentication
├── Budget
├── Certificate
├── Event
├── FileHandler
├── Lead
├── Main
├── Member
├── Role
├── Society
├── User
└── UserInterface

## 🔐 User Roles

| Role | Permissions |
|------|-------------|
| Admin | Manage societies and advisors |
| President | Manage members, events, announcements, certificates and budgets |
| Vice President | Manage attendance |
| Lead | Manage event participants |
| Member | Register for events and view certificates |
| Advisor | Approve events and budgets |

## 💾 Data Storage

The project uses **Java Serialization** to store and retrieve data from files. This allows societies and their related information to persist even after the application is closed.

## ▶️ How to Run

1. Clone the repository
2. 
git clone https://github.com/alveenanaz-ctrl/University-Society-Management-System.git

2. Open the project in **NetBeans** or any Java IDE.

3. Compile and run the `Main` class.

## 📖 Learning Outcomes

This project demonstrates practical implementation of:

- Object-Oriented Design
- Multi-role Authentication
- File Handling using Serialization
- Collection Framework
- Real-world System Modeling
- Java Console Application Development


## 🚀 Future Improvements

- Java Swing GUI
- Database Integration (MySQL)
- Email Notifications
- Event Registration Reports
- Budget Analytics
- Search & Filter Functionality
- Password Encryption
- Unit Testing


## 👩‍💻 Author

**Alveena Naz**

BS Software Engineering

⭐ If you found this project helpful, consider giving it a star!
