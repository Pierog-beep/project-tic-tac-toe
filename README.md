# Gra w "Kółko i Krzyżyk"
Prosta aplikacja z interfejsem graficznym umożliwiająca gre w kółko i krzyżyk przeciwko komputerowi.

## Opis:
Program oferuje klasyczną rozgrywkę w kółko i krzyżyk z wykorzystaniem własnego algorytmu przeciwnika.

Interfejs graficzny składa się z:
- 9 przycisków tworzących planszę 3x3,
- etykiety wyświetlającej wynik gry,
- przycisku resetującego rozgrywkę.

Użytkownik może zmierzyć się z algorytmem, którego zachowanie można modyfikować za pomocą parametrów:
- `blocking_parameter`
- `winning_parameter`

Aplikacja została zaprojektowana modularnie, co umożliwia łatwą podmianę algorytmu na własny.

## Algorytm 
Algorytm analizuje wszystkie możliwe linie zwycięstwa (łącznie 8: 3 wiersze, 3 kolumny, 2 przekątne).

Dla każdej linii:
1. Zlicza pola zajęte przez gracza i komputer,
2. Odrzuca linie już zablokowane (w pełni zajęte),
3. Oblicza wynik na podstawie wag (`blocking_parameter`, `winning_parameter`),
4. Wybiera linię o najwyższym wyniku,
5. Zajmuje pierwsze dostępne pole w tej linii.

## Ograniczenia:
- Algorytm nie gwaratnruje wygranej ani remisu,
- Nie zawsze wybiera optymalne pole lini. 

## Dalszy rozwój: 
- Ulepszenie interface'u graficznego,
- Implementacja bardziej zaawansowanego algorytmu. 
