# 🚀 API Automation Testing with Rest Assured

This project contains automated API tests using **Java**, **Rest Assured**, and **TestNG**.  
The sample API used in this project is [`Reqres.in`](https://reqres.in), a free public API for testing.

---

## 📦 Tech Stack

| Component | Description |
|------------|-------------|
| **Java 17+** | Main programming language |
| **Maven** | Build and dependency management |
| **Rest Assured** | API automation framework |
| **TestNG** | Test runner and assertions |
| **Jackson** | JSON serialization/deserialization |



---

## 🧩 Setup Instructions

1. **Clone this repository**
   ```bash
   git clone git@github.com:edyribowo/reqres-api-automation.git
   cd reqres-api-automation
   ```

2. **Install dependencies**
   ```bash
   mvn clean install
   ```

3. **Run tests**
   ```bash
   mvn clean test
   ```


---

## 🌐 Environment Configuration

Base URL and other configs are stored in `config.properties`:
```
reqresBaseURL=https://reqres.in/api
```

To access configuration in code:
```java
String baseUrl = ConfigReader.get("reqresBaseURL");
```




---

## 🧰 Common Endpoints Tested

| Method | Endpoint      | Description   |
|--------|---------------|---------------|
| `GET` | `/users/id`   | Get users     |
| `POST` | `/register`   | Register user |
| `DELETE` | `/users/{id}` | Delete user   |

---

## ⚠️ Notes

- Public APIs like Reqres may return **mocked** responses.
- Some endpoints (like `/register`) may change behavior over time.

---

## 👤 Author

**Edy Ribowo**  
📧 [eribowo9@gmail.com]  
💼 [LinkedIn Profile](https://www.linkedin.com/in/edy-ribowo-72a757117/?originalSubdomain=id)  
🧑‍💻  *Automation Engineer*
