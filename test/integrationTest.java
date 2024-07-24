import DAO.DaoBebida;
import org.junit.Test;

import static org.junit.Assert.*;

import Model.Bebida;
import Model.Pedido;
import Model.Cliente;
import Model.Endereco;
import DAO.DaoCliente;

public class integrationTest {
      @Test
  public void testIdDaBebidaBD() {
    Bebida sacola1 = new Bebida(222,"agua","agua mineral",3, 1.0);
    DaoBebida database = new DaoBebida(); 
    assertEquals(sacola1.getNome(), database.getBebida(1));
  }

      @Test
  public void testClienteBD() {
    Cliente carlos = new Cliente(1, "Carlos", "Silva", "21999999999", "CarlosSilva01", null);
    DaoCliente database = new DaoCliente(); 
    assertEquals(carlos.getNome(),database.getUser(280));
  }
      @Test
  public void testClienteEnd() {
  Endereco endereco= new Endereco(01, "presidente vargas", "centro", 3, null, "Rio de Janeiro", "Rio de Janeiro");
  Cliente carlos = new Cliente(1, "Carlos", "Silva", "21999999999", "CarlosSilva01", endereco);
  assertEquals(carlos.getEndereco(),endereco);

  }
      @Test
  public void testPedidoCliente() {
    Cliente carlos = new Cliente(1, "Carlos", "Silva", "21999999999", "CarlosSilva01", null);
    Pedido pedido = new Pedido(0,carlos,"2020-10-10",100.0,1);
    assertEquals(carlos,pedido.getCliente());
  }
}