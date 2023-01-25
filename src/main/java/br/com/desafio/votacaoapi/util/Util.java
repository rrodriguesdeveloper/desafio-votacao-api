package br.com.desafio.votacaoapi.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.util.Collection;

/**
 * Classe útil de uso geral
 */
public interface Util {

    /**
     * Método responsável por verificar se está nulo ou vazio
     * @param valor
     * @return boolean
     */
    static boolean estaNuloOuVazio(Object valor) {
        return estaNulo(valor) || estaVazio(valor);
    }

    /**
     * Méotodo responsável por verificar se está nulo
     * @param valor
     * @return boolean
     */
    static boolean estaNulo(Object valor) {
        return valor == null;
    }

    /**
     * Método responsável por verificar se está vazio uma collection
     * @param valor
     * @return boolean
     */
    static boolean estaVazio(Object valor) {
        return valor instanceof Collection ? ((Collection) valor).isEmpty() : "".equals(valor.toString().trim());
    }

    /**
     * Método responsável por converter uma string em um json
     * @param object
     * @return String
     */
    static String toJson(Object object) {
        ObjectWriter ow = new ObjectMapper().writer();

        String mensagem = null;

        try {
            mensagem = ow.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return mensagem;
    }

}
