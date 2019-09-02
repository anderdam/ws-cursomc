package com.adappsdev.wscursomc.dto;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import com.adappsdev.wscursomc.domain.Categoria;
import org.hibernate.validator.constraints.Length;

public class CategoriaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    
    @NotEmpty (message = "Preenchimento obrigatório")
    @Length(min = 5, max = 80, message = "Tamanho deve ser entre 5 e 80 caracteres")
    private String name;
    
    public CategoriaDTO(){
    }

    public CategoriaDTO(Categoria obj){
        id = obj.getId();
        name = obj.getName();
    }

    public CategoriaDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}