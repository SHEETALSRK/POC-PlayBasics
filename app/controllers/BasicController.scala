package controllers

import data.request.BasicRequest
import data.response.BasicResponse
import play.api.libs.json.Json
import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents, Request}
import service.BasicService

import javax.inject.{Inject, Singleton}

@Singleton
class BasicController @Inject() (val controllerComponents : ControllerComponents) extends BaseController {

  def firstGetAPI : Action[AnyContent] = Action { implicit request : Request[AnyContent] =>
    implicit val response = Json.format[BasicResponse]
    Ok(Json.toJson(BasicService.getBasicData))
  }

  def firstPostAPI : Action[AnyContent] = Action { implicit request : Request[AnyContent] =>
    implicit val implicitResponse = Json.format[BasicResponse]
    implicit val implicitRequest = Json.format[BasicRequest]
    val jsonRequest = request.body.asJson.get
    val requestObject = jsonRequest.as[BasicRequest]
    Ok(Json.toJson(BasicService.postBasicData(requestObject)))
  }
}
