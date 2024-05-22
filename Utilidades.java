import java.util.ArrayList;
import java.util.List;

public class Utilidades {
    private final List<Veiculo> lista;

    public Utilidades() {
        lista = new ArrayList<>();
    }

    public List<Veiculo> getList(){
        return lista;
    }

    // ADICIONAR VEICULO
    public void adicionarVeiculo(Veiculo veiculo) throws Exception {
        if (veiculo.getMarca() == null || veiculo.getMarca().isEmpty()) {
            throw new Exception("A marca do veículo não pode ser nulo.");
        }
        if(veiculo.getModelo() == null || veiculo.getModelo().isEmpty()) {
            throw new Exception("O modelo do veículo não pode ser nulo.");
        }
        if(veiculo.getAno() < 1885) {
            throw new Exception("O ano deve ser maior que 0.");
        }
        if (veiculo instanceof Carro && ((Carro) veiculo).getNumeroPortas() < 1) { //casting explícito - converte o objeto referenciado pela variável veiculo para o tipo Carro. instanceof - retorna verdadeiro se o objeto referenciado pela variável veiculo for uma instância de Carro.
            throw new Exception("O carro deve ter um número de portas maior que 0.");
        }
        if(veiculo.getPlaca() == null || veiculo.getPlaca().isEmpty()) {
            throw new Exception("A placa é obrigatória.");
        }
        for (Veiculo L : lista){
            if(L.getPlaca().equalsIgnoreCase(veiculo.getPlaca())) {
                throw new Exception("Já existe um carro com essa placa cadastrado.");
            }
        }
        lista.add(veiculo);
    }

    // REMOVER
    public void removerVeiculo(Veiculo veiculo) {
        lista.remove(veiculo);
    }

    // LISTAR OS VEÍCULOS
    public void listaVeiculo() {
        if(lista.isEmpty()){
            System.out.println("Não há veículos para serem listados.");
            return;
        }
        System.out.println("=== Veículos na Lista ===");
        for (Veiculo veiculo : lista){
            System.out.println(veiculo);
            System.out.println();
        }
    }

    // BUSCAR
    public Veiculo buscarCarro(String placa){
        for(Veiculo veiculo : lista){
            if(veiculo.getPlaca().equalsIgnoreCase(placa)){
                return veiculo;
            }
        }
        return null;
    }
}
