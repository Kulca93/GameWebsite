package controllers

import javax.inject.Inject

import models.Game

import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.mvc._

import scala.concurrent.ExecutionContext.Implicits.global

class Application @Inject()(val messagesApi: MessagesApi) extends Controller with I18nSupport {

  def index = Action {
    Ok(views.html.index("Play"))
  }

  def playstationStore = Action {
    Ok(views.html.playstationStore("Play", Game.games.filter(_.console.equals("playstation")), Game.createGameForm))
  }

  def xboxStore = Action {
    Ok(views.html.xboxStore("Play", Game.games.filter(_.console.equals("xbox")), Game.createGameForm))
  }

  def nintendoStore = Action {
    Ok(views.html.nintendoStore("Play", Game.games.filter(_.console.equals("nintendo")), Game.createGameForm))
  }
  def product = Action {
    Ok(views.html.product("Play", Game.games.filter(_.console.equals("nintendo")), Game.createGameForm))
  }

  def login = Action {
    Ok(views.html.login("Play"))
  }

  def listGames = Action { implicit request =>
    Ok(views.html.listGames(Game.games, Game.createGameForm))
  }

  def createGames = Action { implicit request =>
    Game.createGameForm.bindFromRequest.fold({ formWithErrors =>
      BadRequest(views.html.listGames(Game.games, formWithErrors))
    }, { game =>
      Game.games.append(game)
      Redirect(routes.Application.listGames)
    })
  }

}

