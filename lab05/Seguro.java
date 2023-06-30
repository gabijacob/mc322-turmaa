package lab05;
import java.util.*;

public abstract class Seguro {
    protected final int id_seguro;
    protected Date dataInicio_seguro;
    protected Date dataFim_seguro;
    protected Seguradora seguradora_seguro;
    protected ArrayList<Sinistro> listaSinistros_seguro;
    protected ArrayList<Condutor> listaCondutores_seguro;
    protected double valorMensal_seguro;

    public Seguro(Date dataInicio, Date dataFim, Seguradora seguradora, ArrayList<Sinistro> listaSinistros, ArrayList<Condutor> listaCondutores){
        this.id_seguro = setId();
        this.dataInicio_seguro = dataInicio;
        this.dataFim_seguro = dataFim;
        this.seguradora_seguro = seguradora;
        this.listaSinistros_seguro = listaSinistros;
        this.listaCondutores_seguro = listaCondutores;
        this.valorMensal_seguro = calcularValor();
    }

    public int getId_seguro() {
        return id_seguro;
    }

    public int setId(){
        int max = 9999;
        int min = 1;
        int range = max - min + 1;

        // gerando numeros aleatórios de id entre 1 e 9999
        int id = (int)(Math.random() * range) + min;
        return id;
    }

    public Date getDataInicio_seguro() {
        return dataInicio_seguro;
    }

    public void setDataInicio_seguro(Date dataInicio_seguro) {
        this.dataInicio_seguro = dataInicio_seguro;
    }

    public Date getDataFim_seguro() {
        return dataFim_seguro;
    }

    public void setDataFim_seguro(Date dataFim_seguro) {
        this.dataFim_seguro = dataFim_seguro;
    }

    public Seguradora getSeguradora_seguro() {
        return seguradora_seguro;
    }

    public void setSeguradora_seguro(Seguradora seguradora_seguro) {
        this.seguradora_seguro = seguradora_seguro;
    }

    public ArrayList<Sinistro> getListaSinistros_seguro() {
        return listaSinistros_seguro;
    }

    public void setListaSinistros_seguro(ArrayList<Sinistro> listaSinistros_seguro) {
        this.listaSinistros_seguro = listaSinistros_seguro;
    }

    public ArrayList<Condutor> getListaCondutores_seguro() {
        return listaCondutores_seguro;
    }

    public void setListaCondutores_seguro(ArrayList<Condutor> listaCondutores_seguro) {
        this.listaCondutores_seguro = listaCondutores_seguro;
    }

    public double getValorMensal_seguro() {
        return valorMensal_seguro;
    }

    public void setValorMensal_seguro(double valorMensal) {
        this.valorMensal_seguro = valorMensal;
    }

    public abstract boolean autorizarCondutor();

    public abstract boolean autorizarCondutor(Condutor condutor);

    public abstract boolean desautorizarCondutor(Condutor condutor);

    public abstract double calcularValor();

    public abstract boolean gerarSinistro(Seguro seguro);
    
    public abstract boolean gerarSinistro(Sinistro sinistro);
    
    public Condutor procuraCondutor(String cnpj){
        for(Condutor condutor_iterado : listaCondutores_seguro){
            if(condutor_iterado.getCpf_condutor().equals(cnpj)){
                return condutor_iterado;
            }
        }
        return null;
    }
    public String toString(){
        String listaSinistros_str = "";
        for(Sinistro sinistro_iterarado: listaSinistros_seguro){
            listaSinistros_str += sinistro_iterarado.getId() + "\n";
        }

        String listaCondutores_str = "";
        for(Condutor condutor_iterado: listaCondutores_seguro){
            listaCondutores_str += condutor_iterado.getCpf_condutor() + "\n";
        }

        return "ID do seguro: " + this.id_seguro + "\nData de início do seguro: " + this.dataInicio_seguro + "\nData do fim do seguro: " + this.dataFim_seguro + "\nSeguradora: " + this.seguradora_seguro.getNome_seguradora() + "\nLista de sinistros: " + listaSinistros_str + "\nLista de Condutores: " + listaCondutores_str;
    }
}
