package ru.max.javaspringboot.SpringBootGet_223.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.max.javaspringboot.SpringBootGet_223.config.LoanProperties;
import ru.max.javaspringboot.SpringBootGet_223.model.Car;
import ru.max.javaspringboot.SpringBootGet_223.model.User;
import ru.max.javaspringboot.SpringBootGet_223.repository.CarRepository;
import ru.max.javaspringboot.SpringBootGet_223.repository.UserRepository;

@Service
public class LoanService {

    @Autowired
    private final CarRepository carRepository;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final IncomeService incomeService;

    @Autowired
    private final LoanProperties loanProperties;

    public LoanService(CarRepository carRepository, UserRepository userRepository, IncomeService incomeService, LoanProperties loanProperties) {
        this.carRepository = carRepository;
        this.userRepository = userRepository;
        this.incomeService = incomeService;
        this.loanProperties = loanProperties;
    }

    public Double approveLoan(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return 0.0;
        }
        Car car = user.getCar();
        double carPrice = car != null ? car.getPrice() : 0.0;

        double income = incomeService.getUserIncome(userId);
        double maxLoanByIncome = income > loanProperties.getMinimalIncome() ? (income * 12 * loanProperties.getMaxCredit()) : 0.0;
        double maxLoanByCar = carPrice > 1_000_000 ? (carPrice * loanProperties.getCarCredit()) : 0.0;

        return Math.max(maxLoanByIncome, maxLoanByCar);
    }
}