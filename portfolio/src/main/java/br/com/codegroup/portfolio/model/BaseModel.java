package br.com.codegroup.portfolio.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author João Robson 12/08/2023
 */
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Data
@MappedSuperclass
public abstract class BaseModel implements Serializable {

    // TODO: verificar necessidade do @Serial
    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

}
