package com.softbank.app.gold.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
@Setter
public class Common {

  @Column(name = "created_when", nullable = false)
  private LocalDateTime createdWhen;

  @Column(name = "modified_when", nullable = false)
  private LocalDateTime modifiedWhen;

}
