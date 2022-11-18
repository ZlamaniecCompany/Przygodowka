package com.example.przygodwka

import android.view.View
import kotlinx.android.synthetic.main.activity_strona_gry.*

class Fabula  (val gs: StronaGry) {

    var nastepnyPunkt1 = "";
    var nastepnyPunkt2 = "";
    var nastepnyPunkt3 = "";

    fun wyborPunktu(punkt: String){

        when(punkt){
            "punktStartowy" -> punktStartowy()
            "miecz" -> miecz()
            "potwor" -> potwor()
            "pulapka" -> pulapka()
            "stronaStartowa" -> gs.stronaStartowa()
            "ucieczka" -> ucieczka()
            "gameover" -> gameover()
        }
    }



    fun punktStartowy(){

        gs.tlo.setBackgroundResource(R.drawable.cave)
        gs.gameTextView.setText("Obudziłeś się w ciemnej jaskini.\n\nWidzisz przed sobą rozwidlenie.\n\nCo robisz?")

        gs.wyborButton1.setText("Idź przed siebie")
        gs.wyborButton2.setText("Skręć w prawo")
        gs.wyborButton3.setText("Skręć w lewo")

        nastepnyPunkt1 = "potwor"
        nastepnyPunkt2 = "pulapka"
        nastepnyPunkt3 = "miecz"

    }

    fun miecz(){

        gs.tlo.setBackgroundResource(R.drawable.miecz)
        gs.gameTextView.setText("Widzisz przed sobą miecz wbity w kamień.\n\nWygląda na rzadki artefakt.\n\nCo robisz?")

        gs.wyborButton1.setText("Spróbuj wyciągnąć miecz")
        gs.wyborButton2.setText("Odpuść i idź dalej")
        gs.wyborButton3.setText("Wróć")

        nastepnyPunkt1 = "sukces"
        nastepnyPunkt2 = "marsz"
        nastepnyPunkt3 = "punktStartowy"



    }
    fun potwor(){
        gs.tlo.setBackgroundResource(R.drawable.potwor)
        gs.gameTextView.setText("Natrafiasz na dziwną postać.\n\nŻle jej z oczu patrzy.\n\nSzybka decyzja, co robimy?")

        gs.wyborButton1.setText("Atakuj")
        gs.wyborButton2.setText("Uciekaj")
        gs.wyborButton3.setText("")




        nastepnyPunkt1 = "atak"
        nastepnyPunkt2 = "ucieczka"
        nastepnyPunkt3 = "punktStartowy"
    }

    fun pulapka(){
        gs.tlo.setBackgroundResource(R.drawable.pulapka)
        gs.gameTextView.setText("Znalazles źródełko wody po długim czasie.\n\nJesteś bardzo spragniony.\n\nCo robisz?")

        gs.wyborButton1.setText("Bierzesz łyk wody")
        gs.wyborButton2.setText("Wchodzisz cały do wody")
        gs.wyborButton3.setText("Szukasz wyjścia")

        nastepnyPunkt1 = "picie"
        nastepnyPunkt2 = "mycie"
        nastepnyPunkt3 = "punktStartowy"
    }

    fun ucieczka(){
        gs.tlo.setBackgroundResource(R.drawable.ded)
        gs.gameTextView.setText("Uciekajac potykasz się o kamień.\n\nPotwór dogania ciebie i zadaje cios.\n\nUmierasz")

        gs.wyborButton1.setText("UMARŁEŚ")
        gs.wyborButton2.setText("")
        gs.wyborButton3.setText("")

        nastepnyPunkt1 = "gameover"
        nastepnyPunkt2 = "gameover"
        nastepnyPunkt3 = "gameover"
    }

    fun gameover(){
        gs.tlo.setBackgroundResource(R.drawable.blak)
        gs.gameTextView.setText("Umarłeś!.\n\nTwoja przygoda tutaj się kończy.\n\nKONIEC GRY")

        gs.wyborButton1.setText("Wróć do strony startowej")
        gs.wyborButton2.setText("")
        gs.wyborButton3.setText("")

        nastepnyPunkt1 = "stronaStartowa"
        nastepnyPunkt2 = "stronaStartowa"
        nastepnyPunkt3 = "stronaStartowa"
    }


}