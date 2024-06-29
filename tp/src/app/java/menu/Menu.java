package menu;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import customer.Customer;
import customer.CustomerType;
import sales.Sale;
import utils.Resources;

public class Menu {
    private final List<Customer> customers;

    public Menu() {
        customers = new ArrayList<>();
        seedCustomers();
    }

    private void seedCustomers() {
        Customer joao = new Customer("João", CustomerType.STANDARD, "Brasília", true);
        joao.addSale(new Sale(500.0, LocalDate.now().minusDays(10)));
        joao.addSale(new Sale(200.0, LocalDate.now().minusDays(15)));
        customers.add(joao);

        Customer maria = new Customer("Maria", CustomerType.SPECIAL, "Rio de Janeiro", false);
        maria.addSale(new Sale(1200.0, LocalDate.now().minusDays(20)));
        customers.add(maria);

        Customer pedro = new Customer("Pedro", CustomerType.PRIME, "São Paulo", true);
        pedro.addSale(new Sale(800.0, LocalDate.now().minusDays(30)));
        pedro.addSale(new Sale(400.0, LocalDate.now().minusDays(5)));
        customers.add(pedro);

        Customer Bruna = new Customer("Bruna", CustomerType.SPECIAL, "São Paulo", true);
        Bruna.addSale(new Sale(800.0, LocalDate.now().minusDays(30)));
        Bruna.addSale(new Sale(400.0, LocalDate.now().minusDays(5)));
        customers.add(Bruna);
        //customers.add(new Customer("Maria", CustomerType.SPECIAL, "Rio de Janeiro", false));
        //customers.add(new Customer("Pedro", CustomerType.PRIME, "São Paulo", true));
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
            System.out.println("0. Sair");
            System.out.println("9. Lista Clientes");
            System.out.print("\nEscolha uma opção: ");

            int choice = Resources.readInt("Escolha uma opção");

            switch (choice) {
                case 1:
                    registerCustomer();
                    break;
                case 2:
                    System.out.println("Não implementado");
                    break;
                case 3:
                    System.out.println("Não implementado");
                    break;
                case 4:
                    calculateSalesLastMonth();
                    break;
                case 5:
                    checkSpecialStatus();
                    break;
                case 6:
                    System.out.println("Não implementado");
                    break;
                case 9:
                    listCustomers();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
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

    private void calculateSalesLastMonth() {
        System.out.println("\nCalculando vendas do último mês para cada cliente:");
        for (Customer customer : customers) {
            double salesLastMonth = customer.getSalesLastMonth();
            System.out.println("Cliente: " + customer.getName() + " - Vendas do último mês: R$ " + salesLastMonth);
        }
    }

    private void checkSpecialStatus() {
        System.out.println("\nVerificando status de clientes especiais:");
        for (Customer customer : customers) {
            boolean isSpecialEligible = customer.isEligibleForSpecial();
            System.out.println("Cliente: " + customer.getName() + " - Elegível para ser especial: " + (isSpecialEligible ? "Sim" : "Não"));
        }
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
}
