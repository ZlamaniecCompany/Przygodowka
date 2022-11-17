package com.example.przygodwka

import kotlinx.android.synthetic.main.activity_strona_gry.*

class Fabula  (val gs: StronaGry) {

    var nastepnyPunkt1 = "";
    var nastepnyPunkt2 = "";
    var nastepnyPunkt3 = "";

    fun wyborPunktu(punkt: String){

        when(punkt){
            "punktStartowy" -> punktStartowy()
            "miecz" -> miecz()
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

        nastepnyPunkt1 = "potwor"
        nastepnyPunkt2 = "pulapka"
        nastepnyPunkt3 = "punktStartowy"



    }


}