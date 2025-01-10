package CatalogoDeLivros.Service;

import CatalogoDeLivros.Model.DadosLivros;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConverteDados implements IconverteDados {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public <T> T obterDados(String json, Class<T> classe) {
        try {
            return objectMapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public List<DadosLivros> obterListaDeLivros(String json) {
        try {
            CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(List.class, DadosLivros.class);
            return objectMapper.readValue(json, listType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}