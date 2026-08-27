import java.util.Scanner;
public class Principal {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
 
        Livro livro = new Livro();
        CD cd = new CD();
 

        System.out.println("Digite o nome do livro:");
        livro.setNome(entrada.nextLine());
 
        System.out.println("Digite o preço do livro:");
        livro.setPreco(entrada.nextDouble());
                entrada.nextLine();
 
        System.out.println("Digite o autor do livro:");
        livro.setAutor(entrada.nextLine());
 

        System.out.println("Digite o nome do cd:");
        cd.setNome(entrada.nextLine());
 
        System.out.println("Digite o preço do cd:");
        cd.setPreco(entrada.nextDouble());
        entrada.nextLine();
 
        System.out.println("Digite o número de faixas do cd:");
        cd.setNumFaixas(entrada.nextInt());
 

        System.out.println("Nome livro: " + livro.getNome());
        System.out.println("Preço do livro: " + livro.getPreco());
        System.out.println("Autor do livro: " + livro.getAutor());
 
        System.out.println("Nome do cd: " + cd.getNome());
        System.out.println("Preço do cd: " + cd.getPreco());
        System.out.println("Número de faixas: " + cd.getNumFaixas());
    }
}
 