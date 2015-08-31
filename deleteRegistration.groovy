import groovy.json.JsonSlurper

public static String request() {
  def data = "authentication.userId=8a8294174b7ecb28014b9699220015cc" +
    "&authentication.password=sy6KJsT8" +
    "&authentication.entityId=8a8294174b7ecb28014b9699220015ca"
  def url = ("https://test.oppwa.com/v1/registrations/8a8294494f72e836014f83c4719b031b?" + data).toURL()
  def connection = url.openConnection()
  connection.setRequestMethod("DELETE")
  def json = new JsonSlurper().parseText(connection.inputStream.text)
  json
}
println request()
