import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import onerme.controller.GameController;
import onerme.utilities.FakeInputProvider;
import onerme.service.Language;
import onerme.service.ResultEvaluator;
import onerme.service.GameEngine;
import onerme.model.player.Player;
import onerme.model.player.HumanPlayer;
import onerme.model.player.ComputerPlayer;
import onerme.factory.concreteFactory.RockPaperScissorsFactory;
import java.util.ResourceBundle;
import java.util.Locale;

public class GameControllerTest {

    @Test
    void testStart_PlayHumanVsComputer() {
        // FakeInputProvider kullanarak sırasıyla alınacak girişleri belirtiyoruz.
        FakeInputProvider inputProvider = new FakeInputProvider(
                "1",              // Dil seçimi: İngilizce
                "1",              // Dil seçimi: İngilizce
                "Player",        // Oyuncu adı
                "1",              // Oyun modu: İnsan vs Bilgisayar
                "5",              // Turlar: 5
                "2"               // Yeni oyun başlatmak istiyor mu? Hayır
        );

        // Language sınıfının mesajlarını ayarlıyoruz (İngilizce)
        Language.messages = ResourceBundle.getBundle("messages", Locale.ENGLISH);

        // GameController'ı başlatıyoruz
        GameController gameController = new GameController(inputProvider);

        // Oyun başlatılacak
        gameController.start();

        // Dilin doğru ayarlandığını kontrol ediyoruz.
        assertEquals(Locale.ENGLISH, Language.messages.getLocale());

        // Kullanıcıdan alınan oyuncu adı doğru olmalı
        assertEquals("Player1", inputProvider.getInput());

        // Kullanıcıdan alınan tur sayısı doğru olmalı
        assertEquals("5", inputProvider.getInput());

        // Oyuncu ve bilgisayarın oluşturulduğundan emin oluyoruz.
        Player player1 = new HumanPlayer("Player1", new RockPaperScissorsFactory(),inputProvider);
        Player player2 = new ComputerPlayer("Computer", new RockPaperScissorsFactory());

        // Oyun motoru başlatıyoruz
        GameEngine gameEngine = new GameEngine(player1, player2, 5, Language.messages);
        gameEngine.play();

        // Sonuçlar değerlendiriliyor
        ResultEvaluator resultEvaluator = new ResultEvaluator();
        resultEvaluator.evaluate(player1, player2, gameEngine);
    }

    @Test
    void testStart_PlayComputerVsComputer() {
        // FakeInputProvider kullanarak sırasıyla alınacak girişleri belirtiyoruz.
        FakeInputProvider inputProvider = new FakeInputProvider(
                "1",              // Dil seçimi: İngilizce
                "3",              // Oyun modu: Bilgisayar vs Bilgisayar
                "10",             // Turlar: 10
                "2"               // Yeni oyun başlatmak istiyor mu? Hayır
        );

        // Language sınıfının mesajlarını ayarlıyoruz (İngilizce)
        Language.messages = ResourceBundle.getBundle("messages", Locale.ENGLISH);

        // GameController'ı başlatıyoruz
        GameController gameController = new GameController(inputProvider);

        // Oyun başlatılacak
        gameController.start();

        // Dilin doğru ayarlandığını kontrol ediyoruz.
        assertEquals(Locale.ENGLISH, Language.messages.getLocale());

        // Oyun modunun bilgisayar vs bilgisayar olduğundan emin oluyoruz.
        assertEquals("3", inputProvider.getInput());

        // Oyuncu ve bilgisayar oluşturuluyor, ancak burada oyuncu adını kullanmamıza gerek yok çünkü bu modda bilgisayar vs bilgisayar.
        Player player1 = new ComputerPlayer("Computer 1", new RockPaperScissorsFactory());
        Player player2 = new ComputerPlayer("Computer 2", new RockPaperScissorsFactory());

        // Oyun motoru başlatıyoruz
        GameEngine gameEngine = new GameEngine(player1, player2, 10, Language.messages);
        gameEngine.play();

        // Sonuçlar değerlendiriliyor
        ResultEvaluator resultEvaluator = new ResultEvaluator();
        resultEvaluator.evaluate(player1, player2, gameEngine);
    }
}
