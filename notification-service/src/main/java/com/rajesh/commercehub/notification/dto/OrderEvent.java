package com.rajesh.commercehub.notification.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderEvent {

    private Long orderId;
    private String message;

}
