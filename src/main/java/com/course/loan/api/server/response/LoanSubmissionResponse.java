package com.course.loan.api.server.response;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanSubmissionResponse {

  private UUID loanId;

  private String status;

  private String description;

}
