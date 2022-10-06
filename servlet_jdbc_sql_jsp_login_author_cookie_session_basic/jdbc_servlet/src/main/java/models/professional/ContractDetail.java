package models.professional;

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

    public ContractDetail(int id_contract, int id_attach_service, int quantity) {
        this.id_contract = id_contract;
        this.id_attach_service = id_attach_service;
        this.quantity = quantity;
    }
}
