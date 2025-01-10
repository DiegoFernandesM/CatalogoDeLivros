package CatalogoDeLivros;

import CatalogoDeLivros.util.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private Principal principal;

    public Main(Principal principal) {
        this.principal = principal;
    }

    public static void main(String[] args) {
        SpringApplication.run(CatalogoDeLivros.Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        principal.executar();
    }
}