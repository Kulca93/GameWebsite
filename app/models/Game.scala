package models

import play.api.data.Form
import play.api.data.Forms._
import scala.collection.mutable.ArrayBuffer

case class Game(name: String, price: Int, description: String, img: String, console: String)

object Game {

  val createGameForm = Form(
    mapping(
      "name" -> nonEmptyText,
      "price" -> number,
      "description" -> nonEmptyText,
      "img" -> nonEmptyText,
      "console" -> nonEmptyText

    )(Game.apply)(Game.unapply)
  )

  val games = ArrayBuffer(
    Game("Monster Hunter", 49, "It's a good game, bro", "/xbox/monsterHunterBig.jpg", "xbox"),
    Game("Dragonball FighterZ", 39, "Dragon, Dragon Rock THE DRAGONN!!!!!!!!!!!!!", "/playstation/dragonballBig.jpg", "playstation"),
    Game("Sea Of Theives", 38, "Be a theif on the seas!", "/xbox/seaOfTheivesScreen.jpg", "xbox"),
    Game("Super Mario Odyssey", 34, "Itsaaa me Mariooo", "/switch/marioBig.jpg", "nintendo"),
    Game("Crash N'Sane Trilogy", 29, "Ooga-booga!", "/playstation/crashScreen.jpg", "playstation"),
    Game("UFC 3", 49, "Don't be scared homie!", "/xbox/ufc3Big.jpg", "xbox"),
    Game("Zelda: Breath of the Wild", 39, "Play as Zelda and save the princess!", "/switch/zeldaBig.jpg", "nintendo"),
    Game("Arms", 29, "Stretchy Arms FTW", "/switch/armsBig.jpg", "nintendo")
  )
}

