package com.course.loan.api.server.controller;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.loan.api.server.request.LoanSubmissionRequest;
import com.course.loan.api.server.response.LoanStatusResponse;
import com.course.loan.api.server.response.LoanSubmissionResponse;
import com.course.loan.api.server.response.ProductResponse;
import com.course.loan.constant.LoanConstants;

@RestController
@RequestMapping("/api/loan")
public class LoanBasicApi {

  @Value("${setting.product.car:UNKNOWN}")
  private String productCar;

  @Value("${setting.product.motorcycle:UNKNOWN}")
  private String productMotorcycle;

  @GetMapping("/{loanId}")
  LoanStatusResponse loanStatus(@PathVariable(name = "loanId") UUID loanId) {
    var description = String.format("Loan status using app version : %s", LoanConstants.APP_VERSION);
    var tenure = LoanConstants.TENURES.get(ThreadLocalRandom.current().nextInt(LoanConstants.TENURES.size()));
    var status = switch (ThreadLocalRandom.current().nextInt() % 3) {
    case 0:
      yield LoanConstants.STATUS_REJECTED;
    case 1:
      yield LoanConstants.STATUS_APPROVED;
    default:
      yield LoanConstants.STATUS_IN_PROGRESS;
    };

    return LoanStatusResponse.builder().amount(ThreadLocalRandom.current().nextInt(100) * 50).description(description)
        .status(status).tenure(tenure).build();
  }

  @GetMapping(path = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
  List<ProductResponse> productDetail() {
    var car = ProductResponse.builder().productName(productCar).build();
    var motorcycle = ProductResponse.builder().productName(productMotorcycle).build();

    return List.of(car, motorcycle);
  }

  @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
  LoanSubmissionResponse submitLoan(@RequestBody LoanSubmissionRequest request) {
    var description = String.format("Loan submitted using app version : %s", LoanConstants.APP_VERSION);
    var status = LoanConstants.STATUS_IN_PROGRESS;

    return LoanSubmissionResponse.builder().loanId(UUID.randomUUID()).description(description).status(status).build();
  }

}
