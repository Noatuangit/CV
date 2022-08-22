package models.professional_furama;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContractDetail {
    int id_details;
    int id_contract;
    int id_attach_service;
    int quantity;
}
