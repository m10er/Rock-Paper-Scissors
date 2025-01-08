# Rock-Paper-Scissors

1. Einführung
   Überblick: Zu Beginn des Projekts haben wir das Rock-Paper-Scissors (Schere, Stein, Papier) Spiel entwickelt, um die Bedürfnisse eines Benutzers zu erfüllen. Das Ziel des Spiels ist es, den Spielern sowohl Unterhaltung zu bieten als auch die Agile-Prinzipien und Best Practices in der Softwareentwicklung zu befolgen.
   Ziel: Das Ziel dieses Projekts war es, eine einfache, aber erweiterbare Spielstruktur zu entwickeln und gleichzeitig die Anforderungen der Benutzerstory zu erfüllen.
2. Details der Benutzerstory
   Titel: Waste an Hour Having Fun
   Ich bin ein: Häufiger Spieler
   Ich möchte: Rock, Paper, Scissors spielen
   Damit: Ich kann eine Stunde meines Tages mit Spaß verbringen.
   Akzeptanzkriterien:

Der Spieler kann im Player vs Computer (Spieler gegen Computer) Modus spielen.
Der Spieler kann im Computer vs Computer (Computer gegen Computer) Modus spielen.
Das Spiel bietet bei jedem Versuch eine andere Spielerfahrung.
Technische Einschränkungen:

Ein aufwendiges GUI ist nicht erforderlich (eine einfache Benutzeroberfläche reicht aus).
Es sollte Java oder eine andere objektorientierte Sprache verwendet werden.
Externe Bibliotheken sollten nur für Tests verwendet werden.
Das Projekt sollte den Prinzipien der Agile-Softwareentwicklung folgen.
Leitlinien:

Das Projekt sollte etwa 5 Stunden in Anspruch nehmen, je nach Umfang der Benutzeroberfläche.
Der Fokus liegt auf Tests.
Das Minimum Viable Product (MVP) sollte angestrebt werden, wobei Einfachheit bevorzugt wird.
Der Code sollte erweiterbar sein (zum Beispiel könnte das Spiel um neue Regeln wie "Rock-Paper-Scissors-Lizard-Spock" erweitert werden).
3. Details der Implementierung
   Verwendete Sprachen und Werkzeuge: Wir haben Java verwendet, da es eine objektorientierte Sprache ist, die gut für Konsolenanwendungen geeignet ist. Für die Benutzereingabe haben wir die Scanner-Klasse genutzt, und eine komplexe GUI wurde nicht implementiert (weil sie nicht notwendig war).
   Spiellogik:
   Die Move-Klasse repräsentiert die einzelnen Spielzüge (Stein, Papier, Schere).
   Die Player-Klasse und ihre zwei Unterklassen: HumanPlayer und ComputerPlayer.
   Die Hauptspiellogik befindet sich in der GameEngine-Klasse, die die Runden, Punkte und den Spielfluss verwaltet.
   Spielmodi: Es gibt zwei Spielmodi:
   Player vs Computer (Spieler gegen Computer) – Der Spieler wählt seinen Zug, der Computer wählt einen zufälligen Zug.
   Computer vs Computer (Computer gegen Computer) – Zwei Computer spielen gegeneinander.
   Spielergebnisse:
   Jede Runde endet mit einem Gewinn, Verlust oder Unentschieden.
   Punkte und die Anzahl der Unentschieden werden verfolgt und angezeigt.
   Zusätzliche Features:

Am Ende des Spiels wird der Spieler gefragt, ob er erneut spielen möchte.
Das Spiel unterstützt zwei Sprachen (Englisch und Deutsch), und die grundlegende Lokalisierung wurde mit ResourceBundle realisiert.
Das Spiel ist so konzipiert, dass es in Zukunft leicht um neue Züge oder Regeln erweitert werden kann.
4. Teststrategie
   Unit-Tests: Das Projekt wurde mit Unit-Tests für die wichtigsten Klassen (z. B. Move, GameEngine, Player) getestet. Diese Tests stellen sicher, dass das Spiel korrekt funktioniert (z. B. ob ein Zug den anderen schlägt).
   Testabdeckung: Alle funktionalen Methoden wurden getestet.
   Zum Beispiel wurde die beats()-Methode getestet, um sicherzustellen, dass die Züge korrekt miteinander interagieren.
   Testfälle:
   Player vs Computer: Überprüfung, ob die Züge des Spielers und des Computers die richtigen Ergebnisse liefern.
   Computer vs Computer: Sicherstellen, dass zwei Computer problemlos gegeneinander spielen können.
   Unentschieden zählen: Überprüfen, ob Unentschieden korrekt verfolgt und angezeigt werden.
5. Agile-Prinzipien
   Inkrementelle Entwicklung: Das Spiel wurde schrittweise entwickelt. Zunächst wurde die Grundfunktionalität (Player vs Computer) implementiert, danach wurden weitere Features wie der Computer vs Computer-Modus und die Mehrsprachigkeit hinzugefügt.
   Minimum Viable Product (MVP): Zunächst wurde ein einfaches und funktionales Spiel erstellt, bevor zusätzliche Funktionen hinzugefügt wurden.
   Code-Refactoring: Der Code wurde in jeder Phase so umstrukturiert, dass er einfach, lesbar und wartbar bleibt. Zum Beispiel ist die Move-Klasse so konzipiert, dass neue Züge oder Regeln einfach hinzugefügt werden können.
   Benutzerstorys und Aufgaben: Jede Funktion wurde gemäß einer bestimmten Benutzerstory entwickelt und in Aufgaben unterteilt. Dieser Prozess wurde iterativ mit kontinuierlichem Feedback durchgeführt.
   Kontinuierliche Integration: Der Code wurde regelmäßig getestet und in das Repository integriert, sodass neue Funktionen bestehende Funktionen nicht beeinträchtigen.
6. Herausforderungen und Lösungen
   Sprachlokalisierung: Das Spiel unterstützt zwei Sprachen, was eine Herausforderung darstellte. Dieses Problem wurde jedoch erfolgreich mit der ResourceBundle-Klasse in Java gelöst.
   Unentschieden zählen: Zu Beginn wurde das Zählen der Unentschieden übersehen. Dies wurde jedoch behoben, indem nach jedem Spielzug die Unentschieden gezählt und angezeigt wurden.
   Erweiterbarkeit: Das Spiel wurde so entwickelt, dass es in Zukunft leicht erweiterbar ist, z. B. um neue Spielzüge oder Regeln.
7. Fazit
   Das Projekt erfüllt die Akzeptanzkriterien der Benutzerstory erfolgreich.
   Agile-Prinzipien wurden befolgt, und der Code ist einfach, wartbar und erweiterbar.
   Tests wurden gründlich durchgeführt, und die gesamte Spiellogik sowie die Funktionen wurden getestet.
   Der Code ist so strukturiert, dass er problemlos in der Zukunft erweitert werden kann.
8. Zukünftige Verbesserungen
   GUI-Anwendung: Das Spiel wurde als einfache Konsolenanwendung entwickelt, könnte jedoch später mit einer grafischen Benutzeroberfläche (z. B. JavaFX) erweitert werden.
   Rock-Paper-Scissors-Lizard-Spock: Die Spielregeln und Züge können leicht um neue Optionen erweitert werden.
   Verbesserungen der KI: Die Intelligenz des Computergegners könnte verbessert werden, indem er auf vergangene Ergebnisse reagiert und strategischere Entscheidungen trifft.
9. Build-Anweisungen
   Wie man das Spiel ausführt: Der Java-Code kann mit dem javac-Befehl kompiliert und mit dem java-Befehl ausgeführt werden.
   Tests: JUnit oder andere Testwerkzeuge können verwendet werden, um die Tests auszuführen.
