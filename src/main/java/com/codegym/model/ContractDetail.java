package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "contract_detail")
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contract_detail_id;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "attach_service_id")
    private AttachService attachService;
    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;

    public ContractDetail() {
    }

    public ContractDetail(int quantity, AttachService attachService, Contract contract) {
        this.quantity = quantity;
        this.attachService = attachService;
        this.contract = contract;
    }

    public ContractDetail(int contract_detail_id, int quantity, AttachService attachService, Contract contract) {
        this.contract_detail_id = contract_detail_id;
        this.quantity = quantity;
        this.attachService = attachService;
        this.contract = contract;
    }

    public int getContract_detail_id() {
        return contract_detail_id;
    }

    public void setContract_detail_id(int contract_detail_id) {
        this.contract_detail_id = contract_detail_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
