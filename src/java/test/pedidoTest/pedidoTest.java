package test.pedidoTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import Model.Lanche;
import Model.Pedido;

@DisplayName("Classe para testar Pedido")
public class pedidoTest {
    Pedido x;
    Pedido y;

    @BeforeEach
    public void inicializar() {
        x = new Pedido(
                0,
                null,
                "2020-10-10",
                100.0,
                1);
        y = new Pedido(
                1,
                null,
                "2020-10-13",
                150.0,
                2);
    }

    @DisplayName("Teste para criar classe")
    @Test
    public void testCriaClasse() {
              x = new Pedido(
                0,
                null,
                "2020-10-10",
                100.0,
                1);
        try {
            Assertions.assertAll("x",
                    () -> assertEquals(0, x.getId_pedido()),
                    () -> assertEquals(null, x.getCliente()),
                    () -> assertEquals("2020-10-10", x.getData_pedido()),
                    () -> assertEquals(100, 0, x.getValor_total()),
                    () -> assertEquals(1, x.getQuantidade()));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    @BeforeEach
    @Test
    public void testQuantidadePedido() {
        x = new Pedido(
                0,
                null,
                "2020-10-10",
                100.0,
                1);
        y = new Pedido(
                1,
                null,
                "2020-10-13",
                150.0,
                2);
        try {
            assertNotSame(x, y);
        } catch (ClassCastException e) {
            System.out.println(e.getMessage());
        }
    }

    @BeforeEach
    @Test
    public void testValorTotalDoValorTotal() {
        x = new Pedido(
                0,
                null,
                "2020-10-10",
                100.0,
                1);
        y = new Pedido(
                1,
                null,
                "2020-10-13",
                150.0,
                2);
        try {
            Assertions.assertEquals(x.getValor_total() + y.getValor_total() , 250.0);
        }catch(ClassCastException e) {
            System.out.println(e.getMessage());
        }
    }

    @BeforeEach
    @Test
    public void testDataInvalida() {
        x = new Pedido(
                0,
                null,
                "2020-10-10",
                100.0,
                1);
        try {
            Assertions.assertTrue(x.checkQuantidade());
        }catch(ClassCastException e) {
            System.out.println(e.getMessage());
        }
    }

    @BeforeEach
    @Test
    public void testPedidoUnico() {
        x = new Pedido(
                0,
                null,
                "2020-10-10",
                100.0,
                1);
        Lanche lanche = new Lanche(
                    0,
                    "hamburguer",
                    "pão e carne",
                    100.0,
                    0,
                    100.0,
                    1);
        try {
            Assertions.assertFalse(x.addPedido_Cliente(lanche));
        }catch(ClassCastException e) {
            System.out.println(e.getMessage());
        }
    }
    @BeforeEach
    @Test
    public void testPedidoDuplo() {
        x = new Pedido(
                0,
                null,
                "2021-12-11",
                200.0,
                2);
        Lanche lanche = new Lanche(
                    0,
                    "hamburguer",
                    "pão e carne",
                    100.0,
                    0,
                    100.0,
                    1);
        try {
            Assertions.assertFalse(x.addPedido_Cliente(lanche));
        }catch(ClassCastException e) {
            System.out.println(e.getMessage());
        }
    }
}
