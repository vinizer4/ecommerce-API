package io.github.vinizer4;

import io.github.vinizer4.domain.entity.Cliente;
import io.github.vinizer4.domain.repositorio.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes) {
        return args -> {
            System.out.println("Salvando clientes");
            clientes.salvar(new Cliente("Douglas"));
            clientes.salvar(new Cliente("Outro Cliente"));

            System.out.println("Listando clientes");
            List<Cliente> todosClientes = clientes.obterTodos();
            todosClientes.forEach(System.out::println);

            System.out.println("Atualizando clientes");
            todosClientes.forEach(c -> {
                c.setNome(c.getNome() + " atualizado.");
                clientes.atualizar(c);
            });

            todosClientes = clientes.obterTodos();
            todosClientes.forEach(System.out::println);

            System.out.println("Buscando por nome");
            clientes.buscarPorNome("Cli").forEach(System.out::println);

//            System.out.println("Deletendo clientes");
//            clientes.obterTodos().forEach(c -> {
//                clientes.deletar(c);
//            });

            System.out.println("Listando todo clientes");
            todosClientes = clientes.obterTodos();
            if(todosClientes.isEmpty()) {
                System.out.println("Nenhum cliente encontrado");
            } else {
                todosClientes.forEach(System.out::println);
            }

        };


    };

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}