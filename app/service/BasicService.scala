package service

import data.request.BasicRequest
import data.response.BasicResponse

object BasicService {

  def getBasicData = {
    BasicResponse("Sheetal", "This is first get API", 25)
  }

  def postBasicData(request : BasicRequest) = {
    BasicResponse(s"${request.name} is responding", "This is first POST API", 25)
  }
}
