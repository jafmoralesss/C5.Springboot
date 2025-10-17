# C5.Springboot

# Online Store Order Management API

This project is a simple yet robust backend service for managing online store orders, developed as part of the **Challenge 5** backend bootcamp. It provides a RESTful API with full CRUD (Create, Read, Update, Delete) functionality for orders.

---

## 🚀 Features

- **Create Orders:** Add new orders to the system.
- **Read Orders:** Retrieve a full list of all orders or look up a single order by its unique ID.
- **Delete Orders:** Remove orders from the system.
- **In‑Memory Database:** Utilizes the H2 in-memory database for rapid development and testing.
- **Database Console:** Includes a web-based console to view the database and run SQL queries directly.

---

## 🛠️ Technologies & Tools

- **Java 17:** The core programming language.
- **Spring Boot 3:** The application framework.
- **Spring Data JPA:** For database interaction via ORM.
- **Maven:** Build and dependency management.
- **H2 Database:** In-memory relational database for development.
- **Postman:** Used for API testing and documentation.

---

## ✅ Prerequisites

Before you begin, ensure you have the following installed on your system:

- Java Development Kit (JDK) **17** or later
- Apache **Maven**

---

## ⚙️ Getting Started

Follow these instructions to get the project up and running on your local machine.

### 1) Clone the repository
```bash
git clone <your-repository-url.git>
```

### 2) Navigate to the project directory
```bash
cd online-store
```

### 3) (Optional) Make the startup script executable
> If your project includes a `start.sh` script (macOS/Linux):
```bash
chmod +x start.sh
```

### 4) Run the application

**Option A — Using the startup script**
```bash
./start.sh
```

**Option B — Using Maven (dev profile)**
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

**Option C — Build JAR and run (dev profile)**
```bash
mvn clean package
java -jar target/*.jar --spring.profiles.active=dev
```

Once the app starts, the API will be available at:
```
http://localhost:8080
```

---

## 📡 API Endpoints

Base URL for all endpoints: `/api/orders`

| Method | Endpoint            | Description                          | Request Body Example |
|:------:|---------------------|--------------------------------------|----------------------|
| POST   | `/api/orders`       | Creates a new order                  | `{ "productName": "Keyboard", "quantity": 2, "price": 99.99 }` |
| GET    | `/api/orders`       | Retrieves a list of all orders       | —                    |
| GET    | `/api/orders/{id}`  | Retrieves a single order by its ID   | —                    |
| DELETE | `/api/orders/{id}`  | Deletes an order by its ID           | —                    |

> Note: If your domain model uses multiple fields (e.g., items, unitPrice, etc.), adjust the example payload accordingly.

---

## 🧪 Testing (Postman)

This repository includes (or supports) a Postman collection for easy testing.

1. **Import the collection:** Locate `Online Store API.postman_collection.json` in the project root (or export it from your running API via Swagger if applicable).  
2. **Import into Postman:** Open Postman and use **Import** to load the collection.  
3. **Run requests:** You can now use the saved requests to test all API endpoints.

---

## 🗄️ H2 Database Console

You can directly interact with the in-memory database through the H2 web console.

1. Ensure the application is running.  
2. Open your browser and navigate to: `http://localhost:8080/h2-console`  
3. Use the following credentials to log in:

```
JDBC URL: jdbc:h2:mem:testdb     # or jdbc:h2:mem:ordersdb depending on your config
User Name: sa
Password: (leave blank)
```

You can now view the `ORDERS` table and run queries like:
```sql
SELECT * FROM ORDERS;
```

---

## ✅ Health Check

- Home: `GET /` should return a simple message when the server is up.
- Optional: `GET /ora` may be used as a lightweight endpoint to verify the app is responsive.

---

## 📝 Notes

- Ensure the **dev profile** enables H2 console and configures the in-memory datasource.
- If you switch to **PostgreSQL** in production, set the environment variables accordingly (e.g., `SPRING_DATASOURCE_URL`, `SPRING_DATASOURCE_USERNAME`, `SPRING_DATASOURCE_PASSWORD`).
---
## Evidences for Sprint 1
Use of Spring Initializr to ensure correct configuration.
<img width="3164" height="2060" alt="Image" src="https://github.com/user-attachments/assets/2f75a2d2-3192-4597-9ab3-6aeb4fb9bcda" />

GitHub repository creation
<img width="1826" height="630" alt="Image" src="https://github.com/user-attachments/assets/c39e40f5-00bb-4c6c-9902-0ac705ef6f0f" />

Repository cloning
<img width="3164" height="2060" alt="Image" src="https://github.com/user-attachments/assets/fb911bfe-f85e-4440-8458-62091d0881a0" />

Order of the project (Unzipped from the Spring Initialzr)
<img width="584" height="924" alt="Image" src="https://github.com/user-attachments/assets/ef2edd3a-92f9-424b-8c9e-31d27831277b" />

Running the app
<img width="1746" height="394" alt="Image" src="https://github.com/user-attachments/assets/54cdd240-6ddc-46a1-8fc0-31f8be5c92bf" />

POST test with Postman

<img width="2784" height="1820" alt="Image" src="https://github.com/user-attachments/assets/9db053bd-0506-4952-9943-8e418cd02859" />

GET test with Postman
<img width="2784" height="1820" alt="Image" src="https://github.com/user-attachments/assets/20a8d557-1986-4d8d-ac91-2a64c1a2444d" />

GET by ID test with Postman

<img width="2784" height="1820" alt="Image" src="https://github.com/user-attachments/assets/1c189555-87d6-4d72-b8aa-3647e40cb618" />

DELETE test with Postman
<img width="3164" height="2060" alt="Image" src="https://github.com/user-attachments/assets/37b1875f-1e68-4670-8c45-ec75082aae68" />

H2 console display
<img width="3164" height="2060" alt="Image" src="https://github.com/user-attachments/assets/d735bd11-302d-41cc-81b7-14d2fa19ca7d" />

Display of information in H2
---

👤 Author
Jafet Morales
GitHub: @jafmoralesss
