package edu.icet.mos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class OrderDetails {
    private Integer orderDetailID;
    private Integer itemID;
    private Integer qty;
    private Double unitPrice;
}
