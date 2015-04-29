import groovy.json.JsonSlurper

public static String deleteRegistration() {
  def url = ("https://test.oppwa.com/v1/registrations/8a82944a4cfff62d014d04bf46113327" +
		"?authentication.userId=8a8294174b7ecb28014b9699220015cc" +
        "&authentication.password=sy6KJsT8" +
        "&authentication.entityId=8a8294174b7ecb28014b9699a3cf15d1").toURL()
  def connection = url.openConnection()

  connection.setRequestMethod("DELETE")
  def json = new JsonSlurper().parseText(connection.inputStream.text)
  json
}
println deleteRegistration()