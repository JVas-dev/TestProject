package ru.test.project.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CarDTO {
    @NotNull
    private Long id;
    @NotNull
    private String model;
    @NotNull
    @Min(value = 1)
    private Integer horsepower;
    @NotNull
    private Long ownerId;

    public CarDTO(@NotNull Long id, @NotNull String model, @NotNull Integer horsepower, @NotNull Long ownerId) {
        this.id = id;
        this.model = model;
        this.horsepower = horsepower;
        this.ownerId = ownerId;
    }

    public CarDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(Integer horsepower) {
        this.horsepower = horsepower;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
