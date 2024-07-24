package test.funcionarioTest;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import Model.Funcionario;

public class funcionarioTest {

    Funcionario funcionario = new Funcionario(
            1,
            "Kener",
            "Bortoluzzi",
            "kenerbortoluzzi",
            "Cozinheiro",
            1400.00,
            1,
            1);

    @DisplayName("Função para teste de aumento de salário")
    @Test
    public void testAumentoSalario() {
        double aumentoSalarial = (funcionario.getSalario() + (funcionario.getSalario() * 0.1));
        funcionario.setSalario(aumentoSalarial);
        Assertions.assertEquals(funcionario.getSalario(), aumentoSalarial);
    }

    @DisplayName("Função para teste de diminuição de salário")
    @Test
    public void testDiminuicaoSalario() {
        double diminuicaoSalarial = (funcionario.getSalario() - (funcionario.getSalario() * 0.1));
        funcionario.setSalario(diminuicaoSalarial);
        Assertions.assertEquals(funcionario.getSalario(), diminuicaoSalarial);
    }

    @DisplayName("Função para calcular troca de cargo")
    @Test
    public void testTrocaDeCargo() {
        String novoCargo = "Gerente";
        funcionario.setCargo(novoCargo);
        Assertions.assertEquals(novoCargo, funcionario.getCargo());
    }

    @DisplayName("Função para verificação de id unico")
    @Test
    public void testIDIgual() {
        Funcionario funcionario2 = new Funcionario(
                2,
                "William",
                "Bortoluzzi",
                "williambortoluzzi",
                "Garçom",
                1200.00,
                1,
                1);

        assertNotEquals(funcionario.getId(), funcionario2.getId());
    }

    @DisplayName("Função para alteração de dados")
    @Test
    public void testTrocaUsuario() {
        String novoUsuario = "kener_funcionario";
        funcionario.setUsuario(novoUsuario);
    }
}