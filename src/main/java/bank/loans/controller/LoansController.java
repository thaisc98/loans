package bank.loans.controller;

import bank.loans.config.LoansServiceConfig;
import bank.loans.model.Customer;
import bank.loans.model.Loans;
import bank.loans.model.Properties;
import bank.loans.repository.LoansRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class LoansController {

    @Autowired
    private LoansRepository loansRepository;

    @Autowired
    LoansServiceConfig loansServiceConfig;

    @PostMapping("/my-loans")
    public List<Loans> getLoansDetails(@RequestBody Customer customer){
        List<Loans> loans = loansRepository.findByCustomerIdOrderByStartAtDesc(customer.getCustomerId());
        return Objects.nonNull(loans) ? loans : null;
    }

    @GetMapping("/loans/properties")
    public String getPropertyDetails() throws JsonProcessingException {
        ObjectWriter ow =  new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(loansServiceConfig.getMsg(), loansServiceConfig.getBuildVersion(),
                loansServiceConfig.getMailDetails(), loansServiceConfig.getActiveBranches());
        return ow.writeValueAsString(properties);
    }

}
