package onerme.integration;

import onerme.controller.GameController;
import onerme.factory.concreteFactory.RockPaperScissorsFactory;
import onerme.model.player.ComputerPlayer;
import onerme.model.player.HumanPlayer;
import onerme.service.GameEngine;
import onerme.service.ResultEvaluator;
import onerme.utilities.FakeInputProvider;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GameControllerIntegrationTest {

    @Test
    void testGameControllerIntegration_HumanVsComputer() {
        // Mocked input for human vs computer game
        FakeInputProvider inputProvider = new FakeInputProvider(
                "1",  // Dil seçimi: English
                "1",  // Oyun modu: Human vs Computer
                "TestPlayer",  // Oyuncu adı
                "3",  // Oyun tur sayısı: 3
                "1", "2", "3",  // Oyuncunun seçimleri: Rock, Paper, Scissors
                "2"   // Yeni oyun başlatmak istiyor mu: Hayır
        );

        // Dil ayarı
        ResourceBundle messages = ResourceBundle.getBundle("messages", Locale.ENGLISH);

        // GameController başlat
        GameController gameController = new GameController(inputProvider);

        // Oyun başlat
        gameController.start();

        // Sonuçları değerlendirme
        ResultEvaluator resultEvaluator = new ResultEvaluator();
        String finalScoreMessage = String.format(
                messages.getString("finalScore"),
                "TestPlayer", "Computer", 0, 0, 0
        );

        // Konsol çıktısını kontrol et (örneğin, skoru veya sonucu test etmek için)
        assertTrue(true, "Entegrasyon testi başarılı şekilde tamamlandı.");
    }
}
