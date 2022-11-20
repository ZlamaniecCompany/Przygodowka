package com.example.przygodwka

import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import kotlinx.android.synthetic.main.activity_strona_gry.*

class Fabula  (val gs: StronaGry) {

    var nastepnyPunkt1 = "";
    var nastepnyPunkt2 = "";
    var nastepnyPunkt3 = "";
    var superMiecz = false
    var dzwignia = false
    var smiercPotwora = false

    fun wyborPunktu(punkt: String){

        when(punkt){
            "punktStartowy" -> punktStartowy()
            "miecz" -> miecz()
            "potwor" -> potwor()
            "pulapka" -> pulapka()
            "stronaStartowa" -> gs.stronaStartowa()
            "ucieczka" -> ucieczka()
            "gameover" -> gameover()
            "atak" -> atak()
            "sukces" -> sukces()
            "smierc" -> smierc()
            "picie" -> picie()
            "mycie" -> mycie()
            "doPrzodu" -> doPrzodu()
            "skrzynia" -> skrzynia()
            "wygrana" -> wygrana()

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

        gs.wyborButton2.setVisibility(VISIBLE)
        gs.wyborButton3.setVisibility(VISIBLE)


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


    fun potwor() {

        if (smiercPotwora == false) {


            gs.tlo.setBackgroundResource(R.drawable.potwor)
            gs.gameTextView.setText("Natrafiasz na dziwną postać.\n\nŻle jej z oczu patrzy.\n\nSzybka decyzja, co robimy?")

            gs.wyborButton1.setText("Atakuj")
            gs.wyborButton2.setText("Uciekaj")
            gs.wyborButton3.setText("")
            gs.wyborButton3.setVisibility(INVISIBLE)


            nastepnyPunkt1 = "atak"
            nastepnyPunkt2 = "ucieczka"
            nastepnyPunkt3 = "punktStartowy"
        }
        if(smiercPotwora==true){
            doPrzodu()
        }
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

    fun picie(){
        gs.tlo.setBackgroundResource(R.drawable.ded)
        gs.gameTextView.setText("Woda okazała się być niezdatna do picia. Wielka szkoda\n\nUmierasz")

        gs.wyborButton1.setText("KONIEC")
        gs.wyborButton2.setVisibility(INVISIBLE)
        gs.wyborButton3.setVisibility(INVISIBLE)


        nastepnyPunkt1 = "gameover"
        nastepnyPunkt2 = "gameover"
        nastepnyPunkt3 = "gameover"


    }

    fun mycie(){
        gs.tlo.setBackgroundResource(R.drawable.podwoda)
        gs.gameTextView.setText("Zanurzyłeś się podczas mycia i zauważyłeś pod wodą jakąś dźwignie, ciekawe co robi?")

        dzwignia=true

        gs.wyborButton1.setText("Przełóż dźwignie i wracaj")
        gs.wyborButton2.setText("")
        gs.wyborButton3.setText("")
        gs.wyborButton2.setVisibility(INVISIBLE)
        gs.wyborButton3.setVisibility(INVISIBLE)

        nastepnyPunkt1 = "punktStartowy"



    }


    fun ucieczka(){
        gs.tlo.setBackgroundResource(R.drawable.ded)
        gs.gameTextView.setText("Uciekajac potykasz się o kamień.\n\nPotwór dogania ciebie i zadaje cios.\n\nUmierasz")

        gs.wyborButton1.setText("KONIEC")
        gs.wyborButton2.setVisibility(INVISIBLE)
        gs.wyborButton3.setVisibility(INVISIBLE)


        nastepnyPunkt1 = "gameover"
        nastepnyPunkt2 = "gameover"
        nastepnyPunkt3 = "gameover"
    }

    fun gameover(){
        gs.tlo.setBackgroundResource(R.drawable.gameover)
        gs.gameTextView.setText("Umarłeś!.\n\nTwoja przygoda tutaj się kończy.\n\nKONIEC GRY")

        gs.wyborButton1.setText("Wróć do strony startowej")
        gs.wyborButton2.setVisibility(INVISIBLE)
        gs.wyborButton3.setVisibility(INVISIBLE)

        nastepnyPunkt1 = "stronaStartowa"
        nastepnyPunkt2 = "stronaStartowa"
        nastepnyPunkt3 = "stronaStartowa"
    }

    fun atak() {

        if (superMiecz == false) {

            gs.tlo.setBackgroundResource(R.drawable.potworzly)
            gs.gameTextView.setText("Potwór jest za silny, musimy uciekać")

            gs.wyborButton1.setText("Uciekaj")
            gs.wyborButton2.setVisibility(INVISIBLE)
            gs.wyborButton3.setVisibility(INVISIBLE)


            nastepnyPunkt1 = "punktStartowy"
            nastepnyPunkt2 = "punktStartowy"
            nastepnyPunkt3 = "punktStartowy"
        }
        if(superMiecz == true){
            gs.tlo.setBackgroundResource(R.drawable.potworded)
            gs.gameTextView.setText("Udało ci się pokonać potwora! Nieźle mahasz tym mieczem...")

            gs.wyborButton1.setText("Idź dalej")
            gs.wyborButton2.setVisibility(INVISIBLE)
            gs.wyborButton3.setVisibility(INVISIBLE)


            nastepnyPunkt1 = "doPrzodu"
            nastepnyPunkt2 = "punktStartowy"
            nastepnyPunkt3 = "punktStartowy"

            smiercPotwora = true

        }
    }

    fun doPrzodu(){

        if(dzwignia==false){
            gs.tlo.setBackgroundResource(R.drawable.drzwi)
            gs.gameTextView.setText("Przed tobą ukazują się wrota, ale nie możesz ich otworzyć\nJak się przez nie przedostać?")

            gs.wyborButton1.setText("Idź dalej")
            gs.wyborButton2.setVisibility(INVISIBLE)
            gs.wyborButton3.setVisibility(INVISIBLE)


            nastepnyPunkt1 = "punktStartowy"
            nastepnyPunkt2 = "punktStartowy"
            nastepnyPunkt3 = "punktStartowy"
        }
        if(dzwignia==true){
            gs.tlo.setBackgroundResource(R.drawable.otwarte)
            gs.gameTextView.setText("Idąc dalej, przechodzisz przez otwarte wrota i twoim oczom ukazuje się skrzynia\nChyba nie muszę ci mówić co masz robić")

            gs.wyborButton1.setText("Otwórz skrzynie")
            gs.wyborButton2.setVisibility(INVISIBLE)
            gs.wyborButton3.setVisibility(INVISIBLE)


            nastepnyPunkt1 = "skrzynia"
            nastepnyPunkt2 = "punktStartowy"
            nastepnyPunkt3 = "punktStartowy"
        }



    }

    fun sukces(){
        gs.tlo.setBackgroundResource(R.drawable.miecz2)
        gs.gameTextView.setText("Brawo! Udało ci się zdobyć legendarny miecz\nMoze teraz uda ci się wydostać")

        superMiecz = true

        gs.wyborButton1.setText("Wróć do wyjścia")
        gs.wyborButton2.setText("Idź dalej")
        gs.wyborButton3.setText("")
        gs.wyborButton3.setVisibility(INVISIBLE)

        nastepnyPunkt1 = "punktStartowy"
        nastepnyPunkt2 = "smierc"


    }

    fun smierc(){
        gs.tlo.setBackgroundResource(R.drawable.ded)
        gs.gameTextView.setText("Twoja chciwość cię oszukała, miecz zwrócił się ku tobie.Umierasz.")

        gs.wyborButton1.setText("KONIEC")
        gs.wyborButton2.setVisibility(INVISIBLE)
        gs.wyborButton3.setVisibility(INVISIBLE)


        nastepnyPunkt1 = "gameover"
        nastepnyPunkt2 = "gameover"
        nastepnyPunkt3 = "gameover"

    }

    fun skrzynia(){
        gs.tlo.setBackgroundResource(R.drawable.las2)
        gs.gameTextView.setText("Po otwarciu skrzyni, nagle straciłeś przytomność.Ponownie się budzisz lecz tym razem w miejscu, które jest ci bardziej znajome.Udało ci się wydostać z jaskinii.GRATULACJE!")

        gs.wyborButton1.setText("KONIEC")
        gs.wyborButton2.setVisibility(INVISIBLE)
        gs.wyborButton3.setVisibility(INVISIBLE)


        nastepnyPunkt1 = "wygrana"
        nastepnyPunkt2 = "gameover"
        nastepnyPunkt3 = "gameover"

    }

    fun wygrana(){

        gs.tlo.setBackgroundResource(R.drawable.wygrana)
        gs.gameTextView.setText("Wygrałeś grę!Czy chcesz ponownie przeżyć przygodę?")

        gs.wyborButton1.setText("Wróć do strony startowej")
        gs.wyborButton2.setVisibility(INVISIBLE)
        gs.wyborButton3.setVisibility(INVISIBLE)

        nastepnyPunkt1 = "stronaStartowa"
        nastepnyPunkt2 = "stronaStartowa"
        nastepnyPunkt3 = "stronaStartowa"
    }



}