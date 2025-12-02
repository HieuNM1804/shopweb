

## Giới thiệu về website

WebShop là hệ thống thương mại điện tử cho phép người dùng mua sắm trực tuyến với trải nghiệm hiện đại, bảo mật và tiện lợi. Website hỗ trợ đầy đủ các chức năng cho khách hàng và quản trị viên, bao gồm:

- Đăng ký, đăng nhập, xác thực và quản lý tài khoản cá nhân.
- Phân quyền người dùng: Hệ thống phân biệt rõ vai trò khách hàng (user) và quản trị viên (admin). Quản trị viên có quyền quản lý sản phẩm, danh mục, đơn hàng, khách hàng, phân quyền tài khoản, thống kê doanh thu, v.v.
- Duyệt, tìm kiếm, lọc, sắp xếp sản phẩm: Người dùng có thể tìm kiếm sản phẩm theo tên, lọc theo danh mục, sắp xếp theo giá, ngày tạo, số lượng, v.v. Hỗ trợ tìm kiếm không dấu, phân trang và trải nghiệm mượt mà.
- Xem chi tiết sản phẩm, thêm vào giỏ hàng, cập nhật/xóa sản phẩm trong giỏ.
- Đặt hàng, nhập địa chỉ giao hàng, chọn phương thức thanh toán (giả lập VNPay).
- Quản lý đơn hàng: Xem lịch sử, chi tiết, trạng thái đơn hàng.
- Quản lý sản phẩm yêu thích: Thêm/xóa sản phẩm yêu thích, xem danh sách yêu thích.
- Quản trị viên có thể thêm, sửa, xóa sản phẩm, danh mục, khách hàng, xác nhận đơn hàng, cập nhật trạng thái, xem thống kê sản phẩm bán chạy, doanh thu, số lượng đơn hàng.
- Tích hợp upload ảnh sản phẩm lên Cloudinary, giao diện responsive, hỗ trợ nhiều trình duyệt.


## Các framework, thư viện đã sử dụng

- **Spring Boot**: Framework backend chính, quản lý dependency, cấu hình tự động.
- **Spring Data JPA**: Quản lý truy vấn, ánh xạ dữ liệu entity-database.
- **Spring Security**: Xác thực, phân quyền, bảo mật ứng dụng.
- **Thymeleaf**: Template engine render giao diện động phía server.
- **Lombok**: Tự động sinh getter/setter, constructor, giảm boilerplate code.
- **Jakarta Persistence (JPA)**: Annotation cho entity, ánh xạ ORM.
- **Cloudinary SDK**: Upload ảnh sản phẩm lên cloud.
- **Jackson**: Xử lý JSON cho REST API.
- **Bootstrap, jQuery**: Giao diện frontend, responsive, hiệu ứng động.
- **Maven**: Quản lý dự án, dependency, build.
- **Docker**: Đóng gói, triển khai ứng dụng.
- **MySQL**: Hệ quản trị cơ sở dữ liệu quan hệ.

---

# BÁO CÁO OOP VÀ QUAN HỆ ENTITY TRONG DỰ ÁN

## 1. Đóng gói (Encapsulation)
**Vị trí:** Thư mục entity

- Tất cả các entity đều khai báo thuộc tính với phạm vi truy cập private.
- Việc truy cập và thay đổi giá trị các thuộc tính này đều phải thông qua các phương thức công khai (getter/setter).
- Điều này giúp bảo vệ dữ liệu nội bộ, không cho phép truy cập trực tiếp từ bên ngoài, đảm bảo tính toàn vẹn và an toàn của dữ liệu.

**Ví dụ:**
- private String brand; (trong Watch.java)
- private Integer id; (trong Product.java)
- ... (tất cả các thuộc tính đều là private)

---

## 2. Kế thừa (Inheritance)
**Vị trí:** Thư mục entity

**Lớp cha:** Product
- id: Integer
- name: String
- image: String
- public_id: String
- price: Double
- quantity: Integer
- createDate: Date
- available: Boolean
- category: Category
- orderDetails: List<OrderDetail>

**Các lớp con kế thừa Product và mở rộng thuộc tính:**
- Watch: brand, strapMaterial
- Hat: color, style
- Camera: resolution, sensorType
- Jewelry: material, gemstone
- Laptop: cpu, ram
- Perfume: fragrance, brand
- Phone: os, screenSize
- TravelBag: size, material

---

## 3. Đa hình (Polymorphism)
**Vị trí:** Thư mục entity, service, strategy

Dự án áp dụng tính đa hình mạnh mẽ ở cả tầng dữ liệu (Entity) và tầng nghiệp vụ (Service) thông qua cơ chế ghi đè phương thức (Overriding) và mẫu thiết kế Strategy Pattern.

### a. Đa hình trong Entity (Runtime Polymorphism)
Các lớp con của `Product` ghi đè các phương thức của lớp cha để thể hiện hành vi riêng biệt cho từng loại sản phẩm.

- **Lớp cha `Product`:** Định nghĩa các phương thức mặc định:
    - `calculateShippingFee()`: Mặc định 30.000 VNĐ.
    - `getWarrantyPeriod()`: Mặc định 12 tháng.
    - `getProductType()`: Mặc định "Product".
- **Các lớp con (`Laptop`, `Watch`, ...):** Ghi đè để thay đổi logic:
    - `Laptop`: Phí ship 100.000 VNĐ (do nặng + bảo hiểm), bảo hành 24 tháng.
    - `Watch`: Phí ship 15.000 VNĐ, bảo hành 36 tháng.
    - `getName()`: Tự động nối thêm hậu tố loại sản phẩm (ví dụ: "Rolex (Watch)").

**Lợi ích:** Khi tính toán giỏ hàng, hệ thống chỉ cần gọi `product.calculateShippingFee()` mà không cần kiểm tra `if (product instanceof Laptop)`.

### b. Đa hình trong Thanh toán (Strategy Pattern)
Sử dụng **Strategy Pattern** để quản lý các phương thức thanh toán, giúp dễ dàng mở rộng thêm cổng thanh toán mới (Momo, ZaloPay) mà không sửa code cũ.

- **Interface `PaymentStrategy`:** Định nghĩa chuẩn chung `pay()`.
- **Các chiến lược cụ thể:**
    - `VNPayStrategy`: Xử lý logic gọi API VNPay, tạo URL thanh toán.
    - `CODStrategy`: Xử lý thanh toán khi nhận hàng (đơn giản là chuyển hướng).
- **`PaymentServiceContext`:** Quản lý và lựa chọn chiến lược thanh toán phù hợp tại runtime dựa trên lựa chọn của người dùng.

### c. Đa hình trong Khuyến mãi (Strategy Pattern)
- **Interface `DiscountStrategy`:** Định nghĩa chuẩn tính giảm giá `calculateDiscount()`.
- **Các chiến lược cụ thể:**
    - `PercentageDiscountStrategy`: Tính giảm giá theo phần trăm.
- **`DiscountService`:** Tự động tìm và áp dụng mức giảm giá tốt nhất cho khách hàng từ danh sách các chiến lược hiện có.

---

## 4. Trừu tượng (Abstraction)
**Vị trí:** Thư mục dao

- Các interface DAO định nghĩa thao tác dữ liệu, không chứa logic cụ thể:
   - ProductDAO
   - OrderDAO
   - OrderDetailDAO
   - CategoryDAO
   - CustomerDAO
   - FavoriteDAO
   - RoleDAO
   - AuthorityDAO
   - CartItemDAO
- Các interface này kế thừa từ JpaRepository, chỉ định các phương thức thao tác dữ liệu, còn chi tiết thực thi do Spring Data JPA đảm nhiệm.
- Điều này giúp ẩn chi tiết cài đặt, chỉ tập trung vào các chức năng cần thiết, tăng khả năng mở rộng và bảo trì.

---

## 5. Mô tả quan hệ giữa các entity trong database
**Vị trí:** Thư mục entity

### 1. Product – Category
- **Quan hệ:** Nhiều sản phẩm (Product) thuộc về một danh mục (Category).
- **Thể hiện:**
   - Trong Product:
      - @ManyToOne
         Category category;
   - Trong Category:
      - @OneToMany(mappedBy = "category")
         List<Product> products;

### 2. Product – OrderDetail
- **Quan hệ:** Một sản phẩm (Product) có thể xuất hiện trong nhiều chi tiết đơn hàng (OrderDetail).
- **Thể hiện:**
   - Trong Product:
      - @OneToMany(mappedBy = "product")
         List<OrderDetail> orderDetails;
   - Trong OrderDetail:
      - @ManyToOne
         Product product;

### 3. Order – OrderDetail
- **Quan hệ:** Một đơn hàng (Order) có nhiều chi tiết đơn hàng (OrderDetail).
- **Thể hiện:**
   - Trong Order:
      - @OneToMany(mappedBy = "order")
         List<OrderDetail> orderDetails;
   - Trong OrderDetail:
      - @ManyToOne
         Order order;

### 4. Order – Customers
- **Quan hệ:** Một đơn hàng (Order) thuộc về một khách hàng (Customers).
- **Thể hiện:**
   - Trong Order:
      - @ManyToOne
         Customers customer;

### 5. Customers – Favorite – Product
- **Quan hệ:**
   - Một khách hàng (Customers) có thể yêu thích nhiều sản phẩm (Product) và ngược lại (nhiều-nhiều), thông qua bảng trung gian Favorite.
- **Thể hiện:**
   - Trong Favorite:
      - @Id customerId, @Id productId
      - @ManyToOne
         Customers customer;
      - @ManyToOne
         Product product;

### 6. Customers – CartItem – Product
- **Quan hệ:**
   - Một khách hàng (Customers) có thể có nhiều sản phẩm (Product) trong giỏ hàng (CartItem), và ngược lại (nhiều-nhiều), thông qua bảng trung gian CartItem.
- **Thể hiện:**
   - Trong CartItem:
      - @Id customerId, @Id productId
      - @ManyToOne
         Customers customer;
      - @ManyToOne
         Product product;

### 7. Các quan hệ khác
- Role, Authority, ...: Các entity này dùng cho phân quyền, liên kết với Customers hoặc các bảng khác thông qua các quan hệ nhiều-một hoặc nhiều-nhiều tùy vào thiết kế chi tiết.

---

## 📦 Cấu trúc dự án

```
shopweb/
├── src/
│   ├── main/
│   │   ├── java/com/ptit/
│   │   │   ├── config/          # Configuration classes
│   │   │   ├── controller/      # Web controllers
│   │   │   ├── rest/           # REST API controllers
│   │   │   ├── service/        # Business logic
│   │   │   ├── dao/            # Data access objects
│   │   │   ├── entity/         # JPA entities
│   │   │   ├── dto/            # Data transfer objects
│   │   │   ├── util/           # Utility classes
│   │   │   └── interceptor/    # Request interceptors
│   │   └── resources/
│   │       ├── static/         # Static resources
│   │       │   ├── admin/      # Admin panel files
│   │       │   ├── assets/     # CSS, JS, images
│   │       │   └── assetss/    # AngularJS controllers
│   │       └── templates/      # Thymeleaf templates
│   └── test/                   # Test files
├── database.sql                # Database schema
├── pom.xml                     # Maven configuration
└── README.md                   # Project documentation
```

## 🛠️ Cài đặt và chạy dự án

### Yêu cầu hệ thống
- **Java 17** 
- **Maven 3.6+**
- **MySQL 8.0+**

### 1. Clone repository
```bash
git clone https://github.com/HieuNM1804/shopweb.git
cd shopweb
```

### 2. Cài đặt database

Bạn có thể chạy lệnh sau trong terminal (Command Prompt hoặc PowerShell). Nếu lệnh `mysql` không được nhận diện, hãy sử dụng đường dẫn đầy đủ tới file thực thi của MySQL (thường nằm ở `C:\Program Files\MySQL\MySQL Server 8.0\bin\mysql.exe` trên Windows).

```bash
# Đăng nhập vào MySQL (thay đường dẫn nếu cần thiết)
"C:\Program Files\MySQL\MySQL Server 8.0\bin\mysql" -u root -p

# Sau khi nhập mật khẩu và vào được MySQL shell:
CREATE DATABASE shopweb;
USE shopweb;
SOURCE database.sql;
```

### 3. Cấu hình environment variables
Tạo một file tên là `.env` tại thư mục gốc của dự án (cùng cấp với file `pom.xml`).
Copy nội dung dưới đây vào file `.env` và cập nhật các giá trị tương ứng của bạn:

```env
# Database
DB_PASSWORD=your_mysql_password

# Mail Configuration
MAIL_USERNAME=your_gmail@gmail.com
MAIL_PASSWORD=your_app_password

# Google OAuth2
GOOGLE_CLIENT_ID=your_google_client_id
GOOGLE_CLIENT_SECRET=your_google_client_secret

# VNPay
VNPAY_TMN_CODE=your_vnpay_tmn_code
VNPAY_HASH_SECRET=your_vnpay_hash_secret

# Cloudinary
CLOUD_NAME=your_cloudinary_name
CLOUD_KEY=your_cloudinary_key
CLOUD_SECRET=your_cloudinary_secret
```

### 4. Chạy ứng dụng
```bash
# Cài đặt dependencies
mvn clean install

# Chạy application
mvn spring-boot:run
```

Hoặc sử dụng VS Code task:
```bash
# Trong VS Code, nhấn Ctrl+Shift+P và chọn "Tasks: Run Task"
# Chọn "Run Spring Boot Application"
```

### 5. Truy cập ứng dụng
- **Website**: http://localhost:8080
- **Admin Panel**: http://localhost:8080/admin
- **API Documentation**: http://localhost:8080/actuator

## 🔧 Cấu hình chi tiết

### Database Configuration
```properties
# MySQL Connection
spring.datasource.url=jdbc:mysql://localhost:3306/shopweb?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8&allowPublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA / Hibernate
spring.jpa.hibernate.ddl-auto=none
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.show-sql=false
```

### Security Configuration
```java
// OAuth2 Login
spring.security.oauth2.client.registration.google.client-id=${GOOGLE_CLIENT_ID}
spring.security.oauth2.client.registration.google.client-secret=${GOOGLE_CLIENT_SECRET}
```

### File Upload Configuration
```properties
# MULTIPART
spring.servlet.multipart.enabled=true
spring.servlet.multipart.max-file-size=20MB
spring.servlet.multipart.max-request-size=50MB
```

## 📊 Database Schema

### Main Tables
- **Customers** - User accounts và profiles
- **Products** - Product catalog
- **Categories** - Product categories
- **Orders** - Order information
- **OrderDetails** - Order line items
- **CartItems** - Shopping cart items
- **Favorites** - User favorites
- **Roles** - User roles (DIRE, STAF, CUST)
- **Authorities** - User permissions

### Key Relationships
- Customer → Orders (One-to-Many)
- Order → OrderDetails (One-to-Many)
- Product → Category (Many-to-One)
- Customer → CartItems (One-to-Many)
- Customer → Favorites (One-to-Many)

## 🔌 API Endpoints

### Authentication
- `POST /auth/login` - User login
- `POST /auth/register` - User registration
- `GET /auth/logout` - User logout
- `POST /auth/forgot-password` - Password reset

### Products
- `GET /rest/products` - Get all products
- `GET /rest/products/{id}` - Get product by ID
- `POST /rest/products` - Create new product
- `PUT /rest/products/{id}` - Update product
- `DELETE /rest/products/{id}` - Delete product

### Cart
- `GET /rest/cart/{customerId}` - Get cart items
- `POST /rest/cart/{customerId}/add/{productId}` - Add to cart
- `PUT /rest/cart/{customerId}/update/{productId}` - Update cart item
- `DELETE /rest/cart/{customerId}/remove/{productId}` - Remove from cart

### Orders
- `GET /rest/orders` - Get all orders
- `POST /rest/orders` - Create new order
- `GET /rest/orders/{id}` - Get order by ID
- `PUT /rest/orders/{id}/payment-status` - Update payment status

### Favorites
- `GET /rest/favorites` - Get user favorites
- `POST /rest/favorites` - Add to favorites
- `DELETE /rest/favorites/{productId}` - Remove from favorites

## 💳 Payment Integration

### VNPay Configuration
```properties
# VNPay Settings
vnpay.tmn-code=${VNPAY_TMN_CODE}
vnpay.hash-secret=${VNPAY_HASH_SECRET}
vnpay.url=https://sandbox.vnpayment.vn/paymentv2/vpcpay.html
vnpay.return-url=http://localhost:8080/vnpay/return
vnpay.ipn-url=http://localhost:8080/vnpay/ipn
```

### Payment Flow
1. Customer proceeds to checkout
2. Order is created with PENDING status
3. VNPay payment URL is generated
4. Customer completes payment on VNPay
5. VNPay redirects back with payment result
6. Order status is updated to PAID/FAILED

## 📧 Email Configuration

### Gmail SMTP Setup
```properties
# Mail Configuration
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=${MAIL_USERNAME}
spring.mail.password=${MAIL_PASSWORD}
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

### Email Features
- **Password Reset** - Send reset link via email
- **Order Confirmation** - Send order details
- **Registration Welcome** - Welcome new users

## 🖼️ Image Management

### Cloudinary Integration
```properties
# Cloudinary Configuration
cloud.name=${CLOUD_NAME}
cloud.key=${CLOUD_KEY}
cloud.secret=${CLOUD_SECRET}
```

### Upload Features
- **Product Images** - Upload via admin panel
- **User Avatars** - Profile picture upload
- **Automatic Optimization** - Cloudinary auto-optimization
- **CDN Delivery** - Fast image delivery

## 🔍 Search Features

### Product Search
- **Keyword Search** - Search by product name
- **Category Filter** - Filter by category
- **Accent Insensitive** - Vietnamese accent support
- **Combined Search** - Keyword + Category

### Search Implementation
```java
// Vietnamese accent-insensitive search
@Query("SELECT p FROM Product p WHERE " +
       "LOWER(REPLACE(REPLACE(REPLACE(p.name, 'á', 'a'), 'à', 'a'), 'ạ', 'a')) " +
       "LIKE LOWER(CONCAT('%', :keyword, '%'))")
List<Product> findByNameIgnoringAccents(@Param("keyword") String keyword);
```

## 📱 Responsive Design

### Frontend Technologies
- **Bootstrap 5** - Mobile-first responsive design
- **jQuery** - DOM manipulation
- **AngularJS** - Admin panel SPA
- **Thymeleaf** - Server-side templating

### Responsive Features
- **Mobile Navigation** - Collapsible menu
- **Product Grid** - Responsive product cards
- **Cart Management** - Mobile-optimized cart
- **Touch-friendly** - Mobile gesture support

## 🚀 Deployment

### Production Checklist
1. **Database Setup**
   - Create production database
   - Run database migrations
   - Configure connection pooling

2. **Environment Variables**
   - Set production environment variables
   - Configure SSL certificates
   - Set up monitoring

3. **Application Configuration**
   - Set `spring.profiles.active=prod`
   - Configure logging levels
   - Enable compression

4. **Security**
   - Enable HTTPS
   - Configure CORS policies
   - Set up rate limiting

### Docker Deployment
```dockerfile
FROM openjdk:17-jdk-slim
COPY target/SOF306-ASM-0.0.1.war app.war
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.war"]
```

## 🧪 Testing

### Test Structure
```
src/test/java/com/ptit/
├── controller/     # Controller tests
├── service/        # Service layer tests
├── repository/     # Repository tests
└── integration/    # Integration tests
```

### Running Tests
```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=ProductServiceTest

# Run with coverage
mvn test jacoco:report
```

## 📚 Documentation

### Code Documentation
- **Javadoc** - API documentation
- **Swagger** - REST API documentation
- **Database Schema** - ERD diagrams

### User Documentation
- **User Manual** - Customer features
- **Admin Guide** - Admin panel usage
- **API Reference** - Developer guide

## 🤝 Contributing

### Development Workflow
1. Fork the repository
2. Create feature branch: `git checkout -b feature/new-feature`
3. Commit changes: `git commit -m 'Add new feature'`
4. Push to branch: `git push origin feature/new-feature`
5. Submit pull request

### Code Standards
- **Java Coding Standards** - Follow Google Java Style Guide
- **Commit Messages** - Use conventional commits
- **Documentation** - Update README for new features
- **Testing** - Write unit tests for new code

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

