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

👤 Author
Jafet Morales
GitHub: @jafmoralesss
