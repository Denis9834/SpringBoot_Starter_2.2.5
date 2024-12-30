package ru.max.javaspringboot.SpringBootGet_223.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.max.javaspringboot.SpringBootGet_223.model.Car;
import ru.max.javaspringboot.SpringBootGet_223.model.User;
import ru.max.javaspringboot.SpringBootGet_223.repositories.CarRepository;
import ru.max.javaspringboot.SpringBootGet_223.repositories.UserRepository;

import java.util.List;

@Service
public class LoanService {

    @Value("${loan.minimalIncome}")
    private Double minimalIncome;

    @Value("${loan.maxCredit}")
    private Double maxCredit;

    @Value("${loan.carCredit}")
    private Double carCredit;

    @Autowired
    private final CarRepository carRepository;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final IncomeService incomeService;

    public LoanService(CarRepository carRepository, UserRepository userRepository, IncomeService incomeService) {
        this.carRepository = carRepository;
        this.userRepository = userRepository;
        this.incomeService = incomeService;
    }

    public Double approveLoan(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return 0.0;
        }
        Car car = user.getCar();
        double carPrice = car != null ? car.getPrice() : 0.0;

        double income = incomeService.getUserIncome(userId);
        double maxLoanByIncome = income > minimalIncome ? (income * 12 * maxCredit) : 0.0;
        double maxLoanByCar = carPrice > 1_000_000 ? (carPrice * carCredit) : 0.0;

        return Math.max(maxLoanByIncome, maxLoanByCar);
    }
}