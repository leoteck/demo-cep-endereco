package com.desafio.cepws.core.util;

import com.desafio.cepws.core.model.Endereco;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class EnderecoMockUtil {

    private List<Endereco> enderecos;

    private List<Endereco> gerarEnderecos(){
        enderecos = new ArrayList<>();
        //SP
        enderecos.add(new Endereco("01014901","Rua Boa Vista, 84","Centro","São Paulo","SP"));
        enderecos.add(new Endereco("01014902","Rua Boa Vista, 162","Centro","São Paulo","SP"));
        enderecos.add(new Endereco("01014903","Rua Boa Vista, 200","Centro","São Paulo","SP"));
        enderecos.add(new Endereco("01014904","Rua Boa Vista, 208","Centro","São Paulo","SP"));
        enderecos.add(new Endereco("01014905","Rua Boa Vista, 234","Centro","São Paulo","SP"));
        enderecos.add(new Endereco("01014906","Rua Boa Vista, 230","Centro","São Paulo","SP"));
        enderecos.add(new Endereco("01014907","Rua Boa Vista, 254","Centro","São Paulo","SP"));
        enderecos.add(new Endereco("01014908","Rua Boa Vista, 280","Centro","São Paulo","SP"));
        enderecos.add(new Endereco("01014909","Rua Boa Vista, 314","Centro","São Paulo","SP"));
        enderecos.add(new Endereco("01014910","Rua Boa Vista, 356","Centro","São Paulo","SP"));
        enderecos.add(new Endereco("01014911","Rua Boa Vista, 51","Centro","São Paulo","SP"));
        //BA
        enderecos.add(new Endereco("40010030","Avenida Estados Unidos","Comércio","Salvador","BA"));
        enderecos.add(new Endereco("40010040","Rua da Bélgica","Comércio","Salvador","BA"));
        enderecos.add(new Endereco("40010050","Rua da Espanha","Comércio","Salvador","BA"));
        enderecos.add(new Endereco("40010060","Rua da Holanda","Comércio","Salvador","BA"));
        enderecos.add(new Endereco("40010080","Rua da Noruega","Comércio","Salvador","BA"));
        enderecos.add(new Endereco("40026010","Largo Terreiro de Jesus","Pelourinho","Salvador","BA"));
        enderecos.add(new Endereco("40026020","Avenida Gouveia","Pelourinho","Salvador","BA"));
        enderecos.add(new Endereco("40026030","Ladeira de São Miguel","Pelourinho","Salvador","BA"));
        enderecos.add(new Endereco("40026040","Vila Dezoito","Pelourinho","Salvador","BA"));
        enderecos.add(new Endereco("40026045","Ladeira da Misericórdia","Pelourinho","Salvador","BA"));
        enderecos.add(new Endereco("41370045","Avenida Aliomar Baleeiro","Jardim Nova Esperança","Salvador","BA"));

        return enderecos;
    }

    public List<Endereco> getEnderecos() {
        return CollectionUtils.isEmpty(this.enderecos) ? gerarEnderecos() : this.enderecos;
    }
}
