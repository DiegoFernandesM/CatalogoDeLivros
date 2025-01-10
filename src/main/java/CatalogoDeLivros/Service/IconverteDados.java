 package CatalogoDeLivros.Service;

public interface IconverteDados {
    <T> T  obterDados(String json, Class<T> classe);
}