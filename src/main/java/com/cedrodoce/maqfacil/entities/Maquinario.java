package com.cedrodoce.maqfacil.entities;

import com.cedrodoce.maqfacil.DTO.MaquinarioDTO;
import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.Objects;

@Entity
public class Maquinario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Maquinario() {

    }

    @PrePersist
    public void prePersist() {
        if (this.status == null) {
            Calendar c = Calendar.getInstance();
            this.status = new Status(null, false, null, null, null);
        }
    }

    @Column
    @NotNull
    @NotBlank
    private String modelo;
    @Column
    @NotNull
    @NotBlank
    private String marca;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;
    @Column
    @NotNull
    @NotBlank
    private char porte;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "historico_id", referencedColumnName = "id")
    private HistoricoOperacoes historicoOperacoes;

    public Maquinario(MaquinarioDTO dto) {
        this.marca = dto.marca();
        this.modelo = dto.modelo();
        this.porte = dto.porte();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public char getPorte() {
        return porte;
    }

    public void setPorte(char porte) {
        this.porte = porte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Maquinario that = (Maquinario) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Maquinario{" +
                "id=" + id +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", status=" + status +
                ", porte='" + porte + '\'' +
                '}';
    }
}
