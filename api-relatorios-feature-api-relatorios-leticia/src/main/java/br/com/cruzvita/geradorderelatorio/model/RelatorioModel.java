package br.com.cruzvita.geradorderelatorio.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transacao")
@Data
@NoArgsConstructor
public class RelatorioModel {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String cpf;
    private String tipoTransacao;
    private Date dataTransacao;
    private Double valorTransacao;
    private String cpfBeneficiado;
    private String statusTransacao;
    private String tipo;

}
