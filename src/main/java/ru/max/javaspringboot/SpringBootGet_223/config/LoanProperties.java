package ru.max.javaspringboot.SpringBootGet_223.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "loan")
public class LoanProperties {
    private Double minimalIncome;
    private Double maxCredit;
    private Double carCredit;

    public Double getMinimalIncome() {
        return minimalIncome;
    }

    public void setMinimalIncome(Double minimalIncome) {
        this.minimalIncome = minimalIncome;
    }

    public Double getMaxCredit() {
        return maxCredit;
    }

    public void setMaxCredit(Double maxCredit) {
        this.maxCredit = maxCredit;
    }

    public Double getCarCredit() {
        return carCredit;
    }

    public void setCarCredit(Double carCredit) {
        this.carCredit = carCredit;
    }
}
