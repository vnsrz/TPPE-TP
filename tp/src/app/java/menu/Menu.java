package menu;

import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;
import utils.Resources;
import customer.Customer;
import customer.CustomerType;
import product.Product;

public class Menu {
    private final List<Customer> customers;
    private final List<Product> products;

    public Menu() {
        customers = new ArrayList<>();
        seedCustomers();
        products = new ArrayList<>();
        seedProducts();
    }

    private void seedCustomers() {
        customers.add(new Customer("João", CustomerType.STANDARD, "Brasília", true));
        customers.add(new Customer("Maria", CustomerType.SPECIAL, "Rio de Janeiro", false));
        customers.add(new Customer("Pedro", CustomerType.PRIME, "São Paulo", true));
    }

    private void seedProducts() {
        products.add(new Product(1, "Bola de praia", 15.5, "unidade"));
        products.add(new Product(2, "Bastão de cola", 5, "unidade"));
        products.add(new Product(3, "Tecido azul", 9.99, "metro"));
    }

    public void start() {
        System.out.println("Bem-vindo ao sistema de gerenciamento de clientes e vendas!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar cliente");
            System.out.println("2. Cadastrar produto");
            System.out.println("3. Realizar venda");
            System.out.println("4. Calcular vendas do último mês para cada cliente");
            System.out.println("5. Verificar status de cliente especial");
            System.out.println("6. Calcular saldo de cashback para clientes prime");
            System.out.println("7. Lista Clientes");
            System.out.println("8. Lista Produtos");
            System.out.println("0. Sair");

            int choice = Resources.readInt("Escolha uma opção");

            switch (choice) {
                case 1:
                    registerCustomer();
                    break;
                case 2:
                    registerProduct();
                    break;
                case 3:
                    System.out.println("Não implementado");
                    break;
                case 4:
                    System.out.println("Não implementado");
                    break;
                case 5:
                    System.out.println("Não implementado");
                    break;
                case 6:
                    System.out.println("Não implementado");
                    break;
                case 7:
                    listCustomers();
                    break;
                case 8:
                    listProducts();
                    break;    
                case 0:
                    System.out.println("Saindo do sistema...");
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }

    public boolean hasProductWithCode(int code) {
        for (Product product : products) {
            if (product.getCode() == code) {
                return true;
            }
        }
        return false;
    }

    private void registerCustomer() {
        System.out.println("\nCadastro de Cliente:");

        String name = Resources.readString("Nome");
        int typeChoice = Resources.readInt("Tipo (1 - Padrão, 2 - Especial, 3 - Prime)");
        CustomerType type = switch (typeChoice) {
            case 1 -> CustomerType.STANDARD;
            case 2 -> CustomerType.SPECIAL;
            case 3 -> CustomerType.PRIME;
            default -> {
                System.out.println("Tipo inválido. Será cadastrado como padrão.");
                yield CustomerType.STANDARD;
            }
        };

        String state = Resources.readString("Estado");
        boolean isCapital = Resources.readBoolean("É capital? (0 - Sim / 1 - Não)");

        Customer newCustomer = new Customer(name, type, state, isCapital);
        customers.add(newCustomer);

        System.out.println("Cliente cadastrado com sucesso!");
    }

    private void registerProduct() {
        System.out.println("\nCadastro de Produto:");

        int code = Resources.readInt("Código");
        while(hasProductWithCode(code)){
            System.out.println("\nCódigo já cadastrado.");
            code = Resources.readInt("Digite outro código");
        }
        String description = Resources.readString("Descrição");
        double price = Resources.readDouble("Preço");
        String unit = Resources.readString("Unidade");
        
        Product newProduct = new Product(code, description, price, unit);
        products.add(newProduct);

        System.out.println("Produto cadastrado com sucesso!");
    }

    private void listCustomers() {
        System.out.println("\nLista de Clientes:");

        if (customers.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            for (int i = 0; i < customers.size(); i++) {
                Customer customer = customers.get(i);
                System.out.println("Cliente " + (i + 1) + ":");
                System.out.println("Nome: " + customer.getName());
                System.out.println("Tipo: " + customer.getType());
                System.out.println("Estado: " + customer.getState());
                System.out.println("Capital: " + (customer.isCapital() ? "Sim" : "Não"));
                System.out.println("------------------------------");
            }
        }
    }

    private void listProducts() {
        System.out.println("\nLista de Produtos:");

        if (products.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            for (int i = 0; i < products.size(); i++) {
                Product product = products.get(i);
                System.out.println("Produto " + (i + 1) + ":");
                System.out.println("Codigo: " + product.getCode());
                System.out.println("Descrição: " + product.getDescription());
                System.out.println("Preço: " + product.getPrice());
                System.out.println("Unidade: " + product.getUnit());
                System.out.println("------------------------------");
            }
        }
    }
}
