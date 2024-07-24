import DAO.DaoBebida;
import org.junit.Test;
import org.asynchttpclient.util.Assertions;
import static org.junit.Assert.*;

import Model.Funcionario;
import Model.Pedido;
import Model.Cliente;
import Model.Endereco;
import DAO.DaoCliente;
import DAO.DaoFuncionario;

public class integrationTest2 {
    @Test
    public void testeFuncionarioBD() {
        Funcionario funcionario = new Funcionario(1, "Diego", "Brando", "Dio", "Gerente", 5000.00, 1, 2);
        DaoFuncionario database = new DaoFuncionario();
        assertEquals(funcionario.getUsuario(), database.getFuncionario("Diego"));
    }

    @Test
    public void testeFuncionarioClienteBD() {
        Funcionario funcionario = new Funcionario(1, "Diego", "Brando", "Dio", "Gerente", 5000.00, 1, 2);
        DaoCliente database = new DaoCliente();
        assertNotSame(funcionario, database.getUser(332));
    }

    @Test
    // Possível utilidade é na atualização do banco de dados para utilizar possível
    // classe Pessoa
    public void mesmoIdFuncionarioPessoa() {
        Cliente Ramon = new Cliente(1, "Ramon", "Silva", "21999999942", "CarlosSilva01", null);
        Funcionario funRamon = new Funcionario(1, "Ramon", "Silva", "CarlosSilva01", "Coordenador", 10000.00, 2, 1);
        assertNotSame(Ramon, funRamon);
    }

    @Test
    public void mesmoIdPedidoCliente() {
        Cliente ramon = new Cliente(1, "Ramon", "Silva", "21999999942", "CarlosSilva01", null);
        Pedido pedido = new Pedido(1, ramon, "01/07/2023", 55.00, 1);
        assertSame(ramon, pedido.getCliente());
    }

    @Test
    public void testFuncionarioCliente() {
        Cliente ramon = new Cliente(3, "Ramon", "Silva", "21999999997", "RamonSouza01", null);
        Funcionario funRamon = new Funcionario(1, "Ramon", "Silva", "RamonSilva01", null, null, 0, 0);
        try {
            assertNotSame(ramon.getUsuario(), funRamon.getUsuario());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

}