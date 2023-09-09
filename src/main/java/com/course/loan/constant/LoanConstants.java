package com.course.loan.constant;

import java.util.List;

public interface LoanConstants {

  String APP_VERSION = "2.0.0";
  String STATUS_IN_PROGRESS = "IN_PROGRESS";
  String STATUS_APPROVED = "APPROVED";
  String STATUS_REJECTED = "REJECTED";
  List<Integer> TENURES = List.of(3, 6, 9, 12);

}
