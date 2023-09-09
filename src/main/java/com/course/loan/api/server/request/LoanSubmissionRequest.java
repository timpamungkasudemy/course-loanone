package com.course.loan.api.server.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanSubmissionRequest {

  private int amount;

  private int tenure;

}
