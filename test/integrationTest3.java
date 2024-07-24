import DAO.DaoBebida;
import DAO.DaoCliente;
import org.junit.Test;

import static org.junit.Assert.*;

import Model.Bebida;
import Model.Pedido;
import Model.Cliente;
import Model.Endereco;
import DAO.DaoLanche;
import DAO.DaoPedido;

public class integrationTest3{
   @Test
  public void testIdPedido() {
    Pedido pedido = new Pedido(1,
                null,
                "2023-07-07",
                20.0,
                2);
    DaoPedido database = new DaoPedido(); 
    assertEquals(pedido.getId_pedido(), Integer.parseInt(database.getPedido(1)));
  }
   @Test
  public void testIdPedidoLanche() {
    DaoLanche lanche = new DaoLanche();
    DaoPedido database = new DaoPedido(); 
    assertEquals(lanche.getLanche("hamburguer"), database.getPedido(1));
  }
  @Test
  public void testIdPedidoLancheClass() {
    DaoLanche lanche = new DaoLanche();
    DaoPedido database = new DaoPedido(); 
    assertNotSame(lanche, database);
  }
    @Test
  public void testPedidoCliente() {
    DaoCliente cliente = new DaoCliente();
    DaoPedido database = new DaoPedido(); 
    assertSame(cliente.getUserId(185), database.getPedidoClienteId(1));
  }
}