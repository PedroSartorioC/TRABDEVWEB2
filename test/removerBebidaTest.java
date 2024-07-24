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

public class removerBebidaTest {
    private RemoverBebida removerBebida;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private StringWriter stringWriter;
    private PrintWriter writer;

    @BeforeEach
    public void setup() throws IOException {
        removerBebida = new RemoverBebida();
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);

        stringWriter = new StringWriter();
        writer = new PrintWriter(stringWriter);
        Mockito.when(response.getWriter()).thenReturn(writer);
    }

    @Test
    public void testProcessRequestWithValidData() throws ServletException, IOException {

        String json = "{\"id\": 1, \"nome\": \"Bebida\", \"descricao\": \"Description\", \"quantidade\": 10, " +
                "\"ValorCompra\": 10.5, \"ValorVenda\": 20.5, \"tipo\": \"Type\"}";
        BufferedReader reader = new BufferedReader(new StringReader(json));
        Mockito.when(request.getInputStream()).thenReturn(new ServletInputStreamMock(reader));

        Cookie[] cookies = { new Cookie("cookieName", "cookieValue") };
        Mockito.when(request.getCookies()).thenReturn(cookies);

        DaoBebida bebidaDao = Mockito.mock(DaoBebida.class);
        Mockito.doNothing().when(bebidaDao).remover(Mockito.any(Bebida.class));

        removerBebida.processRequest(request, response);

        writer.flush();
        String responseOutput = stringWriter.toString().trim();
        Assertions.assertEquals("Bebida Removida!", responseOutput);
    }

    @Test
    public void testProcessRequestWithInvalidData() throws ServletException, IOException {

        BufferedReader reader = new BufferedReader(new StringReader(""));
        Mockito.when(request.getInputStream()).thenReturn(new ServletInputStreamMock(reader));

        Mockito.when(request.getCookies()).thenReturn(null);

        removerBebida.processRequest(request, response);

        writer.flush();
        String responseOutput = stringWriter.toString().trim();
        Assertions.assertEquals("erro", responseOutput);
    }
}
