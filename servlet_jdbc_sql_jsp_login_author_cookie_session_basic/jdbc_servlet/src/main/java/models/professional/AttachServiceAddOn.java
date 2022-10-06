package models.professional;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class AttachServiceAddOn {
    int id;
    String name;
    double cost;
    int unit;
    String status;
}
