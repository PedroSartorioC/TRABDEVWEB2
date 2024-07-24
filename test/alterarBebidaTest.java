
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import static org.mockito.Mockito.*;

import controllers.alterarBebida;

public class alterarBebidaTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void textProcessRequest() throws IOException, ServletException {

        String json = "{\"id\": 1, \"nome\": \"Bebida 1\", \"descricao\": \"Descrição\", \"quantidade\": 10, \"ValorCompra\": 5.0, \"ValorVenda\": 10.0, \"tipo\": \"Tipo\"}";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(json.getBytes());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        when(request.getInputStream()).thenReturn(bufferedReader);
        when(response.getWriter()).thenReturn(new PrintWriter(System.out));

        Cookie[] cookies = new Cookie[1];
        when(request.getCookies()).thenReturn(cookies);

        alterarBebida instance = new alterarBebida();
        instance.processRequest(request, response);

        verify(response).setContentType("application/json");
        verify(response).setCharacterEncoding("UTF-8");
        verify(response.getWriter()).println("Bebida Alterada!");
    }
}
