package br.felipehenriques.transfermoney.Operacao.Unit.Servico;


import br.felipehenriques.transfermoney.Carteira.Client.CarteiraClient;
import br.felipehenriques.transfermoney.Carteira.Domain.dto.SaldoResponse;
import br.felipehenriques.transfermoney.Infrastructure.Handler.Exceptions.BadRequestException;
import br.felipehenriques.transfermoney.Infrastructure.Handler.Exceptions.NotFoundException;
import br.felipehenriques.transfermoney.Operacao.Servico.OperacaoClienteLojistaServico;
import br.felipehenriques.transfermoney.Usuario.Repositorio.UsuarioRepositorio;
import br.felipehenriques.transfermoney.Usuario.entidade.TipoUsuario;
import br.felipehenriques.transfermoney.Usuario.entidade.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

public class OperacaoClienteLojistaServicoTest {

    @Mock
    UsuarioRepositorio repositorio;
    @Mock
    private CarteiraClient carteira;

    @InjectMocks
    private OperacaoClienteLojistaServico operacaoLojistaServico;

    @BeforeEach
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void usuarioOrigemInexistenteTest(){
        UUID idUsuarioOrigem = UUID.randomUUID();
        UUID idUsuarioDestino = UUID.randomUUID();
        Usuario usuarioMock = new Usuario(idUsuarioOrigem, "Felipe", "felipe@felipe",
                "2214578", TipoUsuario.LOJISTA, "123456");

        Mockito.when(repositorio.findById(idUsuarioOrigem)).thenReturn(Optional.of(usuarioMock));
        Exception exception = Assertions.assertThrows(NotFoundException.class, () ->
                operacaoLojistaServico.transferir(new BigDecimal("100"), UUID.randomUUID(), idUsuarioDestino)
        );

        String expectedMessage = "Usuário Origem Inexistente.";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void usuarioDestinoInexistenteTest(){
        UUID idUsuarioOrigem = UUID.randomUUID();
        UUID idUsuarioDestino = UUID.randomUUID();
        Usuario usuarioMock = new Usuario(idUsuarioOrigem, "Felipe", "felipe@felipe",
                "2214578", TipoUsuario.LOJISTA, "123456");

        Mockito.when(repositorio.findById(idUsuarioOrigem)).thenReturn(Optional.of(usuarioMock));
        Mockito.when(repositorio.findById(idUsuarioDestino)).thenReturn(Optional.of(usuarioMock));
        Exception exception = Assertions.assertThrows(NotFoundException.class, () ->
                operacaoLojistaServico.transferir(new BigDecimal("100"), idUsuarioOrigem, UUID.randomUUID())
        );

        String expectedMessage = "Usuário Destino Inexistente.";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void saldoInsuficienteTest(){
        SaldoResponse saldoResponse = new SaldoResponse(new BigDecimal("100"));
        Usuario usuarioOrigem = Mockito.mock(Usuario.class);
        Usuario usuarioDestino = Mockito.mock(Usuario.class);
        UUID idUsuarioOrigem = UUID.randomUUID();
        UUID idUsuarioDestino = UUID.randomUUID();
        Mockito.when(repositorio.findById(idUsuarioOrigem)).thenReturn(Optional.of(usuarioOrigem));
        Mockito.when(repositorio.findById(idUsuarioDestino)).thenReturn(Optional.of(usuarioDestino));
        Mockito.when(carteira.retornaSaldoCliente()).thenReturn(saldoResponse);

        Exception exception = Assertions.assertThrows(BadRequestException.class, () ->
                operacaoLojistaServico.transferir(new BigDecimal("100"), idUsuarioOrigem, idUsuarioDestino)
        );

        String expectedMessage = "Saldo Insuficiente.";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    public void usuariosOrigemDestinoIguaisTest(){
        UUID idUsuario = UUID.randomUUID();
        Exception exception = Assertions.assertThrows(BadRequestException.class, () ->
                operacaoLojistaServico.transferir(new BigDecimal("100"), idUsuario, idUsuario)
        );

        String expectedMessage = "Não é possível reaizar uma transferencia a si mesmo.";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

}
