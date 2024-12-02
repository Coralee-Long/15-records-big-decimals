# Records

### Java Class Boilerplate:
1. Declare the Class
2. Declare Fields
3. Create a Constructor
4. Generate Getters & Setters
5. Generate Overrides (equals, hashCode, and toString)

### Example of a Regular Java Class:
```java
public class Book {
    private String ISBN;
    private String title;
    private double price;

    public Book(String ISBN, String title, double price) {
        this.ISBN = ISBN;
        this.title = title;
        this.price = price;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Double.compare(book.price, price) == 0 &&
               ISBN.equals(book.ISBN) &&
               title.equals(book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ISBN, title, price);
    }

    @Override
    public String toString() {
        return "Book{" +
               "ISBN='" + ISBN + '\'' +
               ", title='" + title + '\'' +
               ", price=" + price +
               '}';
    }
}

```
### Using Java Records
Java Records, introduced in Java 14 (as a preview) and finalized in Java 16, eliminate the need for boilerplate code for classes that are primarily used as data carriers.

**Example of a Record:**
```java
public record BookRecord(String ISBN, String title, double price) {
}
```

### Using the Java Record feature, you can have the same boilerplate
```java
public record BookRecord(String ISBN,
                         String title,
                         double price) {
}
```
**Explanation:**

- The compiler automatically provides a constructor, `equals`, `hashCode`, and `toString` methods.
- Records are immutable by design, meaning their fields are final and cannot be modified after creation.

### Adding "Wither" Methods to Records
Although Records are immutable, you can create "wither" methods to produce a new instance of a record with a modified field. This approach avoids directly modifying fields (which is not allowed in records).

**Example of a Record with "Wither" Methods:**
```java
public record BookRecord(String ISBN, String title, double price) {

    public BookRecord withPrice(double price) {
        return new BookRecord(ISBN, title, price);
    }

    public BookRecord withTitle(String title) {
        return new BookRecord(ISBN, title, price);
    }
}
```
**Usage:**
```java
public class Main {
    public static void main(String[] args) {
        BookRecord bookRecord = new BookRecord("1", "Old Title", 10.99);

        // Create a new record with updated fields
        bookRecord = bookRecord.withPrice(8.99).withTitle("New Test Title v2");

        System.out.println(bookRecord); 
        // BookRecord[ISBN=1, title=New Test Title v2, price=8.99]
    }
}
```

## Key Takeaways:
1. Records simplify data-centric classes by reducing boilerplate.
2. Records are immutable, but "wither" methods allow for a new instance with updated values.
3. Use Records for use cases where immutability and concise representation are beneficial, such as DTOs (Data Transfer Objects) or value objects.

---

# BigDecimal 

## Why Use BigDecimal?
BigDecimal is used in Java for high-precision arithmetic, especially in financial applications or scenarios where floating-point precision errors are unacceptable. For example:

```java
double a = 0.1;
double b = 0.2;

System.out.println(a + b); // 0.30000000000000004
```

**The above issue arises due to how floating-point arithmetic works. With BigDecimal:**
```java
BigDecimal c = new BigDecimal("0.1");
BigDecimal d = new BigDecimal("0.2");

System.out.println(c.add(d)); // 0.3

```

## Common Operations with BigDecimal
```java
BigDecimal result = c.add(d);
BigDecimal result = c.subtract(d);
BigDecimal result = c.multiply(d);
// ofter need a rounding mode for division
BigDecimal result = c.divide(d, RoundingMode.HALF_UP);
```

## Rounding Modes
BigDecimal supports a variety of rounding modes to control how values are rounded when performing operations that result in fractional values. Here's a breakdown:

| Rounding Mode    | Description                                                                           | Example (`2.5` / `-2.5`) |
|------------------|---------------------------------------------------------------------------------------|--------------------------|
| **UP**           | Always rounds away from zero.                                                         | `3` / `-3`               |
| **DOWN**         | Always rounds towards zero.                                                           | `2` / `-2`               |
| **HALF_UP**      | Rounds up if the discarded fraction is `>= 0.5`.                                       | `3` / `-3`               |
| **HALF_DOWN**    | Rounds down if the discarded fraction is `< 0.5`.                                      | `2` / `-2`               |
| **CEILING**      | Rounds towards positive infinity (up for positive, down for negative numbers).         | `3` / `-2`               |
| **FLOOR**        | Rounds towards negative infinity (down for positive, up for negative numbers).         | `2` / `-3`               |
| **HALF_EVEN**    | "Banker's rounding" - rounds to the nearest even number.                               | `2` / `-2`               |

## Key Takeaways
1. Use **BigDecimal** for precision-sensitive calculations.
2. Choose the appropriate **rounding mode** for your application.
3. Avoid direct arithmetic with `double` or `float` if precision matters.
4. BigDecimal operations are immutable; they always return a new instance.