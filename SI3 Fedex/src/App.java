
import view.MainView;

public class App {

    // Método principal que inicia a aplicação
    public static void main(String[] args) throws Exception {
        // Garante que a criação e atualização da interface gráfica seja feita na thread correta do Swing
        javax.swing.SwingUtilities.invokeLater(() -> {
            // Instancia a tela principal e a torna visível
            new MainView().setVisible(true);
        });
    }
}
