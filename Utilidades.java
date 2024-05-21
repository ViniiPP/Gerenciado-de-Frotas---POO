import java.util.ArrayList;
import java.util.List;

public class Utilidades {
    private List<Carro> lista;

    public Utilidades() {
        lista = new ArrayList<>();
    }

    public List<Carro> getList(){
        return lista;
    }

    // ADICIONAR
    public void adicionarVeiculo(Carro carro) throws Exception {
        if (carro.getMarca() == null || carro.getMarca().isEmpty()) {
            throw new Exception("A marca do veículo é obrigatório.");
        }
        if(carro.getModelo() == null || carro.getModelo().isEmpty()) { 
            throw new Exception("O modelo do veículo é obrigatório");
        }
        if(carro.getAno() < 1886) { 
            throw new Exception("O ano deve ser válido.");
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
