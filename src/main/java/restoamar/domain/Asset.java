package restoamar.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import java.time.Instant;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String description;
    private String location;
    private Instant createdDate;
    private BigDecimal valueAmount;

    @Enumerated(EnumType.STRING)
    private ValueCurrency valueCurrency;

    // Default constructor required by Hibernate
    public Asset() {
    }

    // Constructor with arguments
    public Asset(UUID id, String name, String description, String location, Instant createdDate, BigDecimal valueAmount, ValueCurrency valueCurrency) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.createdDate = createdDate;
        this.valueAmount = valueAmount;
        this.valueCurrency = valueCurrency;
    }

    // Getters and setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public BigDecimal getValueAmount() {
        return valueAmount;
    }

    public void setValueAmount(BigDecimal valueAmount) {
        this.valueAmount = valueAmount;
    }

    public ValueCurrency getValueCurrency() {
        return valueCurrency;
    }

    public void setValueCurrency(ValueCurrency valueCurrency) {
        this.valueCurrency = valueCurrency;
    }
}