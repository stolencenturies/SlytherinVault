# SlytherinVault — Core Java Asset Management Engine

**SlytherinVault** is a foundational Java backend application designed to simulate secure digital vault operations. Built using core Object-Oriented Programming (OOP) principles, this project enforces strict data encapsulation, input validation, and state management.

---

## Key Features

* **Strict Encapsulation:** Account balances and owner credentials are protected using `private` access modifiers, preventing unauthorized external state mutation.
* **Transaction Validation:** Built-in guardrails reject negative deposits, overdraft attempts, and invalid monetary inputs before state changes occur.
* **Interactive CLI Execution:** Real-time user input processing via `java.util.Scanner` with formatted status reporting.
* **Zero External Dependencies:** Engineered purely with the standard Java Development Kit (JDK 21 LTS) for maximum portability and speed.

---

## Tech Stack

* **Language:** Java (JDK 21 LTS)
* **Architecture:** Object-Oriented Programming (OOP)
* **Version Control:** Git & GitHub
* **IDE:** Visual Studio Code / IntelliJ IDEA

---

## Project Structure

```text
SlytherinVault/
├── VaultSystem.java    # Core domain model, transaction logic, and CLI entry point
└── README.md           # Project documentation
```

---

## Getting Started

### Prerequisites
* Java Development Kit (**JDK 17 or higher**) installed and configured in your system `PATH`.
* Git installed locally.

### Installation & Execution

1. **Clone the repository:**
   ```bash
   git clone https://github.com/stolencenturies
   cd SlytherinVault
   ```

2. **Compile the source code:**
   ```bash
   javac VaultSystem.java
   ```

3. **Run the application:**
   ```bash
   java VaultSystem
   ```

---

## Engineering Roadmap

This repository serves as Phase 1 of an enterprise backend engineering track. Planned architectural upgrades include:

- [ ] **Interactive Loop & Menu System:** Continuous CLI session handling without program termination.
- [ ] **Security Layer:** PIN-based authentication and lockout thresholds for failed withdrawal attempts.
- [ ] **Transaction Ledger:** Audit log tracking timestamps and transaction types using `java.util.ArrayList`.
- [ ] **Data Persistence:** File I/O serialization to save and restore vault states across sessions.
- [ ] **Database & API Migration:** Refactoring core logic into a Spring Boot REST API backed by PostgreSQL.

---

## Author

Built with precision and ambition. Open to backend Java engineering collaborations and freelance contracts.
