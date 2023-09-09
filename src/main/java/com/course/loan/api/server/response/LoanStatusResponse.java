package com.course.loan.api.server.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanStatusResponse {

  private String status;
  
  private int amount;
  
  private int tenure;
  
  private String description;
  
}
