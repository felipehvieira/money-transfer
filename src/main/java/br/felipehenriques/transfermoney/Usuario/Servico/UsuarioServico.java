package br.felipehenriques.transfermoney.Usuario.Servico;

import br.felipehenriques.transfermoney.Carteira.Client.CarteiraClient;
import br.felipehenriques.transfermoney.Carteira.Domain.dto.SaldoResponse;
import br.felipehenriques.transfermoney.Infrastructure.Handler.Exceptions.NotFoundException;
import br.felipehenriques.transfermoney.Usuario.Repositorio.UsuarioRepositorio;
import br.felipehenriques.transfermoney.Usuario.entidade.Usuario;
import br.felipehenriques.transfermoney.Usuario.entidade.UsuarioBuilder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class UsuarioServico {

    private final UsuarioRepositorio repositorio;
    private final CarteiraClient carteiraClient;

    public UsuarioServico(UsuarioRepositorio repositorio, CarteiraClient carteiraClient) {
        this.repositorio = repositorio;
        this.carteiraClient = carteiraClient;
    }

    public Usuario salvar(Usuario usuarioRequest) {
        //realiza o cadastro da carteira
        UUID idCarteira = UUID.randomUUID();
        Usuario usuario =
                new UsuarioBuilder()
                .nomeCompleto(usuarioRequest.getNomeCompleto())
                .documento(usuarioRequest.getDocumento())
                .email(usuarioRequest.getEmail())
                .tipoUsuario(usuarioRequest.getTipoUsuario())
                .senha(usuarioRequest.getSenha())
                .build();

        return repositorio.save(usuario);
    }

    public Usuario findById(UUID idUsuario){
        return repositorio.findById(idUsuario)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado!"));
    }

    public BigDecimal getSaldoUsuario(){
        SaldoResponse response = carteiraClient.retornaSaldoCliente();
        return response.getSaldo();
    }
}
