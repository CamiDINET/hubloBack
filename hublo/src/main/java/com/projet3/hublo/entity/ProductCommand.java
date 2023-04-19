package com.projet3.hublo.entity;

import jakarta.persistence.*;

@Entity
public class ProductCommand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "command_id")
    private Command command;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private Integer quantity;
    public ProductCommand() {}
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Command getCommand() { return command; }
    public void setCommand(Command command) { this.command = command; }
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}
