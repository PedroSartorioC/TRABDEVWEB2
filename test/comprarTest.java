import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class comprarTest {
    private Comprar comprar;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private StringWriter stringWriter;
    private PrintWriter writer;

    @BeforeEach
    public void setup() throws IOException {
        comprar = new Comprar();
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);

        stringWriter = new StringWriter();
        writer = new PrintWriter(stringWriter);
        Mockito.when(response.getWriter()).thenReturn(writer);
    }

    @Test
    public void testProcessRequestWithValidData() throws ServletException, IOException {

        String json = "{\"id\": 1, \"Lanche1\": [\"nome\", \"lanche\", 2], \"Bebida1\": [\"nome\", \"bebida\", 3]}";
        BufferedReader reader = new BufferedReader(new StringReader(json));
        Mockito.when(request.getInputStream()).thenReturn(new ServletInputStreamMock(reader));

        Cookie[] cookies = { new Cookie("cookieName", "cookieValue") };
        Mockito.when(request.getCookies()).thenReturn(cookies);

        DaoCliente clienteDao = Mockito.mock(DaoCliente.class);
        Mockito.when(clienteDao.pesquisaPorID("1")).thenReturn(new Cliente());

        DaoLanche lancheDao = Mockito.mock(DaoLanche.class);
        Mockito.when(lancheDao.pesquisaPorNome("Lanche1")).thenReturn(new Lanche());

        DaoBebida bebidaDao = Mockito.mock(DaoBebida.class);
        Mockito.when(bebidaDao.pesquisaPorNome("Bebida1")).thenReturn(new Bebida());

        DaoPedido pedidoDao = Mockito.mock(DaoPedido.class);
        Mockito.when(pedidoDao.pesquisaPorData(Mockito.any(Pedido.class))).thenReturn(new Pedido());

        Mockito.doNothing().when(pedidoDao).vincularLanche(Mockito.any(Pedido.class), Mockito.any(Lanche.class));
        Mockito.doNothing().when(pedidoDao).vincularBebida(Mockito.any(Pedido.class), Mockito.any(Bebida.class));

        Mockito.when(pedidoDao.salvar(Mockito.any(Pedido.class))).thenReturn(true);

        comprar.processRequest(request, response);

        writer.flush();
        String responseOutput = stringWriter.toString().trim();
        Assertions.assertEquals("Pedido Salvo com Sucesso!", responseOutput);
    }

    @Test
    public void testProcessRequestWithInvalidData() throws ServletException, IOException {

        BufferedReader reader = new BufferedReader(new StringReader(""));
        Mockito.when(request.getInputStream()).thenReturn(new ServletInputStreamMock(reader));

        Mockito.when(request.getCookies()).thenReturn(null);

        comprar.processRequest(request, response);

        writer.flush();
        String responseOutput = stringWriter.toString().trim();
        Assertions.assertEquals("erro", responseOutput);
    }
}
