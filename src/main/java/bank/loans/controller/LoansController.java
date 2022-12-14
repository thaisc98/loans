package bank.loans.controller;

import bank.loans.model.Customer;
import bank.loans.model.Loans;
import bank.loans.repository.LoansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class LoansController {

    @Autowired
    private LoansRepository loansRepository;

    @PostMapping("/my-loans")
    public List<Loans> getLoansDetails(@RequestBody Customer customer){
        List<Loans> loans = loansRepository.findByCustomerIdOrderByStartAtDesc(customer.getCustomerId());
        return Objects.nonNull(loans) ? loans : null;
    }
}
