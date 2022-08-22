package models.professional_furama;

import lombok.*;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor @Data @Builder
public class AttachService {
    int id;
    String name;
    double cost;
    int unit;
    String status;
}
