package br.com.alan.calc.modelo;

@FunctionalInterface
public interface MemoriaObservador {

    void valorAlterado(String novoValor);
}
