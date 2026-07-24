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

## OUTPUT Screenshots
<img width="552" height="614" alt="admin Menu" src="https://github.com/user-attachments/assets/d789cf32-7fec-4eed-8274-fbaf993413ba" />
<img width="502" height="611" alt="president menu" src="https://github.com/user-attachments/assets/5749b204-c591-4652-9b2b-2e25e28c8f34" />
<img width="371" height="215" alt="Member Login" src="https://github.com/user-attachments/assets/6fb38636-9024-4784-88cd-f03d58f9561b" />
<img width="577" height="417" alt="add Member functionality" src="https://github.com/user-attachments/assets/dd8465ff-d73d-4ffe-8d7e-bcb2bea96919" />
<img width="409" height="235" alt="view societies" src="https://github.com/user-attachments/assets/64e5c039-ea25-4c74-8353-c11e52683ed6" />
<img width="469" height="508" alt="Vice President Menu" src="https://github.com/user-attachments/assets/d411e51c-032e-48d3-8429-d1226da920ae" />
<img width="376" height="557" alt="Lead Menu" src="https://github.com/user-attachments/assets/f1a9379a-8660-4566-b141-e6d57fa149d9" />
<img width="476" height="538" alt="Advisor Menu" src="https://github.com/user-attachments/assets/66824426-0e9d-491b-9e8a-01f76aa0620b" />
<img width="387" height="515" alt="General Member Menu" src="https://github.com/user-attachments/assets/28711388-e98d-4b41-924f-5b86261b9661" />





