package springcloud.dta;

import lombok.Data;

@Data
public class ProductDto {
    private Integer pid;//主键

    private String pname;//商品名称
    private Double pprice;//商品价格
    private Integer stock;//库存
}
