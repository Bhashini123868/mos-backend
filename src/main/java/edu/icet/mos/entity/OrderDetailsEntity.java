package edu.icet.mos.entity;

import edu.icet.mos.dto.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "orderDetails")
public class OrderDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderDetailID;
    private Integer itemID;

    @JoinColumn(name = "orderID", referencedColumnName = "orderID",nullable = false)
    private Order order;

    private Integer qty;
    private Double unitPrice;
}
