//: jdbc.domain.model.Purchase.java


package jdbc.domain.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.Accessors;


@Data
@Accessors(fluent = true)
@Getter(onMethod = @__(@JsonProperty))
@Setter(onMethod = @__(@JsonProperty))
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class Purchase {

    private int id;
    private String product;
    private long price;

}///:~