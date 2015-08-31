import groovy.json.JsonSlurper

public static String request() {
  def data = "authentication.userId=8a8294174b7ecb28014b9699220015cc" +
    "&authentication.password=sy6KJsT8" +
    "&authentication.entityId=8a8294174b7ecb28014b9699220015ca"
  def url = ("https://test.oppwa.com/v1/payments/8a82944a4cc25ebf014cc2c782423202?" + data).toURL()
  def connection = url.openConnection()
  connection.setRequestMethod("GET")
  def json = new JsonSlurper().parseText(connection.inputStream.text)
  json
}
println request()
