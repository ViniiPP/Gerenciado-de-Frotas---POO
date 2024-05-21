import java.util.ArrayList;
import java.util.List;

public class Utilidades {
    private final List<Carro> lista;

    public Utilidades() {
        lista = new ArrayList<>();
    }

    public List<Carro> getList(){
        return lista;
    }

    // ADICIONAR VEICULO
    public void adicionarVeiculo(Carro carro) throws Exception {
        if (carro.getTipo() == null || carro.getTipo().isEmpty()){
            throw new Exception("O tipo do veículo não pode ser nulo.");
        }
        if (carro.getMarca() == null || carro.getMarca().isEmpty()) {
            throw new Exception("A marca do veículo não pode ser nulo.");
        }
        if(carro.getModelo() == null || carro.getModelo().isEmpty()) { 
            throw new Exception("O modelo do veículo não pode ser nulo.");
        }
        if(carro.getAno() < 0) { 
            throw new Exception("O ano deve ser maior que 0.");
        }
        if(carro.getNumeroPortas() < 0 && carro.getTipo().equalsIgnoreCase("carro") ) {
            throw new Exception("O carro deve ter um número de portas maior que 0.");
        }
        if(carro.getPlaca() == null || carro.getPlaca().isEmpty()) { 
            throw new Exception("A placa é obrigatória.");
        }
        for (Carro L : lista){
            if(L.getPlaca().equalsIgnoreCase(carro.getPlaca())) {
                throw new Exception("Já existe um carro com essa placa cadastrado.");
            }
        }

        lista.add(carro);

    }

    // REMOVER
    public void removerVeiculo(Carro carro) {
        lista.remove(carro);
    }

    // LISTAR OS VEÍCULOS
    public void listaVeiculo() {
        if(lista.isEmpty()){
            System.out.println("Não há veículos para serem listados.");
            return;
        }
        System.out.println("=== Veículos na Lista ===");
        for (Carro carro : lista){
            System.out.println(carro);
        }
    }

    // BUSCAR
    public Carro buscarCarro(String placa){
        for(Carro carro : lista){
            if(carro.getPlaca().equalsIgnoreCase(placa)){
                return carro;
            }
        }
        return null;
    }
}
