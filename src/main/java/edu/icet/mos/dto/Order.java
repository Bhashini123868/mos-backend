package edu.icet.mos.dto;

import edu.icet.mos.entity.OrderDetailsEntity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {
    private Integer orderID;

    @NotBlank(message = "Customer ID is required")
    private String cusID;

    @NotNull(message = "Total is required")
    @Min(value = 1, message = "Total must be greater than zero")
    private Double total;

    @NotBlank(message = "Date is required")
    private String date;

    @NotNull(message = "Order details list cannot be null")
    private List<OrderDetailsEntity> orderDetail;
}
